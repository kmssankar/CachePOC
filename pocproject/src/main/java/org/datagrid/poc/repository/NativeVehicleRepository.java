package org.datagrid.poc.repository;

import org.datagrid.poc.Dao.VehicleDaoNativeQuery;
import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.datagrid.poc.utils.CacheManager;
import org.infinispan.Cache;
import org.springframework.stereotype.Repository;

@Repository
public class NativeVehicleRepository implements ObjectRepository<NativeVehicle> {
	Cache <Integer,NativeVehicle> nativrvehicleCache = CacheManager.getNativeVehiclecache();	
	private VehicleDaoNativeQuery vehicleDaoNative = new VehicleDaoNativeQuery();
	public NativeVehicle retrive(int id) {
		NativeVehicle nativeVeh = null;
		if(nativrvehicleCache.get(id) == null)
		{
		nativeVeh = vehicleDaoNative.getVehiclenative(id); 
		nativrvehicleCache.put(id, nativeVeh);
		}
		else {
			nativeVeh = nativrvehicleCache.get(id);
		}
		return nativeVeh;
	}

}
