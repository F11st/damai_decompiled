package com.taobao.orange;

import android.content.Context;
import com.taobao.orange.OConstant;
import com.taobao.orange.impl.HurlNetConnection;
import com.taobao.orange.impl.TBNetConnection;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.OLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GlobalOrange {
    static final String TAG = "GlobalOrange";
    public static String ackHost = null;
    public static Set<String> ackVips = null;
    public static String appKey = null;
    public static String appSecret = null;
    public static String appVersion = null;
    public static String authCode = null;
    public static Context context = null;
    public static String dcHost = null;
    public static Set<String> dcVips = null;
    public static String deviceId = null;
    public static volatile int downgrade = 0;
    public static OConstant.ENV env = null;
    static volatile boolean fallbackAvoid = false;
    public static AtomicInteger indexContinueFailsNum = null;
    public static volatile int indexDiff = 0;
    public static volatile boolean indexEnvCheck = false;
    public static volatile String indexResponseHeader = null;
    public static volatile OConstant.UPDMODE indexUpdMode = null;
    public static volatile boolean isChannelProcess = false;
    public static volatile boolean isMainProcess = true;
    public static volatile boolean isMainProcessAlive;
    public static volatile boolean isTaobaoPackage;
    public static Class<? extends INetConnection> netConnection;
    public static volatile Set<String> probeHosts;
    public static volatile boolean processIsolated;
    public static volatile boolean processQuery;
    public static volatile String processQueryForbidTime;
    public static volatile String processQueryStrategy;
    public static volatile long randomDelayAckInterval;
    public static volatile boolean reportUpdateAck;
    public static volatile String reqOrangeHeader;
    public static volatile String reqOrangeHeaderDiff;
    public static volatile int reqRetryNum;
    public static volatile long reqTimestampOffset;
    public static volatile String schema;
    public static boolean statUsedConfig;
    public static String userId;

    static {
        try {
            int i = k60.a;
            netConnection = TBNetConnection.class;
        } catch (ClassNotFoundException unused) {
            netConnection = HurlNetConnection.class;
            OLog.w(TAG, "init not found networksdk", new Object[0]);
        }
        appKey = "";
        appSecret = "";
        appVersion = "";
        deviceId = "";
        userId = "";
        authCode = "";
        schema = "https";
        reqRetryNum = 3;
        reportUpdateAck = false;
        statUsedConfig = false;
        randomDelayAckInterval = 10L;
        probeHosts = Collections.synchronizedSet(new HashSet());
        indexUpdMode = OConstant.UPDMODE.O_XMD;
        downgrade = 0;
        fallbackAvoid = false;
        indexDiff = 0;
        indexResponseHeader = "";
        processIsolated = false;
        processQuery = false;
        processQueryForbidTime = "";
        processQueryStrategy = "1200#3600#5";
        indexEnvCheck = false;
        env = OConstant.ENV.ONLINE;
        dcVips = Collections.synchronizedSet(new HashSet());
        ackVips = Collections.synchronizedSet(new HashSet());
        indexContinueFailsNum = new AtomicInteger(0);
        reqTimestampOffset = 0L;
    }
}
