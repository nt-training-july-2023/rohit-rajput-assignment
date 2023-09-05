package com.gms.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.TicketSaveInDTO;
import com.gms.entity.Department;
import com.gms.entity.Ticket;
import com.gms.entity.User;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.UserNotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.TicketRepository;
import com.gms.repository.UserRepository;
import com.gms.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    
    @Override
    public Ticket saveTicket(TicketSaveInDTO ticketSaveInDTO) {
        Optional<User> userOptional = userRepository.findById(ticketSaveInDTO.getUserId());
        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("User Id not exists"); 
        }
        Optional<Department> departmentOptional = departmentRepository.findById(ticketSaveInDTO.getDepartmentId());
        if(!departmentOptional.isPresent()) {
            throw new DepartmentsNotFoundException("Department Id not exists"); 
        }
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketSaveInDTO.getTitle());
        ticket.setDescription(ticketSaveInDTO.getDescription());
        ticket.setTicketType(ticketSaveInDTO.getTicketType());
        ticket.setDepartment(departmentOptional.get());
        ticket.setUser(userOptional.get());
        return ticketRepository.save(ticket);
    }

}
