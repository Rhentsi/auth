package com.authentificationService.authentificationService.Repository;

import com.authentificationService.authentificationService.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,String> {
}
