package com.alibaba.security.realidentity.jsbridge;

import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVResult;
import android.util.Pair;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3810g;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.a.C3847g;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "livenessEx")
/* renamed from: com.alibaba.security.realidentity.jsbridge.j */
/* loaded from: classes8.dex */
public class C3909j extends AbstractC3893a {
    private static final String as = "LivenessExJSApi";
    private static final int at = 2;
    private static final int au = 3;
    private static final int av = 6;
    private static final int aw = 10;
    private static final int ax = 11;
    private static final int ay = 159;
    private static final int az = 100;

    static /* synthetic */ String a(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 6) {
                    if (i != 10) {
                        if (i != 11) {
                            return null;
                        }
                        return "KeepStill";
                    }
                    return "RaiseHeadDown";
                }
                return "None";
            }
            return "ShakeHead";
        }
        return "OpenMouth";
    }

    private static String b(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 6) {
                    if (i != 10) {
                        if (i != 11) {
                            return null;
                        }
                        return "KeepStill";
                    }
                    return "RaiseHeadDown";
                }
                return "None";
            }
            return "ShakeHead";
        }
        return "OpenMouth";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return "livenessEx";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        int i;
        int i2;
        int i3;
        int i4;
        if (C3800a.a()) {
            C3800a.a(as, "LivenessExApi execute params: ".concat(String.valueOf(str)));
        }
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                i2 = jSONObject.getInt("poseDetectInterval");
            } catch (JSONException unused) {
                i2 = 0;
            }
            try {
                str2 = jSONObject.getString(ALBiometricsKeys.KEY_USERNAME);
            } catch (JSONException unused2) {
            }
            try {
                i3 = jSONObject.getInt("showTip");
            } catch (JSONException unused3) {
                i3 = 0;
            }
            try {
                i4 = jSONObject.getInt("needBase64Image");
            } catch (JSONException unused4) {
                i4 = 0;
            }
            try {
                i = jSONObject.getInt(ALBiometricsKeys.KEY_LESS_IMAGE_MODE);
            } catch (JSONException unused5) {
                i = 0;
            }
        } catch (JSONException unused6) {
            C3800a.b();
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        final Bundle bundle = new Bundle();
        bundle.putBoolean("STEP_NAV", false);
        bundle.putInt(ALBiometricsKeys.KEY_SENSORDATA_INTERVALS, i2);
        bundle.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
        bundle.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
        if (i == 1) {
            bundle.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
        }
        if (str2 != null) {
            bundle.putString(ALBiometricsKeys.KEY_USERNAME, str2);
        }
        bundle.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, i3 != 0);
        final int i5 = i4;
        new ALBiometricsNavigator(this.ao) { // from class: com.alibaba.security.realidentity.jsbridge.j.1
            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final ALBiometricsEventListener getEventListener() {
                return new ALBiometricsEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.j.1.1
                    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
                    public final String getAppKey() {
                        return null;
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBeforeRetry(OnRetryListener onRetryListener, String str3, String str4) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBiometricsFinish(int i6) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBiometricsStart() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBusinessOk() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onCancel(int i6, String str3, String str4) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onError(int i6, Bundle bundle2) {
                        WVResult wVResult = new WVResult();
                        C3800a.d(C3909j.as, "onError.r: ".concat(String.valueOf(i6)));
                        if (i6 == 159) {
                            i6 = 100;
                        }
                        wVResult.addData("errorMsg", String.valueOf(i6));
                        abstractC3907h.a(wVResult);
                        C3909j.this.a(wVResult, false);
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onFinish(int i6, boolean z) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onFrameResult(byte[] bArr, int i6, int i7) {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                    public final void onLogTrack(TrackLog trackLog) {
                        C3847g.C3848a.a.a(trackLog);
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                    public final void onOldLogRecord(Bundle bundle2) {
                        HashMap hashMap = new HashMap();
                        if (bundle2 != null) {
                            for (String str3 : bundle2.keySet()) {
                                hashMap.put(str3, bundle2.get(str3));
                            }
                            AbstractC3841b.a().a(hashMap);
                        }
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorReset() {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorStart() {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorStop() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onSuccess(ALBiometricsResult aLBiometricsResult) {
                        WVResult wVResult = new WVResult();
                        List<ABActionResult> as2 = aLBiometricsResult.getAs();
                        String k = aLBiometricsResult.getK();
                        String a = C3810g.a(C3909j.this.ao, k, aLBiometricsResult.getQi().getP());
                        Pair<String, String> putIdCardImage = RPWebViewMediaCacheManager.getInstance().putIdCardImage(C3909j.this.ao, a);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("imageId", putIdCardImage.first);
                            jSONObject2.put("imageUrl", putIdCardImage.second);
                            if (i5 > 0 && a != null) {
                                jSONObject2.put("base64Image", C3810g.a(C3810g.b(a)));
                            }
                        } catch (JSONException e) {
                            C3800a.d(C3909j.as, e.getLocalizedMessage());
                        }
                        wVResult.addData(AbstractC3840a.K, jSONObject2);
                        for (int i6 = 0; i6 < as2.size(); i6++) {
                            JSONObject jSONObject3 = new JSONObject();
                            String a2 = C3909j.a(as2.get(i6).getAt());
                            List<ABImageResult> is = as2.get(i6).getIs();
                            for (int i7 = 0; i7 < is.size(); i7++) {
                                String putIdCardImage2 = RPWebViewMediaCacheManager.getInstance().putIdCardImage(C3909j.this.ao, is.get(i7).getP(), k);
                                JSONObject jSONObject4 = new JSONObject();
                                try {
                                    jSONObject4.put("imageId", putIdCardImage2);
                                    jSONObject3.put("actionType", a2);
                                    jSONObject3.put("image_".concat(String.valueOf(i7)), jSONObject4);
                                } catch (JSONException unused7) {
                                    C3800a.b();
                                }
                            }
                            wVResult.addData("movement_".concat(String.valueOf(i6)), jSONObject3);
                        }
                        wVResult.setSuccess();
                        abstractC3907h.b(wVResult);
                        C3909j.this.a(new WVResult("success"), true);
                    }

                    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
                    public final String sign(String str3) {
                        return null;
                    }
                };
            }

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final Bundle getParams() {
                return bundle;
            }
        }.start(this.ao);
        return true;
    }
}
