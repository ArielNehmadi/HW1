import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (array.length == 0) {
            return array;
        }
        if (direction != 'L' && direction != 'R') {
            return array;
        }
        int length = array.length;
        if (move<0) {
            move = -move;
            direction = (direction == 'L') ? 'R' : 'L';
        }
        move = move % length;
        if (move == 0) {
            return array;
        }
        
        if (direction == 'R') { 
            int [] firstPart = Arrays.copyOfRange(array, length - move, length);
            int [] secondPart = Arrays.copyOfRange(array, 0, length - move);
            System.arraycopy(firstPart, 0, array, 0, firstPart.length);
            System.arraycopy(secondPart, 0, array, firstPart.length, secondPart.length);
        }
        if (direction == 'L') {
            int [] firstPart = Arrays.copyOfRange(array, move, length);
            int [] secondPart = Arrays.copyOfRange(array, 0, move);
            System.arraycopy(firstPart, 0, array, 0, firstPart.length);
            System.arraycopy(secondPart, 0, array, firstPart.length, secondPart.length);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}