package cn.damai.comment.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.PublishDMListView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class PublishDMListView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemClickListener itemClickListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMListView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PublishDMListView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-2$lambda-1  reason: not valid java name */
    public static final void m11bindData$lambda2$lambda1(List list, PublishDMListView publishDMListView, DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1292581221")) {
            ipChange.ipc$dispatch("1292581221", new Object[]{list, publishDMListView, dmInfo});
            return;
        }
        b41.i(publishDMListView, "this$0");
        if (list != null) {
            Iterator it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                DmInfo dmInfo2 = (DmInfo) it.next();
                if (b41.d(dmInfo.getDmId(), dmInfo2 != null ? dmInfo2.getDmId() : null)) {
                    break;
                }
                i++;
            }
            if ((i < 0 || i >= list.size()) ? false : false) {
                publishDMListView.smoothScrollToPosition(i);
            }
        }
    }

    public final void bindData(@Nullable final List<DmInfo> list, @Nullable final DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127596889")) {
            ipChange.ipc$dispatch("-2127596889", new Object[]{this, list, dmInfo});
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter != null) {
            dMSelectListAdapter.e(list, dmInfo);
        }
        if (dmInfo != null) {
            postDelayed(new Runnable() { // from class: tb.tx1
                @Override // java.lang.Runnable
                public final void run() {
                    PublishDMListView.m11bindData$lambda2$lambda1(list, this, dmInfo);
                }
            }, 500L);
        }
    }

    @Nullable
    public final OnItemClickListener getItemClickListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "73609740") ? (OnItemClickListener) ipChange.ipc$dispatch("73609740", new Object[]{this}) : this.itemClickListener;
    }

    @Nullable
    public final DmInfo getSelectedDm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778657437")) {
            return (DmInfo) ipChange.ipc$dispatch("-778657437", new Object[]{this});
        }
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter != null) {
            return dMSelectListAdapter.b();
        }
        return null;
    }

    public final void setItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-802496124")) {
            ipChange.ipc$dispatch("-802496124", new Object[]{this, onItemClickListener});
            return;
        }
        this.itemClickListener = onItemClickListener;
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter == null) {
            return;
        }
        dMSelectListAdapter.f(onItemClickListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMListView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.comment.view.PublishDMListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1095740389")) {
                    ipChange.ipc$dispatch("-1095740389", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view, "view");
                b41.i(recyclerView, "parent");
                b41.i(state, "state");
                super.getItemOffsets(rect, view, recyclerView, state);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                rect.left = m62.a(context, 6.0f);
                rect.right = m62.a(context, 6.0f);
                if (childLayoutPosition == 0) {
                    rect.left = m62.a(context, 20.0f);
                    return;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                b41.f(adapter);
                if (childLayoutPosition == adapter.getItemCount() - 1) {
                    rect.right = m62.a(context, 20.0f);
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        setAdapter(new DMSelectListAdapter(this.itemClickListener));
    }
}
