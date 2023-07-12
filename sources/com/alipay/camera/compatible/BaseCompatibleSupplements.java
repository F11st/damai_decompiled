package com.alipay.camera.compatible;

import android.hardware.Camera;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.util.ScanDeviceProperty;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class BaseCompatibleSupplements {
    public static final String TAG = "BaseCompatibleSupplements";
    protected Camera.Parameters a;
    public boolean mOpenZsl;

    public BaseCompatibleSupplements(Camera.Parameters parameters) {
        this.a = parameters;
    }

    private BaseCompatibleSupplements a(boolean z) {
        String str = this.a.get("zsd-mode-values");
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        MPaasLogger.d(TAG, new Object[]{"adjustMtkZsd: zsd-values=", str});
        String c = c(z ? "on" : "off", str.split(","));
        String str2 = this.a.get("mtk-cam-mode");
        MPaasLogger.d(TAG, new Object[]{"adjustMtkZsd: mtk-cam-mode=", str2});
        if (c != null && str2 != null) {
            this.a.set("zsd-mode", c);
            this.a.set("mtk-cam-mode", 1);
            this.mOpenZsl = z;
        }
        return this;
    }

    private BaseCompatibleSupplements b(boolean z) {
        String str = this.a.get("zsl-values");
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        MPaasLogger.d(TAG, new Object[]{"adjustQcomZsl: zsl-values=", str});
        String c = c(z ? "on" : "off", str.split(","));
        if (c != null) {
            this.a.set("zsl", c);
            this.mOpenZsl = z;
        }
        return this;
    }

    private BaseCompatibleSupplements d() {
        String c;
        Camera.Parameters parameters = this.a;
        if (parameters == null) {
            return this;
        }
        try {
            String str = parameters.get("3dnr-mode-values");
            if (!TextUtils.isEmpty(str) && (c = c("off", str.split(","))) != null) {
                this.a.set("3dnr-mode", c);
            }
            return this;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"optimizeMTKParameters with e:"}, e);
            return this;
        }
    }

    public BaseCompatibleSupplements adjustZsl(boolean z) {
        if (this.a == null) {
            return this;
        }
        if (ScanDeviceProperty.isQCOMChip()) {
            return b(z);
        }
        return ScanDeviceProperty.isMTKChip() ? a(z) : this;
    }

    protected String c(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public boolean getWhetherOpenZsl() {
        return this.mOpenZsl;
    }

    public BaseCompatibleSupplements optimizeParameters() {
        return ScanDeviceProperty.isMTKChip() ? d() : this;
    }
}
