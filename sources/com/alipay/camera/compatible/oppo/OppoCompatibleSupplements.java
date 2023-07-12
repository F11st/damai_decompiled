package com.alipay.camera.compatible.oppo;

import android.hardware.Camera;
import android.os.Build;
import com.alipay.camera.compatible.BaseCompatibleSupplements;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class OppoCompatibleSupplements extends BaseCompatibleSupplements {
    public static final String TAG = "OppoCompatibleSupplements";

    public OppoCompatibleSupplements(Camera.Parameters parameters) {
        super(parameters);
        MPaasLogger.d(TAG, new Object[]{"adjustContrast: hardware=", Build.HARDWARE});
    }
}
