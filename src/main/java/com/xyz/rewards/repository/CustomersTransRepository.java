package com.xyz.rewards.repository;

import com.xyz.rewards.vo.Customer;
import com.xyz.rewards.vo.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomersTransRepository {

    private static List<Transaction> transactions = new ArrayList<Transaction>();
    private static Map<Customer, List<Transaction>> custTransactions = null;

    private static long index;

    static {

        transactions.add(new Transaction(index++, new Customer(1, "Sathish"), 100.0, LocalDate.now()));
        transactions.add(new Transaction(index++, new Customer(2, "Swathy"), 150.0, LocalDate.now()));
        transactions.add(new Transaction(index++, new Customer(3, "Riyaan"), 80.0, LocalDate.now()));

    }

    public List<Transaction> getAll() {
        return transactions;
    }

    public Map<Customer, List<Transaction>> getCustTransactions() {
        return custTransactions =
                this.transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomer));
    }
}
