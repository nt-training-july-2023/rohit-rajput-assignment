package com.gms.serviceImpl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gms.constants.MessageConstant;
import com.gms.constants.VariableConstant;
import com.gms.dto.CommentOutDTO;
import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.dto.UpdateTicketInDTO;
import com.gms.entity.Comment;
import com.gms.entity.Department;
import com.gms.entity.Role;
import com.gms.entity.Status;
import com.gms.entity.Ticket;
import com.gms.entity.User;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.repository.CommentRepository;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.TicketRepository;
import com.gms.repository.UserRepository;
import com.gms.service.TicketService;

/**
 * this is @TicketServiceImpl class for implementation business logic for ticket
 * table data.
 */
@Service
public class TicketServiceImpl implements TicketService {

    /**
     * This is @Logger object.
     */
    private static final Logger LOGGER = LogManager.getLogger(TicketServiceImpl.class);

    /**
     * this is DepartmentRepository reference.
     */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * this is UserRepository reference.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * this is TicketRepository reference.
     */
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * this is CommentRepository reference.
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * this is @saveTicket method for saving a ticket.
     */
    @Override
    public Ticket saveTicket(final TicketSaveInDTO ticketSaveInDTO) {
        Optional<User> userOptional = userRepository.findById(ticketSaveInDTO.getUserId());
        if (!userOptional.isPresent()) {
            LOGGER.error("[TicketServiceImpl]: User Id not exists");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        Optional<Department> departmentOptional = departmentRepository.findById(ticketSaveInDTO.getDepartmentId());
        if (!departmentOptional.isPresent()) {
            LOGGER.error("[TicketServiceImpl]: Department Id not exists");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        LOGGER.info("[TicketServiceImpl]: Ticket saved");
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketSaveInDTO.getTitle());
        ticket.setDescription(ticketSaveInDTO.getDescription());
        ticket.setTicketType(ticketSaveInDTO.getTicketType());
        ticket.setDepartment(departmentOptional.get());
        ticket.setUser(userOptional.get());
        return ticketRepository.save(ticket);
    }

    /**
     * This is @getAllTicket for getting list of @TicketTableOutDTO.
     */
    @Override
    public List<TicketTableOutDTO> getAllTicket(final Long userId, final Boolean myTicket, final Integer pageNumber,
           final Status filterStatus) {
        Pageable pageable = PageRequest.of(pageNumber, VariableConstant.LIMIT);
        List<TicketTableOutDTO> ticketTableOutDTOs;
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(MessageConstant.NOT_FOUND));
        if (myTicket && user.getTicket().isEmpty()) {
            LOGGER.info("[TicketServiceImpl]: There is no ticket");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        } else if (myTicket && Objects.isNull(filterStatus)) {
            LOGGER.info("[TicketServiceImpl]: Tickets raised by user");
            ticketTableOutDTOs = ticketRepository.findAllTicketByUser(userId, pageable).stream().sorted(comparator)
                    .collect(Collectors.toList());
            return ticketTableOutDTOs;
        } else if (myTicket && !Objects.isNull(filterStatus)) {
            LOGGER.info("[TicketServiceImpl]: Tickets of user filtered by status");
            ticketTableOutDTOs = ticketRepository.findAllTicketByUserAndStatus(userId, filterStatus, pageable).stream()
                    .sorted(comparator).collect(Collectors.toList());
            return ticketTableOutDTOs;
        } else if (user.getRole().equals(Role.ADMIN) && Objects.isNull(filterStatus)) {
            LOGGER.info("[TicketServiceImpl]: All Tickets for ADMIN role without filter");
            ticketTableOutDTOs = ticketRepository.findAllTicket(pageable).stream().sorted(comparator)
                    .collect(Collectors.toList());
            return ticketTableOutDTOs;
        } else if (user.getRole().equals(Role.ADMIN) && !Objects.isNull(filterStatus)) {
            LOGGER.info("[TicketServiceImpl]: All Tickets for ADMIN role with filter by status");
            ticketTableOutDTOs = ticketRepository.findAllTicketByStatus(pageable, filterStatus).stream().sorted(comparator)
                    .collect(Collectors.toList());
            return ticketTableOutDTOs;
        } else if (Objects.isNull(filterStatus)) {
            LOGGER.info("[TicketServiceImpl]: Tickets assigned to a department for Member role without filter");
            ticketTableOutDTOs = ticketRepository.findAllByDepartment(user.getDepartment().getDepartmentId(), pageable);
            if (ticketTableOutDTOs.isEmpty()) {
                LOGGER.info("[TicketServiceImpl]: No ticket is assigned to your department");
                throw new NotFoundException(MessageConstant.NOT_FOUND);
            }
            return ticketTableOutDTOs.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            LOGGER.info("[TicketServiceImpl]: Tickets assigned to a department for Member role without filter");
            ticketTableOutDTOs = ticketRepository.findAllByDepartmentAndStatus(user.getDepartment().getDepartmentId(),
                    filterStatus, pageable);
            return ticketTableOutDTOs;
        }
    }

