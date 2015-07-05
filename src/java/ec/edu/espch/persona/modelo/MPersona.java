/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espch.persona.modelo;

import ec.edu.espoch.persona.accesodatos.AccesoDatos;
import ec.edu.espoch.persona.accesodatos.ConjuntoResultado;
import ec.edu.espoch.persona.accesodatos.Parametro;
import ec.edu.espoch.persona.entidades.Persona;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DWSYSTEMS-CIA
 */
public class MPersona {
    
     public static boolean insertarPersona(Persona persona) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "SELECT * from datospersonales.fn_insert_tpersona(?,?,?,?)";
            lstP.add(new Parametro(1, persona.getNombretpersona()));
            lstP.add(new Parametro(2, persona.getApellidostpersona()));
            lstP.add(new Parametro(3, persona.getCedualtpersona()));
            lstP.add(new Parametro(4, persona.getDirecciontpersona()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getBoolean(0)==true) {
                    respuesta = true;
                }
            }
            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
    
    public static boolean actualizarPersona(Persona persona) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "SELECT datospersonales.fn_update_persona(?,?,?,?,?);";
            lstP.add(new Parametro(1, persona.getCodigotpersona()));
            lstP.add(new Parametro(2, persona.getNombretpersona()));
            lstP.add(new Parametro(3, persona.getApellidostpersona()));
            lstP.add(new Parametro(4, persona.getCedualtpersona()));
            lstP.add(new Parametro(5, persona.getDirecciontpersona()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getBoolean(0)==true) {
                    respuesta = true;
                }
            }
            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
    
     public static  ArrayList<Persona> obtenerPersona() throws Exception
    {
       ArrayList<Persona> lst = new ArrayList<Persona>();
        try
        {
         String sql = "SELECT * from datospersonales.f_select_persona();";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarPersona(rs);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
     public static ArrayList<Persona> llenarPersona(ConjuntoResultado rs) throws Exception
      {
          ArrayList<Persona> lst = new ArrayList<Persona>();
          Persona persona=null;
          try {
            while(rs.next())
            {
                     persona= new Persona(rs.getInt(0),
                             rs.getString(1),
                             rs.getString(2),
                             rs.getString(3),
                             rs.getString(4));
                     lst.add(persona);
            }
            } catch (Exception e) {
                 lst.clear();
               //  integracion.auditoria.log ublog = new integracion.auditoria.log();
                // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
                 throw e;
          }
         return lst;
      }
public static boolean eliminaPersona(Persona persona) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "SELECT datospersonales.fn_delete_tpersona(?);";
            lstP.add(new Parametro(1, persona.getCedualtpersona()));
           
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getBoolean(0)==true) {
                    respuesta = true;
                }
            }
            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
    
    
}
