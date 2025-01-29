/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloBairro;
/**
 *
 * @author heito
 */
public class ControleBairro {
    ConectaBanco connBairro = new ConectaBanco();

    public void InserirBairro(ModeloBairro modBairro) {
        connBairro.conexao();
        try {
            PreparedStatement pst = connBairro.conn.prepareStatement("insert into TB_bairro(nome_bairro,id_cidade)values (?,?)");
            pst.setString(1, modBairro.getNome());
            System.out.println(modBairro.getCodCidade());
            pst.setInt(2, modBairro.getCodCidade());
            JOptionPane.showMessageDialog(null,modBairro.getCodCidade());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "dados armazenados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na inserção dos dados. /n ERRO:" + ex);
        }
        connBairro.desconecta();
    }

    public void excluiCidade(ModeloBairro modBairro) {
        connBairro.conexao();
        try {
            PreparedStatement pst = connBairro.conn.prepareStatement("delete  from  tb_bairro where id_bairro=?");
            pst.setInt(1, modBairro.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados Excluidos  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na exclusão dos dados. /n ERRO:" + ex);
        }
    }

    public void alterarBairro(ModeloBairro modBairro) {
        connBairro.conexao();
        //JOptionPane.showMessageDialog(null, modBairro.getCod_cidade());
        try {
            PreparedStatement pst = connBairro.conn.prepareStatement("update tb_bairro set nome_bairro = ?, id_cidade= ? where id_bairro=?");
            pst.setString(1, modBairro.getNome());
            pst.setInt(2, modBairro.getCodCidade());
            pst.setInt(3, modBairro.getCod());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "dados alterados  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao alterar os dados. /n ERRO:" + ex);
        }
    }

}
