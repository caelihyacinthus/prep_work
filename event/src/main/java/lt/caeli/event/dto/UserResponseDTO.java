package lt.caeli.event.dto;

import java.util.List;

import lt.caeli.event.model.Role;


public record UserResponseDTO(
	    long id,
	    String username,
	    List<Role> roles
) {}
