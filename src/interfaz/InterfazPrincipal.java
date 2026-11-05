package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import estructuras.ListaDoble;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mundo.Administrativo;
import mundo.Campus;
import mundo.CampusException;
import mundo.Directivo;
import mundo.Director;
import mundo.Estudiante;
import mundo.Persona;
import mundo.Profesor;

public class InterfazPrincipal extends JFrame
{
    private static final long serialVersionUID = 1L;

    private Campus campus;

    private JComboBox<String> comboTipo;

    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JTextField txtCodigoInstitucional;
    private JTextField txtDato1;
    private JTextField txtDato2;
    private JTextField txtBuscar;

    private JLabel lblCodigoInstitucional;
    private JLabel lblDato1;
    private JLabel lblDato2;
    private JLabel lblResumenTotales;

    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private JButton btnBuscar;
    private JButton btnResumen;
    private JButton btnOrdenar;
    private JButton btnFiltrar;
    private JButton btnRestaurar;

    private JLabel lblEstructuras;

    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;

    private String documentoSeleccionado;

    public InterfazPrincipal()
    {
        campus = new Campus();

        documentoSeleccionado = null;

        setTitle("Sistema de Gestión de Campus");

        setSize(1050, 620);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        inicializarInterfaz();

        actualizarCamposPorTipo();

        actualizarTabla();
    }

    private void inicializarInterfaz()
    {
        setLayout(new BorderLayout(10, 10));

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelPrincipal.add(crearPanelEncabezado(), BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(2, 1, 10, 10));

        panelCentro.add(crearPanelDatosPersona());

        panelCentro.add(crearPanelTabla());

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        add(panelPrincipal, BorderLayout.CENTER);
    }

    private JPanel crearPanelEncabezado()
    {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.createLineBorder(new Color(140, 160, 190), 2));

        panel.setBackground(new Color(235, 240, 248));

        JPanel panelIzquierdo = new JPanel(new GridLayout(2, 1));

        panelIzquierdo.setBackground(new Color(235, 240, 248));

        JLabel lblUniversidad = new JLabel("Universidad de Ibagué");

        lblUniversidad.setFont(new Font("Arial", Font.BOLD, 20));

        lblUniversidad.setForeground(new Color(30, 80, 150));

        JLabel lblPrograma = new JLabel("Ingeniería de Sistemas");

        lblPrograma.setFont(new Font("Arial", Font.PLAIN, 16));

        lblPrograma.setForeground(new Color(30, 80, 150));

        panelIzquierdo.add(lblUniversidad);

        panelIzquierdo.add(lblPrograma);

        JPanel panelDerecho = new JPanel(new GridLayout(2, 1));

        panelDerecho.setBackground(new Color(235, 240, 248));

