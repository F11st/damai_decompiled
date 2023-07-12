package com.taobao.update.apk.history;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.taobao.update.framework.UpdateRuntime;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApkUpdateHistory {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Data implements Serializable {
        public String ext;
        public String fromVersion;
        public String toVersion;
    }

    public static Data getData() {
        String string = PreferenceManager.getDefaultSharedPreferences(UpdateRuntime.getContext()).getString("update_history", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (Data) JSON.parseObject(string, Data.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void reset() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(UpdateRuntime.getContext()).edit();
        edit.remove("update_history");
        edit.apply();
    }

    public static void update(Data data) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(UpdateRuntime.getContext()).edit();
        edit.putString("update_history", JSON.toJSONString(data));
        edit.apply();
    }
}
