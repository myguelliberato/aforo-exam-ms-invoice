package com.aforo255.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.exam.domain.Invoice;
import com.aforo255.exam.service.InvoiceService;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@RestController
@Slf4j
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/v1/load")
	public List<Invoice> load() {
		log.info("::load::");
		return invoiceService.load();
	}

}
