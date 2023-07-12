package cn.damai.rank.listener;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class TitleModeChangeListener extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a = true;
    private int b;

    private boolean a(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652182580")) {
            return ((Boolean) ipChange.ipc$dispatch("-1652182580", new Object[]{this, recyclerView})).booleanValue();
        }
        try {
            View childAt = recyclerView.getChildAt(0);
            if (childAt != null) {
                return recyclerView.getChildAdapterPosition(childAt) == 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public abstract void b(boolean z);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1837807873")) {
            ipChange.ipc$dispatch("1837807873", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.b += i2;
        if (i2 < 0 && a(recyclerView)) {
            this.b = 0;
        }
        boolean z = this.b == 0;
        if (this.a == z) {
            return;
        }
        this.a = z;
        b(z);
    }
}
