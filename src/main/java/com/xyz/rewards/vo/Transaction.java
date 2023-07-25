package com.xyz.rewards.vo;

import java.time.LocalDate;

public class Transaction {
    private Long id;
    private Customer customer;
    private Double total;
    private LocalDate date;
    protected Long points;

    public Transaction() {
        super();
    }

    public Transaction(long id, Customer customer, double total, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate saveDate) {
        this.date = date;
    }
    public Long getPoints() {
        this.points = 0l;
        if (this.total > 50 && this.total <= 100) {
            this.points += (this.total.intValue() - 50) * 1;

        }
        if (this.total > 100) {
            this.points += 50;
            this.points += (this.total.intValue() - 100) * 2;
        }
        return this.points;
    }
}
