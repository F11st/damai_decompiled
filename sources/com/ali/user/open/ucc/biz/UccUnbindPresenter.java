package com.ali.user.open.ucc.biz;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.broadcast.LoginAction;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.Utils;
import com.youku.passport.libs.LoginArgument;
import com.youku.passport.libs.TlSite;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccUnbindPresenter {
    private static volatile UccUnbindPresenter instance;
    public String PASSPORT_PREFERENCE = "passport_preference";

    public static UccUnbindPresenter getInstance() {
        if (instance == null) {
            synchronized (UccUnbindPresenter.class) {
                if (instance == null) {
                    instance = new UccUnbindPresenter();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUnBindBroadcast(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(LoginArgument.EXT_TL_SITE, str);
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_SNS_UNBIND, hashMap);
    }

    public void doUnbind(final UccParams uccParams, final String str, final UccCallback uccCallback) {
        DataRepository.unbind(uccParams, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccUnbindPresenter.1
            private void rpcResultlHit(String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str2);
                UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_Invoke_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str2, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1009);
                rpcResultlHit(buidErrorCode + "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "解绑失败"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "");
                if (TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                    ((UccService) AliMemberSDK.getService(UccService.class)).logout(KernelContext.getApplicationContext(), str);
                    try {
                        if (Site.WEIBO.equals(str)) {
                            UccUnbindPresenter.this.sendUnBindBroadcast(TlSite.TLSITE_WEIBO);
                            KernelContext.getApplicationContext().getSharedPreferences(UccUnbindPresenter.this.PASSPORT_PREFERENCE, 0).edit().putString("sina_sns_info", "").apply();
                        } else {
                            UccUnbindPresenter.this.sendUnBindBroadcast(str);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (uccCallback != null) {
                        uccCallback.onSuccess(str, new HashMap());
                        return;
                    }
                    return;
                }
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(str, Utils.buidErrorCode(rpcResponse, 1009), Utils.buidErrorMessage(rpcResponse, "解绑失败"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str2, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1009);
                rpcResultlHit(buidErrorCode + "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "解绑失败"));
                }
            }
        });
    }
}
