package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kh extends Handler {
    kg a;

    public kh() {
        this.a = null;
    }

    public kh(Looper looper, kg kgVar) {
        super(looper);
        this.a = null;
        this.a = kgVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1001:
                try {
                    this.a.a((Inner_3dMap_locationOption) message.obj);
                    return;
                } catch (Throwable th) {
                    th = th;
                    str = "ACTION_SET_OPTION";
                    break;
                }
            case 1002:
                try {
                    this.a.a((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    str = "ACTION_SET_LISTENER";
                    break;
                }
            case 1003:
                try {
                    this.a.b((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    str = "ACTION_REMOVE_LISTENER";
                    break;
                }
            case 1004:
                try {
                    this.a.a();
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    str = "ACTION_START_LOCATION";
                    break;
                }
            case 1005:
                try {
                    this.a.b();
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    str = "ACTION_GET_LOCATION";
                    break;
                }
            case 1006:
                try {
                    this.a.c();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    str = "ACTION_STOP_LOCATION";
                    break;
                }
            case 1007:
                try {
                    this.a.d();
                    return;
                } catch (Throwable th7) {
                    jy.a(th7, "ClientActionHandler", "ACTION_DESTROY");
                    return;
                }
            default:
                return;
        }
        jy.a(th, "ClientActionHandler", str);
    }
}
