package com.ahamdah.s2.service;

import com.ahamdah.s2.exception.NotFoundException;
import com.ahamdah.s2.model.Transaction;
import com.ahamdah.s2.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getAll(){
        List<Transaction> list=new ArrayList<>();
        var x=transactionRepository.findAll();
        x.forEach(list::add);
        return list;
    }

    public Transaction getTransaction(String id) throws NotFoundException {
        var x=transactionRepository.findById(id).orElseThrow(()-> new NotFoundException("colud not find with that id "));
        return x;
    }
    public Transaction deleteTransaction(String id) throws NotFoundException{
        var x=transactionRepository.findById(id).orElseThrow(()-> new NotFoundException("colud not find Transaction with that id "));
        transactionRepository.deleteById(id);
        return x;
    }
    public void deleteAll(){
        transactionRepository.deleteAll();
    }
    public void create(Transaction transaction){
        transactionRepository.save(transaction);
    }
    public int getTransactionNumber(){
        List<Transaction> list=new ArrayList<>();
        var x=transactionRepository.findAll();
        x.forEach(list::add);
        return list.size();
    }
    public void update(String id,Transaction transaction)throws NotFoundException{
        var transaction1=transactionRepository.findById(id).orElseThrow(()-> new NotFoundException("colud not find Transaction with that id "));
        transaction1.setSender_id(transaction.getSender_id());
        transaction1.setReceiver_id(transaction.getReceiver_id());
        transaction1.setAmount(transaction.getAmount());
        transaction1.setStatus(transaction.getStatus());
        transactionRepository.save(transaction1);
    }
}
