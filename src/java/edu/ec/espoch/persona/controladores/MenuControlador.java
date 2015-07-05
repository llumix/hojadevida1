/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.espoch.persona.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DWSYSTEMS-CIA
 */
@ManagedBean
@RequestScoped
public class MenuControlador {

    private String ruta;
    private int opcion;

    /**
     * Creates a new instance of MenuControlador
     */
    public MenuControlador() {
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public void asignarRutas() {

        this.ruta = "../paginas/formularios/frmPersona.xhtml";

    }

}
