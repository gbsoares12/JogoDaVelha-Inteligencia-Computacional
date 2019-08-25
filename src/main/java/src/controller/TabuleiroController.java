/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.awt.List;
import java.util.ArrayList;
import src.model.Observado;
import src.model.Observador;

/**
 *
 * @author gabriel
 */
public class TabuleiroController implements Observado {

    private java.util.List<Observador> observadores = new ArrayList<>();
    private String[][] tabuleiro;
    private static TabuleiroController instance;//Padrão Singleton
    private int turno = 0;

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

    public void selecionarCasa(int row, int col) {

        if(this.tabuleiro[row][col] == " "){
            if (turno == 0) {
                this.tabuleiro[row][col] = "X";
            }
            if (turno % 2 == 0) {
                this.tabuleiro[row][col] = "X";
            } else {
                this.tabuleiro[row][col] = "O";
            }
            turno++;
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
    }

    public String getCampo(int row, int col) {
        return this.tabuleiro[row][col];
    }

    public void atualizarView() {
        for (Observador obs : observadores) {
            obs.atualizarTela();
        }
    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

}
