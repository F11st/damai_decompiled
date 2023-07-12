package com.alibaba.aliweex.interceptor.phenix;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import tb.a31;
import tb.b31;
import tb.kp2;
import tb.nh0;
import tb.sj1;
import tb.ui2;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PhenixTracker {
    private static boolean g = true;
    private sj1 a;
    private IWeexAnalyzerInspector b;
    private ExecutorService c;
    @Nullable
    private String d;
    private final int e = kp2.a();
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            a = iArr;
            try {
                iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.CompressFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PhenixTracker() {
        this.c = null;
        this.f = false;
        if (WXEnvironment.isApkDebugable()) {
            this.a = sj1.d();
            this.b = com.alibaba.aliweex.interceptor.a.a();
            this.c = Executors.newSingleThreadExecutor();
            this.f = this.a.g();
            WXLogUtils.d("PhenixTracker", "Create new instance " + toString());
        }
    }

    private boolean f() {
        return g && WXEnvironment.isApkDebugable() && this.a != null && this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(Bitmap.CompressFormat compressFormat) {
        int i = a.a[compressFormat.ordinal()];
        return i != 1 ? i != 2 ? "image/jpeg" : "image/png" : "image/webp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap.CompressFormat h(String str) {
        if (str != null) {
            if (!str.endsWith(".webp") && !str.endsWith(".WEBP")) {
                if (str.endsWith(".png") || str.endsWith(".PNG")) {
                    return Bitmap.CompressFormat.PNG;
                }
            } else {
                return Bitmap.CompressFormat.WEBP;
            }
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        if (this.d == null) {
            this.d = String.valueOf(this.e);
        }
        return this.d;
    }

    public static PhenixTracker j() {
        return new PhenixTracker();
    }

    public void k(final nh0 nh0Var) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (f()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.phenix.PhenixTracker.4
                @Override // java.lang.Runnable
                public void run() {
                    sj1 sj1Var = PhenixTracker.this.a;
                    String i = PhenixTracker.this.i();
                    sj1Var.e(i, "Error code: " + nh0Var.f());
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("image", new IWeexAnalyzerInspector.b(TextUtils.isEmpty(nh0Var.b()) ? "unknown" : nh0Var.b(), "download failed", 200, null));
            } catch (Exception e) {
                WXLogUtils.e("PhenixTracker", e.getMessage());
            }
        }
    }

    public void l(final ui2 ui2Var) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        ExecutorService executorService;
        if (f()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.phenix.PhenixTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    b31 b31Var = new b31();
                    b31Var.h(PhenixTracker.this.i());
                    b31Var.k(ui2Var.g());
                    b31Var.m(ui2Var.g() ? 304 : 200);
                    b31Var.l(ui2Var.g() ? "FROM DISK CACHE" : WXModalUIModule.OK);
                    b31Var.i(ui2Var.b());
                    Bitmap bitmap = ui2Var.f().getBitmap();
                    if (bitmap == null) {
                        PhenixTracker.this.a.j(PhenixTracker.this.i(), "event getbitmap obj is null");
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Bitmap.CompressFormat h = PhenixTracker.this.h(ui2Var.b());
                    bitmap.compress(h, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    b31Var.a("Content-Type", PhenixTracker.this.g(h));
                    b31Var.a(Constants.Protocol.CONTENT_LENGTH, byteArray.length + "");
                    PhenixTracker.this.a.i(b31Var);
                    PhenixTracker.this.a.f(PhenixTracker.this.i(), PhenixTracker.this.g(h), null, new ByteArrayInputStream(byteArray), false);
                    PhenixTracker.this.a.k(PhenixTracker.this.i());
                }
            });
        }
        if (!WXEnvironment.isApkDebugable() || !g || (iWeexAnalyzerInspector = this.b) == null || !iWeexAnalyzerInspector.isEnabled() || (executorService = this.c) == null || executorService.isShutdown()) {
            return;
        }
        this.c.execute(new Runnable() { // from class: com.alibaba.aliweex.interceptor.phenix.PhenixTracker.3
            @Override // java.lang.Runnable
            public void run() {
                int length;
                try {
                    Bitmap bitmap = ui2Var.f().getBitmap();
                    if (bitmap == null) {
                        length = 0;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(PhenixTracker.this.h(ui2Var.b()), 100, byteArrayOutputStream);
                        length = byteArrayOutputStream.toByteArray().length;
                    }
                    IWeexAnalyzerInspector iWeexAnalyzerInspector2 = PhenixTracker.this.b;
                    String b = TextUtils.isEmpty(ui2Var.b()) ? "unknown" : ui2Var.b();
                    iWeexAnalyzerInspector2.onResponse("image", new IWeexAnalyzerInspector.b(b, Collections.singletonMap(Constants.Protocol.CONTENT_LENGTH, length + "").toString(), ui2Var.g() ? 304 : 200, null));
                } catch (Exception e) {
                    WXLogUtils.e("PhenixTracker", e.getMessage());
                }
            }
        });
    }

    public void m(final wr1 wr1Var, final Map<String, String> map) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (f()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.phenix.PhenixTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    a31 a31Var = new a31();
                    a31Var.i(wr1Var.R());
                    a31Var.h(PhenixTracker.this.i());
                    a31Var.m("GET");
                    a31Var.l("Phenix");
                    for (Map.Entry entry : map.entrySet()) {
                        a31Var.a((String) entry.getKey(), (String) entry.getValue());
                    }
                    PhenixTracker.this.a.h(a31Var);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onRequest("image", new IWeexAnalyzerInspector.a(TextUtils.isEmpty(wr1Var.R()) ? "unknown" : wr1Var.R(), "GET", map));
            } catch (Exception e) {
                WXLogUtils.e("PhenixTracker", e.getMessage());
            }
        }
    }
}
