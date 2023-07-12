package com.ali.user.open.mtop.rpc.impl;

import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.mtop.rpc.MTOPWrapper;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MtopRpcServiceImpl implements RpcService {
    @Override // com.ali.user.open.core.service.RpcService
    public String getDeviceId() {
        return DeviceInfo.deviceId;
    }

    @Override // com.ali.user.open.core.service.RpcService
    public void logout(String str) {
        if (ConfigManager.getInstance().isRegisterSidToMtopDefault()) {
            CommonUtils.sendUT("ucc_logout_mtop");
            Mtop.instance(KernelContext.applicationContext).logout();
        }
    }

    @Override // com.ali.user.open.core.service.RpcService
    public void registerSessionInfo(String str, String str2, String str3) {
        if (ConfigManager.getInstance().isRegisterSidToMtopDefault()) {
            CommonUtils.sendUT("ucc_register_session_info");
            Mtop.instance(KernelContext.applicationContext).registerSessionInfo(str2, str3);
        }
    }

    @Override // com.ali.user.open.core.service.RpcService
    public <T> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        MTOPWrapper.getInstance().remoteBusiness(rpcRequest, cls, rpcRequestCallbackWithCode);
    }
}
