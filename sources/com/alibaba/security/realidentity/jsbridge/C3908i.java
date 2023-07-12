package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.business.C3857a;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = C3908i.as)
/* renamed from: com.alibaba.security.realidentity.jsbridge.i */
/* loaded from: classes8.dex */
public class C3908i extends AbstractC3893a {
    private static final String as = "liveness";

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return as;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        if (TextUtils.isEmpty(str)) {
            AbstractC3893a.a(abstractC3907h, AbstractC3893a.ag);
            AbstractC3893a.b("LivenessApi parse params is null");
            return true;
        }
        final RPBusinessHeadParams rPBusinessHeadParams = (RPBusinessHeadParams) C3811h.a(str, RPBusinessHeadParams.class, false);
        if (rPBusinessHeadParams == null) {
            AbstractC3893a.a(abstractC3907h, AbstractC3893a.ag);
            AbstractC3893a.b("LivenessApi parse params is invalid");
            return true;
        }
        RPBusinessHeadParams.IdentityInfoBean identityInfoBean = rPBusinessHeadParams.identityInfo;
        if (identityInfoBean != null) {
            rPBusinessHeadParams.userName = identityInfoBean.name;
        }
        final String str2 = rPBusinessHeadParams.verifyToken;
        C3847g.C3848a.a.d = str2;
        C3847g.C3848a.a.a(TrackLog.createSimpleSdk(as, as, str));
        RPConfig b = C3847g.C3848a.a.b();
        if (b != null && b.getBiometricsConfig() != null) {
            ALBiometricsConfig biometricsConfig = b.getBiometricsConfig();
            if (biometricsConfig.isNeedFailResultPage()) {
                RPConfig.Builder builder = new RPConfig.Builder();
                builder.setNeedFailResultPage(false);
                builder.setTransitionMode(biometricsConfig.getTransitionMode());
                builder.setNeedSound(biometricsConfig.isNeedSound());
                C3847g.C3848a.a.g = builder.build();
            }
        }
        if (TextUtils.isEmpty(rPBusinessHeadParams.fromSource)) {
            C3847g c3847g = C3847g.C3848a.a;
            C3847g.a(c3847g.c, str2, c3847g.h, new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    C3908i.this.a(str2, abstractC3907h, rPBusinessHeadParams);
                }
            }, c3847g.i);
        } else {
            a(str2, abstractC3907h, rPBusinessHeadParams);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final AbstractC3907h abstractC3907h, RPBusinessHeadParams rPBusinessHeadParams) {
        C3857a c3857a = new C3857a(this.ao, str, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.i.2
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, RPDetail rPDetail) {
                JSONObject jSONObject = new JSONObject();
                try {
                    WVResult wVResult = new WVResult();
                    jSONObject.put("code", rPDetail.getCode());
                    jSONObject.put("message", rPDetail.getMsg());
                    jSONObject.put(AbstractC3893a.o, GlobalErrorCode.mappingResultCode(Integer.parseInt(rPDetail.getCode())));
                    if ("-1".equals(rPDetail.getCode())) {
                        LastExitTrackMsg lastExitTrackMsg = C3829a.C3830a.a.a;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("page", lastExitTrackMsg.getPage());
                        jSONObject2.put("view", lastExitTrackMsg.getView());
                        jSONObject2.put("params", lastExitTrackMsg.getParams());
                        jSONObject.put(AbstractC3893a.af, jSONObject2);
                    }
                    wVResult.setData(jSONObject);
                    AbstractC3893a.ap = rPDetail.getFaceImage();
                    abstractC3907h.b(wVResult);
                    C3908i c3908i = C3908i.this;
                    c3908i.a("code: " + rPDetail.getCode() + " msg: " + rPDetail.getMsg());
                    C3847g unused = C3847g.C3848a.a;
                    C3829a.C3830a.a.a(false);
                } catch (Exception e) {
                    if (C3800a.a()) {
                        C3800a.c(C3908i.as, "LivenessApi start liveness error");
                    }
                    AbstractC3893a.a(abstractC3907h, "LivenessApi start liveness error");
                    AbstractC3893a.a("LivenessApi start liveness error", e);
                }
            }
        }, true);
        rPBusinessHeadParams.setScConfig(C3847g.C3848a.a.n);
        c3857a.a(rPBusinessHeadParams);
    }
}
