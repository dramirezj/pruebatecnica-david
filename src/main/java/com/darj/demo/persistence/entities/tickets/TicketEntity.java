package com.darj.demo.persistence.entities.tickets;

import java.time.LocalDate;

import com.darj.demo.persistence.entities.users.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TicketStatus status;

	@Column(name = "createAt")
	private LocalDate createAt;

	@Column(name = "updateAt")
	private LocalDate updateAt;

	@PrePersist
	private void createAt() {
		this.createAt = LocalDate.now();
	}

	@PreUpdate
	private void updateAt() {
		this.updateAt = LocalDate.now();
	}

}
