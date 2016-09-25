

public class DungeonSeed {

	@SuppressWarnings("unused")
	public static long getDungeonSeed(int chunk_x, int chunk_z, long seed){

	    RanD ran = new RanD();

	    int posx = chunk_x * 16;
	    int posz = chunk_z * 16;
	    ran.initSeed(seed);
	    
	    long k = ran.nextLong() / 2L * 2L + 1L;
	    long l = ran.nextLong() / 2L * 2L + 1L;
	    
	    ran.initSeed((long)chunk_x * k + (long)chunk_z * l ^ seed);
	    
	    if(ran.nextInteger(4) == 0){ //water lakes
	    	
	    	int i1 = ran.nextInteger(16) + 8;
	        int j1 = ran.nextInteger(256);
	        int k1 = ran.nextInteger(16) + 8;
	        
	        lakeGenerator(ran);
	    }
	    
	    if(ran.nextInteger(80 / 10)==0){//lava lakes
	    	
	    	int i2 = ran.nextInteger(16) + 8;
	        int l2 = ran.nextInteger(ran.nextInteger(248) + 8);
	        int k3 = ran.nextInteger(16) + 8;
	        
	        if (l2 < 63 || ran.nextInteger(80 / 8) == 0){
	        	lakeGenerator(ran);
	        }
	    }
	    return ran.getSeed();
	} 
	
	
	public static void lakeGenerator(RanD ran){
		int i2 = ran.nextInteger(4) + 4;
    	
		for (int j2 = 0; j2 < i2; ++j2)
		{
			for(int count = 0; count<6; count++){
				@SuppressWarnings("unused")
				double useless = ran.nextDouble();
			}
		}
	}
}
