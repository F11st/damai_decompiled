package cn.damai.comment.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class PublishInputTipsView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private PublishInputTipsAdapter adapter;
    private boolean needShowWhenKeyboardOpen;
    @NotNull
    private RecyclerView tipsListView;
    @Nullable
    private OnTipsSelectedListener tipsSelectedListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishInputTipsView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PublishInputTipsView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bindData(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053780650")) {
            ipChange.ipc$dispatch("-2053780650", new Object[]{this, list});
            return;
        }
        if (list == null || list.isEmpty()) {
            this.needShowWhenKeyboardOpen = false;
            setVisibility(8);
            return;
        }
        this.needShowWhenKeyboardOpen = true;
        setVisibility(0);
        this.adapter.setData(list);
    }

    @NotNull
    public final PublishInputTipsAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2103975513") ? (PublishInputTipsAdapter) ipChange.ipc$dispatch("-2103975513", new Object[]{this}) : this.adapter;
    }

    public final boolean getNeedShowWhenKeyboardOpen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-546911666") ? ((Boolean) ipChange.ipc$dispatch("-546911666", new Object[]{this})).booleanValue() : this.needShowWhenKeyboardOpen;
    }

    @Nullable
    public final OnTipsSelectedListener getTipsSelectedListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1444994817") ? (OnTipsSelectedListener) ipChange.ipc$dispatch("-1444994817", new Object[]{this}) : this.tipsSelectedListener;
    }

    public final void setAdapter(@NotNull PublishInputTipsAdapter publishInputTipsAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881709285")) {
            ipChange.ipc$dispatch("881709285", new Object[]{this, publishInputTipsAdapter});
            return;
        }
        b41.i(publishInputTipsAdapter, "<set-?>");
        this.adapter = publishInputTipsAdapter;
    }

    public final void setTipsSelectedListener(@Nullable OnTipsSelectedListener onTipsSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098961535")) {
            ipChange.ipc$dispatch("1098961535", new Object[]{this, onTipsSelectedListener});
            return;
        }
        this.adapter.e(onTipsSelectedListener);
        this.tipsSelectedListener = onTipsSelectedListener;
    }

    public final boolean touchInSelf(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180948722")) {
            return ((Boolean) ipChange.ipc$dispatch("1180948722", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (i2 <= rect.bottom && rect.top <= i2) {
            if (i <= rect.right && rect.left <= i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishInputTipsView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.adapter = new PublishInputTipsAdapter(this.tipsSelectedListener);
        setGravity(16);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.view_publish_input_tips, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.comment_publish_input_tip_list);
        b41.h(findViewById, "findViewById(R.id.comment_publish_input_tip_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.tipsListView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.tipsListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.comment.view.PublishInputTipsView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "45194190")) {
                    ipChange.ipc$dispatch("45194190", new Object[]{this, rect, view, recyclerView2, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view, "view");
                b41.i(recyclerView2, "parent");
                b41.i(state, "state");
                super.getItemOffsets(rect, view, recyclerView2, state);
                rect.left = m62.a(context, 9.0f);
                rect.right = m62.a(context, 9.0f);
            }
        });
        this.tipsListView.setAdapter(this.adapter);
    }
}
