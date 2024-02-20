package com.backend.bookStore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.backend.bookStore.model.Admin;
import com.backend.bookStore.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByMobileNumber(String username);

	Optional<User> findByMobileNumberAndActive(String username, byte b);

}
