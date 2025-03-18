package lab03.JGalo;

public class Jogo implements JGaloInterface {
    char[][] tabuleiro = new char[3][3];
    int x_plays = 0;
    int o_plays = 0;


    public Jogo() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tabuleiro[i][j] = 0;
    }

    public char getActualPlayer(){

        return (x_plays > o_plays) ? 'O' : 'X';
    }

    public boolean isFinished(){
        if (x_plays + o_plays != 9 && checkResult() == ' ')
            return false;
        else
            return true;
    }


    public boolean setJogada(int x, int y) {
        if (tabuleiro[x-1][y-1] != 0) return false;

        tabuleiro[x-1][y-1] = getActualPlayer();

        if (tabuleiro[x-1][y-1] == 'O') {
            o_plays += 1;
        } else {
            x_plays += 1;
        }

        return true;
    }


    public char checkResult() {
        boolean finish;
        for (int i = 0; i < 3; i++) {
            // Verify lines
            finish = true;
            for (int j = 1; j < 3; j++) {
                if (tabuleiro[i][j] != tabuleiro[i][0] || tabuleiro[i][j] == 0) {
                    finish = false;
                }
            }
            
            if (finish) return tabuleiro[i][0];

            // Verify columns
            finish = true;
            for (int j = 1; j < 3; j++) {
                if (tabuleiro[j][i] != tabuleiro[0][i] || tabuleiro[j][i] == 0) {
                    finish = false;
                }
            }

            if (finish) return tabuleiro[0][i];
        }

        finish = true;
        for (int i = 1; i < 3; i++) {
            if (tabuleiro[i][i] != tabuleiro[0][0] || tabuleiro[i][i] == 0) {
                finish = false;
            }
        }

        if (finish) return tabuleiro[0][0];

        finish = true;
        for (int i = 1; i < 3; i++) {
            if (tabuleiro[i][2-i] != tabuleiro[0][2] || tabuleiro[i][2-i] == 0) {
                finish = false;
            }
        }
        if (finish) return tabuleiro[0][2];

        return ' ';
    }
}
