package com.xiaomi.push;

import com.xiaomi.push.df;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dg extends df.C7630b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ df f205a;

    /* renamed from: a  reason: collision with other field name */
    File f206a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f207a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f208a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f209a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f210b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(df dfVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f205a = dfVar;
        this.a = i;
        this.f208a = date;
        this.f210b = date2;
        this.f207a = str;
        this.b = str2;
        this.f209a = z;
    }

    @Override // com.xiaomi.push.df.C7630b, com.xiaomi.push.ao.AbstractC7600b
    public void b() {
        if (C7595ad.d()) {
            try {
                File file = new File(this.f205a.f198a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    C7628de c7628de = new C7628de();
                    c7628de.a(this.a);
                    this.f206a = c7628de.a(this.f205a.f198a, this.f208a, this.f210b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ao.AbstractC7600b
    /* renamed from: c */
    public void mo765c() {
        File file = this.f206a;
        if (file != null && file.exists()) {
            this.f205a.f199a.add(new df.C7631c(this.f207a, this.b, this.f206a, this.f209a));
        }
        this.f205a.a(0L);
    }
}
