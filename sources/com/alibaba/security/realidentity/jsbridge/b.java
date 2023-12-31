package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "cancelUpload")
/* loaded from: classes8.dex */
public class b extends a {
    private static final String as = "CancelUploadJSApi";
    private static final String at = "cancelSuccess";
    private static final String au = "cancelFailure";
    private static final String av = "";

    private void c(String str) {
        WVResult wVResult = new WVResult();
        IUploaderTask iUploaderTask = (IUploaderTask) m.a().a(str);
        if (iUploaderTask != null) {
            com.uploader.export.a.a().cancelAsync(iUploaderTask);
            this.an.b(wVResult);
            wVResult.addData(a.r, str);
            wVResult.addData("errorMsg", at);
            wVResult.setSuccess();
            m.a().b(str);
            a(wVResult, true);
            return;
        }
        wVResult.addData(a.r, str);
        wVResult.addData("errorMsg", au);
        this.an.a(wVResult);
        a(wVResult, false);
    }

    private void d() {
        WVResult wVResult = new WVResult();
        IUploaderManager a = com.uploader.export.a.a();
        for (Map.Entry<String, Object> entry : m.a().b()) {
            a.cancelAsync((IUploaderTask) entry.getValue());
        }
        m a2 = m.a();
        synchronized (a2.a) {
            a2.a.clear();
        }
        wVResult.setSuccess();
        wVResult.addData("errorMsg", at);
        this.an.b(wVResult);
        a(wVResult, true);
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return "cancelUpload";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has(a.r) ? jSONObject.getString(a.r) : null;
            if (TextUtils.isEmpty(string)) {
                a.a(hVar);
                return false;
            }
            if ("".equals(string)) {
                d();
            } else {
                WVResult wVResult = new WVResult();
                IUploaderTask iUploaderTask = (IUploaderTask) m.a().a(string);
                if (iUploaderTask != null) {
                    com.uploader.export.a.a().cancelAsync(iUploaderTask);
                    this.an.b(wVResult);
                    wVResult.addData(a.r, string);
                    wVResult.addData("errorMsg", at);
                    wVResult.setSuccess();
                    m.a().b(string);
                    a(wVResult, true);
                } else {
                    wVResult.addData(a.r, string);
                    wVResult.addData("errorMsg", au);
                    this.an.a(wVResult);
                    a(wVResult, false);
                }
            }
            return true;
        } catch (JSONException e) {
            if (com.alibaba.security.common.c.a.a()) {
                com.alibaba.security.common.c.a.c(as, "CancelUploadApi params error");
            }
            a.a("CancelUploadApi params error", e);
            a.a(hVar);
            return false;
        }
    }
}
