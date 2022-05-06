
package com.CDA.demo.repository;

import com.CDA.demo.models.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface Repositorys extends CrudRepository<Service,Long>{
    
    @Override
    public List<Service> findAll();

    @Override
    public Optional<Service> findById(Long id);
    
    public Optional<Service> findByDocumento(Long documento);
    
    @Override
    public <S extends Service> S save(S entity);
    
    @Override
    public void delete (Service entity);

    public Service save(Optional<Service> actualizacion);

    @Override
    public boolean existsById(Long id);
    
    public boolean existsByDocumento(Long documento);
}
