/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import java.sql.*;
import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;

/**
 *
 * @author heitor
 */
public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.driver";
    private String caminho = "jdbc:postgresql://localhost:5432/sistema_venda";
    private String usuario = "heitor";
    private String senha = "heitor@2024";
    public Connection conn;

    public void conexao() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "conectado com sucesso!!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro:" + ex.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(null, "Erro de ExecuataSQl!\n Erro:" + ex.getMessage());
        }

    }

    public void desconecta() {
        try {
            conn.close();
           // JOptionPane.showMessageDialog(null, "desconectado com sucesso!!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro:" + ex.getMessage());
        }
    }
}
