/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espoch.persona.entidades;

/**
 *
 * @author DWSYSTEMS-CIA
 */
public class Persona {
    
     private  int codigotpersona;
    private String nombretpersona;
    private String apellidostpersona;
    private String cedualtpersona;
    private String direcciontpersona;

    public Persona(int codigotpersona, String nombretpersona, String apellidostpersona, String cedualtpersona, String direcciontpersona) {
        this.codigotpersona = codigotpersona;
        this.nombretpersona = nombretpersona;
        this.apellidostpersona = apellidostpersona;
        this.cedualtpersona = cedualtpersona;
        this.direcciontpersona = direcciontpersona;
    }

    public Persona() {
    }

    
    
    public int getCodigotpersona() {
        return codigotpersona;
    }

    public void setCodigotpersona(int codigotpersona) {
        this.codigotpersona = codigotpersona;
    }

    public String getNombretpersona() {
        return nombretpersona;
    }

    public void setNombretpersona(String nombretpersona) {
        this.nombretpersona = nombretpersona;
    }

    public String getApellidostpersona() {
        return apellidostpersona;
    }

    public void setApellidostpersona(String apellidostpersona) {
        this.apellidostpersona = apellidostpersona;
    }

    public String getCedualtpersona() {
        return cedualtpersona;
    }

    public void setCedualtpersona(String cedualtpersona) {
        this.cedualtpersona = cedualtpersona;
    }

    public String getDirecciontpersona() {
        return direcciontpersona;
    }

    public void setDirecciontpersona(String direcciontpersona) {
        this.direcciontpersona = direcciontpersona;
    }
    
    
}
