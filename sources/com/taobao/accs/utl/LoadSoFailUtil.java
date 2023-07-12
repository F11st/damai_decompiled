package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LoadSoFailUtil {
    public static final int MAX_FAIL_TIMES = 3;
    private static final String TAG = "LoadSoFailUtil";

    public static boolean enableSoFailCheck() {
        return true;
    }

    public static int getSoFailTimes() {
        int i;
        try {
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        if (enableSoFailCheck()) {
            i = APreferencesManager.getSharedPreferences(GlobalClientInfo.getContext(), Constants.SP_LOAD_SO_FILE_NAME, 0).getInt(Constants.SP_KEY_LOAD_SO_TIMES, 0);
            try {
                ALog.i(TAG, "getSoFailTimes", Constants.KEY_TIMES, Integer.valueOf(i));
            } catch (Throwable th2) {
                th = th2;
                ALog.e(TAG, "getSoFailTimes", th, new Object[0]);
                return i;
            }
            return i;
        }
        return 0;
    }

    public static void loadSoFail() {
        try {
            Context context = GlobalClientInfo.getContext();
            SharedPreferences sharedPreferences = APreferencesManager.getSharedPreferences(context, Constants.SP_LOAD_SO_FILE_NAME, 0);
            int i = sharedPreferences.getInt(Constants.SP_KEY_LOAD_SO_TIMES, 0) + 1;
            if (i > 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(Constants.SP_KEY_LOAD_SO_TIMES, i);
                edit.apply();
            }
            ALog.e(TAG, "loadSoFail", Constants.KEY_TIMES, Integer.valueOf(i));
            if (Build.VERSION.SDK_INT == 15) {
                UtilityImpl.killService(context);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "loadSoFail", th, new Object[0]);
        }
    }

    public static void loadSoSuccess() {
        try {
            int soFailTimes = getSoFailTimes();
            if (soFailTimes > 0) {
                SharedPreferences.Editor edit = GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_LOAD_SO_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
                ALog.i(TAG, "loadSoSuccess", "fail times", Integer.valueOf(soFailTimes));
            }
        } catch (Throwable th) {
            ALog.e(TAG, "loadSoSuccess", th, new Object[0]);
        }
    }
}
