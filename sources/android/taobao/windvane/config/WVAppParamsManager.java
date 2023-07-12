package android.taobao.windvane.config;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVAppParamsManager {
    private static WVAppParamsManager Instance;
    private WVAppParams params;
    private boolean paramsSet;

    public static WVAppParamsManager getInstance() {
        if (Instance == null) {
            synchronized (WVAppParamsManager.class) {
                if (Instance == null) {
                    Instance = new WVAppParamsManager();
                }
            }
        }
        return Instance;
    }

    public WVAppParams getParams() {
        return this.params;
    }

    public boolean isParamsSet() {
        return this.paramsSet;
    }

    public void setParams(WVAppParams wVAppParams) {
        if (wVAppParams == null || TextUtils.isEmpty(wVAppParams.appKey) || TextUtils.isEmpty(wVAppParams.appVersion)) {
            return;
        }
        this.params = wVAppParams;
        this.paramsSet = true;
    }
}
