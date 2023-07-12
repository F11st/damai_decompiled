package me.ele.altriax.launcher.real.time.data.utils;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Apm {
    private static final String EMPTY_STRING = "";

    public static String processApmEvents(@NonNull Gson gson, @NonNull List<rf0> list) {
        try {
            return gson.toJson(list, new TypeToken<List<rf0>>() { // from class: me.ele.altriax.launcher.real.time.data.utils.Apm.3
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmProperties(@NonNull Gson gson, @NonNull Map<String, Object> map) {
        try {
            return gson.toJson(map, new TypeToken<Map<String, Object>>() { // from class: me.ele.altriax.launcher.real.time.data.utils.Apm.1
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmStages(@NonNull Gson gson, @NonNull List<qf2> list) {
        try {
            return gson.toJson(list, new TypeToken<List<qf2>>() { // from class: me.ele.altriax.launcher.real.time.data.utils.Apm.4
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmStats(@NonNull Gson gson, @NonNull Map<String, Object> map) {
        try {
            return gson.toJson(map, new TypeToken<Map<String, Object>>() { // from class: me.ele.altriax.launcher.real.time.data.utils.Apm.2
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }
}
