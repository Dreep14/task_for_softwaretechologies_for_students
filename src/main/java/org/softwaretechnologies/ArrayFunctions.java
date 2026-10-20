package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }

    /**
     * Функция, меняющая порядок элементов в массиве array на обратный.
     * @param array массив, который будет перевернут.
     */
    public static void reverse(int[] array) {
        // TODO: реализуйте вышеуказанную функцию
        int temp;

        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];

            array[i] = array[array.length - 1 - i];

            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * Функция, заменяющая строки матрицы на столбцы матрицы. Пример:
       1  2  3     1  4  7
       4  5  6     2  5  8
       7  8  9     3  6  9
     * Функция работает только с квадратными матрицами.
     * Если матрица не квадратная, то выведете на экран сообщение:
       Матрица не квадратная
     * @param matrix матрица, в которой столбцы будут заменены на строки.
     */
    public static void rotateMatrix(int[][] matrix) {
        // TODO: реализуйте вышеуказанную функцию
        if (matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i].length != matrix.length) {
                System.out.println("Матрица не квадратная");
                return;
            }
        }

        int temp;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = i + 1; j < matrix.length; j++) {

                temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];

                matrix[j][i] = temp;
            }
        }
    }
}
