package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.C7514g;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7530w;
import com.vivo.push.util.C7532y;
import com.vivo.push.util.ContextDelegate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.cache.c */
/* loaded from: classes11.dex */
public abstract class AbstractC7447c<T> {
    protected static final Object a = new Object();
    protected List<T> b = new ArrayList();
    protected Context c;
    private byte[] d;
    private byte[] e;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC7447c(Context context) {
        this.c = ContextDelegate.getContext(context);
        C7530w b = C7530w.b();
        b.a(this.c);
        this.d = b.c();
        this.e = b.d();
        c();
    }

    private String b() {
        return C7532y.b(this.c).a(a(), null);
    }

    private void d(String str) {
        C7532y.b(this.c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (a) {
            C7514g.a(a());
            this.b.clear();
            c(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] e() {
        byte[] bArr = this.d;
        return (bArr == null || bArr.length <= 0) ? C7530w.b().c() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] f() {
        byte[] bArr = this.e;
        return (bArr == null || bArr.length <= 0) ? C7530w.b().d() : bArr;
    }

    public final void d() {
        synchronized (a) {
            this.b.clear();
            d("");
            C7523p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            C7523p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
        } else if (str.length() > 10000) {
            C7523p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
        } else {
            try {
                C7523p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
                List<T> a2 = a(b(str));
                if (a2 != null) {
                    this.b.addAll(a2);
                }
            } catch (Exception e) {
                d();
                C7523p.d("CacheSettings", C7523p.a(e));
            }
        }
    }
}
