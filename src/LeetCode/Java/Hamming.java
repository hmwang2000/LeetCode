package LeetCode.Java;

public class Hamming {
	public int hammingDistance(int x, int y) {
	    int i = x ^ y;
	    int count=0;
	    while (i != 0) {
	        ++ count;
	        i = (i-1)& i;
	    }
	    return count;
	}   
	public static void main(String[] args) {
        Hamming s = new Hamming();
        System.out.println(s.hammingDistance(1, 4));
        assert(s.hammingDistance(1, 0) == 1);
        assert(s.hammingDistance(1, 1) == 0);
    }
}
