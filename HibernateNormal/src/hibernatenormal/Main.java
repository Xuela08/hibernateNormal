package hibernatenormal;

import java.util.List;




public class Main {
    
    public static void main(String[] args) {
        ContactosDAO contactosDAO = new ContactosDAO(); 
        Contacto contactoRecuperado = null;  
        long idAEliminar = 0;  

        //Creamos tes instancias de Contacto 
        Contacto contacto1 = new Contacto(0, "Contacto 1", "contacto1@contacto.com", "12345678"); 
        Contacto contacto2 = new Contacto(0, "Contacto 2", "contacto2@contacto.com", "87654321"); 
        Contacto contacto3 = new Contacto(0, "Contacto 3", "contacto3@contacto.com", "45612378");  

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        idAEliminar = contactosDAO.guardaContacto(contacto1); 
        contactosDAO.guardaContacto(contacto2); 
        contactosDAO.guardaContacto(contacto3);  

        //Modificamos el contacto 2 y lo actualizamos 
        contacto2.setNombre("Nuevo Contacto 2"); 
        contactosDAO.actualizaContacto(contacto2);  

        //Recuperamos el contacto1 de la base de datos 
        contactoRecuperado = contactosDAO.obtenContacto(idAEliminar); 
        System.out.println("Recuperamos a " + contactoRecuperado.getNombre());  

        //Eliminamos al contactoRecuperado (que es el contacto3) 
        contactosDAO.eliminaContacto(contactoRecuperado);  

        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Contacto> listaContactos = contactosDAO.obtenListaContactos();  
        System.out.println("Hay " + listaContactos.size() + "contactos en la base de datos");  

        for(Contacto c : listaContactos) 
        { 
            System.out.println("-> " + c.getNombre()); 
        }
    }
    
}

