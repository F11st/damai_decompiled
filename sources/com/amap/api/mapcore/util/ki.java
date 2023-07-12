package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ki extends Handler {
    kg a;

    public ki(Looper looper, kg kgVar) {
        super(looper);
        this.a = null;
        this.a = kgVar;
    }

    public ki(kg kgVar) {
        this.a = null;
        this.a = kgVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        try {
            kg kgVar = this.a;
            if (kgVar != null) {
                kgVar.a((Inner_3dMap_location) message.obj);
            }
        } catch (Throwable th) {
            jy.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
        }
    }
}
