package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.sensor.C3790a;
import com.alibaba.security.biometrics.sensor.api.InterfaceC3795a;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.component.b */
/* loaded from: classes8.dex */
public class C3769b extends AbstractC3768a {
    private static final String d = "b";
    private InterfaceC3795a e;
    private String f;

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        C3800a.a(d, "Data collect initialized");
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        if (activity != null) {
            this.f = activity.getClass().getSimpleName();
        }
        this.e = new C3790a(activity);
        HashMap<String, String> hashMap = new HashMap<>();
        if (aLBiometricsParams != null) {
            hashMap.put(C3790a.a, String.valueOf(aLBiometricsParams.needCollect));
            hashMap.put(C3790a.b, aLBiometricsParams.enabledSensors);
            hashMap.put(C3790a.c, String.valueOf(aLBiometricsParams.collectInterval));
            hashMap.put(C3790a.d, String.valueOf(aLBiometricsParams.maxClickCount));
            hashMap.put(C3790a.e, String.valueOf(aLBiometricsParams.maxSensorCount));
        }
        try {
            this.e.a(hashMap);
            return false;
        } catch (RpSecException e) {
            C3800a.b();
            a("Data Collect init failed: " + e.getErrorCode() + "::" + e.getMessage());
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean b() {
        e();
        return super.b();
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean c() {
        return super.c();
    }

    public final void d() {
        C3800a.a(d, "<SENSOR_TEST_LOG> SensorData collect started >>> 1");
        InterfaceC3795a interfaceC3795a = this.e;
        if (interfaceC3795a == null) {
            return;
        }
        try {
            interfaceC3795a.a(1);
            a(true);
        } catch (RpSecException e) {
            C3800a.b();
            a("Data Collect start failed: " + e.getErrorCode() + "::" + e.getMessage());
        }
    }

    public final void e() {
        C3800a.a(d, "<SENSOR_TEST_LOG> SensorData collect stopped >>> 5");
        InterfaceC3795a interfaceC3795a = this.e;
        if (interfaceC3795a == null) {
            return;
        }
        try {
            interfaceC3795a.a(3);
            a(false);
        } catch (RpSecException e) {
            C3800a.b();
            a("Data Collect stop failed: " + e.getErrorCode() + "::" + e.getMessage());
        }
    }

    public final String f() {
        C3800a.a(d, "<SENSOR_TEST_LOG> SensorData upload >>> 4");
        InterfaceC3795a interfaceC3795a = this.e;
        if (interfaceC3795a == null) {
            return null;
        }
        try {
            return (String) interfaceC3795a.a(2).get("data");
        } catch (RpSecException e) {
            C3800a.b();
            a("Data Collect failed: " + e.getErrorCode() + "::" + e.getMessage());
            return null;
        }
    }

    public final void g() {
        InterfaceC3795a interfaceC3795a = this.e;
        if (interfaceC3795a == null) {
            return;
        }
        try {
            interfaceC3795a.a(4);
        } catch (RpSecException e) {
            C3800a.b();
            a("Data Collect reset failed: " + e.getErrorCode() + "::" + e.getMessage());
        }
    }

    private static HashMap<String, String> a(ALBiometricsParams aLBiometricsParams) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aLBiometricsParams == null) {
            return hashMap;
        }
        hashMap.put(C3790a.a, String.valueOf(aLBiometricsParams.needCollect));
        hashMap.put(C3790a.b, aLBiometricsParams.enabledSensors);
        hashMap.put(C3790a.c, String.valueOf(aLBiometricsParams.collectInterval));
        hashMap.put(C3790a.d, String.valueOf(aLBiometricsParams.maxClickCount));
        hashMap.put(C3790a.e, String.valueOf(aLBiometricsParams.maxSensorCount));
        return hashMap;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        super.a(aLBiometricsActivityParentView);
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a() {
        d();
        return super.a();
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(int i, KeyEvent keyEvent) {
        return super.a(i, keyEvent);
    }

    private void a(String str) {
        TrackLog createDataCollectionExceptionLog = TrackLog.createDataCollectionExceptionLog(str);
        ALBiometricsParams aLBiometricsParams = this.b;
        if (aLBiometricsParams != null) {
            createDataCollectionExceptionLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        createDataCollectionExceptionLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createDataCollectionExceptionLog.addTag10("Android");
        C3829a.C3830a.a.a(createDataCollectionExceptionLog);
        C3829a.C3830a.a.a(false);
    }

    private void a(boolean z) {
        TrackLog createCollectSensorEndLog;
        if (z) {
            createCollectSensorEndLog = TrackLog.createCollectSensorStartLog(this.f);
        } else {
            createCollectSensorEndLog = TrackLog.createCollectSensorEndLog(this.f);
        }
        ALBiometricsParams aLBiometricsParams = this.b;
        if (aLBiometricsParams != null) {
            createCollectSensorEndLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        createCollectSensorEndLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createCollectSensorEndLog.addTag10("Android");
        C3829a.C3830a.a.a(createCollectSensorEndLog);
        C3829a.C3830a.a.a(false);
    }
}
