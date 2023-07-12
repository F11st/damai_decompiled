package com.taobao.android.dinamic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.view.CompatibleView;
import tb.e90;
import tb.p80;
import tb.v80;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.d */
/* loaded from: classes12.dex */
public class C6322d extends LayoutInflater {
    private v80 a;

    protected C6322d(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }

    private CompatibleView a(String str, String str2) {
        Context context = getContext();
        return new CompatibleView(context, str2 + str);
    }

    public static C6322d b(Context context, v80 v80Var) {
        C6322d c6322d = new C6322d(LayoutInflater.from(context), context);
        c6322d.c(v80Var);
        return c6322d;
    }

    public void c(v80 v80Var) {
        this.a = v80Var;
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return LayoutInflater.from(context);
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        if (C6313b.d(str) != null) {
            try {
                return e90.b(str, getContext(), attributeSet, this.a);
            } catch (Throwable th) {
                this.a.e().b().a(p80.ERROR_CODE_VIEW_EXCEPTION, str);
                DinamicLog.c("DinamicInflater", th, "onCreateView failed");
                return a(p80.ERROR_CODE_VIEW_EXCEPTION, str);
            }
        }
        this.a.e().b().a(p80.ERROR_CODE_VIEW_NOT_FOUND, str);
        return a(p80.ERROR_CODE_VIEW_NOT_FOUND, str);
    }
}
