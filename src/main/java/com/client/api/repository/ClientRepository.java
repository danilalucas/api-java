package com.client.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.api.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
