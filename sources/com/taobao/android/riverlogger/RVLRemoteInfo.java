package com.taobao.android.riverlogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RVLRemoteInfo {
    private final String a;
    private final String b;
    private final boolean c = false;
    private final CommandFilter d = null;
    private boolean e = true;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface CommandFilter {
        boolean filter(@NonNull String str, @Nullable String str2);
    }

    public RVLRemoteInfo(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    public static RVLRemoteInfo f(String str) {
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("server", null);
            if (optString2 == null) {
                optString2 = jSONObject.optString("appWsUrl", null);
                if (optString2 == null) {
                    return null;
                }
                optString = jSONObject.optString("debugId", null);
            } else {
                optString = jSONObject.optString("id", null);
            }
            if (optString == null) {
                return null;
            }
            return new RVLRemoteInfo(optString2, optString);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public CommandFilter b() {
        return this.d;
    }

    public boolean c() {
        if (this.d != null) {
            return false;
        }
        return this.e;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }
}
