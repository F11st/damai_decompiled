package me.ele.altriax.launcher.common;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXConfig {
    public static final String KEY_ALI_PRIVACY_NOT_INIT_DOWNGRADE = "boost_ali_privacy_not_init_downgrade";
    private static final String KEY_DAG_ALTRIAXB = "boost_altriaxb";
    public static final String KEY_EXTERNAL_LINK_HOME_SKIP_ADS_DOWNGRADE = "boost_external_link_home_skip_ads_downgrade";
    public static final String KEY_EXTERNAL_LINK_HOST_LONG_LINK_DOWNGRADE = "boost_external_link_host_long_link_downgrade";
    public static final String KEY_EXTERNAL_LINK_SCHEME_UPGRADE_WINDVANE2_DOWNGRADE = "boost_external_link_scheme_upgrade_windvane2_downgrade";
    public static final String KEY_IDLE_CHECK_DOWNGRADE = "boost_idle_check_downgrade";
    private static final String NAMESPACE = "android_ele_launch";
    public static final String SP_NAME = "android_ele_launch_sp";
    public static final String VALUE_TRUE = "1";
    public static List<String> orangeKeys;

    static {
        ArrayList arrayList = new ArrayList();
        orangeKeys = arrayList;
        arrayList.add(KEY_DAG_ALTRIAXB);
        orangeKeys.add(KEY_EXTERNAL_LINK_SCHEME_UPGRADE_WINDVANE2_DOWNGRADE);
        orangeKeys.add(KEY_EXTERNAL_LINK_HOST_LONG_LINK_DOWNGRADE);
        orangeKeys.add(KEY_EXTERNAL_LINK_HOME_SKIP_ADS_DOWNGRADE);
        orangeKeys.add(KEY_ALI_PRIVACY_NOT_INIT_DOWNGRADE);
        orangeKeys.add(KEY_IDLE_CHECK_DOWNGRADE);
    }

    public static String loadOrangeValue(@NonNull String str) {
        return LauncherRuntime.sContext.getSharedPreferences(SP_NAME, 0).getString(str, "");
    }

    public static void registerAltriaXListener() {
        registerAltriaXListenerInternal(orangeKeys);
    }

    private static void registerAltriaXListenerInternal(@Nullable final List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, ExifInterface.LONGITUDE_EAST, null, SystemClock.elapsedRealtime() + ""));
        OrangeConfig.getInstance().registerListener(new String[]{NAMESPACE}, new OConfigListener() { // from class: me.ele.altriax.launcher.common.AltriaXConfig.1
            @Override // com.taobao.orange.OConfigListener
            public void onConfigUpdate(String str, Map<String, String> map) {
                AltriaXExecutor.ALTRIAX_EXECUTOR.execute(new Runnable() { // from class: me.ele.altriax.launcher.common.AltriaXConfig.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(AltriaXConfig.NAMESPACE);
                        for (String str2 : list) {
                            if (!TextUtils.isEmpty(str2)) {
                                String str3 = configs.get(str2);
                                AltriaXConfig.saveOrangeValue(str2, str3);
                                AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "orange " + str2, null, str3));
                            }
                        }
                    }
                });
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveOrangeValue(@NonNull String str, @NonNull String str2) {
        LauncherRuntime.sContext.getSharedPreferences(SP_NAME, 0).edit().putString(str, str2).apply();
    }
}
