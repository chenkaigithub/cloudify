/*******************************************************************************
 * Copyright (c) 2011 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.cloudifysource.esc.driver.provisioning.storage;

import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import org.cloudifysource.dsl.internal.context.RemoteStorageProvisioningDriver;

/**
 * 
 * @author elip
 *
 */
public class RemoteStorageProvisioningDriverAdapter implements RemoteStorageProvisioningDriver {

	private StorageProvisioningDriver storageProvisioningDriver;
	
	public RemoteStorageProvisioningDriverAdapter(final StorageProvisioningDriver driver) {
		this.storageProvisioningDriver = driver;
	}

	@Override
	public void attachVolume(final String volumeId, final String device, final String ip) throws RemoteException {
		try {
			long defaultDuration = 0;
			TimeUnit a = TimeUnit.SECONDS;
			storageProvisioningDriver.attachVolume(volumeId, device, ip, defaultDuration, a);
		} catch (final Exception e) {
			throw new RemoteException("Failed attaching volume with id " + volumeId 
					+ " to instance with ip " + ip + " : " + e.getMessage(), e);
		}
	}

	@Override
	public String createVolume(final String templateName) {	
		return null;
	}
	
	
}
