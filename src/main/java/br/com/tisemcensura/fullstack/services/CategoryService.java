package br.com.tisemcensura.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tisemcensura.fullstack.entities.Category;
import br.com.tisemcensura.fullstack.exceptions.ResourceNotFoundException;
import br.com.tisemcensura.fullstack.repositories.CategoryRepository;

@Service
public class CategoryService {
    
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	public Category save(Category category) {
		return repository.save(category);
	}
	
	public Category update(Category category, Long id) {
		category.setId(id);
		return repository.save(category);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
