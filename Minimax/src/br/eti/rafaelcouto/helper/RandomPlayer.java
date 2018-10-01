package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Exemplo de IA para o jogo da velha
 * @author Rafael
 */
public class RandomPlayer {
    
    /**
     * Converte uma string em um estado (matriz de inteiros)
     * @param text
     * @return
     */
    public int[][] stringToState(String text) {
        int[][] state = new int[3][3];
        for (int i = 0; i < text.length(); i++) {
            int row = (int) Math.floorDiv(i, 3);
            int col = i % 3;
            if (text.toUpperCase().charAt(i) == 'O') {
                state[row][col] = -1;
            }
            else if (text.toUpperCase().charAt(i) == 'X') {
                state[row][col] = 1;
            }
        }
        return state;
    }

    public int player(int[][] state) {
        int val = 0;

        for(int[] line: state) {
            for(int item: line) {
                val += item;
            }
        }

        if (val == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * Retorna uma lista com os movimentos possíveis a partir de um estado
     * @param state
     * @return
     */
    public ArrayList<Integer> validMoves(int[][] state) {
        ArrayList<Integer> moves = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 0) {
                    moves.add(i*state[i].length+j);
                }
            }
        }
        return moves;
    }
    
    /**
     * Retorna o estado resultante após executar uma determinada jogada em um determinado estado
     * @param state Estado atual
     * @param move  Jogada
     * @return
     */
    public int[][] resultingState(int[][] state, int move) {
        //System.out.println("before resultingstate: "+Arrays.deepToString(state));
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            newState[i] = state[i].clone();
        }
        int row = Math.floorDiv(move, state[0].length);
        int col = move % state[0].length;
        newState[row][col] = currentPlayer(state);
        //System.out.println("after resultingstate: "+Arrays.deepToString(state));
        return newState;
    }
    
    /**
     * Retorna o próximo jogador a jogar no estado dado
     * @param state Estado para o qual deseja descobrir quem é o próximo a jogar
     * @return
     */
    public int currentPlayer(final int[][] state) {
        int contX = 0, contO = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 1) contX++;
                else if (state[i][j] == -1) contO++;
            }
        }
        if (contX > contO) return -1;
        else return 1;        
    }
    
    /**
     * Retorna uma lista de todos os possíveis estados descententes de um determinado estado
     * @param state Estado para o qual deseja obter os estados descendentes
     * @return
     */
    public ArrayList<int[][]> getChildren(final int[][] state) {
        ArrayList<int[][]> children = new ArrayList<>();
        ArrayList<Integer> moves = validMoves(state);
        for (Integer move : moves) {
            children.add(resultingState(state, move));
        }
        return children;
    }
    
    /**
     * Retorna se um estado é terminal ou não
     * @param state Estado que deseja saber se é terminal ou não
     * @return
     */
    public boolean isTerminal(final int[][] state) {
        return getChildren(state).size() == 0 || getWinner(state) != 0;
    }
    
    /**
     * Retorna o vencedor se houver
     * @param state Estado para o qual se deseja verificar o vencedor
     * @return
     */
    public int getWinner(int[][] state) {
        if (state[0][0] == state[0][1] && state[0][0] == state[0][2]) return state[0][0];   //First row
        if (state[1][0] == state[1][1] && state[1][0] == state[1][2]) return state[1][0];   //Second row
        if (state[2][0] == state[2][1] && state[2][0] == state[2][2]) return state[2][0];   //Third row
        if (state[0][0] == state[1][0] && state[0][0] == state[2][0]) return state[0][0];   //First col
        if (state[0][1] == state[1][1] && state[0][1] == state[2][1]) return state[0][1];   //Second col
        if (state[0][2] == state[1][2] && state[0][2] == state[2][2]) return state[0][2];   //Third col
        if (state[0][0] == state[1][1] && state[0][0] == state[2][2]) return state[0][0];   //Main diag
        if (state[0][2] == state[1][1] && state[0][2] == state[2][0]) return state[0][2];   //Second diag
        return 0;
    }
    
    /**
     * Retorna a heurística calculada para o estado dado
     * @param state Estado para o qual será calculada a heurística
     * @return
     */
    public double heuristic(int[][] state) {
        return 0;   //TODO Implementar sua heurística aqui
    }
    
    /**
     * Retorna uma jogada para um estado
     * @param state Estado para o qual vai fazer a jogada
     * @return
     */
    public int play(int[][] state) {
        ArrayList<Integer> moves = validMoves(state);
        return moves.get((int) Math.floor(Math.random()*moves.size()));
    }

    public int recommendedPlay(int[][] previousState, int[][] currentState) {
        for (int i = 0; i < previousState.length; i++) {
            for (int j = 0; j < previousState[i].length; j++) {
                if (previousState[i][j] != currentState[i][j]) {
                    return i*3+j;
                }
            }
        }

        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomPlayer rp = new RandomPlayer();
        int move = rp.play(rp.stringToState(args[0]));
        System.out.println(move);
    }
    
}
