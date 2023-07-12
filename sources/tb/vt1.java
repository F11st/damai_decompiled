package tb;

import android.content.res.Resources;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vt1 {
    public static final String RENDERING_TYPE_EXTERNAL = "external";
    public static final String RENDERING_TYPE_TEXTURE = "texture";
    public Map<String, Object> a;
    public String b;

    public static vt1 a(Map<String, Object> map) {
        Map<String, Object> map2 = (Map) map.get("src");
        String str = (String) map.get("imageType");
        String str2 = (String) map.get("renderingType");
        if (map.get("width") instanceof Double) {
            ((Double) map.get("width")).doubleValue();
        }
        if (map.get("height") instanceof Double) {
            ((Double) map.get("height")).doubleValue();
        }
        float f = Resources.getSystem().getDisplayMetrics().density;
        vt1 vt1Var = new vt1();
        vt1Var.a = map2;
        vt1Var.b = str;
        return vt1Var;
    }
}
