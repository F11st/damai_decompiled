package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.a.C5471a;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public abstract class AGConnectApp {
    public static AGConnectApp getInstance() {
        return C5471a.a();
    }

    private static AGConnectApp getInstance(String str) {
        return C5471a.a(str);
    }

    public static AGConnectApp initialize(Context context) {
        return C5471a.a(context);
    }

    private static AGConnectApp initialize(Context context, String str) {
        return C5471a.a(context, str);
    }

    public abstract void setApiKey(String str);

    public abstract void setAppId(String str);

    public abstract void setClientId(String str);

    public abstract void setClientSecret(String str);

    public abstract void setCpId(String str);

    public abstract void setCustomAuthProvider(CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(String str, String str2);

    public abstract void setProductId(String str);
}
