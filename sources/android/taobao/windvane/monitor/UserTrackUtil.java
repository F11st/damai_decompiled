package android.taobao.windvane.monitor;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.taobao.statistic.TBS;
import java.lang.reflect.Method;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UserTrackUtil {
    public static final int EVENTID_DEV_STORAGE = 15307;
    public static final int EVENTID_ERROR = 15306;
    public static final int EVENTID_MONITOR = 15301;
    public static final int EVENTID_PA_APPS = 15305;
    public static final int EVENTID_PA_SAPP = 15303;
    public static final int EVENTID_PA_UCSDK = 15309;
    public static boolean OFF = false;
    private static final String TAG = "UserTrackUtil";
    private static boolean isInit;
    private static Method utCommitEvent;
    private static Method utCommitEventWithArgs;
    private static Method utCommitPage;

    public static void commitEvent(int i, String str, String str2, String str3) {
        if (utCommitEvent == null || WVCommonConfig.commonConfig.monitorStatus == 0) {
            return;
        }
        try {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "commitEvent: " + i + jn1.OR + str + jn1.OR + str2 + jn1.OR + str3);
            }
            utCommitEvent.invoke(null, Integer.valueOf(i), str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        if (isInit) {
            return;
        }
        try {
            int i = TBS.Ext.a;
            Class cls = Integer.TYPE;
            utCommitEvent = TBS.Ext.class.getDeclaredMethod("commitEvent", cls, Object.class, Object.class, Object.class);
            utCommitPage = TBS.Ext.class.getDeclaredMethod("commitEvent", String.class, cls, Object.class, Object.class, Object.class, String[].class);
            utCommitEventWithArgs = TBS.Ext.class.getDeclaredMethod("commitEvent", cls, Object.class, Object.class, Object.class, String[].class);
            isInit = true;
        } catch (ClassNotFoundException unused) {
            TaoLog.d(TAG, "UT class not found");
        } catch (NoSuchMethodException unused2) {
            TaoLog.d(TAG, "UT method not found");
        }
    }

    public static String toArgString(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(map.size() * 28);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                sb.append(key);
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(",");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void commitEvent(String str, int i, String str2, String str3, String str4, String str5) {
        if (utCommitPage == null || WVCommonConfig.commonConfig.monitorStatus == 0) {
            return;
        }
        try {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "commitEvent: " + str + jn1.OR + i + jn1.OR + str2 + jn1.OR + str3 + jn1.OR + str4 + ((Object) TextUtils.concat(str5)));
            }
            utCommitPage.invoke(null, str, Integer.valueOf(i), str2, str3, str4, new String[]{str5});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commitEvent(int i, String str, String str2, String str3, String[] strArr) {
        if (utCommitEventWithArgs == null || WVCommonConfig.commonConfig.monitorStatus == 0) {
            return;
        }
        try {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "commitEvent: " + i + jn1.OR + str + jn1.OR + str2 + jn1.OR + str3 + ((Object) TextUtils.concat(strArr)));
            }
            utCommitEventWithArgs.invoke(null, Integer.valueOf(i), str, str2, str3, strArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
