/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utils;

/**
 *
 * @author gabriel
 */
public class Utilitarios {

    public static String defineMargin(int tamanhoTabuleiro) {
        String spaceMargin = " ";
        // são 19 backspace para centralizar no tabuleiro 3x3 e 9 para 6x6

        switch (tamanhoTabuleiro) {
            case 3:
                for (int i = 0; i < 18; i++) {
                    spaceMargin += " ";
                }
                break;
            case 4:
                for (int i = 0; i < 12; i++) {
                    spaceMargin += " ";
                }
                break;
            case 5:
                for (int i = 0; i < 10; i++) {
                    spaceMargin += " ";
                }
                break;
            case 6:
                for (int i = 0; i < 6; i++) {
                    spaceMargin += " ";
                }
                break;
            case 7:
            case 8:
                for (int i = 0; i < 4; i++) {
                    spaceMargin += " ";
                }
                break;
            case 9:
                for (int i = 0; i < 3; i++) {
                    spaceMargin += " ";
                }
                break;
            case 10:
            case 11:
                for (int i = 0; i < 2; i++) {
                    spaceMargin += " ";
                }
                break;
            case 12:
                    spaceMargin += " ";
                break;
        }
        return spaceMargin;
    }
}
