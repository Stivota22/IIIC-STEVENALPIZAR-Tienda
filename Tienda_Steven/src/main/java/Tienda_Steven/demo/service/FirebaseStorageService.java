
package Tienda_Steven.demo.service;

import org.springframework.web.multipart.MultipartFile;


public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-josuevalverde.appspot.com";
    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "Techshop";
    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-StevenAlpizar-firebase-adminsdk-sgpf3-bf9e711a54.json";
}
