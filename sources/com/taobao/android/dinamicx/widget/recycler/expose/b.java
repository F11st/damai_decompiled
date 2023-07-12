package com.taobao.android.dinamicx.widget.recycler.expose;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    private final RecyclerView a;
    private final IExposeViewVisibleCallback b;
    private final IExposeStayCallback c;
    private final long d;
    private ExposeScrollerListener e;
    private ExposeChildAttachListener f;
    private boolean g;
    private List<Object> h;
    private final a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull RecyclerView recyclerView, @NonNull c cVar) {
        this.a = recyclerView;
        this.c = cVar.i();
        this.b = cVar.j();
        this.d = cVar.e();
        this.i = new a(recyclerView, cVar);
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
        a aVar = this.i;
        if (aVar != null) {
            aVar.g();
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
            a aVar = this.i;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    public void d() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.i();
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
        a aVar = this.i;
        if (aVar != null) {
            aVar.a();
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
