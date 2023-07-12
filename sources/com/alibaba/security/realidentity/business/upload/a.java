package com.alibaba.security.realidentity.business.upload;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.realidentity.business.start.UploadToken;
import com.alibaba.security.realidentity.upload.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class a extends AsyncTask<UploadToken, Void, String> {
    private static final String l = e.class.getSimpleName();
    String a;
    protected String b;
    AtomicInteger c;
    AtomicIntegerArray d;
    int e;
    int f;
    InterfaceC0170a g;
    protected String h;
    protected com.alibaba.security.realidentity.upload.a.a i;
    protected String j;
    protected String k;
    private ThreadPoolExecutor m;
    private byte[] n;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.upload.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0170a {
        void a();

        void b();
    }

    public a(Context context, String str, String str2, String str3, String str4, byte[] bArr) {
        this.n = bArr;
        a(context, str, str2, str3, str4);
    }

    private void a(Context context, String str, String str2, String str3, String str4) {
        this.a = str2;
        this.k = str;
        if (str4 != null && !str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        this.h = str4;
        this.b = str3;
        com.alibaba.security.realidentity.upload.b unused = b.a.a;
        com.alibaba.security.realidentity.upload.a.a a = com.alibaba.security.realidentity.upload.b.a(context);
        this.i = a;
        a.b = str;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.upload.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-uploadService");
            }
        });
        this.m = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void b(int i) {
        this.f = i;
    }

    private String e() {
        return this.a;
    }

    private boolean f() {
        for (int i = 0; i < this.f; i++) {
            if (this.d.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    private void g() {
        this.d.addAndGet(this.e, 1);
    }

    private void h() {
        this.d.addAndGet(this.e, 0);
    }

    private static long i() {
        return GetCacheDataManager.getInstance().getUploadTimeOut();
    }

    protected boolean c() {
        return false;
    }

    protected abstract String d();

    protected byte[] b() {
        return this.n;
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4);
    }

    private void a(InterfaceC0170a interfaceC0170a) {
        this.g = interfaceC0170a;
    }

    private void a(AtomicIntegerArray atomicIntegerArray) {
        this.d = atomicIntegerArray;
    }

    private void a(AtomicInteger atomicInteger) {
        this.c = atomicInteger;
    }

    private void a(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(com.alibaba.security.realidentity.business.start.UploadToken... r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.alibaba.security.realidentity.a.g r1 = com.alibaba.security.realidentity.a.g.a.a()
            android.content.Context r1 = r1.c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r1 = r1.getAbsolutePath()
            r2.append(r1)
            java.lang.String r1 = "/realidentity"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.append(r1)
            java.lang.String r1 = "/images/"
            r0.append(r1)
            java.lang.String r1 = r9.k
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r9.b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 1
            r4 = 0
            java.util.concurrent.FutureTask r5 = new java.util.concurrent.FutureTask     // Catch: java.lang.Exception -> L69
            com.alibaba.security.realidentity.business.upload.a$2 r6 = new com.alibaba.security.realidentity.business.upload.a$2     // Catch: java.lang.Exception -> L69
            r6.<init>()     // Catch: java.lang.Exception -> L69
            r5.<init>(r6)     // Catch: java.lang.Exception -> L69
            java.util.concurrent.ThreadPoolExecutor r6 = r9.m     // Catch: java.lang.Exception -> L67
            r6.execute(r5)     // Catch: java.lang.Exception -> L67
            r6 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Exception -> L67
            java.lang.Object r6 = r5.get(r6, r8)     // Catch: java.lang.Exception -> L67
            byte[] r6 = (byte[]) r6     // Catch: java.lang.Exception -> L67
            goto L70
        L67:
            goto L6a
        L69:
            r5 = r4
        L6a:
            if (r5 == 0) goto L6f
            r5.cancel(r3)
        L6f:
            r6 = r4
        L70:
            java.lang.String r5 = ""
            if (r6 != 0) goto L82
            boolean r10 = r9.c()
            if (r10 != 0) goto L7d
            r9.j = r4
            goto L7f
        L7d:
            r9.j = r5
        L7f:
            java.lang.String r10 = r9.j
            return r10
        L82:
            boolean r0 = com.alibaba.security.common.d.e.a(r0, r6, r1)
            if (r0 != 0) goto L8b
            r9.j = r5
            return r5
        L8b:
            com.alibaba.security.realidentity.upload.UploadFileModel r0 = new com.alibaba.security.realidentity.upload.UploadFileModel
            r0.<init>()
            java.lang.String r1 = "jpeg"
            r0.setFileType(r1)
            r0.setLocalFilePath(r2)
            r0.setRemoteFileName(r4)
            r1 = 0
            r10 = r10[r1]
            com.alibaba.security.realidentity.upload.UploadFileConfigParams r1 = new com.alibaba.security.realidentity.upload.UploadFileConfigParams
            r1.<init>()
            java.lang.String r4 = "image/jpeg"
            r1.setContentType(r4)
            java.lang.String r4 = r10.bucket
            r1.setBucket(r4)
            java.lang.String r4 = r10.endPoint
            r1.setEndPoint(r4)
            long r4 = r10.expired
            r1.setExpired(r4)
            java.lang.String r4 = r10.key
            r1.setKey(r4)
            java.lang.String r4 = r10.path
            r1.setPath(r4)
            java.lang.String r4 = r10.secret
            r1.setSecret(r4)
            java.lang.String r10 = r10.token
            r1.setToken(r10)
            java.util.concurrent.CountDownLatch r10 = new java.util.concurrent.CountDownLatch
            r10.<init>(r3)
            com.alibaba.security.realidentity.upload.a.a r1 = r9.i
            com.alibaba.security.realidentity.business.upload.a$3 r3 = new com.alibaba.security.realidentity.business.upload.a$3
            r3.<init>()
            java.lang.Object r0 = r1.a(r0, r3)
            com.alibaba.security.biometrics.service.common.GetCacheDataManager r1 = com.alibaba.security.biometrics.service.common.GetCacheDataManager.getInstance()     // Catch: java.lang.InterruptedException -> Le9
            long r1 = r1.getUploadTimeOut()     // Catch: java.lang.InterruptedException -> Le9
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> Le9
            r10.await(r1, r3)     // Catch: java.lang.InterruptedException -> Le9
            goto Lee
        Le9:
            com.alibaba.security.realidentity.upload.a.a r10 = r9.i
            r10.a(r0)
        Lee:
            java.lang.String r10 = r9.j
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.business.upload.a.doInBackground(com.alibaba.security.realidentity.business.start.UploadToken[]):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        boolean z = false;
        if (this.j == null) {
            this.d.addAndGet(this.e, 0);
        } else {
            this.d.addAndGet(this.e, 1);
        }
        if (this.c.decrementAndGet() != 0 || this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.f) {
                z = true;
                break;
            } else if (this.d.get(i) == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.g.a();
        } else {
            this.g.b();
        }
    }

    public final String a() {
        return this.j;
    }
}
