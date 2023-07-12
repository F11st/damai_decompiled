package com.taobao.android.tlog.protocol.builder;

import com.taobao.android.tlog.protocol.utils.Base64;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UploadDataBuilder {
    private static String TAG = "TLOG.Protocol.UploadDataBuilder";

    public static String buildLogUploadContent(String str) throws Exception {
        return Base64.encodeBase64String(str.getBytes());
    }
}
