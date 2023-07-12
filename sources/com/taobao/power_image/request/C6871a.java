package com.taobao.power_image.request;

import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.power_image.request.a */
/* loaded from: classes11.dex */
public class C6871a {
    private Map<String, PowerImageBaseRequest> a;
    private WeakReference<TextureRegistry> b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.power_image.request.a$b */
    /* loaded from: classes11.dex */
    public static class C6873b {
        private static final C6871a a = new C6871a();
    }

    public static C6871a c() {
        return C6873b.a;
    }

    public List<Map<String, Object>> a(List<Map<String, Object>> list) {
        PowerImageBaseRequest powerImageTextureRequest;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                String str = (String) map.get("renderingType");
                if ("external".equals(str)) {
                    powerImageTextureRequest = new PowerImageExternalRequest(map);
                } else if ("texture".equals(str)) {
                    powerImageTextureRequest = new PowerImageTextureRequest(map, this.b.get());
                }
                this.a.put(powerImageTextureRequest.b, powerImageTextureRequest);
                boolean a = powerImageTextureRequest.a();
                Map<String, Object> b = powerImageTextureRequest.b();
                b.put("success", Boolean.valueOf(a));
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    public void b(TextureRegistry textureRegistry) {
        this.b = new WeakReference<>(textureRegistry);
    }

    public List<Map<String, Object>> d(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String str = (String) ((Map) list.get(i)).get("uniqueKey");
                PowerImageBaseRequest powerImageBaseRequest = this.a.get(str);
                if (powerImageBaseRequest != null) {
                    this.a.remove(str);
                    boolean h = powerImageBaseRequest.h();
                    Map<String, Object> b = powerImageBaseRequest.b();
                    b.put("success", Boolean.valueOf(h));
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }

    public void e(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            this.a.get((String) ((Map) list.get(i)).get("uniqueKey")).g();
        }
    }

    private C6871a() {
        this.a = new HashMap();
    }
}
