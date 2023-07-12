package com.taobao.power_image.loader;

import com.taobao.power_image.loader.PowerImageLoaderProtocol;
import java.util.HashMap;
import java.util.Map;
import tb.vt1;

/* compiled from: Taobao */
/* renamed from: com.taobao.power_image.loader.a */
/* loaded from: classes11.dex */
public class C6867a implements PowerImageLoaderProtocol {
    private final Map<String, PowerImageLoaderProtocol> a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.power_image.loader.a$b */
    /* loaded from: classes11.dex */
    private static class C6869b {
        private static final C6867a a = new C6867a();
    }

    public static C6867a a() {
        return C6869b.a;
    }

    @Override // com.taobao.power_image.loader.PowerImageLoaderProtocol
    public void handleRequest(vt1 vt1Var, PowerImageLoaderProtocol.PowerImageResponse powerImageResponse) {
        PowerImageLoaderProtocol powerImageLoaderProtocol = this.a.get(vt1Var.b);
        if (powerImageLoaderProtocol != null) {
            powerImageLoaderProtocol.handleRequest(vt1Var, powerImageResponse);
            return;
        }
        throw new IllegalStateException("PowerImageLoader for " + vt1Var.b + " has not been registered.");
    }

    private C6867a() {
        this.a = new HashMap();
    }
}
