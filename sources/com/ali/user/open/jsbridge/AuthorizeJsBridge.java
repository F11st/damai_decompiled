package com.ali.user.open.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import cn.damai.commonbusiness.yymember.bean.MemberGuideInfo;
import com.ali.user.open.authorize.AuthorizeCallback;
import com.ali.user.open.authorize.AuthorizeService;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.data.DefaultDataProvider;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AuthorizeJsBridge extends WVApiPlugin {
    private final int TYPE_AUTHORIZE = 1;

    private void authorizeAction(final int i, final String str, final WVCallBackContext wVCallBackContext) {
        if (KernelContext.sdkInitialized.booleanValue()) {
            if (i == 1) {
                authorize(str, wVCallBackContext);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(AliMemberSDK.getMasterSite())) {
            AliMemberSDK.setMasterSite("taobao");
        }
        AliMemberSDK.init(this.mContext.getApplicationContext(), new InitResultCallback() { // from class: com.ali.user.open.jsbridge.AuthorizeJsBridge.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i2, String str2) {
                AuthorizeJsBridge.this.onFailCallback(wVCallBackContext, i2, str2);
            }

            @Override // com.ali.user.open.core.callback.InitResultCallback
            public void onSuccess() {
                AuthorizeJsBridge.this.setUccDataProvider();
                if (i == 1) {
                    AuthorizeJsBridge.this.authorize(str, wVCallBackContext);
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

    public static void register() {
        try {
            WVPluginManager.registerPlugin("aluAuthorizeBridge", (Class<? extends WVApiPlugin>) AuthorizeJsBridge.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void authorize(String str, final WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) new JSONObject(str).get("authorizeScene");
                if (TextUtils.isEmpty(str2)) {
                    onFailCallback(wVCallBackContext, 1203, "authorizeScene不可为空");
                    return;
                }
                ((AuthorizeService) AliMemberSDK.getService(AuthorizeService.class)).authorizeWithScene(str2, (Map) null, new AuthorizeCallback() { // from class: com.ali.user.open.jsbridge.AuthorizeJsBridge.2
                    public void onFail(int i, String str3) {
                        AuthorizeJsBridge.this.onFailCallback(wVCallBackContext, i, str3);
                    }

                    public void onSuccess(Map map) {
                        if (wVCallBackContext != null) {
                            wVCallBackContext.success(new WVResult());
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                onFailCallback(wVCallBackContext, 1299, "系统异常");
            }
        } else {
            onFailCallback(wVCallBackContext, 1203, "参数不能为空");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (MemberGuideInfo.authorize.equals(str)) {
            authorizeAction(1, str2, wVCallBackContext);
            return true;
        }
        wVCallBackContext.error();
        return false;
    }

    public void setUccDataProvider() {
        ((UccService) AliMemberSDK.getService(UccService.class)).setUccDataProvider(new DefaultDataProvider());
    }
}
