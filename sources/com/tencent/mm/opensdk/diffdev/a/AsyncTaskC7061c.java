package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* compiled from: Taobao */
/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: classes11.dex */
class AsyncTaskC7061c extends AsyncTask<Void, Void, C7062a> {
    private String a;
    private String b;
    private OAuthListener c;
    private int d;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.mm.opensdk.diffdev.a.c$a */
    /* loaded from: classes11.dex */
    static class C7062a {
        public OAuthErrCode a;
        public String b;
        public int c;

        C7062a() {
        }
    }

    public AsyncTaskC7061c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.mm.opensdk.diffdev.a.AsyncTaskC7061c.C7062a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.AsyncTaskC7061c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(C7062a c7062a) {
        C7062a c7062a2 = c7062a;
        this.c.onAuthFinish(c7062a2.a, c7062a2.b);
    }
}
