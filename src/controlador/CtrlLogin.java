package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Listas;
import modelo.Validaciones;
import vista.Login;
import vista.MenuPrincipal;

public class CtrlLogin implements ActionListener {
    private Login view;
    private MenuPrincipal menu;
    private Listas listas;
    private CtrlInicio ctrlInicio;

    //Imagen
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlLogin(Login view, MenuPrincipal menu, Listas listas, CtrlInicio ctrlInicio) {
        this.view = view;
        this.menu = menu;
        this.listas = listas;
        this.ctrlInicio = ctrlInicio;
        //Action Listener
        this.view.btnIngresar.addActionListener(this);
        this.view.btnCambiarClave.addActionListener(this);
        this.view.btnCerrar.addActionListener(this);
        //Key Listener
        this.view.txtCorreo.addKeyListener(new EventoCorreo());
    }
    //Inicializaciones necesarias para abrir la ventana de ingreso***********************************************************************************
    public void Iniciar() {
        view.setVisible(true);
        view.setTitle("Inicio de Sesión");
        view.setLocationRelativeTo(null);
        view.setIconImage(iconoPropio); //icono
        view.setVisible(true);
        view.setResizable(false);
        
        CargarImagenes();
    }
    //Cargar imagen para logo del programa***********************************************************************************************************
    public void CargarImagenes() {
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/imagenes/Banner.png"));
        Image im1 = myImage.getImage();
        Image im2 = im1.getScaledInstance(view.lblLogo.getWidth(), view.lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(im2);
        view.lblLogo.setIcon(i);
    }
    //Se valida que los datos ingresados sean correspondientes a un usuario creado previamente*******************************************************
    public void ValidarIngreso(){
        if (!Validaciones.ComprobarUsuario(listas.getListaUsuarios(),
                view.txtCorreo.getText(), view.txtContrasenia.getText()).equals("-1")) {
            listas.setIngreso(view.txtCorreo.getText());
            ctrlInicio.Inicio();
            AbrirVentana(menu, "Menú Principal");
            Limpiar();
        }
        else{
            JOptionPane.showMessageDialog(null, "Datos Incorrectos", "Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Para cambiar la contraseña de un usuario creado anteriormente**********************************************************************************
    public void CambiarClave() {
        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electronico:");
        if (correo != null) {
            int aux = listas.buscarCorreo(correo);
            if (aux != -1) {
                String claveA = JOptionPane.showInputDialog(null, "Ingrese su clave actual:");
                if (claveA.equals(listas.getUsuario(aux).getContrasenia())) {
                    listas.getUsuario(aux).setConstrasenia(JOptionPane.showInputDialog(null, "Ingrese su nueva clave:"));
                    JOptionPane.showMessageDialog(null, "Cambio realizado con exito", "Cambio de Clave", JOptionPane.INFORMATION_MESSAGE);
                    
                    try {
                        listas.GrabarUsuariosActuales();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error en la grabacion de los datos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La clave actual es incorrecta", "Cambio de Contraseña", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe", "Cambio de Contraseña", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Limpiar los datos que se hayan ingresado en los contenedores de texto**************************************************************************
    public void Limpiar() {
        view.txtCorreo.setText("");
        view.txtContrasenia.setText("");
    }
    //Abrir una ventana y cerrar la actual sin que el programa se termine****************************************************************************
    public void AbrirVentana(JFrame ventan, String nom) {
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        view.setVisible(false);
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
    }
    //Funciones para los botones*********************************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnIngresar) {
            ValidarIngreso();
        }
        if (e.getSource() == view.btnCambiarClave) {
            CambiarClave();
        }
        if (e.getSource() == view.btnCerrar) {
            System.exit(0);
        }
    }
    //Funciones Key Adapter**************************************************************************************************************************
    private class EventoCorreo extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            //Código ASCII de la tecla pulsada
            int tecla = e.getKeyChar();
            //verdadera para el abecedario y borrado
            boolean num = (tecla >= 97 && tecla <= 122) || tecla == 46 || tecla == 64 || tecla == 32 || tecla == 239 || tecla == 127;
            if (!num) {
                //No escribe en el campo para una tecla diferente
                e.consume();
            }
        }
    }
}
