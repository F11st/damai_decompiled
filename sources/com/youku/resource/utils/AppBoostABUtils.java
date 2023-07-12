package com.youku.resource.utils;

import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;
import com.youku.middlewareservice.provider.youku.nobel.NobelSDKProviderProxy;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AppBoostABUtils {
    private static final String BOOST_A = "1786";
    private static final String BOOST_B = "1787";
    private static final String BOOST_C = "1788";
    private static String BOOST_PREFS_KEY = "player_prefs";
    private static final String NOBEL_KEY_BOOST = "nobel_id_boost";
    public static final String SCENCE_CHANNEL = "channel";
    public static final String SCENCE_DETAIL = "detail";
    public static final String SCENCE_HOME = "home";
    public static final String SCENCE_SEARCH = "search";
    public static final String SCENCE_UCENTER = "ucenter";
    private static final String TAG = "AppBoostABUtils";
    private static int currentNobelAb = -1;
    private static int supportBoost = -1;

    private static int getBoostMode() {
        return getIntBoostPrefs("boost_mode", -1);
    }

    private static String getBoostPrefs(String str, String str2) {
        return HighPerfSPProviderProxy.getString(BOOST_PREFS_KEY, str, str2);
    }

    private static int getIntBoostPrefs(String str, int i) {
        return HighPerfSPProviderProxy.getInt(BOOST_PREFS_KEY, str, i);
    }

    private static boolean getNobelConfig() {
        String boostPrefs = getBoostPrefs(NOBEL_KEY_BOOST, "none");
        return BOOST_B.equalsIgnoreCase(boostPrefs) || BOOST_C.equalsIgnoreCase(boostPrefs);
    }

    public static boolean isOpenBoost() {
        return getNobelConfig();
    }

    private static void saveBoostApsConfig(String str) {
        if (Arrays.asList(ApasServiceManager.getInstance().getConfig("boost_config", "enable_boost_list", "detail").split(",")).contains(str)) {
            saveIntBoostPrefs("boost_mode", 1);
        } else {
            saveIntBoostPrefs("boost_mode", 0);
        }
    }

    private static void saveBoostNobelAb() {
        String hitAB = NobelSDKProviderProxy.hitAB("767");
        if (hitAB == null || hitAB.equals(getBoostPrefs(NOBEL_KEY_BOOST, "none"))) {
            return;
        }
        saveBoostPrefs(NOBEL_KEY_BOOST, hitAB);
    }

    private static void saveBoostPrefs(String str, String str2) {
        try {
            HighPerfSPProviderProxy.putString(BOOST_PREFS_KEY, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveIntBoostPrefs(String str, int i) {
        try {
            HighPerfSPProviderProxy.putInt(BOOST_PREFS_KEY, str, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean supportBoost() {
        int i = supportBoost;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (getBoostMode() == 1) {
            supportBoost = 1;
            return true;
        }
        supportBoost = 0;
        return false;
    }

    public static void updateBoostConfig(String str) {
        saveBoostNobelAb();
    }
}
