package com.alibaba.pictures.bricks.component.text;

import android.view.View;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.text.FoldTextViewContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FoldTextViewView extends AbsView<GenericItem<ItemValue>, FoldTextViewModel, FoldTextViewPresent> implements FoldTextViewContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private View itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldTextViewView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-41279171") ? (View) ipChange.ipc$dispatch("-41279171", new Object[]{this}) : this.itemView;
    }

    @Override // com.alibaba.pictures.bricks.component.text.FoldTextViewContract.View
    @NotNull
    public FoldTextView getTextView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642537325")) {
            return (FoldTextView) ipChange.ipc$dispatch("-1642537325", new Object[]{this});
        }
        View findViewById = this.itemView.findViewById(R$id.bricks_fold_text);
        b41.h(findViewById, "itemView.findViewById(R.id.bricks_fold_text)");
        return (FoldTextView) findViewById;
    }

    public final void setItemView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "474029891")) {
            ipChange.ipc$dispatch("474029891", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.itemView = view;
    }
}
