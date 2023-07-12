package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class j implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ e f74a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f75a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, Context context, e eVar) {
        this.f75a = str;
        this.a = context;
        this.f74a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f75a)) {
            return;
        }
        String[] split = this.f75a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m586a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.a, this.f74a, str);
        i.m649a(this.a);
    }
}
