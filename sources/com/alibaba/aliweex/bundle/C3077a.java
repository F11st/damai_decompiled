package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.view.View;
import com.alibaba.aliweex.bundle.WeexPageContract;
import tb.lz2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.bundle.a */
/* loaded from: classes5.dex */
public class C3077a implements WeexPageContract.IErrorView {
    private lz2 a;
    private WeexPageContract.IRenderPresenter b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.bundle.a$a */
    /* loaded from: classes15.dex */
    class View$OnClickListenerC3078a implements View.OnClickListener {
        View$OnClickListenerC3078a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3077a.this.b != null) {
                C3077a.this.b.reload();
            }
            C3077a.this.showErrorView(false, null);
        }
    }

    public C3077a(WeexPageContract.IRenderPresenter iRenderPresenter) {
        this.b = iRenderPresenter;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void createErrorView(Context context, View view) {
        if (this.a != null || view == null) {
            return;
        }
        lz2 lz2Var = new lz2(context, view);
        this.a = lz2Var;
        lz2Var.d();
        this.a.f(new View$OnClickListenerC3078a());
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void destroy() {
        lz2 lz2Var = this.a;
        if (lz2Var != null) {
            lz2Var.b();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void showErrorView(boolean z, String str) {
        lz2 lz2Var = this.a;
        if (lz2Var != null) {
            if (z) {
                lz2Var.g(str);
            } else {
                lz2Var.d();
            }
        }
    }
}
