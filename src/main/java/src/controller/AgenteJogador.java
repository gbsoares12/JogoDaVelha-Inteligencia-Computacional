/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.util.ArrayList;
import src.model.JogadorMinMax;
import src.utils.Utilitarios;

/**
 *
 * @author gabriel
 */
public class AgenteJogador {

    private String[][] tabuleiroAgente;
    private JogadorMinMax jogador;
    private int valor = 0;
    final private int dimensaoTabuleiro;

    private AgenteJogador noPai;
    private ArrayList<AgenteJogador> nosFilhos = new ArrayList<>();
    private String marginPecas;
    
    public AgenteJogador(int dimensaoTabuleiro) {
        this.dimensaoTabuleiro = dimensaoTabuleiro;
        this.tabuleiroAgente = new String[dimensaoTabuleiro][dimensaoTabuleiro];
        marginPecas = Utilitarios.defineMargin(dimensaoTabuleiro);
    }

    public String[][] getTabuleiroAgente() {
        return tabuleiroAgente;
    }

    public void setTabuleiroAgente(String[][] tabuleiroAgente) {
        this.tabuleiroAgente = tabuleiroAgente;
    }

    public JogadorMinMax getJogador() {
        return jogador;
    }

    public void setJogador(JogadorMinMax jogador) {
        this.jogador = jogador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public AgenteJogador getNoPai() {
        return noPai;
    }

    public void setNoPai(AgenteJogador noPai) {
        this.noPai = noPai;
    }

    public ArrayList<AgenteJogador> getNosFilhos() {
        return nosFilhos;
    }

    public void setNosFilhos(ArrayList<AgenteJogador> nosFilhos) {
        this.nosFilhos = nosFilhos;
    }

    public AgenteJogador getMelhorFilho() {
        AgenteJogador agnt = new AgenteJogador(this.dimensaoTabuleiro);
        int melhor = Integer.MIN_VALUE;
        for (AgenteJogador filho : nosFilhos) {
            if (filho.getValor() > melhor) {
                agnt = filho;
                melhor = filho.getValor();
            }
        }
        return agnt;
    }

    public String getXY(int linha, int coluna) {
        return tabuleiroAgente[linha][coluna];
    }

    public void setX(int linha, int coluna) {
        tabuleiroAgente[linha][coluna] = this.marginPecas +"X";
    }

    public void setO(int linha, int coluna) {
        tabuleiroAgente[linha][coluna] = this.marginPecas +"O";
    }

    public boolean verificaPerdeuHorizontal() {
        int casasFeitas = 0;
        for (int row = 0; row < this.dimensaoTabuleiro; row++) {
            for (int col = 0; col < this.dimensaoTabuleiro; col++) {
                if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"X")) {
                    casasFeitas++;
                    if (casasFeitas == this.dimensaoTabuleiro) {
                        return true;
                    }
                }
            }
            casasFeitas = 0;
        }
        return false;
    }

    public boolean verificaPerdeuVertical() {
        int casasFeitas = 0;
        for (int col = 0; col < this.dimensaoTabuleiro; col++) {
            for (int row = 0; row < this.dimensaoTabuleiro; row++) {
                if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"X")) {
                    casasFeitas++;
                    if (casasFeitas == this.dimensaoTabuleiro) {
                        return true;
                    }
                }
            }
            casasFeitas = 0;
        }
        return false;
    }

    public boolean verificaPerdeuDiagonal() {
        int casaFeitasVertical = 0;
        int casaFeitasVerticalInvertido = 0;
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            if (this.tabuleiroAgente[i][i].equals(this.marginPecas +"X")) {
                casaFeitasVertical++;
            }
        }
        if(casaFeitasVertical == this.dimensaoTabuleiro){
            return true;
        }
        int row = this.dimensaoTabuleiro - 1;
        int col = 0;
        while (row >= 0) {
            if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"X")) {
                casaFeitasVerticalInvertido++;
            }
            row--;
            col++;
        }
        return casaFeitasVerticalInvertido == this.dimensaoTabuleiro;
    }

    public boolean verificaGanhouHorizontal() {
        int casasFeitas = 0;
        for (int row = 0; row < this.dimensaoTabuleiro; row++) {
            for (int col = 0; col < this.dimensaoTabuleiro; col++) {
                if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"O")) {
                    casasFeitas++;
                    if (casasFeitas == this.dimensaoTabuleiro) {
                        return true;
                    }
                }
            }
            casasFeitas = 0;
        }
        return false;
    }

    public boolean verificaGanhouVertical() {
        int casasFeitas = 0;

        for (int col = 0; col < this.dimensaoTabuleiro; col++) {
            for (int row = 0; row < this.dimensaoTabuleiro; row++) {
                if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"O")) {
                    casasFeitas++;
                    if (casasFeitas == this.dimensaoTabuleiro) {
                        return true;
                    }
                }
            }
            casasFeitas = 0;
        }
        return false;
    }

    public boolean verificaGanhouDiagonal() {
        int casaFeitasVertical = 0;
        int casaFeitasVerticalInvertido = 0;

        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            if (this.tabuleiroAgente[i][i].equals(this.marginPecas +"O")) {
                casaFeitasVertical++;
            }
        }
        if(casaFeitasVertical == this.dimensaoTabuleiro){
            return true;
        }
        
        int row = this.dimensaoTabuleiro - 1;
        int col = 0;
        while (row >= 0) {
            if (this.tabuleiroAgente[row][col].equals(this.marginPecas +"O")) {
                casaFeitasVerticalInvertido++;
            }
            row--;
            col++;
        }
        return casaFeitasVerticalInvertido == this.dimensaoTabuleiro;
    }

    public boolean empate() {
        boolean empate = true;
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int j = 0; j < this.dimensaoTabuleiro; j++) {
                if (this.tabuleiroAgente[i][j].equals(" ")) {
                    empate = false;
                    break;
                }
            }
        }

        return empate && !ganhou();
    }

    public boolean perdeu() {
        return (verificaPerdeuHorizontal()
                || verificaPerdeuVertical()
                || verificaPerdeuDiagonal());
    }

    public boolean ganhou() {
        return (verificaGanhouHorizontal()
                || verificaGanhouVertical()
                || verificaGanhouDiagonal());
    }

    public boolean isTerminal() {
        return ganhou() || empate() || perdeu();
    }

    public int getResultado() {
        if (ganhou()) {
            valor = 1;
            return 1;
        } else {
            if (perdeu()) {
                valor = -1;
                return -1;
            } else {
                return 0;
            }
        }
    }

    public void mostra() {
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int j = 0; j < this.dimensaoTabuleiro; j++) {
                System.out.print(this.tabuleiroAgente[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("Utilidade: " + this.getValor() + "\n");
    }

    public ArrayList<AgenteJogador> getTodosFilhos() {
        return this.nosFilhos;
    }

    public ArrayList<AgenteJogador> getFilhos(AgenteJogador agnt) {
        this.nosFilhos = new ArrayList<>();
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int j = 0; j < this.dimensaoTabuleiro; j++) {
                try {
                    AgenteJogador filho = agnt.clone();
                    filho.setNoPai(agnt);
                    if (filho.getXY(i, j).equals(" ")) {
                        if (jogador.equals(JogadorMinMax.Max)) {
                            filho.setO(i, j);
                        } else {
                            filho.setX(i, j);
                        }
                        filho.getResultado();
                        this.nosFilhos.add(filho);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return nosFilhos;
    }

    @Override
    protected AgenteJogador clone() throws CloneNotSupportedException {
        AgenteJogador agnt = new AgenteJogador(this.dimensaoTabuleiro);
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            System.arraycopy(this.tabuleiroAgente[i], 0, agnt.getTabuleiroAgente()[i], 0, this.dimensaoTabuleiro);
        }
        return agnt;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int j = 0; j < this.dimensaoTabuleiro; j++) {
                s += this.tabuleiroAgente[i][j] + ",";
            }
        }
        return s + "]\n";
    }
}
