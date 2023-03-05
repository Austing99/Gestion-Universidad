 
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
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.Edificio;
import modelo.Elemento;
import modelo.Espacio;
import modelo.Listas;
import vista.GestionEspacios;
import vista.MenuPrincipal;
import vista.Tabla;

public class CtrlGestionEspacios implements ActionListener,ItemListener{
    private final MenuPrincipal menu;
    private final GestionEspacios view;
    private final Listas lista;
    private final Tabla tabla;
    private final CtrlTabla ctrlTabla;
    private int opc;
    //Imagen
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlGestionEspacios(MenuPrincipal menu, GestionEspacios view, Listas lista, Tabla tabla, CtrlTabla ctrlTabla) {
        this.menu = menu;
        this.view = view;
        this.lista = lista;
        this.tabla = tabla;
        this.ctrlTabla = ctrlTabla;
        
        //Action Listener*******************************************************
        //Botones
        this.view.btnNuevo.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnGrabar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnCerrar.addActionListener(this);
        this.view.btnListasEspacios.addActionListener(this);
        //Botones Encargados
        this.view.btnAddEncar.addActionListener(this);
        this.view.btnElimEncar.addActionListener(this);
        this.view.btnMostEncar.addActionListener(this);
        //Botones Elementos
        this.view.btnNuevoElem.addActionListener(this);
        this.view.btnEliminarElem.addActionListener(this);
        this.view.btnGrabarElem.addActionListener(this);
        this.view.btnCancelarElem.addActionListener(this);
        this.view.btnListaElementos.addActionListener(this);
        //Item Listener*********************************************************
        this.view.cmbEdificio.addItemListener(this);
        this.view.cmbPlanta.addItemListener(this);
        this.view.cmbEdiElem.addItemListener(this);
        //Key Listener**********************************************************
        //Espacios
        this.view.txtCapacidad.addKeyListener(new EventoNumeros());
        //Elementos
        this.view.txtCantidad.addKeyListener(new EventoNumeros());
    }
    //Funciones para inicializar interfaz************************************************************************************************************
    public void Iniciar(){
        //Inicializaciones necesarias
        CargarImagenes();
        LimpiarVista();
        CargarComboBox();
        ActivarBotones(true);
        ActivarTextos(false);
        ActivarElementos(true);
        CargarComboEdificios(view.cmbEdificio);
        CargarComboEdificios(view.cmbEdiElem);
    }
    //Carga de datos en los ComboBox respectivos*****************************************************************************************************
    public void CargarComboEdificios(JComboBox combo){
        combo.removeAllItems();
        for(int i=0; i<lista.TamanioListaEdificios();i++){
            combo.addItem(lista.getEdificio(i).getCodigo());
        }
    }
    
    public void CargarComboPlantas(){
        int edi = lista.buscarEdificio((String) view.cmbEdificio.getSelectedItem());
        
        if(edi!=-1){
            int plantas = lista.getEdificio(edi).getNum_plantas();
            if(plantas>0){
                view.cmbPlanta.removeAllItems();
                for(int i=1; i<=plantas;i++){
                    view.cmbPlanta.addItem(i+"");
                }
                view.cmbPlanta.setSelectedIndex(0);
            }
        }
    }
    
