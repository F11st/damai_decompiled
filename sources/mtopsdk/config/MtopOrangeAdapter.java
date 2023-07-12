package mtopsdk.config;

import android.content.Context;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.orange.OrangeConfigLocal;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopOrangeAdapter {
    private static final String TAG = "mtopsdk.OrangeAdapter";
    private static boolean mOrangeValid = true;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class MtopOrangeListener implements OrangeConfigListenerV1 {
        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
        }
    }

    public static String getConfig(String str, String str2, String str3) {
        if (mOrangeValid) {
            return OrangeConfigLocal.getInstance().getConfig(str, str2, str3);
        }
        TBSdkLog.w(TAG, "[getConfig] getConfig error,no orange sdk");
        return str3;
    }

    public static Map<String, String> getConfigs(String str) {
        if (mOrangeValid) {
            return OrangeConfigLocal.getInstance().getConfigs(str);
        }
        TBSdkLog.w(TAG, "[getConfig] getConfigs by groupName error,no orange sdk");
        return null;
    }

    public static void init(Context context) {
        if (mOrangeValid) {
            OrangeConfigLocal.getInstance().init(context);
        } else {
            TBSdkLog.w(TAG, "[init] init orange error,no orange sdk");
        }
    }

    public static void registerListener(String[] strArr, MtopOrangeListener mtopOrangeListener) {
        if (mOrangeValid) {
            OrangeConfigLocal.getInstance().registerListener(strArr, mtopOrangeListener);
        } else {
            TBSdkLog.w(TAG, "[registerListener] registerListener error,no orange sdk");
        }
    }

    public static void unregisterListener(String[] strArr) {
        if (mOrangeValid) {
            OrangeConfigLocal.getInstance().unregisterListener(strArr);
        } else {
            TBSdkLog.w(TAG, "[unregisterListener] unregisterListener error,no orange sdk");
        }
    }
}
