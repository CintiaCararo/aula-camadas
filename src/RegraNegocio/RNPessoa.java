/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegraNegocio;

import Persistencia.PersPessoa;
import VO.VOPessoa;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class RNPessoa {
    
    private PersPessoa persPessoa;
    
    public RNPessoa(){
        persPessoa = new PersPessoa();
    }
    
    public boolean inserir(VOPessoa pessoa){
        if(pessoa.getId() > 0) {
            return persPessoa.alterar(pessoa);
        }else {
            return persPessoa.inserir(pessoa);
        }        
    }
    
    public boolean excluir(VOPessoa pessoa) {
        return persPessoa.excluir(pessoa);
    }
    
    public boolean alterar(VOPessoa pessoa) {
        return persPessoa.alterar(pessoa);
    }
    
    public List<VOPessoa> listar(){
        return persPessoa.listar();
    }
    
}
