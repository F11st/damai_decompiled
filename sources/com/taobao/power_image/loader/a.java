package com.taobao.power_image.loader;

import com.taobao.power_image.loader.PowerImageLoaderProtocol;
import java.util.HashMap;
import java.util.Map;
import tb.vt1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements PowerImageLoaderProtocol {
    private final Map<String, PowerImageLoaderProtocol> a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        private static final a a = new a();
    }

    public static a a() {
        return b.a;
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

    private a() {
        this.a = new HashMap();
    }
}
