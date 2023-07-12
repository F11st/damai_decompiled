package anet.channel;

import anet.channel.session.TnetSpdySession;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface DataFrameCb {
    void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i, int i2);

    void onException(int i, int i2, boolean z, String str);
}
