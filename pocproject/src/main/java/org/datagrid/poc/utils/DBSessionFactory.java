package org.datagrid.poc.utils;
import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class DBSessionFactory {
	
	static StandardServiceRegistry standardServiceRegistry ;
	static SessionFactory sessionFactory;
	static
	{
	   if (sessionFactory == null) {
		   try
		   {
		    standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(standardServiceRegistry)
            		.addAnnotatedClass(Vehicle.class)
            		.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
		   }
		   catch(Exception E)
		   {
			   E.printStackTrace();
			   if (standardServiceRegistry != null) {
			          StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			     }
		   }
        }
	}
	public static SessionFactory getSessionFactory()
	{		
	        return sessionFactory;
	}

}
