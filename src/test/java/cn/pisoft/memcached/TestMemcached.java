package cn.pisoft.memcached;

import com.whalin.MemCached.MemCachedClient;

import org.junit.AfterClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestMemcached extends TestCase{
	
	@AfterClass
	public void afterClass(){
		MemcachedFactory.getInstance().flushAll();
	}
	
	@Test
	public void testSet(){
		MemCachedClient mcc= MemcachedFactory.getInstance();
		mcc.set("test", "test");
		assertEquals(mcc.get("test"), "test");
	}

}
