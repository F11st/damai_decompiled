package com.efs.sdk.base.a.c.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.e.f;
import java.io.File;
import java.util.Map;
import tb.f33;
import tb.n43;
import tb.q33;
import tb.w63;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile SharedPreferences a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        f33 a = com.efs.sdk.base.a.d.a.a();
        File c = q33.c(a.c, a.a);
        if (c.exists()) {
            z43.i(c);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        File b = q33.b(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
        if (b.exists()) {
            b.delete();
        }
    }

    private void e() {
        if (this.a == null) {
            synchronized (com.efs.sdk.base.a.e.b.class) {
                if (this.a == null) {
                    String str = com.efs.sdk.base.a.d.a.a().a;
                    this.a = com.alibaba.android.newsharedpreferences.a.c(com.efs.sdk.base.a.d.a.a().c, n43.b(("config_" + str.toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(@NonNull a aVar) {
        d();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        edit.putInt("cver", aVar.a);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : aVar.f.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        try {
            e();
        } catch (Throwable th) {
            w63.c("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        f fVar;
        fVar = f.a.a;
        if (fVar.b()) {
            return;
        }
        c.a().h();
    }
}
