package Alumnos;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmAlumnos pantalla = new frmAlumnos();
                pantalla.setVisible(true);

                pantalla.setBotonGuardarListener(new BotonGuardarListener() {
                    @Override
                    public void guardando(alumno persona) {
                        System.out.println("Nombre:" + persona.getNombre());
                        System.out.println("A. Paterno: "+ persona.getAPaterno());
                        System.out.println("A.Materno: " + persona.getAMaterno());
                        System.out.println("Sexo :" + persona.getSexo());
                        System.out.println("Curp: " + persona.getCURP());
                        System.out.println("Telefono :" + persona.getTelefono());
                        System.out.println("Correo :" + persona.getCorreo());
                        System.out.println("Discapacidad: " + persona.getDiscapacidad());

//jose samuel cortinas de la Cruz 22130555.

                    }
                });

            }
        });
    }
        //

        }

