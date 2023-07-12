package com.taobao.android.dinamic.expression.parser;

import com.taobao.android.dinamicx.C6366c;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXFontSize;
import java.util.List;
import tb.v0;
import tb.v80;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expression.parser.b */
/* loaded from: classes11.dex */
class C6325b extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list != null && list.size() != 0) {
            if (C6366c.f() && list.size() == 1 && list.get(0) != null) {
                return String.valueOf(z00.m(DinamicXEngine.i(), C6366c.c(z00.j(DinamicXEngine.i(), String.valueOf(list.get(0)), 0))));
            }
            DXFontSize b = DXFontSize.b();
            if (list.size() == 1 && (list.get(0) instanceof Number)) {
                return b.c((Double) list.get(0));
            }
            if (list.size() == 2 && (list.get(0) instanceof Number) && (list.get(1) instanceof Number)) {
                return b.d((Double) list.get(0), (Double) list.get(1));
            }
            if (list.size() == 5 && (list.get(0) instanceof Number) && (list.get(1) instanceof Number) && (list.get(2) instanceof Number) && (list.get(3) instanceof Number) && (list.get(4) instanceof Number)) {
                return b.e((Double) list.get(0), (Double) list.get(1), (Double) list.get(2), (Double) list.get(3), (Double) list.get(4));
            }
            if (list.size() == 1 && list.get(0) != null) {
                return b.f(String.valueOf(list.get(0)));
            }
            if (list.size() == 2 && list.get(0) != null && list.get(1) != null) {
                return b.g(String.valueOf(list.get(0)), String.valueOf(list.get(1)));
            }
            if (list.size() == 5) {
                return b.h(String.valueOf(list.get(0)), String.valueOf(list.get(1)), String.valueOf(list.get(2)), String.valueOf(list.get(3)), String.valueOf(list.get(4)));
            }
        }
        return null;
    }
}
