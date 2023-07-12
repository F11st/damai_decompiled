package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.x */
/* loaded from: classes11.dex */
public final class C7531x implements InterfaceC7511d {
    private static String a = "SpCache";
    private static String b = "com.vivo.push.cache";
    private SharedPreferences c;

    @Override // com.vivo.push.util.InterfaceC7511d
    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = context.getSharedPreferences(b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.InterfaceC7511d
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            C7509b.a(edit);
            C7523p.d(a, "putString by ".concat(String.valueOf(str)));
            return;
        }
        C7523p.b(a, "putString error by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.InterfaceC7511d
    public final String a(String str, String str2) {
        String string = this.c.getString(str, str2);
        String str3 = a;
        C7523p.d(str3, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear();
            C7509b.a(edit);
        }
        C7523p.d(a, "system cache is cleared");
    }
}
