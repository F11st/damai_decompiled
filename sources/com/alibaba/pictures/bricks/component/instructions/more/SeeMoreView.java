package com.alibaba.pictures.bricks.component.instructions.more;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SeeMoreView extends AbsView<GenericItem<ItemValue>, SeeMoreModel, SeeMorePresent> implements SeeMoreContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeeMoreView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.content = (TextView) view.findViewById(R.id.content);
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1938087917") ? (View) ipChange.ipc$dispatch("1938087917", new Object[]{this}) : this.view;
    }

    @Override // com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract.View
    public void renderContent(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364363571")) {
            ipChange.ipc$dispatch("-1364363571", new Object[]{this, str});
            return;
        }
        b41.i(str, "content");
        this.content.setText(str);
    }
}
