package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.categoriaservice;
import com.tienda.service.productoservice;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/producto")
public class productocontroller {
  
    @Autowired
    private productoservice productoService;
    @Autowired
    private categoriaservice categoriaService;
    
    
     @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        boolean productos = false;
        producto = (Producto) productoService.getProductos(productos);
        model.addAttribute("producto", producto);
        
        var categorias = categoriaService.getcategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/producto/modifica";
    }   
}