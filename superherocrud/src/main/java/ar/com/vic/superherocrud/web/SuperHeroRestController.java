package ar.com.vic.superherocrud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vic.superherocrud.model.SuperHero;
import ar.com.vic.superherocrud.service.SuperHeroService;


@RestController
public class SuperHeroRestController {
	@Autowired
	private SuperHeroService superHeroService;

	@GetMapping(value = "/", produces = "application/json")
	public @ResponseBody List<SuperHero> getAllSuperHeros() {
		return superHeroService.getAllSuperHeros();
	}
}
