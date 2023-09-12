package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Department;
import com.gms.entity.Status;
import com.gms.entity.Ticket;
import com.gms.entity.TicketType;
import com.gms.entity.User;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.TicketNotFoundException;
import com.gms.exception.UserNotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.TicketRepository;
import com.gms.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private DepartmentRepository departmentRepository;
    @InjectMocks
    private TicketServiceImpl ticketServiceImpl;
    @Test
    public void testSaveTicketIfUserNotFound() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        UserNotFoundException userNotFoundException = assertThrows(UserNotFoundException.class,
                ()->ticketServiceImpl.saveTicket(new TicketSaveInDTO()));
        assertEquals("User Id not exists", userNotFoundException.getMessage());
    }

    @Test
    public void testSaveTicketIfDepartmentNotFound() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(departmentRepository.findById(anyLong())).thenReturn(Optional.empty());
        DepartmentsNotFoundException departmentsNotFoundException = assertThrows(DepartmentsNotFoundException.class, () -> ticketServiceImpl.saveTicket(new TicketSaveInDTO()));
        assertEquals("Department Id not exists", departmentsNotFoundException.getMessage());
    }

    @Test
    public void testSaveTicketSuccefully() {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO();
        ticketSaveInDTO.setDepartmentId(1);
        ticketSaveInDTO.setUserId(1);
        ticketSaveInDTO.setTicketType(TicketType.Feedback);
        User user = new User();
        user.setId(ticketSaveInDTO.getUserId());
        Department department = new Department();
        department.setDepartmentId(ticketSaveInDTO.getDepartmentId());
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setTicketType(ticketSaveInDTO.getTicketType());
        ticket.setDepartment(department);
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        when(departmentRepository.findById(1l)).thenReturn(Optional.of(department));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
        Ticket ticket2 = ticketServiceImpl.saveTicket(ticketSaveInDTO);
        assertNotNull(ticket2);
        assertEquals(ticket.getTicketType(), ticket2.getTicketType());
        assertSame(ticket, ticket2);
        assertEquals(user, ticket2.getUser());
        assertEquals(department, ticket2.getDepartment());
    }
    
    @Test
    public void testGetAllTicketFailure() {
        List<TicketTableOutDTO> list = Arrays.asList();
        when(ticketRepository.findAllTicket()).thenReturn(list);
        TicketNotFoundException exception = assertThrows(TicketNotFoundException.class, ()->{
            ticketServiceImpl.getAllTicket();
        });
        assertEquals("There is no ticket", exception.getMessage());
    }
    
    @Test
    public void testGetAllTicketSuccess() {
        List<TicketTableOutDTO> list = Arrays.asList(new TicketTableOutDTO("qwerty", "HR", Status.OPEN, "Rohit Rajput", LocalDateTime.now()));
        when(ticketRepository.findAllTicket()).thenReturn(list);
        List<TicketTableOutDTO> tableOutDTOs = ticketServiceImpl.getAllTicket();
        assertEquals(list, tableOutDTOs);
    }
    
    
}
