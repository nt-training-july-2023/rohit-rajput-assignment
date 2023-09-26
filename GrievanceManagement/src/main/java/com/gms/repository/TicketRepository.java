package com.gms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Status;
import com.gms.entity.Ticket;

import net.bytebuddy.asm.Advice.This;

/**
 * This is @TicketRepository to perform operation on ticket table in database.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    /**
     * This method is to get list of @TicketTableOutDTO by departmentId for member dashboard.
     * @param departmentId
     * @param pageable
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where d.departmentId = ?1")
    List<TicketTableOutDTO> findAllByDepartment(Long departmentId, Pageable pageable);

    /**
     * This method is to get list of @TicketTableOutDTO for admin dashboard.
     * @param pageable
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u")
    List<TicketTableOutDTO> findAllTicket(Pageable pageable);

    /**
     * This method returns List<TicketTableOutDTO> sorted by status.
     * @param pageable
     * @param filterStatus
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where t.status = ?1")
    List<TicketTableOutDTO> findAllTicketByStatus(Pageable pageable, Status filterStatus);

    /**
     * This method returns List<TicketTableOutDTO> assigned to a department sorted by status.
     * @param departmentId
     * @param filterStatus
     * @param pageable
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where d.departmentId = ?1 AND t.status = ?2")
    List<TicketTableOutDTO> findAllByDepartmentAndStatus(Long departmentId, Status filterStatus, Pageable pageable);

    /**
     * This method returns List<TicketTableOutDTO> raised by a user.
     * @param userId
     * @param pageable
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where u.id = ?1")
    List<TicketTableOutDTO> findAllTicketByUser(Long userId, Pageable pageable);

    /**
     * This method returns List<TicketTableOutDTO> raised by a user and sorted by status.
     * @param userId
     * @param filterStatus
     * @param pageable
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.ticketId, t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where u.id = ?1 AND t.status = ?2")
    List<TicketTableOutDTO> findAllTicketByUserAndStatus(Long userId, Status filterStatus, Pageable pageable);
   
}
