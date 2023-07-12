package com.youku.network.call;

import android.os.Handler;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.C7926c;
import com.youku.network.C8004d;
import com.youku.network.C8007e;
import com.youku.network.InterfaceC7974a;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.l */
/* loaded from: classes3.dex */
public class C7998l implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private InterfaceC7974a a;
    private C8004d b;
    private int c;
    private int d;
    private Map<String, List<String>> e;
    private volatile boolean f;
    private NetworkEvent$FinishEvent g;
    private boolean h;
    private ByteArrayOutputStream i;
    private Handler j;
    private IAntiFlowManager k;

    public C7998l(Handler handler, InterfaceC7974a interfaceC7974a, IAntiFlowManager iAntiFlowManager) {
        this.b = C8004d.a();
        this.d = 0;
        this.f = false;
        this.g = null;
        this.h = false;
        this.i = null;
        this.a = interfaceC7974a;
        this.j = handler;
        this.k = iAntiFlowManager;
    }

    public C7998l(InterfaceC7974a interfaceC7974a, IAntiFlowManager iAntiFlowManager) {
        this(null, interfaceC7974a, iAntiFlowManager);
    }

    private int a(Map<String, List<String>> map) {
        String a = a(map, "content-length");
        if (C7926c.b(a)) {
            try {
                return Integer.parseInt(a);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private String a(Map<String, List<String>> map, String str) {
        List<String> b = b(map, str);
        if (b == null || b.isEmpty()) {
            return null;
        }
        return b.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final NetworkEvent$FinishEvent networkEvent$FinishEvent, final Object obj) {
        C8007e.a().submit(new Runnable() { // from class: com.youku.network.call.NetworkListener$2
            @Override // java.lang.Runnable
            public void run() {
                C7998l.this.b(networkEvent$FinishEvent, obj);
            }
        });
    }

    private List<String> b(Map<String, List<String>> map, String str) {
        if (map != null && !map.isEmpty() && !C7926c.c(str)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        if (this.a == null) {
            return;
        }
        this.b.b(networkEvent$FinishEvent.getHttpCode());
        this.b.a(this.e);
        this.b.a(networkEvent$FinishEvent.getDesc());
        ByteArrayOutputStream byteArrayOutputStream = this.i;
        if (byteArrayOutputStream != null) {
            this.b.a(byteArrayOutputStream.toByteArray());
        }
        this.b.a(networkEvent$FinishEvent.getStatisticData());
        this.k.afterCall(this.b.d(), this.b.f());
        Handler handler = this.j;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.youku.network.call.NetworkListener$3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC7974a interfaceC7974a;
                    C8004d c8004d;
                    interfaceC7974a = C7998l.this.a;
                    c8004d = C7998l.this.b;
                    interfaceC7974a.a(c8004d);
                }
            });
        } else {
            this.a.a(this.b);
        }
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        synchronized (this) {
            this.g = networkEvent$FinishEvent;
            if (this.h || !this.f) {
                a(networkEvent$FinishEvent, obj);
            }
        }
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(final ParcelableInputStream parcelableInputStream, final Object obj) {
        this.f = true;
        MtopSDKThreadPoolExecutorFactory.submitRequestTask(new Runnable() { // from class: com.youku.network.call.NetworkListener$1
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
                if (r0 != null) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
                if (r0 == null) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
                r0.close();
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r4 = this;
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    int r0 = r0.length()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    if (r0 <= 0) goto Lf
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    int r0 = r0.length()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    goto L15
                Lf:
                    com.youku.network.call.l r0 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    int r0 = com.youku.network.call.C7998l.a(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                L15:
                    com.youku.network.call.l r1 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    r2.<init>(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    com.youku.network.call.C7998l.a(r1, r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                L23:
                    anetwork.channel.aidl.ParcelableInputStream r1 = r2     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    int r1 = r1.read(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    r2 = -1
                    if (r1 == r2) goto L37
                    com.youku.network.call.l r2 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    java.io.ByteArrayOutputStream r2 = com.youku.network.call.C7998l.b(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    r3 = 0
                    r2.write(r0, r3, r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
                    goto L23
                L37:
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2
                    if (r0 == 0) goto L4b
                    goto L48
                L3c:
                    r0 = move-exception
                    goto L76
                L3e:
                    com.youku.network.call.l r0 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L3c
                    r1 = 0
                    com.youku.network.call.C7998l.a(r0, r1)     // Catch: java.lang.Throwable -> L3c
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2
                    if (r0 == 0) goto L4b
                L48:
                    r0.close()     // Catch: java.lang.Exception -> L4b
                L4b:
                    com.youku.network.call.l r0 = com.youku.network.call.C7998l.this
                    java.io.ByteArrayOutputStream r0 = com.youku.network.call.C7998l.b(r0)
                    mtopsdk.network.util.NetworkUtils.closeQuietly(r0)
                    com.youku.network.call.l r0 = com.youku.network.call.C7998l.this
                    monitor-enter(r0)
                    com.youku.network.call.l r1 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L73
                    anetwork.channel.NetworkEvent$FinishEvent r1 = com.youku.network.call.C7998l.c(r1)     // Catch: java.lang.Throwable -> L73
                    if (r1 == 0) goto L6b
                    com.youku.network.call.l r1 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L73
                    anetwork.channel.NetworkEvent$FinishEvent r2 = com.youku.network.call.C7998l.c(r1)     // Catch: java.lang.Throwable -> L73
                    java.lang.Object r3 = r3     // Catch: java.lang.Throwable -> L73
                    com.youku.network.call.C7998l.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L73
                    goto L71
                L6b:
                    com.youku.network.call.l r1 = com.youku.network.call.C7998l.this     // Catch: java.lang.Throwable -> L73
                    r2 = 1
                    com.youku.network.call.C7998l.a(r1, r2)     // Catch: java.lang.Throwable -> L73
                L71:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L73
                    return
                L73:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L73
                    throw r1
                L76:
                    anetwork.channel.aidl.ParcelableInputStream r1 = r2
                    if (r1 == 0) goto L7d
                    r1.close()     // Catch: java.lang.Exception -> L7d
                L7d:
                    com.youku.network.call.l r1 = com.youku.network.call.C7998l.this
                    java.io.ByteArrayOutputStream r1 = com.youku.network.call.C7998l.b(r1)
                    mtopsdk.network.util.NetworkUtils.closeQuietly(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.network.call.NetworkListener$1.run():void");
            }
        });
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
        this.c = i;
        this.e = map;
        this.d = a(map);
        return false;
    }
}
