package ar.com.vic.superherocrud.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vic.superherocrud.model.SuperHero;
import ar.com.vic.superherocrud.service.SuperHeroService;


@RestController
@RequestMapping("/superheros")
public class SuperHeroRestController {
	@Autowired
	private SuperHeroService superHeroService;

	@GetMapping(value = "/", produces = "application/json")
	public @ResponseBody List<SuperHero> getAllSuperHeros() {
		return superHeroService.getAllSuperHeros();
	}
	
	@GetMapping(value = "/{id}")
	public @ResponseBody Optional<SuperHero> getSuperHeroById(@PathVariable("id") Long id) {
		return superHeroService.getSuperHeroById(id);
	}

	@GetMapping(value = "/getSuperHeroByName/{name}")
	public @ResponseBody Iterable<SuperHero> getSuperHeroByName(@PathVariable("name") String name) {
		return superHeroService.getSuperHeroByName(name);
	}
	
	@GetMapping(value = "/email/{email}")
	public @ResponseBody Iterable<SuperHero> getSuperHeroByEmail(@RequestParam("email") String email) {
		return superHeroService.getSuperHeroByEmail(email);
	}

	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody SuperHero addSuperHero(@RequestBody SuperHero superHero) {
		return superHeroService.addSuperHero(superHero);
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public @ResponseBody String delSuperHero(@PathVariable("id") Long id) {
		return superHeroService.delSuperHero(id);
	}
	
	@PutMapping(path = "/", produces = "application/json")
	public @ResponseBody SuperHero updSuperHero(@RequestBody SuperHero superHero) {
		return superHeroService.updSuperHero(superHero);
	}
}
