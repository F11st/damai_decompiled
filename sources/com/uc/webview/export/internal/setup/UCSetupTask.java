package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.ValueCallback;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.Build;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.setup.aj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class UCSetupTask<RETURN_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>> extends BaseSetupTask<RETURN_TYPE, CALLBACK_TYPE> {
    private static UCMRunningInfo c;
    private static UCSetupTask e;
    private static UCAsyncTask f;
    private static int g;
    private UCMRunningInfo a;
    private UCMRepairInfo d;
    private String j;
    static final /* synthetic */ boolean b = true;
    protected static final List<UCSetupTask> sTotalSetupTasks = new ArrayList(2);
    private static boolean h = true;
    private static final AtomicBoolean i = new AtomicBoolean(false);

    public UCSetupTask() {
        List<UCSetupTask> list = sTotalSetupTasks;
        synchronized (list) {
            list.add(this);
        }
    }

    private void a(String str, Object obj, StringBuilder sb) {
        boolean z;
        boolean z2;
        Object option = getOption(str);
        str.hashCode();
        boolean z3 = false;
        boolean z4 = true;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -394759268:
                if (str.equals(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX)) {
                    c2 = 0;
                    break;
                }
                break;
            case 2082:
                if (str.equals(UCCore.OPTION_HARDWARE_ACCELERATED)) {
                    c2 = 1;
                    break;
                }
                break;
            case 269945140:
                if (str.equals(UCCore.OPTION_STARTUP_POLICY)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1029404637:
                if (str.equals(UCCore.OPTION_INIT_FAILED_LOG_POLICY)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1167815028:
                if (str.equals(UCCore.OPTION_APP_STARTUP_TIME)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1669844920:
                if (str.equals(UCCore.OPTION_VERIFY_POLICY)) {
                    c2 = 5;
                    break;
                }
                break;
            case 1934044806:
                if (str.equals(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED)) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (com.uc.webview.export.internal.utility.p.a((String) option) && obj != null) {
                    option = obj;
                    str = UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION;
                    z = false;
                    z2 = true;
                    break;
                } else {
                    str = UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION;
                    z = false;
                    z2 = false;
                    break;
                }
            case 1:
                Boolean bool = (Boolean) option;
                option = Integer.valueOf((bool == null || !bool.booleanValue()) ? 0 : 1);
                z = false;
                z2 = false;
                break;
            case 2:
                Integer b2 = com.uc.webview.export.internal.utility.e.b(str);
                if (b2 != null) {
                    sb.append("    use DynamicSetting ");
                    sb.append(str);
                    sb.append("=");
                    sb.append(b2);
                    sb.append(", preValue:");
                    sb.append(option);
                    sb.append(StringUtils.LF);
                    option = b2;
                }
            case 3:
            case 5:
                z = true;
                z3 = true;
                z2 = false;
                break;
            case 4:
                Long l = (Long) option;
                if (option != null) {
                    option = Long.valueOf(SystemClock.elapsedRealtime() - l.longValue());
                    str = UCCore.STARTUP_ELAPSE_BEETWEEN_UC_INIT_AND_APP;
                }
                z = false;
                z2 = false;
                break;
            case 6:
                Boolean bool2 = (Boolean) option;
                option = Integer.valueOf((bool2 == null || !bool2.booleanValue()) ? 0 : 1);
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z3 = true;
                z2 = false;
                break;
        }
        if (!z3 || obj == null || option != null) {
            obj = option;
            z4 = z2;
        }
        if (obj == null) {
            sb.append("    ");
            sb.append(str);
            sb.append("= [NoConfig]\n");
            return;
        }
        String str2 = null;
        if (z && (obj instanceof Integer)) {
            str2 = "0b" + Integer.toBinaryString(((Integer) obj).intValue());
        }
        sb.append("    ");
        sb.append(str);
        sb.append("=");
        if (str2 == null) {
            str2 = obj;
        }
        sb.append(str2);
        sb.append(z4 ? " [UseDefault]" : "");
        sb.append(StringUtils.LF);
        com.uc.webview.export.internal.utility.i.a().a(str, obj);
    }

    @Reflection
    public static Class<?> classForName(String str) throws ClassNotFoundException {
        UCMRunningInfo totalLoadedUCM = getTotalLoadedUCM();
        ClassLoader classLoader = totalLoadedUCM == null ? null : totalLoadedUCM.classLoader;
        if (classLoader == null) {
            return Class.forName(str);
        }
        return Class.forName(str, true, classLoader);
    }

    public static UCSetupTask getDefault() {
        return e;
    }

    public static synchronized UCAsyncTask getRoot() {
        UCAsyncTask uCAsyncTask;
        synchronized (UCSetupTask.class) {
            if (f == null) {
                f = new bx(Integer.valueOf(g), Boolean.valueOf(h)).onEvent("start", new bw()).onEvent(UCCore.EVENT_DIE, new bv());
            }
            uCAsyncTask = f;
        }
        return uCAsyncTask;
    }

    public static UCMRunningInfo getTotalLoadedUCM() {
        return c;
    }

    public static boolean isSetupThread() {
        return getRoot().inThread();
    }

    public static void resumeAll() {
        synchronized (sTotalSetupTasks) {
            int i2 = 0;
            while (true) {
                List<UCSetupTask> list = sTotalSetupTasks;
                if (i2 < list.size()) {
                    list.get(i2).resume();
                    i2++;
                }
            }
        }
    }

    protected static void setEnableRootTaskCreateThread(Boolean bool) {
        h = bool.booleanValue();
    }

    protected static void setRootTaskPriority(int i2) {
        g = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCrashCode() {
        return this.j != null ? aj.a.a(this, getContext(), this.j).a : "";
    }

    @Reflection
    public final UCMRunningInfo getLoadedUCM() {
        return this.a;
    }

    @Reflection
    public final UCMRepairInfo getRepairInfo() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aj getSetupCrashImprover(Context context, String str) {
        if (com.uc.webview.export.internal.utility.p.a(str)) {
            return null;
        }
        this.j = str;
        return aj.a.a(this, context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetCrashFlag() {
        if (this.j != null) {
            aj.a.a(this, getContext(), this.j).a();
        }
    }

    protected void setDefault(UCSetupTask uCSetupTask) {
        e = uCSetupTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setLoadedUCM(UCMRunningInfo uCMRunningInfo) {
        this.a = uCMRunningInfo;
    }

    protected final void setRepairInfo(UCMRepairInfo uCMRepairInfo) {
        this.d = uCMRepairInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setTotalLoadedUCM(UCMRunningInfo uCMRunningInfo) {
        c = uCMRunningInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupGlobalOnce() {
        if (i.getAndSet(true)) {
            return;
        }
        Log.d("UCSetupTask", "setupGlobalOnce");
        com.uc.webview.export.internal.uc.startup.b.a(292);
        SDKFactory.e(getContext().getApplicationContext());
        UCElapseTime uCElapseTime = new UCElapseTime();
        Object[] objArr = (Object[]) getOption(UCCore.OPTION_LOG_CONFIG);
        if (objArr != null && objArr.length == 5) {
            Boolean bool = (Boolean) objArr[0];
            Boolean bool2 = (Boolean) objArr[1];
            Log.setup(bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : false, (ValueCallback) objArr[2]);
        }
        UCCyclone.enableDebugLog = Log.enabled();
        com.uc.webview.export.internal.uc.startup.b.a(226, uCElapseTime.getMilis());
        Log.rInfo("UCSetupTask", "setupPrintLog log_conf=" + Arrays.toString(objArr) + ", enabled:" + Log.enabled());
        Log.d("UCSetupTask", "setupGlobalOption: ucbs version:" + Build.Version.NAME + JSMethod.NOT_SET + Build.Version.BUILD_SERIAL);
        StringBuilder sb = new StringBuilder();
        sb.append("setupGlobalOption:\n");
        a(UCCore.OPTION_APP_STARTUP_TIME, null, sb);
        a(UCCore.OPTION_APP_STARTUP_OPPORTUNITY, 0, sb);
        a(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX, "0", sb);
        a(UCCore.OPTION_SDK_INTERNATIONAL_ENV, null, sb);
        a(UCCore.OPTION_WEBVIEW_POLICY, 1, sb);
        a(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS, null, sb);
        a(UCCore.OPTION_USE_SDK_SETUP, null, sb);
        a(UCCore.OPTION_MULTI_CORE_TYPE, null, sb);
        a(UCCore.OPTION_HARDWARE_ACCELERATED, null, sb);
        a(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED, null, sb);
        a(UCCore.OPTION_GRANT_ALL_BUILDS, null, sb);
        a(UCCore.OPTION_CONNECTION_CONNECT_TIMEOUT, null, sb);
        a(UCCore.OPTION_CONNECTION_READ_TIMEOUT, null, sb);
        a(UCCore.OPTION_EXACT_OLD_KERNEL_CHECK, null, sb);
        a(UCCore.OPTION_EXACT_LAST_MODIFIED_CHECK, null, sb);
        a(UCCore.OPTION_UC_PLAYER_ROOT, null, sb);
        a(UCCore.OPTION_USE_UC_PLAYER, Boolean.TRUE, sb);
        a(UCCore.OPTION_BUSINESS_INIT_TYPE, null, sb);
        a(UCCore.OPTION_STARTUP_POLICY, 16, sb);
        a(UCCore.OPTION_VERIFY_POLICY, null, sb);
        a(UCCore.OPTION_INIT_FAILED_LOG_POLICY, 3, sb);
        a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS, 0, sb);
        a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_FALLBACK_TIMEOUT, 0, sb);
        Boolean bool3 = Boolean.FALSE;
        a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SERVICE_SPEEDUP, bool3, sb);
        a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SECCOMP, bool3, sb);
        a(UCCore.OPTION_GPU_PROCESS_MODE, 0, sb);
        a(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST, null, sb);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION, null, sb);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE, null, sb);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE, null, sb);
        Log.d("UCSetupTask", sb.toString());
        sb.setLength(0);
        if (com.uc.webview.export.internal.utility.i.a().c(UCCore.OPTION_INIT_FAILED_LOG_POLICY) == 0) {
            Log.flushCachedLogs(null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherInitOption:\n");
        for (Map.Entry<String, Object> entry : this.mOptions.entrySet()) {
            String key = entry.getKey();
            if (!com.uc.webview.export.internal.utility.i.a().a.containsKey(key)) {
                sb2.append("    ");
                sb2.append(key);
                sb2.append("=");
                sb2.append(entry.getValue());
                sb2.append(StringUtils.LF);
            }
        }
        Log.d("UCSetupTask", sb2.toString());
        sb2.setLength(0);
        com.uc.webview.export.internal.uc.startup.b.a(293);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public synchronized RETURN_TYPE start() {
        if (getParent() == null) {
            com.uc.webview.export.internal.uc.startup.b.a(328);
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_SETUP_THREAD_PRIORITY);
            if (num != null) {
                setRootTaskPriority(num.intValue());
            }
            Boolean bool = (Boolean) this.mOptions.get(UCCore.OPTION_SETUP_CREATE_THREAD);
            if (!com.uc.webview.export.internal.utility.p.a((String) this.mOptions.get(UCCore.OPTION_UCM_UPD_URL))) {
                bool = Boolean.TRUE;
            }
            if (bool != null) {
                setEnableRootTaskCreateThread(bool);
            }
            com.uc.webview.export.internal.uc.startup.b.a(329);
            UCAsyncTask root = getRoot();
            setParent(root);
            com.uc.webview.export.internal.uc.startup.b.a(330);
            RETURN_TYPE return_type = (RETURN_TYPE) super.start();
            root.start();
            return return_type;
        }
        return (RETURN_TYPE) super.start();
    }
}
