package com.example.springbootclientpractise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShpoController {

	@Autowired
	private ShopRepo sh;
	@PostMapping("/shop")
	public ResponseEntity<Shop>savedata(@RequestBody Shop shop){
		return new ResponseEntity<Shop>(sh.save(shop),HttpStatus.CREATED);
	}
	@GetMapping("/shop")
	public ResponseEntity<List<Shop>>getdata(){
		return new ResponseEntity<>(sh.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/shop/{id}")
	public ResponseEntity<Shop>getall(@PathVariable int id,@RequestBody Shop shop){
		Optional<Shop>op=sh.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/shop/{id}")
	public ResponseEntity<Shop>update(@PathVariable int id,@RequestBody Shop shop){

		Optional<Shop>op=sh.findById(id);
		if(op.isPresent()) {
			op.get().setName(shop.getName());
			op.get().setAdress(shop.getAdress());
			return new ResponseEntity<>(sh.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
	}
	}
	@DeleteMapping("/shop/{id}")
	public ResponseEntity<Shop>delete(@PathVariable int id,@RequestBody Shop shop){

		Optional<Shop>op=sh.findById(id);
		if(op.isPresent()) {
			sh.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
	
	}
	
	}
	
	
}
