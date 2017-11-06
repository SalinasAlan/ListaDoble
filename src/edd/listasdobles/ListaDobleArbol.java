/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listasdobles;

/**
 *
 * @author Salinas
 */
public class ListaDobleArbol
{

    private AlumnoArbol mInicio;
    private AlumnoArbol mFin;

    public ListaDobleArbol()
    {
        this.mInicio = null;
        this.mFin = null;
    }

    /**
     * @return the mInicio
     */
    public AlumnoArbol getmInicio()
    {
        return mInicio;
    }

    /**
     * @param mInicio the mInicio to set
     */
    public void setmInicio(AlumnoArbol mInicio)
    {
        this.mInicio = mInicio;
    }

    /**
     * @return the mFin
     */
    public AlumnoArbol getmFin()
    {
        return mFin;
    }

    /**
     * @param mFin the mFin to set
     */
    public void setmFin(AlumnoArbol mFin)
    {
        this.mFin = mFin;
    }

    public boolean vacio()
    {
        return mFin == null && mInicio == null;
    }

    public void insertar(AlumnoArbol mObjALD)
    {
        if (!vacio())
        {
            if (mObjALD.getmNombre().compareTo(mFin.getmNombre()) >= 0)
            {
                mObjALD.setmAntLA(mFin);
                mFin.setmSigLA(mObjALD);
                mFin = mObjALD;
            } else if (mObjALD.getmNombre().compareTo(mInicio.getmNombre()) <= 0)
            {
                mObjALD.setmSigLA(mInicio);
                mInicio.setmAntLA(mObjALD);
                mInicio = mObjALD;
            } else
            {
                AlumnoArbol mAux = mInicio;
                while (mObjALD.getmNombre().compareTo(mAux.getmNombre()) >= 0)
                {
                    mAux = mAux.getmSigLA();
                }
                mObjALD.setmAntLA(mAux.getmAntLA());
                mObjALD.setmSigLA(mAux);
                mAux.setmAntLA(mObjALD);
                mObjALD.getmAntLA().setmSigLA(mObjALD);
            }

        } else
        {
            mInicio = mObjALD;
            mFin = mObjALD;
        }
    }

    public AlumnoArbol eliminar(String nombre)
    {
        boolean bandera = false;
        if (mInicio == mFin)
        { //si solo hay un elemento en la lista
            AlumnoArbol mAux = mInicio;
            mInicio = mFin = null;
            return mAux;
        }
        if (mInicio.getmNombre().equals(nombre))
        { // si el elemento a eliminar es el primero
            AlumnoArbol a = mInicio;
            mInicio.getmSigLA().setmAntLA(null);
            mInicio = mInicio.getmSigLA();
            return a;
        }
        if (mFin.getmNombre().equals(nombre))
        { //si el elemento a eliminar es el ultimo
            AlumnoArbol au = mFin;
            mFin.getmAntLA().setmSigLA(null);
            mFin = mFin.getmAntLA();
            return au;
        } else
        { //si esta en medio de la lista
            AlumnoArbol aux = mInicio;
            while (aux != null && bandera == false)
            {
                if (aux.getmNombre().equals(nombre))
                {
                    AlumnoArbol aux1 = aux;
                    aux.getmAntLA().setmSigLA(aux.getmSigLA());
                    aux.getmSigLA().setmAntLA(aux.getmAntLA());
                    aux.setmAntLA(null);
                    aux.setmSigLA(null);
                    bandera = true;
                    return aux1;
                } else
                {
                    aux = aux.getmSigLA();
                }
            }
        }
        return null;
    }

    public void desp()
    {
        AlumnoArbol aux = mInicio;
        AlumnoArbol aux1 = mFin;
        System.out.println("\nAscendente");
        while (aux != null)
        {

            System.out.println("\n Nombre del alumno: " + aux.getmNombre()
                    + "\n Numero de control: " + aux.getmNoControl()
                    + "\n Promedio: " + aux.getmProm()
                    + "\n");
            aux = aux.getmSigLA();
        }

        System.out.println("\nDescendente");
        while (aux1 != null)
        {
            System.out.println("\n Nombre del alumno: " + aux1.getmNombre()
                    + "\n Grupo: "
                    + "\n Numero de control: " + aux1.getmNoControl()
                    + "\n Promedio: " + aux1.getmProm());
            aux1 = aux1.getmAntLA();
        }

    }

    public void modificar(String mNombre, int mNoControl, String mGrupo, int mProm)
    {
        AlumnoArbol aux = mInicio;
        boolean bandera = false;
        while (bandera == false && aux != null)
        {
            if (aux.getmNombre().equals(mNombre))
            {
                aux.setmNombre(mNombre);
                aux.setmNoControl(mNoControl);
                aux.setmGrupo(mGrupo);
                aux.setmProm(mProm);
                bandera = true;
            } else
            {
                aux = aux.getmSigLA();
            }
        }
    }
}
