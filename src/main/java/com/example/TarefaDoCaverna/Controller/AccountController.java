package com.example.TarefaDoCaverna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TarefaDoCaverna.Models.Account;
import com.example.TarefaDoCaverna.Models.Points;
import com.example.TarefaDoCaverna.Services.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	private AccountService services;
	
	
	@GetMapping("/acc/{cpf}")
	public ResponseEntity<Points> searchPointsByCpf(@PathVariable ("cpf") String cpf){
		Points account = services.searchPointsByCpf(cpf);
		return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();		
	}
	
	@GetMapping("/acc")
	public ResponseEntity<List<Account>> listCpf(){
		List<Account> listAccount = services.listCpf();
		return ResponseEntity.ok(listAccount);
	}
	
	@PostMapping("/acc")
	public ResponseEntity<String> cadastrar(@RequestBody Account account){
		services.cadastrar(account);
		return ResponseEntity.status(HttpStatus.CREATED).body("criado");
	}
	
	@PutMapping("/acc/{cpf}")
	public ResponseEntity<String> updateUser(@RequestBody Account account, @PathVariable("cpf") String cpf){
		services.updateUser(cpf, account);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("atualizado");	
	}
	@DeleteMapping("acc/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		services.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("deletado");
	}
	@DeleteMapping("acc")
	public ResponseEntity<?> deleteAll(){
		services.deleteall();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("deletado");
	}
	
}