package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.dto.UpdateTicketInDTO;
import com.gms.entity.Comment;
import com.gms.entity.Department;
import com.gms.entity.Role;
import com.gms.entity.Status;
import com.gms.entity.Ticket;
import com.gms.entity.TicketType;
import com.gms.entity.User;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.repository.CommentRepository;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.TicketRepository;
import com.gms.repository.UserRepository;

public class TicketServiceImplTest {
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private TicketServiceImpl ticketServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTicketIfUserNotFound() {
        when(userRepository.findById(1l)).thenReturn(Optional.empty());
        NotFoundException notFoundException = assertThrows(NotFoundException.class,
                ()->ticketServiceImpl.saveTicket(new TicketSaveInDTO()));
        assertEquals("User Id not exists", notFoundException.getMessage());
    }

    @Test
    public void testSaveTicketIfDepartmentNotFound() {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO();
        ticketSaveInDTO.setUserId(1l);
        ticketSaveInDTO.setDepartmentId(1l);
        User user = new User();
        user.setId(1l);
        when(userRepository.findById(ticketSaveInDTO.getUserId())).thenReturn(Optional.of(user));
        when(departmentRepository.findById(ticketSaveInDTO.getDepartmentId())).thenReturn(Optional.empty());
        NotFoundException notFoundException = assertThrows(NotFoundException.class,
                () -> ticketServiceImpl.saveTicket(ticketSaveInDTO));
        assertEquals("Department Id not exists", notFoundException.getMessage());
    }

    @Test
    public void testSaveTicketSuccefully() {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO();
        ticketSaveInDTO.setDepartmentId(1l);
        ticketSaveInDTO.setUserId(1l);
        ticketSaveInDTO.setTicketType(TicketType.FEEDBACK);
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
    public void testGetAllTicketIfUserNotFound() {
        when(userRepository.findById(1l)).thenThrow(new NotFoundException("User Not Found"));
        NotFoundException exception = assertThrows(NotFoundException.class, ()->{
            ticketServiceImpl.getAllTicket(1l, false);
        });
        assertEquals("User Not Found", exception.getMessage());
    }
    
    @Test
    public void testGetAllTicketIfUserFoundAndTicketSizeIsZero() {
        User user = new User();
        user.setId(1l);
        user.setTicket(Arrays.asList());
        when(userRepository.findById(1l)).thenThrow(new NotFoundException("There is no ticket"));
        NotFoundException exception = assertThrows(NotFoundException.class, ()->{
            ticketServiceImpl.getAllTicket(1l, true);
        });
        assertEquals("There is no ticket", exception.getMessage());
    }
    
    @Test
    public void testGetAllTicketIfMyTicketIsTrue() {
        Department department1 = new Department();
        department1.setDepartmentId(1l);
        department1.setDepartmentName("HR");
        
        Department department2 = new Department();
        department2.setDepartmentId(2l);
        department2.setDepartmentName("Finance");
        
        User user = new User();
        user.setId(1l);
        user.setName("Rohit");
        
        Ticket ticket1 = new Ticket();
        ticket1.setTitle("qwerty");
        ticket1.setStatus(Status.BEING_ADDRESSED);
        ticket1.setLastUpdationTime(LocalDateTime.now().withNano(0));
        ticket1.setUser(user);
        ticket1.setDepartment(department1);
        
        Ticket ticket2 = new Ticket();
        ticket2.setTitle("qwert");
        ticket2.setStatus(Status.BEING_ADDRESSED);
        ticket2.setLastUpdationTime(LocalDateTime.now().withNano(0));
        ticket2.setUser(user);
        ticket2.setDepartment(department2);
        
        user.setTicket(Arrays.asList(ticket1,ticket2));
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        List<TicketTableOutDTO> ticketTableOutDTOs = ticketServiceImpl.getAllTicket(1l, true);
        
        assertEquals(2, ticketTableOutDTOs.size());
        assertEquals("qwerty", ticketTableOutDTOs.get(0).getTitle());
        assertEquals("qwert", ticketTableOutDTOs.get(1).getTitle());
    }
    
    @Test
    public void testGetAllTicketIfMyTicketIsFalseAndRoleIsAdmin() {
       
        User user = new User();
        user.setId(1l);
        user.setName("Rohit");
        user.setRole(Role.ADMIN);
        
        TicketTableOutDTO ticket1 = new TicketTableOutDTO();
        ticket1.setTitle("qwerty");
        ticket1.setStatus(Status.BEING_ADDRESSED);
        ticket1.setLastUpdationTime(LocalDateTime.now().withNano(0));
       
        TicketTableOutDTO ticket2 = new TicketTableOutDTO();
        ticket2.setTitle("qwert");
        ticket2.setStatus(Status.BEING_ADDRESSED);
        ticket2.setLastUpdationTime(LocalDateTime.now().withNano(0));
      
        List<TicketTableOutDTO> list = Arrays.asList(ticket1,ticket2);
        
        when(ticketRepository.findAllTicket()).thenReturn(list);
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        
        List<TicketTableOutDTO> ticketTableOutDTOs = ticketServiceImpl.getAllTicket(1l, false);
        assertEquals(2, ticketTableOutDTOs.size());
        assertEquals("qwerty", ticketTableOutDTOs.get(0).getTitle());
        assertEquals("qwert", ticketTableOutDTOs.get(1).getTitle());
    }
    
    @Test
    public void testGetAllTicketIfMyTicketIsFalseAndRoleIsMemberAndListSizeIszero() {       
        User user = new User();
        user.setId(1l);
        user.setName("Rohit");
        user.setRole(Role.MEMBER);
        Department department =  new Department();
        department.setDepartmentId(1l);
        user.setDepartment(department);

        
        when(ticketRepository.findAllByDepartment(1l)).thenReturn(Arrays.asList());
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        
        NotFoundException exception = assertThrows(NotFoundException.class, ()->
            ticketServiceImpl.getAllTicket(1l, false)
            );
        assertEquals("No ticket is assigned to your department", exception.getMessage());
    }
    
    @Test
    public void testGetAllTicketIfMyTicketIsFalseAndRoleIsMember() {       
        User user = new User();
        user.setId(1l);
        user.setName("Rohit");
        user.setRole(Role.MEMBER);
        Department department =  new Department();
        department.setDepartmentId(1l);
        user.setDepartment(department);
        
        TicketTableOutDTO ticket1 = new TicketTableOutDTO();
        ticket1.setTitle("qwerty");
        ticket1.setStatus(Status.BEING_ADDRESSED);
        ticket1.setLastUpdationTime(LocalDateTime.now().withNano(0));
       
        TicketTableOutDTO ticket2 = new TicketTableOutDTO();
        ticket2.setTitle("qwert");
        ticket2.setStatus(Status.BEING_ADDRESSED);
        ticket2.setLastUpdationTime(LocalDateTime.now().withNano(0));
      
        List<TicketTableOutDTO> list = Arrays.asList(ticket1,ticket2);        
        when(ticketRepository.findAllByDepartment(1l)).thenReturn(list);
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        
        List<TicketTableOutDTO> ticketTableOutDTOs = ticketServiceImpl.getAllTicket(1l, false);
        assertEquals(2, ticketTableOutDTOs.size());
            
    }

    @Test
    public void testUpdateTicketTicketIdNotFound() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenThrow(new NotFoundException("ticketId not found"));
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
        assertEquals("ticketId not found", exception.getMessage());
    }

