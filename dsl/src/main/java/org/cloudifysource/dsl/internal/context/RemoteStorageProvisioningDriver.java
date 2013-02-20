package org.cloudifysource.dsl.internal.context;

import java.rmi.Remote;

import org.cloudifysource.dsl.context.ServiceContext;

/**
 * This interface exposes Storage API methods that can be executed over LRMI from the USM to the ESM.
 * servers as an entry point for services that wish to use the storage functionality at runtime via the {@link ServiceContext}
 * @author elip
 *
 */
public interface RemoteStorageProvisioningDriver extends Remote {
	
	String hello();

}
