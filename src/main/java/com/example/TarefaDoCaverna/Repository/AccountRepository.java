package com.example.TarefaDoCaverna.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TarefaDoCaverna.Models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Optional<Account> findByCpf(String cpf);
}
