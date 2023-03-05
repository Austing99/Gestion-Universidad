/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Austin
 */
public class GestionEspacios extends javax.swing.JFrame {

    /**
     * Creates new form IngresarEspacio
     */
    public GestionEspacios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        pnlElementos = new javax.swing.JPanel();
        btnListaElementos = new javax.swing.JButton();
        txtDescEle = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        btnNuevoElem = new javax.swing.JButton();
        btnGrabarElem = new javax.swing.JButton();
        btnEliminarElem = new javax.swing.JButton();
        btnCancelarElem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbEdiElem = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblTituloTabla1 = new javax.swing.JLabel();
        cmbEspacio = new javax.swing.JComboBox<>();
        pnlEspacios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbEdificio = new javax.swing.JComboBox<>();
        txtCapacidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbPlanta = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnListasEspacios = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTituloTabla2 = new javax.swing.JLabel();
        btnAddEncar = new javax.swing.JButton();
        btnElimEncar = new javax.swing.JButton();
        btnMostEncar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("High Tower Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión Espacios");

        btnCerrar.setBackground(new java.awt.Color(0, 0, 102));
        btnCerrar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnListaElementos.setBackground(new java.awt.Color(200, 30, 0));
        btnListaElementos.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnListaElementos.setForeground(new java.awt.Color(255, 255, 255));
        btnListaElementos.setText("Lista Elementos");
        btnListaElementos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDescEle.setMaximumSize(new java.awt.Dimension(72, 22));
        txtDescEle.setMinimumSize(new java.awt.Dimension(72, 22));
        txtDescEle.setPreferredSize(new java.awt.Dimension(72, 22));

