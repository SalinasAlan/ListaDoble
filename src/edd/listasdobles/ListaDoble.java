/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listas;

/**
 *
 * @author Salinas
 */
public class ListaDoble
{

    AlumnoLD mInicio, mFin;

    public boolean vacio()
    {
        return mFin == null && mInicio == null;
    }

    public void insertar(AlumnoLD mObjALD)
    {
        if (!vacio())
        {
            if (mObjALD.getmNombre().compareTo(mFin.getmNombre()) >= 0)
            {
                mObjALD.setmAntD(mFin);
                mFin.setmSigD(mObjALD);
                mFin = mObjALD;
            } else if (mObjALD.getmNombre().compareTo(mInicio.getmNombre()) <= 0)
            {
                mObjALD.setmSig(mInicio);
                mInicio.setmAntD(mObjALD);
                mInicio = mObjALD;
            } else
            {
                AlumnoLD mAux = mInicio;
                while (mObjALD.getmNombre().compareTo(mAux.mNombre) >= 0)
                {
                    mAux = mAux.getmSigD();
                }
                mObjALD.setmAntD(mAux.getmAntD());
                mObjALD.setmSig(mAux);
                mAux.setmAntD(mObjALD);
                mObjALD.getmAntD().setmSig(mObjALD);
            }

        } else
        {
            mInicio = mObjALD;
            mFin = mObjALD;
        }
    }

    public AlumnoLD eliminar(String nombre)
    {
        boolean bandera = false;
        if (mInicio == mFin)
        { //si solo hay un elemento en la lista
            AlumnoLD mAux = mInicio;
            mInicio = mFin = null;
            return mAux;
        }
        if (mInicio.getmNombre().equals(nombre))
        { // si el elemento a eliminar es el primero
            AlumnoLD a = mInicio;
            mInicio.getmSigD().setmAntD(null);
            mInicio = mInicio.getmSigD();
            return a;
        }
        if (mFin.getmNombre().equals(nombre))
        { //si el elemento a eliminar es el ultimo
            AlumnoLD au = mFin;
            mFin.getmAntD().setmSigD(null);
            mFin = mFin.getmAntD();
            return au;
        } else
        { //si esta en medio de la lista
            AlumnoLD aux = mInicio;
            while (aux != null && bandera == false)
            {
                if (aux.getmNombre().equals(nombre))
                {
                    AlumnoLD aux1 = aux;
                    aux.getmAntD().setmSigD(aux.getmSigD());
                    aux.getmSigD().setmAntD(aux.getmAntD());
                    aux.setmAntD(null);
                    aux.setmSigD(null);
                    bandera = true;
                    return aux1;
                } else
                {
                    aux = aux.getmSigD();
                }
            }
        }
        return null;
    }

    public void desp()
    {
        AlumnoLD aux = mInicio;
        AlumnoLD aux1 = mFin;
        System.out.println("\nAscendente");
        while (aux != null)
        {

            System.out.println(" Nombre del alumno: " + aux.getmNombre() + "\n Numero de control: " + aux.getmNoControl() + "\n Promedio: " + aux.getmProm() + "\n");
            aux = aux.getmSigD();
        }

        System.out.println("\nDescendente");
        while (aux1 != null)
        {
            System.out.println(" Nombre del alumno: " + aux1.getmNombre() + "\n Numero de control: " + aux1.getmNoControl() + "\n Promedio: " + aux1.getmProm() + "\n");
            aux1 = aux1.getmAntD();
        }

    }

    public void modificar(String mNombre, int mNoControl)
    {
        AlumnoLD aux = mInicio;
        boolean bandera = false;
        while (bandera == false && aux != null)
        {
            if (aux.getmNombre().equals(mNombre))
            {
                aux.setmNoControl(mNoControl);
                bandera = true;
            } else
            {
                aux = aux.getmSigD();
            }
        }
    }
}
