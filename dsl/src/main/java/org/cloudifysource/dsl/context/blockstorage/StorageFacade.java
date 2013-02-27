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

package org.cloudifysource.dsl.context.blockstorage;

import java.rmi.RemoteException;

/**
 * 
 * @author elip
 *
 */
public interface StorageFacade {
	
	/**
	 * 
	 * Attaches a volume storage device to the local machine.
	 * This method will also mount the device onto the FileSystem so it will be ready to use.
	 * @param volumeId - the id of the volume to be attached.
	 * @param device - the device name of the volume.
	 * @param path - the path of the storage volume in the local file system.
	 * @throws RemoteException - thrown in case something went wrong during the remote call.
	 */
	void attachVolume(final String volumeId, final String device, final String path) throws RemoteException;
	
	
	/**
	 * 
	 * @param templateName - the storage template name to be used when creating the volume.
	 * @return the volume id.
	 */
	String createVolume(final String templateName);

}
