package com.alipay.camera.compatible.vivo;

import android.hardware.Camera;
import android.os.Build;
import com.alipay.camera.compatible.BaseCompatibleSupplements;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class VivoCompatibleSupplements extends BaseCompatibleSupplements {
    public static final String TAG = "VivoCompatibleSupplements";

    public VivoCompatibleSupplements(Camera.Parameters parameters) {
        super(parameters);
        MPaasLogger.d(TAG, new Object[]{"adjustContrast: hardware=", Build.HARDWARE});
    }
}
