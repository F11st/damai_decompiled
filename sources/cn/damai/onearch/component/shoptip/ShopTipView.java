package cn.damai.onearch.component.shoptip;

import android.view.View;
import android.widget.TextView;
import cn.damai.onearch.component.shoptip.ShopTipContract;
import cn.damai.onearch.view.AbsView;
import com.alient.onearch.adapter.R;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ShopTipView extends AbsView<IItem<ItemValue>, ShopTipContract.Model<IItem<ItemValue>>, ShopTipContract.Presenter<IItem<ItemValue>, ShopTipContract.Model<IItem<ItemValue>>>> implements ShopTipContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;
    private final View rightArrow;

    public ShopTipView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R.id.content);
        this.rightArrow = view.findViewById(R.id.right_arrow);
    }

    @Override // cn.damai.onearch.component.shoptip.ShopTipContract.View
    public void hideRightArrow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757697382")) {
            ipChange.ipc$dispatch("757697382", new Object[]{this});
        } else {
            this.rightArrow.setVisibility(8);
        }
    }

    @Override // cn.damai.onearch.component.shoptip.ShopTipContract.View
    public void renderContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432983716")) {
            ipChange.ipc$dispatch("-1432983716", new Object[]{this, str});
        } else {
            this.content.setText(str);
        }
    }

    @Override // cn.damai.onearch.component.shoptip.ShopTipContract.View
    public void showRightArrow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132150901")) {
            ipChange.ipc$dispatch("-2132150901", new Object[]{this});
        } else {
            this.rightArrow.setVisibility(0);
        }
    }

    @Override // cn.damai.onearch.component.shoptip.ShopTipContract.View
    public void updateBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91781443")) {
            ipChange.ipc$dispatch("91781443", new Object[]{this, Integer.valueOf(i)});
        } else if (getRenderView() != null) {
            getRenderView().setBackgroundColor(i);
        }
    }
}
