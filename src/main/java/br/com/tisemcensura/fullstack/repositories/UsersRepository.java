package br.com.tisemcensura.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tisemcensura.fullstack.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>  {

}
