package com.taobao.android.dinamic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.parser.DinamicParser;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.view.CompatibleView;
import com.taobao.android.dinamic.view.DFrameLayout;
import com.taobao.android.dinamic.view.DLinearLayout;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import tb.a90;
import tb.e90;
import tb.iy2;
import tb.m80;
import tb.oq;
import tb.p80;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DViewGenerator {
    public static final String TAG = "DViewGenerator";
    private String a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.DViewGenerator$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ iy2 val$result;

        AnonymousClass1(iy2 iy2Var, long j) {
            this.val$result = iy2Var;
            this.val$consumingTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "createView template=" + this.val$result.c() + "consumimg=" + (this.val$consumingTime / 1000000.0d));
            }
            C6312a.h().d();
            String unused = DViewGenerator.this.a;
            this.val$result.c();
            this.val$result.f();
            if (!this.val$result.f()) {
                this.val$result.b();
            }
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.DViewGenerator$2  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ iy2 val$result;

        AnonymousClass2(iy2 iy2Var, long j) {
            this.val$result = iy2Var;
            this.val$consumingTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "bindData template=" + this.val$result.c() + "consuming=" + (this.val$consumingTime / 1000000.0d));
            }
            C6312a.h().d();
            String unused = DViewGenerator.this.a;
            this.val$result.c();
            this.val$result.e();
            if (!this.val$result.e()) {
                this.val$result.b();
            }
            throw null;
        }
    }

    public DViewGenerator(String str) {
        this.a = "default";
        new ArrayDeque(16);
        this.a = str;
    }

    private void b(DinamicTemplate dinamicTemplate) {
        C6312a.h().c();
    }

    private void c(DinamicTemplate dinamicTemplate) {
        C6312a.h().c();
    }

    private iy2 e(v80 v80Var) {
        long nanoTime = System.nanoTime();
        iy2 e = v80Var.e();
        Iterator<View> it = e.a().iterator();
        while (it.hasNext()) {
            View next = it.next();
            try {
                C6314c.a(next, v80Var);
            } catch (Throwable unused) {
                p80 b = e.b();
                b.a("other", next.getClass() + "bind data failed;");
            }
        }
        m(e, System.nanoTime() - nanoTime);
        return e;
    }

    private iy2 g(View view, Object obj, boolean z, Object obj2) {
        if (view != null && obj != null) {
            int i = a90.TAG_ROOT_VIEW_RESULT;
            iy2 iy2Var = (iy2) view.getTag(i);
            if (iy2Var == null) {
                View findViewWithTag = view.findViewWithTag("dinamicRootView");
                if (findViewWithTag == null) {
                    iy2 iy2Var2 = new iy2(this.a);
                    iy2Var2.b().a("other", "binddata rootView or data is null");
                    return iy2Var2;
                }
                iy2Var = (iy2) findViewWithTag.getTag(i);
                if (iy2Var == null) {
                    iy2 iy2Var3 = new iy2(this.a);
                    iy2Var3.b().a("other", "binddata rootView or data is null");
                    return iy2Var3;
                }
            }
            b(iy2Var.c());
            v80.C9812b c9812b = new v80.C9812b();
            c9812b.h(obj2);
            c9812b.i(this.a);
            c9812b.k(iy2Var);
            c9812b.j(obj);
            c9812b.g(obj);
            return e(c9812b.f());
        }
        iy2 iy2Var4 = new iy2(this.a);
        iy2Var4.b().a("other", "binddata rootView or data is null");
        return iy2Var4;
    }

    private void h(Context context, View view, View view2, iy2 iy2Var, v80 v80Var) {
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            View a = e90.a(context, childAt, iy2Var, v80Var);
            if (a != null) {
                ((ViewGroup) view2).addView(a, childAt.getLayoutParams());
                if (l(childAt)) {
                    h(context, childAt, a, iy2Var, v80Var);
                }
            }
        }
    }

    private boolean l(View view) {
        if (m80.DONOT_NEED_BIND_CHILD.equals(view.getTag()) || (view instanceof DLoopLinearLayout)) {
            return false;
        }
        return (view instanceof DLinearLayout) || (view instanceof DFrameLayout);
    }

    private void m(iy2 iy2Var, long j) {
        C6312a.h().d();
    }

    private void n(iy2 iy2Var, long j) {
        C6312a.h().d();
    }

    public static DViewGenerator o(String str) {
        if (TextUtils.isEmpty(str)) {
            return C6313b.c("default").a;
        }
        return C6313b.c(str).a;
    }

    public iy2 d(View view, Object obj, Object obj2) {
        return g(view, obj, false, obj2);
    }

    public void f(ArrayList<View> arrayList, v80 v80Var) {
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            try {
                C6314c.a(next, v80Var);
            } catch (Throwable unused) {
                p80 b = v80Var.e().b();
                b.a("other", next.getClass() + "bind data failed;");
            }
        }
    }

    public iy2 i(View view, Context context, v80 v80Var) {
        iy2 iy2Var = new iy2(this.a);
        iy2Var.g(new ArrayList<>(20));
        View a = e90.a(context, view, iy2Var, v80Var);
        if (a == null) {
            iy2Var.i(null);
            return iy2Var;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            a.setLayoutParams(layoutParams);
        }
        if (!(view instanceof ViewGroup)) {
            iy2Var.i(a);
            return iy2Var;
        }
        h(context, view, a, iy2Var, v80Var);
        iy2Var.i(a);
        return iy2Var;
    }

    public iy2 j(Context context, ViewGroup viewGroup, DinamicTemplate dinamicTemplate) {
        return k(context, viewGroup, dinamicTemplate, null);
    }

    public iy2 k(Context context, ViewGroup viewGroup, DinamicTemplate dinamicTemplate, Object obj) {
        long nanoTime = System.nanoTime();
        if (context != null && dinamicTemplate != null && dinamicTemplate.checkValid()) {
            c(dinamicTemplate);
            iy2 iy2Var = new iy2(this.a);
            XmlPullParser a = DinamicParser.a(this.a, dinamicTemplate, iy2Var);
            long nanoTime2 = System.nanoTime();
            if (a != null) {
                try {
                    iy2Var.h(dinamicTemplate);
                    iy2Var.g(new ArrayList<>(20));
                    v80.C9812b c9812b = new v80.C9812b();
                    c9812b.k(iy2Var);
                    c9812b.i(this.a);
                    c9812b.h(obj);
                    View inflate = C6322d.b(context, c9812b.f()).inflate(a, (ViewGroup) null);
                    if (inflate instanceof CompatibleView) {
                        n(iy2Var, System.nanoTime() - nanoTime2);
                        return iy2Var;
                    }
                    oq.c(inflate, viewGroup);
                    x80 x80Var = (x80) inflate.getTag(a90.PROPERTY_KEY);
                    Object obj2 = x80Var.b.get(m80.c);
                    Object obj3 = x80Var.b.get(m80.d);
                    if (obj2 != null) {
                        dinamicTemplate.setCompilerVersion(String.valueOf(obj2));
                    } else {
                        dinamicTemplate.setCompilerVersion(m80.b);
                    }
                    if (obj3 != null) {
                        dinamicTemplate.setInterpreterVersion(String.valueOf(obj3));
                    } else {
                        dinamicTemplate.setInterpreterVersion(m80.b);
                    }
                    inflate.setTag("dinamicRootView");
                    inflate.setTag(a90.TAG_ROOT_VIEW_RESULT, iy2Var);
                    iy2Var.i(inflate);
                    n(iy2Var, System.nanoTime() - nanoTime2);
                    return iy2Var;
                } catch (Throwable th) {
                    iy2Var.h(dinamicTemplate);
                    iy2Var.b().a("other", "inflateViewFailed");
                    DinamicLog.b(TAG, this.a + "infalte dinamic view failed", th);
                    n(iy2Var, System.nanoTime() - nanoTime2);
                    return iy2Var;
                }
            }
            iy2Var.h(dinamicTemplate);
            iy2Var.b().a(p80.ERROR_CODE_TEMPLATE_NOT_FOUND, dinamicTemplate.toString());
            n(iy2Var, System.nanoTime() - nanoTime2);
            return iy2Var;
        }
        iy2 iy2Var2 = new iy2(this.a);
        iy2Var2.i(null);
        iy2Var2.h(dinamicTemplate);
        iy2Var2.b().a(p80.ERROR_CODE_TEMPLATE_INFO_ERROR, dinamicTemplate != null ? dinamicTemplate.toString() : "context=null or exactTemplate=null");
        n(iy2Var2, System.nanoTime() - nanoTime);
        return iy2Var2;
    }
}
