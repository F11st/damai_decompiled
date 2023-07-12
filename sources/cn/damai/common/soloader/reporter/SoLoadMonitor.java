package cn.damai.common.soloader.reporter;

import android.text.TextUtils;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class SoLoadMonitor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PLAYER_PLAY_FAILED = "player_play_failed";
    public static final String PLAYER_PLAY_SUCCESS = "player_play_success";
    public static final String PLAYER_RETRY = "player_retry";
    public static final String PLAYER_RETRY_FAILED = "player_retry_failed";
    public static final String PLAYER_RETRY_SUCCESS = "player_retry_success";
    public static final String PLAYER_START = "player_start";
    public static final String SOLOAD_CHECK_FAILED = "soload_check_failed";
    public static final String SOLOAD_CHECK_SUCCESS = "soload_check_success";
    public static final String SOLOAD_DOWNLOAD_FAILED = "soload_download_failed";
    public static final String SOLOAD_DOWNLOAD_SUCCESS = "soload_download_success";
    public static final String SOLOAD_INJECTTION_FAILED = "soload_injection_failed";
    public static final String SOLOAD_INJECTTION_SUCCESS = "soload_injection_success";
    public static final String SOLOAD_LOADLIBRARY_FAILED = "soload_loadlibrary_failed";
    public static final String SOLOAD_LOADLIBRARY_SUCCESS = "soload_loadlibrary_success";

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum MonitorType {
        SOLOAD_CHECK_FAILED,
        SOLOAD_CHECK_SUCCESS,
        SOLOAD_DOWNLOAD_FAILED,
        SOLOAD_DOWNLOAD_SUCCESS,
        SOLOAD_INJECTTION_FAILED,
        SOLOAD_INJECTTION_SUCCESS,
        SOLOAD_LOADLIBRARY_FAILED,
        SOLOAD_LOADLIBRARY_SUCCESS,
        PLAYER_START,
        PLAYER_PLAY_SUCCESS,
        PLAYER_PLAY_FAILED,
        PLAYER_RETRY,
        PLAYER_RETRY_SUCCESS,
        PLAYER_RETRY_FAILED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MonitorType.values().length];
            a = iArr;
            try {
                iArr[MonitorType.SOLOAD_CHECK_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MonitorType.SOLOAD_CHECK_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MonitorType.SOLOAD_DOWNLOAD_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MonitorType.SOLOAD_DOWNLOAD_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MonitorType.SOLOAD_INJECTTION_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MonitorType.SOLOAD_INJECTTION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MonitorType.SOLOAD_LOADLIBRARY_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[MonitorType.SOLOAD_LOADLIBRARY_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[MonitorType.PLAYER_START.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[MonitorType.PLAYER_PLAY_SUCCESS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[MonitorType.PLAYER_PLAY_FAILED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[MonitorType.PLAYER_RETRY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[MonitorType.PLAYER_RETRY_SUCCESS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[MonitorType.PLAYER_RETRY_FAILED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static void a(MonitorType monitorType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1146708888")) {
            ipChange.ipc$dispatch("-1146708888", new Object[]{monitorType});
        } else {
            b(monitorType, "");
        }
    }

    public static void b(MonitorType monitorType, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102347314")) {
            ipChange.ipc$dispatch("1102347314", new Object[]{monitorType, str});
            return;
        }
        HashMap hashMap = new HashMap();
        switch (a.a[monitorType.ordinal()]) {
            case 1:
                str2 = SOLOAD_CHECK_SUCCESS;
                break;
            case 2:
                str2 = SOLOAD_CHECK_FAILED;
                break;
            case 3:
                str2 = SOLOAD_DOWNLOAD_SUCCESS;
                break;
            case 4:
                str2 = SOLOAD_DOWNLOAD_FAILED;
                break;
            case 5:
                str2 = SOLOAD_INJECTTION_SUCCESS;
                break;
            case 6:
                str2 = SOLOAD_INJECTTION_FAILED;
                break;
            case 7:
                str2 = SOLOAD_LOADLIBRARY_SUCCESS;
                break;
            case 8:
                str2 = SOLOAD_LOADLIBRARY_FAILED;
                break;
            case 9:
                str2 = PLAYER_START;
                break;
            case 10:
                str2 = PLAYER_PLAY_SUCCESS;
                break;
            case 11:
                str2 = PLAYER_PLAY_FAILED;
                break;
            case 12:
                str2 = PLAYER_RETRY;
                break;
            case 13:
                str2 = PLAYER_RETRY_SUCCESS;
                break;
            case 14:
                str2 = PLAYER_RETRY_FAILED;
                break;
            default:
                str2 = "";
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contentlabel", str);
        }
        hashMap.put("titlelabel", str2);
        c.e().A(hashMap, "SoLoad", "SoLoadDynamicsService");
    }
}
