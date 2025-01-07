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
import modelo.ModeloCidade;

/**
 *
 * @author heito
 */
public class ControleCidade {

    ConectaBanco connCidade = new ConectaBanco();

    public void InserirCidade(ModeloCidade mod) {
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("insert into tb_cidade(nome_cidade,id_estado)values(?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCodEstado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados armazenados com secesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na iserção dos dados. \nERRO!:" + ex);
        }
        connCidade.desconecta();
    }

    public void ExcluiTB_cidade(ModeloCidade mod) {
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("delete from tb_cidade where id_cidade=?");
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "excluido com secesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados. \nERRO!:" + ex);
        }

    }

    public void AlteraCidade(ModeloCidade mod) {
        connCidade.conexao();
        JOptionPane.showMessageDialog(null, mod.getCodEstado());
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("update tb_cidade set nome_cidade=?, id_estado=?where id_cidade=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCodEstado());
            pst.setInt(3, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados Alterados com secesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Alteração dos dados. \nERRO!:" + ex);
        }
    }
}
