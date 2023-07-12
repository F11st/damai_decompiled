package com.youku.network;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DisposableHttpTask extends Thread {
    private static final String AD_TAG = "HttpCommunication.advertisement";
    private String url;

    public DisposableHttpTask(String str) {
        super("DisposableHttpTask");
        this.url = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:31:0x008e). Please submit an issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            java.lang.String r0 = "HttpCommunication.advertisement"
            super.run()
            boolean r1 = com.youku.httpcommunication.C7926c.d()
            if (r1 == 0) goto L8e
            com.youku.httpcommunication.C7926c.b()
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r3 = r6.url     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r3.<init>()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r4 = "advertisement exposure url："
            r3.append(r4)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r4 = r6.url     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r3.append(r4)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            com.youku.httpcommunication.C7924a.b(r0, r3)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r1 = 15000(0x3a98, float:2.102E-41)
            r2.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r2.setReadTimeout(r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            java.lang.String r1 = "User-Agent"
            java.lang.String r3 = com.youku.config.YoukuConfig.getUserAgent()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r2.setRequestProperty(r1, r3)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r2.connect()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            int r1 = r2.getResponseCode()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            java.lang.String r4 = "the response of advertisement exposure url："
            r3.append(r4)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r3.append(r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            com.youku.httpcommunication.C7924a.b(r0, r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L81
            r2.disconnect()     // Catch: java.lang.Exception -> L7c
            goto L8e
        L66:
            r1 = move-exception
            goto L6e
        L68:
            r0 = move-exception
            goto L83
        L6a:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L6e:
            java.lang.String r3 = "DisposableHttpTask run Exception"
            com.youku.httpcommunication.C7924a.a(r0, r3, r1)     // Catch: java.lang.Throwable -> L81
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L8e
            r2.disconnect()     // Catch: java.lang.Exception -> L7c
            goto L8e
        L7c:
            r0 = move-exception
            r0.printStackTrace()
            goto L8e
        L81:
            r0 = move-exception
            r1 = r2
        L83:
            if (r1 == 0) goto L8d
            r1.disconnect()     // Catch: java.lang.Exception -> L89
            goto L8d
        L89:
            r1 = move-exception
            r1.printStackTrace()
        L8d:
            throw r0
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.network.DisposableHttpTask.run():void");
    }
}
