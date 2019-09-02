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
public class JuizAgente{

    final private TabuleiroController controller = TabuleiroController.getInstance();
    final private String[][] tabuleiro = controller.getTabuleiro();

    public JuizAgente() {
    }
    

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

//    public boolean verificaEndGame() {
//
//        if (!verificaHorizontalCompleta()) {
//            if (!verificaVerticalCompleta()) {
//                if (!verificaDiagonalCompleta()) {
//                    return false;
//                } else {
//                    return true;
//                }
//            } else {
//                return true;
//            }
//        } else {
//            return true;
//        }
//    }

    public boolean verificaHorizontalCompleta() {
        for (int row = 0; row < this.tabuleiro.length; row++) {
            for (int col = 0; col < this.tabuleiro.length; col++) {
                if("O".equals(tabuleiro[row][col])){
                    return false;
                }
            }
        }
        return true;
    }
    
//    public boolean verificaVerticalCompleta() {
//        for (int row = 0; row < this.tabuleiro.length; row++) {
//            if (!pecaAtual[2].equals(this.tabuleiro[row][(int) pecaAtual[1]])) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean verificaDiagonalCompleta() {
//        int row = 0;
//        int col = 0;
//        for (int i = 0; i < this.tabuleiro.length; i++) {
//            if (!pecaAtual[2].equals(this.tabuleiro[row][col])) {
//                return false;
//            }
//            row++;col++;
//        }
//        return true;
//    }
}

