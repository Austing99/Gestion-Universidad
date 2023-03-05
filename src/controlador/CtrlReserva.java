package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Agenda;
import modelo.Espacio;
import modelo.LineaAgenda;
import modelo.Listas;
import modelo.Solicitante;
import modelo.Solicitud;
import vista.MenuPrincipal;
import vista.Reserva;

public class CtrlReserva implements ActionListener,ItemListener{
    private Reserva view;
    private MenuPrincipal menu;
    private Listas lista;
    private CtrlAgenda ctrlAgenda;
    //Icono
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlReserva(MenuPrincipal menu, Reserva view, Listas lista, CtrlAgenda ctrlAgenda) {
        this.menu = menu;
        this.view = view;
        this.lista = lista;
        this.ctrlAgenda = ctrlAgenda;
        
        //Botones
        this.view.btnSolicitar.addActionListener(this);
        this.view.btnCerrarReserva.addActionListener(this);
        this.view.rbtnDia.addActionListener(this);
        this.view.rbtnVariosDias.addActionListener(this);
        
        //CmbBox
        this.view.cmbEdificio.addItemListener(this);
    }
    
    public void Iniciar(){
        IniciarVista();
        CargarComboEdificios();
        CargarCombosHora(view.cmb_HoraIni, 7, 20);
        CargarCombosHora(view.cmb_HoraFin, 8, 21);
        
        view.rbtnDia.setSelected(false);
        view.rbtnVariosDias.setSelected(false);
    }
    
    private void IniciarVista() {
        view.rbtnDia.setSelected(false);
        view.rbtnDia.setSelected(false);
        view.txtDia1.setEnabled(false);
        view.txtAnio1.setEnabled(false);
        view.txtMes1.setEnabled(false);
        
        view.rbtnVariosDias.setSelected(false);
        view.txtDiaN.setEnabled(false);
        view.txtAnioN.setEnabled(false);
        view.txtMesN.setEnabled(false);
        view.txtDiaN2.setEnabled(false);
        view.txtAnioN2.setEnabled(false);
        view.txtMesN2.setEnabled(false);
    }
    
    public void CargarComboEdificios(){
        if(view.cmbEdificio.getItemCount()>0) view.cmbEdificio.removeAllItems();
        
        for(int i=0; i<lista.TamanioListaEdificios();i++){
            view.cmbEdificio.addItem(lista.getEdificio(i).getCodigo());
        }
    }
    
    public void CargarComboAulas(){
        if(view.cmbAula.getItemCount()>0) view.cmbAula.removeAllItems();
        
        int index = lista.buscarEdificio((String) view.cmbEdificio.getSelectedItem());
        
        if(index!=-1){
            for(Espacio es:lista.getEdificio(index).getListaEspacios()) view.cmbAula.addItem(es.getCodigo());
        }
    }

    private void CargarCombosHora(JComboBox combo,int inicio,int fin) {
        if(combo.getItemCount()>0) combo.removeAllItems();
        
        for(int i=inicio;i<=fin;i++){
            if(i<10) combo.addItem("0"+i+":00");
            else combo.addItem(i+":00");
        }
    }
    
    public void ActivarTextosDia(boolean estado){
        view.txtDia1.setEnabled(estado);
        view.txtAnio1.setEnabled(estado);
        view.txtMes1.setEnabled(estado);
        
        view.txtDiaN.setEnabled(!estado);
        view.txtAnioN.setEnabled(!estado);
        view.txtMesN.setEnabled(!estado);
        view.txtDiaN2.setEnabled(!estado);
        view.txtAnioN2.setEnabled(!estado);
        view.txtMesN2.setEnabled(!estado);
    }
    
    public void Solicitar(){
        Espacio esp = BuscarEspacio((String) view.cmbEdificio.getSelectedItem(),
                (String) view.cmbAula.getSelectedItem());
        
        if(esp!=null){
            int index = lista.buscarCorreo(lista.getIngreso());
            Solicitante solicitante = new Solicitante(lista.getUsuario(index));
            
            Solicitud solicitud = new Solicitud(esp.GenerarCodigoReserva(), "En espera");
            
            LineaAgenda linAgen = new LineaAgenda((String) view.cmb_HoraIni.getSelectedItem(),
                    (String) view.cmb_HoraFin.getSelectedItem(),view.txtActividad.getText(),
                    solicitante,solicitud);
            
            Agenda nuevo = new Agenda();
            
            if(view.rbtnDia.isSelected()){
                String fecha = view.txtDia1.getText()+"/"+view.txtMes1.getText()+"/"+view.txtAnio1.getText();
                nuevo.setFechaInicio(fecha);
                nuevo.setFechaFin(fecha);
            }
            if(view.rbtnVariosDias.isSelected()){
                String fechaI = view.txtDiaN.getText()+"/"+view.txtMesN.getText()+"/"+view.txtAnioN.getText();
                String fechaF = view.txtDiaN2.getText()+"/"+view.txtMesN2.getText()+"/"+view.txtAnioN2.getText();
                nuevo.setFechaInicio(fechaI);
                nuevo.setFechaFin(fechaF);
            }
            
            nuevo.setLineaAgenda(linAgen);
            
            esp.AgregarAgenda(nuevo);
            
            ctrlAgenda.inicio(esp);
            ctrlAgenda.setTablaSolicitudes1();//Cambiar esto se daña cuando se crea mas de una solicitud en la misma ejecucion
            JOptionPane.showMessageDialog(null, "Solicitud Enviada");
            
            LimpiarVista();
            IniciarVista();
        }
    }
    
    public Espacio BuscarEspacio(String edificio, String espacio){
        int index = lista.buscarEdificio(edificio);
        if(index!=-1){
            for(Espacio es:lista.getEdificio(index).getListaEspacios()){
                if(es.getCodigo().equals(espacio)) return es;
            }
        }
        return null;
    }
    
    public void LimpiarVista(){
        view.txtTipo.setText("");
        view.txtCapacidad.setText("");
        view.txtActividad.setText("");
        
        view.txtDia1.setText("");
        view.txtAnio1.setText("");
        view.txtMes1.setText("");
        
        view.txtDiaN.setText("");
        view.txtAnioN.setText("");
        view.txtMesN.setText("");
        view.txtDiaN2.setText("");
        view.txtAnioN2.setText("");
        view.txtMesN2.setText("");
    }

    private void AbrirVentana(JFrame ventan, String nom) {
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
        view.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.btnSolicitar) Solicitar();
        if(e.getSource()==view.btnCerrarReserva) AbrirVentana(menu, "Menú Principal");
        //Radio button
        if(e.getSource()==view.rbtnDia) ActivarTextosDia(true);
        if(e.getSource()==view.rbtnVariosDias) ActivarTextosDia(false);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==view.cmbEdificio) CargarComboAulas();
    }
}
