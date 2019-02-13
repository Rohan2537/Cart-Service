package com.capgemini.eshoppingZone.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eshoppingZone.ewallet.pojo.Statement;

@Repository
public interface StatementsRepository extends JpaRepository<Statement, Integer> {

}
