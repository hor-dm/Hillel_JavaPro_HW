public class ArrayDataException extends NumberFormatException {

    public ArrayDataException(int i, int j) {
        System.out.println("ArrayDataException says: Wrong array element, row: " + i + "  column: " + j);
    }
}
