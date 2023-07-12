package com.alipay.camera.compatible;

import android.hardware.Camera;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.camera.compatible.mi.MiCompatibleSupplements;
import com.alipay.camera.compatible.oppo.OppoCompatibleSupplements;
import com.alipay.camera.compatible.vivo.VivoCompatibleSupplements;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CompatibleManager {
    public static final String TAG = "CompatibleManager";
    private static boolean a;
    private static boolean b;
    public static boolean sOpenZsl;

    public static void enableOptimizeParameters(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void enableSetZSLValue(boolean z) {
        a = z;
    }

    public static void optimizeParameters(Camera.Parameters parameters) {
        if (!b || parameters == null) {
            return;
        }
        new DefaultCompatibleSupplements(parameters).optimizeParameters();
    }

    public static void setZslValue(Camera.Parameters parameters, boolean z) {
        if (!a) {
            sOpenZsl = false;
            return;
        }
        String manufacturer = Build.getMANUFACTURER();
        BaseCompatibleSupplements defaultCompatibleSupplements = new DefaultCompatibleSupplements(parameters);
        if (TextUtils.equals(manufacturer, "Xiaomi")) {
            defaultCompatibleSupplements = new MiCompatibleSupplements(parameters);
        } else if (TextUtils.equals(manufacturer, "vivo")) {
            defaultCompatibleSupplements = new VivoCompatibleSupplements(parameters);
        } else if (TextUtils.equals(manufacturer, "OPPO")) {
            defaultCompatibleSupplements = new OppoCompatibleSupplements(parameters);
        }
        defaultCompatibleSupplements.adjustZsl(z);
        sOpenZsl = defaultCompatibleSupplements.getWhetherOpenZsl();
    }
}
