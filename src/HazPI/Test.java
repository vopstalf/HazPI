package HazPI;
import java.util.Arrays;
/**
 * Created by Filip on 14/06/2015.
 *
 * Test File please ignore
 */
public class Test {

    public static void main(String[] args){
        Matrix matrix = new Matrix(2,2);

        matrix.set(1,1,4);
        matrix.set(1,2,3);
        matrix.set(2,1,6);
        matrix.set(2,2,3);

        matrix.decomposeLU();

        System.out.println(Arrays.deepToString(matrix.L));
        System.out.println(Arrays.deepToString(matrix.U));

    }
}
