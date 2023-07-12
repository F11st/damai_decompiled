package com.sina.weibo.sdk.share;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.share.d */
/* loaded from: classes7.dex */
public final class AsyncTaskC6230d extends AsyncTask<WeiboMultiMessage, Void, C6229c> {
    private WeakReference<Context> B;
    private InterfaceC6228b C;

    public AsyncTaskC6230d(Context context, InterfaceC6228b interfaceC6228b) {
        this.B = new WeakReference<>(context);
        this.C = interfaceC6228b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012d A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:16:0x002c, B:18:0x0030, B:20:0x0034, B:21:0x0036, B:23:0x003a, B:25:0x003e, B:27:0x0042, B:28:0x0046, B:30:0x004d, B:31:0x005c, B:33:0x0062, B:35:0x006a, B:37:0x0074, B:39:0x007f, B:41:0x0089, B:46:0x0096, B:48:0x009a, B:49:0x00a1, B:51:0x00ab, B:52:0x00b8, B:53:0x00bf, B:54:0x00c0, B:55:0x00c7, B:56:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:63:0x00de, B:65:0x00e9, B:74:0x011a, B:76:0x0120, B:81:0x012d, B:83:0x0131, B:84:0x0147, B:86:0x015e, B:87:0x0174, B:88:0x017b, B:68:0x00f8, B:70:0x0102, B:73:0x010a, B:89:0x017c, B:90:0x0183, B:91:0x0184), top: B:99:0x002c }] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sina.weibo.sdk.share.C6229c doInBackground(com.sina.weibo.sdk.api.WeiboMultiMessage... r13) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.AsyncTaskC6230d.doInBackground(com.sina.weibo.sdk.api.WeiboMultiMessage[]):com.sina.weibo.sdk.share.c");
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(C6229c c6229c) {
        C6229c c6229c2 = c6229c;
        super.onPostExecute(c6229c2);
        InterfaceC6228b interfaceC6228b = this.C;
        if (interfaceC6228b != null) {
            interfaceC6228b.a(c6229c2);
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        super.onPreExecute();
    }
}
