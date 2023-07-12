package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.C7523p;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.o */
/* loaded from: classes11.dex */
public abstract class AbstractC7496o {
    private int a;
    private String b;

    public AbstractC7496o(int i) {
        this.a = -1;
        if (i >= 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(C7410a c7410a) {
        c7410a.a("command", this.a);
        c7410a.a("client_pkgname", this.b);
        c(c7410a);
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    protected abstract void c(C7410a c7410a);

    public boolean c() {
        return false;
    }

    protected abstract void d(C7410a c7410a);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(Intent intent) {
        C7410a a = C7410a.a(intent);
        if (a == null) {
            C7523p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a.a("method", this.a);
        e(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(Intent intent) {
        C7410a a = C7410a.a(intent);
        if (a == null) {
            C7523p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(C7410a c7410a) {
        String a = C7497p.a(this.a);
        if (a == null) {
            a = "";
        }
        c7410a.a("method", a);
        e(c7410a);
    }

    public final void b(C7410a c7410a) {
        String a = c7410a.a();
        if (!TextUtils.isEmpty(a)) {
            this.b = a;
        } else {
            this.b = c7410a.a("client_pkgname");
        }
        d(c7410a);
    }
}
