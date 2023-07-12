package com.taobao.phenix.loader.file;

import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import tb.h62;
import tb.ne0;
import tb.oe0;
import tb.op0;
import tb.p22;
import tb.xt2;
import tb.yg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b extends BaseChainProducer<oe0, oe0, com.taobao.phenix.request.a> {
    private final FileLoader j;

    public b(FileLoader fileLoader) {
        super(1, 0);
        this.j = fileLoader;
    }

    private ne0 H(Consumer<oe0, com.taobao.phenix.request.a> consumer, boolean z, h62 h62Var, String str) throws Exception {
        com.taobao.phenix.request.a context = consumer.getContext();
        p22 load = this.j.load(h62Var, str, context.H());
        if (context.i()) {
            xt2.q("LocalFile", context, "Request is cancelled before reading file", new Object[0]);
            consumer.onCancellation();
            load.release();
            return null;
        }
        yg2 yg2Var = new yg2(consumer, load.b, z ? 0 : context.R());
        ne0 c = ne0.c(load, yg2Var);
        if (yg2Var.d()) {
            return null;
        }
        return c;
    }

    @Override // tb.jh
    protected boolean a(Consumer<oe0, com.taobao.phenix.request.a> consumer) {
        String str;
        boolean z;
        com.taobao.phenix.request.a context = consumer.getContext();
        com.taobao.phenix.request.b G = context.G();
        com.taobao.phenix.request.b T = context.T();
        h62 l = G.l();
        char c = l.a() ? (char) 1 : (T == null || !T.l().a()) ? (char) 0 : (char) 2;
        if (c == 0) {
            return false;
        }
        ne0 ne0Var = null;
        String k = G.k();
        o(consumer);
        xt2.n("Phenix", "LocalImage started.", context);
        if (c != 1) {
            if (c == 2) {
                try {
                    k = T.k();
                    ne0Var = H(consumer, true, T.l(), k);
                    consumer.getContext().x();
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(ne0Var != null && ne0Var.a());
                    xt2.l("LocalFile", k, "load file(secondary) result=%B", objArr);
                } catch (Exception e) {
                    xt2.p("LocalFile", k, "load file(secondary) error=%s", e);
                }
            }
            str = k;
            z = false;
        } else {
            try {
                ne0Var = H(consumer, false, l, k);
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(ne0Var != null && ne0Var.a());
                xt2.l("LocalFile", k, "load file result=%B", objArr2);
            } catch (Exception e2) {
                xt2.p("LocalFile", k, "load file error=%s", e2);
                consumer.onFailure(e2);
            }
            str = k;
            z = true;
        }
        n(consumer, z);
        xt2.n("Phenix", "LocalImage Finished.", context);
        if (ne0Var != null) {
            if (z) {
                context.U().A(ne0Var.b);
                context.U().x = ne0Var.b;
                op0.j(context.U());
            }
            oe0 oe0Var = new oe0(ne0Var, str, 1, true, G.i());
            oe0Var.p = c == 2;
            consumer.onNewResult(oe0Var, z);
        }
        return z;
    }
}
