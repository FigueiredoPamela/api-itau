package br.com.itau.repository;

import br.com.itau.model.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PamPam13
 */
public interface CarRepository extends JpaRepository<Car, Long>{
    
    List<Car> findByName(String name);
    
    List<Car> findByManufacturer(String manufacturer);
    
    List<Car> findByCarYear(int carYear);
    
    List<Car> findByChassiOrPlaca(String chassi, String placa);
            
}
