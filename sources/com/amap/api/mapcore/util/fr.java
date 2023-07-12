package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fr extends ContextThemeWrapper {
    private static final String[] d = {"android.widget", "android.webkit", "android.app"};
    private Resources a;
    private LayoutInflater b;
    private ClassLoader c;
    private a e;
    private LayoutInflater.Factory f;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a {
        public HashSet<String> a = new HashSet<>();
        public HashMap<String, Constructor<?>> b = new HashMap<>();

        public a() {
        }
    }

    public fr(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.e = new a();
        this.f = new LayoutInflater.Factory() { // from class: com.amap.api.mapcore.util.fr.1
            @Override // android.view.LayoutInflater.Factory
            public View onCreateView(String str, Context context2, AttributeSet attributeSet) {
                return fr.this.a(str, context2, attributeSet);
            }
        };
        this.a = fs.a();
        this.c = classLoader;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.b == null) {
                LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
                if (layoutInflater != null) {
                    this.b = layoutInflater.cloneInContext(this);
                }
                this.b.setFactory(this.f);
                this.b = this.b.cloneInContext(this);
            }
            return this.b;
        }
        return super.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View a(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            com.amap.api.mapcore.util.fr$a r0 = r11.e
            java.util.HashSet<java.lang.String> r0 = r0.a
            boolean r0 = r0.contains(r12)
            r1 = 0
            if (r0 == 0) goto Lc
            return r1
        Lc:
            com.amap.api.mapcore.util.fr$a r0 = r11.e
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.b
            java.lang.Object r0 = r0.get(r12)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L87
            java.lang.String r5 = "api.navi"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> L64
            if (r5 == 0) goto L2a
            java.lang.ClassLoader r5 = r11.c     // Catch: java.lang.Throwable -> L64
            java.lang.Class r5 = r5.loadClass(r12)     // Catch: java.lang.Throwable -> L64
            goto L51
        L2a:
            java.lang.String[] r5 = com.amap.api.mapcore.util.fr.d     // Catch: java.lang.Throwable -> L64
            int r6 = r5.length     // Catch: java.lang.Throwable -> L64
            r7 = 0
        L2e:
            if (r7 >= r6) goto L50
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L64
            java.lang.ClassLoader r9 = r11.c     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r10.<init>()     // Catch: java.lang.Throwable -> L4d
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "."
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            r10.append(r12)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.Class r5 = r9.loadClass(r8)     // Catch: java.lang.Throwable -> L4d
            goto L51
        L4d:
            int r7 = r7 + 1
            goto L2e
        L50:
            r5 = r1
        L51:
            if (r5 != 0) goto L54
            goto L61
        L54:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 != r6) goto L59
            goto L61
        L59:
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L65
            java.lang.ClassLoader r7 = r11.c     // Catch: java.lang.Throwable -> L65
            if (r6 == r7) goto L62
        L61:
            goto L65
        L62:
            r6 = 1
            goto L66
        L64:
            r5 = r1
        L65:
            r6 = 0
        L66:
            if (r6 != 0) goto L70
            com.amap.api.mapcore.util.fr$a r13 = r11.e
            java.util.HashSet<java.lang.String> r13 = r13.a
            r13.add(r12)
            return r1
        L70:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L86
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L86
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> L86
            java.lang.reflect.Constructor r0 = r5.getConstructor(r6)     // Catch: java.lang.Throwable -> L86
            com.amap.api.mapcore.util.fr$a r5 = r11.e     // Catch: java.lang.Throwable -> L86
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r5 = r5.b     // Catch: java.lang.Throwable -> L86
            r5.put(r12, r0)     // Catch: java.lang.Throwable -> L86
            goto L87
        L86:
        L87:
            if (r0 == 0) goto L97
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L97
            r12[r4] = r13     // Catch: java.lang.Throwable -> L97
            r12[r3] = r14     // Catch: java.lang.Throwable -> L97
            java.lang.Object r12 = r0.newInstance(r12)     // Catch: java.lang.Throwable -> L97
            android.view.View r12 = (android.view.View) r12     // Catch: java.lang.Throwable -> L97
            r1 = r12
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fr.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}
