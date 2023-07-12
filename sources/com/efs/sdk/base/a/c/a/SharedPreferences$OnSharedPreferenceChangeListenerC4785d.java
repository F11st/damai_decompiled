package com.efs.sdk.base.a.c.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.alibaba.android.newsharedpreferences.C3236a;
import com.efs.sdk.base.a.d.C4786a;
import com.efs.sdk.base.a.e.C4794f;
import com.efs.sdk.base.a.e.HandlerC4790b;
import java.io.File;
import java.util.Map;
import tb.f33;
import tb.n43;
import tb.q33;
import tb.w63;
import tb.z43;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.c.a.d */
/* loaded from: classes10.dex */
public final class SharedPreferences$OnSharedPreferenceChangeListenerC4785d implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile SharedPreferences a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        f33 a = C4786a.a();
        File c = q33.c(a.c, a.a);
        if (c.exists()) {
            z43.i(c);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        File b = q33.b(C4786a.a().c, C4786a.a().a);
        if (b.exists()) {
            b.delete();
        }
    }

    private void e() {
        if (this.a == null) {
            synchronized (HandlerC4790b.class) {
                if (this.a == null) {
                    String str = C4786a.a().a;
                    this.a = C3236a.c(C4786a.a().c, n43.b(("config_" + str.toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(@NonNull C4781a c4781a) {
        d();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        edit.putInt("cver", c4781a.a);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : c4781a.f.entrySet()) {
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
        C4794f c4794f;
        c4794f = C4794f.C4795a.a;
        if (c4794f.b()) {
            return;
        }
        C4783c.a().h();
    }
}
