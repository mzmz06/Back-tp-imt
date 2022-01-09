package fr.alpha.alphaspring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DictionnaryController {

	@Autowired
	Dictionnaryitf ds;

	@GetMapping("/annuaire/recherche")
	public String recherche(Model model,
			@RequestParam(name = "name", required = false, defaultValue = "*") String name) {
		if (name.equals("*"))
			model.addAttribute("entries", ds.getAll());
		else
			model.addAttribute("entries", ds.getFromName(name));
		return "annuaire/recherche";
	}
	@GetMapping("/annuaire/supprimer/{id}")
	public String supprime(Model model, @PathVariable int id) {
		ds.deleteFromId(id);
		model.addAttribute("entries", ds.getAll());
		return "redirect:/annuaire/recherche";
		
	}
	@GetMapping("/annuaire/ajouter")
	public String ajouterEntree() {
		return "/annuaire/ajout";
	}
	@PostMapping("/annuaire/ajouter")
	public String add (@RequestParam String name, @RequestParam String surname, @RequestParam String phone, @RequestParam String city) {
		Person p = new Person(12, name, surname, phone, city);
		ds.addPerson(p);
		return "redirect:/annuaire/recherche";
	}
	@GetMapping("/annuaire/modifier/{id}")
	public String modifierEntree(Model model, @PathVariable int id) {
		model.addAttribute("entry", ds.getFromId(id));
		return "/annuaire/modif";
	}
	
	@PostMapping ("/annuaire/modifier/{id}")
	public String modifierEntree(@PathVariable int id, @RequestParam String name, @RequestParam String surname, @RequestParam String phone, @RequestParam String city) {
		Person p = new Person(id, name, surname, phone, city);
		ds.addPerson(p);
		return "redirect:/annuaire/recherche";
	}
}
