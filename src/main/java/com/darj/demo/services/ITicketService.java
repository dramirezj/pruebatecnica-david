package com.darj.demo.services;

import com.darj.demo.controller.tickets.dto.TicketDto;
import com.darj.demo.persistence.entities.tickets.TicketEntity;
import com.darj.demo.util.Pager;

public interface ITicketService {

	Pager<TicketEntity> all(Integer pageNumber, Integer pageSize);
	
	Pager<TicketEntity> findByFilter(Long id, Integer pageNumber, Integer pageSize);
	
	TicketDto save(TicketDto ticketDto);
	
	TicketDto update(TicketDto ticketDto);
	
}
