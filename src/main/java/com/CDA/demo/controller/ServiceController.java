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
    public void saveId(@RequestBody Service serv){
       repository.save(serv);
       //return "ok"; 
    } 
    @GetMapping("/servicio/{documento}")
    public Optional<Service> getDocumento (@PathVariable Long documento){
        return repository.findByDocumento(documento);
    }
    @PutMapping("/servicio")
    public String UpdateID (@RequestBody Service serv){
        Long documentoID = serv.getDocumento();
        if(repository.existsByDocumento(documentoID)){
            Service actualizacion = repository.findByDocumento(documentoID).get();
            actualizacion.setId(serv.getId());
            actualizacion.setDocumento(serv.getDocumento());
            actualizacion.setNombre_apellido(serv.getNombre_apellido());
            actualizacion.setTelefono(serv.getTelefono());
            actualizacion.setTipo_vehiculo(serv.getTipo_vehiculo());
            actualizacion.setPlaca(serv.getPlaca());
            actualizacion.setModelo(serv.getModelo());
            actualizacion.setFecha(serv.getFecha());
            actualizacion.setHora(serv.getHora());
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
