package com.example.TarefaDoCaverna.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TarefaDoCaverna.Exception.CaralhoException;
import com.example.TarefaDoCaverna.Models.Account;
import com.example.TarefaDoCaverna.Models.Points;
import com.example.TarefaDoCaverna.Repository.AccountRepository;



@Service
public class AccountService {
	
	private static final Logger log = LoggerFactory.getILoggerFactory().getLogger(AccountService.class.getName());
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account searchByCpf(String cpf){
		Optional<Account> accountCpf = accountRepository.findByCpf(cpf);
		
		if (accountCpf.isPresent()) {
			return accountCpf.get();
		} else {
			return null;
		}
	}
	
	public List<Account> listCpf(){
		return accountRepository.findAll();
	}
	
	public void cadastrar(Account account){
		accountRepository.save(account);
	}
	
    public void updateUser(String cpf, Account newAccountInfo) {
        Account savedAccount = accountRepository.findByCpf(cpf).get();
        BeanUtils.copyProperties(newAccountInfo, savedAccount, "cpf", "id"); 	
                  	        	
        if (savedAccount != null) {
			log.warn("updateUser(Account newAccountInfo) - warning - Account already exists with cpf: {}", newAccountInfo.getCpf());
			throw new CaralhoException("Account already exists");
		}else {
			accountRepository.save(savedAccount); 
		} 
    }		
    
    public void deleteById(Long id) {
		accountRepository.deleteById(id);
    }
    
    public void deleteall() {
    	accountRepository.deleteAll();
    }
    
    public Points searchPointsByCpf(String cpf){
    	Account newAccount = searchByCpf(cpf);
    	Points points = new Points(newAccount.getPoints());
    	return points;
    }   
  }
