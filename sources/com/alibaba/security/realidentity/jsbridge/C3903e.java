package com.alibaba.security.realidentity.jsbridge;

import android.os.Message;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3801a;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = AbstractC3893a.I)
/* renamed from: com.alibaba.security.realidentity.jsbridge.e */
/* loaded from: classes8.dex */
public class C3903e extends AbstractC3893a {
    private static final int as = 10;

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return AbstractC3893a.I;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        JSONObject jSONObject;
        C3800a.b("AbsJavaScriptExecuter", "GetDeviceInfoApi input params: ".concat(String.valueOf(str)));
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("errorMsg", "NO_INFO");
            abstractC3907h.a(wVResult);
            return false;
        }
        final String optString = jSONObject.optString(AbstractC3893a.d, "");
        if (!TextUtils.isEmpty(optString)) {
            C3847g.C3848a.a.d = optString;
        }
        AbstractC3893a.aq.execute(new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.e.1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject2;
                String a = C3801a.a(ALBiometricsJni.genVersionTag(C3903e.this.ao, optString));
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientType(AbstractC3893a.ai);
                clientInfo.setVersionTag(a);
                try {
                    jSONObject2 = new JSONObject(C3811h.a(clientInfo));
                } catch (JSONException e) {
                    if (C3800a.a()) {
                        C3800a.c("AbsJavaScriptExecuter", "GetDeviceInfoApi json assemble error");
                    }
                    AbstractC3893a.a("GetDeviceInfoApi json assemble error", C3805b.a(e));
                    jSONObject2 = null;
                }
                Message obtain = Message.obtain();
                obtain.what = 10;
                obtain.obj = jSONObject2;
                C3903e.this.a(obtain);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final void b(Message message) {
        super.b(message);
        if (message.what == 10) {
            JSONObject jSONObject = (JSONObject) message.obj;
            WVResult wVResult = new WVResult();
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                wVResult.setSuccess();
                wVResult.addData(AbstractC3893a.f, jSONObject);
                this.an.b(wVResult);
                return;
            }
            wVResult.addData("errorMsg", "NO_INFO");
            this.an.a(wVResult);
        }
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final boolean b() {
        return true;
    }

    private void a(JSONObject jSONObject) {
        WVResult wVResult = new WVResult();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            wVResult.setSuccess();
            wVResult.addData(AbstractC3893a.f, jSONObject);
            this.an.b(wVResult);
            return;
        }
        wVResult.addData("errorMsg", "NO_INFO");
        this.an.a(wVResult);
    }
}
