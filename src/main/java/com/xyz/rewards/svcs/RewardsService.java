package com.xyz.rewards.svcs;

import com.xyz.rewards.repository.CustomersTransRepository;
import com.xyz.rewards.vo.Customer;
import com.xyz.rewards.vo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "RewardsService")
public class RewardsService {

    @Autowired
    private CustomersTransRepository transactionsRepository;

    public List<Transaction> getAllTransactions() {
        return transactionsRepository.getAll();
    }

    public Set<Customer> getAllCustomers() {
        return transactionsRepository.getCustTransactions().keySet();
    }

    public Long getCustTotalRewards(Integer id) {
        Long custTotalRewards = transactionsRepository.getCustTransactions().get(new Customer(id)).
                stream().map(t -> t.getPoints()).reduce(0L, (a, b) -> a + b);
        return custTotalRewards;

    }

    public Map<java.time.Month, java.lang.Long> getCustMonthlyRewards(Integer id) {
        Map<Month, Long> custMonthlyRewards = transactionsRepository.getCustTransactions().get(new Customer(id))
                .stream()
                .collect(Collectors.groupingBy(t -> t.getDate().getMonth(),
                        Collectors.summingLong(t -> t.getPoints())));
        return custMonthlyRewards;
    }

    public Long getTotalRewards() {
        return transactionsRepository.getAll()
                .stream()
                .map(t -> t.getPoints()).reduce(0L, (a, b) -> a + b);
    }

}
