package org.cloudifysource.esc.driver.provisioning.storage;

import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import org.cloudifysource.dsl.internal.context.RemoteStorageProvisioningDriver;

public class RemoteStorageProvisioningDriverAdapter implements RemoteStorageProvisioningDriver {

	private StorageProvisioningDriver storageProvisioningDriver;
	
	public RemoteStorageProvisioningDriverAdapter(StorageProvisioningDriver driver) {
		this.storageProvisioningDriver = driver;
	}

	@Override
	public void attachVolume(String volumeId, String ip, long duration,
			TimeUnit timeUnit) throws RemoteException {
		try {
			storageProvisioningDriver.attachVolume(volumeId, ip, duration, timeUnit);
		} catch (final Exception e) {
			throw new RemoteException("Failed attaching volume with id " + volumeId 
					+ " to instance with ip " + ip + " : " + e.getMessage(), e);
		}
	}

	@Override
	public String createVolume(String templateName) {
		
		
		
		return null;
	}
	
	
}
