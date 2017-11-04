/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listasdobles;

import edd.listas.Alumno;

/**
 *
 * @author Salinas
 */
public class AlumnoArbol extends Alumno
{

    private String mGrupo;
    private AlumnoArbol mSigLA; //Siguiente de la lista para el arbol
    private AlumnoArbol mAntLA; //Anterior de la lista para el arbol

    public AlumnoArbol(String mNombre, int mProm, int mNoControl, String mGrupo)
    {
        super(mNombre, mProm, mNoControl);
        this.mGrupo = mGrupo;
        this.mSigLA = null;
        this.mAntLA = null;
    }

    /**
     * @return the mGrupo
     */
    public String getmGrupo()
    {
        return mGrupo;
    }

    /**
     * @param mGrupo the mGrupo to set
     */
    public void setmGrupo(String mGrupo)
    {
        this.mGrupo = mGrupo;
    }

    /**
     * @return the mSigLA
     */
    public AlumnoArbol getmSigLA()
    {
        return mSigLA;
    }

    /**
     * @param mSigLA the mSigLA to set
     */
    public void setmSigLA(AlumnoArbol mSigLA)
    {
        this.mSigLA = mSigLA;
    }

    /**
     * @return the mAntLA
     */
    public AlumnoArbol getmAntLA()
    {
        return mAntLA;
    }

    /**
     * @param mAntLA the mAntLA to set
     */
    public void setmAntLA(AlumnoArbol mAntLA)
    {
        this.mAntLA = mAntLA;
    }
    
}
