/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloTelefone;

/**
 *
 * @author heito
 */
public class ControleTelefone {

    ConectaBanco connex = new ConectaBanco();
    ModeloTelefone modTel = new ModeloTelefone();
    ModeloTelefone connBot = new ModeloTelefone();

    public void InserirTel(ModeloTelefone modTel) {
        connex.conexao();
        try {
            PreparedStatement pst = connex.conn.prepareStatement("insert into TB_telefone(numero_tel)values(?)");
            pst.setString(1, modTel.getTel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados armazenados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR !/nERRO:" + ex);
        }
    }

    public void Excluir(ModeloTelefone modeloTel) {
        connex.conexao();
        PreparedStatement pst;
        try {
            pst = connex.conn.prepareStatement("Delete from tb_telefone where id_telefone=?");
            pst.setInt(1, modTel.getCodTel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO excluir !/nERRO:" + ex);
        }
        connex.desconecta();
    }

    public void alterar(ModeloTelefone modTel) {
        connex.conexao();
        PreparedStatement pst;
        try {
            pst = connex.conn.prepareStatement("update tb_telefone set numero_tel= ? where id_telefone=?");
            pst.setString(1, modTel.getTel());
            pst.setInt(2, modTel.getCodTel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "alterados  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO alterar !/nERRO:" + ex);
        }

    }

    public ModeloTelefone primeiro() {
        connex.conexao();
        connex.executaSQL("select * from Tb_telefone");
        try {
            connex.rs.first();
            modTel.setCodTel(connex.rs.getInt("id_telefone"));
            modTel.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex);
        }
        connex.desconecta();
        return modTel;

    }

    public ModeloTelefone ultimo() {
        connex.conexao();
        try {
            connex.rs.last();
            modTel.setCodTel(connex.rs.getInt("id_telefone"));
            modTel.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex);
        }
        connex.desconecta();
        return modTel;

    }

    public ModeloTelefone anterior() {
        connex.conexao();
        try {
            connex.rs.previous();
            modTel.setCodTel(connex.rs.getInt("id_telefone"));
            modTel.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex);
        }
        connex.desconecta();
        return modTel;

    }

    public ModeloTelefone proximo() {
        connex.conexao();
        try {
            connex.rs.next();
            modTel.setCodTel(connex.rs.getInt("id_telefone"));
            modTel.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex);
        }
        connex.desconecta();
        return modTel;
    }
}
