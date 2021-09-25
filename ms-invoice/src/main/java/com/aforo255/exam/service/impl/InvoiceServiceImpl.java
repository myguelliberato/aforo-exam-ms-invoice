package com.aforo255.exam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aforo255.exam.domain.Invoice;
import com.aforo255.exam.repository.InvoiceRepository;
import com.aforo255.exam.service.InvoiceService;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public List<Invoice> load() {
		log.info("load");
		return (List<Invoice>) invoiceRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void save(Invoice t) {
		log.info("save::{}", new Gson().toJson(t));
		invoiceRepository.save(t);

	}

	@Override
	public Invoice findById(Integer invoiceId) {
		log.info("findById::{}", invoiceId);
		Optional<Invoice> optional = invoiceRepository.findById(invoiceId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
