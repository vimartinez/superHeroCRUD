package ar.com.vic.superherocrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="SuperHeroes")
public class SuperHero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "El nombre no puede ser nulo")
	private String name;
	@Size(min = 1, max = 100000, message = "La fuerza debe estar entre 1 y 100.000")
	private Integer strength;
	@Size(min = 1, max = 5000, message = "La velocidad debe estar entre 1 y 5.000 km/h")
	private Integer speed;
	@Size(min = 1, max = 100000, message = "La salud debe estar entre 1 y 100.000")
	private Integer health;
	@Email(message = "La dirección de mail no es correcta")
    private String email;
	private boolean canFly;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCanFly() {
		return canFly;
	}
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	
}
