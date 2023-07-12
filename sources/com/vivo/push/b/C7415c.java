package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.c */
/* loaded from: classes11.dex */
public class C7415c extends AbstractC7496o {
    private String a;
    private String b;
    private long c;
    private int d;
    private int e;
    private String f;

    public C7415c(int i, String str) {
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
    @Override // com.vivo.push.AbstractC7496o
    public void c(C7410a c7410a) {
        c7410a.a("req_id", this.a);
        c7410a.a("package_name", this.b);
        c7410a.a("sdk_version", 323L);
        c7410a.a("PUSH_APP_STATUS", this.d);
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        c7410a.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC7496o
    public void d(C7410a c7410a) {
        this.a = c7410a.a("req_id");
        this.b = c7410a.a("package_name");
        this.c = c7410a.b("sdk_version", 0L);
        this.d = c7410a.b("PUSH_APP_STATUS", 0);
        this.f = c7410a.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
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

    @Override // com.vivo.push.AbstractC7496o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                C7523p.a("BaseAppCommand", "pkg name is null");
                String a = a();
                if (TextUtils.isEmpty(a)) {
                    C7523p.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a;
            }
            this.d = C7527t.b(context, str);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }
}
