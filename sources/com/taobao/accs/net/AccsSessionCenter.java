package com.taobao.accs.net;

import anet.channel.C0162c;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import com.taobao.accs.connection.ConnectionServiceManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsSessionCenter {
    private static final String TAG = "AccsSessionCenter";

    public static Session get(C0162c c0162c, String str, long j) {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return c0162c.h(str, j);
        }
        return null;
    }

    public static Session getThrowsException(C0162c c0162c, String str, long j) throws Exception {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return c0162c.r(str, j);
        }
        return null;
    }

    public static Session get(C0162c c0162c, String str, ConnType.TypeLevel typeLevel, long j) {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return c0162c.i(str, typeLevel, j);
        }
        return null;
    }

    public static Session getThrowsException(C0162c c0162c, String str, ConnType.TypeLevel typeLevel, long j) throws Exception {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return c0162c.s(str, typeLevel, j);
        }
        return null;
    }
}
