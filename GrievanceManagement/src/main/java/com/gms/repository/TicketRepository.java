package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u where d.departmentId = ?1")
    List<TicketTableOutDTO> findAllByDepartment(long departmentId);

    @Query("select new com.gms.dto." + "TicketTableOutDTO("
            + "t.title, d.departmentName , t.status, u.name, t.lastUpdationTime)"
            + "from Ticket t JOIN t.department d JOIN t.user u")
    List<TicketTableOutDTO> findAllTicket();

    @Query("select new com.gms.dto.TicketInfoOutDTO("
            + "t.ticketId, t.title, t.description, t.ticketType,"
            + "d.departmentName, u.name, t.creationTime,"
            + "t.lastUpdationTime, t.status)"
            + "from Ticket t JOIN t.department d JOIN t.user u where t.ticketId = ?1")
    TicketInfoOutDTO findTicketById(long id);

}
