package practico6;

import java.util.*;
import java.util.stream.Collectors;

public class Directorio {
    
    HashMap<Long, Cliente> directorio = new HashMap<>();
    
    public void agregarCliente(long nrotel, long dni, String nombre, String apellido, String ciudad, String direccion) {
        if(!directorio.containsKey(nrotel)){
            directorio.put(nrotel, new Cliente(dni, nombre, apellido, ciudad, direccion));
        }
    }

    public Cliente buscarCliente(long nrotel) {
        return directorio.get(nrotel);
    }

    public List<Long> buscarTelefono(String apellido) {
        ArrayList<Long> listaNum = new ArrayList<>();
        Set<Long> telefonos = directorio.keySet();
        Iterator<Long> it = telefonos.iterator();
        long i = it.next();
        
        while(it.hasNext()) {
            if(directorio.get(i).getApellido().equalsIgnoreCase(apellido)){
                listaNum.add(i);
            }
        }
        return listaNum;
    }

    public List<Cliente> buscarClientes(String ciudad) {
        return directorio.values().stream().filter(cliente -> cliente.getCiudad().equals(ciudad)).collect(Collectors.toList());
    }

    public Cliente borrarCliente(long dni) {
        Set aux = directorio.keySet();
        Iterator it = aux.iterator();
        Cliente bandera = null;
        Cliente c;
        while(it.hasNext()){
            c = directorio.remove((long)it.next());
            if(c.getDni() == dni){
                bandera = directorio.remove(it);
                break;
            }
        }
    return bandera;
    }

}
