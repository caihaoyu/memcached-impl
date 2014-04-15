package cn.pisoft.memcached;

import com.whalin.MemCached.MemCachedClient;

public class MemMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  MemCachedClient mcc= MemcachedFactory.getInstance();
		  //设置为永不过期
//		  mcc.set("foo", "hello world",new Date(0));
		  mcc.flushAll();
//		  System.out.println(mcc.get("foo"));

	}

}
