package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {

}
