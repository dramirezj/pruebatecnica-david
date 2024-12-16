package com.darj.demo.persistence.repositories.tickets;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darj.demo.persistence.entities.tickets.TicketEntity;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

	@EntityGraph(attributePaths = { "user" })
	Page<TicketEntity> findAll(Pageable pageable);
	
	@Query(name = "findByFilter", value = "SELECT t FROM TicketEntity t WHERE t.id = :id")
	Page<TicketEntity> findByFilter(Pageable pageable, @Param("id") Long id);
	
	@Query(name = "findByFilter", value = "SELECT t FROM TicketEntity t WHERE t.id = :id")
	Optional<TicketEntity> delete(Long id);
	
}
