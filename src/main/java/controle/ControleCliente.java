/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloBairro;
import modelo.ModeloCliente;

/**
 *
 * @author heito
 */
public class ControleCliente {

    ConectaBanco connex = new ConectaBanco();

    public void InserirCliente(ModeloCliente modCliente) {
        connex.conexao();
        try {
            PreparedStatement pst = connex.conn.prepareStatement("insert into TB_cliente(nome_cliente,id_cidade,endereco_cliente,rg_cliente,cpf_cliente,Id_bairro)values (?,?)");
            pst.setString(1, modCliente.getNome());
            System.out.println(modCliente.getId());
            pst.setInt(2, modCliente.getId());
            pst.setString(3, modCliente.getRg());
            pst.setString(4, modCliente.getCpf());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "dados armazenados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na inserção dos dados. /n ERRO:" + ex);
        }
        connex.desconecta();
    }
}
