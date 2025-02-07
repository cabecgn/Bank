package com.bank.Bank.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transfer {

	private UUID id;
	private LocalDateTime createdAt;
	private BigDecimal amount;
	private UUID accountNumberFrom;
	private UUID accountNumberTo;

}
