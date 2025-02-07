package com.bank.Bank.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.bank.Bank.application.repository.TransferRepository;
import com.bank.Bank.application.repository.springdatajpa.TransferSpringRepository;
import com.bank.Bank.domain.models.Transfer;
import com.bank.Bank.infrastructure.entities.TransferEntity;
import com.bank.Bank.infrastructure.mappers.TransferMapper;

public class TransferRepositoryImpl implements TransferRepository {

	private TransferSpringRepository repository;
	private TransferMapper mapper;

	@Override
	public Transfer saveTransfer(Transfer transfer) {
		TransferEntity transferEntity = repository.save(mapper.toEntity(transfer));
		return mapper.toDomain(transferEntity);
	}

	@Override
	public Optional<Transfer> findById(UUID id) {

		Optional<TransferEntity> transferEntity = repository.findById(id);
		if (transferEntity.isEmpty()) {
			return Optional.empty();
		}
		return transferEntity.map(mapper::toDomain);

	}

	@Override
	public List<Transfer> findAll() {

		return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
	}

}
