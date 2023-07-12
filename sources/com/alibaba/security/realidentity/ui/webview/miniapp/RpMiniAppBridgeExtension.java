package com.alibaba.security.realidentity.ui.webview.miniapp;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.NativePermissionRequire;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.realidentity.a.C3847g;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RpMiniAppBridgeExtension implements BridgeExtension {
    private static final String TAG = RpMiniAppBridgeExtension.class.getSimpleName();

    public void onFinalized() {
    }

    public void onInitialized() {
    }

    public Permission permit() {
        return null;
    }

    @NativePermissionRequire({"android.permission.CAMERA"})
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpStartByH5(@BindingNode(Page.class) Page page, @BindingParam(name = {"verifyToken"}, required = true) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "invalid verifyToken"));
                return;
            }
            if (page != null && page.getApp() != null && page.getApp().getAppContext() != null) {
                Context context = page.getApp().getAppContext().getContext();
                if (context == null) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "null context found"));
                    return;
                } else {
                    RPVerify.start(context, str, null, C3834a.C3835a.c, new RPEventListener() { // from class: com.alibaba.security.realidentity.ui.webview.miniapp.RpMiniAppBridgeExtension.1
                        @Override // com.alibaba.security.realidentity.RPEventListener
                        public final void onFinish(RPResult rPResult, RPDetail rPDetail) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("state", (Object) Integer.valueOf(rPResult.code));
                            jSONObject.put("errorCode", (Object) (TextUtils.isEmpty(rPDetail.getCode()) ? "invalidParams" : rPDetail.getCode()));
                            jSONObject.put("subErrorCode", (Object) (TextUtils.isEmpty(rPDetail.getSubCode()) ? null : rPDetail.getSubCode()));
                            jSONObject.put("message", (Object) rPDetail.getMsg());
                            bridgeCallback.sendJSONResponse(jSONObject);
                        }
                    });
                    return;
                }
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "null app context found"));
        } catch (Exception e) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, e.getMessage()));
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpTraceLink(@BindingNode(Page.class) Page page, @BindingParam(name = {"token"}) String str, @BindingParam(name = {"service"}) String str2, @BindingParam(name = {"method"}) String str3, @BindingParam(name = {"code"}) int i, @BindingParam(name = {"msg"}) String str4, @BindingParam(name = {"params"}) String str5, @BindingParam(name = {"result"}) String str6, @BindingParam(name = {"tags"}) List<String> list, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            TrackLog trackLog = new TrackLog();
            trackLog.setVerifyToken(str);
            trackLog.setService(str2);
            trackLog.setMethod(str3);
            trackLog.setCode(i);
            trackLog.setParams(str5);
            trackLog.setResult(str6);
            trackLog.setTags(list);
            trackLog.setMsg(str4);
            trackLog.setLayer(C3834a.C3835a.c);
            C3847g.C3848a.a.d = str;
            C3847g.C3848a.a.a(trackLog);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", (Object) 0);
            jSONObject.put("message", (Object) "success");
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception e) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, e.getMessage()));
        }
    }
}
