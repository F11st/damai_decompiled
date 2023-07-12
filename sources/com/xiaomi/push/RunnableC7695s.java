package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.s */
/* loaded from: classes11.dex */
public class RunnableC7695s implements Runnable {
    final /* synthetic */ C7694r a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f821a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7695s(C7694r c7694r, String str, String str2, String str3) {
        this.a = c7694r;
        this.f821a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.f818a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f821a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
