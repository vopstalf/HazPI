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
     * Array for the internal storage of the lower triangular matrix L.
     *
     * @serial internal storage L matrix.
     */
    public double[][] L; //TODO change to private

    /**
     * Array for the internal storage of the upper triangular matrix U.
     *
     * @serial internal storage U matrix.
     */
    public double[][] U; //TODO change to private

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

        for(int j=0; j<n; j++){
            U[0][j] = A[0][j];
        }

        for(int i=0; i<m; i++){
            L[i][0] = A[i][0]/U[0][0];
            L[i][i] =1;
        }

        for(int j = 0; j<n;j++) {
            for (int i = 1; i < m - 1; i++) {
                s = 0;
                for (int t = 0; t < i - 1; t++) {
                    s += L[i][t] * U[t][j];
                }
                U[i][i] = A[i][i] - s;
                U[i][j] = A[i][j] - s;
                L[j][i] = (A[j][i] - s) / U[i][i];
            }
        }
        s = 0;
        for (int t = 0; t < n-2; t++) {
            s += L[n-1][t] * U[t][n-1];
        }
        U[n-1][n-1]=A[n-1][n-1]-s;
        //TODO implement LU decomposition
    }

    public void decomposeLU2() {
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
        //TODO implement LU decomposition
    }
}
