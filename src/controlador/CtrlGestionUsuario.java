package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Listas;
import modelo.Usuario;
import modelo.Validaciones;
import vista.*;

public class CtrlGestionUsuario implements ActionListener,ItemListener{
    //Variables
    private final MenuPrincipal menu;
    private final GestionUsuarios view;
    private final Listas lista;
    private final Tabla tabla;
    private final CtrlTabla ctrlTabla;
    private int opc;
    //Imagen Logo
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlGestionUsuario(MenuPrincipal menu, GestionUsuarios view, Listas lista, Tabla tabla, CtrlTabla ctrlTabla) {
        this.menu = menu;
        this.view = view;
        this.lista = lista;
        this.tabla = tabla;
        this.ctrlTabla = ctrlTabla;
        //Action Listener
        this.view.btnNuevo.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnGrabar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnCerrar.addActionListener(this);
        this.view.btnListaUsuarios.addActionListener(this);
        //Key Adapter
        this.view.txtCedula.addKeyListener(new EventoNumerosCedula());
        this.view.txtNombres.addKeyListener(new EventoLetras());
        this.view.txtApellidos.addKeyListener(new EventoLetras());
        this.view.txtCorreo.addKeyListener(new EventoCorreo());
        this.view.txtTelefono.addKeyListener(new EventoNumerosTelefono());
        //Item Listener
        this.view.cmbDependencia.addItemListener(this);
        //Inicializaciones necesarias
        CargarImagenes();
        LimpiarVista();
        CargarComboBox();
        ActivarBotones(true);
        ActivarTextos(false);
    }
    //Funcion cuando se va a crear un nuevo usuario**************************************************************************************************
    public void Nuevo(){
        LimpiarVista();
        ActivarBotones(false);
        ActivarTextos(true);
        opc = 1;
    }
    //Funcion cuando se desea actualizar datos de un usuario creado anteriormente********************************************************************
    public void Actualizar(){
        int pos = lista.buscarCedula(JOptionPane.showInputDialog(null, "Escribe el numero de cedula \ndel usuario que desea modificar:"));
        if(pos!=-1){
            ActivarBotones(false);
            ActivarTextos(true);
            MostrarDatos(lista.getUsuario(pos));
            view.txtCedula.setEditable(false);
            opc = 2;
        }
        else JOptionPane.showMessageDialog(null, "Usuario no existe");
    }
    //Funcion para grabar los datos ingresados en los cuadros de texto, sea nuevo o actualizar un usuario********************************************
    public void Grabar(){
        String errores = Validaciones.ValidarUsuario(view.txtCedula.getText(), 
                view.txtContrasenia.getText(), view.txtNombres.getText(), 
                view.txtApellidos.getText(), view.txtTelefono.getText(), 
                view.txtCorreo.getText());
        
        if(errores.equalsIgnoreCase("")){
            if (opc == 1){//si es nuevo
                Usuario nuevo = new Usuario();
                GrabarDatos(nuevo);
                lista.AgregarUsuario(nuevo);
                JOptionPane.showMessageDialog(null,"Usuario ingresado correctamente","Ingreso Usuario",JOptionPane.INFORMATION_MESSAGE);
            }
            else{//es actualizar
                int pos=lista.buscarCedula(view.txtCedula.getText());
                if(pos == -1)
                    JOptionPane.showMessageDialog(null, "Usuario no existe");
                else{
                    GrabarDatos(lista.getUsuario(pos));
                    JOptionPane.showMessageDialog(null,"Usuario modificado correctamente","Gestion Usuario",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //Graba en el archivo
            GrabarArchivo();
            LimpiarVista();
            ActivarBotones(true);
            ActivarTextos(false);
        }
        else JOptionPane.showMessageDialog(null,errores,"Datos Incorrectos",JOptionPane.ERROR_MESSAGE);
    }
    //En caso que se desee eliminar un usuario ingresado anteriormente*******************************************************************************
    public void Eliminar(){
        int pos = lista.buscarCedula(JOptionPane.showInputDialog(null, "Escribe el numero de cedula \ndel usuario que desea buscar:"));
        if (pos != -1){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?\nUsuario: " + 
                    lista.getUsuario(pos).getNombres()+" "+lista.getUsuario(pos).getApellidos(),"Alerta!",JOptionPane.YES_NO_OPTION);
            if (res == 0){
                lista.EliminarUsuario(pos);
                JOptionPane.showMessageDialog(null, "Empleado Eliminado");
            }
            if(res == 1) JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");
        }
        else JOptionPane.showMessageDialog(null, "Usuario no existe");
    }
    //En caso de haber presionado nuevo o actualizar y se quiera cancelar el ingreso de datos********************************************************
    public void Cancelar(){
        LimpiarVista();
        ActivarBotones(true);
        ActivarTextos(false);
    }
    //Funcion para mostrar los datos de un usuarios en pantalla**************************************************************************************
    public void MostrarDatos(Usuario u){
        view.txtCedula.setText(u.getCedula());
        view.txtNombres.setText(u.getNombres());
        view.txtApellidos.setText(u.getApellidos());
        view.txtTelefono.setText(u.getTelefono());
        view.txtCorreo.setText(u.getCorreo());
        view.txtContrasenia.setText(u.getContrasenia());
        if(u.getDependencia().equals("EstudianteA")){
            view.cmbDependencia.setSelectedItem("Estudiante");
            view.rbtnPermiso.setSelected(true);
        }
        else if(u.getDependencia().equals("EstudianteB")){
            view.cmbDependencia.setSelectedItem("Estudiante");
            view.rbtnNoPermiso.setSelected(true);
        }
        else {
            view.cmbDependencia.setSelectedItem(u.getDependencia());
        }
    }
    //Funcion para grabar datos en un objeto tipo usuario********************************************************************************************
    public void GrabarDatos(Usuario u){
        String aux = "";
        if(((String)view.cmbDependencia.getSelectedItem()).equals("Estudiante") && view.rbtnPermiso.isSelected()) aux = "EstudianteA";
        else if(((String)view.cmbDependencia.getSelectedItem()).equals("Estudiante") && view.rbtnNoPermiso.isSelected()) aux = "EstudianteB";
        else aux = (String)view.cmbDependencia.getSelectedItem();
        
        u.setCedula(view.txtCedula.getText());
        u.setNombres(view.txtNombres.getText());
        u.setApellidos(view.txtApellidos.getText());
        u.setTelefono(view.txtTelefono.getText());
        u.setCorreo(view.txtCorreo.getText());
        u.setConstrasenia(view.txtContrasenia.getText());
        u.setDependencia(aux);
    }
    //Funcion para mostrar los datos en la interfaz con tabla****************************************************************************************
    public void ListarUsuarios(){
        AbrirVentana(tabla,"Tabla Usuarios");
        String col[] = {"CEDULA","NOMBRES","APELLIDOS","TELEFONO","CORREO","CONTRASEÑA","DEPENDENCIA"};
        ctrlTabla.Inicio(col,1);
        for(Usuario u:lista.getListaUsuarios()){
            if(!u.getDependencia().equals("Administrador")) ctrlTabla.AgregarFila(u.getDatos());
        }
    }
    //Cargar imagen para logo del programa***********************************************************************************************************
    public void CargarImagenes(){
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/imagenes/Layer.png"));
        Image im1 = myImage.getImage();
        Image im2 = im1.getScaledInstance(view.lblLogo.getWidth(), view.lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(im2);
        view.lblLogo.setIcon(i);
    }
    //Funcion para activar y desactivar botones dependiendo como sea necesario***********************************************************************
    public void ActivarBotones(boolean estado){
        view.btnNuevo.setEnabled(estado);
        view.btnActualizar.setEnabled(estado);
        view.btnEliminar.setEnabled(estado);
        view.btnCerrar.setEnabled(estado);
        view.btnGrabar.setEnabled(!estado);
        view.btnCancelar.setEnabled(!estado);
        view.btnListaUsuarios.setEnabled(true);
    }
    //Funcion para activar los cuadros de texto dependiendo como sea necesario***********************************************************************
    public void ActivarTextos(boolean estado){
        view.txtCedula.setEditable(estado);
        view.txtNombres.setEditable(estado);
        view.txtApellidos.setEditable(estado);
        view.txtTelefono.setEditable(estado);
        view.txtCorreo.setEditable(estado);
        view.txtContrasenia.setEditable(estado);
        view.cmbDependencia.setSelectedIndex(0);
        view.cmbDependencia.setEnabled(estado);
        
    }
    //Funcion para limpiar todos los cuadros de texto para que no haya informacion en ellos**********************************************************
    public void LimpiarVista(){
        view.txtCedula.setText("");
        view.txtNombres.setText("");
        view.txtApellidos.setText("");
        view.txtTelefono.setText("");
        view.txtCorreo.setText("");
        view.txtContrasenia.setText("");
    }
    //Cargar opciones en el combo de dependencias****************************************************************************************************
    public void CargarComboBox(){
        view.cmbDependencia.removeAllItems();
        view.cmbDependencia.addItem("Decano");
        view.cmbDependencia.addItem("Subdecano");
        view.cmbDependencia.addItem("Director de Carrera");
        view.cmbDependencia.addItem("Docente");
        view.cmbDependencia.addItem("Estudiante");
        view.cmbDependencia.setEditable(false);
    }
    //Funcion en caso de que se escoja en dependencia "Estudiante", para elegir si puede o no reservar espacios***************************************
    public void EstudianteAB(){
        if(((String) view.cmbDependencia.getSelectedItem()).equals("Estudiante")){
            view.lblReservarAulas.setVisible(true);
            view.rbtnPermiso.setVisible(true);
            view.rbtnNoPermiso.setVisible(true);
        }
        else{
            view.lblReservarAulas.setVisible(false);
            view.rbtnPermiso.setVisible(false);
            view.rbtnNoPermiso.setVisible(false);
        }
    }
    //Abrir una ventana y cerrar la actual sin que el programa se termine****************************************************************************
    public void AbrirVentana(JFrame ventan,String nom){
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        view.setVisible(false);
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
    }
    //Funcion para grabar los datos actuales en el archivo de usuarios*******************************************************************************
    public void GrabarArchivo(){
        try{
            lista.GrabarUsuariosActuales();
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    //Acciones para los Botones**********************************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.btnNuevo) Nuevo();
        if(e.getSource()==view.btnActualizar) Actualizar();
        if(e.getSource()==view.btnGrabar) Grabar();
        if(e.getSource()==view.btnEliminar) Eliminar();
        if(e.getSource()==view.btnCancelar) Cancelar();
        if(e.getSource()==view.btnCerrar) AbrirVentana(menu,"Menu Pricipal");
        if(e.getSource()==view.btnListaUsuarios) ListarUsuarios();
    }
    //Funcion para el ComboBox cunado se seleccione una opcion***************************************************************************************
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==view.cmbDependencia) EstudianteAB();
    }
    //Funciones Key Listener*************************************************************************************************************************
    private class EventoNumerosCedula extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            //Variable que registra el codigo ASCII de la tecla pulsada
            int tecla=e.getKeyChar();
            
            //Varible que es verdadera cuando se presionan las teclasd de numeros y de borrado
            boolean num= tecla>= 48 && tecla<=57 || tecla==127;
            
            //Si es falsa (una tecla diferente a numeros)
            if(!num){
                //No se escribe en el campo
                e.consume();
            }
            //Resringe al campo que escriba más de ciertos dígitos
            if(view.txtCedula.getText().length()>=10){
                e.consume();
                JOptionPane.showMessageDialog(null,"La cedula no puede contener más de 10 dígitos","Números Excesivos",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class EventoNumerosTelefono extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            //Variable que registra el codigo ASCII de la tecla pulsada
            int tecla=e.getKeyChar();
            
            //Varible que es verdadera cuando se presionan las teclasd de numeros y de borrado
            boolean num= tecla>= 48 && tecla<=57 || tecla==127;
            
            //Si es falsa (una tecla diferente a numeros)
            if(!num){
                //No se escribe en el campo
                e.consume();
            }
            //Resringe al campo que escriba más de ciertos dígitos
            if(view.txtTelefono.getText().length()>=10){
                e.consume();
                JOptionPane.showMessageDialog(null,"El telefono no puede contener más de 10 dígitos","Números Excesivos",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class EventoLetras extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            //Código ASCII de la tecla pulsada
            int tecla=e.getKeyChar();
            //verdadera para el abecedario y borrado
            boolean num= (tecla>= 65 && tecla<=90) || (tecla>= 97 && tecla<=122) || tecla==32 || tecla==239 ||tecla==127;
            if(!num){
                //No escribe en el campo para una tecla diferente
                e.consume();
            }
        }
    }
    
    private class EventoCorreo extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            //Código ASCII de la tecla pulsada
            int tecla=e.getKeyChar();
            //verdadera para el abecedario y borrado
            boolean num= (tecla>= 97 && tecla<=122) || tecla==46 || tecla==64 || tecla==32 || tecla==239 ||tecla==127;
            if(!num){
                //No escribe en el campo para una tecla diferente
                e.consume();
            }
        }
    }
}