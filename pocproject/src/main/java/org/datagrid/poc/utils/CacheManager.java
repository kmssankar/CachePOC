package org.datagrid.poc.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.datagrid.poc.entities.Vehicle;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@SuppressWarnings("deprecation")
public class CacheManager {
	static Cache <Integer,Vehicle > vehicleCache ;
	static EmbeddedCacheManager manager;
	
	static
	{
		try
		{
		manager = new DefaultCacheManager();
		manager.defineConfiguration("Vehicle-Cache", new ConfigurationBuilder()
				.eviction()
				.strategy(EvictionStrategy.LIRS)
				.maxEntries(20)
				.expiration().maxIdle(3, TimeUnit.SECONDS)
				.build());
		vehicleCache =manager.getCache("Vehicle-Cache");	
		}
		catch(Exception E)
		{
			if (manager != null)
			{
				try {
					manager.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Cache <Integer,Vehicle > getVehiclecache()
	{
		return vehicleCache;
	}
}
