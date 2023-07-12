package com.alibaba.security.realidentity.business.dynamic;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.d.C3890b;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.dynamic.a */
/* loaded from: classes8.dex */
public abstract class AbstractAsyncTaskC3874a<T> extends AsyncTask<String, Void, T> {
    protected final WeakReference<Context> a;
    protected final String b;
    protected final RPEventListener c;
    protected final Runnable d;
    protected final C3890b e;

    public AbstractAsyncTaskC3874a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, C3890b c3890b) {
        this.a = new WeakReference<>(context);
        this.b = str;
        this.c = rPEventListener;
        this.d = runnable;
        this.e = c3890b;
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
        a((AbstractAsyncTaskC3874a<T>) t);
    }
}
