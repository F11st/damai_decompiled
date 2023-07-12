package tb;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import io.flutter.wpkbridge.WPKFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class bq0 implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    private final Context a;
    @NotNull
    private final Map<String, List<ns0>> b;

    public bq0(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = new LinkedHashMap();
    }

    private final void a(ns0 ns0Var) {
        List<ns0> list = this.b.get(ns0Var.a());
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(ns0Var.a(), list);
        }
        list.add(ns0Var);
    }

    private final ns0 b(byte[] bArr, String str, String str2) {
        JSONObject c = eq0.INSTANCE.c(bArr);
        String string = c.getString("layer");
        if (string != null) {
            String string2 = c.getString("css");
            String str3 = string2 == null ? "" : string2;
            String string3 = c.getString("databinding");
            String str4 = string3 == null ? "" : string3;
            String string4 = c.getString("js");
            return new ns0(str2, str, -1, string, str3, str4, string4 == null ? "" : string4);
        }
        throw new IllegalArgumentException("Layer mustn't empty, templateBiz = " + str + ", templateId = " + str2);
    }

    private final ns0 c(String str, String str2) {
        List<ns0> list = this.b.get(str);
        Object obj = null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (b41.d(((ns0) obj2).d(), str2)) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int h = ((ns0) obj).h();
                do {
                    Object next = it.next();
                    int h2 = ((ns0) next).h();
                    if (h < h2) {
                        obj = next;
                        h = h2;
                    }
                } while (it.hasNext());
            }
        }
        return (ns0) obj;
    }

    private final byte[] d(GXTemplateEngine.C3347i c3347i) {
        AssetManager assets;
        try {
            String b = c3347i.b();
            if (b.length() == 0) {
                b = c3347i.a();
            }
            Resources resources = this.a.getResources();
            if (resources != null && (assets = resources.getAssets()) != null) {
                InputStream open = assets.open(b + r10.DIR + c3347i.d());
                if (open == null) {
                    return null;
                }
                byte[] c = oe.c(open);
                xj.a(open, null);
                return c;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public ns0 getTemplate(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "gxTemplateItem");
        ns0 c = c(c3347i.a(), c3347i.d());
        if (c != null) {
            return c;
        }
        byte[] d = d(c3347i);
        if (d != null) {
            ns0 b = b(d, c3347i.a(), c3347i.d());
            b.i("assets_binary");
            a(b);
            return c(c3347i.a(), c3347i.d());
        }
        return null;
    }
}
