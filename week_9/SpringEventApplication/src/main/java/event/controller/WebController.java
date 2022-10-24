package event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import event.beans.Concert;
import event.repository.EventRepository;


@Controller
public class WebController {
	@Autowired
	EventRepository repo;

	/**
	 * Displays the Results page if concerts exists in the database otherwise displays Input page
	 * @param model
	 * @return Results page
	 */
	@GetMapping({ "/", "viewAll" })
	public String viewAllConcerts(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewConcert(model);
		}
		model.addAttribute("concert", repo.findAll());
		return "results";
	}

	/**
	 * Displays the Input page
	 * @param model
	 * @return Input page
	 */
	@GetMapping("/inputConcert")
	public String addNewConcert(Model model) {
		Concert concert = new Concert();
		model.addAttribute("newConcert", concert);
		return "input";
	}

	/**
	 * Saves the new concert and redirect to the view all contacts
	 * @param concert
	 * @param model
	 * @return viewAllConcerts(model)
	 */
	@PostMapping("/inputConcert")
	public String addNewConcert(@ModelAttribute Concert concert, Model model) {
		repo.save(concert);
		return viewAllConcerts(model);
	}

	/**
	 * Displays Input page for the concert matching the id
	 * @param id
	 * @param model
	 * @return Input page
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateConcert(@PathVariable("id") long id, Model model) {
		Concert concert = repo.findById(id).orElse(null);
		model.addAttribute("newConcert", concert);
		return "input";
	}

	/**
	 * Updates the concert based on user input
	 * @param concert
	 * @param model
	 * @return viewAllConcerts(model)
	 */
	@PostMapping("/update/{id}")
	public String reviseConcert(Concert concert, Model model) {
		repo.save(concert);
		return viewAllConcerts(model);
	}
	
	/**
	 * Deletes selected concert from database matching using id
	 * @param id
	 * @param model
	 * @return viewAllConcerts(model)
	 */
	@GetMapping("/delete/{id}")
	public String deleteConcert(@PathVariable("id") long id, Model model) {
		Concert concert = repo.findById(id).orElse(null);
		repo.delete(concert);
		return viewAllConcerts(model);

	}

}
