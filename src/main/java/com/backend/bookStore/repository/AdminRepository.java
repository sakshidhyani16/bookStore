package com.backend.bookStore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.backend.bookStore.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	Admin findByEmail(String username);

	Optional<Admin> findByEmailAndActive(String username, byte b);


}
