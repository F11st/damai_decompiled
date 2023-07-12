package com.taobao.tlog.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogController;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogUtils;
import java.io.File;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogConfigSwitchReceiver {
    public static final String REMOTE_DEBUGER_ANDROID = "remote_debug";
    public static final String REMOTE_TLOG_CONFIG = "tlog_switch";
    private static final String TAG = "TLogConfigReceiver";

    public static void init(final Context context) {
        OrangeConfig.getInstance().registerListener(new String[]{REMOTE_DEBUGER_ANDROID, "tlog_switch"}, new OrangeConfigListener() { // from class: com.taobao.tlog.remote.TLogConfigSwitchReceiver.1
            @Override // com.taobao.orange.OrangeConfigListener
            public void onConfigUpdate(String str) {
                Log.i(TLogConfigSwitchReceiver.TAG, "TLogConfigSwitchReceiver onConfigUpdate " + str);
                Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
                if (configs != null) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                    if (TLogConfigSwitchReceiver.REMOTE_DEBUGER_ANDROID.equals(str)) {
                        String str2 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY);
                        String str3 = configs.get("tlog_switch");
                        String str4 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL);
                        String str5 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_MODULE);
                        String str6 = configs.get("tlog_start_up_sampling");
                        if (TLogController.getInstance() == null) {
                            return;
                        }
                        Log.e(TLogConfigSwitchReceiver.TAG, "tlogDestroy is: " + str2 + "tlogSwitch is : " + str3 + "  tlogLevel is : " + str4 + "  tlogModule is : " + str5);
                        if (!TextUtils.isEmpty(str2) && "true".equals(str2)) {
                            Log.e(TLogConfigSwitchReceiver.TAG, "destroy tlog");
                            TLogController.getInstance().closeLog();
                            TLogUtils.cleanDir(new File(TLogInitializer.getInstance().getFileDir()));
                            edit.putBoolean(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY, true).apply();
                            return;
                        }
                        edit.putBoolean(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY, false).apply();
                        if (!TextUtils.isEmpty(str3) && "false".equals(str3)) {
                            Log.e(TLogConfigSwitchReceiver.TAG, "switch tlog function");
                            TLogController.getInstance().closeLog();
                            edit.putBoolean("tlog_switch", false).apply();
                        } else {
                            edit.putBoolean("tlog_switch", true).apply();
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            Log.e(TLogConfigSwitchReceiver.TAG, "change tlog level : " + str4);
                            LogLevel convertLogLevel = TLogUtils.convertLogLevel(str4);
                            edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL, str4).apply();
                            TLogController.getInstance().setLogLevel(convertLogLevel);
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            Log.e(TLogConfigSwitchReceiver.TAG, "tlog model : " + str5);
                            if ("off".equals(str5)) {
                                TLogController.getInstance().cleanModuleFilter();
                                edit.remove(TLogConstant.REMOTE_DEBUGER_LOG_MODULE).apply();
                            } else {
                                Map<String, LogLevel> makeModule = TLogUtils.makeModule(str5);
                                if (makeModule != null && makeModule.size() > 0) {
                                    TLogController.getInstance().addModuleFilter(makeModule);
                                    edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_MODULE, str5).apply();
                                }
                            }
                        }
                        if (TextUtils.isEmpty(str6)) {
                            return;
                        }
                        Log.e(TLogConfigSwitchReceiver.TAG, "change tlog start up sampling : " + str6);
                        try {
                            TLogInitializer.getInstance().startUpSampling(Integer.valueOf(Integer.parseInt(str6)));
                            return;
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else if ("tlog_switch".equals(str)) {
                        String str7 = configs.get(TLogConstant.TLOG_CONFIG_LOG_FILE_SIZE);
                        if (!TextUtils.isEmpty(str7)) {
                            try {
                                edit.putLong(TLogConstant.TLOG_CONFIG_LOG_FILE_SIZE, Long.parseLong(str7)).apply();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        String str8 = configs.get(TLogConstant.TLOG_FILE_VERSION);
                        if (!TextUtils.isEmpty(str8)) {
                            try {
                                edit.putInt(TLogConstant.TLOG_FILE_VERSION, Integer.parseInt(str8)).apply();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        String str9 = configs.get(TLogConstant.TLOG_STATISTICS_SAMPLE);
                        if (!TextUtils.isEmpty(str9)) {
                            try {
                                edit.putInt(TLogConstant.TLOG_STATISTICS_SAMPLE, Integer.parseInt(str9)).apply();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        String str10 = configs.get(TLogConstant.TLOG_FILE_STATISTICS_DAY);
                        if (!TextUtils.isEmpty(str10)) {
                            try {
                                edit.putInt(TLogConstant.TLOG_FILE_STATISTICS_DAY, Integer.parseInt(str10)).apply();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        String str11 = configs.get(TLogConstant.TLOG_FILE_STATISTICS_SAMPLE);
                        if (!TextUtils.isEmpty(str11)) {
                            try {
                                edit.putInt(TLogConstant.TLOG_FILE_STATISTICS_SAMPLE, Integer.parseInt(str11)).apply();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        String str12 = configs.get(TLogConstant.TLOG_BUFFER_SIZE);
                        if (!TextUtils.isEmpty(str12)) {
                            try {
                                edit.putLong(TLogConstant.TLOG_BUFFER_SIZE, Long.parseLong(str12)).apply();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        String str13 = configs.get(TLogConstant.TLOG_SCAN_UPLOAD);
                        if (!TextUtils.isEmpty(str13)) {
                            edit.putBoolean(TLogConstant.TLOG_SCAN_UPLOAD, "true".equals(str13)).apply();
                        }
                        String str14 = configs.get(TLogConstant.TLOG_MULTI_PROCESS_NOTIFY);
                        if (!TextUtils.isEmpty(str14)) {
                            edit.putBoolean(TLogConstant.TLOG_MULTI_PROCESS_NOTIFY, "true".equals(str14)).apply();
                        }
                        Log.e(TLogConfigSwitchReceiver.TAG, String.format("[orange]tlog_switch: fileVersion=%s, tlogMaxSize=%s, utSampleRate=%s, fileStatisticsDays=%s, fileStatisticsRate=%s, bufferSize=%s, scanUpload=%s, multiProcessNotify=%s", str8, str7, str9, str10, str11, str12, str13, str14));
                        return;
                    } else {
                        return;
                    }
                }
                Log.i(TLogConfigSwitchReceiver.TAG, "TLogConfigSwitchReceiver --> the config is null!");
            }
        });
    }
}
