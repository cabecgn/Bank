package com.bank.Bank.application.repository.springdatajpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.Bank.infrastructure.entities.CompanyEntity;

@Repository
public interface CompanySpringRepository extends JpaRepository<CompanyEntity, UUID> {

	@Query(nativeQuery = true, value = "select c.id, c.cuit, c.company_name, c.date_accession from company c inner join transfer f on c.id = f.account_number_from where created_at between :start and :end")
	public List<CompanyEntity> findCompaniesWithTransfersBetweenDates(@Param("start") LocalDateTime start,
			@Param("end") LocalDateTime end);

	@Query(nativeQuery = true, value = "select * from company where date_accession between :start and :end")
	public List<CompanyEntity> findCompaniesThatAccessionBetweenDates(@Param("start") LocalDate start,
			@Param("end") LocalDate end);
	
	public CompanyEntity findByCuit(String cuit);
}
