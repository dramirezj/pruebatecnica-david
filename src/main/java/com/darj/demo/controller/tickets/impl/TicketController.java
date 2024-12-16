package com.darj.demo.controller.tickets.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darj.demo.configuration.http.HttpResponseBuilder;
import com.darj.demo.configuration.http.HttpResponseMessage;
import com.darj.demo.configuration.http.RestConstants;
import com.darj.demo.controller.tickets.ITicketController;
import com.darj.demo.controller.tickets.TicketConstants;
import com.darj.demo.controller.tickets.dto.TicketDto;
import com.darj.demo.services.ITicketMapper;
import com.darj.demo.services.ITicketService;
import com.darj.demo.util.Pager;
import com.darj.demo.util.messages.MessageLevel;
import com.darj.demo.util.messages.MessagesEnum;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = RestConstants.TICKETS_RESOURCE)
@RequiredArgsConstructor
public class TicketController implements ITicketController {

	private final ITicketService ticketService;
	private final ITicketMapper ticketMapper = Mappers.getMapper(ITicketMapper.class);

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponseMessage<Pager<TicketDto>>> all(
			@RequestParam(name = RestConstants.PAGE_NUMBER_HEADER_NAME, defaultValue = RestConstants.PAGE_NUMBER) Integer pageNumber,
			@RequestParam(name = RestConstants.PAGE_SIZE_HEADER_NAME, defaultValue = RestConstants.PAGE_SIZE) Integer pageSize) {
		var content = ticketService.all(pageNumber, pageSize);
		var pager = new Pager<>(ticketMapper.entityToDto(content.getRecords()), content.getTotalSize());
		return HttpResponseBuilder.buildResponse(new HttpResponseMessage<>(MessagesEnum.SUCCESSFULLY_OPERATION.name(),
				MessagesEnum.SUCCESSFULLY_OPERATION.getMessage(), MessageLevel.INFO, pager), HttpStatus.OK);
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponseMessage<TicketDto>> save(@RequestBody TicketDto ticketDto) {
		var content = ticketService.save(ticketDto);
		return HttpResponseBuilder.buildResponse(new HttpResponseMessage<>(MessagesEnum.SUCCESSFULLY_OPERATION.name(),
				MessagesEnum.SUCCESSFULLY_OPERATION.getMessage(), MessageLevel.INFO, content), HttpStatus.OK);
	}
	
	@PutMapping(path = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponseMessage<TicketDto>> update(@RequestBody TicketDto ticketDto) {
		var content = ticketService.update(ticketDto);
		return HttpResponseBuilder.buildResponse(new HttpResponseMessage<>(MessagesEnum.SUCCESSFULLY_OPERATION.name(),
				MessagesEnum.SUCCESSFULLY_OPERATION.getMessage(), MessageLevel.INFO, content), HttpStatus.OK);
	}

	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<HttpResponseMessage<Pager<TicketDto>>> findByFilter(
			@RequestHeader(name = "id", required = true) Long id,
			@RequestParam(name = RestConstants.PAGE_NUMBER_HEADER_NAME, required = false, defaultValue = TicketConstants.PAGE_NUMBER) Integer pageNumber,
			@RequestParam(name = RestConstants.PAGE_SIZE_HEADER_NAME, required = false, defaultValue = TicketConstants.PAGE_SIZE) Integer pageSize) {
		var content = ticketService.findByFilter(id, pageNumber, pageSize);
		var pager = new Pager<>(ticketMapper.entityToDto(content.getRecords()), content.getTotalSize());
		return HttpResponseBuilder.buildResponse(new HttpResponseMessage<>(MessagesEnum.SUCCESSFULLY_OPERATION.name(),
				MessagesEnum.SUCCESSFULLY_OPERATION.getMessage(), MessageLevel.INFO, pager), HttpStatus.OK);
	}

}
