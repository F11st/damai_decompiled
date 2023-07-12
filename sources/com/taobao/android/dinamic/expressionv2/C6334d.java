package com.taobao.android.dinamic.expressionv2;

import android.view.View;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expression.parser.C6324a;
import com.taobao.android.dinamic.expression.parser.DinamicDataParser;
import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.List;
import tb.a90;
import tb.m80;
import tb.v80;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expressionv2.d */
/* loaded from: classes11.dex */
public class C6334d extends DinamicASTNode {
    private List e;

    public C6334d() {
        this.a = DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod;
    }

    @Override // com.taobao.android.dinamic.expressionv2.DinamicASTNode
    public Object c() {
        ArrayList arrayList = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            Object c = this.b.get(i).c();
            if (c != null) {
                arrayList.add(c);
            } else {
                arrayList.add(m80.NL);
            }
        }
        String str = this.d;
        DinamicDataParser b = str != null ? C6324a.b(str) : null;
        DinamicLog.h("MethodName:" + this.d);
        if (b != null) {
            try {
                DinamicLog.h("args:" + arrayList.toString());
                return b.evalWithArgs(arrayList, (v80) this.c);
            } catch (Throwable th) {
                DinamicLog.i("DinamicExpresstion", th, "parse express failed, parser=", b.getClass().getName());
                return null;
            }
        }
        return null;
    }

    public void d() {
        this.e = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.e.add(this.b.get(i).c());
        }
    }

    public List e() {
        return this.e;
    }

    public void f(View view) {
        DinamicLog.j("DinamicExpression handleEvent", new String[0]);
        if (this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.b.get(i).c());
        }
        String str = this.d;
        DinamicEventHandler b = str != null ? C6313b.b(str) : null;
        if (b != null) {
            try {
                v80 v80Var = (v80) this.c;
                b.handleEvent(view, v80Var.c(), arrayList, v80Var.d(), v80Var.b(), (ArrayList) view.getTag(a90.VIEW_PARAMS));
            } catch (Throwable th) {
                DinamicLog.i("DinamicExpression", th, "parse express failed, parser=", b.getClass().getName());
            }
        }
    }
}
