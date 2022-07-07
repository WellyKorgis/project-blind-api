package com.blind.account.api;

import com.blind.account.domain.Account;
import com.blind.account.persistence.repository.AccountRepository;
import com.blind.post.domain.Post;
import com.blind.post.persistence.repository.PostRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    ResponseEntity<String> listAllAccounts() {

        List<Account> accountList = accountRepository.findAll();
        if (accountList == null) {
            return new ResponseEntity<>("No accounts exist to show", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accountList.toString(), HttpStatus.ACCEPTED);
        }
    }
}
