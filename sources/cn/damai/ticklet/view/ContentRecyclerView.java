package cn.damai.ticklet.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CompositeScrollListener compositeScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1274960477")) {
                ipChange.ipc$dispatch("1274960477", new Object[]{this});
                return;
            }
            ViewGroup.LayoutParams layoutParams = ContentRecyclerView.this.getLayoutParams();
            ViewParent parent = ContentRecyclerView.this.getParent();
            while (true) {
                if (parent == null) {
                    break;
                } else if (parent instanceof ScrollLayout) {
                    ScrollLayout scrollLayout = (ScrollLayout) parent;
                    int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.minOffset;
                    if (layoutParams.height == measuredHeight) {
                        return;
                    }
                    layoutParams.height = measuredHeight;
                } else {
                    parent = parent.getParent();
                }
            }
            ContentRecyclerView.this.setLayoutParams(layoutParams);
        }
    }

    public ContentRecyclerView(Context context) {
        super(context);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener(this, null);
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void throwIfNotOnMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490216758")) {
            ipChange.ipc$dispatch("-1490216758", new Object[]{this});
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278093934")) {
            ipChange.ipc$dispatch("278093934", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedRecyclerView(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50746385")) {
            ipChange.ipc$dispatch("50746385", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class CompositeScrollListener extends RecyclerView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<RecyclerView.OnScrollListener> a;

        private CompositeScrollListener(ContentRecyclerView contentRecyclerView) {
            this.a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1045862211")) {
                ipChange.ipc$dispatch("-1045862211", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.a)) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-131311934")) {
                ipChange.ipc$dispatch("-131311934", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.a)) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
        }

        /* synthetic */ CompositeScrollListener(ContentRecyclerView contentRecyclerView, a aVar) {
            this(contentRecyclerView);
        }
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener(this, null);
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener(this, null);
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }
}
