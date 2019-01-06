package org.datagrid.poc.repository;

import org.datagrid.poc.Dao.VehicleDaoNativeQuery;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.springframework.stereotype.Repository;

@Repository
public class NativeVehicleRepository implements ObjectRepository<NativeVehicle> {
	private VehicleDaoNativeQuery vehicleDaoNative = new VehicleDaoNativeQuery();
	public NativeVehicle retrive(int id) {
		NativeVehicle nativeVeh = vehicleDaoNative.getVehiclenative(id); 
		return nativeVeh;
	}

}
