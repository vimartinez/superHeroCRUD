package ar.com.vic.superherocrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vic.superherocrud.model.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long>, SuperHeroRepositoryCustom {

}
