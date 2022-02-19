package com.sip.springdata1.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.springdata1.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider,Long> {

	
}
