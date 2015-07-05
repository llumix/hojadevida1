/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.espoch.persona.controladores;

import ec.edu.espch.persona.modelo.MPersona;
import ec.edu.espoch.persona.entidades.Persona;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import recursos.Util;

/**
 *
 * @author ReivaJ
 */
@ManagedBean
@ViewScoped
public class PersonaControlador {

    private Persona objPersona;
      private Persona selObjPersona;
    private ArrayList<Persona> lstPersona;

    public PersonaControlador() {
        this.objPersona = new Persona();
        this.lstPersona = new ArrayList<Persona>();
        this.selObjPersona = new Persona();
//        cargarMateriasEstudiante();
    }

    public Persona getObjPersona() {
        return objPersona;
    }

    public Persona getSelObjPersona() {
        return selObjPersona;
    }

    public void setSelObjPersona(Persona selObjPersona) {
        this.selObjPersona = selObjPersona;
    }

    
    
    public void setObjPersona(Persona objPersona) {
        this.objPersona = objPersona;
    }

    public ArrayList<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(ArrayList<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        cargarPersona();

    }
    /*
     Metodo que permite cargar todos los registros de la base de datos
     */

    public void cargarPersona() {
        try {
            this.lstPersona = MPersona.obtenerPersona();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }
    /*
     Metodo para insertar en la tabla persona
     */

    public void cerrarForm() {
        RequestContext.getCurrentInstance().closeDialog("dlgEditarPersona"); 
        //DefaultRequestContext.getCurrentInstance().execute("dlgPersonaInsertar.hide()");
    }
    
    public void frmEditar()
    {
        RequestContext.getCurrentInstance().openDialog("dlgEditarPersona");
    }
    public void insertarPersona() {
        try {
            if (MPersona.insertarPersona(objPersona)) {
                DefaultRequestContext.getCurrentInstance().execute("dlgPersonaInsertar.hide()");
                Util.addSuccessMessage("Datos Insertados");
                cargarPersona();

            } else {
                Util.mostrarMensaje("Datos no insertados Insertados");
            }

            objPersona = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }

    
    public void eliminarPersona() {
        try {
            if (MPersona.eliminaPersona(objPersona)) {
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarPersona.hide()");
                Util.addSuccessMessage("Datos eliminados");
                cargarPersona();

            } else {
                Util.mostrarMensaje("Datos no eliminados");
            }

            objPersona = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }
  public void actualizarPersona() {
        try {
            if (MPersona.actualizarPersona(objPersona)) {
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarPersona.hide()");
                Util.addSuccessMessage("Datos actualizados");
                cargarPersona();

            } else {
                Util.mostrarMensaje("Datos no actualizados");
            }

            objPersona = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }
}
