package org.datagrid.poc.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@SuppressWarnings("deprecation")
public class CacheManager {
	static Cache<Integer, Vehicle> vehicleCache;
	static Cache<Integer, NativeVehicle> vehicleNativeCache;
	static EmbeddedCacheManager manager,nativeVehicleManager;

	static {
		if (vehicleCache == null) {
			try {
				manager = new DefaultCacheManager();
				manager.defineConfiguration("Vehicle-Cache", new ConfigurationBuilder().eviction().size(20)
						.strategy(EvictionStrategy.LIRS).expiration().maxIdle(13, TimeUnit.SECONDS).build());
				vehicleCache = manager.getCache("Vehicle-Cache");
			} catch (Exception E) {
				if (manager != null) {
					try {
						manager.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (vehicleNativeCache == null) {
			try {
				nativeVehicleManager = new DefaultCacheManager();
				nativeVehicleManager.defineConfiguration("Native-Vehicle-Cache", new ConfigurationBuilder().eviction().size(20)
						.strategy(EvictionStrategy.LIRS).expiration().maxIdle(13, TimeUnit.SECONDS).build());
				vehicleNativeCache = nativeVehicleManager.getCache("Native-Vehicle-Cache");
			} catch (Exception E) {
				if (nativeVehicleManager != null) {
					try {
						nativeVehicleManager.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static Cache<Integer, Vehicle> getVehiclecache() {
		return vehicleCache;
	}

	public static Cache<Integer, NativeVehicle> getNativeVehiclecache() {
		return vehicleNativeCache;
	}
}
