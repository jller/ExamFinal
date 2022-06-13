/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examfinal_alvizurijose.modelo.dao;

import examfinal_alvizurijose.Plato;
import java.util.List;

/**
 *
 * @author ggpo0
 */
public interface IPlatoDao {
    public void insertar(Plato p);
    public List<Plato> listar(String sql);
    public Plato obtenerXId(int id);
    public void actualizar(Plato p);
    public void actualizaEstado(int id,int estado);
    public int consultar(String sql);
}
