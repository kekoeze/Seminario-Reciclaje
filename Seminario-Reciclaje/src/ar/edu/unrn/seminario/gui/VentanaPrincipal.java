package ar.edu.unrn.seminario.gui;
import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;
import ar.edu.unrn.seminario.api.PersistenceApi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IApi api = new PersistenceApi();
                    VentanaPrincipal frame = new VentanaPrincipal(api);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaPrincipal(IApi api) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setToolTipText("Roles");
        setJMenuBar(menuBar);

        JMenu UsuariosNewMenu = new JMenu("Usuarios");
        menuBar.add(UsuariosNewMenu);

        JMenuItem AltaModificacionNewMenuItem = new JMenuItem("Alta/Modificacion");
        AltaModificacionNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaUsuario altaUsuario= new AltaUsuario(api);
                altaUsuario.setVisible(true);
            }
        });
        UsuariosNewMenu.add(AltaModificacionNewMenuItem);

        JMenuItem ListadoNewMenuItem = new JMenuItem("Listado");
        ListadoNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        UsuariosNewMenu.add(ListadoNewMenuItem);

        JMenu RolesNewMenu = new JMenu("Roles");
        menuBar.add(RolesNewMenu);

        JMenuItem AltaRolNewMenuItem = new JMenuItem("Alta rol");
        AltaRolNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaRol altaRol= new AltaRol(api);
                altaRol.setVisible(true);
            }
        });
        RolesNewMenu.add(AltaRolNewMenuItem);

        JMenuItem ListarNewMenuItem = new JMenuItem("Lista Roles");
        ListarNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        RolesNewMenu.add(ListarNewMenuItem);

        JMenu ViviendasNewMenu = new JMenu("Viviendas");
        menuBar.add(ViviendasNewMenu);

        JMenuItem RegistrarViviendaNewMenuItem = new JMenuItem("Registrar Vivienda");
        RegistrarViviendaNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrarVivienda registrarVivienda= new RegistrarVivienda(api);
                registrarVivienda.setVisible(true);
            }
        });
        ViviendasNewMenu.add(RegistrarViviendaNewMenuItem);

        JMenuItem ListarViviendaNewMenuItem = new JMenuItem("ListarVivienda");
        ListarViviendaNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ListadoVivienda listado= new ListadoVivienda(api);
            	listado.setVisible(true);
            }
        });
        ViviendasNewMenu.add(ListarViviendaNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton SalirNewButton = new JButton("Salir");
        SalirNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        SalirNewButton.setBounds(179, 217, 89, 23);
        contentPane.add(SalirNewButton);
    }
}
