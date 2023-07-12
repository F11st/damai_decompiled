package com.taobao.android.dinamic;

import com.taobao.android.dinamic.dinamic.DinamicAppMonitor;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamic.expression.parser.C6324a;
import com.taobao.android.dinamic.tempate.manager.TemplateCache;
import tb.v0;
import tb.w0;
import tb.w80;
import tb.x0;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.a */
/* loaded from: classes12.dex */
public class C6312a {
    private static final C6312a e = new C6312a();
    private TemplateCache.HttpLoader a;
    private x0 b;
    private w80 c;
    private DinamicAppMonitor d;

    public static C6312a h() {
        return e;
    }

    public DinamicAppMonitor a() {
        return this.d;
    }

    public TemplateCache.HttpLoader b() {
        return this.a;
    }

    public x0 c() {
        return this.b;
    }

    public w80 d() {
        return this.c;
    }

    public void e(String str, v0 v0Var) throws DinamicException {
        C6324a.c(str, v0Var);
    }

    public void f(String str, w0 w0Var) throws DinamicException {
        DinamicViewHelper.registerEventHandler(str, w0Var);
    }

    public void g(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        DinamicViewHelper.registerViewConstructor(str, dinamicViewAdvancedConstructor);
    }
}
