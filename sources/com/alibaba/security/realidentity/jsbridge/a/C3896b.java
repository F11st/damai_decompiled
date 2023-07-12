package com.alibaba.security.realidentity.jsbridge.a;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3907h;
import com.alibaba.security.realidentity.jsbridge.InterfaceC3904f;

/* compiled from: Taobao */
@InterfaceC3904f(a = "rpGetSensor")
/* renamed from: com.alibaba.security.realidentity.jsbridge.a.b */
/* loaded from: classes8.dex */
public class C3896b extends AbstractC3893a {
    private static final String as = "b";

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final String a() {
        return "rpGetSensor";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() { // from class: com.alibaba.security.realidentity.jsbridge.a.b.1
            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f) {
                SensorInfo sensorInfo = new SensorInfo(f);
                WVResult wVResult = new WVResult();
                wVResult.addData(AbstractC3893a.ae, C3811h.a(sensorInfo));
                wVResult.setSuccess();
                abstractC3907h.b(wVResult);
                C3896b.this.a(wVResult, true);
            }
        });
        return true;
    }
}
