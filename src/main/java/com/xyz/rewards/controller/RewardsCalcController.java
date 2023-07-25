package com.xyz.rewards.controller;

import com.xyz.rewards.svcs.RewardsService;
import com.xyz.rewards.vo.Customer;
import com.xyz.rewards.vo.GenericResponseEntity;
import com.xyz.rewards.vo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class RewardsCalcController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping("/")
    public String hello() {
        return "Hello Rewards ...";
    }

    @GetMapping("/getAllTransactions")
    public ResponseEntity<GenericResponseEntity> getAllTransactions() {
        List<Transaction> response = null;
        response = rewardsService.getAllTransactions();
        return new ResponseEntity<GenericResponseEntity>
                (new GenericResponseEntity(response), HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<GenericResponseEntity> getAllCustomers() {
        Set<Customer> response = null;
        response = rewardsService.getAllCustomers();
        return new ResponseEntity<GenericResponseEntity>
                (new GenericResponseEntity(response), HttpStatus.OK);
    }

    @GetMapping("/getCustTotalRewards/{id}")
    public ResponseEntity<GenericResponseEntity> getCustTotalRewards(@PathVariable Integer id) {
        Long totalRewards = rewardsService.getCustTotalRewards(id);
        return new ResponseEntity<GenericResponseEntity>
                (new GenericResponseEntity(totalRewards), HttpStatus.OK);
    }

    @GetMapping("/getCustMonthlyRewards/{id}")
    public ResponseEntity<GenericResponseEntity> getCustMonthlyRewards(@PathVariable Integer id) {
        Map<Month, Long> custMonthlyRewards = rewardsService.getCustMonthlyRewards(id);
        return new ResponseEntity<GenericResponseEntity>
                (new GenericResponseEntity(custMonthlyRewards), HttpStatus.OK);
    }

    @GetMapping("/getTotalRewards")
    public ResponseEntity<GenericResponseEntity> getTotalRewards() {
        Long allCustomersRewards = rewardsService.getTotalRewards();
        return new ResponseEntity<GenericResponseEntity>
                (new GenericResponseEntity(allCustomersRewards), HttpStatus.OK);
    }

}
