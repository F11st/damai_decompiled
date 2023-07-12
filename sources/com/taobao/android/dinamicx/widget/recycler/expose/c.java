package com.taobao.android.dinamicx.widget.recycler.expose;

import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c {
    private final RecyclerView a;
    private IExposeDistinctCallback b;
    private IExposeFilterCallback c;
    private final IExposeCallback d;
    private IExposeViewVisibleCallback e;
    private IExposeStayCallback f;
    private long g = 500;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements IExposeViewVisibleCallback {
        final /* synthetic */ float a;

        a(c cVar, float f) {
            this.a = f;
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback
        public float visiblePercent() {
            return this.a;
        }
    }

    public c(RecyclerView recyclerView, IExposeCallback iExposeCallback) {
        this.a = recyclerView;
        this.d = iExposeCallback;
    }

    public b a() {
        return new b(this.a, this);
    }

    public c b(IExposeDistinctCallback iExposeDistinctCallback) {
        this.b = iExposeDistinctCallback;
        return this;
    }

    public c c(IExposeStayCallback iExposeStayCallback) {
        this.f = iExposeStayCallback;
        return this;
    }

    public c d(IExposeFilterCallback iExposeFilterCallback) {
        this.c = iExposeFilterCallback;
        return this;
    }

    public long e() {
        return this.g;
    }

    public IExposeDistinctCallback f() {
        return this.b;
    }

    public IExposeCallback g() {
        return this.d;
    }

    public IExposeFilterCallback h() {
        return this.c;
    }

    public IExposeStayCallback i() {
        return this.f;
    }

    public IExposeViewVisibleCallback j() {
        return this.e;
    }

    public c k(float f) {
        this.e = new a(this, f);
        return this;
    }

    public c l(long j) {
        this.g = j;
        return this;
    }
}