        JLabel lblTitulo = new JLabel("Gestión de Campus", SwingConstants.RIGHT);

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));

        lblTitulo.setForeground(new Color(20, 60, 120));

        JLabel lblSubtitulo = new JLabel("Gestión de personas", SwingConstants.RIGHT);

        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 18));

        lblSubtitulo.setForeground(new Color(80, 80, 80));

        panelDerecho.add(lblTitulo);

        panelDerecho.add(lblSubtitulo);

        panel.add(panelIzquierdo, BorderLayout.WEST);

        panel.add(panelDerecho, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearPanelDatosPersona()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(new TitledBorder("Datos de la persona"));

        JPanel formulario = new JPanel(new GridLayout(4, 4, 10, 10));

        String[] tipos = { "Estudiante", "Profesor", "Administrativo", "Directivo", "Director" };

        comboTipo = new JComboBox<>(tipos);

        txtDocumento = new JTextField();

        txtNombre = new JTextField();

        txtCorreo = new JTextField();

        txtCodigoInstitucional = new JTextField();

        txtDato1 = new JTextField();

        txtDato2 = new JTextField();

        lblCodigoInstitucional = new JLabel("Código:");

        lblDato1 = new JLabel("Dato 1:");

        lblDato2 = new JLabel("Dato 2:");

        formulario.add(new JLabel("Tipo:"));

        formulario.add(comboTipo);

        formulario.add(new JLabel("Documento:"));

        formulario.add(txtDocumento);

        formulario.add(new JLabel("Nombre:"));

        formulario.add(txtNombre);

        formulario.add(new JLabel("Correo:"));

        formulario.add(txtCorreo);

        formulario.add(lblCodigoInstitucional);

        formulario.add(txtCodigoInstitucional);

        formulario.add(lblDato1);

        formulario.add(txtDato1);

        formulario.add(lblDato2);

        formulario.add(txtDato2);

        formulario.add(new JLabel(""));

        formulario.add(new JLabel(""));

        btnAgregar = new JButton("Agregar");

        btnModificar = new JButton("Modificar");

        btnEliminar = new JButton("Eliminar");

        btnLimpiar = new JButton("Limpiar");

        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 10, 10));

        panelBotones.add(btnAgregar);

        panelBotones.add(btnModificar);

        panelBotones.add(btnEliminar);

        panelBotones.add(btnLimpiar);

        panel.add(formulario, BorderLayout.CENTER);

        panel.add(panelBotones, BorderLayout.SOUTH);

        comboTipo.addActionListener(e -> actualizarCamposPorTipo());

        btnAgregar.addActionListener(e -> agregarPersona());

        btnModificar.addActionListener(e -> modificarPersona());

        btnEliminar.addActionListener(e -> eliminarPersona());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        return panel;
    }

    private JPanel crearPanelTabla()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(new TitledBorder("Personas registradas"));

        modeloTabla = new DefaultTableModel(new Object[] { "Documento", "Nombre", "Tipo", "Programa / Área" }, 0)
        {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        tablaPersonas = new JTable(modeloTabla);

        tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tablaPersonas);

        JPanel panelInferior = new JPanel(new GridLayout(4, 1, 5, 5));

        JPanel panelBusqueda = new JPanel(new GridLayout(1, 5, 10, 10));

        txtBuscar = new JTextField();

        btnBuscar = new JButton("Buscar");

        btnResumen = new JButton("Ver resumen");

        btnFiltrar = new JButton("Filtrar");

        panelBusqueda.add(new JLabel("Buscar por documento:"));

        panelBusqueda.add(txtBuscar);

        panelBusqueda.add(btnBuscar);

        panelBusqueda.add(btnResumen);

        panelBusqueda.add(btnFiltrar);

        JPanel panelAcciones = new JPanel(new GridLayout(1, 2, 10, 10));

        btnOrdenar = new JButton("Ordenar por nombre");

        btnRestaurar = new JButton("Restaurar eliminado");

        panelAcciones.add(btnOrdenar);

        panelAcciones.add(btnRestaurar);

        lblEstructuras = new JLabel();

        lblEstructuras.setHorizontalAlignment(SwingConstants.RIGHT);

        lblEstructuras.setForeground(new Color(30, 80, 150));

        lblResumenTotales = new JLabel();

        lblResumenTotales.setHorizontalAlignment(SwingConstants.RIGHT);

        panelInferior.add(panelBusqueda);

        panelInferior.add(panelAcciones);

        panelInferior.add(lblEstructuras);

        panelInferior.add(lblResumenTotales);

        panel.add(scroll, BorderLayout.CENTER);

        panel.add(panelInferior, BorderLayout.SOUTH);

        btnBuscar.addActionListener(e -> buscarPersona());

        btnResumen.addActionListener(e -> verResumen());

        btnOrdenar.addActionListener(e -> ordenarPersonas());

        btnFiltrar.addActionListener(e -> filtrarPersonas());

        btnRestaurar.addActionListener(e -> restaurarEliminado());

        tablaPersonas.getSelectionModel().addListSelectionListener(e ->
        {
            if (!e.getValueIsAdjusting() && tablaPersonas.getSelectedRow() != -1)
            {
                int fila = tablaPersonas.getSelectedRow();

                String documento = modeloTabla.getValueAt(fila, 0).toString();

                Persona persona = campus.buscarPersona(documento);

                if (persona != null)
                {
                    cargarPersonaEnFormulario(persona);
                }
            }
        });

        return panel;
    }

    private void actualizarCamposPorTipo()
    {
        if (comboTipo == null)
        {
            return;
        }

        String tipo = comboTipo.getSelectedItem().toString();

        txtCodigoInstitucional.setText("");

        txtDato1.setText("");

        txtDato2.setText("");

        if (tipo.equals("Estudiante"))
        {
            lblCodigoInstitucional.setText("Código estudiante:");

            lblDato1.setText("Programa:");

            lblDato2.setVisible(false);

            txtDato2.setVisible(false);
        }
        else if (tipo.equals("Profesor"))
        {
            lblCodigoInstitucional.setText("Código empleado:");

            lblDato1.setText("Área:");

            lblDato2.setVisible(false);

            txtDato2.setVisible(false);
        }
        else if (tipo.equals("Administrativo"))
        {
            lblCodigoInstitucional.setText("Código empleado:");

            lblDato1.setText("Área:");

            lblDato2.setText("Cargo:");

            lblDato2.setVisible(true);

            txtDato2.setVisible(true);
        }
        else if (tipo.equals("Directivo"))
        {
            lblCodigoInstitucional.setText("Código empleado:");

            lblDato1.setText("Área:");

            lblDato2.setText("Cargo:");

            lblDato2.setVisible(true);

            txtDato2.setVisible(true);
        }
        else if (tipo.equals("Director"))
        {
            lblCodigoInstitucional.setText("Código empleado:");

            lblDato1.setText("Área:");

            lblDato2.setText("Programa dirigido:");

            lblDato2.setVisible(true);

            txtDato2.setVisible(true);
        }

        repaint();

        revalidate();
    }

    private void agregarPersona()
    {
        try
        {
            String tipo = comboTipo.getSelectedItem().toString();

            String documento = txtDocumento.getText().trim();

            String nombre = txtNombre.getText().trim();

            String correo = txtCorreo.getText().trim();

            String codigo = txtCodigoInstitucional.getText().trim();

            String dato1 = txtDato1.getText().trim();

            String dato2 = txtDato2.getText().trim();

            validarCampos(tipo, documento, nombre, correo, codigo, dato1, dato2);

            Persona persona = construirPersona(tipo, documento, nombre, correo, codigo, dato1, dato2);

            campus.agregarPersona(persona);

            JOptionPane.showMessageDialog(this, "Persona agregada correctamente.");

            actualizarTabla();

            limpiarCampos();
        }
        catch (CampusException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarPersona()
    {
        try
        {
            String documentoBase = documentoSeleccionado;

            if (documentoBase == null || documentoBase.isEmpty())
            {
                documentoBase = txtDocumento.getText().trim();
            }

            Persona persona = campus.buscarPersona(documentoBase);

            if (persona == null)
            {
                JOptionPane.showMessageDialog(this, "No se encontró la persona a modificar.");

                return;
            }

            String nuevoDocumento = txtDocumento.getText().trim();

            String nombre = txtNombre.getText().trim();

            String correo = txtCorreo.getText().trim();

            String codigo = txtCodigoInstitucional.getText().trim();

            String dato1 = txtDato1.getText().trim();

            String dato2 = txtDato2.getText().trim();

            String tipo = comboTipo.getSelectedItem().toString();

            validarCampos(tipo, nuevoDocumento, nombre, correo, codigo, dato1, dato2);

            if (!nuevoDocumento.equals(documentoBase))
            {
                Persona otra = campus.buscarPersona(nuevoDocumento);

                if (otra != null)
                {
                    JOptionPane.showMessageDialog(this, "Ya existe otra persona con ese documento.");

                    return;
                }

                persona.setNumeroDocumento(nuevoDocumento);
            }

            persona.setNombre(nombre);

            persona.setCorreo(correo);

            if (persona instanceof Estudiante)
            {
                Estudiante estudiante = (Estudiante) persona;

                estudiante.setCodigoEstudiante(codigo);

                estudiante.setPrograma(dato1);
            }
            else if (persona instanceof Profesor)
            {
                Profesor profesor = (Profesor) persona;

                profesor.setCodigoEmpleado(codigo);

                profesor.setArea(dato1);
            }
            else if (persona instanceof Administrativo)
            {
                Administrativo administrativo = (Administrativo) persona;

                administrativo.setCodigoEmpleado(codigo);

                administrativo.setArea(dato1);

                administrativo.setCargo(dato2);
            }
            else if (persona instanceof Director)
            {
                Director director = (Director) persona;

                director.setCodigoEmpleado(codigo);

                director.setArea(dato1);

                director.setPrograma(dato2);
            }
            else if (persona instanceof Directivo)
            {
                Directivo directivo = (Directivo) persona;

                directivo.setCodigoEmpleado(codigo);

                directivo.setArea(dato1);

                directivo.setCargo(dato2);
            }

            JOptionPane.showMessageDialog(this, "Persona modificada correctamente.");

            actualizarTabla();

            limpiarCampos();
        }
        catch (CampusException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPersona()
    {
        try
        {
            String documento = documentoSeleccionado;

            if (documento == null || documento.isEmpty())
            {
                documento = txtDocumento.getText().trim();
            }

            if (documento.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Ingrese o seleccione un documento.");

                return;
            }

            Persona persona = campus.buscarPersona(documento);

            if (persona == null)
            {
                JOptionPane.showMessageDialog(this, "No se encontró la persona.");

                return;
            }

            campus.eliminarPersona(documento);

            JOptionPane.showMessageDialog(this, "Persona eliminada correctamente.");

            actualizarTabla();

            limpiarCampos();
        }
        catch (CampusException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPersona()
    {
        String documento = txtBuscar.getText().trim();

        if (documento.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ingrese un documento para buscar.");

            return;
        }

        Persona persona = campus.buscarPersona(documento);

        if (persona == null)
        {
            JOptionPane.showMessageDialog(this, "No se encontró una persona con ese documento.");

            return;
        }

        cargarPersonaEnFormulario(persona);

        seleccionarPersonaEnTabla(documento);
    }

    private void ordenarPersonas()
    {
        if (campus.darPersonas().estaVacia())
        {
            JOptionPane.showMessageDialog(this, "No hay personas registradas para ordenar.");

            return;
        }

        campus.ordenarPorNombre();

        actualizarTabla();

        JOptionPane.showMessageDialog(this, "Personas ordenadas alfabéticamente por nombre.", "Ordenamiento", JOptionPane.INFORMATION_MESSAGE);
    }

    private void restaurarEliminado()
    {
        try
        {
            Persona persona = campus.restaurarUltimoEliminado();

            actualizarTabla();

            JOptionPane.showMessageDialog(this, "Se restauró a " + persona.getNombre() + ".", "Pila de eliminados", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (CampusException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filtrarPersonas()
    {
        String texto = txtBuscar.getText().trim();

        if (texto.isEmpty())
        {
            actualizarTabla();

            JOptionPane.showMessageDialog(this, "Se muestran todas las personas registradas.");

            return;
        }

        try
        {
            ListaDoble<Persona> filtradas = campus.filtrarPorProgramaOArea(texto);

            if (filtradas.estaVacia())
            {
                JOptionPane.showMessageDialog(this, "No hay personas registradas en \"" + texto + "\".");

                return;
            }

            modeloTabla.setRowCount(0);

            for (int i = 0; i < filtradas.getTamanio(); i++)
            {
                Persona persona = filtradas.obtener(i);

                Object[] fila = new Object[4];

                fila[0] = persona.getNumeroDocumento();

                fila[1] = persona.getNombre();

                fila[2] = persona.getTipo();

                fila[3] = obtenerDatoTabla(persona);

                modeloTabla.addRow(fila);
            }

            JOptionPane.showMessageDialog(this, "Personas encontradas: " + filtradas.getTamanio() + ".\nDeje el campo vacío y presione Filtrar para ver todas.", "Filtro por programa o área", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (CampusException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionarPersonaEnTabla(String documento)
    {
        for (int i = 0; i < modeloTabla.getRowCount(); i++)
        {
            if (modeloTabla.getValueAt(i, 0).toString().equals(documento))
            {
                tablaPersonas.setRowSelectionInterval(i, i);

                break;
            }
        }
    }

    private void verResumen()
    {
        Persona persona = null;

        if (documentoSeleccionado != null)
        {
            persona = campus.buscarPersona(documentoSeleccionado);
        }

        if (persona == null)
        {
            String documento = txtBuscar.getText().trim();

            if (!documento.isEmpty())
            {
                persona = campus.buscarPersona(documento);
            }
        }

        if (persona == null)
        {
            JOptionPane.showMessageDialog(this, "Seleccione o busque una persona primero.");

            return;
        }

        JOptionPane.showMessageDialog(this, persona.resumen(), "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cargarPersonaEnFormulario(Persona persona)
    {
        documentoSeleccionado = persona.getNumeroDocumento();

        txtDocumento.setText(persona.getNumeroDocumento());

        txtNombre.setText(persona.getNombre());

        txtCorreo.setText(persona.getCorreo());

        if (persona instanceof Estudiante)
        {
            Estudiante estudiante = (Estudiante) persona;

            comboTipo.setSelectedItem("Estudiante");

            txtCodigoInstitucional.setText(estudiante.getCodigoEstudiante());

            txtDato1.setText(estudiante.getPrograma());

            txtDato2.setText("");
        }
        else if (persona instanceof Profesor)
        {
            Profesor profesor = (Profesor) persona;

            comboTipo.setSelectedItem("Profesor");

            txtCodigoInstitucional.setText(profesor.getCodigoEmpleado());

            txtDato1.setText(profesor.getArea());

            txtDato2.setText("");
        }
        else if (persona instanceof Administrativo)
        {
            Administrativo administrativo = (Administrativo) persona;

            comboTipo.setSelectedItem("Administrativo");

            txtCodigoInstitucional.setText(administrativo.getCodigoEmpleado());

            txtDato1.setText(administrativo.getArea());

            txtDato2.setText(administrativo.getCargo());
        }
        else if (persona instanceof Director)
        {
            Director director = (Director) persona;

            comboTipo.setSelectedItem("Director");

            txtCodigoInstitucional.setText(director.getCodigoEmpleado());

            txtDato1.setText(director.getArea());

            txtDato2.setText(director.getPrograma());
        }
        else if (persona instanceof Directivo)
        {
            Directivo directivo = (Directivo) persona;

            comboTipo.setSelectedItem("Directivo");

            txtCodigoInstitucional.setText(directivo.getCodigoEmpleado());

            txtDato1.setText(directivo.getArea());

            txtDato2.setText(directivo.getCargo());
        }
    }

    private Persona construirPersona(String tipo, String documento, String nombre, String correo, String codigo, String dato1, String dato2)
    {
        if (tipo.equals("Estudiante"))
        {
            return new Estudiante(documento, nombre, correo, codigo, dato1);
        }
        else if (tipo.equals("Profesor"))
        {
            return new Profesor(documento, nombre, correo, codigo, dato1);
        }
        else if (tipo.equals("Administrativo"))
        {
            return new Administrativo(documento, nombre, correo, codigo, dato1, dato2);
        }
        else if (tipo.equals("Directivo"))
        {
            return new Directivo(documento, nombre, correo, codigo, dato1, dato2);
        }
        else
        {
            return new Director(documento, nombre, correo, codigo, dato1, dato2);
        }
    }

    private void validarCampos(String tipo, String documento, String nombre, String correo, String codigo, String dato1, String dato2) throws CampusException
    {
        if (documento.isEmpty() || nombre.isEmpty() || correo.isEmpty() || codigo.isEmpty() || dato1.isEmpty())
        {
            throw new CampusException("Debe completar todos los campos obligatorios.");
        }

        if ((tipo.equals("Administrativo") || tipo.equals("Directivo") || tipo.equals("Director")) && dato2.isEmpty())
        {
            throw new CampusException("Debe completar todos los campos obligatorios.");
        }
    }

    private void actualizarTabla()
    {
        modeloTabla.setRowCount(0);

        for (int i = 0; i < campus.darPersonas().getTamanio(); i++)
        {
            Persona persona = campus.darPersonas().obtener(i);

            Object[] fila = new Object[4];

            fila[0] = persona.getNumeroDocumento();

            fila[1] = persona.getNombre();

            fila[2] = persona.getTipo();

            fila[3] = obtenerDatoTabla(persona);

            modeloTabla.addRow(fila);
        }

        String ultimo = "ninguno";

        if (!campus.darEliminados().estaVacia())
        {
            ultimo = campus.darEliminados().verTope().getNombre();
        }

        lblEstructuras.setText("Eliminados que se pueden restaurar: " + campus.darEliminados().getTamanio() + "   |   Último eliminado: " + ultimo);

        lblResumenTotales.setText("Total: " + campus.darTotalPersonas() + "   |   Estudiantes: " + campus.darTotalEstudiantes() + "   |   Profesores: " + campus.darTotalProfesores() + "   |   Administrativos: " + campus.darTotalAdministrativos() + "   |   Directivos: " + campus.darTotalDirectivos());
    }

    private String obtenerDatoTabla(Persona persona)
    {
        if (persona instanceof Estudiante)
        {
            return ((Estudiante) persona).getPrograma();
        }
        else if (persona instanceof Profesor)
        {
            return ((Profesor) persona).getArea();
        }
        else if (persona instanceof Administrativo)
        {
            return ((Administrativo) persona).getArea();
        }
        else if (persona instanceof Director)
        {
            return ((Director) persona).getPrograma();
        }
        else if (persona instanceof Directivo)
        {
            return ((Directivo) persona).getArea();
        }

        return "";
    }

    private void limpiarCampos()
    {
        documentoSeleccionado = null;

        txtDocumento.setText("");

        txtNombre.setText("");

        txtCorreo.setText("");

        txtCodigoInstitucional.setText("");

        txtDato1.setText("");

        txtDato2.setText("");

        txtBuscar.setText("");

        comboTipo.setSelectedIndex(0);

        actualizarCamposPorTipo();

        tablaPersonas.clearSelection();

        txtDocumento.requestFocus();
    }
}