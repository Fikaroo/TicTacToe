import java.util.*;

public class TicTacToe2 {
    public static void main(String[] args) {

        char[][] char2D = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char2D[i][j] = ' ';
            }
        }

        printchar2D(char2D);

        while (true){
            inputUserx(char2D);
            String result = checkWinner(char2D);
            if(result.length()>0){
                System.out.println(result);
                break;
            }
            inputUsero(char2D);
            result = checkWinner(char2D);
            if(result.length()>0){
                System.out.println(result);
                break;
            }}
    }


    public static void printchar2D(char[][] char2D) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(char2D[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static void inputUserx(char[][] char2D) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the coordinates: ");

        int x = 0, y = 0;

        while (true) {
            try {
                x = in.nextInt()-1;
                y = in.nextInt()-1;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                in.nextInt();
            }
            if (x > 2 | x < 0 | y > 2 | y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if(char2D[x][y] == 'X'|char2D[x][y] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
        char2D[x][y] = 'X';
        printchar2D(char2D);
    }

    public static void inputUsero(char[][] char2D) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the coordinates: ");

        int x = 0, y = 0;

        while (true) {
            try {
                x = in.nextInt()-1;
                y = in.nextInt()-1;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                in.nextInt();
            }

            if (x > 2 | x < 0 | y > 2 | y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if(char2D[x][y] == 'X'|char2D[x][y] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
        char2D[x][y] = 'O';
        printchar2D(char2D);
    }
    static int x,o;
    public static boolean oWins(char[][] char2D) {

        if (char2D[0][0] == 'O' && char2D[0][1] == 'O' && char2D[0][2] == 'O') {
            o++;
            return true;
        }

        if (char2D[1][0] == 'O' && char2D[1][1] == 'O' && char2D[1][2] == 'O') {
            o++;
            return true;
        }

        if (char2D[2][0] == 'O' && char2D[2][1] == 'O' && char2D[2][2] == 'O') {
            o++;
            return true;
        }

        if (char2D[0][0] == 'O' && char2D[1][0] == 'O' && char2D[2][0] == 'O') {
            o++;
            return true;
        }

        if (char2D[0][1] == 'O' && char2D[1][1] == 'O' && char2D[2][1] == 'O') {
            o++;
            return true;
        }

        if (char2D[0][2] == 'O' && char2D[1][2] == 'O' && char2D[2][2] == 'O') {
            o++;
            return true;
        }

        if (char2D[0][0] == 'O' && char2D[1][1] == 'O' && char2D[2][2] == 'O') {
            o++;
            return true;
        }

        if (char2D[2][0] == 'O' && char2D[1][1] == 'O' && char2D[0][2] == 'O') {
            o++;
            return true;
        }

        return false;
    }

    public static boolean xWins(char[][] char2D) {
        if (char2D[0][0] == 'X' && char2D[0][1] == 'X' && char2D[0][2] == 'X') {
            x++;
            return true;
        }

        if (char2D[1][0] == 'X' && char2D[1][1] == 'X' && char2D[1][2] == 'X') {
            x++;
            return true;
        }

        if (char2D[2][0] == 'X' && char2D[2][1] == 'X' && char2D[2][2] == 'X') {
            x++;
            return true;
        }

        if (char2D[0][0] == 'X' && char2D[1][0] == 'X' && char2D[2][0] == 'X') {
            x++;
            return true;
        }

        if (char2D[0][1] == 'X' && char2D[1][1] == 'X' && char2D[2][1] == 'X') {
            x++;
            return true;
        }

        if (char2D[0][2] == 'X' && char2D[1][2] == 'X' && char2D[2][2] == 'X') {
            x++;
            return true;
        }

        if (char2D[0][0] == 'X' && char2D[1][1] == 'X' && char2D[2][2] == 'X') {
            x++;
            return true;
        }

        if (char2D[2][0] == 'X' && char2D[1][1] == 'X' && char2D[0][2] == 'X') {
            x++;
            return true;
        }

        return false;
    }

    public static String checkWinner(char[][] char2D) {
        int xc = 0;
        int oc = 0;
        for (char[] char1D : char2D) {
            for (char c : char1D) {
                if (Character.valueOf(c).equals('X')) {
                    xc++;
                }
                if (Character.valueOf(c).equals('O')) {
                    oc++;
                }
            }
        }

        if (xWins(char2D)) {
            return "X wins";
        }

        if(oWins(char2D)) {
            return "O wins";
        }

        if (char2D[0][0] != ' ' && char2D[0][1] != ' ' && char2D[0][2] != ' ' &&
                char2D[1][0] != ' ' &&
                char2D[1][1] != ' ' && char2D[1][2] != ' ' && char2D[2][0] != ' ' &&
                char2D[2][1] != ' '
                && char2D[2][2] != ' ') {
            return "Draw";
        }

        return "";
    }
}