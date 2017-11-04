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
public class AlumnoLD extends Alumno
{

    private AlumnoLD mSigD; //Nodo siguiente y anterior para lista doble.
    private AlumnoLD mAntD; //Nodo siguiente y anterior para lista doble.

    public AlumnoLD(String mNombre, int mProm, int mNoControl)
    {
        super(mNombre, mProm, mNoControl);
        this.mSigD = null;
        this.mAntD = null;
    }

    /**
     * @return the mSigD
     */
    public AlumnoLD getmSigD()
    {
        return mSigD;
    }

    /**
     * @param mSigD the mSigD to set
     */
    public void setmSigD(AlumnoLD mSigD)
    {
        this.mSigD = mSigD;
    }

    /**
     * @return the mAntD
     */
    public AlumnoLD getmAntD()
    {
        return mAntD;
    }

    /**
     * @param mAntD the mAntD to set
     */
    public void setmAntD(AlumnoLD mAntD)
    {
        this.mAntD = mAntD;
    }

}
