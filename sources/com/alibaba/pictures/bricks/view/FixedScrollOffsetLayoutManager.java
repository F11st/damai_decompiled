package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.GenericVirtualLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FixedScrollOffsetLayoutManager extends GenericVirtualLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final HashMap<Integer, Integer> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedScrollOffsetLayoutManager(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = new HashMap<>();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283460210")) {
            return ((Integer) ipChange.ipc$dispatch("1283460210", new Object[]{this, state})).intValue();
        }
        b41.i(state, "state");
        if (getChildCount() == 0) {
            return 0;
        }
        try {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
            int i = 0;
            for (int i2 = 0; i2 < findFirstVisibleItemPosition; i2++) {
                Integer num = this.a.get(Integer.valueOf(i2));
                if (num == null) {
                    num = 0;
                }
                i += num.intValue();
            }
            return i - (findViewByPosition != null ? findViewByPosition.getTop() : 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(@Nullable RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965830516")) {
            ipChange.ipc$dispatch("965830516", new Object[]{this, state});
            return;
        }
        super.onLayoutCompleted(state);
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0 || findLastVisibleItemPosition < findFirstVisibleItemPosition) {
            return;
        }
        while (findFirstVisibleItemPosition < findLastVisibleItemPosition) {
            View childAt = getChildAt(findFirstVisibleItemPosition);
            if (childAt != null) {
                this.a.put(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(childAt.getHeight()));
            }
            findFirstVisibleItemPosition++;
        }
    }
}
