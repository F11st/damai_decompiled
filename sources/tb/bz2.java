package tb;

import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bz2 {
    public static final String DAYDREAM_SETUP_COMPLETED = "daydream_setup";
    public static final String DEVICE_PARAMS_SETTING = "device_params";
    public static final String PHONE_PARAMS_SETTING = "phone_params";
    public static final String PROVIDER_INTENT_ACTION = "android.content.action.VR_SETTINGS_PROVIDER";
    public static final String QUERY_PARAMETER_KEY = "key";
    public static final String SDK_CONFIGURATION_PARAMS_SETTING = "sdk_configuration_params";
    public static final String SETTING_VALUE_KEY = "value";
    public static final String USER_PREFS_SETTING = "user_prefs";
    public static final String VRCORE_AUTHORITY = "com.google.vr.vrcore.settings";

    public static Uri a(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).path(str2).build();
    }
}
