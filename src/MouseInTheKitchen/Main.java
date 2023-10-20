package MouseInTheKitchen;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int rows = dimentions[0];
        int cols = dimentions[1];

        char[][] board = new char[rows][cols];

        fillMatrix(board, scanner);

        int[] mouseCoords = findMouseCoords(board);
        int mouseRow = mouseCoords[0];
        int mouseCol = mouseCoords[1];


        String line = scanner.nextLine();

        while (!"danger".equals(line)) {



            switch (line) {
                case "up":
                    //check if after the move the mouse will be inbound if not -> mouse eats it
                    if (checkOutOfBounds(board, mouseRow - 1, mouseCol)) {
                        if (board[mouseRow - 1][mouseCol] == 'T') {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow - 1][mouseCol] = 'M';
                            System.out.println("Mouse is trapped!");
                            printMatrix(board);
                            return;
                        } else if (board[mouseRow - 1][mouseCol] == '@') {
                            board[mouseRow][mouseCol] = 'M';
                        } else {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow - 1][mouseCol] = 'M';
                            mouseRow = mouseRow - 1;
                        }
                    } else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(board);
                        return;
                    }
                    break;
                case "down":
                    //check if after the move the mouse will be inbound
                    if (checkOutOfBounds(board, mouseRow + 1, mouseCol)) {
                        if (board[mouseRow + 1][mouseCol] == 'T') {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow + 1][mouseCol] = 'M';
                            System.out.println("Mouse is trapped!");
                            printMatrix(board);
                            return;
                        } else if (board[mouseRow + 1][mouseCol] == '@') {
                            board[mouseRow][mouseCol] = 'M';
                        } else {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow + 1][mouseCol] = 'M';
                            mouseRow = mouseRow + 1;
                        }
                    } else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(board);
                        return;
                    }
                    break;
                case "right":
                    //check if after the move the mouse will be inbound
                    if (checkOutOfBounds(board, mouseRow, mouseCol + 1)) {
                        if (board[mouseRow][mouseCol + 1] == 'T') {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow][mouseCol + 1] = 'M';
                            System.out.println("Mouse is trapped!");
                            printMatrix(board);
                            return;
                        } else if (board[mouseRow][mouseCol + 1] == '@') {
                            board[mouseRow][mouseCol] = 'M';
                        } else {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow][mouseCol + 1] = 'M';
                            mouseCol = mouseCol + 1;
                        }
                    } else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(board);
                        return;
                    }
                    break;
                case "left":
                    //check if after the move the mouse will be inbound
                    if (checkOutOfBounds(board, mouseRow, mouseCol - 1)) {
                        if (board[mouseRow][mouseCol - 1] == 'T') {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow][mouseCol - 1] = 'M';
                            System.out.println("Mouse is trapped!");
                            printMatrix(board);
                            return;
                        } else if (board[mouseRow][mouseCol - 1] == '@') {
                            board[mouseRow][mouseCol] = 'M';
                        } else {
                            board[mouseRow][mouseCol] = '*';
                            board[mouseRow][mouseCol - 1] = 'M';
                            mouseCol = mouseCol - 1;
                        }
                    } else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(board);
                        return;
                    }
                    break;
            }

            int cheeseCount = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'C') {
                        cheeseCount++;
                    }
                }
            }

            if (cheeseCount <= 0) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                printMatrix(board);
                return;
            }


            line = scanner.nextLine();
        }

        System.out.println("Mouse will come back later!");
        printMatrix(board);
    }

    private static void printMatrix(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkOutOfBounds(char[][] board, int mouseRow, int mouseCol) {

        return mouseRow >= 0 && mouseRow < board.length && mouseCol >= 0 & mouseCol < board[mouseRow].length;
    }

    private static int[] findMouseCoords(char[][] board) {
        int[] coords = new int[2];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char currentChar = board[row][col];


                if (currentChar == 'M') {
                    coords[0] = row;
                    coords[1] = col;
                }
            }
        }
        return coords;
    }


    private static void fillMatrix(char[][] matrix, Scanner s) {
        for (int row = 0; row < matrix.length; row++) {
            char[] rowData = s.nextLine().toCharArray();
            matrix[row] = rowData;
        }
    }

}
