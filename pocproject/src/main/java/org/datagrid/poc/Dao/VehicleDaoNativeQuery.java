package org.datagrid.poc.Dao;

import java.util.List;

import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.datagrid.poc.utils.DBSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class VehicleDaoNativeQuery {
	Vehicle vehicle = null;
	Session session = null;

	public NativeVehicle getVehiclenative(int unitid) {
		NativeVehicle nativeVehicle = null;
		try {
			session = DBSessionFactory.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			System.out.println("Inside Getvhicleunitid NativeQuery !! ");
			@SuppressWarnings("rawtypes")
			Query query = session.createNativeQuery(" SELECT " + "VE.UNITID as unitid ," + "VE.DUMMYVIN as dummyvin ,"
					+ "VE.VIN as vin , " + "VE.MODELYR as modelyr , " + "VE.MODELCD as modelcd , "
					+ "VF.MSRP as msrp , " + "VF.DISTPRICE as distprice , " + "VF.DLRPRICE as dlrprice  , "
					+ "VF.ACCYPRICE as accyprice, " + "VF.FACTORYACCYPRICE as factoryaccyprice, "
					+ "VF.PPOACCYPRICE as ppoaccyprice " + "FROM VEHICLE VE , " + "vehiclefinancial VF "
					+ "WHERE VE.UNITID =VF.UNITID " + "AND VE.UNITID = :UNITIDINP", "VehicleValueMapping");
			query.setParameter("UNITIDINP", unitid);
			List<NativeVehicle> nativeVeh = query.getResultList();
			if (nativeVeh.size() > 0) {
				nativeVehicle = nativeVeh.get(0);
			} else {
				nativeVehicle = new NativeVehicle(0, "NA", "NA", "NA", "NA", 0.00, 0.00, 0.00, 0.00, 0.00, 0.00);
			}
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return nativeVehicle;
	}

}
