package com.alibaba.security.realidentity.track;

import android.content.Context;
import android.os.Looper;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.d.C3801a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.b.InterfaceC3832a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.http.RpcInvoker;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.track.a */
/* loaded from: classes8.dex */
public final class C3915a implements InterfaceC3832a {
    private static final String b = "TrackUpload";
    private static final boolean c = false;
    final String a = "mtop.verifycenter.rp.log";
    private final Context d;
    private final ThreadPoolExecutor e;

    public C3915a(Context context) {
        this.d = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.track.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "tbrpsdk-trackUpload");
            }
        });
        this.e = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(List<TrackLog> list) {
        RPTrackHttpModel rPTrackHttpModel = new RPTrackHttpModel();
        String str = C3847g.C3848a.a.d;
        rPTrackHttpModel.setClientInfo(a(str));
        rPTrackHttpModel.setVerifyToken(str);
        rPTrackHttpModel.setWirelessLogs(list);
        HashMap hashMap = new HashMap();
        hashMap.put("request", C3811h.a(rPTrackHttpModel));
        Context context = this.d;
        if (context != null) {
            RpcInvoker.callMtopSync(context, "mtop.verifycenter.rp.log", "1.0", true, C3811h.a((Object) hashMap));
        }
    }

    private ClientInfo a(String str) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag(C3801a.a(ALBiometricsJni.genVersionTag(this.d, str)));
        return clientInfo;
    }

    @Override // com.alibaba.security.common.track.b.InterfaceC3832a
    public final void a(final List<TrackLog> list) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.e.execute(new Runnable() { // from class: com.alibaba.security.realidentity.track.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    C3915a.this.b(list);
                }
            });
        } else {
            b(list);
        }
    }
}
