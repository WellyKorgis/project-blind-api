package com.blind.account.api;

import com.blind.account.domain.Account;
import com.blind.account.persistence.repository.AccountRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/api/v1/accounts")
public class AccountController {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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
}
