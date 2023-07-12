package tb;

import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class xa2 {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final IAuth d;
    public final IHeartbeat e;
    public final DataFrameCb f;

    private xa2(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        this.a = str;
        this.c = z2;
        this.d = iAuth;
        this.b = z;
        this.e = iHeartbeat;
        this.f = dataFrameCb;
    }

    public static xa2 a(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        return new xa2(str, z, z2, iAuth, iHeartbeat, dataFrameCb);
    }
}
