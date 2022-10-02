package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String ListCustomer(Model model) {
		
		// Get Customers from Service
		List<Customer> customerList = customerService.getCustomers();
	
		//add customers to model
		model.addAttribute("customers",customerList);
		
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomerMethod(@ModelAttribute("customer") Customer customer ) {
		customerService.saveCustomer(customer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId") int id, Model model) {
		
		//get customer from DB
		Customer customer = customerService.getCustomer(id);
		
		//add customer to model
		model.addAttribute("customer", customer);
		
		return "customer-form";
		
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@ModelAttribute("customerId") int id, Model model) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	

}
