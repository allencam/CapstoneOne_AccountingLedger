package com.ps.data;

import com.ps.models.Search;
import com.ps.models.Transaction;

import java.util.List;

public interface TransactionDaoInt {
    List<Transaction> getAll();
    Transaction getById(int id);
    Transaction create (Transaction transaction);
    void delete(int id); // Deletes a task by id
    List<Transaction> customSearch (Search search);
}