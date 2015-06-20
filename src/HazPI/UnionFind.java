package HazPI;
/**
 * Quick Union Find Algorithm
 *
 * @author Filip Van Opstal <van_opstal_filip@hotmail.com>
 * @version 0.1
 * @since 2015-06-20
 */
public class UnionFind {
     /*
     * ----------------------------Fields--------------------------------------
     */

    /**
     * Array for internally storing connected object sets.
     *
     * @serial connected sets array.
     */
    private int[] id;


     /*
     * ----------------------------Constructors---------------------------------
     */

    /**
     * Construct an m-by-n matrix of zeros.
     *
     * @param n Number of objects.
     */
    public UnionFind(int n){
        id = new int[n];
        for(int i = 0; i<n;i++){
            id[i]=i;
        }
    }

    /*
     * ----------------------------Methods------------------------------------
     */

    /**
     * Gets the root object of a given object.
     *
     * @param i Index of the object.
     * @return Index of the root object of object i.
     * @throws ArrayIndexOutOfBoundsException
     */
    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    /**
     * Checks if two objects are connected.
     *
     * @param p Index of the first object.
     * @param q Index of the second object.
     * @return Boolean indicating if both objects are connected.
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean connected(int p, int q){
       return root(p)== root(q);
    }
    /**
     * Adds connection between two objects.
     *
     * @param p Index of the first object.
     * @param q Index of the second object.
     * @throws ArrayIndexOutOfBoundsException
     */
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

}
