
package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DiaFecha;
import modelo.Edificio;
import modelo.Espacio;
import modelo.Listas;
import vista.MenuPrincipal;
import vista.Tabla;
import vista.VistaAgenda;

public class CtrlAgenda extends MouseAdapter implements ActionListener, ItemListener{
    private  MenuPrincipal menu;
    private  VistaAgenda view;
    private  Tabla tabla;
    private  Listas listas;
    private  CtrlTabla ctrlTabla;
    private Espacio esp;
    private DefaultTableModel tablaEspacios, tablaSolicitudes;
    
    //Imagen
    private final Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");
    
    public CtrlAgenda(MenuPrincipal menu, VistaAgenda view, Listas listas, Tabla tabla, CtrlTabla ctrlTabla){
        this.menu = menu;
        this.view = view;
        this.listas = listas;
        this.tabla = tabla;
        this.ctrlTabla = ctrlTabla;
        this.view.btnEspacios.addActionListener(this);
        this.view.btnCerrar.addActionListener(this);
        this.view.btnAcepSoli.addActionListener(this);
        this.view.btnRechSoli.addActionListener(this);
        this.view.btnBuscar.addActionListener(this);//Boton para buscar la agenda por fecha
        this.view.PanelEncargado.setVisible(false);
        
        this.view.cmbAula.addItemListener(this);
        
        this.view.tablaSolicitudes.addMouseListener(this);
        
        setTablaEspacios();
        setTablaSolicitudes();
        Espacios();
    }
    
    public void inicio(Espacio esp){
        this.esp = esp;
    }
    
