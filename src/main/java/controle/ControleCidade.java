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
    public void InserirCidade(ModeloCidade mod){
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("insert into TB_cidade(nome_cidade,id_estado)values (?,?)");
            pst.setString(1,mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados armazenados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," erro na inserção dos dados. /n ERRO:"+ex);
        }
    }
    
    
}
