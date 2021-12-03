package ar.com.vic.superherocrud.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.vic.superherocrud.model.SuperHero;



public class SuperHeroRepositoryCustomImpl implements SuperHeroRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Iterable<SuperHero> getSuperHeroByName(String name) {
		
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	     CriteriaQuery<SuperHero> query = cb.createQuery(SuperHero.class);
	        Root<SuperHero> root = query.from(SuperHero.class);
	 
	        List<Predicate> predicates = new ArrayList<>();
	        predicates.add(cb.and(cb.like(root.get("name"), "%"+name+"%")));
	        query.select(root)
	            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
	        
	        return entityManager.createQuery(query).getResultList();

	}
	
	@Override
	public Iterable<SuperHero> getSuperHeroByEmail(String email) {
		
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	     CriteriaQuery<SuperHero> query = cb.createQuery(SuperHero.class);
	        Root<SuperHero> root = query.from(SuperHero.class);
	 
	        List<Predicate> predicates = new ArrayList<>();
	        predicates.add(cb.and(cb.like(root.get("email"), "%"+email+"%")));
	        query.select(root)
	            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
	        
	        return entityManager.createQuery(query).getResultList();

	}

}
