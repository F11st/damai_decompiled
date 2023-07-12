package com.ali.user.mobile.data;

import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.SmsApplyResponse;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResponseData;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DataRepository {
    private static DataRepository instance;

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    public void directRegister(RegistParam registParam, String str, RpcRequestCallback rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(RegisterComponent.getInstance().buildDirectRegisterRequest(registParam, str), OceanRegisterResponseData.class, rpcRequestCallback);
    }

    public void register(RegistParam registParam, OceanRegisterParam oceanRegisterParam, RpcRequestCallback rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(RegisterComponent.getInstance().buildRegisterRpcRequest(registParam, oceanRegisterParam), OceanRegisterResponseData.class, rpcRequestCallback);
    }

    public void sendSMS(RegistParam registParam, OceanRegisterParam oceanRegisterParam, RpcRequestCallback rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(RegisterComponent.getInstance().buildSendSmsRequest(registParam, oceanRegisterParam), SmsApplyResponse.class, rpcRequestCallback);
    }
}