        lbl5.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(0, 0, 102));
        lbl5.setText("Descripción:");

        txtCantidad.setMaximumSize(new java.awt.Dimension(72, 22));
        txtCantidad.setMinimumSize(new java.awt.Dimension(72, 22));
        txtCantidad.setPreferredSize(new java.awt.Dimension(72, 22));

        lbl6.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        lbl6.setForeground(new java.awt.Color(0, 0, 102));
        lbl6.setText("Cantidad:");

        btnNuevoElem.setBackground(new java.awt.Color(200, 30, 0));
        btnNuevoElem.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnNuevoElem.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoElem.setText("Nuevo");
        btnNuevoElem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGrabarElem.setBackground(new java.awt.Color(200, 30, 0));
        btnGrabarElem.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnGrabarElem.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabarElem.setText("Grabar");
        btnGrabarElem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnEliminarElem.setBackground(new java.awt.Color(200, 30, 0));
        btnEliminarElem.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnEliminarElem.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarElem.setText("Eliminar");
        btnEliminarElem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancelarElem.setBackground(new java.awt.Color(200, 30, 0));
        btnCancelarElem.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnCancelarElem.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarElem.setText("Cancelar");
        btnCancelarElem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Edificio:");

        cmbEdiElem.setMaximumSize(new java.awt.Dimension(72, 22));

        jLabel8.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Espacio:");

        lblTituloTabla1.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        lblTituloTabla1.setForeground(new java.awt.Color(200, 30, 0));
        lblTituloTabla1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTabla1.setText("Gestión Elementos");

        cmbEspacio.setMaximumSize(new java.awt.Dimension(72, 22));

        javax.swing.GroupLayout pnlElementosLayout = new javax.swing.GroupLayout(pnlElementos);
        pnlElementos.setLayout(pnlElementosLayout);
        pnlElementosLayout.setHorizontalGroup(
            pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTituloTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlElementosLayout.createSequentialGroup()
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(lbl5)
                            .addComponent(lbl6))
                        .addGap(92, 92, 92)
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEdiElem, 0, 220, Short.MAX_VALUE)
                            .addComponent(cmbEspacio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescEle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoElem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrabarElem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarElem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarElem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlElementosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListaElementos)
                .addContainerGap())
        );
        pnlElementosLayout.setVerticalGroup(
            pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloTabla1)
                .addGap(18, 18, 18)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbEdiElem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevoElem)))
                .addGap(18, 18, 18)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabarElem))
                .addGap(18, 18, 18)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl5)
                    .addComponent(txtDescEle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarElem))
                .addGap(18, 18, 18)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarElem))
                .addGap(18, 18, 18)
                .addComponent(btnListaElementos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Edificio:");

        cmbEdificio.setMaximumSize(new java.awt.Dimension(72, 22));

        txtCapacidad.setMaximumSize(new java.awt.Dimension(72, 22));
        txtCapacidad.setMinimumSize(new java.awt.Dimension(72, 22));
        txtCapacidad.setPreferredSize(new java.awt.Dimension(72, 22));

        txtDescripcion.setMaximumSize(new java.awt.Dimension(72, 22));
        txtDescripcion.setMinimumSize(new java.awt.Dimension(72, 22));
        txtDescripcion.setPreferredSize(new java.awt.Dimension(72, 22));

        txtCodigo.setMaximumSize(new java.awt.Dimension(72, 22));
        txtCodigo.setMinimumSize(new java.awt.Dimension(72, 22));
        txtCodigo.setPreferredSize(new java.awt.Dimension(72, 22));

        lbl3.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(0, 0, 102));
        lbl3.setText("Codigo:");

        jLabel5.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Descripcion:");

        label.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(0, 0, 102));
        label.setText("Planta:");

        jLabel6.setFont(new java.awt.Font("High Tower Text", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Capacidad:");

        cmbPlanta.setMaximumSize(new java.awt.Dimension(72, 22));

        cmbTipo.setMaximumSize(new java.awt.Dimension(72, 22));

        btnNuevo.setBackground(new java.awt.Color(0, 0, 102));
        btnNuevo.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 102));
        btnActualizar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGrabar.setBackground(new java.awt.Color(0, 0, 102));
        btnGrabar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setText("Grabar");
        btnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 102));
        btnEliminar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 102));
        btnCancelar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnListasEspacios.setBackground(new java.awt.Color(0, 0, 102));
        btnListasEspacios.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnListasEspacios.setForeground(new java.awt.Color(255, 255, 255));
        btnListasEspacios.setText("Lista Espacios");
        btnListasEspacios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlEspaciosLayout = new javax.swing.GroupLayout(pnlEspacios);
        pnlEspacios.setLayout(pnlEspaciosLayout);
        pnlEspaciosLayout.setHorizontalGroup(
            pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspaciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label)
                    .addComponent(lbl3)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(104, 104, 104)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbTipo, 0, 220, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPlanta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEdificio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListasEspacios, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEspaciosLayout.setVerticalGroup(
            pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspaciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(cmbPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(pnlEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListasEspacios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTituloTabla2.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        lblTituloTabla2.setForeground(new java.awt.Color(200, 30, 0));
        lblTituloTabla2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTabla2.setText("Gestión Encargados");

        btnAddEncar.setBackground(new java.awt.Color(0, 0, 102));
        btnAddEncar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnAddEncar.setForeground(new java.awt.Color(255, 255, 255));
        btnAddEncar.setText("Agregar Encargado");
        btnAddEncar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnElimEncar.setBackground(new java.awt.Color(0, 0, 102));
        btnElimEncar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnElimEncar.setForeground(new java.awt.Color(255, 255, 255));
        btnElimEncar.setText("Eliminar Encargado");
        btnElimEncar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnMostEncar.setBackground(new java.awt.Color(0, 0, 102));
        btnMostEncar.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        btnMostEncar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostEncar.setText("Listar Encargados");
        btnMostEncar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddEncar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnElimEncar)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostEncar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTituloTabla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloTabla2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEncar)
                    .addComponent(btnElimEncar)
                    .addComponent(btnMostEncar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionEspacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEspacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEspacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEspacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEspacios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAddEncar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCancelarElem;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnElimEncar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEliminarElem;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnGrabarElem;
    public javax.swing.JButton btnListaElementos;
    public javax.swing.JButton btnListasEspacios;
    public javax.swing.JButton btnMostEncar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnNuevoElem;
    public javax.swing.JComboBox<String> cmbEdiElem;
    public javax.swing.JComboBox<String> cmbEdificio;
    public javax.swing.JComboBox<String> cmbEspacio;
    public javax.swing.JComboBox<String> cmbPlanta;
    public javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    public javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTituloTabla1;
    private javax.swing.JLabel lblTituloTabla2;
    private javax.swing.JPanel pnlElementos;
    private javax.swing.JPanel pnlEspacios;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCapacidad;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDescEle;
    public javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
