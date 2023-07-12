package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.taobao.windvane.extra.uc.IOnSgHttpRequestCallback;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.wkit.component.Constants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WindvaneListener implements IOnSgHttpRequestCallback {
    private static final boolean DEBUG = false;
    private static final int ERROR_HANDLER_METHOD_ID_MIN = 200000;
    private static final int ERROR_HANDLER_METHOD_WINDVANE_H5_SIGN_NORMAL = 200001;
    private static final int ERROR_HANDLER_METHOD_WINDVANE_H5_SIGN_TEST1000 = 200002;
    private static String[] FIX_HEADER_KEY = {"Accept-Encoding", IRequestConst.USER_AGENT};
    private static final String KEY_API = "api";
    private static final String KEY_APPKEY = "appkey";
    private static final String KEY_AUTH_CODE = "authCode";
    private static final String KEY_DATA = "data";
    private static final String KEY_ENV = "env";
    private static final String KEY_MINI_WUA = "miniWua";
    private static final String KEY_SIGN_KEY = "signKey";
    private static final String KEY_USE_WUA = "useWua";
    private static final String RESULT_X_APPKEY = "x-appkey";
    private static final String RESULT_X_MINIWUA = "x-mini-wua";
    private static final String RESULT_X_PV = "x-pv";
    private static final String RESULT_X_PV_VALUE = "6.3-h5-v2";
    private static final String RESULT_X_PV_VALUE_TEST = "6.3-h5-test";
    private static final String RESULT_X_SGEXT = "x-sgext";
    private static final String RESULT_X_SIGN = "x-sign";
    private static final String RESULT_X_T = "x-t";
    private static final String RESULT_X_UMT = "x-umt";
    private static final String RESULT_X_WUA = "wua";
    private static final String SYMBOL_AND = "&";
    private static final String TAG = "WindvaneListener";
    private static volatile IRouterComponent gGlobalRounterComponent;
    private IUnifiedSecurityComponent gUnifiedSecurityComp;
    private IStaticDataStoreComponent sdsComponent;
    final int PLUGIN_ID = 10;
    private long avg_TimeCost = 0;
    final int ERROR_CODE_GET_ROUTER_FAILED = 1;
    final int ERROR_CODE_G_CONFIG_CLOSE = 2;
    final int ERROR_CODE_G_URL_LIST_CLOSE = 3;
    final int ERROR_CODE_GET_APPKEY_FAILED = 4;
    final int ERROR_CODE_GET_SIGN_INIT_FAILED = 5;
    final int ERROR_CODE_GET_SIGN_GETFACTOR_FAILED = 6;
    final int ERROR_CODE_GET_SIGN_GETFACTOR_NULL = 7;
    final int ERROR_CODE_REQUEST_HEADER_INVALID = 8;
    final int ERROR_CODE_GET_GORANGECALLBACKPROCESSSWITCH_FAILED = 9;
    final int ERROR_CODE_GET_GORANGEURLLISTSTR_FAILED = 10;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class WLOG {
        public static void d(String str) {
        }

        public static void e(String str) {
        }
    }

    private IRouterComponent getRouterComponent() {
        if (gGlobalRounterComponent == null) {
            synchronized (WindvaneListener.class) {
                if (gGlobalRounterComponent == null) {
                    try {
                        ISGPluginManager sGPluginManager = SecurityGuardManager.getInstance(OrangeAdapter.gContext).getSGPluginManager();
                        this.gUnifiedSecurityComp = (IUnifiedSecurityComponent) SecurityGuardManager.getInstance(OrangeAdapter.gContext).getInterface(IUnifiedSecurityComponent.class);
                        this.sdsComponent = SecurityGuardManager.getInstance(OrangeAdapter.gContext).getStaticDataStoreComp();
                        gGlobalRounterComponent = sGPluginManager.getRouter();
                    } catch (Exception e) {
                        WLOG.d("getRouterComponent : " + e.getMessage());
                    }
                }
            }
        }
        return gGlobalRounterComponent;
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.alibaba.wireless.security.open.securityguardaccsadapter.WindvaneListener.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }

    public static String stringToMD5(String str) {
        String str2 = null;
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16);
            for (int i = 0; i < 32 - bigInteger.length(); i++) {
                try {
                    bigInteger = "0" + bigInteger;
                } catch (Exception unused) {
                    str2 = bigInteger;
                    return str2;
                }
            }
            return bigInteger;
        } catch (Exception unused2) {
        }
    }

    public String assembleSignData(Map<String, String> map, String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            String[] strArr = FIX_HEADER_KEY;
            if (i < strArr.length) {
                String str3 = strArr[i];
                String str4 = map.get(str3);
                if (str4 == null) {
                    return null;
                }
                WLOG.d("key = " + str3 + " value = " + str4);
                sb.append(str4);
                sb.append("&");
                i++;
            } else {
                sb.append(str);
                sb.append("&");
                sb.append(str2);
                return sb.toString();
            }
        }
    }

    public String getSignUrl(String str, String str2) {
        int length = str2.length();
        int length2 = str.length();
        if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            length2 = str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        }
        if (length <= length2) {
            return str.substring(length, length2);
        }
        return null;
    }

    public boolean isHeadValid(Map<String, String> map) {
        for (String str : FIX_HEADER_KEY) {
            if (!map.keySet().contains(str)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, String> onSgHttpRequest(String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4) {
        return onSgHttpRequestImpl(str, str2, z, map, map2, map3, map4);
    }

    public Map<String, String> onSgHttpRequestImpl(String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4) {
        WLOG.d("enter onSgHttpRequest");
        return new HashMap();
    }
}
