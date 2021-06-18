package br.com.tisemcensura.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tisemcensura.fullstack.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
