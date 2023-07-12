package com.ali.user.mobile.rpc.impl;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.callback.RpcRequestCallbackWithCode;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.RpcService;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import mtopsdk.mtop.deviceid.DeviceIDManager;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopParamType;
import mtopsdk.mtop.intf.MtopSetting;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MtopRpcServiceImpl implements RpcService {
    private String deviceId;

    @Override // com.ali.user.mobile.service.RpcService
    public String getDeviceId() {
        String globalDeviceId = SDKConfig.getInstance().getGlobalDeviceId();
        this.deviceId = globalDeviceId;
        if (TextUtils.isEmpty(globalDeviceId)) {
            try {
                DeviceIDManager.getInstance().getDeviceID(DataProviderFactory.getApplicationContext(), DataProviderFactory.getDataProvider().getAppkey());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.deviceId;
    }

    @Override // com.ali.user.mobile.service.RpcService
    public void logout() {
        if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
            Mtop.instance(DataProviderFactory.getApplicationContext()).logout();
        }
    }

    @Override // com.ali.user.mobile.service.RpcService
    public <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls) {
        return (T) MTOPWrapper.getInstance().post(rpcRequest, cls);
    }

    @Override // com.ali.user.mobile.service.RpcService
    public void registerSessionInfo(String str, String str2, String str3) {
        if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
            Mtop.instance(DataProviderFactory.getApplicationContext()).registerSessionInfo(str, str2);
            MtopSetting.setParam(Mtop.Id.INNER, MtopParamType.HEADER, "x-disastergrd", str3);
        }
    }

    @Override // com.ali.user.mobile.service.RpcService
    public <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallback rpcRequestCallback) {
        remoteBusiness(rpcRequest, cls, "", rpcRequestCallback);
    }

    @Override // com.ali.user.mobile.service.RpcService
    public void setHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MtopSetting.setParam(Mtop.Id.INNER, MtopParamType.HEADER, str, str2);
    }

    @Override // com.ali.user.mobile.service.RpcService
    public <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls, String str) {
        return (T) MTOPWrapper.getInstance().post(rpcRequest, cls, str);
    }

    @Override // com.ali.user.mobile.service.RpcService
    public <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RemoteBusiness.init(DataProviderFactory.getApplicationContext(), DataProviderFactory.getDataProvider().getTTID());
        MTOPWrapper.getInstance().remoteBusiness(rpcRequest, cls, rpcRequestCallbackWithCode);
    }

    @Override // com.ali.user.mobile.service.RpcService
    public <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, String str, RpcRequestCallback rpcRequestCallback) {
        RemoteBusiness.init(DataProviderFactory.getApplicationContext(), DataProviderFactory.getDataProvider().getTTID());
        MTOPWrapper.getInstance().remoteBusiness(rpcRequest, cls, str, rpcRequestCallback);
    }
}
