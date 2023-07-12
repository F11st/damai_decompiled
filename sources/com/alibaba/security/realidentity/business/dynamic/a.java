package com.alibaba.security.realidentity.business.dynamic;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.realidentity.RPEventListener;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class a<T> extends AsyncTask<String, Void, T> {
    protected final WeakReference<Context> a;
    protected final String b;
    protected final RPEventListener c;
    protected final Runnable d;
    protected final com.alibaba.security.realidentity.d.b e;

    public a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, com.alibaba.security.realidentity.d.b bVar) {
        this.a = new WeakReference<>(context);
        this.b = str;
        this.c = rPEventListener;
        this.d = runnable;
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public T doInBackground(String... strArr) {
        return null;
    }

    public abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(T t) {
        super.onPostExecute(t);
        a((a<T>) t);
    }
}
