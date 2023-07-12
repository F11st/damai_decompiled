package com.taobao.android.riverlogger.remote;

import com.taobao.android.riverlogger.C6572c;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLogInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.taobao.android.riverlogger.remote.c */
/* loaded from: classes11.dex */
public class C6583c implements RVLLogInterface {
    private static final AtomicBoolean a = new AtomicBoolean(true);

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public void log(C6572c c6572c) {
        RemoteChannel c = C6581b.c();
        if (c == null) {
            return;
        }
        if (a.compareAndSet(true, false)) {
            c.j(String.format("{\"method\":\"Dev.log\",\"params\":{\"level\":\"Error\",\"module\":\"LOGGER/CLIENT_RESTART_MARK\",\"time\":%d}}", Long.valueOf(System.currentTimeMillis())));
        }
        String a2 = c6572c.a();
        c.j(String.format("{\"method\":\"Dev.log\",\"params\":{\"level\":\"%s\",\"module\":\"%s\",%s}", c6572c.a.toString(), c6572c.b, c6572c.j ? a2.substring(1) : String.format("\"time\":%d,\"ext\":%s}", Long.valueOf(System.currentTimeMillis()), JSONObject.quote(a2))));
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        if (C6581b.c() != null) {
            return RVLLevel.Verbose;
        }
        return RVLLevel.Off;
    }
}
