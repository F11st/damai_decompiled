package com.alibaba.security.realidentity.upload.a;

import android.content.Context;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class a implements com.alibaba.security.realidentity.upload.b.a {
    protected Context a;
    public String b = g.a.a.d;

    public a(Context context) {
        this.a = context;
    }

    private String a() {
        return this.b;
    }

    private void a(String str) {
        this.b = str;
    }

    public final void a(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, str2);
        hashMap.put("fileLength", Long.valueOf(j));
        a(TrackLog.createOssUploadFileBeginLog(h.a((Object) hashMap)));
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, str2);
        hashMap.put("fileLength", Long.valueOf(j2));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ossUrl", str3);
        hashMap2.put("errorCode", str4);
        hashMap2.put("errorMsg", str5);
        a(TrackLog.createOssUploadFileEndLog(h.a((Object) hashMap), h.a((Object) hashMap2), j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(TrackLog trackLog) {
        g unused = g.a.a;
        g.a(this.b, trackLog);
    }
}
