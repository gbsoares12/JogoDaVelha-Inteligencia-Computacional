/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gabriel
 */
public class Tabuleiro {

    int tamanhoTabuleiro;

    public Tabuleiro(int tamanho) {
        this.tamanhoTabuleiro = tamanho;
    }

    
}

class TabuleiroVelha extends AbstractTableModel {

    final private int tamanhoTabuleiro;

    public TabuleiroVelha(int tamanho) {
        this.tamanhoTabuleiro = tamanho;
    }

    JLabel jLabel = new JLabel();

    String[][] dados = {
        {"X", "O", "O"},
        {"O", "X", "O"},
        {"O", "O", "X"}
    };

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return this.tamanhoTabuleiro;
    }

    @Override
    public int getRowCount() {
        return this.tamanhoTabuleiro;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {

            return " ";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }

}

class TabuleiroRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {

        setValue(value);
        return this;
    }

}
