package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Listas{
    private String ingreso;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Edificio> edificios = new ArrayList<Edificio>();
    //Funciones de la variable ingreso***********************************************************************
    public String getIngreso() {
        return ingreso;
    }
    
    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }
    //Funciones Lista Usuarios*******************************************************************************
    public ArrayList<Usuario> getListaUsuarios(){    
        return usuarios;
    }
    
    public void setListaUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void AgregarUsuario(Usuario u) {
        usuarios.add(u);
    }
    
    public Usuario getUsuario(int index){
        return usuarios.get(index);
    }
    
    public void LimpiarListaUsuarios(){
        usuarios.clear();
    }
    
    public int TamanioListaUsuarios(){
        return usuarios.size();
    }
    
    public void EliminarUsuario(int index){
        this.usuarios.remove(index);
    }
    
    public int buscarCedula (String identificacion){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getCedula().equalsIgnoreCase(identificacion)) return i;
        }
        return -1;
    }
    
    public int buscarCorreo (String correo){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getCorreo().equals(correo)) return i;
        }
        return -1;
    }
    
    public int BuscarUsuario(String nombres){
        for(int i=0;i<usuarios.size();i++){
            String aux = usuarios.get(i).getNombres()+" "+usuarios.get(i).getApellidos();
            if(aux.equals(nombres)) return i;
        }
        return -1;
    }
    
    public void CrearAdministrador(){
        int index = buscarCorreo("administracionucuenca@gmail.com");
        
        if(index==-1){
            Usuario nuevo = new Usuario();
            nuevo.setCedula("");
            nuevo.setNombres("Administrador");
            nuevo.setApellidos("");
            nuevo.setTelefono("");
            nuevo.setCorreo("administracionucuenca@gmail.com");
            nuevo.setDependencia("Administrador");
            nuevo.setConstrasenia("123");
            
            usuarios.add(nuevo);
            
            try {
                GrabarUsuariosActuales();
            } catch (IOException ex) {
            }
        }
    }
    
    public void GrabarUsuariosActuales() throws FileNotFoundException, IOException{
        try{
            ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("usuariosActuales"));
            archivo.writeObject(usuarios);
            archivo.flush();
            archivo.close();
        } 
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error -> Al abrir el archivo de Usuarios");
        }
    }

    //Método para recuperar datos de las personas del archivo personas afiliadas
    public void RecuperarClientesActuales(){
        try{
            ObjectInputStream archivo = null;
            File path=new File("usuariosActuales");
            if(path.exists()){
                archivo =new ObjectInputStream(new FileInputStream("usuariosActuales"));
                usuarios=(ArrayList<Usuario>)archivo.readObject(); //Recupera los datos del archivo
                archivo.close();
            }
            else{
                System.out.println("No se cargo el archivo Usuarios");
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error -> Se encuentra una clase IOException del objeto");
        }
        catch(IOException ex){
            System.out.println("Error -> Al abrir el archivo de Usuarios");
        }
    }
    //Funciones Lista Usuarios*******************************************************************************
    public ArrayList<Edificio> getListaEdificios(){    
        return edificios;
    }
    
    public void setListaEdificios(ArrayList<Edificio> edificios) {
        this.edificios = edificios;
    }
    
    public void AgregarEdificio(Edificio e) {
        edificios.add(e);
    }
    
    public Edificio getEdificio(int index){
        return edificios.get(index);
    }
    
    public void LimpiarListaEdificios(){
        edificios.clear();
    }
    
    public int TamanioListaEdificios(){
        return edificios.size();
    }
    
    public void EliminarEdificio(int index){
        this.edificios.remove(index);
    }
    
    public int buscarEdificio(String codigo){
        for(int i=0;i<edificios.size();i++){
            if(edificios.get(i).getCodigo().equals(codigo)) return i;
        }
        return -1;
    }
    
    public Espacio BuscarEspacio(String codigo){
        for(Edificio ed:edificios){
            int index = ed.buscarEspacio(codigo);
            if(index!=-1) return ed.getEspacio(index);
        }
        return null;
    }
    
    public void GrabarEdificiosActuales() throws FileNotFoundException, IOException{
        try{
            ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("edificiosActuales"));
            archivo.writeObject(edificios);
            archivo.flush();
            archivo.close();
        } 
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error -> Al abrir el archivo de Edificios");
        }
    }

    //Método para recuperar datos de las personas del archivo personas afiliadas
    public void RecuperarEdificiosActuales(){
        try{
            ObjectInputStream archivo = null;
            File path=new File("edificiosActuales");
            if(path.exists()){
                archivo =new ObjectInputStream(new FileInputStream("edificiosActuales"));
                edificios=(ArrayList<Edificio>)archivo.readObject(); //Recupera los datos del archivo
                archivo.close();
            }
            else{
                System.out.println("No se cargo el archivo Edificios");
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error -> Se encuentra una clase IOException del objeto");
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Error -> Al abrir el archivo de Edificios");
        }
    }
    //Funciones extras**********************************************************
    public String GenerarCodigo(String  edificio, String piso){
        System.out.println("Generando Código");
        int edi = buscarEdificio(edificio);
        System.out.println("edi "+edi);
        int pos;
        String codigo;
        int i = 0;
        do{
            if(i<10) codigo = edificio + piso + "0" + i;
            else codigo = edificio + piso + i;
            
            pos = getEdificio(edi).buscarEspacio(codigo);
            System.out.println("Pos " + pos);
            i++;
        }while(pos!=-1);
        System.out.println(codigo);
        return codigo;
    }
    
    public String GenerarCodigoEdificio(){
        int pos = -1;
        int i = 0;
        int charc = 64;
        
        do{
            charc++;
            pos=buscarEdificio(""+(char)charc);
            i++;
            System.out.println("Cod " +(char)charc);
        }while(pos!=-1);
        
        return ""+(char)charc;
    }
}