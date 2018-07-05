package com.example.demo;
import dal.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class Class1 {
	//Test Method
	@RequestMapping("/get")
	public String getMethod() {
		return "Hi Chirag";
	}
	//Functionality Method 
	@RequestMapping("/update")
	public String updateID() {
		return "Updated :"+DalClass.interact();
	}
}
