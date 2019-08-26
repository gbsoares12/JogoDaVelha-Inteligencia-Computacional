/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.util.ArrayList;
import src.controller.TabuleiroController;

/**
 *
 * @author gabriel
 */
public class Juiz {

    final private TabuleiroController controller = TabuleiroController.getInstance();
    final private String[][] tabuleiro = controller.getTabuleiro();
    final private Object[] pecaAtual = controller.getPecaAtual();

    public Juiz() {
    }

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

    public boolean verificaHorizontalCompleta() {
        for (int col = 0; col < this.tabuleiro.length; col++) {
            if (!pecaAtual[2].equals(this.tabuleiro[(int) pecaAtual[0]][col])) {
                return false;
            }
        }
        return true;
    }

    public boolean verificaVerticalCompleta() {
        for (int row = 0; row < this.tabuleiro.length; row++) {
            if (!pecaAtual[2].equals(this.tabuleiro[row][(int) pecaAtual[1]])) {
                return false;
            }
        }
        return true;
    }

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
