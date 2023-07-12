package com.taobao.tao.log.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.utils.TLogMultiProcessTool;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogStatisticsManager {
    private static final int DEFAULT_FILE_STATISTICS_DAY = 1;
    private static final String SP_KEY_FILE_DATE = "tlog_file_statistics_timestamp";
    private static final String TAG = "TLogStatistics";
    private static boolean isEnable;
    private static boolean isFileSizeEnable;

    public static void init(Context context, int i, int i2) {
        Log.i(TAG, "TLogStatisticsManager init");
        i = (i > 10000 || i < 0) ? 4000 : 4000;
        i2 = (i2 > 10000 || i2 < 0) ? 50 : 50;
        try {
            int nextInt = new Random().nextInt(10000);
            boolean z = nextInt < i;
            isEnable = z;
            isFileSizeEnable = nextInt < i2;
            Log.e(TAG, String.format("TLog statistic ut_enable=%b, file_enable=%b, randomRate=%d, configRate=%d，fileRate=%d", Boolean.valueOf(z), Boolean.valueOf(isFileSizeEnable), Integer.valueOf(nextInt), Integer.valueOf(i), Integer.valueOf(i2)));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "TLogStatisticsManager init exception!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIsEnable() {
        return isEnable;
    }

    public static void statisticsFile(Context context) {
        try {
            if (isEnable && isFileSizeEnable) {
                if (!TLogMultiProcessTool.isMainProcess(context)) {
                    Log.w(TAG, "Only work in main process");
                    return;
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                int i = 1;
                if (defaultSharedPreferences.contains(TLogConstant.TLOG_FILE_STATISTICS_DAY) && (i = defaultSharedPreferences.getInt(TLogConstant.TLOG_FILE_STATISTICS_DAY, 1)) <= 0) {
                    Log.i(TAG, "statistics file is disable");
                    return;
                }
                int i2 = i + 1;
                String[] days = TLogUtils.getDays(Integer.valueOf(i2));
                if (days != null && days.length == i2) {
                    String string = defaultSharedPreferences.getString(SP_KEY_FILE_DATE, "");
                    String str = days[0];
                    if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                        String[] strArr = new String[i];
                        int i3 = 0;
                        while (i3 < i) {
                            int i4 = i3 + 1;
                            strArr[i3] = days[i4];
                            i3 = i4;
                        }
                        List<String> filePath = TLogUtils.getFilePath(TLogInitializer.getInstance().getNameprefix(), 0, strArr);
                        if (filePath != null && !filePath.isEmpty()) {
                            for (String str2 : filePath) {
                                File file = new File(str2);
                                if (file.exists() && file.isFile()) {
                                    String name = file.getName();
                                    long length = file.length();
                                    int indexOf = name.indexOf(JSMethod.NOT_SET);
                                    TLogEventHelper.fileSizeEvent(name.substring(0, indexOf), name.substring(indexOf + 1, name.indexOf(".tlog")), length);
                                }
                            }
                            defaultSharedPreferences.edit().putString(SP_KEY_FILE_DATE, str).apply();
                            return;
                        }
                        Log.i(TAG, "statisticsFile cancel. Log log file list is empty");
                        return;
                    }
                    Log.i(TAG, "statistics file cancel. No need statisticsFile again.");
                    return;
                }
                Log.i(TAG, "statistics file cancel. Days list is empty!");
                return;
            }
            Log.e(TAG, "statistics file is disable");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "statisticsFile exception!");
        }
    }
}
