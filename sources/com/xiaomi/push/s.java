package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s implements Runnable {
    final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f821a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str, String str2, String str3) {
        this.a = rVar;
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
