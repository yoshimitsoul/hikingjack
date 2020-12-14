package com.rando.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rando.modele.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value="select u from User u where u.nomUser = ?1")
	User checkUserExist(String utilisateur);
}
