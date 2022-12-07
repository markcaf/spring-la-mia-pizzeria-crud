package org.generation.italy.demo.repo;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
	
	List<Pizza> findByNomeContainingIgnoreCase(String nome);
}
