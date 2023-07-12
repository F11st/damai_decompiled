package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hh1 {
    public static final String DIMEN_BIZ = "bizId";
    public static final String DIMEN_CODE = "errorCode";
    public static final String DIMEN_DIGEST = "digest";
    public static final String DIMEN_ETAG = "etag";
    public static final String DIMEN_MESSAGE = "errorMessage";
    public static final String DIMEN_POD_VERSION = "podVer";
    public static final String DIMEN_VERSION = "appSnapshotVersion";
    public static final String MODULE_NAME = "slide";
    public static final String POINT_CACHE = "slide_cache";
    public static final String POINT_ERROR = "slide_error";
    public static final String POINT_MATCH = "slide_match";
    public static final String POINT_MAXFAILS = "slide_fails";
    public static final String POINT_NOTIFY = "slide_notify";
    public static final String POINT_UPDATE = "slide_update";
    public static final String POINT_UTDID = "slide_utdid";
    private static boolean a = true;

    public static void a(String str, String str2) {
        if (a) {
            AppMonitor.Counter.commit(MODULE_NAME, str, str2, 1.0d);
        }
    }

    public static void b(String str, String str2, String str3, String str4) {
        if (a) {
            AppMonitor.Alarm.commitFail(MODULE_NAME, str, str2, str3, str4);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            AppMonitor.Alarm.commitSuccess(MODULE_NAME, str, str2);
        }
    }
}
