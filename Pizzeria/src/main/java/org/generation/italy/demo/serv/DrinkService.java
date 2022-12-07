package org.generation.italy.demo.serv;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
	@Autowired
	private DrinkRepo drinkRepo;
	
	public void save(Drink drink) {
		drinkRepo.save(drink);
	}
	
	public List<Drink> findAll() {
		return drinkRepo.findAll();
	}
	
	public Optional<Drink> findDrinkById(int id) {
		return drinkRepo.findById(id);
	}
	
	public void delete (Drink drink) {
		drinkRepo.delete(drink);
	}
	
	public void deleteById(int id) {
		drinkRepo.deleteById(id);
	}
	
	public List<Drink> findByNome(String nome){
		return drinkRepo.findByNomeContainingIgnoreCase(nome);
	}
}
