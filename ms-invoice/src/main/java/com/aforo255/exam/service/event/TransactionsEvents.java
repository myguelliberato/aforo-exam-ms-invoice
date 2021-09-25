package com.aforo255.exam.service.event;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.exam.domain.Invoice;
import com.aforo255.exam.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionsEvents {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ObjectMapper objectMapper;

	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info(":::::processTransactionEvent:::::");
		try {
			Invoice account = new Invoice();
			Invoice event = objectMapper.readValue(consumerRecord.value(), Invoice.class);
			account = invoiceService.findById(event.getInvoiceId());
			account.setAmount(event.getAmount());
			account.setState(2);
			invoiceService.save(account);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}