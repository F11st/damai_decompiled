package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dk implements Runnable {
    final /* synthetic */ dj a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Throwable f218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar, String str, Throwable th) {
        this.a = djVar;
        this.f217a = str;
        this.f218a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        list = dj.f214a;
        simpleDateFormat = dj.f213a;
        str = this.a.b;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f217a), this.f218a));
        list2 = dj.f214a;
        if (list2.size() > 20000) {
            list3 = dj.f214a;
            int size = (list3.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    list5 = dj.f214a;
                    if (list5.size() > 0) {
                        list6 = dj.f214a;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            list4 = dj.f214a;
            simpleDateFormat2 = dj.f213a;
            str4 = this.a.b;
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
        }
        try {
            if (ad.d()) {
                this.a.m767a();
                return;
            }
            str3 = this.a.b;
            Log.w(str3, "SDCard is unavailable.");
        } catch (Exception e) {
            str2 = this.a.b;
            Log.e(str2, "", e);
        }
    }
}
