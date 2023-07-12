package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.xiaomi.push.cj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cg extends cj.e {
    private String a;

    public cg(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static cg a(Context context, String str, hn hnVar) {
        byte[] a = it.a(hnVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hnVar.d());
        contentValues.put("messageItem", a);
        contentValues.put(ALBiometricsKeys.KEY_APP_ID, bx.a(context).b());
        contentValues.put("packageName", bx.a(context).m714a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new cg(str, contentValues, "a job build to insert message to db");
    }
}
