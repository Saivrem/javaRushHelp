package org.dustyRoom.tasks.syntax;

/**
 * task1012
 * Рассмотрим аналог памяти компьютера на примере массива строк. Если удалить некоторые элементы,
 * то в массиве появятся так называемые "дыры" - то есть элементы равные null.
 * Метод executeDefragmentation(String[]), принимающий массив строк, выполняет его "дефрагментацию",
 * то есть перемещает все объекты в начало массива в таком же порядке,
 * передвинув все "дыры" (элементы равные null) в конец массива.
 * В этой задаче тебе нужно реализовать метод executeDefragmentation(String[]).
 */
public class Defragmentation {

    /**
     * Executes defragmentation on an array by moving all non-null elements to the beginning and filling the remaining null elements at the end.
     *
     * @param array the array to be defragmented
     */
    public static void executeDefragmentation(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != null) {
                        array[i] = array[j];
                        array[j] = null;
                        break;
                    }
                    if (j == array.length - 1) {
                        return;
                    }
                }
            }
        }
    }
}