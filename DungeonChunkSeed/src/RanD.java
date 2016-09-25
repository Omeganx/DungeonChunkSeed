
import java.util.Random;

public class RanD {
	
	long seed;
	
	public RanD(long s){
		this.seed = (s ^ 0x5DEECE66DL) & ((1L << 48) - 1);
	}
	
	public RanD(){
		Random ran = new Random();
		this.seed = ran.nextLong();
	}
	
	public void initSeed(long s){
		this.seed = (s ^ 0x5DEECE66DL) & ((1L << 48) - 1);
	}
	
	public int nextInteger(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n must be positive");
		if ((n & -n) == n)  
			return (int)((n * (long)next(31)) >> 31);
		int bits, val;
		do {
			bits = next(31);
			val = bits % n;
		} while (bits - val + (n-1) < 0);
		
		return val;
	}
	
	public long nextLong() {
		return ((long)next(32) << 32) + next(32);
	}
	
	private int next(int bits) {
		seed = (this.seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
		return (int)(this.seed >>> (48 - bits));
	}
	 
	public void next(){
		seed = (this.seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
	}
	
	public double nextDouble() {
		return (((long)next(26) << 27) + next(27)) / (double)(1L << 53);
	}
	
	public long getSeed(){
		return this.seed;
	}
	
	public void setSeed(long s){
		this.seed = s;
	}
}