    public void CargarComboEspacios(){
        int edi = lista.buscarEdificio((String) view.cmbEdiElem.getSelectedItem());
        
        if(edi!=-1){
            if(lista.getEdificio(edi).TamanioListaEspacios()>0){
                for(Espacio esp: lista.getEdificio(edi).getListaEspacios()){
                    view.cmbEspacio.addItem(esp.getCodigo());
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////Funciones Espacios///////////////////////////////////////////////////////////
    //Funcion cuando se va a crear un nuevo espacio**************************************************************************************************
    public void Nuevo(){
        LimpiarVista();
        ActivarBotones(false);
        ActivarTextos(true);
        opc = 1;
    }
    //Funcion cuando se desea actualizar datos de un espacio creado anteriormente********************************************************************
    public void Actualizar(){
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio\npara listar elementos:");
        Espacio esp = lista.BuscarEspacio(codigo);
        
        if(esp!=null){
            MostrarDatosEspacio(esp);
            ActivarBotones(false);
            ActivarTextos(true);
            opc = 2;
            view.cmbEdificio.setEnabled(false);
            view.cmbPlanta.setEnabled(false);
            view.txtCodigo.setEditable(false);
        }
        else JOptionPane.showMessageDialog(null, "Espacio Inexistente");
    }
    //Funcion para grabar los datos ingresados en los cuadros de texto, sea nuevo o actualizar un espacio********************************************
    public void Grabar(){
        int edi = lista.buscarEdificio((String) view.cmbEdificio.getSelectedItem());
        
        if (opc == 1 && edi!=-1){ //si es nuevo
            
                Espacio nuevo = new Espacio();
                
                GrabarDatos(nuevo);
                
                lista.getEdificio(edi).AgregarEspacio(nuevo);
                JOptionPane.showMessageDialog(null,"Espacio ingresado correctamente\n Codigo: " + nuevo.getCodigo(),"Ingreso Espacio",JOptionPane.INFORMATION_MESSAGE);
        }
        if(opc==2 && edi!=-1){//es actualizar
            int pos = lista.getEdificio(edi).buscarEspacio((String) view.txtCodigo.getText());
            if(pos == -1)
                JOptionPane.showMessageDialog(null, "El aula no existe");
            else{
                GrabarDatos(lista.getEdificio(edi).getEspacio(pos));
                
                JOptionPane.showMessageDialog(null,"Espacio modificado correctamente\n Codigo: " + lista.getEdificio(edi).getEspacio(pos).getCodigo(),
                        "Gestion Espacios",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Graba en el archivo
        GrabarArchivo();
        ActivarBotones(true);
        ActivarTextos(false);
        LimpiarVista();
    }
    //En caso que se desee eliminar un espacio ingresado anteriormente*******************************************************************************
    public void Eliminar(){
        String [] codEdif = new String[lista.TamanioListaEdificios()];
        for(int i=0;i<lista.TamanioListaEdificios();i++){
            codEdif[i] = lista.getEdificio(i).getCodigo();
        }
        
        String resp = (String) JOptionPane.showInputDialog(null,"Seleccione el edificio","Borrar Espacio",JOptionPane.DEFAULT_OPTION,null,codEdif,codEdif[0]);
        
        int edi = lista.buscarEdificio(resp);
        
        if(edi!=-1){
            int codigo = lista.getEdificio(edi).buscarEspacio(JOptionPane.showInputDialog(null, "Escribe el codigo del espacio \nque desea eliminar:"));
            if(codigo!=-1){
                int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?","Alerta!",JOptionPane.YES_NO_OPTION);
                if (res == 0){
                    lista.getEdificio(edi).EliminarEspacio(codigo);
                    JOptionPane.showMessageDialog(null, "Edificio Eliminado");
                }
                if(res == 1) JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");
            }
            else JOptionPane.showMessageDialog(null,"Espacio no existe","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    //En caso de haber presionado nuevo o actualizar y se quiera cancelar el ingreso de datos********************************************************
    public void Cancelar(){
        LimpiarVista();
        ActivarBotones(true);
        ActivarTextos(false);
    }
    //Funcion para mostrar los datos de un espacio en pantalla***************************************************************************************
    public void MostrarDatosEspacio(Espacio esp){
        view.txtCodigo.setText(esp.getCodigo());
        view.txtDescripcion.setText(esp.getDescripcion());
        view.cmbTipo.setSelectedItem(esp.getTipo());
        view.txtCapacidad.setText(esp.getCapacidad()+"");
    }
    //Funcion para grabar datos en un objeto tipo espacio********************************************************************************************
    public void GrabarDatos(Espacio es){
        if(opc==1){
            es.setCodigo(lista.GenerarCodigo((String) view.cmbEdificio.getSelectedItem(), (String) view.cmbPlanta.getSelectedItem()));
            es.LimpiarListaEncargados();
            int index = lista.buscarCorreo("adiministracionucuenca@gmail.com");
            if(index!=-1) es.AgregarEncargado(lista.getUsuario(index));
        }
        es.setDescripcion(view.txtDescripcion.getText());
        es.setUbicacion("Planta "+view.cmbPlanta.getSelectedItem());
        es.setTipo((String)view.cmbTipo.getSelectedItem());
        es.setCapacidad(Integer.parseInt(view.txtCapacidad.getText()));
    }
    //Funcion para mostrar los datos en la interfaz con tabla****************************************************************************************
    public void ListaEspacios(){
        AbrirVentana(tabla,"Tabla Espacios");
        String col[] = {"EDIFICIO","CODIGO","DESCRIPCION","UBICACION","TIPO","CAPACIDAD"};
        ctrlTabla.Inicio(col,3);
        for(Edificio ed:lista.getListaEdificios()){
            for(Espacio es:ed.getListaEspacios()){
                Vector fila = es.getDatos();
                fila.add(0, ed.getCodigo());
                ctrlTabla.AgregarFila(fila);
            }
        }
    }
    //Funcion para activar y desactivar botones dependiendo como sea necesario en el caso de espacios************************************************
    public void ActivarBotones(boolean estado){
        view.btnNuevo.setEnabled(estado);
        view.btnActualizar.setEnabled(estado);
        view.btnEliminar.setEnabled(estado);
        view.btnCerrar.setEnabled(estado);
        view.btnGrabar.setEnabled(!estado);
        view.btnCancelar.setEnabled(!estado);
        view.btnListasEspacios.setEnabled(true);
    }
    //Funcion para activar los cuadros de texto dependiendo como sea necesario en el caso de espacios************************************************
    public void ActivarTextos(boolean estado){
        view.cmbEdificio.setEnabled(estado);
        view.cmbPlanta.setEnabled(estado);
        view.txtCodigo.setEditable(false);
        view.txtDescripcion.setEditable(estado);
        view.cmbTipo.setEnabled(estado);
        view.txtCapacidad.setEditable(estado);
    }
    //Funcion para limpiar todos los cuadros de texto para que no haya informacion en ellos en el caso de espacios***********************************
    public void LimpiarVista(){
        view.txtCodigo.setText("");
        view.txtDescripcion.setText("");
        view.txtCapacidad.setText("");
    }
    //Cargar ComboBox tipo de aula*******************************************************************************************************************
    public void CargarComboBox(){
        view.cmbTipo.removeAllItems();
        view.cmbTipo.addItem("Aula");
        view.cmbTipo.addItem("Centro Computo");
        view.cmbTipo.addItem("Auditorio");
        view.cmbTipo.setEditable(false);
    }
    ///////////////////////////////////////////////////////////////////Funciones Elementos///////////////////////////////////////////////////////////
    //Funcion cuando se va a crear un nuevo elemento*************************************************************************************************
    public void NuevoElemento(){
        LimpiarVistaElementos();
        ActivarElementos(false);
    }
    //Funcion para grabar los datos ingresados en los cuadros de texto en un nuevo elemento**********************************************************
    public void GrabarElemento(){
        int edi = lista.buscarEdificio((String) view.cmbEdiElem.getSelectedItem());
        
        if(edi!=-1){
            int esp = lista.getEdificio(edi).buscarEspacio((String) view.cmbEspacio.getSelectedItem());
            if(esp!=-1){
                lista.getEdificio(edi).getEspacio(esp).AgregarElementos(new Elemento(view.txtDescEle.getText(),Integer.parseInt(view.txtCantidad.getText())));
                GrabarArchivo();
            }
            else JOptionPane.showMessageDialog(null,"Espacio no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null,"Edificio no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    //En caso que se desee eliminar un elemento ingresado anteriormente******************************************************************************
    public void EliminarElemento(){
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio:");
        Espacio esp = lista.BuscarEspacio(codigo);
        
        if(esp!=null){
            String[] elementos = new String[esp.TamanioListaElementos()];
            for(int i=0;i<esp.TamanioListaElementos();i++) elementos[i]=esp.getElemento(i).getDescripcion();
            
            String resp = (String) JOptionPane.showInputDialog(null,"Seleccione un encargado:",
                            "Agregar Encargado",JOptionPane.DEFAULT_OPTION,null,elementos,elementos[0]);
            
            if(resp!=""){
                int index = esp.buscarElemento(resp);
                if(index!=-1){
                    esp.EliminarElementos(index);
                    JOptionPane.showMessageDialog(null, "Elemento Eliminado");
                }
            }
        }
        else JOptionPane.showMessageDialog(null, "Espacio Inexistente");
    }
    //Funcion para mostrar los datos en la interfaz con tabla****************************************************************************************
    public void ListaElementos(){
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio\npara listar elementos:");
        Espacio esp = lista.BuscarEspacio(codigo);
        if(esp!=null){
            AbrirVentana(tabla,"Tabla Espacios");
            String col[] = {"ESPACIO","DESCRIPCION","CANTIDAD"};
            ctrlTabla.Inicio(col,3);
            
            for(Elemento el:esp.getListaElementos()){
                Vector fila = el.getDatos();
                fila.add(0, esp.getCodigo());
                ctrlTabla.AgregarFila(fila);
            }    
        }
        else JOptionPane.showMessageDialog(null, "Espacio Inexistente");
    }
    //Funcion para activar y desactivar elementos dependiendo como sea necesario en el caso de elementos***********************************************
    public void ActivarElementos(boolean estado){
        //Botones
        view.btnNuevoElem.setEnabled(estado);
        view.btnEliminarElem.setEnabled(estado);
        view.btnGrabarElem.setEnabled(!estado);
        view.btnCancelarElem.setEnabled(!estado);
        //Combo Box
        view.cmbEdiElem.setEnabled(!estado);
        view.cmbEspacio.setEnabled(!estado);
        //Textos
        view.txtDescEle.setEnabled(!estado);
        view.txtCantidad.setEnabled(!estado);
    }
    //Funcion para limpiar todos los cuadros de texto para que no haya informacion en ellos en el caso de elementos**********************************
    public void LimpiarVistaElementos(){
        view.txtDescEle.setText("");
        view.txtCantidad.setText("");
    }
    ///////////////////////////////////////////////////////////////////Funciones Encargados//////////////////////////////////////////////////////////
    //Funcion cuando se va a crear un nuevo encargado************************************************************************************************
    public void AgregarEncargado(){
        int index =-1;
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio\npara agregar encargado:");
        for(Edificio ed:lista.getListaEdificios()){
            index = ed.buscarEspacio(codigo);
            if(index!=-1){
                String[] encargados = new String[lista.TamanioListaUsuarios()];
                
                for(int i=0;i<lista.TamanioListaUsuarios();i++) encargados[i]= lista.getUsuario(i).getNombres()+" "+lista.getUsuario(i).getApellidos();
                
                String resp = (String) JOptionPane.showInputDialog(null,"Seleccione un encargado:",
                            "Agregar Encargado",JOptionPane.DEFAULT_OPTION,null,encargados,encargados[0]);
                
                if(!resp.equals("")){
                    int indexEnc = lista.BuscarUsuario(resp);
                    if(indexEnc!=-1) ed.getEspacio(index).AgregarEncargado(lista.getUsuario(indexEnc));
                    GrabarArchivo();
                    
                    JOptionPane.showMessageDialog(null, "Encargado Agregado");
                    
                }
            }
        }
        if(index==-1) JOptionPane.showMessageDialog(null,"Espacio no existe");
    }
    //En caso que se desee eliminar un encargado ingresado anteriormente*****************************************************************************
    public void EliminarEncargado(){
        int index =-1;
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio\npara agregar encargado:");
        for(Edificio ed:lista.getListaEdificios()){
            index = ed.buscarEspacio(codigo);
            if(index!=-1){
                String[] encargados = new String[ed.getEspacio(index).TamanioListaEncargados()];
                
                for(int i=0;i<ed.getEspacio(index).TamanioListaEncargados();i++) encargados[i]= ed.getEspacio(index).getEncargado(i).getNombres()+
                        " "+ed.getEspacio(index).getEncargado(i).getApellidos();
                
                String resp = (String) JOptionPane.showInputDialog(null,"Seleccione el encargado a eliminar:",
                            "Eliminar Encargado",JOptionPane.DEFAULT_OPTION,null,encargados,encargados[0]);
                
                if(!resp.equals("")){
                    int indexElim = ed.getEspacio(index).buscarEncargado(resp);
                    if(indexElim!=-1) ed.getEspacio(index).EliminarEncargado(indexElim);
                    GrabarArchivo();
                    
                    JOptionPane.showMessageDialog(null, "Encargado Eliminado");
                }
            }
        }
        
        if(index==-1) JOptionPane.showMessageDialog(null,"Espacio no existe");
    }
    //Funcion para mostrar los encargados de un espacio**********************************************************************************************
    public void MostrarEncargados(){
        String codigo = JOptionPane.showInputDialog(null, "Escriba el codigo del espacio\npara listar encargados:");
        Espacio esp = lista.BuscarEspacio(codigo);
        String mensaje="Los encargados del aula " + codigo+":\n";
        
        if(esp!=null){
            String encargados = "";
            for(int i=0;i<esp.TamanioListaEncargados();i++) encargados=encargados+esp.getEncargado(i).getNombres()+" "+esp.getEncargado(i).getApellidos()+"\n";
            JOptionPane.showMessageDialog(null, mensaje+encargados);
            
        }
        else JOptionPane.showMessageDialog(null,"Espacio no Encontrado");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    //Cargar imagen para logo del programa***********************************************************************************************************
    public void CargarImagenes(){
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/imagenes/Layer.png"));
        Image im1 = myImage.getImage();
        Image im2 = im1.getScaledInstance(view.lblLogo.getWidth(), view.lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(im2);
        view.lblLogo.setIcon(i);
    }
    //Funcion para grabar Archivo********************************************************************************************************************
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
    //Action Listener Botones************************************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones***************************************************************
        if(e.getSource()==view.btnNuevo) Nuevo();
        if(e.getSource()==view.btnActualizar) Actualizar();
        if(e.getSource()==view.btnGrabar) Grabar();
        if(e.getSource()==view.btnEliminar) Eliminar();
        if(e.getSource()==view.btnCancelar) Cancelar();
        if(e.getSource()==view.btnListasEspacios) ListaEspacios();
        if(e.getSource()==view.btnListaElementos) ListaElementos();
        if(e.getSource()==view.btnCerrar) AbrirVentana(menu,"Menu Pricipal");
        //Botones Elementos
        if(e.getSource()==view.btnNuevoElem) NuevoElemento();
        if(e.getSource()==view.btnEliminarElem) ;
        if(e.getSource()==view.btnGrabarElem) GrabarElemento();
        if(e.getSource()==view.btnCancelarElem){
            LimpiarVistaElementos();
            ActivarElementos(true);
        }
        //Botones Encargados
        if(e.getSource()==view.btnAddEncar) AgregarEncargado();
        if(e.getSource()==view.btnElimEncar) EliminarEncargado();
        if(e.getSource()==view.btnMostEncar) MostrarEncargados();
    }
    //Item Listener ComboBox*************************************************************************************************************************
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==view.cmbEdificio) CargarComboPlantas();
        
        if(e.getSource()==view.cmbEdiElem) CargarComboEspacios();
    }
    //Key Listener***********************************************************************************************************************************
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
}