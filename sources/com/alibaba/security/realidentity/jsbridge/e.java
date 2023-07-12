package com.alibaba.security.realidentity.jsbridge;

import android.os.Message;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = a.I)
/* loaded from: classes8.dex */
public class e extends a {
    private static final int as = 10;

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return a.I;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        JSONObject jSONObject;
        com.alibaba.security.common.c.a.b("AbsJavaScriptExecuter", "GetDeviceInfoApi input params: ".concat(String.valueOf(str)));
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("errorMsg", "NO_INFO");
            hVar.a(wVResult);
            return false;
        }
        final String optString = jSONObject.optString(a.d, "");
        if (!TextUtils.isEmpty(optString)) {
            g.a.a.d = optString;
        }
        a.aq.execute(new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.e.1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject2;
                String a = com.alibaba.security.common.d.a.a(ALBiometricsJni.genVersionTag(e.this.ao, optString));
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientType(a.ai);
                clientInfo.setVersionTag(a);
                try {
                    jSONObject2 = new JSONObject(com.alibaba.security.common.d.h.a(clientInfo));
                } catch (JSONException e) {
                    if (com.alibaba.security.common.c.a.a()) {
                        com.alibaba.security.common.c.a.c("AbsJavaScriptExecuter", "GetDeviceInfoApi json assemble error");
                    }
                    a.a("GetDeviceInfoApi json assemble error", com.alibaba.security.common.d.b.a(e));
                    jSONObject2 = null;
                }
                Message obtain = Message.obtain();
                obtain.what = 10;
                obtain.obj = jSONObject2;
                e.this.a(obtain);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final void b(Message message) {
        super.b(message);
        if (message.what == 10) {
            JSONObject jSONObject = (JSONObject) message.obj;
            WVResult wVResult = new WVResult();
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                wVResult.setSuccess();
                wVResult.addData(a.f, jSONObject);
                this.an.b(wVResult);
                return;
            }
            wVResult.addData("errorMsg", "NO_INFO");
            this.an.a(wVResult);
        }
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final boolean b() {
        return true;
    }

    private void a(JSONObject jSONObject) {
        WVResult wVResult = new WVResult();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            wVResult.setSuccess();
            wVResult.addData(a.f, jSONObject);
            this.an.b(wVResult);
            return;
        }
        wVResult.addData("errorMsg", "NO_INFO");
        this.an.a(wVResult);
    }
}
