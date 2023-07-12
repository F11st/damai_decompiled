package com.taobao.android.dinamicx.widget.recycler.expose;

import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.c */
/* loaded from: classes12.dex */
public class C6514c {
    private final RecyclerView a;
    private IExposeDistinctCallback b;
    private IExposeFilterCallback c;
    private final IExposeCallback d;
    private IExposeViewVisibleCallback e;
    private IExposeStayCallback f;
    private long g = 500;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.c$a */
    /* loaded from: classes11.dex */
    class C6515a implements IExposeViewVisibleCallback {
        final /* synthetic */ float a;

        C6515a(C6514c c6514c, float f) {
            this.a = f;
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback
        public float visiblePercent() {
            return this.a;
        }
    }

    public C6514c(RecyclerView recyclerView, IExposeCallback iExposeCallback) {
        this.a = recyclerView;
        this.d = iExposeCallback;
    }

    public C6513b a() {
        return new C6513b(this.a, this);
    }

    public C6514c b(IExposeDistinctCallback iExposeDistinctCallback) {
        this.b = iExposeDistinctCallback;
        return this;
    }

    public C6514c c(IExposeStayCallback iExposeStayCallback) {
        this.f = iExposeStayCallback;
        return this;
    }

    public C6514c d(IExposeFilterCallback iExposeFilterCallback) {
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

    public C6514c k(float f) {
        this.e = new C6515a(this, f);
        return this;
    }

    public C6514c l(long j) {
        this.g = j;
        return this;
    }
}
