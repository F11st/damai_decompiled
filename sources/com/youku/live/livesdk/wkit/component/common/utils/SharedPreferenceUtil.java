package com.youku.live.livesdk.wkit.component.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SharedPreferenceUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FILE_NAME_LIVE_PIP = "live_pip";
    public static final String KEY_LIVE_PIP_SWITCH = "live_pip_switch";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtil(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "972112302")) {
            ipChange.ipc$dispatch("972112302", new Object[]{this});
            return;
        }
        SharedPreferences.Editor editor = this.editor;
        if (editor == null) {
            return;
        }
        editor.clear();
        this.editor.commit();
    }

    public Boolean contain(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163453838")) {
            return (Boolean) ipChange.ipc$dispatch("1163453838", new Object[]{this, str});
        }
        if (this.sharedPreferences != null && !TextUtils.isEmpty(str)) {
            return Boolean.valueOf(this.sharedPreferences.contains(str));
        }
        return Boolean.FALSE;
    }

    public Map<String, ?> getAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924776825")) {
            return (Map) ipChange.ipc$dispatch("924776825", new Object[]{this});
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public Object getSharedPreference(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873040295")) {
            return ipChange.ipc$dispatch("1873040295", new Object[]{this, str, obj});
        }
        if (this.editor == null || TextUtils.isEmpty(str)) {
            return "";
        }
        if (obj instanceof String) {
            return this.sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return this.sharedPreferences.getString(str, null);
    }

    public void put(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198687150")) {
            ipChange.ipc$dispatch("-1198687150", new Object[]{this, str, obj});
        } else if (this.editor == null || TextUtils.isEmpty(str)) {
        } else {
            if (obj instanceof String) {
                this.editor.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                this.editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                this.editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                this.editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                this.editor.putLong(str, ((Long) obj).longValue());
            } else {
                this.editor.putString(str, obj.toString());
            }
            this.editor.commit();
        }
    }

    public void remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025639787")) {
            ipChange.ipc$dispatch("-1025639787", new Object[]{this, str});
        } else if (this.editor == null || TextUtils.isEmpty(str)) {
        } else {
            this.editor.remove(str);
            this.editor.commit();
        }
    }
}
