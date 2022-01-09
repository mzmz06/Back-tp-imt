package fr.alpha.alphaspring;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionnaryService implements Dictionnaryitf {
//Map<Integer,Person> hm;
	@Autowired
	PersonRepository pr;
	public DictionnaryService() {
		//super();
		//hm = new HashMap<Integer,Person>();
		//hm.put(1, new Person(1,"Who", "Doctor", "0606060606", "Lille"));
		//hm.put(2, new Person(2,"Bond", "James", "0606060606", "Londres"));
		//hm.put(3, new Person(3,"Alpha", "Emmanuel", "0606060606", "Paris"));
	}

	@Override
	public Collection<Person> getAll() {
		//return (Collection<Person>) (hm.values());
		return pr.findAll();
	}

	@Override
	public Person getFromId(int id) {
		//return hm.get(id);
		return pr.findById(id);
	}

	@Override
	public boolean deleteFromId(int id) {
		//if(hm.remove(id) != null) return true;
		//return false;
		Person p = pr.findById(id);
		if (p != null )  {pr.delete(p); return true;}
		return false;
	}

	@Override
	public void addPerson(Person p) {
		//hm.put(p.getId(), p);
		pr.save(p);
	}
	
	@Override
	public List<Person> getFromName(String name) {
		//return hm.values().stream().filter( e -> e.getName().equals(name)).collect(Collectors.toList());
		return pr.findByName(name);
	}
}
