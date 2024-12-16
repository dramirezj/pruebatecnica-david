package com.darj.demo.persistence.entities.users;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 60)
	private String name;

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
