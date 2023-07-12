package com.taobao.applink.c;

import android.os.AsyncTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, String str, String str2, String str3) {
        this.d = bVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        this.d.d(this.a, this.b, this.c);
        return null;
    }
}
