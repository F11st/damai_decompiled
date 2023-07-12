package com.alibaba.motu.tbrest.rest;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestHttpUtils {
    public static final int HTTP_REQ_TYPE_GET = 1;
    public static final int HTTP_REQ_TYPE_POST_FORM_DATA = 2;
    public static final int HTTP_REQ_TYPE_POST_URL_ENCODED = 3;
    public static final int MAX_CONNECTION_TIME_OUT = 10000;
    public static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 60000;
    private static final String POST_Field_BOTTOM = "--GJircTeP--\r\n";
    private static final String POST_Field_TOP = "--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n";

    /* JADX WARN: Removed duplicated region for block: B:102:0x01be A[Catch: IOException -> 0x01d8, all -> 0x01f0, LOOP:0: B:100:0x01b7->B:102:0x01be, LOOP_END, TRY_LEAVE, TryCatch #0 {IOException -> 0x01d8, blocks: (B:99:0x01b4, B:100:0x01b7, B:102:0x01be), top: B:167:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01c2 A[EDGE_INSN: B:193:0x01c2->B:104:0x01c2 ?: BREAK  , EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] sendRequest(int r17, java.lang.String r18, java.util.Map<java.lang.String, java.lang.Object> r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.rest.RestHttpUtils.sendRequest(int, java.lang.String, java.util.Map, boolean):byte[]");
    }
}
