package br.com.tisemcensura.fullstack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tisemcensura.fullstack.entities.Users;
import br.com.tisemcensura.fullstack.repositories.UsersRepository;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;
	
	@CrossOrigin
	@GetMapping
	public List<Users> findAll(){return repository.findAll();}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private String senhaComHash;
	
	@Bean
	public BCryptPasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
			
	@CrossOrigin
	public ResponseEntity<?> findById(@PathVariable long id){
		return repository.findById(id)
		       .map(record -> ResponseEntity.ok().body(record))
		       .orElse(ResponseEntity.notFound().build());
	} //findById end
	
	@CrossOrigin
	@PostMapping
	public Users create(@Validated @RequestBody Users user){
		this.senhaComHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(this.senhaComHash);
	   return repository.save(user);
	} //post end
	
	@CrossOrigin
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public Users update(@RequestBody Users user, @PathVariable long id) {
		user.setId(id);
		return repository.save(user);		
	} // put method end
	
	@CrossOrigin
	public ResponseEntity<?> delete(Long id) {
		repository.deleteById(id);
		return null;
	} //delete end
}
