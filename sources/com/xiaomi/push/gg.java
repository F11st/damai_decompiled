package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class gg implements Runnable {
    final /* synthetic */ gd a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(gd gdVar, String str) {
        this.a = gdVar;
        this.f419a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cv.a().a(this.f419a, true);
    }
}
