package com.taobao.android.dinamicx.widget.recycler.expose;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.b */
/* loaded from: classes12.dex */
public class C6513b {
    private final RecyclerView a;
    private final IExposeViewVisibleCallback b;
    private final IExposeStayCallback c;
    private final long d;
    private ExposeScrollerListener e;
    private ExposeChildAttachListener f;
    private boolean g;
    private List<Object> h;
    private final C6511a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6513b(@NonNull RecyclerView recyclerView, @NonNull C6514c c6514c) {
        this.a = recyclerView;
        this.c = c6514c.i();
        this.b = c6514c.j();
        this.d = c6514c.e();
        this.i = new C6511a(recyclerView, c6514c);
    }

    public void a() {
        ExposeChildAttachListener exposeChildAttachListener;
        if (this.g && (exposeChildAttachListener = this.f) != null) {
            exposeChildAttachListener.b();
        }
    }

    public void b() {
        if (this.g) {
            return;
        }
        this.g = true;
        C6511a c6511a = this.i;
        if (c6511a != null) {
            c6511a.g();
        }
        IExposeStayCallback iExposeStayCallback = this.c;
        if (iExposeStayCallback != null) {
            ExposeChildAttachListener exposeChildAttachListener = new ExposeChildAttachListener(this.a, iExposeStayCallback, this.b, this.d);
            this.f = exposeChildAttachListener;
            ExposeScrollerListener exposeScrollerListener = new ExposeScrollerListener(exposeChildAttachListener);
            this.e = exposeScrollerListener;
            this.a.addOnScrollListener(exposeScrollerListener);
            this.a.addOnChildAttachStateChangeListener(this.f);
        }
    }

    public void c() {
        if (this.g) {
            this.g = false;
            ExposeChildAttachListener exposeChildAttachListener = this.f;
            if (exposeChildAttachListener != null) {
                exposeChildAttachListener.c();
                this.a.removeOnChildAttachStateChangeListener(this.f);
            }
            ExposeScrollerListener exposeScrollerListener = this.e;
            if (exposeScrollerListener != null) {
                this.a.removeOnScrollListener(exposeScrollerListener);
            }
            if (this.h != null) {
                this.h = null;
            }
            C6511a c6511a = this.i;
            if (c6511a != null) {
                c6511a.h();
            }
        }
    }

    public void d() {
        C6511a c6511a = this.i;
        if (c6511a != null) {
            c6511a.i();
        }
    }

    public void e() {
        ExposeChildAttachListener exposeChildAttachListener;
        if (this.g && (exposeChildAttachListener = this.f) != null) {
            exposeChildAttachListener.f();
        }
    }

    public List<Object> f() {
        return this.h;
    }

    public void g() {
        C6511a c6511a = this.i;
        if (c6511a != null) {
            c6511a.a();
        }
    }

    public void h() {
        ExposeChildAttachListener exposeChildAttachListener;
        if (this.g && (exposeChildAttachListener = this.f) != null) {
            exposeChildAttachListener.g();
        }
    }

    public void i(List<Object> list) {
        this.h = list;
    }
}
