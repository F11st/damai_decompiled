package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class x implements d {
    private static String a = "SpCache";
    private static String b = "com.vivo.push.cache";
    private SharedPreferences c;

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = context.getSharedPreferences(b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            b.a(edit);
            p.d(a, "putString by ".concat(String.valueOf(str)));
            return;
        }
        p.b(a, "putString error by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        String string = this.c.getString(str, str2);
        String str3 = a;
        p.d(str3, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear();
            b.a(edit);
        }
        p.d(a, "system cache is cleared");
    }
}
