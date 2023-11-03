
package Tienda_Steven.demo.dao;

import Tienda_Steven.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
}