    public void setTablaEspacios(){
        String data[][] = {};
        String col[] = {"Hora","Lunes","Martes","Miércoles","Jueves","Viernes"};
        int hora = 6;
        //Para que la tabla no sea editable
        tablaEspacios = new DefaultTableModel(data,col){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        view.tablaEspacios.setModel(tablaEspacios);
        for(int i=0;i<16;i++){
            tablaEspacios.insertRow(tablaEspacios.getRowCount(), new Object[]{});
            hora++;
            tablaEspacios.setValueAt(hora+" : 00", tablaEspacios.getRowCount()-1, 0);
        }
    }
    
    public void setTablaSolicitudes(){
        String data[][] = {};
        String col[] = {"Solicitante","Prioridad","Estado","Fecha","Actividad","Hora Inicio","Hora Fin"};
        //Para que la tabla no sea editable
            tablaSolicitudes = new DefaultTableModel(data,col){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        view.tablaSolicitudes.setModel(tablaSolicitudes);
    }
    
    //Cuando existen solicitudes
    public void setTablaSolicitudes1(){
        String data[][] = {};
        String col[] = {"Solicitante","Prioridad","Estado","Fecha","Actividad","Hora Inicio","Hora Fin"};
        //Para que la tabla no sea editable
        tablaSolicitudes = new DefaultTableModel(data,col){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        view.tablaSolicitudes.setModel(tablaSolicitudes);
        if(esp!=null){
            for(int i=0;i<esp.getSizeAgenda();i++){
                tablaSolicitudes.insertRow(tablaSolicitudes.getRowCount(), new Object[]{});
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getSolicitante().getUsuario().getCorreo(), tablaSolicitudes.getRowCount()-1, 0);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getSolicitante().getPrioridad(), tablaSolicitudes.getRowCount()-1, 1);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getSolicitud().getEstado(), tablaSolicitudes.getRowCount()-1, 2);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getFechaFin(), tablaSolicitudes.getRowCount()-1, 3);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), tablaSolicitudes.getRowCount()-1, 4);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getHoraInicial(), tablaSolicitudes.getRowCount()-1, 5);
                tablaSolicitudes.setValueAt(esp.getAgenda(i).getLineaAgenda().getHoraFinal(), tablaSolicitudes.getRowCount()-1, 6);
            }
        }
    }    
    
    //Funcion que coloca la actividad en la tabla del espacio una vez que se halla aprobado la solicitud
    //NOTA: fehca-> fecha de la solicitud
    public void colocarAgenda(String fecha, int i,String horaInicio, String horaFinal){
        String fechaSeparada[] = fecha.split("/");//fechaSeparada[0]=dia fechaSeparada[1]=mes fechaSeparada[2]=año
        String horaIni[] = horaInicio.split(":");
        String horaF[] = horaFinal.split(":");
        int horaI = Integer.parseInt(horaIni[0]);
        int horaFi = Integer.parseInt(horaF[0]);
        int fechaAgenda=DiaFecha.diaDeLaSemana(Integer.parseInt(fechaSeparada[0]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[2]));
        switch(fechaAgenda){
            case 1 -> {
                for(int j=0;j<horaFi-horaI;j++){
                    tablaEspacios.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), (horaI-7)+j, fechaAgenda);
                }
            }
            case 2 -> {
                for(int j=0;j<horaFi-horaI;j++){
                    tablaEspacios.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), (horaI-7)+j, fechaAgenda);
                }
            }
            case 3 -> {
                for(int j=0;j<horaFi-horaI;j++){
                    tablaEspacios.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), (horaI-7)+j, fechaAgenda);
                }
            }
            case 4 -> {
                for(int j=0;j<horaFi-horaI;j++){
                    tablaEspacios.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), (horaI-7)+j, fechaAgenda);
                }
            }
            case 5 -> {
                for(int j=0;j<horaFi-horaI;j++){
                    tablaEspacios.setValueAt(esp.getAgenda(i).getLineaAgenda().getActividad(), (horaI-7)+j, fechaAgenda);
                }
            }
            default -> JOptionPane.showMessageDialog(null,"El día de la solicitud no es valido");
        }
    }
    
    public void Espacios(){  
        if(view.cmbAula.getItemCount()>0) view.cmbAula.removeAllItems();
        for(Edificio ed:listas.getListaEdificios()){
            for(Espacio es:ed.getListaEspacios()){
                view.cmbAula.addItem(es.getCodigo());
            }
        }
    }
    
    public void ListaEspacios(){
        AbrirVentana(tabla,"Tabla Espacios");
        String col[] = {"EDIFICIO","CODIGO","DESCRIPCION","UBICACION","TIPO","CAPACIDAD"};
        ctrlTabla.Inicio(col,4);
        for(Edificio ed:listas.getListaEdificios()){
            for(Espacio es:ed.getListaEspacios()){
                Vector fila = es.getDatos();
                fila.add(0, ed.getCodigo());
                ctrlTabla.AgregarFila(fila);
            }
        }
    }
    
    public void VerificarEncargado(){
        for(Edificio ed:listas.getListaEdificios()){
            int aux = ed.buscarEspacio((String) view.cmbAula.getSelectedItem());
            System.out.println("Espacio" + aux);
            
            if(aux!=-1){
                int aux2 = ed.getEspacio(aux).buscarCorreoEncargado(listas.getIngreso());
                System.out.println("Encargado" + aux2);
                
                if(aux2!=-1) view.PanelEncargado.setVisible(true);
                else view.PanelEncargado.setVisible(false);
            }
        }
    }
    
    public void AbrirVentana(JFrame ventan,String nom){
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        view.setVisible(false);
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.btnCerrar) AbrirVentana(menu, "Menu Principal");
        if(e.getSource()==view.btnEspacios) ListaEspacios();
        if(e.getSource()==view.btnAcepSoli){
            int estado=JOptionPane.showConfirmDialog(null, "Está seguro que desea agregar a la agenda la actividad: "+"\n"+
                    esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getActividad());//Se muestra un cuadro de confirmacion
            if(estado==0){//En caso de que estado sea afirmativo
                esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getSolicitud().setEstado("Aprobado");
                tablaSolicitudes.setValueAt(esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getSolicitud().getEstado(), view.tablaSolicitudes.getSelectedRow(), 2);
                colocarAgenda(esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getFechaFin(), view.tablaSolicitudes.getSelectedRow(),
                    esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getHoraInicial(),
                    esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getHoraFinal());
            }
        }
        if(e.getSource()==view.btnRechSoli){
            esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getSolicitud().setEstado("Rechazado");
            tablaSolicitudes.setValueAt(esp.getAgenda(view.tablaSolicitudes.getSelectedRow()).getLineaAgenda().getSolicitud().getEstado(), view.tablaSolicitudes.getSelectedRow(), 2);
            //Agregar método de enviar correo
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==view.cmbAula) VerificarEncargado();
    }
    
    //Devuelve la seleccion de la fila que se desea aceptar o rechazar
    @Override
    public void mouseClicked(MouseEvent ev){
        if(ev.getSource().equals(view.tablaSolicitudes)){
            System.out.println(""+view.tablaSolicitudes.getSelectedRow());
        }     
    }
    
}
