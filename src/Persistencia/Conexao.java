package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor.
    private static final String username = "root",
                                password = "",
                                host = "localhost",
                                port = "3306",
                                database = "aula",
                                url = "jdbc:mysql://" + host + ":" + port + "/" + database;


    //Com o static, ao invés deles pertencerem à instância do objeto, eles pertencem à classe.
    public static Connection criarConexao() {
        Connection connection = null;
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro: Classe não carregada: org.mysql.jdbc.Driver, "
                    + "talvez o pacote .jar não esteja no projeto!");
            return null;
        }
         
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException ex) {
            System.err.println("Erro: nao foi possivel conectar ao banco!" + '\n' + ex);
        }
        return connection;
    }

}
