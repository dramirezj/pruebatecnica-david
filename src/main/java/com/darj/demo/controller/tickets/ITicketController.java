package com.darj.demo.controller.tickets;

import org.springframework.http.ResponseEntity;

import com.darj.demo.configuration.http.HttpResponseMessage;
import com.darj.demo.controller.tickets.dto.TicketDto;
import com.darj.demo.util.Pager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ITicketController {

	@Operation(summary = TicketConstants.TICKETS_SUMMARY, description = TicketConstants.TICKETS_GET_DESCRIPTION, tags = TicketConstants.TICKETS_TAG)
	@ApiResponses(value = {
			@ApiResponse(responseCode = TicketConstants.RESPONSE_200, description = TicketConstants.TICKETS_SUMMARY),
			@ApiResponse(responseCode = TicketConstants.RESPONSE_500, description = TicketConstants.INTERNAL_SERVER_ERROR) })
	ResponseEntity<HttpResponseMessage<Pager<TicketDto>>> all(Integer pageNumber, Integer pageSize);

	@Operation(summary = TicketConstants.TICKETS_SUMMARY, description = TicketConstants.TICKETS_GET_DESCRIPTION, tags = TicketConstants.TICKETS_TAG)
	@ApiResponses(value = {
			@ApiResponse(responseCode = TicketConstants.RESPONSE_200, description = TicketConstants.TICKETS_SUMMARY),
			@ApiResponse(responseCode = TicketConstants.RESPONSE_500, description = TicketConstants.INTERNAL_SERVER_ERROR) })
	ResponseEntity<HttpResponseMessage<Pager<TicketDto>>> findByFilter(Long id, Integer pageNumber, Integer pageSize);

	@Operation(summary = TicketConstants.TICKETS_SUMMARY, description = TicketConstants.TICKETS_POST_DESCRIPTION, tags = TicketConstants.TICKETS_TAG)
	@ApiResponses(value = {
			@ApiResponse(responseCode = TicketConstants.RESPONSE_200, description = TicketConstants.TICKETS_SUMMARY),
			@ApiResponse(responseCode = TicketConstants.RESPONSE_500, description = TicketConstants.INTERNAL_SERVER_ERROR) })
	ResponseEntity<HttpResponseMessage<TicketDto>> save(@RequestBody TicketDto ticketDto);

	@Operation(summary = TicketConstants.TICKETS_SUMMARY, description = TicketConstants.TICKETS_PUT_DESCRIPTION, tags = TicketConstants.TICKETS_TAG)
	@ApiResponses(value = {
			@ApiResponse(responseCode = TicketConstants.RESPONSE_200, description = TicketConstants.TICKETS_SUMMARY),
			@ApiResponse(responseCode = TicketConstants.RESPONSE_500, description = TicketConstants.INTERNAL_SERVER_ERROR) })
	ResponseEntity<HttpResponseMessage<TicketDto>> update(@RequestBody TicketDto ticketDto);

}
