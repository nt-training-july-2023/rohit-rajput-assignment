package com.gms.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gms.constants.MessageConstant;
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
            LOGGER.warn("[TicketServiceImpl]: User Id not exists");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        Optional<Department> departmentOptional = departmentRepository.findById(ticketSaveInDTO.getDepartmentId());
        if (!departmentOptional.isPresent()) {
            LOGGER.warn("[TicketServiceImpl]: Department Id not exists");
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
    public List<TicketTableOutDTO> getAllTicket(final Long userId, final Boolean myTicket,
            Integer pageNumber, Status filterStatus) {
        System.out.println(filterStatus);
        Pageable pageable = PageRequest.of(pageNumber, 10);
        List<TicketTableOutDTO> ticketTableOutDTOs;
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(MessageConstant.NOT_FOUND));
        if (myTicket && user.getTicket().size() == 0) {
            LOGGER.info("There is no ticket");
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        } else if (myTicket && filterStatus==null) {
            LOGGER.info("Tickets raised by user");
            ticketTableOutDTOs = user.getTicket().stream().map(ticket -> {
                TicketTableOutDTO outDTO = new TicketTableOutDTO();
                outDTO.setTicketId(ticket.getTicketId());
                outDTO.setTitle(ticket.getTitle());
                outDTO.setStatus(ticket.getStatus());
                outDTO.setLastUpdationTime(ticket.getLastUpdationTime());
                outDTO.setAssignedBy(ticket.getUser().getName());
                outDTO.setDepartmentName(ticket.getDepartment().getDepartmentName());
                return outDTO;
            }).sorted(comparator).collect(Collectors.toList());
            return ticketTableOutDTOs;
        }else if(myTicket && filterStatus!=null) {
            LOGGER.info("Tickets of user filtered by status");
            ticketTableOutDTOs = user.getTicket().stream()
                    .filter(ticket-> ticket.getStatus().equals(filterStatus))
                    .map(ticket -> {
                TicketTableOutDTO outDTO = new TicketTableOutDTO();
                outDTO.setTicketId(ticket.getTicketId());
                outDTO.setTitle(ticket.getTitle());
                outDTO.setStatus(ticket.getStatus());
                outDTO.setLastUpdationTime(ticket.getLastUpdationTime());
                outDTO.setAssignedBy(ticket.getUser().getName());
                outDTO.setDepartmentName(ticket.getDepartment().getDepartmentName());
                return outDTO;
            }).collect(Collectors.toList());
            return ticketTableOutDTOs;
        }        
        else if (user.getRole().equals(Role.ADMIN) && filterStatus==null) {
            LOGGER.info("All Tickets for ADMIN role without filter");
            ticketTableOutDTOs = ticketRepository.findAllTicket(pageable).stream().sorted(comparator)
                    .collect(Collectors.toList());
            return ticketTableOutDTOs;
        }else if (user.getRole().equals(Role.ADMIN) && filterStatus!=null) {
            LOGGER.info("All Tickets for ADMIN role with filter by status");
            ticketTableOutDTOs = ticketRepository.findAllTicketByStatus(pageable,filterStatus);
            return ticketTableOutDTOs;
        }
        else if(filterStatus==null){
            LOGGER.info("Tickets assigned to a department for Member role without filter");
            ticketTableOutDTOs = ticketRepository.findAllByDepartment(user.getDepartment().getDepartmentId(),pageable);
            if (ticketTableOutDTOs.size() == 0) {
                throw new NotFoundException("No ticket is assigned to your department");
            }
            return ticketTableOutDTOs.stream().sorted(comparator).collect(Collectors.toList());
        }else {
            LOGGER.info("Tickets assigned to a department for Member role without filter");
            ticketTableOutDTOs = ticketRepository.findAllByDepartmentAndStatus(user.getDepartment().getDepartmentId(), filterStatus, pageable);
            return ticketTableOutDTOs;
        }
    }

    /**
     * This is @getTicketById for getting a list by ticketId.
     */
    @Override
    public TicketInfoOutDTO getTicketById(final Long ticketId, final Long userId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if(!ticket.isPresent()) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        if(ticket.get().getUser().getId()!=userId && user.get().getRole()==Role.MEMBER) {
            throw new BadRequestException(MessageConstant.ACCESS_DENIED);
        }
        List<CommentOutDTO> commentOutDTOs = ticket.get().getComments().stream().map(comment->{
            CommentOutDTO commentOutDTO = new CommentOutDTO();
            commentOutDTO.setComment(comment.getComment());
            commentOutDTO.setUserName(comment.getUser().getName());
            return commentOutDTO;
        }).collect(Collectors.toList());       
        TicketInfoOutDTO ticketInfoOutDTO = new TicketInfoOutDTO();
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
        return ticketInfoOutDTO;
    }


    
    @Override
    public String updateTicket(final UpdateTicketInDTO updateTicketInDTO) {
      Ticket ticket = ticketRepository.findById(updateTicketInDTO.getTicketId())
              .orElseThrow(() -> new NotFoundException(MessageConstant.NOT_FOUND));
      User user = userRepository.findById(updateTicketInDTO.getUserId())
              .orElseThrow(() -> new NotFoundException(MessageConstant.NOT_FOUND));
      if (!ticket.getDepartment().equals(user.getDepartment())) {
          throw new BadRequestException(MessageConstant.ACCESS_DENIED);
      }
      if (ticket.getStatus().equals(Status.RESOLVED)) {
          throw new BadRequestException("Ticket is Resolved, You can't update");
      }
      if (updateTicketInDTO.getStatus().equals(Status.OPEN)) {
          throw new BadRequestException("Updated status value can't be OPEN");
      }
      if (updateTicketInDTO.getStatus().equals(Status.RESOLVED)
              && updateTicketInDTO.getComment()==null
              && ticket.getComments().size()==0) {
          throw new BadRequestException("Without a comment you can't RESOLVED ticket");
      }
      if (ticket.getStatus().equals(Status.OPEN) && updateTicketInDTO.getComment()==null) {
          throw new BadRequestException("Without comment Status value OPEN can't be change");
      }
      if(ticket.getStatus().equals(updateTicketInDTO.getStatus()) && updateTicketInDTO.getComment()==null) {
          throw new BadRequestException("There is no content to update");
      }
      if(updateTicketInDTO.getComment()!=null) {
          Comment comment = new Comment();
          comment.setComment(updateTicketInDTO.getComment());
          comment.setCommentTime(LocalDateTime.now().withNano(0));
          comment.setTicket(ticket);
          comment.setUser(user);
          commentRepository.save(comment);
      }
      if(!ticket.getStatus().equals(updateTicketInDTO.getStatus())) {
          ticket.setStatus(updateTicketInDTO.getStatus());
          ticketRepository.save(ticket);
      }
      return MessageConstant.UPDATED;
    }

    Comparator<TicketTableOutDTO> comparator = (TicketTableOutDTO ticketTableOutDTO1,
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
