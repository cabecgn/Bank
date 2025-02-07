package com.bank.Bank.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bank.Bank.domain.models.Transfer;

public interface TransferRepository {

	Transfer saveTransfer(Transfer transfer);

	Optional<Transfer> findById(UUID id);

	List<Transfer> findAll();

}
