package Alumnos;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

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
                        System.out.println("Edad: " + persona.getEdad());

                       Path path= Path.of("C:\\Users\\jsamc\\Sam.txt");
                        String contenido = persona.getNombre();
                        String contenido1 = persona.getAPaterno();
                        String contenido2 = persona.getAMaterno();
                        String contenido3 = persona.getSexo();
                        String contenido4 = persona.getCURP();
                        String contenido5 = persona.getTelefono();
                        String contenido6 = persona.getCorreo();
                        String contenido7 = persona.getDiscapacidad();
                        String contenido8 = persona.getEdad();


                        try(FileWriter archivo = new FileWriter(path.toFile(),true)) {
                            PrintWriter pw = new PrintWriter(archivo);
                            pw.println("Nombre:"+ contenido);
                            pw.println("Apaterno:"+contenido1);
                            pw.println("AMaterno:"+contenido2);
                            pw.println("Sexo:"+contenido3);
                            pw.println("Curp:"+contenido4);
                            pw.println("Telefono:"+ contenido5);
                            pw.println("Correo:"+ contenido6);
                            pw.println("Discapacidad:" + contenido7);
                            pw.println("Edad:"+ contenido8);
                        }
                        catch(IOError e){e.getMessage();}catch(IOException e){
                            throw new RuntimeException(e);
                        }
//jose samuel cortinas de la Cruz 22130555.

                    }
                });

            }
        });
    }
        //

        }

