package com.youku.middlewareservice.provider.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.login4android.broadcast.LoginAction;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DefaultLoginBroadcastReceiver extends BroadcastReceiver {
    private final ILoginCallBack callBack;

    /* compiled from: Taobao */
    /* renamed from: com.youku.middlewareservice.provider.login.DefaultLoginBroadcastReceiver$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$login4android$broadcast$LoginAction;

        static {
            int[] iArr = new int[LoginAction.values().length];
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction = iArr;
            try {
                iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultLoginBroadcastReceiver(ILoginCallBack iLoginCallBack) {
        this.callBack = iLoginCallBack;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LoginAction valueOf;
        ILoginCallBack iLoginCallBack;
        if (intent == null || (valueOf = LoginAction.valueOf(intent.getAction())) == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$taobao$login4android$broadcast$LoginAction[valueOf.ordinal()];
        if (i == 1) {
            ILoginCallBack iLoginCallBack2 = this.callBack;
            if (iLoginCallBack2 != null) {
                iLoginCallBack2.onSuccess();
            }
        } else if (i == 2) {
            ILoginCallBack iLoginCallBack3 = this.callBack;
            if (iLoginCallBack3 != null) {
                iLoginCallBack3.onCancel();
            }
        } else if (i != 3) {
            if (i == 4 && (iLoginCallBack = this.callBack) != null) {
                iLoginCallBack.onLogout();
            }
        } else {
            ILoginCallBack iLoginCallBack4 = this.callBack;
            if (iLoginCallBack4 != null) {
                iLoginCallBack4.onFailed();
            }
        }
    }
}
