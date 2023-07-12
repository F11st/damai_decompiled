package com.taobao.android.dinamicx.widget.recycler.expose;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeViewVisibleCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.vg0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExposeChildAttachListener implements RecyclerView.OnChildAttachStateChangeListener {
    private final RecyclerView a;
    private final IExposeStayCallback b;
    private final IExposeViewVisibleCallback c;
    private final HashMap<Integer, Long> d = new HashMap<>();
    private final long e;

    public ExposeChildAttachListener(RecyclerView recyclerView, IExposeStayCallback iExposeStayCallback, IExposeViewVisibleCallback iExposeViewVisibleCallback, long j) {
        this.a = recyclerView;
        this.b = iExposeStayCallback;
        this.c = iExposeViewVisibleCallback;
        this.e = j;
    }

    private void a(int i) {
        if (this.d.get(Integer.valueOf(i)) == null || this.d.get(Integer.valueOf(i)).longValue() <= 0) {
            this.d.put(Integer.valueOf(i), 0L);
        }
    }

    private void d(int i, RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null || this.b == null || recyclerView.getLayoutManager().findViewByPosition(i) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = this.d.get(Integer.valueOf(i)).longValue();
        if (longValue <= 0 || longValue >= currentTimeMillis) {
            return;
        }
        long j = currentTimeMillis - longValue;
        this.d.put(Integer.valueOf(i), 0L);
        if (j >= this.e) {
            this.b.exposeStay(i, j);
        }
    }

    private void e(int i) {
        if (this.b != null) {
            d(i, this.a);
        }
        this.d.remove(Integer.valueOf(i));
    }

    public void b() {
        try {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null && recyclerView.getLayoutManager() != null && this.b != null) {
                Iterator it = new ArrayList(this.d.keySet()).iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    View findViewByPosition = this.a.getLayoutManager().findViewByPosition(intValue);
                    if (findViewByPosition != null) {
                        int i = (this.d.get(Integer.valueOf(intValue)).longValue() > 0L ? 1 : (this.d.get(Integer.valueOf(intValue)).longValue() == 0L ? 0 : -1));
                        if (i == 0 && vg0.b(findViewByPosition, this.c.visiblePercent())) {
                            this.d.put(Integer.valueOf(intValue), Long.valueOf(System.currentTimeMillis()));
                        } else if (i > 0 && vg0.a(findViewByPosition, 0.1f)) {
                            d(intValue, this.a);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            vg0.c(th.toString());
        }
    }

    public void c() {
    }

    public void f() {
        try {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null && recyclerView.getLayoutManager() != null && this.b != null) {
                for (Map.Entry<Integer, Long> entry : this.d.entrySet()) {
                    if (vg0.b(this.a.getLayoutManager().findViewByPosition(entry.getKey().intValue()), this.c.visiblePercent())) {
                        d(entry.getKey().intValue(), this.a);
                    }
                }
            }
        } catch (Throwable th) {
            vg0.c(th.toString());
        }
    }

    public void g() {
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        RecyclerView recyclerView;
        int childAdapterPosition;
        if (view == null || (recyclerView = this.a) == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(view)) < 0) {
            return;
        }
        a(childAdapterPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        int childAdapterPosition;
        if (!(view == null && this.a == null) && (childAdapterPosition = this.a.getChildAdapterPosition(view)) >= 0) {
            try {
                e(childAdapterPosition);
            } catch (Throwable th) {
                vg0.c(th.toString());
            }
        }
    }
}
