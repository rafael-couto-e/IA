package br.eti.rafaelcouto.helper;

import java.util.Scanner;

public class MinimaxPlayer extends RandomPlayer {	//Confira o fonte da classe RandomPlayer para ver os métodos disponíveis
    @Override
    public double heuristic(int[][] state) {
        return getWinner(state);	//Como o minimax consegue analisar o jogo da velha inteiro, a heurística pode ser a própria condição de vitória
    }

    public double[] negamax(int[][] state, int depth) { //Retorna 2 valores: o valor do estado e a melhor jogada
		//SEU CÓDIGO AQUI
		//NÃO PRECISA MEXER EM MAIS NENHUM LUGAR

        String strState = stateToString(state);

        double[] result = new double[2];

        if (depth == 0 || super.isTerminal(state)) {
            if (player(state) == 1) {
                result[0] = this.heuristic(state);
            } else {
                result[0] = -this.heuristic(state);
            }
        } else {
            double value = Double.NEGATIVE_INFINITY;

            for (int[][] child: super.getChildren(state)) {
                double[] negamax = negamax(child, depth-1);

                if (value > -negamax[0]) {
                    result[1] = negamax[1];
                } else {
                    value = -negamax[0];
                    result[1] = super.recommendedPlay(state, child);
                }
            }

            result[0] = value;
        }

        return result;
    }

    public int play(int[][] state) {
        double[] result = negamax(state, 99);
        return (int) result[1];
    }

    public static String valueToString(int value) {
        return value == 1 ? "X" : value == -1 ? "O" : " ";
    }

    public static String stateToString(int[][] state) {
        StringBuilder builder = new StringBuilder("-------\n");

        for(int i = 0; i < state.length; i++) {
            builder.append("|");
            for(int j = 0; j < state[i].length; j++) {
                builder.append(valueToString(state[i][j]));
                builder.append("|");
            }

            builder.append("\n");
        }

        builder.append("-------");

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MinimaxPlayer rp = new MinimaxPlayer();

        int[][] state = rp.stringToState(args[0]);

        int x = 1;

        while (!rp.isTerminal(state)) {
            int move;

            if (x == -1) {
                System.out.print("Informe a jogada: ");
                move = scanner.nextInt();
            } else {
                move = rp.play(state);
            }

            int i = 0, j = 0;

            switch (move) {
                case 0:
                    i = 0;
                    j = 0;
                    break;
                case 1:
                    i = 0;
                    j = 1;
                    break;
                case 2:
                    i = 0;
                    j = 2;
                    break;
                case 3:
                    i = 1;
                    j = 0;
                    break;
                case 4:
                    i = 1;
                    j = 1;
                    break;
                case 5:
                    i = 1;
                    j = 2;
                    break;
                case 6:
                    i = 2;
                    j = 0;
                    break;
                case 7:
                    i = 2;
                    j = 1;
                    break;
                case 8:
                    i = 2;
                    j = 2;
                    break;
            }

            state[i][j] = x;

            System.out.println(stateToString(state));
            System.out.println("****************************");

            x = -x;
        }
    }    
}