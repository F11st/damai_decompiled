package tb;

import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class cq0 implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    private final Context context;
    @NotNull
    private final Map<String, List<ns0>> templateCache;

    public cq0(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
        this.templateCache = new LinkedHashMap();
    }

    private final void addToCache(ns0 ns0Var) {
        List<ns0> list = this.templateCache.get(ns0Var.a());
        if (list == null) {
            list = new ArrayList<>();
            this.templateCache.put(ns0Var.a(), list);
        }
        list.add(ns0Var);
    }

    private final ns0 getFromCache(String str, String str2) {
        List<ns0> list = this.templateCache.get(str);
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0045, blocks: (B:3:0x0001, B:20:0x0039, B:6:0x000d, B:9:0x0014, B:12:0x001b, B:14:0x0028, B:15:0x002b, B:19:0x0035), top: B:29:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String readFileFromAssets(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = r3.getContext()     // Catch: java.lang.Exception -> L45
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L45
            if (r1 != 0) goto Ld
        Lb:
            r2 = r0
            goto L31
        Ld:
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Exception -> L45
            if (r1 != 0) goto L14
            goto Lb
        L14:
            java.io.InputStream r4 = r1.open(r4)     // Catch: java.lang.Exception -> L45
            if (r4 != 0) goto L1b
            goto Lb
        L1b:
            java.nio.charset.Charset r1 = tb.hi.UTF_8     // Catch: java.lang.Exception -> L45
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L45
            r2.<init>(r4, r1)     // Catch: java.lang.Exception -> L45
            r4 = 8192(0x2000, float:1.148E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L2b
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch: java.lang.Exception -> L45
            goto L31
        L2b:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L45
            r1.<init>(r2, r4)     // Catch: java.lang.Exception -> L45
            r2 = r1
        L31:
            if (r2 != 0) goto L35
            r4 = r0
            goto L39
        L35:
            java.lang.String r4 = tb.fm2.c(r2)     // Catch: java.lang.Throwable -> L3e
        L39:
            tb.xj.a(r2, r0)     // Catch: java.lang.Exception -> L45
            r0 = r4
            goto L45
        L3e:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L40
        L40:
            r1 = move-exception
            tb.xj.a(r2, r4)     // Catch: java.lang.Exception -> L45
            throw r1     // Catch: java.lang.Exception -> L45
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.cq0.readFileFromAssets(java.lang.String):java.lang.String");
    }

    @NotNull
    public Context getContext() {
        return this.context;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public ns0 getTemplate(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "gxTemplateItem");
        ns0 fromCache = getFromCache(iVar.a(), iVar.d());
        if (fromCache != null) {
            return fromCache;
        }
        String b = iVar.b();
        if (b.length() == 0) {
            b = iVar.a();
        }
        String str = b + r10.DIR + iVar.d() + "/index.json";
        String str2 = b + r10.DIR + iVar.d() + "/index.css";
        String str3 = b + r10.DIR + iVar.d() + "/index.databinding";
        String readFileFromAssets = readFileFromAssets(str);
        String readFileFromAssets2 = readFileFromAssets(str2);
        String readFileFromAssets3 = readFileFromAssets(str3);
        String readFileFromAssets4 = readFileFromAssets(b + r10.DIR + iVar.d() + "/index.js");
        if (readFileFromAssets != null) {
            ns0 ns0Var = new ns0(iVar.d(), iVar.a(), -1, readFileFromAssets, readFileFromAssets2 == null ? "" : readFileFromAssets2, readFileFromAssets3 == null ? "" : readFileFromAssets3, readFileFromAssets4 == null ? "" : readFileFromAssets4);
            ns0Var.i("assets");
            addToCache(ns0Var);
            return ns0Var;
        }
        return null;
    }
}
