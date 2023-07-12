package com.ali.user.open.mtop.rpc;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.exception.RpcException;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.JSONUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MTOPWrapper {
    private static MTOPWrapper INSTANCE = null;
    private static final int MTOP_BIZ_CODE = 94;
    private static final String TAG = "login.MTOPWrapperImpl";

    private MtopRequest buildMtopRequest(RpcRequest rpcRequest) throws JSONException {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(rpcRequest.target);
        mtopRequest.setVersion(rpcRequest.version);
        mtopRequest.setNeedEcode(rpcRequest.NEED_ECODE);
        mtopRequest.setNeedSession(rpcRequest.NEED_SESSION);
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < rpcRequest.paramNames.size(); i++) {
            if (rpcRequest.paramNames.get(i) != null) {
                jSONObject.put(rpcRequest.paramNames.get(i), rpcRequest.paramValues.get(i).toString());
            }
        }
        mtopRequest.setData(jSONObject.toString());
        return mtopRequest;
    }

    private <V> RpcResponse<V> getBizRpcResponse(MtopResponse mtopResponse, Class<V> cls) {
        try {
            return getRpcResponse(mtopResponse, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized MTOPWrapper getInstance() {
        MTOPWrapper mTOPWrapper;
        synchronized (MTOPWrapper.class) {
            if (INSTANCE == null) {
                INSTANCE = new MTOPWrapper();
            }
            mTOPWrapper = INSTANCE;
        }
        return mTOPWrapper;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    private <V> RpcResponse<V> getRpcResponse(MtopResponse mtopResponse, Class<V> cls) throws JSONException {
        JSONObject optJSONObject;
        RpcResponse<V> rpcResponse = new RpcResponse<>();
        byte[] bytedata = mtopResponse.getBytedata();
        if (bytedata != null && (optJSONObject = new JSONObject(new String(bytedata)).optJSONObject("data")) != null) {
            rpcResponse.code = optJSONObject.optInt("code");
            rpcResponse.codeGroup = optJSONObject.optString("codeGroup");
            rpcResponse.message = optJSONObject.optString("message");
            rpcResponse.actionType = optJSONObject.optString("actionType");
            rpcResponse.success = optJSONObject.optBoolean("success");
            if (!TextUtils.isEmpty(optJSONObject.optString("returnValue"))) {
                rpcResponse.returnValue = JSONUtils.parseStringValue(optJSONObject.optString("returnValue"), cls);
            }
        }
        return rpcResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <V> RpcResponse<V> processMtopResponse(MtopResponse mtopResponse, Class<V> cls) {
        if (mtopResponse == null || !mtopResponse.isApiSuccess()) {
            if (mtopResponse != null) {
                if (!mtopResponse.isNetworkError()) {
                    if (!mtopResponse.isApiLockedResult()) {
                        if (!mtopResponse.is41XResult()) {
                            if (!mtopResponse.isExpiredRequest()) {
                                if (!mtopResponse.isIllegelSign()) {
                                    if (!mtopResponse.isSystemError()) {
                                        if (!mtopResponse.isSessionInvalid()) {
                                            if (!mtopResponse.isMtopServerError()) {
                                                if (!mtopResponse.isMtopSdkError()) {
                                                    return getBizRpcResponse(mtopResponse, cls);
                                                }
                                                throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
                                            }
                                            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
                                        }
                                        throw new RpcException((Integer) 407, mtopResponse.getRetMsg());
                                    }
                                    throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
                                }
                                throw new RpcException((Integer) 403, mtopResponse.getRetMsg());
                            }
                            throw new RpcException((Integer) 402, mtopResponse.getRetMsg());
                        }
                        throw new RpcException((Integer) 401, mtopResponse.getRetMsg());
                    }
                    throw new RpcException((Integer) 400, mtopResponse.getRetMsg());
                }
                throw new RpcException((Integer) 7, mtopResponse.getRetMsg());
            }
            return null;
        }
        return getBizRpcResponse(mtopResponse, cls);
    }

    public String post(RpcRequest rpcRequest) {
        return post(rpcRequest, LoginReturnData.class).toString();
    }

    public <T> void remoteBusiness(RpcRequest rpcRequest, final Class<T> cls, final RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequest == null || rpcRequestCallbackWithCode == null) {
            return;
        }
        try {
            MtopBusiness build = MtopBusiness.build(Mtop.instance(Mtop.Id.INNER, KernelContext.applicationContext), buildMtopRequest(rpcRequest), AliMemberSDK.ttid);
            String str = "acs.waptest.taobao.com";
            String str2 = "acs.wapa.taobao.com";
            String str3 = "acs.m.taobao.com";
            if (rpcRequest.NEED_ECODE) {
                if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionOnlineDomain)) {
                    str3 = ConfigManager.getInstance().sessionOnlineDomain;
                }
                if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionPreDomain)) {
                    str2 = ConfigManager.getInstance().sessionPreDomain;
                }
                if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionDailyDomain)) {
                    str = ConfigManager.getInstance().sessionPreDomain;
                }
                build.setCustomDomain(str3, str2, str);
            } else {
                if (!TextUtils.isEmpty(ConfigManager.getInstance().onlineDomain)) {
                    str3 = ConfigManager.getInstance().onlineDomain;
                }
                if (!TextUtils.isEmpty(ConfigManager.getInstance().preDomain)) {
                    str2 = ConfigManager.getInstance().preDomain;
                }
                if (!TextUtils.isEmpty(ConfigManager.getInstance().dailyDomain)) {
                    str = ConfigManager.getInstance().dailyDomain;
                }
                build.setCustomDomain(str3, str2, str);
                build.reqMethod(MethodEnum.POST);
            }
            build.showLoginUI(rpcRequest.SHOW_LOGIN_UI);
            build.addListener((MtopListener) new IRemoteBaseListener() { // from class: com.ali.user.open.mtop.rpc.MTOPWrapper.1
                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                    try {
                        rpcRequestCallbackWithCode.onError(retCode, MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                    } catch (RpcException e) {
                        RpcResponse rpcResponse = new RpcResponse();
                        rpcResponse.code = e.getCode();
                        rpcResponse.message = "亲，您的手机网络不太顺畅哦~";
                        rpcRequestCallbackWithCode.onError(retCode, rpcResponse);
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    rpcRequestCallbackWithCode.onSuccess(MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                    try {
                        rpcRequestCallbackWithCode.onSystemError(retCode, MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                    } catch (RpcException e) {
                        RpcResponse rpcResponse = new RpcResponse();
                        rpcResponse.code = e.getCode();
                        rpcResponse.message = "亲，您的手机网络不太顺畅哦~";
                        rpcRequestCallbackWithCode.onSystemError(retCode, rpcResponse);
                    }
                }
            });
            build.startRequest();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public <V> RpcResponse<V> post(RpcRequest rpcRequest, Class<V> cls) {
        return post(rpcRequest, cls, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <V> com.ali.user.open.core.model.RpcResponse<V> post(com.ali.user.open.core.model.RpcRequest r6, java.lang.Class<V> r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "login.MTOPWrapperImpl"
            r1 = 0
            mtopsdk.mtop.domain.MtopRequest r6 = r5.buildMtopRequest(r6)     // Catch: java.lang.Exception -> L9d
            java.lang.String r2 = "INNER"
            android.content.Context r3 = com.ali.user.open.core.context.KernelContext.applicationContext     // Catch: java.lang.Exception -> L9d
            mtopsdk.mtop.intf.Mtop r2 = mtopsdk.mtop.intf.Mtop.instance(r2, r3)     // Catch: java.lang.Exception -> L9d
            java.lang.String r3 = com.ali.user.open.core.AliMemberSDK.ttid     // Catch: java.lang.Exception -> L9d
            mtopsdk.mtop.intf.MtopBuilder r6 = r2.build(r6, r3)     // Catch: java.lang.Exception -> L9d
            mtopsdk.mtop.domain.MethodEnum r2 = mtopsdk.mtop.domain.MethodEnum.POST     // Catch: java.lang.Exception -> L9d
            mtopsdk.mtop.intf.MtopBuilder r6 = r6.reqMethod(r2)     // Catch: java.lang.Exception -> L9d
            r2 = 94
            mtopsdk.mtop.intf.MtopBuilder r6 = r6.setBizId(r2)     // Catch: java.lang.Exception -> L9d
            r2 = 10000(0x2710, float:1.4013E-41)
            mtopsdk.mtop.intf.MtopBuilder r6 = r6.setConnectionTimeoutMilliSecond(r2)     // Catch: java.lang.Exception -> L9d
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L9d
            if (r2 != 0) goto L30
            r6.setReqUserId(r8)     // Catch: java.lang.Exception -> L9d
        L30:
            r8 = 1
            r6.retryTime(r8)     // Catch: java.lang.Exception -> L9d
            com.ali.user.open.core.config.ConfigManager r8 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r8 = r8.onlineDomain     // Catch: java.lang.Exception -> L9d
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L9d
            if (r8 == 0) goto L43
            java.lang.String r8 = "acs.m.taobao.com"
            goto L49
        L43:
            com.ali.user.open.core.config.ConfigManager r8 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r8 = r8.onlineDomain     // Catch: java.lang.Exception -> L9d
        L49:
            com.ali.user.open.core.config.ConfigManager r2 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r2 = r2.preDomain     // Catch: java.lang.Exception -> L9d
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L9d
            if (r2 == 0) goto L58
            java.lang.String r2 = "acs.wapa.taobao.com"
            goto L5e
        L58:
            com.ali.user.open.core.config.ConfigManager r2 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r2 = r2.preDomain     // Catch: java.lang.Exception -> L9d
        L5e:
            com.ali.user.open.core.config.ConfigManager r3 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r3 = r3.dailyDomain     // Catch: java.lang.Exception -> L9d
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L9d
            if (r3 == 0) goto L6d
            java.lang.String r3 = "acs.waptest.taobao.com"
            goto L73
        L6d:
            com.ali.user.open.core.config.ConfigManager r3 = com.ali.user.open.core.config.ConfigManager.getInstance()     // Catch: java.lang.Exception -> L9d
            java.lang.String r3 = r3.dailyDomain     // Catch: java.lang.Exception -> L9d
        L73:
            r6.setCustomDomain(r8, r2, r3)     // Catch: java.lang.Exception -> L9d
            mtopsdk.mtop.domain.MtopResponse r6 = r6.syncRequest()     // Catch: java.lang.Exception -> L9d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98
            r8.<init>()     // Catch: java.lang.Exception -> L98
            java.lang.String r2 = "receive MtopResponse = "
            r8.append(r2)     // Catch: java.lang.Exception -> L98
            r8.append(r6)     // Catch: java.lang.Exception -> L98
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L98
            if (r8 != 0) goto L90
            java.lang.String r8 = "  null"
            goto L94
        L90:
            java.lang.String r8 = r6.toString()     // Catch: java.lang.Exception -> L98
        L94:
            com.ali.user.open.core.trace.SDKLogger.d(r0, r8)     // Catch: java.lang.Exception -> L98
            goto La8
        L98:
            r8 = move-exception
            r4 = r8
            r8 = r6
            r6 = r4
            goto L9f
        L9d:
            r6 = move-exception
            r8 = r1
        L9f:
            java.lang.String r2 = "MtopResponse error"
            com.ali.user.open.core.trace.SDKLogger.e(r0, r2, r6)
            r6.printStackTrace()
            r6 = r8
        La8:
            if (r6 == 0) goto Laf
            com.ali.user.open.core.model.RpcResponse r6 = r5.processMtopResponse(r6, r7)
            return r6
        Laf:
            java.lang.String r6 = "MtopResponse response=null"
            com.ali.user.open.core.trace.SDKLogger.e(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.mtop.rpc.MTOPWrapper.post(com.ali.user.open.core.model.RpcRequest, java.lang.Class, java.lang.String):com.ali.user.open.core.model.RpcResponse");
    }
}
