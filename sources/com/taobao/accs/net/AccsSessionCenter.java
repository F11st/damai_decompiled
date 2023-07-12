package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.c;
import anet.channel.entity.ConnType;
import com.taobao.accs.connection.ConnectionServiceManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsSessionCenter {
    private static final String TAG = "AccsSessionCenter";

    public static Session get(c cVar, String str, long j) {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return cVar.h(str, j);
        }
        return null;
    }

    public static Session getThrowsException(c cVar, String str, long j) throws Exception {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return cVar.r(str, j);
        }
        return null;
    }

    public static Session get(c cVar, String str, ConnType.TypeLevel typeLevel, long j) {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return cVar.i(str, typeLevel, j);
        }
        return null;
    }

    public static Session getThrowsException(c cVar, String str, ConnType.TypeLevel typeLevel, long j) throws Exception {
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return cVar.s(str, typeLevel, j);
        }
        return null;
    }
}
