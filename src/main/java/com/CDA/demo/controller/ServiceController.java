/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CDA.demo.controller;

import com.CDA.demo.models.Service;
import com.CDA.demo.repository.Repositorys;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ServiceController {
    @Autowired                                                                  //inicializar repositorio
    Repositorys repository;
    
    @GetMapping("/servicio")
     public List<Service> finAll(){
         return repository.findAll();
    }
    @PostMapping("/servicio")
    public String saveId(@RequestBody Service serv){
       repository.save(serv);
       return "ok"; 
    } 
    @GetMapping("/servicio/{documento}")
    public Optional<Service> getDocumento (@PathVariable Long documento){
        return repository.findByDocumento(documento);
    }
    @PutMapping("/servicio")
    public String UpdateID (@RequestBody Service serv){
        Long id = serv.getId();
        if(repository.existsById(id)){
            Service actualizacion = repository.findById(id).get();
            actualizacion.setId(serv.getId());
            actualizacion.setDocumento(serv.getDocumento());
            actualizacion.setNombre(serv.getNombre());
            actualizacion.setApellido(serv.getApellido());
            actualizacion.setDocumento(serv.getDocumento());
            repository.save(actualizacion);
        } 
        else{
            repository.save(serv);
        }
        return "ok";
    }
    @DeleteMapping("/servicio/{id}")
    public String deleteId(@PathVariable Long id){
        repository.deleteById(id);
        return "ok";
    }    
}
