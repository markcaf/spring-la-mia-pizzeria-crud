package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.serv.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/drinks")
public class DrinkController {
	
	@Autowired
	private DrinkService drinkService;
	
	@GetMapping
	public String getDrinks(Model model) {
		List<Drink> drinks = drinkService.findAll();
		model.addAttribute("drinks", drinks);
		return "drinks";
	}
	
	@GetMapping("/drink/{id}")
	public String getDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		
		if (optDrink.isEmpty()) {
			System.err.println("Drink non disponibile con id: " + id);
		}
		
		Drink drink = optDrink.get();
		
		model.addAttribute("drink", drink);
		
		return "drink";
	}
	
	@GetMapping("/drink/create")
	public String createDrink(Model model) {
		Drink drink = new Drink();
		model.addAttribute("drink", drink);
		return "drink-create";
	}
	@PostMapping("/drink/create")
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/drinks/drink/create";
		}
		drinkService.save(drink);
		return "redirect:/drinks";
	}
	
	@GetMapping("/drink/update/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {

		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();

		model.addAttribute("drink", drink);

		return "drink-update";
	}
	
	@PostMapping("/drink/store")
	public String updateDrink(@Valid @ModelAttribute("drink") Drink drink,  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/drinks/drink/update/" + drink.getId();
		}

		drinkService.save(drink);		

		return "redirect:/drinks";
	}
	
	@GetMapping("/drink/delete/{id}")
	public String deleteDrink(@PathVariable("id") int id) {

		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();

		drinkService.delete(drink);

		return "redirect:/drinks";
	}
	
	@GetMapping("/search")
	public String getSearchDrinkByName(Model model, 
			@RequestParam(name = "q", required = false) String query) {

		List<Drink> drinks = query == null ? drinkService.findAll() : drinkService.findByNome(query); 

		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);

		return "drinks-search";
	}
	
}
