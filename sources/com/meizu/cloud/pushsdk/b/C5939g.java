package com.meizu.cloud.pushsdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.g */
/* loaded from: classes10.dex */
public class C5939g extends C5940h<InterfaceC5938f> implements InterfaceC5938f {
    private static C5939g a;
    private boolean b;

    private C5939g(InterfaceC5938f interfaceC5938f) {
        super(interfaceC5938f);
        this.b = false;
    }

    public static C5939g b() {
        if (a == null) {
            synchronized (C5939g.class) {
                if (a == null) {
                    a = new C5939g(new C5920b());
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        a(context, (String) null);
    }

    public void a(Context context, String str) {
        if (this.b) {
            return;
        }
        this.b = true;
        b((context.getApplicationInfo().flags & 2) != 0);
        if (str == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                str = MzSystemUtils.getDocumentsPath(context) + "/pushSdk/" + context.getPackageName();
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName();
            }
        }
        a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str) {
        c().a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str, String str2) {
        c().a(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str, String str2, Throwable th) {
        c().a(str, str2, th);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(boolean z) {
        c().a(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public boolean a() {
        return c().a();
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void b(String str, String str2) {
        c().b(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void b(boolean z) {
        c().b(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void c(String str, String str2) {
        c().c(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void d(String str, String str2) {
        c().d(str, str2);
    }
}
