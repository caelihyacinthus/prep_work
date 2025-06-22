package lt.caeli.event.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String role;
	
	public Role(){}

	public Role(String role){
		this.role = role;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}

}
