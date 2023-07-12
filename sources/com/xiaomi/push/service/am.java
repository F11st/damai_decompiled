package com.xiaomi.push.service;

import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class am extends al.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ax f889a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(String str, ax axVar, int i) {
        this.f890a = str;
        this.f889a = axVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return this.f890a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f889a.a(this.a);
    }
}