    /**
     * This is @getTicketById for getting a list by ticketId.
     */
    @Override
    public TicketInfoOutDTO getTicketById(final Long ticketId, final Long userId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (!ticket.isPresent()) {
            LOGGER.error("[TicketServiceImpl]: Tickets id does not exists");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            LOGGER.error("[TicketServiceImpl]: user id does not exists");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        List<CommentOutDTO> commentOutDTOs = ticket.get().getComments().stream().map(comment -> {
            CommentOutDTO commentOutDTO = new CommentOutDTO();
            commentOutDTO.setComment(comment.getComment());
            commentOutDTO.setName(comment.getUser().getName());
            return commentOutDTO;
        }).collect(Collectors.toList());
        TicketInfoOutDTO ticketInfoOutDTO = new TicketInfoOutDTO();
        ticketInfoOutDTO.setUserId(ticket.get().getUser().getId());
        ticketInfoOutDTO.setTitle(ticket.get().getTitle());
        ticketInfoOutDTO.setTicketType(ticket.get().getTicketType());
        ticketInfoOutDTO.setTicketId(ticket.get().getTicketId());
        ticketInfoOutDTO.setStatus(ticket.get().getStatus());
        ticketInfoOutDTO.setDescription(ticket.get().getDescription());
        ticketInfoOutDTO.setCreationTime(ticket.get().getCreationTime());
        ticketInfoOutDTO.setLastUpdatedTime(ticket.get().getLastUpdationTime());
        ticketInfoOutDTO.setAssignedTo(ticket.get().getDepartment().getDepartmentName());
        ticketInfoOutDTO.setAssignedBy(ticket.get().getUser().getName());
        ticketInfoOutDTO.setComments(commentOutDTOs);
        LOGGER.info("[TicketServiceImpl]: Giving TicketInfoOutDTO response to ticketController");
        return ticketInfoOutDTO;
    }

    /**
     *This is @updateTicket method for updating a ticket.
     */
    @Override
    public String updateTicket(final UpdateTicketInDTO updateTicketInDTO) {
        Ticket ticket = ticketRepository.findById(updateTicketInDTO.getTicketId())
                .orElseThrow(() -> new NotFoundException(MessageConstant.NOT_FOUND));
        User user = userRepository.findById(updateTicketInDTO.getUserId())
                .orElseThrow(() -> new NotFoundException(MessageConstant.NOT_FOUND));
        if (!ticket.getDepartment().equals(user.getDepartment())) {
            LOGGER.error("[TicketServiceImpl]: you are not belonging to this department");
            throw new BadRequestException(MessageConstant.ACCESS_DENIED);
        }
        if (ticket.getStatus().equals(Status.RESOLVED)) {
            LOGGER.warn("[TicketServiceImpl]: Ticket is resolved , you can't update");
            throw new BadRequestException("Ticket is Resolved, You can't update");
        }
        if (updateTicketInDTO.getStatus().equals(Status.OPEN)) {
            LOGGER.warn("[TicketServiceImpl]: Ticket is open , you can't update");
            throw new BadRequestException("Updated status value can't be OPEN");
        }
        if (updateTicketInDTO.getStatus().equals(Status.RESOLVED) && Objects.isNull(updateTicketInDTO.getComment())
                && ticket.getComments().isEmpty()) {
            LOGGER.warn("[TicketServiceImpl]: Without a comment you can't RESOLVED ticket");
            throw new BadRequestException("Without a comment you can't RESOLVED ticket");
        }
        if (ticket.getStatus().equals(Status.OPEN) && Objects.isNull(updateTicketInDTO.getComment())) {
            LOGGER.warn("[TicketServiceImpl]: Without comment Status value OPEN can't be change");
            throw new BadRequestException("Without comment Status value OPEN can't be change");
        }
        if (ticket.getStatus().equals(updateTicketInDTO.getStatus()) && Objects.isNull(updateTicketInDTO.getComment())) {
            LOGGER.info("[TicketServiceImpl]: There is no content to update");
            throw new BadRequestException("There is no content to update");
        }
        if (!Objects.isNull(updateTicketInDTO.getComment()) && !updateTicketInDTO.getComment().trim().equals("")) {
            LOGGER.info("[TicketServiceImpl]: Adding a comment");
            Comment comment = new Comment();
            comment.setComment(updateTicketInDTO.getComment());
            comment.setCommentTime(LocalDateTime.now().withNano(0));
            comment.setTicket(ticket);
            comment.setUser(user);
            commentRepository.save(comment);
        }
        LOGGER.info("[TicketServiceImpl]: Setting last updated time of ticket");
        ticket.setLastUpdationTime(LocalDateTime.now().withNano(0));
        ticket.setStatus(updateTicketInDTO.getStatus());
        ticketRepository.save(ticket);

        return MessageConstant.UPDATED;
    }

    /**
     * This is implementation of @Comparator compare method.
     */
    private static Comparator<TicketTableOutDTO> comparator = (TicketTableOutDTO ticketTableOutDTO1,
            TicketTableOutDTO ticketTableOutDTO2) -> {
        if (ticketTableOutDTO1.getStatus().equals(ticketTableOutDTO2.getStatus())) {
            return ticketTableOutDTO2.getLastUpdationTime().compareTo(ticketTableOutDTO1.getLastUpdationTime());
        } else if (ticketTableOutDTO1.getStatus().equals(Status.OPEN)) {
            return -1;
        } else if (ticketTableOutDTO1.getStatus().equals(Status.BEING_ADDRESSED)) {
            return ticketTableOutDTO2.getStatus().equals(Status.OPEN) ? 1 : -1;
        } else {
            return 1;
        }
    };
}
