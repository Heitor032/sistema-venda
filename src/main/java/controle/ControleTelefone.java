/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.ModeloTelefone;

/**
 *
 * @author heito
 */
public class ControleTelefone {

    public void InserirTel(ModeloTelefone tel) {
        connex.conexao();
        PreparedStatement pst = connTel.conn.prepareStatement("inset * from ");
        
    }
}
