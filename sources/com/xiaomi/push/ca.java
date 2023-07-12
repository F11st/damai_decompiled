package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ca extends al.AbstractRunnableC7597a {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC7622cn interfaceC7622cn;
        InterfaceC7622cn interfaceC7622cn2;
        Context context;
        interfaceC7622cn = this.a.f144a;
        if (interfaceC7622cn != null) {
            interfaceC7622cn2 = this.a.f144a;
            context = this.a.f141a;
            interfaceC7622cn2.b(context);
            this.a.b("delete_time");
        }
    }
}
