package com.ust.Security2x.repo;

import com.ust.Security2x.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
