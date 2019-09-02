/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;
/**
 *
 * @author gabriel
 */
public class JuizPrincipal implements Juiz{

    final private TabuleiroController controller = TabuleiroController.getInstance();
    final private String[][] tabuleiro = controller.getTabuleiro();
    final private Object[] pecaAtual = controller.getPecaAtual();

    public JuizPrincipal() {
    }
    
    @Override
    public boolean verificaEmpate() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if(!this.tabuleiro[i][j].equals(" ")){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean verificaEndGame() {

        if (!verificaHorizontalCompleta()) {
            if (!verificaVerticalCompleta()) {
                if (!verificaDiagonalCompleta()) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public boolean verificaHorizontalCompleta() {
        for (int col = 0; col < this.tabuleiro.length; col++) {
            if (!pecaAtual[2].equals(this.tabuleiro[(int) pecaAtual[0]][col])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verificaVerticalCompleta() {
        for (int row = 0; row < this.tabuleiro.length; row++) {
            if (!pecaAtual[2].equals(this.tabuleiro[row][(int) pecaAtual[1]])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verificaDiagonalCompleta() {
        int row = 0;
        int col = 0;
        for (int i = 0; i < this.tabuleiro.length; i++) {
            if (!pecaAtual[2].equals(this.tabuleiro[row][col])) {
                return false;
            }
            row++;col++;
        }
        return true;
    }
}
