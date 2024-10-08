package Alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class frmAlumnos extends JFrame {
    private JTextField txtNombre;
    private JTextField txtAPaterno;
    private JTextField txtAMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JCheckBox chkDiscapacidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField txtCURP;
    private JPanel pnlPrincipal;
    private JButton GEdad;
    private JButton butEdad;
    private JTextField txtEdad;
    private BotonGuardarListener botonGuardarListener;


    public frmAlumnos() {
        setTitle("Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlPrincipal);
        setBounds(300, 300, 600, 700);

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

        butEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEdad();

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
        String edad = txtEdad.getText();
        String curp = txtCURP.getText().toUpperCase();


        alumno dato = new alumno(nombre, apaterno, amaterno, CURP, telefono, correo, discapacidad, sexo, edad);

        if (botonGuardarListener != null) {
            botonGuardarListener.guardando(dato);
        }
        Borrar();

    }

    private void Borrar() {
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtCURP.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        chkDiscapacidad.setSelected(false);
        txtEdad.setText("");
    }

    private void poblarComboBox() {
        DefaultComboBoxModel<Genero> comboBoxModel = (DefaultComboBoxModel<Genero>) cmbSexo.getModel();

        for (Genero genero : Genero.values()) {
            comboBoxModel.addElement(genero);
        }
    }

    private void calcularEdad() {
            String curp = txtCURP.getText().toUpperCase();
            try {
                String fechaNacimientoStr = curp.substring(4, 10);

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyMMdd");
                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formato);

                LocalDate fechaActual = LocalDate.now();
                Period periodo = Period.between(fechaNacimiento, fechaActual);
                int edad = periodo.getYears();
                txtEdad.setText(edad + " años");

            } catch (Exception e) {
                txtEdad.setText("CURP no válida");
            }
        }





    }



        /*DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            try {
                String fechaNacimientoStr = JOptionPane.showInputDialog(null,
                        "Introduce tu fecha de nacimiento (dd/mm/yyyy):",
                        "Calculo de Edad",
                        JOptionPane.QUESTION_MESSAGE);

                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formato);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null,
                        "Fecha ingresada incorrecta. Por favor, usa el formato dd/mm/yyyy.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        txtEdad.setText(""+periodo.getYears() +" años");


         */










