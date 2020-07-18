package ar.com.gnchiesa.api.controller;

import ar.com.gnchiesa.model.Account;
import ar.com.gnchiesa.model.AccountMovement;
import ar.com.gnchiesa.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;

    @ApiOperation(notes = "Get account", value = "Get account by id")
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public Account getById(@PathVariable("accountId") Integer accountId, HttpServletRequest request) throws Exception {
        return accountService.getAccountById(accountId);
    }

    @ApiOperation(notes = "Create account", value = "Create an account")
    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public Account create(@RequestBody Account account, HttpServletRequest request) throws Exception {
        return accountService.create(account);
    }

    @ApiOperation(notes = "Make a Debit Op", value = "Make a debit operation")
    @RequestMapping(value = "/account/{accountId}/debit", method = RequestMethod.POST)
    public Account debit(@PathVariable("accountId") Integer accountId, @RequestBody AccountMovement accountMovement, HttpServletRequest request) throws Exception {
        return accountService.debit(accountService.getAccountById(accountId), accountMovement.getAmount());
    }

    @ApiOperation(notes = "Make a Debit Op", value = "Make a debit operation")
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public Account credit(@PathVariable("accountId") Integer accountId, @RequestBody AccountMovement accountMovement, HttpServletRequest request) throws Exception {
        return accountService.credit(accountService.getAccountById(accountId), accountMovement.getAmount());
    }

}
