package com.aforo255.exam.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aforo255.exam.domain.Invoice;
@Repository
public interface InvoiceRepository    extends CrudRepository<Invoice, Integer> , JpaSpecificationExecutor<Invoice> {

}
