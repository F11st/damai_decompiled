package com.taobao.applink.c;

import android.os.AsyncTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.taobao.applink.c.a */
/* loaded from: classes12.dex */
public class AsyncTaskC6679a extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ C6680b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC6679a(C6680b c6680b, String str, String str2, String str3) {
        this.d = c6680b;
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
