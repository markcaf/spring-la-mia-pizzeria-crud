package org.generation.italy.demo.repo;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Integer> {

	List<Drink> findByNomeContainingIgnoreCase(String nome);
}
