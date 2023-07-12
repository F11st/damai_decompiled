package com.huawei.agconnect;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.a.C5481a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class AGConnectInstance {
    public static AGConnectInstance buildInstance(AGConnectOptions aGConnectOptions) {
        return C5481a.a(aGConnectOptions);
    }

    public static AGConnectInstance getInstance() {
        return C5481a.a();
    }

    public static AGConnectInstance getInstance(String str) {
        return C5481a.a(str);
    }

    public static synchronized void initialize(Context context) {
        synchronized (AGConnectInstance.class) {
            Log.i("AGConnectInstance", "AGConnectInstance#initialize");
            C5481a.a(context);
        }
    }

    public static synchronized void initialize(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (AGConnectInstance.class) {
            Log.i("AGConnectInstance", "AGConnectInstance#initialize with options");
            C5481a.a(context, aGConnectOptionsBuilder);
        }
    }

    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> cls);
}
