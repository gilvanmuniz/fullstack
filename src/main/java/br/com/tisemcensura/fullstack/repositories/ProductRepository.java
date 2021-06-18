package br.com.tisemcensura.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tisemcensura.fullstack.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
