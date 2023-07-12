package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = i.as)
/* loaded from: classes8.dex */
public class i extends a {
    private static final String as = "liveness";

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return as;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        if (TextUtils.isEmpty(str)) {
            a.a(hVar, a.ag);
            a.b("LivenessApi parse params is null");
            return true;
        }
        final RPBusinessHeadParams rPBusinessHeadParams = (RPBusinessHeadParams) com.alibaba.security.common.d.h.a(str, RPBusinessHeadParams.class, false);
        if (rPBusinessHeadParams == null) {
            a.a(hVar, a.ag);
            a.b("LivenessApi parse params is invalid");
            return true;
        }
        RPBusinessHeadParams.IdentityInfoBean identityInfoBean = rPBusinessHeadParams.identityInfo;
        if (identityInfoBean != null) {
            rPBusinessHeadParams.userName = identityInfoBean.name;
        }
        final String str2 = rPBusinessHeadParams.verifyToken;
        g.a.a.d = str2;
        g.a.a.a(TrackLog.createSimpleSdk(as, as, str));
        RPConfig b = g.a.a.b();
        if (b != null && b.getBiometricsConfig() != null) {
            ALBiometricsConfig biometricsConfig = b.getBiometricsConfig();
            if (biometricsConfig.isNeedFailResultPage()) {
                RPConfig.Builder builder = new RPConfig.Builder();
                builder.setNeedFailResultPage(false);
                builder.setTransitionMode(biometricsConfig.getTransitionMode());
                builder.setNeedSound(biometricsConfig.isNeedSound());
                g.a.a.g = builder.build();
            }
        }
        if (TextUtils.isEmpty(rPBusinessHeadParams.fromSource)) {
            com.alibaba.security.realidentity.a.g gVar = g.a.a;
            com.alibaba.security.realidentity.a.g.a(gVar.c, str2, gVar.h, new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.a(str2, hVar, rPBusinessHeadParams);
                }
            }, gVar.i);
        } else {
            a(str2, hVar, rPBusinessHeadParams);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final h hVar, RPBusinessHeadParams rPBusinessHeadParams) {
        com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(this.ao, str, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.i.2
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, RPDetail rPDetail) {
                JSONObject jSONObject = new JSONObject();
                try {
                    WVResult wVResult = new WVResult();
                    jSONObject.put("code", rPDetail.getCode());
                    jSONObject.put("message", rPDetail.getMsg());
                    jSONObject.put(a.o, GlobalErrorCode.mappingResultCode(Integer.parseInt(rPDetail.getCode())));
                    if ("-1".equals(rPDetail.getCode())) {
                        LastExitTrackMsg lastExitTrackMsg = a.C0165a.a.a;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("page", lastExitTrackMsg.getPage());
                        jSONObject2.put("view", lastExitTrackMsg.getView());
                        jSONObject2.put("params", lastExitTrackMsg.getParams());
                        jSONObject.put(a.af, jSONObject2);
                    }
                    wVResult.setData(jSONObject);
                    a.ap = rPDetail.getFaceImage();
                    hVar.b(wVResult);
                    i iVar = i.this;
                    iVar.a("code: " + rPDetail.getCode() + " msg: " + rPDetail.getMsg());
                    com.alibaba.security.realidentity.a.g unused = g.a.a;
                    a.C0165a.a.a(false);
                } catch (Exception e) {
                    if (com.alibaba.security.common.c.a.a()) {
                        com.alibaba.security.common.c.a.c(i.as, "LivenessApi start liveness error");
                    }
                    a.a(hVar, "LivenessApi start liveness error");
                    a.a("LivenessApi start liveness error", e);
                }
            }
        }, true);
        rPBusinessHeadParams.setScConfig(g.a.a.n);
        aVar.a(rPBusinessHeadParams);
    }
}
