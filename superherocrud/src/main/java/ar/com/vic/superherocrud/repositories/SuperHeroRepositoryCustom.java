package ar.com.vic.superherocrud.repositories;

import ar.com.vic.superherocrud.model.SuperHero;

public interface SuperHeroRepositoryCustom {
	
	Iterable<SuperHero> getSuperHeroByName(String name);
	
	Iterable<SuperHero> getSuperHeroByEmail(String name);

}
