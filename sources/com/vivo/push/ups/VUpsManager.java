package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.vivo.push.PushClient;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VUpsManager {

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.ups.VUpsManager$a */
    /* loaded from: classes11.dex */
    private static class C7502a {
        private static VUpsManager a = new VUpsManager();
    }

    public static VUpsManager getInstance() {
        return C7502a.a;
    }

    public void onCommandResult(Context context, Bundle bundle) {
    }

    public void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOnPush(new C7503a(this, uPSRegisterCallback, context));
    }

    public void turnOffPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOffPush(new C7506d(this, uPSTurnCallback));
    }

    public void turnOnPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOnPush(new C7505c(this, uPSTurnCallback));
    }

    public void unRegisterToken(Context context, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOffPush(new C7504b(this, uPSRegisterCallback));
    }
}
