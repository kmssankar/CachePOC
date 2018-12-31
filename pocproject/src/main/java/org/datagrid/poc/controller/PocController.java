package org.datagrid.poc.controller;

import org.datagrid.poc.entities.Vehicle;
import org.datagrid.poc.nativeentities.NativeVehicle;
import org.datagrid.poc.repository.NativeVehicleRepository;
import org.datagrid.poc.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocController {

	@Autowired
	vehicleRepository vehiclerepo;
	@Autowired
	NativeVehicleRepository nativeVehRepo;
	@GetMapping("/vehicle/get/{id}")
	public Vehicle getVehicle(@PathVariable("id") int id)
	{
		return vehiclerepo.retrive(id);
	}
	@GetMapping("/nativevehicle/get/{id}")
	public NativeVehicle nativevehicle(@PathVariable("id") int id)
	{
		return nativeVehRepo.retrive(id);
	}
}


