package br.eti.rafaelcouto.helper;

public class MinimaxPlayer extends RandomPlayer {	//Confira o fonte da classe RandomPlayer para ver os métodos disponíveis
    private static Boolean PLAYER1 = true;

    public double heuristic(int[][] state) {
        return getWinner(state);	//Como o minimax consegue analisar o jogo da velha inteiro, a heurística pode ser a própria condição de vitória
    }

    public double[] minimax(int[][] state, int depth) { //Retorna 2 valores: o valor do estado e a melhor jogada
		//SEU CÓDIGO AQUI
		//NÃO PRECISA MEXER EM MAIS NENHUM LUGAR

        double[] result = new double[2];

        if(depth == 0 || super.isTerminal(state)) { //SE estado é terminal OU profundidade = 0 ENTÃO
            if (PLAYER1) { //SE jogador1 ENTÃO
                result[0] = this.heuristic(state); //RETORNE o valor da heurística do estado
            } else { //SENÃO
                result [0] = -this.heuristic(state); //RETORNE o negativo do valor da heurística do estado
            } //FIM SE
        } else { //SENÃO
            result[1] = Double.NEGATIVE_INFINITY; //valor ← -∞

            for(int[][] i: super.getChildren(state)) { //PARA CADA filho DE estado
                result[1] = Math.max(result[1], -minimax(i, depth-1)[1]); //valor ← max(valor, -negamax(filho, profundidade-1))
            } //FIM PARA
        } //FIM SE

        PLAYER1 = !PLAYER1;

        return result; //RETORNE valor
    }

    public int play(int[][] state) {
        double[] result = minimax(state, 99);
        return (int) result[1];
    }

    public static void main(String[] args) {
        MinimaxPlayer rp = new MinimaxPlayer();
        int move = rp.play(rp.stringToState(args[0]));
        System.out.println(move);
    }    
}