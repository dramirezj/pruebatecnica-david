package com.darj.demo.services.impl;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darj.demo.configuration.cache.CacheConstants;
import com.darj.demo.controller.tickets.dto.TicketDto;
import com.darj.demo.persistence.entities.tickets.TicketEntity;
import com.darj.demo.persistence.repositories.tickets.TicketRepository;
import com.darj.demo.services.ITicketMapper;
import com.darj.demo.services.ITicketService;
import com.darj.demo.util.Pager;
import com.darj.demo.util.messages.MessagesEnum;
import com.darj.demo.util.messages.MessagesUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService {

	private final TicketRepository ticketRepository;
	private final ITicketMapper mapper = Mappers.getMapper(ITicketMapper.class);

	@Transactional(readOnly = true)
	@Override
	@CachePut(value = CacheConstants.TICKETS_CACHE)
	public Pager<TicketEntity> all(Integer pageNumber, Integer pageSize) {
		var response = ticketRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("id").descending()));
		return new Pager<>(response.getContent(), response.getTotalElements());
	}
	
	@Transactional(readOnly = true)
	@Override
	@CachePut(value = CacheConstants.TICKETS_CACHE)
	public Pager<TicketEntity> findByFilter(Long id, Integer pageNumber, Integer pageSize) {
		var response = ticketRepository.findByFilter(PageRequest.of(pageNumber, pageSize, Sort.by("id").descending()), id);
		return new Pager<>(response.getContent(), response.getTotalElements());
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.TICKETS_CACHE, allEntries = true)
	})
	public TicketDto save(TicketDto ticketDto) {
		TicketEntity ticketEntity = mapper.dtoToEntity(ticketDto);
		TicketEntity entity = ticketRepository.save(ticketEntity);
		return mapper.entityToDto(entity);
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.TICKETS_CACHE, allEntries = true)
	})
	public TicketDto update(TicketDto ticketDto) {
		Optional<TicketEntity> optTicketEntity = ticketRepository.findById(ticketDto.getId());
		if(optTicketEntity.isEmpty()) {
			throw MessagesUtil.buildException(MessagesEnum.RECORD_NOT_FOUND);
		}
		TicketEntity ticketEntity = mapper.dtoToEntity(ticketDto);
		TicketEntity entity = ticketRepository.save(ticketEntity);
		return mapper.entityToDto(entity);
	}
	
	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.TICKETS_CACHE, allEntries = true)
	})
	public TicketDto delete(Long id) {
		Optional<TicketEntity> optTicketEntity = ticketRepository.delete(id);
		if(optTicketEntity.isEmpty()) {
			throw MessagesUtil.buildException(MessagesEnum.RECORD_NOT_FOUND);
		}
		ticketRepository.delete(optTicketEntity.get());
		return mapper.entityToDto(optTicketEntity.get());
	}
}
