
package Tienda_STEVEN.demo.dao;

import Tienda_STEVEN.demo.domain.Producto; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    
}
