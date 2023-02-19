package com.example.cashbook;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="records")
public class Record {
	@Getter
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	private LocalDateTime date;
	
	@Getter @Setter
	private String subject;
	
	@Getter @Setter
	private int amount;
	
	public Record() {
		
	}
	public Record(LocalDateTime date, String subject, int amount) {
		this.date = date;
		this.subject = subject;
		this.amount = amount;
	}
}
