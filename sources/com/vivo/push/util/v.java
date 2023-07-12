package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class v implements d {
    private ContentResolver a;

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        if (j.b()) {
            this.a = context.getContentResolver();
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.a, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "putString error by ".concat(String.valueOf(str)));
        }
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.a, str);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
