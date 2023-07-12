package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ClientManager {
    private static final int BINDED = 2;
    private static final int BINDING = 1;
    private static final String PRE_NAME = "ACCS_BIND";
    private static final String PRE_NAME_V2 = "ACCS_BIND_V2";
    private static final String SP_BIND_KEY = "bind_status";
    private static String TAG = "ClientManager_";
    private static final int UNBINDED = 4;
    private static final int UNBINDING = 3;
    private long lastFlushTime;
    private final String mConfigTag;
    private Context mContext;
    private ConcurrentMap<String, Integer> mBindStatus = new ConcurrentHashMap();
    private ConcurrentMap<String, Integer> mBindStatusV2 = new ConcurrentHashMap();
    private ConcurrentMap<String, Set<String>> mUserBindStatus = new ConcurrentHashMap();

    public ClientManager(Context context, String str) {
        if (context != null) {
            TAG += str;
            this.mConfigTag = str;
            this.mContext = context.getApplicationContext();
            restoreClients();
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    private Map<String, Integer> getBindStatus() {
        return OrangeAdapter.isRegIdSwitchEnableAndValid(this.mContext) ? this.mBindStatusV2 : this.mBindStatus;
    }

    private String getFileName() {
        StringBuilder sb = new StringBuilder();
        sb.append(OrangeAdapter.isRegIdSwitchEnableAndValid(this.mContext) ? PRE_NAME_V2 : PRE_NAME);
        sb.append(JSMethod.NOT_SET);
        sb.append(this.mConfigTag);
        return sb.toString();
    }

    private void restoreClients() {
        try {
            SharedPreferences sharedPreferences = APreferencesManager.getSharedPreferences(this.mContext, PRE_NAME, 0);
            String string = sharedPreferences.getString(SP_BIND_KEY, null);
            if (TextUtils.isEmpty(string)) {
                Context context = this.mContext;
                string = APreferencesManager.getSharedPreferences(context, "ACCS_BIND_" + this.mConfigTag, 0).getString(SP_BIND_KEY, null);
            } else {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                ALog.w(TAG, "restoreClients break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.lastFlushTime = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.lastFlushTime;
            if (currentTimeMillis < j + 86400000) {
                for (int i = 1; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has("d")) {
                        String string2 = jSONObject.getString("d");
                        if ((Build.getMODEL() + "-" + Build.getBRAND()).equals(string2)) {
                            this.mBindStatus.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                        }
                    } else {
                        this.mBindStatus.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                    }
                }
                ALog.i(TAG, "restoreClients success", "mBindStatus", this.mBindStatus);
            } else {
                ALog.i(TAG, "restoreClients expired", "lastFlushTime", Long.valueOf(j));
                this.lastFlushTime = 0L;
            }
            SharedPreferences sharedPreferences2 = APreferencesManager.getSharedPreferences(this.mContext, PRE_NAME_V2, 0);
            String string3 = sharedPreferences2.getString(SP_BIND_KEY, null);
            if (TextUtils.isEmpty(string3)) {
                Context context2 = this.mContext;
                string3 = APreferencesManager.getSharedPreferences(context2, "ACCS_BIND_V2_" + this.mConfigTag, 0).getString(SP_BIND_KEY, null);
            } else {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.clear();
                edit2.apply();
            }
            if (TextUtils.isEmpty(string3)) {
                ALog.w(TAG, "restoreClients V2 break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray2 = new JSONArray(string3);
            this.lastFlushTime = jSONArray2.getLong(0);
            long currentTimeMillis2 = System.currentTimeMillis();
            long j2 = this.lastFlushTime;
            if (currentTimeMillis2 < 86400000 + j2) {
                for (int i2 = 1; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2.has("d")) {
                        String string4 = jSONObject2.getString("d");
                        if ((Build.getMODEL() + "-" + Build.getBRAND()).equals(string4)) {
                            this.mBindStatusV2.put(jSONObject2.getString("p"), Integer.valueOf(jSONObject2.getInt("s")));
                        }
                    } else {
                        this.mBindStatusV2.put(jSONObject2.getString("p"), Integer.valueOf(jSONObject2.getInt("s")));
                    }
                }
                ALog.i(TAG, "restoreClients V2 success", "mBindStatus", this.mBindStatusV2);
                return;
            }
            ALog.i(TAG, "restoreClients V2 expired", "lastFlushTime", Long.valueOf(j2));
            this.lastFlushTime = 0L;
        } catch (Exception e) {
            ALog.w(TAG, "restoreClients V2", e, new Object[0]);
        }
    }

    public static void saveClients(Context context, String str, long j, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j > 0 && j < System.currentTimeMillis()) {
                jSONArray.put(j);
            } else {
                jSONArray.put(System.currentTimeMillis() - (Math.random() * 8.64E7d));
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", str2);
                jSONObject.put("s", map.get(str2).intValue());
                jSONObject.put("d", Build.getMODEL() + "-" + Build.getBRAND());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, str, 0).edit();
            edit.putString(SP_BIND_KEY, jSONArray.toString());
            edit.apply();
            ALog.i(TAG, "saveClients", "f", str, "value", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearClients() {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(this.mContext, getFileName(), 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAppBinded(String str) {
        if (getBindStatus().isEmpty()) {
            restoreClients();
        }
        Integer num = getBindStatus().get(str);
        ALog.i(TAG, "isAppBinded", "appStatus", num, "mBindStatus", getBindStatus());
        return num != null && num.intValue() == 2;
    }

    public boolean isAppBinding(String str) {
        Integer num = getBindStatus().get(str);
        return num != null && num.intValue() == 1;
    }

    public boolean isAppUnbinded(String str) {
        Integer num = getBindStatus().get(str);
        return num != null && num.intValue() == 4;
    }

    public boolean isAppUnbinding(String str) {
        Integer num = getBindStatus().get(str);
        return num != null && num.intValue() == 3;
    }

    public boolean isUserBinded(String str, String str2) {
        Set<String> set;
        try {
            if (!TextUtils.isEmpty(str) && (set = this.mUserBindStatus.get(str)) != null) {
                if (set.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception e) {
            String str3 = TAG;
            ALog.e(str3, TAG + e.toString(), new Object[0]);
            e.printStackTrace();
        }
        return false;
    }

    public void onAppBind(String str) {
        Integer num = getBindStatus().get(str);
        if (num == null || num.intValue() != 2) {
            getBindStatus().put(str, 2);
            saveClients(this.mContext, getFileName(), this.lastFlushTime, getBindStatus());
        }
    }

    public void onAppBinding(String str) {
        Integer num = getBindStatus().get(str);
        if (num == null || num.intValue() != 1) {
            getBindStatus().put(str, 1);
            saveClients(this.mContext, getFileName(), this.lastFlushTime, getBindStatus());
        }
    }

    public void onAppUnbind(String str) {
        Integer num = getBindStatus().get(str);
        if (num == null || num.intValue() != 4) {
            getBindStatus().put(str, 4);
            saveClients(this.mContext, getFileName(), this.lastFlushTime, getBindStatus());
        }
    }

    public void onAppUnbinding(String str) {
        Integer num = getBindStatus().get(str);
        if (num == null || num.intValue() != 3) {
            getBindStatus().put(str, 3);
            saveClients(this.mContext, getFileName(), this.lastFlushTime, getBindStatus());
        }
    }

    public void onUserBind(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Set<String> set = this.mUserBindStatus.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(str2);
                this.mUserBindStatus.put(str, set);
            }
        } catch (Exception e) {
            String str3 = TAG;
            ALog.e(str3, TAG + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public void onUserUnBind(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mUserBindStatus.remove(str);
        } catch (Exception e) {
            String str3 = TAG;
            ALog.e(str3, TAG + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }
}
