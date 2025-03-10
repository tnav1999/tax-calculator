package com.fpt.taxcalculator.repository;

import com.fpt.taxcalculator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	@Query(value = "SELECT pe FROM Person pe WHERE pe.id = :id")
	Person getPersonById(@Param("id") Long id);

	List<Person> findAllByOrderByIncome();
}
