package com.ali.user.mobile.register;

import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResponseData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegisterDataRepository {
    private static RegisterDataRepository instance;

    private RegisterDataRepository() {
    }

    public static RegisterDataRepository getInstance() {
        if (instance == null) {
            synchronized (RegisterDataRepository.class) {
                if (instance == null) {
                    instance = new RegisterDataRepository();
                }
            }
        }
        return instance;
    }

    public void directRegister(RegistParam registParam, String str, RpcRequestCallback<OceanRegisterResult> rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(RegisterComponent.getInstance().buildDirectRegisterRequest(registParam, str), OceanRegisterResponseData.class, rpcRequestCallback);
    }
}
