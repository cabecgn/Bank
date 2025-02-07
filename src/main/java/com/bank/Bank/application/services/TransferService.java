package com.bank.Bank.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.Bank.application.repository.TransferRepository;
import com.bank.Bank.domain.models.Transfer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferService {

	private TransferRepository transferRepository;

	public List<Transfer> getAll() {
		return transferRepository.findAll();
	}

}
