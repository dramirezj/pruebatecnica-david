package com.darj.demo.controller.users.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import com.darj.demo.util.DateUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class UserDto implements Serializable {

	private Long id;
	@JsonProperty(value = "usuario")
	private String name;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha creacion")
	private LocalDate createAt;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha actualizacion")
	private LocalDate updateAt;

	private static final long serialVersionUID = -1947875921708960264L;
}
