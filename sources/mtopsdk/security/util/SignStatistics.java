package mtopsdk.security.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.stat.IUploadStats;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SignStatistics {
    private static final String SIGN_EXCEPTION_MONITOR_POINT = "signException";
    private static final String SIGN_STATS_MODULE = "mtopsdk";
    private static final String TAG = "mtopsdk.SignStatistics";
    private static volatile IUploadStats mUploadStats;
    private static volatile AtomicBoolean registerFlag = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface SignStatsType {
        public static final String TYPE_AVMP_INSTANCE = "AVMPInstance";
        public static final String TYPE_GET_APPKEY = "GetAppKey";
        public static final String TYPE_GET_SECBODY = "GetSecBody";
        public static final String TYPE_INIT_UMID = "InitUMID";
        public static final String TYPE_INVOKE_AVMP = "InvokeAVMP";
        public static final String TYPE_SG_MANAGER = "SGManager";
        public static final String TYPE_SIGN_HMAC_SHA1 = "SignHMACSHA1";
        public static final String TYPE_SIGN_MTOP_REQUEST = "SignMtopRequest";

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    public static void commitStats(String str, String str2, String str3) {
        if (mUploadStats == null) {
            return;
        }
        if (registerFlag.compareAndSet(false, true)) {
            registerStats();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("errorcode", str2);
        hashMap.put(AgooConstants.MESSAGE_FLAG, str3);
        if (mUploadStats != null) {
            mUploadStats.onCommit(SIGN_STATS_MODULE, SIGN_EXCEPTION_MONITOR_POINT, hashMap, null);
        }
    }

    private static void registerStats() {
        HashSet hashSet = new HashSet();
        hashSet.add("type");
        hashSet.add("errorcode");
        hashSet.add(AgooConstants.MESSAGE_FLAG);
        if (mUploadStats != null) {
            mUploadStats.onRegister(SIGN_STATS_MODULE, SIGN_EXCEPTION_MONITOR_POINT, hashSet, null, false);
        }
    }

    public static void setIUploadStats(IUploadStats iUploadStats) {
        mUploadStats = iUploadStats;
        TBSdkLog.i(TAG, "set IUploadStats =" + iUploadStats);
    }
}
