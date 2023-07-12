package com.xiaomi.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ft extends Thread {
    final /* synthetic */ fs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft(fs fsVar, String str) {
        super(str);
        this.a = fsVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fn fnVar;
        try {
            fnVar = this.a.a;
            fnVar.m897a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
