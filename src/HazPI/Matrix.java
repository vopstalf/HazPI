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
    private final double[][] A;

    /**
     * Array for the internal storage of the lower triangular matrix L.
     *
     * @serial internal storage L matrix.
     */
    private double[][] L;

    /**
     * Array for the internal storage of the upper triangular matrix U.
     *
     * @serial internal storage U matrix.
     */
    private double[][] U;

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
        L = new double[m][m];
        U = new double[n][n];
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
        return A[i][j];
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
        A[i][j] = value;
    }

    /**
     * Performs LU decomposition of the matrix object.
     *
     * Uses Doolittle algorithm
     */
    public void decomposeLU() {

        for(int j=0; j<n; j++){
            U[1][j] = A[1][j];
        }

        for(int i=0; i<m; i++){
            L[i][1] = A[i][1]/U[1][1];
        }


        for(int i = 0; i<m; i++){
            //nothing
        }
        //TODO implement LU decomposition
    }
}
