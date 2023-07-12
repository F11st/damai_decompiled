package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bj;
import com.xiaomi.push.service.bn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.ar */
/* loaded from: classes11.dex */
public class C7563ar extends ContentObserver {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7563ar(ao aoVar, Handler handler) {
        super(handler);
        this.a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ao aoVar = this.a;
        context = aoVar.f48a;
        aoVar.f52a = Integer.valueOf(bn.a(context).a());
        num = this.a.f52a;
        if (num.intValue() != 0) {
            context2 = this.a.f48a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f48a;
            if (bj.b(context3)) {
                this.a.m626c();
            }
        }
    }
}
