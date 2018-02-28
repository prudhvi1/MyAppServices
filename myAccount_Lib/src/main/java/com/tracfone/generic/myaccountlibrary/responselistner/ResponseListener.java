package com.tracfone.generic.myaccountlibrary.responselistner;

import com.octo.android.robospice.persistence.exception.SpiceException;

public interface ResponseListener {
	public void OnNetworkResponse(Object response, boolean status,String cacheKey);
	public void OnNetworkFailure(SpiceException spiceexception);
}
