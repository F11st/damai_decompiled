package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.common.c.C3800a;
import com.uploader.export.C7361a;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "cancelUpload")
/* renamed from: com.alibaba.security.realidentity.jsbridge.b */
/* loaded from: classes8.dex */
public class C3900b extends AbstractC3893a {
    private static final String as = "CancelUploadJSApi";
    private static final String at = "cancelSuccess";
    private static final String au = "cancelFailure";
    private static final String av = "";

    private void c(String str) {
        WVResult wVResult = new WVResult();
        IUploaderTask iUploaderTask = (IUploaderTask) C3912m.a().a(str);
        if (iUploaderTask != null) {
            C7361a.a().cancelAsync(iUploaderTask);
            this.an.b(wVResult);
            wVResult.addData(AbstractC3893a.r, str);
            wVResult.addData("errorMsg", at);
            wVResult.setSuccess();
            C3912m.a().b(str);
            a(wVResult, true);
            return;
        }
        wVResult.addData(AbstractC3893a.r, str);
        wVResult.addData("errorMsg", au);
        this.an.a(wVResult);
        a(wVResult, false);
    }

    private void d() {
        WVResult wVResult = new WVResult();
        IUploaderManager a = C7361a.a();
        for (Map.Entry<String, Object> entry : C3912m.a().b()) {
            a.cancelAsync((IUploaderTask) entry.getValue());
        }
        C3912m a2 = C3912m.a();
        synchronized (a2.a) {
            a2.a.clear();
        }
        wVResult.setSuccess();
        wVResult.addData("errorMsg", at);
        this.an.b(wVResult);
        a(wVResult, true);
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return "cancelUpload";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has(AbstractC3893a.r) ? jSONObject.getString(AbstractC3893a.r) : null;
            if (TextUtils.isEmpty(string)) {
                AbstractC3893a.a(abstractC3907h);
                return false;
            }
            if ("".equals(string)) {
                d();
            } else {
                WVResult wVResult = new WVResult();
                IUploaderTask iUploaderTask = (IUploaderTask) C3912m.a().a(string);
                if (iUploaderTask != null) {
                    C7361a.a().cancelAsync(iUploaderTask);
                    this.an.b(wVResult);
                    wVResult.addData(AbstractC3893a.r, string);
                    wVResult.addData("errorMsg", at);
                    wVResult.setSuccess();
                    C3912m.a().b(string);
                    a(wVResult, true);
                } else {
                    wVResult.addData(AbstractC3893a.r, string);
                    wVResult.addData("errorMsg", au);
                    this.an.a(wVResult);
                    a(wVResult, false);
                }
            }
            return true;
        } catch (JSONException e) {
            if (C3800a.a()) {
                C3800a.c(as, "CancelUploadApi params error");
            }
            AbstractC3893a.a("CancelUploadApi params error", e);
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }
}
