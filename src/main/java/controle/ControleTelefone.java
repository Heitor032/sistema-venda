/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public ModeloTelefone primeiro() {
       
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
    }

}
