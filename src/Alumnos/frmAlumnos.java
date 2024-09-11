package Alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAlumnos extends JFrame{
    private JTextField txtNombre;
    private JTextField txtAPaterno;
    private JPasswordField txtAMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JCheckBox chkDiscapacidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField txtCURP;
    private JPanel pnlPrincipal;
    private BotonGuardarListener botonGuardarListener;


    public frmAlumnos() {
        setTitle("Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlPrincipal);

        poblarComboBox();
        setLocationRelativeTo(null);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrar();
            }
        });
    }
    public void setBotonGuardarListener(BotonGuardarListener listener) {
        this.botonGuardarListener = listener;
    }
    private void enviarDatos() {
        String nombre = txtNombre.getText();
        String apaterno = txtAPaterno.getText();
        String amaterno = txtAMaterno.getText();
        String CURP = txtCURP.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        Boolean discapacidad = chkDiscapacidad.isSelected();

        alumno dato= new alumno(nombre,apaterno,amaterno,CURP,telefono,correo,discapacidad,sexo);

        if(botonGuardarListener != null) {
            botonGuardarListener.guardando(dato);
        }
        Borrar();
    }
    private void Borrar()
    {
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtCURP.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        chkDiscapacidad.setSelected(false);
    }
    private void poblarComboBox()
    {
        DefaultComboBoxModel <Genero>comboBoxModel =  (DefaultComboBoxModel<Genero>) cmbSexo.getModel();

        for(Genero genero : Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }
}


