package com.efs.sdk.base.a.c.a;

import androidx.annotation.NonNull;
import com.taobao.weex.common.Constants;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.w63;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.c.a.b */
/* loaded from: classes10.dex */
public final class C4782b {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);

    private static int a(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        if (str2 == null) {
            str2 = "0";
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    private static int b(String str, String str2, String str3) {
        if ("ver".equals(str)) {
            return a(str2, str3);
        }
        if (Constants.Value.DATETIME.equals(str)) {
            return e(str2, str3);
        }
        return -100;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x017a, code lost:
        if (r9.compareTo(r8) != 0) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x0241, LOOP:1: B:139:0x01dc->B:155:0x023d, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:137:0x01d9, B:155:0x023d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0241, blocks: (B:3:0x0004, B:5:0x000c, B:7:0x0014, B:10:0x001d, B:15:0x0036, B:17:0x0048, B:31:0x008b, B:136:0x01d5, B:34:0x0095, B:35:0x009a, B:83:0x0141, B:85:0x0146, B:86:0x014c, B:87:0x0152, B:88:0x0158, B:89:0x015e, B:90:0x0164, B:91:0x016a, B:92:0x0170, B:94:0x0176, B:100:0x0183, B:102:0x0189, B:107:0x0193, B:109:0x0199, B:114:0x01a3, B:116:0x01a9, B:121:0x01b3, B:123:0x01b9, B:128:0x01c3, B:130:0x01c9, B:37:0x009f, B:40:0x00ab, B:43:0x00b7, B:46:0x00c3, B:49:0x00cf, B:52:0x00d9, B:55:0x00e3, B:58:0x00ed, B:61:0x00f7, B:64:0x0101, B:67:0x010b, B:70:0x0115, B:73:0x011f, B:76:0x012a, B:79:0x0135, B:18:0x004d, B:20:0x0055, B:21:0x0068, B:23:0x0070, B:24:0x0075, B:26:0x007b, B:28:0x0081, B:139:0x01dc, B:141:0x01e2, B:143:0x01ea, B:145:0x01f0, B:148:0x0200, B:151:0x0210, B:153:0x0224, B:154:0x0236), top: B:160:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(java.util.Map<java.lang.String, java.lang.String> r13, org.json.JSONArray r14, org.json.JSONArray r15) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.a.c.a.C4782b.c(java.util.Map, org.json.JSONArray, org.json.JSONArray):void");
    }

    public static boolean d(@NonNull String str, @NonNull C4781a c4781a) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.youku.arch.v3.core.Constants.CONFIG);
            int i = jSONObject.getInt("cver");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject2.optString(next, ""));
                    }
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("app_configs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("conditions");
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("actions");
                            if (optJSONArray2 != null && optJSONArray3 != null && optJSONArray3.length() > 0) {
                                c(hashMap, optJSONArray2, optJSONArray3);
                            }
                        }
                    }
                }
            }
            c4781a.b(hashMap);
            c4781a.a = i;
            return true;
        } catch (Throwable th) {
            w63.c("efs.config", "parseConfig error, data is ".concat(String.valueOf(str)), th);
            return false;
        }
    }

    private static int e(String str, String str2) {
        if (str == null) {
            str = "1970/01/01 00:00:00";
        }
        if (str2 == null) {
            str2 = "1970/01/01 00:00:00";
        }
        String[] split = str.split("[:/\\s]");
        String[] split2 = str2.split("[:/\\s]");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
