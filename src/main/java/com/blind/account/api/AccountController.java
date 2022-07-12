package com.blind.account.api;

import com.blind.account.domain.Account;
import com.blind.account.persistence.repository.AccountRepository;
import com.blind.post.domain.Post;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;
import java.util.Optional;

import static java.awt.SystemColor.info;

@Slf4j
@RestController("/api/v1/accounts")
public class AccountController {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),

            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping()
    Account addAccount(@Valid @RequestBody Account accountToAdd) {
        return accountRepository.save(accountToAdd);
    }


  @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "NO_CONTENT"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping()
    ResponseEntity<String> getAccountById(@PathVariable Integer id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            return new ResponseEntity<>(foundAccount.toString(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("No accounts with the id '"+ id +"' has been found."
                    , HttpStatus.NO_CONTENT);
        }
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "NO_CONTENT"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping()
    ResponseEntity<String> getAccountByEmail(@PathVariable String email) {
        Optional<Account> foundAccount = accountRepository.findByEmail(email);
        if (foundAccount.isPresent()) {
            return new ResponseEntity<>(foundAccount.toString(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("No accounts with the email '"+ email +"' has been found."
                    , HttpStatus.NO_CONTENT);
        }
    }
    
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "NO_CONTENT"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping()
    ResponseEntity<String> getAccountByUsername(@PathVariable String username) {
        Optional<Account> foundAccount = accountRepository.findByUsername(username);
        if (foundAccount.isPresent()) {
            return new ResponseEntity<>(foundAccount.toString(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("No accounts with the username '"+ username +"' has been found.", HttpStatus.NO_CONTENT);
        }
    }
            
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "NO_CONTENT"),
        @ApiResponse(code = 404, message = "NOT_FOUND"),
        @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })        
    ResponseEntity<String> listAllAccounts() {

        List<Account> accountList = accountRepository.findAll();
        if (accountList == null) {
            return new ResponseEntity<>("No accounts exist to show", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accountList.toString(), HttpStatus.ACCEPTED);

        }
    }
}
