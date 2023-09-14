package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Status;
import com.gms.entity.Ticket;

/**
 * This is @TicketRepository to perform operation on ticket table in database.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    /**
     * This method is to get list of @TicketTableOutDTO by departmentId for member dashboard.
     * @param departmentId
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where d.departmentId = ?1")
    List<TicketTableOutDTO> findAllByDepartment(final Long departmentId);

    /**
     * This method is to get list of @TicketTableOutDTO for admin dashboard.
     * @return List<TicketTableOutDTO>
     */
    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u")
    List<TicketTableOutDTO> findAllTicket();

    /**
     * This method is use for finding details of ticket by ticketId.
     * @param id
     * @return TicketInfoOutDTO
     */
    @Query("select new com.gms.dto.TicketInfoOutDTO("
            + "t.ticketId, t.title, t.description, t.ticketType,"
            + "d.departmentName, u.name, t.creationTime,"
            + "t.lastUpdationTime, (select new com.gms.dto.CommentOutDTO(c.comment, u2.name , c.commentTime) from c),t.status)"
            + "from Ticket t JOIN t.department d JOIN t.user u  JOIN t.comments c JOIN c.user u2 where t.ticketId = ?1")
    TicketInfoOutDTO findTicketById(final Long id);
   
}
