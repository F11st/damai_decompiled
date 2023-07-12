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
/* loaded from: classes12.dex */
public class d extends LayoutInflater {
    private v80 a;

    protected d(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }

    private CompatibleView a(String str, String str2) {
        Context context = getContext();
        return new CompatibleView(context, str2 + str);
    }

    public static d b(Context context, v80 v80Var) {
        d dVar = new d(LayoutInflater.from(context), context);
        dVar.c(v80Var);
        return dVar;
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
        if (b.d(str) != null) {
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
