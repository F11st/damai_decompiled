package android.taobao.windvane.config;

import android.taobao.windvane.config.WVConfigManager;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVUpdatingInfo {
    private WVConfigManager.WVConfigUpdateFromType fromType;
    private String version;

    WVUpdatingInfo(WVConfigManager.WVConfigUpdateFromType wVConfigUpdateFromType, String str) {
        this.fromType = wVConfigUpdateFromType;
        this.version = str;
    }

    public WVConfigManager.WVConfigUpdateFromType getFromType() {
        return this.fromType;
    }

    public String getVersion() {
        return this.version;
    }
}
