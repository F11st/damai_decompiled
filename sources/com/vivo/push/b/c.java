package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c extends com.vivo.push.o {
    private String a;
    private String b;
    private long c;
    private int d;
    private int e;
    private String f;

    public c(int i, String str) {
        super(i);
        this.c = -1L;
        this.d = -1;
        this.a = null;
        this.b = str;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("package_name", this.b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.d);
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.a("package_name");
        this.c = aVar.b("sdk_version", 0L);
        this.d = aVar.b("PUSH_APP_STATUS", 0);
        this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.e;
    }

    public final void g() {
        this.f = null;
    }

    public final String h() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                String a = a();
                if (TextUtils.isEmpty(a)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a;
            }
            this.d = com.vivo.push.util.t.b(context, str);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }
}
