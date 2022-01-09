package fr.alpha.alphaspring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PersonRepository  extends CrudRepository<Person, Integer> {
	List<Person> findByName(String  lastname);
	Person findById(int id);
	List<Person> findAll();

}
