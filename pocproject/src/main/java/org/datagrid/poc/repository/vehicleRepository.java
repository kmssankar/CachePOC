package org.datagrid.poc.repository;

import org.datagrid.poc.Dao.VehicleDao;
import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.utils.CacheManager;
import org.infinispan.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Implementing Generic method
@Repository
public class vehicleRepository implements ObjectRepository<Vehicle> {
	Cache <Integer,Vehicle> vehicleCache = CacheManager.getVehiclecache();	
	
	VehicleDao vehicledao = new VehicleDao();
	public Vehicle retrive(int id) {
		System.out.println("Cache Statistics : Name ->  " + vehicleCache.getName() + " Status Size ->  " + vehicleCache.size());
		System.out.println("Inside Retrive");
		Vehicle veh =null;
		try{
		veh =(Vehicle) vehicleCache.get(id);
		}
		catch(Exception E){
			E.printStackTrace();
		}
		if(veh == null){
		 System.out.println("Not in cache !! ");
		 veh = vehicledao.getVehicleunitid(id);
		 vehicleCache.put(id,veh);
		}
		System.out.println("Cache Statistics : " + vehicleCache.getStatus());
		return veh;
	}

}
