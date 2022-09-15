package com.example.demo.contoller;

import com.example.demo.domain.Adress;
import com.example.demo.respository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdressController {

    @Autowired
    AdressRepository adressRepository;
//    @Autowired
//    StudentRepository studentRepository;

    @GetMapping("/adress")
    public List<Adress> index() {
        return adressRepository.findAll();
    }

    @PostMapping("/adress/create")
    public Adress addAdress(@RequestBody Adress adress) {
        return adressRepository.save(adress);
    }

    @DeleteMapping("/adress/delete/{id}")
    public Boolean deleteAdress(@PathVariable int id) {
        adressRepository.deleteById(id);
        return true;
    }
}
