package lt.caeli.event.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import lt.caeli.event.dto.UserMapper;
import lt.caeli.event.dto.UserRequestDTO;
import lt.caeli.event.dto.UserResponseDTO;
import lt.caeli.event.model.User;
import lt.caeli.event.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        if (userService.isUsernameUnique(userRequestDTO.username())) {
            Map<String, String> badResponse = new HashMap<>();
            badResponse.put("username", "username already in use");
            return ResponseEntity.badRequest().body(badResponse);
        }

        User user = UserMapper.toUser(userRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserResponseDTO savedUser = UserMapper.toUserResponseDTO(userService.saveUser(user));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.id())
                    .toUri())
            .body(savedUser);
    }
}