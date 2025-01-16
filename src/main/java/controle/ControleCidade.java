/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            PreparedStatement pst = connCidade.conn.prepareStatement("insert into TB_cidade(nome_cidade,id_estado)values (?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados armazenados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na inserção dos dados. /n ERRO:" + ex);
        }
        connCidade.desconecta();
    }

    public void excluiCidade(ModeloCidade mod) {
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("delete  from  tb_cidade where id_cidade=?");
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados Excluidos  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na exclusão dos dados. /n ERRO:" + ex);
        }
    }

    public void alterarCidade(ModeloCidade mod) {
        connCidade.conexao();
        //JOptionPane.showMessageDialog(null, mod.getCod_estado());
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("update  tb_cidade set nome_cidade = ?, id_estado= ? where id_cidade=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.setInt(3, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "dados alterados  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao alterar os dados. /n ERRO:" + ex);
        }
    }

}
