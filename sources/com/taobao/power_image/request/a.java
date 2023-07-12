package com.taobao.power_image.request;

import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    private Map<String, PowerImageBaseRequest> a;
    private WeakReference<TextureRegistry> b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static final a a = new a();
    }

    public static a c() {
        return b.a;
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
                Map<String, Object> b2 = powerImageTextureRequest.b();
                b2.put("success", Boolean.valueOf(a));
                arrayList.add(b2);
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
                    Map<String, Object> b2 = powerImageBaseRequest.b();
                    b2.put("success", Boolean.valueOf(h));
                    arrayList.add(b2);
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

    private a() {
        this.a = new HashMap();
    }
}
