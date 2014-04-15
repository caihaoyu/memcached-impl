package cn.pisoft.memcached;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcachedFactory {
private volatile static MemCachedClient mcc;
	
	static{
		String[] servers =
			{	"127.0.0.1:11211",
				"10.180.6.115:11211"
			
			};

			Integer[] weights = { 6,4};

			// grab an instance of our connection pool
			SockIOPool pool = SockIOPool.getInstance();

			// set the servers and the weights
			pool.setServers( servers );
			pool.setWeights( weights );

			// set some basic pool settings
			// 5 initial, 5 min, and 250 max conns
			// and set the max idle time for a conn
			// to 6 hours
			pool.setInitConn(20 );
			pool.setMinConn( 20 );
			pool.setMaxConn( 1024 );
			pool.setMaxIdle( 1000 * 60 * 60 * 6 );

			// set the sleep for the maint thread
			// it will wake up every x seconds and
			// maintain the pool size
			pool.setMaintSleep( 30 );

			// set some TCP settings
			// disable nagle
			// set the read timeout to 3 secs
			// and don't set a connect timeout
			pool.setNagle( false );
			pool.setSocketTO( 3000 );
			pool.setSocketConnectTO( 0 );
			
			pool.setAliveCheck(true);
			// initialize the connection pool
			pool.initialize();
	}
	
	public MemcachedFactory(){
		
	}
	
	public static MemCachedClient getInstance(){
		if(null==mcc){
			synchronized (MemCachedClient.class) {  
                if (mcc == null) {  
                    mcc = new MemCachedClient();  
                }  
            }  
        }  
        return mcc;  
		
	}

}
