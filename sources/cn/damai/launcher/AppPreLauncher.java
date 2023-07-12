package cn.damai.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import cn.damai.common.AppConfig;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.motu.crashreporter.ReporterConfigure;
import com.alibaba.motu.tbrest.SendService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import java.util.HashMap;
import java.util.Map;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AppPreLauncher {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = AppPreLauncher.class.getSimpleName() + "_xxx";
    private Context a = null;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class UTCrashCaughtListner implements IUTCrashCaughtListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private UTCrashCaughtListner() {
        }

        @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
        public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "173397527")) {
                return (Map) ipChange.ipc$dispatch("173397527", new Object[]{this, thread, th});
            }
            HashMap hashMap = new HashMap();
            if (th != null) {
                String th2 = th.toString();
                String[] strArr = {"com.taobao.agoo.AgooCommondReceiver", "com.taobao.orange.receiver.OrangeReceiver", "com.alibaba.pictures.accs.TaobaoIntentService"};
                if (!TextUtils.isEmpty(th2)) {
                    for (int i = 0; i < 3; i++) {
                        String str = strArr[i];
                        if (th2.contains(str)) {
                            try {
                                String str2 = AppPreLauncher.TAG;
                                Log.d(str2, "close component = " + str);
                                hashMap.put("disable_component", str);
                                AppPreLauncher.this.a.getPackageManager().setComponentEnabledSetting(new ComponentName(AppPreLauncher.this.a, str), 2, 1);
                                PreferenceManager.getDefaultSharedPreferences(AppPreLauncher.this.a).edit().putString("disableComponent", str).commit();
                            } catch (Throwable th3) {
                                Log.w(AppPreLauncher.TAG, th3);
                            }
                        }
                    }
                }
            }
            return hashMap;
        }
    }

    private void c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825684970")) {
            ipChange.ipc$dispatch("-825684970", new Object[]{this, context});
            return;
        }
        try {
            ReporterConfigure reporterConfigure = new ReporterConfigure();
            reporterConfigure.enableDumpSysLog = true;
            reporterConfigure.enableDumpRadioLog = true;
            reporterConfigure.enableDumpEventsLog = true;
            reporterConfigure.enableCatchANRException = true;
            reporterConfigure.enableANRMainThreadOnly = true;
            reporterConfigure.enableDumpAllThread = true;
            reporterConfigure.enableDeduplication = false;
            reporterConfigure.isCloseMainLooperSampling = true;
            String p = AppConfig.p();
            SharedPreferences sharedPreferences = context.getSharedPreferences(SessionManager.USERINFO, 0);
            MotuCrashReporter.getInstance().enable(context, AppConfig.b(), AppConfig.c(), AppConfig.q(), p, sharedPreferences != null ? sharedPreferences.getString(SessionConstants.OLDNICK, "") : null, reporterConfigure);
            MotuCrashReporter.getInstance().setCrashCaughtListener(new UTCrashCaughtListner());
        } catch (Throwable th) {
            Log.e(TAG, String.valueOf(th));
        }
    }

    public void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391424987")) {
            ipChange.ipc$dispatch("-391424987", new Object[]{this, context});
            return;
        }
        cb1.b("prelaunch", "prelaunch invokded");
        this.a = context;
        SendService.getInstance().host = "h-adashx.ut.hzshudian.com";
        MotuCrashReporter.getInstance().changeHost("h-adashx.ut.hzshudian.com");
        if (!AppConfig.v()) {
            c(context);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("popcorn", 0);
        if (sharedPreferences == null || !sharedPreferences.getBoolean("crash_status", false)) {
            return;
        }
        Toast.makeText(context, "debug爆米花开启crash上报功能", 1).show();
        c(context);
    }
}
