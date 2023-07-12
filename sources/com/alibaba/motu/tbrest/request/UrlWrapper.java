package com.alibaba.motu.tbrest.request;

import com.alibaba.motu.tbrest.SendService;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class UrlWrapper {
    private static final int MAX_CONNECTION_TIME_OUT = 10000;
    private static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 60000;
    public static int mErrorCode;
    private static RestSslSocketFactory mRestSslSocketFactory;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0188  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.motu.tbrest.request.BizResponse sendRequest(java.lang.String r9, java.lang.String r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.request.UrlWrapper.sendRequest(java.lang.String, java.lang.String, byte[]):com.alibaba.motu.tbrest.request.BizResponse");
    }

    public static BizResponse sendRequestByUrl(String str, byte[] bArr) {
        return sendRequest(SendService.getInstance().appKey, str, bArr);
    }

    public static BizResponse sendRequest(String str, byte[] bArr) {
        String str2;
        String str3 = SendService.getInstance().appKey;
        if (SendService.getInstance().openHttp.booleanValue()) {
            str2 = "http://" + str + "/upload";
        } else {
            str2 = "https://" + str + "/upload";
        }
        return sendRequest(str3, str2, bArr);
    }
}
