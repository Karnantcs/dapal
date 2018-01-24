package com.hms.inventory;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	Random e = new Random();
	
	@RequestMapping("/list")
	public String getInventoryList() {
		
		return "inventories";
	}
	
	@RequestMapping("/count")
	public int getInventoryCount() {
		
		return e.nextInt();
	}
	
}
