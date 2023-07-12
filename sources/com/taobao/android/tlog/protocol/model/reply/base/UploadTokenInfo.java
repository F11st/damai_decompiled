package com.taobao.android.tlog.protocol.model.reply.base;

import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UploadTokenInfo extends LinkedHashMap<String, String> {
    private static final long serialVersionUID = 1;
    public FileInfo fileInfo;

    public UploadTokenInfo set(String str, String str2) {
        put(str, str2);
        return this;
    }
}
