package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	
	public Page<Sale> findSales(String _minDate, String _maxDate, Pageable _pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = _minDate.equals("") ? today.minusDays(365): LocalDate.parse(_minDate);
		LocalDate max = _maxDate.equals("") ? today: LocalDate.parse(_maxDate);
		
		return repository.findSales(min, max, _pageable);
	}
}