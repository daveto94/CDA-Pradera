
package com.CDA.demo.repository;

import com.CDA.demo.models.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository 
public interface Repositorys extends CrudRepository<Service,Long>{
    
    @Override
    public List<Service> findAll();

    @Override
    public Optional<Service> findById(Long id);

    @Override
    public <S extends Service> S save(S entity);
    
    @Override
    public void delete (Service entity);
    
   
}
