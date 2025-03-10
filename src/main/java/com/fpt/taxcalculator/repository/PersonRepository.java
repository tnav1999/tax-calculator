package com.fpt.taxcalculator.repository;

import com.fpt.taxcalculator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findAllByOrderByIncome();

	@Query("SELECT per FROM Person per WHERE per.lastName = :lastName")
	Person findPersonByLastname(@Param("lastName") String lastName);
}
