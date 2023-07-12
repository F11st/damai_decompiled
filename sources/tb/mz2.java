package tb;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.adapter.adapter.IFeedBackCallBack;
import com.alibaba.fastjson.JSON;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.arch.v3.event.Subject;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class mz2 implements IWXJSExceptionAdapter {
    public static String a() {
        try {
            Application b = C3004a.l().b();
            return b == null ? "" : b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            WXLogUtils.e("WXExceptionAdapter getAppVersionName Exception: ", e);
            return "";
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        double d = 100.0d;
        double random = Math.random() * 100.0d;
        if ("weex_native_error".equals(str)) {
            String a = a();
            if (TextUtils.isEmpty(a) || a.split(".").length == 3) {
                d = 10.0d;
            }
        }
        IConfigAdapter c = C3004a.l().c();
        if (c != null) {
            try {
                d = Double.valueOf(c.getConfig(oz2.WXAPM_CONFIG_GROUP, str, String.valueOf(d))).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return random < d;
    }

    @Override // com.taobao.weex.adapter.IWXJSExceptionAdapter
    public void onJSException(WXJSExceptionInfo wXJSExceptionInfo) {
        Map<String, Object> hashMap;
        IGodEyeStageAdapter h;
        WXSDKInstance wXSDKInstance;
        Map<String, String> containerInfo;
        String str;
        if (wXJSExceptionInfo == null) {
            Log.e("WXJSExceptionAdapter", "null == exception");
            return;
        }
        try {
            Log.i("weex js err", "js err start");
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            WXErrorCode errCode = wXJSExceptionInfo.getErrCode();
            if (errCode.getErrorGroup() == WXErrorCode.ErrorGroup.NATIVE && errCode.getErrorType() == WXErrorCode.ErrorType.NATIVE_ERROR) {
                bizErrorModule.businessType = "weex_native_error";
                bizErrorModule.exceptionCode = errCode.getErrorCode();
            } else {
                bizErrorModule.businessType = "WEEX_ERROR";
                String bundleUrl = wXJSExceptionInfo.getBundleUrl();
                if (bundleUrl != null) {
                    String b = xz2.b(bundleUrl, true);
                    if (b.length() > 1024) {
                        b = b.substring(0, 1024);
                    }
                    bizErrorModule.exceptionCode = b;
                } else {
                    Log.i("weex js err", "bundle url is null");
                }
            }
            if (b(bizErrorModule.businessType)) {
                bizErrorModule.exceptionDetail = wXJSExceptionInfo.getBundleUrl();
                bizErrorModule.exceptionId = errCode.getErrorCode();
                String weexVersion = wXJSExceptionInfo.getWeexVersion();
                if (weexVersion != null) {
                    bizErrorModule.exceptionVersion = weexVersion;
                }
                String exception = wXJSExceptionInfo.getException();
                if (exception != null) {
                    int indexOf = exception.indexOf(StringUtils.LF);
                    bizErrorModule.exceptionArg1 = indexOf > 0 ? exception.substring(0, indexOf) : exception;
                    bizErrorModule.exceptionArg3 = exception + "\nend_weex_stack\n";
                }
                String function = wXJSExceptionInfo.getFunction();
                if (function != null) {
                    bizErrorModule.exceptionArg2 = function;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorCode", errCode.getErrorCode());
                hashMap2.put("errorGroup", errCode.getErrorGroup());
                hashMap2.put("errorType", errCode.getErrorType());
                WXSDKInstance y = WXSDKManager.v().y(wXJSExceptionInfo.getInstanceId());
                if (y != null && errCode.getErrorGroup() == WXErrorCode.ErrorGroup.JS) {
                    String str2 = y.getWXPerformance().pageName;
                    hashMap2.put("wxBundlePageName", str2 == null ? "unKnowPageNameCaseUnSet" : str2);
                    if (y.getContext() instanceof IFeedBackCallBack) {
                        IFeedBackCallBack iFeedBackCallBack = (IFeedBackCallBack) y.getContext();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("useWeex", Boolean.TRUE);
                        hashMap3.put("infoType", bizErrorModule.businessType);
                        if (exception != null) {
                            int i = 200;
                            if (exception.length() <= 200) {
                                i = exception.length();
                            }
                            hashMap3.put("shortErrorMsg", exception.substring(0, i));
                        }
                        hashMap3.put("weexRealPageName", str2);
                        iFeedBackCallBack.addFeedCallBackInfo(bizErrorModule.businessType, JSON.toJSONString(hashMap3));
                    }
                }
                String instanceId = wXJSExceptionInfo.getInstanceId();
                if (instanceId != null) {
                    hashMap2.put("instanceId", instanceId);
                } else {
                    hashMap2.put("instanceId", "no instanceId");
                }
                String jsFrameworkVersion = wXJSExceptionInfo.getJsFrameworkVersion();
                if (jsFrameworkVersion != null) {
                    hashMap2.put("frameWorkVersion", jsFrameworkVersion);
                } else {
                    hashMap2.put("frameWorkVersion", "no framework version");
                }
                Map<String, String> extParams = wXJSExceptionInfo.getExtParams();
                if (extParams != null && extParams.size() > 0) {
                    hashMap2.putAll(extParams);
                    if (!TextUtils.isEmpty(extParams.get("wxGreyBundle"))) {
                        bizErrorModule.exceptionId = extParams.get("wxGreyBundle");
                    }
                }
                try {
                    if (!TextUtils.isEmpty(instanceId) && (wXSDKInstance = WXSDKManager.v().i().get(instanceId)) != null && (containerInfo = wXSDKInstance.getContainerInfo()) != null && containerInfo.containsKey(AliWXSDKEngine.f) && (str = containerInfo.get(AliWXSDKEngine.f)) != null) {
                        hashMap2.put(AliWXSDKEngine.f, str);
                    }
                } catch (Throwable unused) {
                }
                bizErrorModule.exceptionArgs = hashMap2;
                if (b("god_eye_stage_data") && errCode != WXErrorCode.WX_ERROR_WHITE_SCREEN && (h = C3004a.l().h()) != null) {
                    h.onException("exception_weex_check", bizErrorModule.exceptionArg1, hashMap2);
                }
                bizErrorModule.thread = Thread.currentThread();
                BizErrorReporter.getInstance().send(C3004a.l().b(), bizErrorModule);
                Log.i("weex js err", "js err end");
                if (errCode.getErrorGroup() != WXErrorCode.ErrorGroup.JS || y == null) {
                    return;
                }
                try {
                    hashMap = JSON.parseObject(JSON.toJSONString(wXJSExceptionInfo));
                } catch (Exception unused2) {
                    hashMap = new HashMap<>();
                    hashMap.put("bundleUrl", wXJSExceptionInfo.getBundleUrl());
                    hashMap.put("errorCode", wXJSExceptionInfo.getErrCode());
                    hashMap.put("exception", wXJSExceptionInfo.getException());
                    hashMap.put("extParams", wXJSExceptionInfo.getExtParams());
                    hashMap.put(Subject.FUNCTION, wXJSExceptionInfo.getFunction());
                    hashMap.put("instanceId", wXJSExceptionInfo.getInstanceId());
                    hashMap.put("jsFrameworkVersion", wXJSExceptionInfo.getJsFrameworkVersion());
                    hashMap.put("weexVersion", wXJSExceptionInfo.getWeexVersion());
                }
                y.fireGlobalEventCallback("exception", hashMap);
            }
        } catch (Exception e) {
            Log.e("weex js err", "build weex callback data err", e);
        }
    }
}
