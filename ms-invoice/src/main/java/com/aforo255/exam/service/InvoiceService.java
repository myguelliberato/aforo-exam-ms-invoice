package com.aforo255.exam.service;

import java.util.List;

import com.aforo255.exam.domain.Invoice;

public interface InvoiceService {

	List<Invoice> load();

	void save(Invoice account);

	Invoice findById(Integer invoiceId);

}
