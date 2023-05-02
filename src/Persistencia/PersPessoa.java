package Persistencia;

import VO.VOPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersPessoa {
    
     public boolean inserir(VOPessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, idade, peso, altura) values (?, ?, ?, ?)";
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = Conexao.criarConexao();
            if (con == null) {
                System.err.println("aqui");
                return false;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setFloat(3, pessoa.getPeso());
            ps.setFloat(4, pessoa.getAltura());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir " + ex);
            return false;
        } finally {
            // fechar as conexoes
            try {
                if (ps != null) {
                    ps.close();

                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao: " + ex);
                return false;
            }
        }
        return true;
    }
    
     public boolean excluir(VOPessoa pessoa) {
        String sql = "DELETE FROM PESSOA WHERE ID = " + pessoa.getId();
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = Conexao.criarConexao();
            if (con == null) {
                return false;
            }
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar pessoa " + ex);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao: " + ex);
            }
        }
        return true;

    }
    
    
     public boolean alterar(VOPessoa pessoa) {
        String sql = "UPDATE PESSOA SET "
                + "NOME = ?,"
                + "IDADE = ?,"
                + "PESO = ?,"
                + "ALTURA = ? "
                + "WHERE ID = " + pessoa.getId();
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = Conexao.criarConexao();
            if (con == null) {
                return false;
            }
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setFloat(3, pessoa.getPeso());
            ps.setFloat(4, pessoa.getAltura());
            
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar pessoa " + ex);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao: " + ex);
            }
        }
        return true;

    }

    public List<VOPessoa> listar() {
        String sql = "SELECT * FROM PESSOA";
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        List<VOPessoa> lista = new ArrayList<>();
        try {
            con = Conexao.criarConexao();
            if (con == null) {
                return null;
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                VOPessoa p = new VOPessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setAltura(rs.getFloat("altura"));
                p.setPeso(rs.getFloat("peso"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar pessoa " + ex);
            return null;
        } finally {
            // fechar as conexoes
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao: " + ex);
            }
        }
        return lista;
    }
}
