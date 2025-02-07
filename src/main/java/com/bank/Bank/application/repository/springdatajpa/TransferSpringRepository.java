package com.bank.Bank.application.repository.springdatajpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Bank.infrastructure.entities.TransferEntity;

public interface TransferSpringRepository extends JpaRepository<TransferEntity, UUID> {

}
