import java.util.Scanner;

public class TicTacToe_MULTIPLAYER {

    public static String[][] scene = new String[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        createField();

        int player = 0;
        String XorO = "";
        while (true) {
            System.out.print("Type it the position in the field [ 1 - 9 ]: > ");
            String position = scanner.next();

            if ((player % 2) == 0) {
                XorO = "X";
            } else if ((player % 2) != 0) {
                XorO = "O";
            }

            switch (position) {
            case "1":
                if (checkField(0, 0)) {
                    updateField(0, 0, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "2":
                if (checkField(0, 1)) {
                    updateField(0, 1, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "3":
                if (checkField(0, 2)) {
                    updateField(0, 2, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "4":
                if (checkField(1, 0)) {
                    updateField(1, 0, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "5":
                if (checkField(1, 1)) {
                    updateField(1, 1, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "6":
                if (checkField(1, 2)) {
                    updateField(1, 2, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "7":
                if (checkField(2, 0)) {
                    updateField(2, 0, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "8":
                if (checkField(2, 1)) {
                    updateField(2, 1, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            case "9":
                if (checkField(2, 2)) {
                    updateField(2, 2, XorO);
                } else {
                    System.out.println("Invalid move!");
                }
                break;
            default:
                System.out.println("Invalid move!");
                continue;
            }

            showField();

            if (checkWin()) {
                break;
            } else if (checkLose()) {
                break;
            }
            player++;
        }

        scanner.close();
    }

    public static void createField() {
        for (int i = 0; i < scene.length; i++) {
            for (int j = 0; j < scene[i].length; j++) {
                scene[i][j] = " ";
            }
        }
    }

    public static boolean checkField(int line, int position) {
        if (scene[line][position] != " ") { // If the position has already been taken
            return false;
        } else {
            return true;
        }
    }

    public static void updateField(int line, int position, String XorO) {
        scene[line][position] = XorO;
    }

    public static void showField() {
        for (int i = 0; i < scene.length; i++) {
            for (int j = 0; j < scene[i].length; j++) {
                System.out.print(scene[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin() {
        boolean Xwin = false;
        boolean Owin = false;

        if (scene[0][0].equals("X") && scene[0][1].equals("X") && scene[0][2].equals("X")) { // Horizontal lines
            Xwin = true;
        } else if (scene[0][0].equals("O") && scene[0][1].equals("O") && scene[0][2].equals("O")) {
            Owin = true;
        } else if (scene[1][0].equals("X") && scene[1][1].equals("X") && scene[1][2].equals("X")) {
            Xwin = true;
        } else if (scene[1][0].equals("O") && scene[1][1].equals("O") && scene[1][2].equals("O")) {
            Owin = true;
        } else if (scene[2][0].equals("X") && scene[2][1].equals("X") && scene[2][2].equals("X")) {
            Xwin = true;
        } else if (scene[2][0].equals("O") && scene[2][1].equals("O") && scene[2][2].equals("O")) {
            Owin = true;
        }

        if (scene[0][0].equals("X") && scene[1][0].equals("X") && scene[2][0].equals("X")) { // Vertical lines
            Xwin = true;
        } else if (scene[0][0].equals("O") && scene[1][0].equals("O") && scene[2][0].equals("O")) {
            Owin = true;
        } else if (scene[0][1].equals("X") && scene[1][1].equals("X") && scene[2][1].equals("X")) {
            Xwin = true;
        } else if (scene[0][1].equals("O") && scene[1][1].equals("O") && scene[2][1].equals("O")) {
            Owin = true;
        } else if (scene[0][2].equals("X") && scene[1][2].equals("X") && scene[2][2].equals("X")) {
            Xwin = true;
        } else if (scene[0][2].equals("O") && scene[1][2].equals("O") && scene[2][2].equals("O")) {
            Owin = true;
        }

        if (scene[0][0].equals("X") && scene[1][1].equals("X") && scene[2][2].equals("X")) { // Crossed lines
            Xwin = true;
        } else if (scene[0][0].equals("O") && scene[1][1].equals("O") && scene[2][2].equals("O")) {
            Owin = true;
        } else if (scene[2][0].equals("X") && scene[1][1].equals("X") && scene[0][2].equals("X")) {
            Xwin = true;
        } else if (scene[2][0].equals("O") && scene[1][1].equals("O") && scene[2][2].equals("O")) {
            Owin = true;
        } else if (scene[0][2].equals("X") && scene[1][1].equals("X") && scene[2][0].equals("X")) {
            Xwin = true;
        } else if (scene[0][2].equals("O") && scene[1][1].equals("O") && scene[2][0].equals("O")) {
            Owin = true;
        } else if (scene[2][2].equals("X") && scene[1][1].equals("X") && scene[0][0].equals("X")) {
            Xwin = true;
        } else if (scene[2][2].equals("O") && scene[1][1].equals("O") && scene[0][0].equals("O")) {
            Owin = true;
        }

        if (Xwin) {
            System.out.println("X is the winner!");
            return true;
        } else if (Owin) {
            System.out.println("O is the winner!");
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkLose() { // It will check wheter it is actually possible to win anymore
        for (int i = 0; i < scene.length; i++) {
            for (int j = 0; j < scene[i].length; j++) {
                if (scene[i][j] == " ") {
                    return false;
                }
            }
        }
        System.out.println("No one won!");
        return true;
    }

    public static void fakeField() { // It generates a ' fake field ' for testing / development
        scene[0][0] = "X";
        scene[0][1] = "X";
        scene[0][2] = "O";
        scene[1][0] = "X";
        scene[1][1] = "O";
        scene[1][2] = "X";
        scene[2][0] = "O";
        scene[2][1] = "O";
        scene[2][2] = "O";
    }
}
