package org.datagrid.poc.nativeentities;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Cacheable
public class NativeVehicle {
	private int unitid;
	private String dummyvin;
	private String vin;
	private String modelyr;
	private String modelcd;
	private double msrp;
	private double distprice;
	private double dlrprice;
	private double accyprice;
	private double factoryaccyprice;
	private double ppoaccyprice;
	
	public NativeVehicle(int unitid, String dummyvin, String vin, String modelyr, String modelcd, double msrp,
			double distprice, double dlrprice, double accyprice, double factoryaccyprice, double ppoaccyprice) {
		super();
		this.unitid = unitid;
		this.dummyvin = dummyvin;
		this.vin = vin;
		this.modelyr = modelyr;
		this.modelcd = modelcd;
		this.msrp = msrp;
		this.distprice = distprice;
		this.dlrprice = dlrprice;
		this.accyprice = accyprice;
		this.factoryaccyprice = factoryaccyprice;
		this.ppoaccyprice = ppoaccyprice;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getDummyvin() {
		return dummyvin;
	}
	public void setDummyvin(String dummyvin) {
		this.dummyvin = dummyvin;
	}
	public String getModelcd() {
		return modelcd;
	}
	public void setModelcd(String modelcd) {
		this.modelcd = modelcd;
	}
	public String getModelyr() {
		return modelyr;
	}
	public void setModelyr(String modelyr) {
		this.modelyr = modelyr;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getAccyprice() {
		return accyprice;
	}
	public void setAccyprice(double accyprice) {
		this.accyprice = accyprice;
	}
	public double getDistprice() {
		return distprice;
	}
	public void setDistprice(double distprice) {
		this.distprice = distprice;
	}
	public double getDlrprice() {
		return dlrprice;
	}
	public void setDlrprice(double dlrprice) {
		this.dlrprice = dlrprice;
	}
	public double getFactoryaccyprice() {
		return factoryaccyprice;
	}
	public void setFactoryaccyprice(double factoryaccyprice) {
		this.factoryaccyprice = factoryaccyprice;
	}
	public double getMsrp() {
		return msrp;
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	public double getPpoaccyprice() {
		return ppoaccyprice;
	}
	public void setPpoaccyprice(double ppoaccyprice) {
		this.ppoaccyprice = ppoaccyprice;
	}
}
