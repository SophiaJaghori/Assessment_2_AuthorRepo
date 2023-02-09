package com.cogent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.entity.Author;
import com.cogent.entity.User;
import com.cogent.repository.AuthorRepository;
import com.cogent.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityProjectApplication {

	 @Autowired
	    private UserRepository repository;
	 @Autowired
	 	private AuthorRepository authorRepository;
	    @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(101, "Joe", "password", "joe@gmail.com"),
	                new User(102, "user1", "pwd1", "user1@gmail.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	        
	        List<Author> authors = Stream.of(
	        		new Author(1,"Joe","Woltman",1000),
	        		new Author(2,"Shorecrest","Wa",1000),
	        		new Author(3,"Marry","Sam",1000)
	        		).collect(Collectors.toList());
	        authorRepository.saveAll(authors);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}

}
