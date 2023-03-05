package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Edificio;
import modelo.Listas;
import vista.GestionEdificios;
import vista.MenuPrincipal;
import vista.Tabla;

public class CtrlGestionEdificios implements ActionListener{
    //Variables
    private final MenuPrincipal menu;
    private final GestionEdificios view;
    private final Listas lista;
    private final Tabla tabla;
    private final CtrlTabla ctrlTabla;
    private int opc;
    //Imagen Logo
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlGestionEdificios(MenuPrincipal menu, GestionEdificios view, Listas lista, Tabla tabla, CtrlTabla ctrlTabla) {
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
        this.view.btnListaEdificios.addActionListener(this);
        //Key Adapter
        this.view.txtCodigo.addKeyListener(new EventoLetrasCodigo());
        this.view.txtNombre.addKeyListener(new EventoLetras());
        this.view.txtNumPlantas.addKeyListener(new EventoNumeros());
        //Inicializaciones necesarias
        CargarImagenes();
        LimpiarVista();
        CargarComboBox();
        ActivarBotones(true);
        ActivarTextos(false);
    }
    //Funcion cuando se va a crear un nuevo edificio*************************************************************************************************
    public void Nuevo(){
        LimpiarVista();
        ActivarBotones(false);
        ActivarTextos(true);
        opc = 1;
    }
    //Funcion cuando se desea actualizar datos de un edificio creado anteriormente*******************************************************************
    public void Actualizar(){
        int pos = lista.buscarEdificio(JOptionPane.showInputDialog(null, "Escribe el codigo \ndel edificio que desea modificar:"));
        if(pos!=-1){
            ActivarBotones(false);
            ActivarTextos(true);
            opc = 2;
            MostrarDatos(lista.getEdificio(pos));
        }
    }
    //Funcion para grabar los datos ingresados en los cuadros de texto, sea nuevo o actualizar un edificio*******************************************
    public void Grabar(){
        if (opc == 1){//si es nuevo
                Edificio nuevo = new Edificio();
                
                GrabarDatos(nuevo);
                
                lista.AgregarEdificio(nuevo);
                JOptionPane.showMessageDialog(null,"Edificio ingresado correctamente \n Codigo: "+nuevo.getCodigo(),"Ingreso Edificio",JOptionPane.INFORMATION_MESSAGE);
        }
        else{//es actualizar
            int pos=lista.buscarEdificio(view.txtCodigo.getText());
            if(pos == -1)
                JOptionPane.showMessageDialog(null, "Edificio no existe");
            else{
                GrabarDatos(lista.getEdificio(pos));
                
                JOptionPane.showMessageDialog(null,"Edificio modificado correctamente","Gestion Usuario",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Graba en el archivo
        GrabarArchivo();
        ActivarBotones(true);
        ActivarTextos(false);
        LimpiarVista();
    }
    //En caso que se desee eliminar un edificio ingresado anteriormente******************************************************************************
    public void Eliminar(){
        int pos = lista.buscarEdificio(JOptionPane.showInputDialog(null, "Escribe el codigo del edificio que desea eliminar:"));
        if (pos == -1)
            JOptionPane.showMessageDialog(null, "Edificio no existe");
        else{
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?","Alerta!",JOptionPane.YES_NO_OPTION);
            if (res == 0){
                lista.EliminarEdificio(pos);
                JOptionPane.showMessageDialog(null, "Edificio Eliminado");
            }
            if(res == 1) JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");
            LimpiarVista();
        }
    }
    //En caso de haber presionado nuevo o actualizar y se quiera cancelar el ingreso de datos********************************************************
    public void Cancelar(){
        LimpiarVista();
        ActivarBotones(true);
        ActivarTextos(false);
    }
    //Funcion para mostrar los datos de un edificio en pantalla**************************************************************************************
    public void MostrarDatos(Edificio ed){
        view.txtCodigo.setText(ed.getCodigo());
        view.txtNombre.setText(ed.getNombre());
        view.cmbUbicacion.setSelectedItem(ed.getUbicacion());
        view.txtNumPlantas.setText(ed.getNum_plantas()+"");
    }
    //Funcion para grabar datos en un objeto tipo edificio*******************************************************************************************
    public void GrabarDatos(Edificio ed){
        if(opc==1) ed.setCodigo(lista.GenerarCodigoEdificio());
        ed.setNombre(view.txtNombre.getText());
        ed.setUbicacion((String)view.cmbUbicacion.getSelectedItem());
        ed.setNum_plantas(Integer.parseInt(view.txtNumPlantas.getText()));
    }
    //Funcion para mostrar los datos en la interfaz con tabla****************************************************************************************
    public void ListarEdificios(){
        AbrirVentana(tabla,"Tabla Edificios");
        String col[] = {"CODIGO","NOMBRE","UBICACION","NUMERO PLANTAS","NUMERO ESPACIOS"};
        ctrlTabla.Inicio(col,2);
        for(Edificio ed:lista.getListaEdificios()){
            ctrlTabla.AgregarFila(ed.getDatos());
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
        view.btnListaEdificios.setEnabled(true);
    }
    //Funcion para activar los cuadros de texto dependiendo como sea necesario***********************************************************************
    public void ActivarTextos(boolean estado){
        view.txtCodigo.setEditable(false);
        view.txtNombre.setEditable(estado);
        view.cmbUbicacion.setEnabled(estado);
        view.txtNumPlantas.setEditable(estado);
    }
    //Funcion para limpiar todos los cuadros de texto para que no haya informacion en ellos**********************************************************
    public void LimpiarVista(){
        view.txtCodigo.setText("");
        view.txtNombre.setText("");
        view.txtNumPlantas.setText("");
    }
    //Cargar opciones en el combo de ubicacion*******************************************************************************************************
    public void CargarComboBox(){
        view.cmbUbicacion.removeAllItems();
        view.cmbUbicacion.addItem("Campus Balzay");
        view.cmbUbicacion.addItem("Campus Yanuncay");
        view.cmbUbicacion.addItem("Campus Central");
        view.cmbUbicacion.addItem("Campus Paraiso");
        view.cmbUbicacion.addItem("Campus Tarqui");
        view.cmbUbicacion.setEditable(false);
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
    //Funcion para grabar los datos actuales en el archivo de edificios******************************************************************************
    public void GrabarArchivo(){
        try{
            lista.GrabarEdificiosActuales();
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
        if(e.getSource()==view.btnListaEdificios) ListarEdificios();
    }
    //Funciones Key Listener*************************************************************************************************************************
    private class EventoLetrasCodigo extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            //Código ASCII de la tecla pulsada
            int tecla=e.getKeyChar();
            //verdadera para el abecedario y borrado
            boolean num= (tecla>= 65 && tecla<=90) || tecla==32 ||tecla==127;
            if(!num){
                //No escribe en el campo para una tecla diferente
                e.consume();
            }
            if(view.txtCodigo.getText().length()>=1){
                e.consume();
                JOptionPane.showMessageDialog(null,"El Codigo no puede contener más de 1 dígito","Digitos Excesivos",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private class EventoNumeros extends KeyAdapter{
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
}