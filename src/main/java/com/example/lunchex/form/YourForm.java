package com.example.lunchex.form;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class YourForm {
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private String storeName;
}
