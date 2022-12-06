package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.DrinkService;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private DrinkService drinkService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// INSERIMENTO PIZZE

		Pizza p1 = new Pizza("Margherita", "Mozzarella, olio e pomodoro", 4);
		Pizza p2 = new Pizza("Marinara", "Pomodoro, aglio, origano", 3);
		Pizza p3 = new Pizza("Diavola", "Mozzarella, pomodoro e salame piccante", 5);
		Pizza p4 = new Pizza("Pizza fritta", "Ripieno fritto con mozzarella e pomodoro", 7);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		
		// INSERIMENTO DRINK

		Drink d1 = new Drink("Coca Cola", "Bevanda gassata analcolica", 3);
		Drink d2 = new Drink("Vino", "Rosso o bianco della casa", 6);
		Drink d3 = new Drink("Sprite", "Bevanda gassata analcolica", 3);
		Drink d4 = new Drink("Birra", "Birra chiara artigianale", 7);

		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);


		// LETTURA

		List<Pizza> pizzas = pizzaService.findAll();
		System.out.println(pizzas);
		
		List<Drink> drinks = drinkService.findAll();
		System.out.println(drinks);
	}
}
