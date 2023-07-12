package com.alibaba.android.vlayout.extend;

import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ViewLifeCycleHelper {
    private HashMap<View, STATUS> a = new HashMap<>();
    private ViewLifeCycleListener b;
    private VirtualLayoutManager c;
    private int d;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum STATUS {
        APPEARING,
        APPEARED,
        DISAPPEARING,
        DISAPPEARED
    }

    public ViewLifeCycleHelper(VirtualLayoutManager virtualLayoutManager, @NonNull ViewLifeCycleListener viewLifeCycleListener) {
        this.b = viewLifeCycleListener;
        this.c = virtualLayoutManager;
    }

    private STATUS b(View view) {
        if (!this.a.containsKey(view)) {
            HashMap<View, STATUS> hashMap = this.a;
            STATUS status = STATUS.DISAPPEARED;
            hashMap.put(view, status);
            return status;
        }
        return this.a.get(view);
    }

    private boolean c(View view) {
        return b(view) == STATUS.APPEARING;
    }

    private boolean d(View view) {
        return b(view) == STATUS.DISAPPEARED;
    }

    private boolean e(View view) {
        return b(view) == STATUS.DISAPPEARING;
    }

    private boolean f(View view) {
        return b(view) == STATUS.APPEARED;
    }

    private void g(View view) {
        STATUS b = b(view);
        STATUS status = STATUS.APPEARED;
        if (b == status) {
            return;
        }
        k(view, status);
        ViewLifeCycleListener viewLifeCycleListener = this.b;
        if (viewLifeCycleListener != null) {
            viewLifeCycleListener.onAppeared(view);
        }
    }

    private void h(View view) {
        STATUS b = b(view);
        STATUS status = STATUS.APPEARING;
        if (b == status) {
            return;
        }
        k(view, status);
        ViewLifeCycleListener viewLifeCycleListener = this.b;
        if (viewLifeCycleListener != null) {
            viewLifeCycleListener.onAppearing(view);
        }
    }

    private void i(View view) {
        STATUS b = b(view);
        STATUS status = STATUS.DISAPPEARED;
        if (b == status) {
            return;
        }
        k(view, status);
        ViewLifeCycleListener viewLifeCycleListener = this.b;
        if (viewLifeCycleListener != null) {
            viewLifeCycleListener.onDisappeared(view);
        }
    }

    private void j(View view) {
        STATUS b = b(view);
        STATUS status = STATUS.DISAPPEARING;
        if (b == status) {
            return;
        }
        k(view, status);
        ViewLifeCycleListener viewLifeCycleListener = this.b;
        if (viewLifeCycleListener != null) {
            viewLifeCycleListener.onDisappearing(view);
        }
    }

    private void k(View view, STATUS status) {
        this.a.put(view, status);
    }

    public void a() {
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            if (this.d == 0) {
                this.d = DisplayMetrics.getheightPixels(childAt.getContext().getResources().getDisplayMetrics());
            }
            if (this.c.getVirtualLayoutDirection() == 1) {
                if (childAt.getTop() <= 0 && childAt.getBottom() >= 0 && f(childAt)) {
                    j(childAt);
                } else if (childAt.getTop() <= this.d && childAt.getBottom() >= this.d && d(childAt)) {
                    h(childAt);
                }
            } else if (childAt.getTop() <= 0 && childAt.getBottom() >= 0 && d(childAt)) {
                h(childAt);
            } else if (childAt.getTop() <= this.d && childAt.getBottom() >= this.d && f(childAt)) {
                j(childAt);
            }
            if (childAt.getTop() >= 0 && childAt.getBottom() <= this.d) {
                if (d(childAt)) {
                    h(childAt);
                } else if (c(childAt)) {
                    g(childAt);
                }
            } else if (childAt.getBottom() <= 0 || childAt.getTop() >= this.d) {
                if (f(childAt)) {
                    j(childAt);
                } else if (e(childAt)) {
                    i(childAt);
                }
            }
        }
    }
}
