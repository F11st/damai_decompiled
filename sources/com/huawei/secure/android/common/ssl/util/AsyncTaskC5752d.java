package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* compiled from: Taobao */
/* renamed from: com.huawei.secure.android.common.ssl.util.d */
/* loaded from: classes10.dex */
public class AsyncTaskC5752d extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = AsyncTaskC5752d.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            String str = a;
            C5755g.b(str, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        String str2 = a;
        C5755g.a(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            AbstractC5754f.a(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C5755g.a(a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            C5755g.c(a, "onPostExecute: upate done");
        } else {
            C5755g.b(a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        C5755g.c(a, "onProgressUpdate");
    }
}
