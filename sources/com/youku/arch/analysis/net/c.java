package com.youku.arch.analysis.net;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.ntk.a.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final double[] a = {1.0d, 0.8d, 0.64d, 0.51d, 0.41d, 0.32d, 0.26d, 0.21d, 0.17d, 0.14d, 0.11d, 0.09d, 0.07d, 0.06d, 0.05d};
    private volatile long b;
    private Context c;
    private volatile List<e> d;
    private volatile e e;
    private long f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class a {
        private static final c a = new c(null);
    }

    private c() {
        this.d = new ArrayList();
    }

    /* synthetic */ c(SmartEvaluator$1 smartEvaluator$1) {
        this();
    }

    public static c a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-339016233") ? (c) ipChange.ipc$dispatch("-339016233", new Object[0]) : a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.analysis.net.c.$ipChange
            java.lang.String r1 = "-958240663"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r5 = 2
            r2[r5] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            java.io.File r0 = new java.io.File
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.String r1 = "NetQuality.log"
            r0.<init>(r5, r1)
            r5 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r1.write(r6)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L4d
            r1.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L36:
            r5 = move-exception
            goto L3f
        L38:
            r6 = move-exception
            r1 = r5
            r5 = r6
            goto L4e
        L3c:
            r6 = move-exception
            r1 = r5
            r5 = r6
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r5 = move-exception
            r5.printStackTrace()
        L4c:
            return
        L4d:
            r5 = move-exception
        L4e:
            if (r1 == 0) goto L58
            r1.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r6 = move-exception
            r6.printStackTrace()
        L58:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.analysis.net.c.a(android.content.Context, java.lang.String):void");
    }

    private void a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106466377")) {
            ipChange.ipc$dispatch("-106466377", new Object[]{this, aVar});
            return;
        }
        synchronized (this) {
            if (this.e != null) {
                if (aVar.f) {
                    if (aVar.a() == 1) {
                        this.e.c++;
                    }
                    if (aVar.a() != 0) {
                        this.e.b++;
                    }
                    if (aVar.e == 1) {
                        this.e.d++;
                    }
                } else {
                    if (aVar.a() == 1) {
                        this.e.f++;
                    }
                    if (aVar.a() != 0) {
                        this.e.e++;
                    }
                    if (aVar.e == 1) {
                        this.e.g++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String sb;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426511943")) {
            ipChange.ipc$dispatch("1426511943", new Object[]{this});
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.c.getFilesDir().getAbsolutePath(), "NetQuality.log")));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            bufferedReader.close();
            sb = sb2.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (!TextUtils.isEmpty(sb)) {
            synchronized (this) {
                this.d = JSON.parseArray(sb, e.class);
            }
        }
        this.f = d();
        synchronized (this) {
            Iterator<e> it = this.d.iterator();
            while (it.hasNext()) {
                e next = it.next();
                long j = this.f;
                long j2 = next.a;
                if (j - j2 > 2592000) {
                    it.remove();
                } else if (j == j2) {
                    this.e = next;
                }
            }
            if (this.e == null) {
                this.e = new e();
                this.e.a = this.f;
                this.d.add(this.e);
            }
        }
    }

    private long d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426541722")) {
            return ((Long) ipChange.ipc$dispatch("1426541722", new Object[]{this})).longValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis - (currentTimeMillis % 86400);
    }

    public com.youku.arch.analysis.net.a b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686475704")) {
            return (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("686475704", new Object[]{this});
        }
        com.youku.arch.analysis.net.a aVar = new com.youku.arch.analysis.net.a();
        if (com.youku.arch.probe.plugins.c.b) {
            com.youku.arch.probe.plugins.c.a(com.youku.arch.probe.plugins.b.c).a(com.youku.arch.probe.plugins.c.a(com.youku.arch.probe.plugins.d.c).a(aVar));
            aVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b > DateUtils.MILLIS_PER_MINUTE) {
                this.b = currentTimeMillis;
                a(aVar);
            }
            b.a().b();
        }
        AdapterForTLog.loge("speedtest", "NetQuality:" + aVar.toString());
        return aVar;
    }
}
