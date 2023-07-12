package com.taobao.weex.common;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class WXModule implements IWXObject {
    public static final String ACTION_ACTIVITY_RESULT = "actionActivityResult";
    public static final String ACTION_REQUEST_PERMISSIONS_RESULT = "actionRequestPermissionsResult";
    public static final String GRANT_RESULTS = "grantResults";
    public static final String PERMISSIONS = "permissions";
    public static final String REQUEST_CODE = "requestCode";
    public static final String RESULT_CODE = "resultCode";
    private Map<String, List<String>> mEvents = new HashMap();
    private Map<String, Boolean> mKeepAlives = new HashMap();
    private String mModuleName;
    public WXSDKInstance mWXSDKInstance;

    @JSMethod
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z = false;
        if (map != null && map.size() > 0 && map.containsKey(BQCCameraParam.FOCUS_ONCE) && WXUtils.getBoolean(map.get(BQCCameraParam.FOCUS_ONCE), Boolean.FALSE).booleanValue()) {
            z = true;
        }
        this.mKeepAlives.put(str2, Boolean.valueOf(z));
        if (this.mEvents.get(str) == null) {
            this.mEvents.put(str, new ArrayList());
        }
        this.mEvents.get(str).add(str2);
    }

    protected final WXComponent findComponent(String str) {
        if (this.mWXSDKInstance == null || str == null) {
            return null;
        }
        return WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
    }

    public List<String> getEventCallbacks(String str) {
        return this.mEvents.get(str);
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public boolean isOnce(String str) {
        return this.mKeepAlives.get(str).booleanValue();
    }

    public boolean onActivityBack() {
        return false;
    }

    public void onActivityCreate() {
    }

    public void onActivityDestroy() {
    }

    public void onActivityPause() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onActivityResume() {
    }

    public void onActivityStart() {
    }

    public void onActivityStop() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @JSMethod
    public void removeAllEventListeners(String str) {
        if (this.mEvents.containsKey(str)) {
            for (String str2 : this.mEvents.remove(str)) {
                this.mKeepAlives.remove(str2);
            }
        }
    }

    public void setModuleName(String str) {
        this.mModuleName = str;
    }
}
