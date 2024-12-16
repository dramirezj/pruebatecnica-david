package com.darj.demo.controller.tickets.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.darj.demo.controller.users.dto.UserDto;
import com.darj.demo.persistence.entities.tickets.TicketStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import com.darj.demo.util.DateUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class TicketDto implements Serializable {

	private Long id;
	@JsonProperty(value = "usuario")
	private UserDto user;
	@JsonProperty(value = "estado")	
	private TicketStatus status;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha creacion")
	private LocalDate createAt;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha actualizacion")
	private LocalDate updateAt;

	private static final long serialVersionUID = 3379778599820057521L;
}
