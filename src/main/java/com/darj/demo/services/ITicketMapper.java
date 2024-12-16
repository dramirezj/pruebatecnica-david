package com.darj.demo.services;

import java.util.List;

import org.mapstruct.Mapper;

import com.darj.demo.controller.tickets.dto.TicketDto;
import com.darj.demo.persistence.entities.tickets.TicketEntity;

@Mapper
public interface ITicketMapper {

	TicketDto entityToDto(TicketEntity ticketEntity);

	List<TicketDto> entityToDto(List<TicketEntity> ticketEntities);

	TicketEntity dtoToEntity(TicketDto tickeDto);

}
