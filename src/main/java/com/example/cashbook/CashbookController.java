package com.example.cashbook;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CashbookController {
	@Autowired
	private RecordRepository recordRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Record> records = recordRepository.findAll();
		model.addAttribute("records", records);
		return "recordlist";
	}

	@GetMapping("new_record")
	public String newRecord() {
		return "newrecord";
	}

	@PostMapping("new_record")
	public String newRecord(
			@RequestParam("date") 
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam("subject") String subject,
			@RequestParam("amount") int amount,
			Model model) {
		Record record = new Record(date, subject, amount);
		recordRepository.saveAndFlush(record);
		return "redirect:/";
	}
}
