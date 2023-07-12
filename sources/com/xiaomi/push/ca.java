package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ca extends al.a {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cn cnVar2;
        Context context;
        cnVar = this.a.f144a;
        if (cnVar != null) {
            cnVar2 = this.a.f144a;
            context = this.a.f141a;
            cnVar2.b(context);
            this.a.b("delete_time");
        }
    }
}