    @Test
    public void testUpdateTicketUserIdNotFound() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        
        when(ticketRepository.findById(updateTicketInDTO.getTicketId())).thenReturn(Optional.of(new Ticket()));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenThrow(new NotFoundException("userId not found"));
        
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
        assertEquals("userId not found", exception.getMessage());
    }

    @Test
    public void testUpdateTicketIfUserNotBelongToDepartment() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        Department department1 = new Department();
        department1.setDepartmentId(1l);
        Department department2 = new Department();
        department2.setDepartmentId(2l);
        Ticket ticket = new Ticket();
        ticket.setDepartment(department1);
        User user = new User();
        user.setDepartment(department2);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId())).thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId())).thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }

    @Test
    public void testUpdateTicketIfTicketResolvedEarlier() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.RESOLVED);
        ticket.setDepartment(department1);
        User user = new User();
        user.setDepartment(department1);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }
    
    @Test
    public void testUpdateTicketIfUpdatedStatusIsOpen() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        updateTicketInDTO.setStatus(Status.OPEN);
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.OPEN);
        ticket.setDepartment(department1);
        User user = new User();
        user.setDepartment(department1);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }
    
    @Test
    public void testUpdateTicketIfUpdatedStatusIsResolvedAndCommentNullAndCommentSizeIsZero() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        updateTicketInDTO.setStatus(Status.RESOLVED);
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.OPEN);
        ticket.setDepartment(department1);
        ticket.setComments(Arrays.asList());
        User user = new User();
        user.setDepartment(department1);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }
    
    @Test
    public void testUpdateTicketIfTicketStatusIsOpenAndCommentNull() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        updateTicketInDTO.setStatus(Status.RESOLVED);
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.OPEN);
        ticket.setDepartment(department1);
        ticket.setComments(Arrays.asList(new Comment()));
        User user = new User();
        user.setDepartment(department1);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }
    
    @Test
    public void testUpdateTicketIfNoContentToBeUpdated() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        updateTicketInDTO.setStatus(Status.BEING_ADDRESSED);
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.BEING_ADDRESSED);
        ticket.setDepartment(department1);
        ticket.setComments(Arrays.asList(new Comment()));
        User user = new User();
        user.setDepartment(department1);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> {
            ticketServiceImpl.updateTicket(updateTicketInDTO);
        });
    }
    
    @Test
    public void testUpdateTicketIfTicketUpdatedSuccessfully() {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO();
        updateTicketInDTO.setTicketId(1l);
        updateTicketInDTO.setUserId(1l);
        updateTicketInDTO.setStatus(Status.BEING_ADDRESSED);
        updateTicketInDTO.setComment("qwerty");
        Department department1 = new Department();
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.OPEN);
        ticket.setDepartment(department1);
        ticket.setComments(Arrays.asList(new Comment()));
        User user = new User();
        user.setDepartment(department1);
        Comment comment = new Comment();
        comment.setComment(updateTicketInDTO.getComment());
        comment.setCommentTime(LocalDateTime.now().withNano(0));
        comment.setTicket(ticket);
        comment.setUser(user);
        ticket.setStatus(updateTicketInDTO.getStatus());
        when(commentRepository.save(comment)).thenReturn(comment);
        when(ticketRepository.save(ticket)).thenReturn(ticket);
        when(ticketRepository.findById(updateTicketInDTO.getTicketId()))
                .thenReturn(Optional.of(ticket));
        when(userRepository.findById(updateTicketInDTO.getUserId()))
                .thenReturn(Optional.of(user));
        String message = ticketServiceImpl.updateTicket(updateTicketInDTO);
        assertEquals("Ticket updated Successfully", message);
       
    }
}
