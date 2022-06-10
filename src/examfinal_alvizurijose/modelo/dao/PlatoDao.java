/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examfinal_alvizurijose.modelo.dao;

import examfinal_alvizurijose.Plato;
import examfinal_alvizurijose.script.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ggpo0
 */
public class PlatoDao implements IPlatoDao{

    @Override
    public void insertar(Plato p) {
        String sql ="insert into plato (nombre,precio,descripcion,valoracion,region) values (?,?,?,?,?)"; 
        Connection cnn =null;
      
        try {
            cnn=Conexion.conectar();
            PreparedStatement ps =cnn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getDescripcion());
            ps.setInt(4, p.getValoracion());
            ps.setString(5, p.getRegion());
            
            ps.executeUpdate();
            System.out.println(" ------ inserto correctamente ---- ");
        } catch (Exception e) {
            System.out.println(" error al insertar platillo .... "+ e.getMessage());
        }
        finally{
            Conexion.close();
        }
    }

    @Override
    public List<Plato> listar(String sql) {
        Connection cnn =null;
        List<Plato> lista =new ArrayList<Plato>();
        
        try {
            cnn=Conexion.conectar();
            PreparedStatement ps =cnn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()) {
                Plato p =new Plato();
                p.setIdplato(rs.getInt("idplato"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setValoracion(rs.getInt("valoracion"));
                p.setEstado(rs.getInt("estado"));
                p.setRegion(rs.getString("region"));
                
                lista.add(p);
            }
            
            System.out.println(" ----- listado completado --- ");
        } catch (Exception e) {
            System.out.println(" error al listar platillos "+e.getMessage());
        }finally{
            Conexion.close();
        }
        
        return lista;
    }

    @Override
    public Plato obtenerXId(int id) {
        String sql ="select * from plato where idPlato =?";
        Plato p =null;
        Connection cnn =null;
        try {
            cnn =Conexion.conectar();
            PreparedStatement ps =cnn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            
            if(rs.next()){
                p=new Plato();
                p.setIdplato(rs.getInt("idplato"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setValoracion(rs.getInt("valoracion"));
                p.setEstado(rs.getInt("estado"));
                p.setRegion(rs.getString("region"));
            }
            System.out.println(" se obtuvo corretamente el platillo por el id ");
            
        } catch (Exception e) {
            System.out.println(" error al obtener platillo "+ e.getMessage());
        }
        finally{
            Conexion.close();
        }
        return p;
    }

    @Override
    public void actualizar(Plato p) {
        String sql ="update plato set nombre=?, precio=?, descripcion=?, valoracion=?, estado=?, region=? where idplato =?";
        Connection cnn =null;
        try {
            cnn =Conexion.conectar();
            PreparedStatement ps =cnn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getDescripcion());
            ps.setInt(4, p.getValoracion());
            ps.setInt(5, p.getEstado());
            ps.setString(6, p.getRegion());
            ps.setInt(7, p.getIdplato());
            
            ps.executeUpdate();
            
            System.out.println(" ----------------------- actualizacion satisfactoria ------------ ");
        } catch (Exception e) {
            System.out.println(" error al actualizar el platillo .... "+e.getMessage());
        }
        finally{
            Conexion.close();
        }
    }

    @Override
    public void actualizaEstado(int id, int estado) {
        String sql ="update plato set estado =? where idplato=?";
        Connection cnn=null;
        try {
            cnn=Conexion.conectar();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
            
            System.out.println(" se actualizo el estado ");
        } catch (Exception e) {
            System.out.println(" error al actualizar ... "+ e.getMessage());
        }
        finally{
            Conexion.close();
        }
    }
}
