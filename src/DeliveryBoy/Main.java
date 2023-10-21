package DeliveryBoy;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] neighborhood = new char[rows][cols];
        fillMatrix(neighborhood, scanner);

        int[] boyCoords = findBoyCoords(neighborhood);
        int boyRow = boyCoords[0];
        int boyCol = boyCoords[1];
        int currentRow = boyRow;
        int currentCol = boyCol;

        String command = scanner.nextLine();
        boolean isPizzaCollected = false;

        while (true) {
            switch (command) {
                case "up":
                    if (canMove(neighborhood, currentRow - 1, currentCol)) {
                        char nextSymbol = neighborhood[currentRow - 1][currentCol];
                        char currentSymbol = neighborhood[currentRow][currentCol];
                        if (nextSymbol == '-' || nextSymbol == '.') {
                            if (currentSymbol != 'R') {
                                neighborhood[currentRow][currentCol] = '.';
                                neighborhood[currentRow - 1][currentCol] = 'B';
                                currentRow = currentRow - 1;
                            } else {
                                neighborhood[currentRow - 1][currentCol] = 'B';
                                currentRow = currentRow - 1;
                            }
                        } else if (nextSymbol == '*') {
                            break;
                        } else if (nextSymbol == 'P') {
                            neighborhood[currentRow][currentCol] = '.';
                            neighborhood[currentRow - 1][currentCol] = 'R';
                            currentRow = currentRow - 1;
                            isPizzaCollected = true;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextSymbol == 'R') {
                            neighborhood[currentRow][currentCol] = '.';
                            currentRow = currentRow - 1;
                        } else if (nextSymbol == 'A') {
                            if (currentSymbol != 'R') {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow - 1][currentCol] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[currentRow][currentCol] = '.';
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    neighborhood[currentRow][currentCol] = '.';
                                    currentRow = currentRow - 1;
                                }
                            } else {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow - 1][currentCol] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    currentRow = currentRow - 1;
                                }
                            }
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        neighborhood[boyRow][boyCol] = ' ';
                        printMatrix(neighborhood);
                        return;
                    }
                    break;
                case "down":
                    if (canMove(neighborhood, currentRow + 1, currentCol)) {
                        char nextSymbol = neighborhood[currentRow + 1][currentCol];
                        char currentSymbol = neighborhood[currentRow][currentCol];
                        if (nextSymbol == '-' || nextSymbol == '.') {
                            if (currentSymbol != 'R') {
                                neighborhood[currentRow][currentCol] = '.';
                                neighborhood[currentRow + 1][currentCol] = 'B';
                                currentRow = currentRow + 1;
                            } else {
                                neighborhood[currentRow + 1][currentCol] = 'B';
                                currentRow = currentRow + 1;
                            }
                        } else if (nextSymbol == '*') {
                            break;
                        } else if (nextSymbol == 'P') {
                            neighborhood[currentRow][currentCol] = '.';
                            neighborhood[currentRow + 1][currentCol] = 'R';
                            currentRow = currentRow + 1;
                            isPizzaCollected = true;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextSymbol == 'R') {
                            neighborhood[currentRow][currentCol] = '.';
                            currentRow = currentRow + 1;
                        } else if (nextSymbol == 'A') {
                            if (currentSymbol != 'R') {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow + 1][currentCol] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[currentRow][currentCol] = '.';
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    neighborhood[currentRow][currentCol] = '.';
                                    currentRow = currentRow + 1;
                                }
                            } else {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow + 1][currentCol] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    currentRow = currentRow + 1;
                                }
                            }
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        neighborhood[boyRow][boyCol] = ' ';
                        printMatrix(neighborhood);
                        return;
                    }
                    break;
                case "right":
                    if (canMove(neighborhood, currentRow, currentCol + 1)) {
                        char nextSymbol = neighborhood[currentRow][currentCol + 1];
                        char currentSymbol = neighborhood[currentRow][currentCol];
                        if (nextSymbol == '-' || nextSymbol == '.') {
                            if (currentSymbol != 'R') {
                                neighborhood[currentRow][currentCol] = '.';
                                neighborhood[currentRow][currentCol + 1] = 'B';
                                currentCol = currentCol + 1;
                            } else {
                                neighborhood[currentRow][currentCol + 1] = 'B';
                                currentCol = currentCol + 1;
                            }
                        } else if (nextSymbol == '*') {
                            break;
                        } else if (nextSymbol == 'P') {
                            neighborhood[currentRow][currentCol] = '.';
                            neighborhood[currentRow][currentCol + 1] = 'R';
                            currentCol = currentCol + 1;
                            isPizzaCollected = true;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextSymbol == 'R') {
                            neighborhood[currentRow][currentCol] = '.';
                            currentCol = currentCol + 1;
                        } else if (nextSymbol == 'A') {
                            if (currentSymbol != 'R') {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow][currentCol + 1] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[currentRow][currentCol] = '.';
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    neighborhood[currentRow][currentCol] = '.';
                                    currentCol = currentCol + 1;
                                }
                            } else {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow][currentCol + 1] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    currentCol = currentCol + 1;
                                }
                            }
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        neighborhood[boyRow][boyCol] = ' ';
                        printMatrix(neighborhood);
                        return;
                    }
                    break;
                case "left":
                    if (canMove(neighborhood, currentRow, currentCol - 1)) {
                        char nextSymbol = neighborhood[currentRow][currentCol - 1];
                        char currentSymbol = neighborhood[currentRow][currentCol];
                        if (nextSymbol == '-' || nextSymbol == '.') {
                            if (currentSymbol != 'R') {
                                neighborhood[currentRow][currentCol] = '.';
                                neighborhood[currentRow][currentCol - 1] = 'B';
                                currentCol = currentCol - 1;
                            } else {
                                neighborhood[currentRow][currentCol - 1] = 'B';
                                currentCol = currentCol - 1;
                            }
                        } else if (nextSymbol == '*') {
                            break;
                        } else if (nextSymbol == 'P') {
                            neighborhood[currentRow][currentCol] = '.';
                            neighborhood[currentRow][currentCol - 1] = 'R';
                            currentCol = currentCol - 1;
                            isPizzaCollected = true;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextSymbol == 'R') {
                            neighborhood[currentRow][currentCol] = '.';
                            currentCol = currentCol - 1;
                        } else if (nextSymbol == 'A') {
                            if (currentSymbol != 'R') {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow][currentCol - 1] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[currentRow][currentCol] = '.';
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    neighborhood[currentRow][currentCol] = '.';
                                    currentCol = currentCol - 1;
                                }
                            } else {
                                if (isPizzaCollected) {
                                    neighborhood[currentRow][currentCol - 1] = 'P';
                                    System.out.println("Pizza is delivered on time! Next order...");
                                    neighborhood[boyRow][boyCol] = 'B';
                                    printMatrix(neighborhood);
                                    return;
                                } else {
                                    currentCol = currentCol - 1;
                                }
                            }
                        }
                    } else {

                        System.out.println("The delivery is late. Order is canceled.");
                        neighborhood[boyRow][boyCol] = ' ';
                        printMatrix(neighborhood);
                        return;
                    }
                    break;
            }


            command = scanner.nextLine();
        }
    }


    private static void printMatrix(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }


    private static boolean canMove(char[][] neighborhood, int boyRow, int boyCol) {
        if (boyRow >= 0 && boyRow < neighborhood.length && boyCol >= 0 && boyCol < neighborhood[boyRow].length) {
            return true;
        } else {
            return false;
        }
    }

    private static int[] findBoyCoords(char[][] neighborhood) {
        int[] coords = new int[2];
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col] == 'B') {
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



