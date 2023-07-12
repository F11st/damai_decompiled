package com.alibaba.pictures.bricks.component.empty;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.empty.EmptyContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class EmptyView extends AbsView<IItem<ItemValue>, EmptyContract.Model<IItem<ItemValue>>, EmptyContract.Presenter<IItem<ItemValue>, EmptyContract.Model<IItem<ItemValue>>>> implements EmptyContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;

    public EmptyView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R$id.content);
    }

    @Override // com.alibaba.pictures.bricks.component.empty.EmptyContract.View
    public void renderContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940725926")) {
            ipChange.ipc$dispatch("-1940725926", new Object[]{this, str});
        } else {
            this.content.setText(str);
        }
    }
}
