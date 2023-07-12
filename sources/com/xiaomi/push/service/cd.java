package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class cd extends al.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Notification f958a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f959a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f960a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.a = i;
        this.f960a = str;
        this.f959a = context;
        this.b = str2;
        this.f958a = notification;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        String b;
        b = cc.b(this.a, this.f960a);
        return b;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        cc.c(this.f959a, this.b, this.a, this.f960a, this.f958a);
    }
}
