package com.ali.user.open.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.OneKeyLoginService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.webview.INavHelper;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.biz.UccH5Presenter;
import com.ali.user.open.ucc.biz.UccTrustLoginPresenter;
import com.ali.user.open.ucc.data.DefaultDataProvider;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.webview.UccSystemJSBridge;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccJsBridge extends WVApiPlugin {
    private static volatile UccJsBridge instance;
    private final int TYPE_UCC_BIND = 1;
    private final int TYPE_UCC_TRUSTLOGIN = 2;
    private final int TYPE_UCC_UNBIND = 3;
    private final int TYPE_UCC_FETCH_URL = 4;
    private final int TYPE_UCC_FETCH_URL_NO_LOGIN = 5;
    private final int TYPE_UCC_ONEKEY_LOGIN = 6;
    private final int TYPE_UCC_USER_GROW_LOGIN = 7;

    public static UccJsBridge getInstance() {
        if (instance == null) {
            synchronized (UccJsBridge.class) {
                if (instance == null) {
                    instance = new UccJsBridge();
                }
            }
        }
        return instance;
    }

    private void getUIMode(String str, WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("mode", CommonUtils.getDarkModeStatus(KernelContext.applicationContext) ? "Dark" : "Light");
            wVCallBackContext.success(wVResult);
        }
    }

    private void getUserToken(String str, final WVCallBackContext wVCallBackContext) {
        if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null) {
            setUccDataProvider();
        }
        ((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider().getUserToken(AliMemberSDK.getMasterSite(), new MemberCallback<String>() { // from class: com.ali.user.open.jsbridge.UccJsBridge.10
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str2) {
                UccJsBridge.this.onFailCallback(wVCallBackContext, i, str2);
            }

            @Override // com.ali.user.open.core.callback.MemberCallback
            public void onSuccess(String str2) {
                if (wVCallBackContext != null) {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("userToken", str2);
                    wVCallBackContext.success(wVResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailCallback(WVCallBackContext wVCallBackContext, int i, String str) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.setResult("HY_FAILED");
            wVResult.addData("code", String.valueOf(i));
            wVResult.addData("message", str);
            wVCallBackContext.error(wVResult);
        }
    }

    private void uccAction(final int i, final String str, final WVCallBackContext wVCallBackContext) {
        if (!KernelContext.sdkInitialized.booleanValue()) {
            try {
                WVPluginManager.registerPlugin(UccSystemJSBridge.ALU_SYSTEM_JSBRIDGE, (Class<? extends WVApiPlugin>) UccJsBridge.class);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (TextUtils.isEmpty(AliMemberSDK.getMasterSite())) {
                AliMemberSDK.setMasterSite("taobao");
            }
            AliMemberSDK.init(this.mContext.getApplicationContext(), new InitResultCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.2
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i2, String str2) {
                }

                @Override // com.ali.user.open.core.callback.InitResultCallback
                public void onSuccess() {
                    UccJsBridge.this.setUccDataProvider();
                    int i2 = i;
                    if (i2 == 1) {
                        UccJsBridge.this.uccBind(str, wVCallBackContext);
                    } else if (i2 == 2) {
                        UccJsBridge.this.uccTrustLogin(str, wVCallBackContext);
                    } else if (i2 == 3) {
                        UccJsBridge.this.uccUnbind(str, wVCallBackContext);
                    } else if (i2 == 4) {
                        UccJsBridge.this.uccFetchUrl(str, wVCallBackContext);
                    } else if (i2 == 5) {
                        UccJsBridge.this.uccFetchUrlWithNoLogin(str, wVCallBackContext);
                    } else if (i2 == 6) {
                        UccJsBridge.this.uccOneKeyLogin(str, wVCallBackContext);
                    } else if (i2 == 7) {
                        UccJsBridge.this.uccUserGrowLogin(str, wVCallBackContext);
                    }
                }
            });
        } else if (i == 1) {
            uccBind(str, wVCallBackContext);
        } else if (i == 2) {
            uccTrustLogin(str, wVCallBackContext);
        } else if (i == 3) {
            uccUnbind(str, wVCallBackContext);
        } else if (i == 4) {
            uccFetchUrl(str, wVCallBackContext);
        } else if (i == 5) {
            uccFetchUrlWithNoLogin(str, wVCallBackContext);
        } else if (i == 6) {
            uccOneKeyLogin(str, wVCallBackContext);
        } else if (i == 7) {
            uccUserGrowLogin(str, wVCallBackContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccFetchUrl(String str, final WVCallBackContext wVCallBackContext) {
        try {
            if (AliMemberSDK.getService(UserTrackerService.class) != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("uccFetchUrl", (Map) JSON.parseObject(str, Map.class));
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null && Site.isHavanaSite(AliMemberSDK.getMasterSite())) {
                setUccDataProvider();
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            ((UccService) AliMemberSDK.getService(UccService.class)).fetchUrl((Activity) this.mContext, optString, hashMap, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.3
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str3, int i, String str4) {
                    UccJsBridge uccJsBridge = UccJsBridge.this;
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "获取页面失败";
                    }
                    uccJsBridge.onFailCallback(wVCallBackContext2, i, str4);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str3, Map map) {
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (wVCallBackContext2 != null) {
                        wVCallBackContext2.success();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccFetchUrlWithNoLogin(String str, final WVCallBackContext wVCallBackContext) {
        try {
            if (AliMemberSDK.getService(UserTrackerService.class) != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("uccFetchUrlNoLogin", (Map) JSON.parseObject(str, Map.class));
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            hashMap.put(ParamsConstants.Key.PARAM_NO_LOGIN, "1");
            ((UccService) AliMemberSDK.getService(UccService.class)).fetchUrl((Activity) this.mContext, optString, hashMap, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.4
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str3, int i, String str4) {
                    UccJsBridge uccJsBridge = UccJsBridge.this;
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "获取页面失败";
                    }
                    uccJsBridge.onFailCallback(wVCallBackContext2, i, str4);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str3, Map map) {
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (wVCallBackContext2 != null) {
                        wVCallBackContext2.success();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccOneKeyLogin(String str, final WVCallBackContext wVCallBackContext) {
        try {
            if (AliMemberSDK.getService(UserTrackerService.class) != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("uccOneKeyLogin", (Map) JSON.parseObject(str, Map.class));
            }
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            if (AliMemberSDK.getService(OneKeyLoginService.class) != null) {
                ((OneKeyLoginService) AliMemberSDK.getService(OneKeyLoginService.class)).oneKeyLogin(hashMap, new MemberCallback<String>() { // from class: com.ali.user.open.jsbridge.UccJsBridge.5
                    @Override // com.ali.user.open.core.callback.FailureCallback
                    public void onFailure(int i, String str3) {
                        UccJsBridge.this.onFailCallback(wVCallBackContext, i, str3);
                    }

                    @Override // com.ali.user.open.core.callback.MemberCallback
                    public void onSuccess(String str3) {
                        WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                        if (wVCallBackContext2 != null) {
                            wVCallBackContext2.success();
                        }
                    }
                });
            } else {
                onFailCallback(wVCallBackContext, -1, "service未注册");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccTrustLogin(String str, final WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null && Site.isHavanaSite(AliMemberSDK.getMasterSite())) {
                setUccDataProvider();
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            ((UccService) AliMemberSDK.getService(UccService.class)).trustLogin((Activity) this.mContext, optString, hashMap, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.7
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str3, int i, String str4) {
                    UccJsBridge uccJsBridge = UccJsBridge.this;
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = SNSJsbridge.TAOBAO_ERROR_MESSAGE;
                    }
                    uccJsBridge.onFailCallback(wVCallBackContext2, i, str4);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str3, Map map) {
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (wVCallBackContext2 != null) {
                        wVCallBackContext2.success();
                    }
                }
            });
        } catch (Exception e) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("message", e.getMessage());
            UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_EXCEPTION", null, hashMap2);
            onFailCallback(wVCallBackContext, 1199, "系统异常:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccUnbind(String str, final WVCallBackContext wVCallBackContext) {
        try {
            String optString = new JSONObject(str).optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null && Site.isHavanaSite(AliMemberSDK.getMasterSite())) {
                setUccDataProvider();
            }
            ((UccService) AliMemberSDK.getService(UccService.class)).unbind(optString, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.9
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str2, int i, String str3) {
                    UccJsBridge uccJsBridge = UccJsBridge.this;
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "解绑失败";
                    }
                    uccJsBridge.onFailCallback(wVCallBackContext2, i, str3);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str2, Map map) {
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (wVCallBackContext2 != null) {
                        wVCallBackContext2.success();
                    }
                }
            });
        } catch (Exception e) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", e.getMessage());
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccLogin_EXCEPTION", null, hashMap);
            onFailCallback(wVCallBackContext, 1199, "系统异常:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uccUserGrowLogin(String str, final WVCallBackContext wVCallBackContext) {
        try {
            if (AliMemberSDK.getService(UserTrackerService.class) != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("uccUserGrowLogin", (Map) JSON.parseObject(str, Map.class));
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            String optString2 = jSONObject.optString("requestToken");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "requestToken不能为空");
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            UccParams uccParams = new UccParams();
            uccParams.requestToken = optString2;
            UccTrustLoginPresenter.getInstance().userGrowLogin((Activity) this.mContext, uccParams, optString, hashMap, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.6
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str3, int i, String str4) {
                    if (i == 3000) {
                        if (wVCallBackContext != null) {
                            WVResult wVResult = new WVResult();
                            wVResult.setResult("HY_FAILED");
                            wVResult.addData("code", String.valueOf(i));
                            if (!TextUtils.isEmpty(str4)) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(str4);
                                    Iterator<String> keys2 = jSONObject2.keys();
                                    while (keys2.hasNext()) {
                                        String str5 = "" + ((Object) keys2.next());
                                        if (!TextUtils.equals("site", str5)) {
                                            wVResult.addData(str5, jSONObject2.optString(str5));
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            wVCallBackContext.error(wVResult);
                            return;
                        }
                        return;
                    }
                    UccJsBridge.this.onFailCallback(wVCallBackContext, i, str4);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str3, Map map) {
                    if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.setResult(WVResult.SUCCESS);
                        if (map != null) {
                            wVResult.addData("callbackUrl", map.get("callbackUrl"));
                        }
                        wVCallBackContext.success(wVResult);
                    }
                }
            });
        }
    }

    public synchronized void aluOpenWebViewByUrl(String str, WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) new JSONObject(str).get("url");
                Bundle bundle = new Bundle();
                bundle.putString("url", str2);
                if (ConfigManager.getInstance().getNavHelper() != null) {
                    ((INavHelper) ConfigManager.getInstance().getNavHelper().newInstance()).navTo(this.mContext, str2);
                } else {
                    UccH5Presenter.openUrl(this.mContext, bundle, null);
                }
                wVCallBackContext.success(new WVResult());
            } catch (Exception e) {
                e.printStackTrace();
                onFailCallback(wVCallBackContext, 1199, "系统异常");
            }
        } else {
            onFailCallback(wVCallBackContext, 1108, "参数不能为空");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("uccBind".equals(str)) {
            uccAction(1, str2, wVCallBackContext);
            return true;
        } else if ("uccTrustLogin".equals(str)) {
            uccAction(2, str2, wVCallBackContext);
            return true;
        } else if ("uccUnbind".equals(str)) {
            uccAction(3, str2, wVCallBackContext);
            return true;
        } else if ("getUIMode".equals(str)) {
            getUIMode(str2, wVCallBackContext);
            return true;
        } else if ("uccFetchUrl".equals(str)) {
            uccAction(4, str2, wVCallBackContext);
            return true;
        } else if ("uccFetchUrlNoLogin".equals(str)) {
            uccAction(5, str2, wVCallBackContext);
            return true;
        } else if ("aluOpenWebViewByUrl".equals(str)) {
            aluOpenWebViewByUrl(str2, wVCallBackContext);
            return true;
        } else if ("openUrlWithCallback".equals(str)) {
            openUrlWithCallback(str2, wVCallBackContext);
            return true;
        } else if ("uccOnekeyLogin".equals(str)) {
            uccAction(6, str2, wVCallBackContext);
            return true;
        } else if ("uccUserGrowContinueLogin".equals(str)) {
            uccAction(7, str2, wVCallBackContext);
            return true;
        } else if ("getUserToken".equals(str)) {
            getUserToken(str2, wVCallBackContext);
            return true;
        } else {
            wVCallBackContext.error();
            return false;
        }
    }

    public synchronized void openUrlWithCallback(String str, final WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("url", (String) jSONObject.opt("url"));
            bundle.putString(ParamsConstants.Key.PRAMA_TRANSPARENT_H5, (String) jSONObject.opt(ParamsConstants.Key.PRAMA_TRANSPARENT_H5));
            UccH5Presenter.openUrl(this.mContext, bundle, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.1
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str2, int i, String str3) {
                    UccJsBridge.this.onFailCallback(wVCallBackContext, i, str3);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str2, Map map) {
                    if (wVCallBackContext != null) {
                        wVCallBackContext.success(new WVResult());
                    }
                }
            });
        } else {
            onFailCallback(wVCallBackContext, 1108, "参数不能为空");
        }
    }

    public void setUccDataProvider() {
        ((UccService) AliMemberSDK.getService(UccService.class)).setUccDataProvider(new DefaultDataProvider());
    }

    public void uccBind(String str, WVCallBackContext wVCallBackContext) {
        uccBind((Activity) this.mContext, str, wVCallBackContext);
    }

    public void uccBind(Activity activity, String str, final WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("site");
            if (TextUtils.isEmpty(optString)) {
                onFailCallback(wVCallBackContext, 1108, "site不能为空");
                return;
            }
            if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null && Site.isHavanaSite(AliMemberSDK.getMasterSite())) {
                setUccDataProvider();
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = "" + ((Object) keys.next());
                if (!TextUtils.equals("site", str2)) {
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            ((UccService) AliMemberSDK.getService(UccService.class)).bind(activity, optString, hashMap, new UccCallback() { // from class: com.ali.user.open.jsbridge.UccJsBridge.8
                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str3, int i, String str4) {
                    UccJsBridge uccJsBridge = UccJsBridge.this;
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "绑定失败";
                    }
                    uccJsBridge.onFailCallback(wVCallBackContext2, i, str4);
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str3, Map map) {
                    WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                    if (wVCallBackContext2 != null) {
                        wVCallBackContext2.success();
                    }
                }
            });
        } catch (Exception e) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("message", e.getMessage());
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccLogin_EXCEPTION", null, hashMap2);
            onFailCallback(wVCallBackContext, 1199, "系统异常:" + e.getMessage());
        }
    }
}
