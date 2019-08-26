/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.util.ArrayList;
import src.model.Observado;
import src.model.Observador;
import src.model.Juiz;
import src.utils.Utilitarios;

/**
 *
 * @author gabriel
 */
public class TabuleiroController implements Observado {

    private final java.util.List<Observador> observadores = new ArrayList<>();
    private String[][] tabuleiro;
    private static TabuleiroController instance;//Padrão Singleton
    private int turno = 0;
    private String marginPecas;
    private Object[] pecaAtual = new Object[3];
    private Juiz juiz;

    public synchronized static TabuleiroController getInstance() {//Padrão Singleton
        if (instance == null) {
            instance = new TabuleiroController();
        }
        return instance;
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Object[] getPecaAtual() {
        return pecaAtual;
    }

    public void selecionarCasa(int row, int col) {

        if (this.tabuleiro[row][col].equals(" ")) {
            if (turno == 0) {
                this.tabuleiro[row][col] = this.marginPecas + "X";
            }
            if (turno % 2 == 0) {
                this.tabuleiro[row][col] = this.marginPecas + "X";
            } else {
                this.tabuleiro[row][col] = this.marginPecas + "O";
            }

            pecaAtual[0] = row;//Linha
            pecaAtual[1] = col;//Coluna
            pecaAtual[2] = this.tabuleiro[row][col];//Value (String)
            
            if (this.juiz.verificaEndGame()) {
                endGame();
            }
            
            
            this.turno++;
            atualizarView();
        }
    }

    public void iniciar(int tamanhoTabuleiro) {
        tabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro];
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                this.tabuleiro[i][j] = " ";
            }
        }
        marginPecas = Utilitarios.defineMargin(this.tabuleiro.length);
        this.turno = 0;
        this.juiz = new Juiz();
    }

    public String getCampo(int row, int col) {
        return this.tabuleiro[row][col];
    }

    public void atualizarView() {
        observadores.forEach((obs) -> {
            obs.atualizarTela();
        });
    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

    public void endGame() {
        for (Observador observadore : observadores) {
            observadore.terminarJogo();
        }
    }
}
