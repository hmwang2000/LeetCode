package LeetCode.Java;

public class Complement {
	public int findComplement(int num) {
		int valid = 0;  // 最高位为1的位数
	    int tmp = num;
	    while(tmp > 0) {
	        tmp /= 2;
	        valid++;
	    }
	    return ~num & ((1 << valid) - 1);
	}
    int findComplement2(int num) {
        int temp = num, mask = 1;
        while(temp != 0) {
            temp = temp >> 1;
            mask = mask << 1;
        }
        return num ^ (mask - 1);
    }
	public static void main(String[] args) {
		Complement s = new Complement();
	    assert(s.findComplement(5) == 2);
	    assert(s.findComplement(1) == 0);
	    assert(s.findComplement(0) == 0);
	    
	    int n = 45;
	    System.out.println(Integer.toBinaryString(n));
	}
}
