
package org.datagrid.poc.Dao;

import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.utils.DBSessionFactory;
import org.hibernate.Session;
public class VehicleDao {
	
	
	public Vehicle getVehicleunitid(int unitid)
	{	
		Vehicle vehicle =null;
		Session session = null;
		try
		{
		session = DBSessionFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		System.out.println("Inside Getvhicleunitid !! ");
		vehicle = (Vehicle) session.get(Vehicle.class, new Integer (unitid));
		if (vehicle == null)
				{
				Vehicle vehicleDefault = new Vehicle();
				vehicleDefault.setDummyvin("Not Available");
				vehicleDefault.setVin("Not Available");
				vehicle = vehicleDefault;
				}
		}
		catch(Exception E)
		{
			System.out.println("Exception E " + E);
			E.printStackTrace();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }  
		}
		System.out.println("Vehicle " + vehicle);
		return vehicle;
	}
}
