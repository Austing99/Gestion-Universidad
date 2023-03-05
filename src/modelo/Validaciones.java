package modelo;

import java.util.ArrayList;

public class Validaciones {
    public static String ValidarUsuario(String cedula, String contrasenia, String nombres, String apellidos, String telefono, String correo){
        String errores="";
        if(ValidarCedula(cedula) && ValidarCorreo(correo) && telefono.length()==10 &&
                !nombres.equalsIgnoreCase("") && !apellidos.equalsIgnoreCase("") &&
                !contrasenia.equalsIgnoreCase("")) errores = "";
        else{
            if(!ValidarCedula(cedula)) errores=errores+"Numero de Cedula Invalido\n";
            if(nombres.equalsIgnoreCase("")) errores=errores+"Nombres sin ingresar\n";
            if(apellidos.equalsIgnoreCase("")) errores=errores+"Apellidos sin ingresar\n";
            if(telefono.length()!=10) errores=errores+"Numero de Telefono Invalido\n";
            if(!ValidarCorreo(correo)) errores=errores+"Correo Electronico Invalido\n";
            if(contrasenia.equalsIgnoreCase("")) errores=errores+"Contraseña sin ingresar\n";
        }
        return errores;
    }
    public static boolean ValidarCedula(String cedu){
        boolean val=false;
        //Validacion del tamaño de la cedula
        if(cedu.length()!=10){
            return false;
        }
        else{
            int []vecNum=new int[11];   
            int c;
            int suma=0;
            int aux;
            int div;
            int res;
            for(int i=0; i<10; i++)     //Llenado del array de numeros de la cedula
            {
                c=(int)cedu.charAt(i);  //Transformacion de caracteres a enteros
                aux=c-48;
                vecNum[i]=aux;
                if((i%2)==0)            //Si el numero es par
                {
                    vecNum[i]=vecNum[i]*2;  
                    if(vecNum[i]>9)     //Si, multiplicación >9, restar 9
                    {
                        vecNum[i]=vecNum[i]-9;
                    }
                }
                else {                  
                    vecNum[i]=vecNum[i]*1;
                }
         
            }
            for(int j=0; j<9; j++)      //Suma de los resultados
            {
                suma=suma+vecNum[j];
            }
            div=(suma%10);      //Residuo de la division 
            res=10-div;         //Resta para obtener el ultimo digito
            int d=(int)cedu.charAt(9);      //Ultimo digito de la cedula ingresada
            d=d-48;
            if(d==res)          //Validación del ultimo dígito
            {
                val=true;       //Da como válida a la cédula ingresada
            }
            return val;     //Retorna validación en boolean
            
        }
    }
    //**************************************************************************
    public static boolean ValidarCorreo(String correo){
        String[] cadena = correo.split("@");
        if(cadena.length==2){
            if(cadena[1].equals("ucuenca.edu.ec")) return true;
        }
        else return false;
        return false;
    }
    //**************************************************************************
    public static String ComprobarUsuario(ArrayList<Usuario> usuarios,String usuario,String clave){
        if(usuarios.size()!=0){
            for(Usuario u: usuarios){
                if(u.getCorreo().equals(usuario) && u.getContrasenia().equals(clave)) return u.getCorreo();
            }
        }
        return "-1";
    }
}