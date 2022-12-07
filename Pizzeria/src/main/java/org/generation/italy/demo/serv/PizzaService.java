package org.generation.italy.demo.serv;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public void save(Pizza pizza) {
		pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}
	
	public Optional<Pizza> findPizzaById(int id) {
		return pizzaRepo.findById(id);
	}
	
	public void delete (Pizza pizza) {
		pizzaRepo.delete(pizza);
	}
	
	public void deleteById(int id) {
		pizzaRepo.deleteById(id);
	}
	
	public List<Pizza> findByNome(String nome){
		return pizzaRepo.findByNomeContainingIgnoreCase(nome);
	}
}
