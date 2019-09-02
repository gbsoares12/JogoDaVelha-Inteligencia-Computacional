/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.model.JogadorMinMax;
import src.model.Observado;
import src.model.Observador;
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
    private JuizPrincipal juiz;
    private int quantidadeJogadas;
    private AgenteJogador agente;

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
                endGame((String) pecaAtual[2]);
            } else if (this.turno == (this.quantidadeJogadas - 1) & this.juiz.verificaEmpate()) {
                endGame("empate");
            }

            this.turno++;
            atualizarView();
        }
    }

    public void selecionarCasaModoAI(int row, int col) {
        if(turno ==2) {
            System.out.println("break");
        }
        if (this.agente.getJogador().equals(JogadorMinMax.Min)) {

            //Eu Joguei
            if (this.tabuleiro[row][col].equals(" ")) {

                this.tabuleiro[row][col] = "X";
                this.agente.setX(row, col);
                //Calculo o Minimax
                this.agente.setJogador(JogadorMinMax.Max);
                this.agente = minimaxDecision(this.agente);
                //Computador Joga
                setTabuleiro(this.agente.getTabuleiroAgente());
                atualizarView();
                this.agente.setJogador(JogadorMinMax.Min);
                if (this.agente.isTerminal()) {
                    if (this.agente.ganhou()) {
                        endGame("Computador");
                    }
                    if (this.agente.perdeu()) {
                        endGame("Você");
                    }
                    if (this.agente.empate()) {
                        endGame("empate");
                    }
                }

            }
        }
        turno++;
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
        this.juiz = new JuizPrincipal();
        this.quantidadeJogadas = (int) Math.pow(this.tabuleiro.length, 2);
        this.agente = new AgenteJogador(this.tabuleiro.length);
        this.agente.setJogador(JogadorMinMax.Min);
        this.agente.setTabuleiroAgente(tabuleiro);
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

    public void endGame(String situacaoVencedor) {
        for (Observador observadore : observadores) {
            observadore.terminarJogo(situacaoVencedor);
        }
    }

    private AgenteJogador minimaxDecision(AgenteJogador agente) {

        int melhor = MaxValue(agente);
        ArrayList<AgenteJogador> filhos = agente.getTodosFilhos();
        for (AgenteJogador filho : filhos) {
            filho.mostra();
            System.out.println("");
            if (filho.getValor() == melhor) {
                return filho;
            }
        }
        return null;
    }

    private int MinValue(AgenteJogador agente) {
        if (agente.isTerminal()) {
            agente.setValor(agente.getResultado());
            return agente.getValor();
        } else {
            agente.setValor(Integer.MAX_VALUE);
            agente.setJogador(JogadorMinMax.Min);
            ArrayList<AgenteJogador> filhos = agente.getFilhos(agente);
            for (AgenteJogador filho : filhos) {
                agente.setValor(Math.min(agente.getValor(), MaxValue(filho)));
            }
            return agente.getValor();
        }
    }

    private int MaxValue(AgenteJogador agente) {
        if (agente.isTerminal()) {
            agente.setValor(agente.getResultado());
            return agente.getValor();
        } else {
            agente.setValor(Integer.MIN_VALUE);
            agente.setJogador(JogadorMinMax.Max);
            ArrayList<AgenteJogador> filhos = agente.getFilhos(agente);
            for (AgenteJogador filho : filhos) {
                agente.setValor(Math.max(agente.getValor(), MinValue(filho)));
            }
            return agente.getValor();
        }
    }

}
