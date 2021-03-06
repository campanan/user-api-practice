package br.com.training.controller;

import javax.validation.Valid;

import br.com.training.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody @Valid User user) {
		return userService.saveAll(user);
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public User getUser (@PathVariable String cpf){ return userService.verifyAndGetIfExists(cpf);    }

	@PutMapping(value="/{cpf}")
    public User updateUser(@PathVariable String cpf, User userNovo){ return userService.updateUserByCpf(cpf,userNovo);}

	@DeleteMapping(value="/{cpf}")
    public void delUser (@PathVariable String cpf){  userService.deleteUserByCpf(cpf);}




}
