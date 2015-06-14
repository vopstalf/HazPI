package HazPI;
/**
 * @author Filip Van Opstal <van_opstal_filip@hotmail.com>
 * @version 0.1
 * @since 2015-06-14
 */
public class Matrix implements Cloneable {

    /*
     * ----------------------------Fields--------------------------------------
     */

    /**
     * Array for the internal storage of the matrix elements.
     *
     * @serial internal storage matrix.
     */
    public final double[][] A; //TODO change to private

    /**
     * Row and column dimensions.
     *
     * @serial row and column dimension.
     */
    private final int m, n;

    /*
     * ----------------------------Constructors---------------------------------
     */

    /**
     * Construct an m-by-n matrix of zeros.
     *
     * @param m Number of rows.
     * @param n Number of colums.
     */

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        A = new double[m][n];
    }

    /*
     * ----------------------------Methods------------------------------------
     */

    /**
     * Get a single element.
     *
     * @param i Row index.
     * @param j Column index.
     * @return A(i, j)
     * @throws ArrayIndexOutOfBoundsException
     */

    public double get(int i, int j) {
        return A[i-1][j-1];
    }

    /**
     * Set a single element.
     *
     * @param i     Row index.
     * @param j     Column index.
     * @param value Value to be assigned to A(i,j)
     * @throws ArrayIndexOutOfBoundsException
     */

    public void set(int i, int j, double value) {
        A[i-1][j-1] = value;
    }

    /**
     * Performs LU decomposition of the matrix object.
     *
     * Uses Doolittle algorithm
     */
    public void decomposeLU() {
        double s;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i;j++){
                s = A[i][j];
                for(int p = 0;p<j;p++){
                    s -= A[i][p]*A[p][j];
                }
                A[i][j] = s/A[j][j];
            }
            for(int j=i;j<n;j++){
                s = A[i][j];
                for(int p =0;p<i;p++){
                    s = s - A[i][p]*A[p][j];
                }
                A[i][j]=s;
            }
        }
    }
}
