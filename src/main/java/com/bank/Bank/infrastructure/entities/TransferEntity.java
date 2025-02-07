package com.bank.Bank.infrastructure.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transfer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	UUID id;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;

	@PositiveOrZero
	private BigDecimal amount;

	@NotNull
	private UUID accountNumberFrom;

	@NotNull
	private UUID accountNumberTo;

}
