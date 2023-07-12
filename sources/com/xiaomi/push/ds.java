package com.xiaomi.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ds implements Runnable {
    final /* synthetic */ dr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.a = drVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
