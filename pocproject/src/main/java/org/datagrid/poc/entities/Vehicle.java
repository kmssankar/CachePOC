package org.datagrid.poc.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * The persistent class for the vehicle database table.
 * 
 */
@Table(name = "vehicle")
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
/*@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")*/

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int unitid;
	@Column(name="dummyvin",length=17,columnDefinition="CHAR")
	private String dummyvin;
	@Column(name="modelcd",length=4,columnDefinition="CHAR")
	private String modelcd;
	@Column(name="modelyr",length=4,columnDefinition="CHAR")
	private String modelyr;
	@Column(name="vin",length=17,columnDefinition="CHAR")
	private String vin;

	public Vehicle() {
	}

	public int getUnitid() {
		return this.unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public String getDummyvin() {
		return this.dummyvin;
	}

	public void setDummyvin(String dummyvin) {
		this.dummyvin = dummyvin;
	}

	public String getModelcd() {
		return this.modelcd;
	}

	public void setModelcd(String modelcd) {
		this.modelcd = modelcd;
	}

	public String getModelyr() {
		return this.modelyr;
	}

	public void setModelyr(String modelyr) {
		this.modelyr = modelyr;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public String toString() {
		return "Vehicle [unitid=" + unitid + ", dummyvin=" + dummyvin + ", modelcd=" + modelcd + ", modelyr=" + modelyr
				+ ", vin=" + vin + "]";
	}
}