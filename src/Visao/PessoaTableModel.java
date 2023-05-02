
package Visao;


import VO.VOPessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuário
 */
public class PessoaTableModel extends AbstractTableModel {

    private final List<VOPessoa> lista;
    private final String[] headerList = {"Nome", "Idade", "Peso"};
    private final Class[] classes = {String.class, Integer.class, Float.class};

    public PessoaTableModel(List<VOPessoa> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return headerList.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VOPessoa entity = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return entity.getNome();                
            case 1:
                return entity.getIdade();
            case 2:
                return entity.getPeso();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return classes[arg0];
    }

    @Override
    public String getColumnName(int col) {
        return headerList[col];
    }
    
}
