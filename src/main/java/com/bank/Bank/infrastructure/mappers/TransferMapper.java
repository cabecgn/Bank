package com.bank.Bank.infrastructure.mappers;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bank.Bank.domain.models.Transfer;
import com.bank.Bank.infrastructure.entities.TransferEntity;

@Component()
public class TransferMapper {

	public TransferEntity toEntity(Transfer transfer) {
		if (Objects.isNull(transfer)) {
			return null;
		}

		return TransferEntity.builder().id(transfer.getId()).createdAt(transfer.getCreatedAt())
				.amount(transfer.getAmount()).accountNumberTo(transfer.getAccountNumberTo())
				.accountNumberFrom(transfer.getAccountNumberFrom()).build();

	}

	public Transfer toDomain(TransferEntity transferEntity) {
		if (Objects.isNull(transferEntity)) {
			return null;
		}

		return Transfer.builder().id(transferEntity.getId()).createdAt(transferEntity.getCreatedAt())
				.amount(transferEntity.getAmount()).accountNumberTo(transferEntity.getAccountNumberTo())
				.accountNumberFrom(transferEntity.getAccountNumberFrom()).build();

	}

}
