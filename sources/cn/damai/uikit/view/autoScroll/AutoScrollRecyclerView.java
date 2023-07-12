package cn.damai.uikit.view.autoScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AutoScrollRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    AutoScrollTask autoPollTask;
    AtomicBoolean scrolling;

    public AutoScrollRecyclerView(Context context) {
        super(context);
        this.scrolling = new AtomicBoolean(false);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671545602")) {
            ipChange.ipc$dispatch("-1671545602", new Object[]{this});
        } else {
            this.autoPollTask = new AutoScrollTask(this);
        }
    }

    public boolean isRunning() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-587018965") ? ((Boolean) ipChange.ipc$dispatch("-587018965", new Object[]{this})).booleanValue() : this.scrolling.get();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339905549")) {
            return ((Boolean) ipChange.ipc$dispatch("339905549", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0 && this.scrolling.get()) {
            stop();
        }
        return true;
    }

    public void start(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857475670")) {
            ipChange.ipc$dispatch("-1857475670", new Object[]{this, Long.valueOf(j)});
            return;
        }
        if (this.scrolling.getAndSet(true)) {
            stop();
        }
        postDelayed(this.autoPollTask, j);
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209246516")) {
            ipChange.ipc$dispatch("-1209246516", new Object[]{this});
            return;
        }
        this.scrolling.compareAndSet(true, false);
        removeCallbacks(this.autoPollTask);
    }

    public AutoScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrolling = new AtomicBoolean(false);
        init();
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771364442")) {
            ipChange.ipc$dispatch("771364442", new Object[]{this});
            return;
        }
        if (this.scrolling.getAndSet(true)) {
            stop();
        }
        postDelayed(this.autoPollTask, 2000L);
    }

    public AutoScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrolling = new AtomicBoolean(false);
        init();
    }
}
