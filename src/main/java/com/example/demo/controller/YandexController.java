package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Yandex;
import com.example.demo.repo.YandexRepo;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@ResponseBody()
public class YandexController {
	@Autowired
	YandexRepo repo;
	
	@PostMapping(value="/adddata",produces ="application/json",consumes ="multipart/form-data" )
	public Yandex adddata(Yandex data) {
		repo.save(data);
		return data;
	}
	
	@GetMapping("/getdata")
	public List<Yandex> getdata(){
		return repo.findAll();
	}
	
	
	@GetMapping("/search/{text}")
	public List<Yandex> search(@PathVariable("text") String text){
		System.out.println(repo.findAnimeByTitle(text).toString());
		return repo.findAnimeByTitle(text);
	}
}
