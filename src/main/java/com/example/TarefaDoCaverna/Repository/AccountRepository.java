package com.example.TarefaDoCaverna.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TarefaDoCaverna.Models.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	public Optional<Account> findByCpf(String cpf);
}
