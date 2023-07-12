package com.alibaba.pictures.bricks.component.instructions;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract;
import com.alibaba.pictures.bricks.component.text.FoldTextViewModel;
import com.alibaba.pictures.bricks.component.text.FoldTextViewPresent;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class PurchaseInstructionsView extends AbsView<GenericItem<ItemValue>, FoldTextViewModel, FoldTextViewPresent> implements PurchaseInstructionsContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;
    @NotNull
    private View itemView;
    private final TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseInstructionsView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.title = (TextView) view.findViewById(R$id.title);
        this.content = (TextView) this.itemView.findViewById(R$id.content);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-564004958") ? (View) ipChange.ipc$dispatch("-564004958", new Object[]{this}) : this.itemView;
    }

    @Override // com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract.View
    public void renderContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1174925781")) {
            ipChange.ipc$dispatch("1174925781", new Object[]{this, str});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if ((z ? str : null) != null) {
            this.content.setVisibility(8);
            return;
        }
        this.content.setVisibility(0);
        this.content.setText(str);
    }

    @Override // com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract.View
    public void renderTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1101228778")) {
            ipChange.ipc$dispatch("-1101228778", new Object[]{this, str});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if ((z ? str : null) != null) {
            this.title.setVisibility(8);
            return;
        }
        this.title.setVisibility(0);
        this.title.setText(str);
    }

    public final void setItemView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449399678")) {
            ipChange.ipc$dispatch("1449399678", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.itemView = view;
    }
}
