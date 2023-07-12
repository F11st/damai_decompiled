package com.alibaba.security.realidentity.upload.a;

import android.content.Context;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.upload.b.InterfaceC3920a;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.upload.a.a */
/* loaded from: classes8.dex */
public abstract class AbstractC3917a implements InterfaceC3920a {
    protected Context a;
    public String b = C3847g.C3848a.a.d;

    public AbstractC3917a(Context context) {
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
        a(TrackLog.createOssUploadFileBeginLog(C3811h.a((Object) hashMap)));
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
        a(TrackLog.createOssUploadFileEndLog(C3811h.a((Object) hashMap), C3811h.a((Object) hashMap2), j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(TrackLog trackLog) {
        C3847g unused = C3847g.C3848a.a;
        C3847g.a(this.b, trackLog);
    }
}
