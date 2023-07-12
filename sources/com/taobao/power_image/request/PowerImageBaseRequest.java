package com.taobao.power_image.request;

import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import com.taobao.power_image.loader.C6867a;
import com.taobao.power_image.loader.PowerImageLoaderProtocol;
import com.taobao.power_image.loader.PowerImageResult;
import java.util.HashMap;
import java.util.Map;
import tb.ut1;
import tb.vt1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class PowerImageBaseRequest {
    public static final String RENDER_TYPE_EXTERNAL = "external";
    public static final String RENDER_TYPE_TEXTURE = "texture";
    private vt1 a;
    String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.power_image.request.PowerImageBaseRequest$a */
    /* loaded from: classes11.dex */
    public class C6870a implements PowerImageLoaderProtocol.PowerImageResponse {
        C6870a() {
        }

        @Override // com.taobao.power_image.loader.PowerImageLoaderProtocol.PowerImageResponse
        public void onResult(PowerImageResult powerImageResult) {
            PowerImageBaseRequest.this.d(powerImageResult);
        }
    }

    public PowerImageBaseRequest(Map<String, Object> map) {
        this.b = (String) map.get("uniqueKey");
        this.a = vt1.a(map);
    }

    private void f() {
        C6867a.a().handleRequest(this.a, new C6870a());
    }

    public boolean a() {
        boolean z = this.a != null;
        this.c = z ? "initializeSucceed" : "initializeFailed";
        return z;
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("uniqueKey", this.b);
        hashMap.put("state", this.c);
        return hashMap;
    }

    public void c(final String str) {
        PowerImageDispatcher.c().e(new Runnable() { // from class: com.taobao.power_image.request.PowerImageBaseRequest.3
            @Override // java.lang.Runnable
            public void run() {
                PowerImageBaseRequest powerImageBaseRequest = PowerImageBaseRequest.this;
                powerImageBaseRequest.c = "loadFailed";
                Map<String, Object> b = powerImageBaseRequest.b();
                String str2 = str;
                if (str2 == null) {
                    str2 = "failed!";
                }
                b.put("errMsg", str2);
                ut1.C9791b.a().b(b, false);
            }
        });
    }

    abstract void d(PowerImageResult powerImageResult);

    public void e() {
        PowerImageDispatcher.c().e(new Runnable() { // from class: com.taobao.power_image.request.PowerImageBaseRequest.2
            @Override // java.lang.Runnable
            public void run() {
                PowerImageBaseRequest.this.c = "loadSucceed";
                ut1.C9791b.a().b(PowerImageBaseRequest.this.b(), true);
            }
        });
    }

    public boolean g() {
        if (("initializeSucceed".equals(this.c) || "loadFailed".equals(this.c)) && this.a != null) {
            f();
            return true;
        }
        return false;
    }

    public boolean h() {
        return false;
    }
}
