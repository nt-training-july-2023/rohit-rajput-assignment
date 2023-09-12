package com.gms.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Department;
import com.gms.entity.Status;
import com.gms.entity.Ticket;
import com.gms.entity.User;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.TicketNotFoundException;
import com.gms.exception.UserNotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.TicketRepository;
import com.gms.repository.UserRepository;
import com.gms.service.TicketService;

/**
 * this is @TicketServiceImpl class for implementin business logic for ticket
 * table data.
 */
@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger LOGGER = LogManager.getLogger(TicketServiceImpl.class);
    /**
     * this is DepartmentRepository refernce.
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
     * this is @saveTicket method for saving a ticket.
     */
    @Override
    public Ticket saveTicket(final TicketSaveInDTO ticketSaveInDTO) {
        Optional<User> userOptional = userRepository.findById(ticketSaveInDTO.getUserId());
        if (!userOptional.isPresent()) {
            LOGGER.warn("[TicketServiceImpl]: User Id not exists");
            throw new UserNotFoundException("User Id not exists");
        }
        Optional<Department> departmentOptional = departmentRepository.findById(ticketSaveInDTO.getDepartmentId());
        if (!departmentOptional.isPresent()) {
            LOGGER.warn("[TicketServiceImpl]: Department Id not exists");
            throw new DepartmentsNotFoundException("Department Id not exists");
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

    @Override
    public List<TicketTableOutDTO> getAllTicket() {
        List<TicketTableOutDTO> ticketTableOutDTOs = ticketRepository.findAllTicket();
        if (ticketTableOutDTOs.size() == 0) {
            LOGGER.warn("[TicketServiceImpl]: Empty list of ticket");
            throw new TicketNotFoundException("There is no ticket");
        }
        LOGGER.info("[TicketServiceImpl]: Sorting list of ticket basis of status");
        List<TicketTableOutDTO> sortedOnStatus = ticketTableOutDTOs.stream().sorted((ticket1, ticket2) -> {
            if (ticket1.getStatus().equals(ticket2.getStatus())) {
                return ticket2.getLastUpdationTime().compareTo(ticket1.getLastUpdationTime());
            } else if (ticket1.getStatus().equals(Status.OPEN)) {
                return -1;
            } else if (ticket1.getStatus().equals(Status.BEING_ADDRESSED)) {
                return ticket2.getStatus().equals(Status.OPEN) ? 1 : -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
        return sortedOnStatus;
    }

    @Override
    public List<TicketTableOutDTO> getAllTicketByDepartment(String departmentName) {
        if (!departmentRepository.existsByDepartmentName(departmentName)) {
            LOGGER.warn("[TicketServiceImpl]: Department Name not exists");
            throw new DepartmentsNotFoundException("DepartmentName Not Found");
        }
        Long departmentId = departmentRepository.findByDepartmentName(departmentName);
        List<TicketTableOutDTO> ticketTableOutDTOs = ticketRepository.findAllByDepartment(departmentId);
        if (ticketTableOutDTOs.isEmpty()) {
            LOGGER.warn("[TicketServiceImpl]: No ticket is assigned to this department");
            throw new TicketNotFoundException("Ticket is not assigned to your department");
        }
        LOGGER.info("[TicketServiceImpl]: Sorting list of ticket basis of status");
        List<TicketTableOutDTO> sortedOnStatus = ticketTableOutDTOs.stream().sorted((ticket1, ticket2) -> {
            if (ticket1.getStatus().equals(ticket2.getStatus())) {
                return ticket2.getLastUpdationTime().compareTo(ticket1.getLastUpdationTime());
            } else if (ticket1.getStatus().equals(Status.OPEN)) {
                return -1;
            } else if (ticket1.getStatus().equals(Status.BEING_ADDRESSED)) {
                return ticket2.getStatus().equals(Status.OPEN) ? 1 : -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
        return sortedOnStatus;
    }

    @Override
    public TicketInfoOutDTO getTicketById(long id) {
        if(!ticketRepository.existsById(id)) {
            throw new TicketNotFoundException("Ticket Id not exists");
        }
        TicketInfoOutDTO ticketInfoOutDTO = ticketRepository.findTicketById(id);
        return ticketInfoOutDTO;
    }
}
