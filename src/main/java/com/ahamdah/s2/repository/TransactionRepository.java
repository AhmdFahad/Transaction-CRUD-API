package com.ahamdah.s2.repository;

import com.ahamdah.s2.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TransactionRepository extends ElasticsearchRepository<Transaction,String> {
}

