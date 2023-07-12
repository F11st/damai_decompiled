package com.youku.skinmanager.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SkinResourceUtils {
    @Nullable
    public static Integer getColor(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (!TextUtils.isEmpty(string)) {
                if (!string.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    string = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + string;
                }
                return Integer.valueOf(Color.parseColor(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static Drawable getDrawable(Context context, String str) {
        Bitmap decodeFile;
        if (TextUtils.isEmpty(str) || !str.endsWith(".png") || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        decodeFile.setDensity(320);
        return new BitmapDrawable(context.getResources(), decodeFile);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getJson(java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r5 != 0) goto L12
            return r1
        L12:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
            r2.<init>(r5)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
            r1.<init>(r2)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
        L26:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
            if (r2 == 0) goto L30
            r0.append(r2)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4e
            goto L26
        L30:
            r5.close()     // Catch: java.io.IOException -> L45
            goto L49
        L34:
            r1 = move-exception
            goto L3c
        L36:
            r0 = move-exception
            goto L50
        L38:
            r5 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L3c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r5 = move-exception
            r5.printStackTrace()
        L49:
            java.lang.String r5 = r0.toString()
            return r5
        L4e:
            r0 = move-exception
            r1 = r5
        L50:
            if (r1 == 0) goto L5a
            r1.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r5 = move-exception
            r5.printStackTrace()
        L5a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.skinmanager.utils.SkinResourceUtils.getJson(java.lang.String):java.lang.String");
    }

    public static ColorStateList makeColorList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{i, i2});
    }
}
