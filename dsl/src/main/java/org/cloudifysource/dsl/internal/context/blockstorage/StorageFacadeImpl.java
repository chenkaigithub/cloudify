/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
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

package org.cloudifysource.dsl.internal.context.blockstorage;

import java.rmi.RemoteException;

import org.cloudifysource.dsl.context.ServiceContext;
import org.cloudifysource.dsl.context.blockstorage.StorageFacade;
import org.cloudifysource.dsl.internal.context.RemoteStorageProvisioningDriver;

/**
 * 
 * @author elip
 *
 */
public class StorageFacadeImpl implements StorageFacade {

	private ServiceContext serviceContext;
	private RemoteStorageProvisioningDriver remoteStorageProvisioningDriver;
	
	
	public StorageFacadeImpl(final ServiceContext serviceContext,
			final RemoteStorageProvisioningDriver storageApi) {
		this.serviceContext = serviceContext;
		this.remoteStorageProvisioningDriver = storageApi;
	}

	@Override
	public void attachVolume(final String volumeId, final String device, final String path) throws RemoteException {
		remoteStorageProvisioningDriver.attachVolume(volumeId, device, serviceContext.getPrivateAddress());
		
		// TODO eli - mount this device onto the FileSystem using the device name and the path.
		
	}

	@Override
	public String createVolume(final String templateName) {		
		return remoteStorageProvisioningDriver.createVolume(templateName);
	}
}
