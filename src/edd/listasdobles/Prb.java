/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Salinas
 */
public class Prb
{

    public static void main(String[] args)
    {
        BufferedReader mLeer = new BufferedReader(new InputStreamReader(System.in));
        ListaDoble mLD = new ListaDoble();
        int op = 0;

        do
        {
            try
            {
                System.out.println("\n1. Ingresar alumno"
                        + "\n2. Mostrar alumno"
                        + "\n3. Eliminar a un alumno"
                        + "\n4. Modificar un alumno"
                        + "\n5. Salir");
                op = Integer.parseInt(mLeer.readLine());
                switch (op)
                {
                    case 1:
                        System.out.println("\nIngrese el nombre del alumno.");
                        String mNombre = mLeer.readLine();
                        System.out.println("Ingrese el promedio.");
                        int mProm = Integer.parseInt(mLeer.readLine());
                        System.out.println("Ingrese el numero de control.");
                        int mNoControl = Integer.parseInt(mLeer.readLine());
                        AlumnoLD mA = new AlumnoLD(mNombre, mProm, mNoControl);
                        mLD.insertar(mA);
                        break;
                    case 2:
                        mLD.desp();
                        break;
                    case 3:
                        System.out.println("\nIngrese el nombre del alumno a eliminar");
                        mNombre = mLeer.readLine();
                        mLD.eliminar(mNombre);
                        break;
                    case 4:
                        System.out.println("\nIngrese el nombre del alumno a modificar");
                        mNombre = mLeer.readLine();
                        System.out.println("Ingrse el No. de control");
                        mNoControl = Integer.parseInt(mLeer.readLine());
                        mLD.modificar(mNombre, mNoControl);
                        break;
                    case 5:
                        System.out.println("Adios");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (Exception e)
            {
                System.out.println("Solo opciones numéricas\n");
            }
        } while (op != 5);

    }
}
