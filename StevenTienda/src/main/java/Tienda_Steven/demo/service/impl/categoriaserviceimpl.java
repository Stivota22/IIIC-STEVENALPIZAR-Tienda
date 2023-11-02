
package Tienda_Steven.demo.service.impl;

import com.tienda.dao.categoriaDao;
import com.tienda.domain.categoria;
import com.tienda.service.categoriaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public abstract class categoriaserviceimpl implements categoriaservice {
    
    @Autowired
    private categoriaDao categoriaDao;
    @Transactional(readOnly=true)
    public List<categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
     @Override
    @Transactional(readOnly = true)
    public categoria getCategoria(categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
     @Override
    @Transactional
    public void save(categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
