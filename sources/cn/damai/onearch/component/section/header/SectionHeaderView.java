package cn.damai.onearch.component.section.header;

import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.section.header.SectionHeaderContract;
import cn.damai.onearch.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SectionHeaderView extends AbsView<IItem<ItemValue>, SectionHeaderContract.Model<IItem<ItemValue>>, SectionHeaderContract.Presenter<IItem<ItemValue>, SectionHeaderContract.Model<IItem<ItemValue>>>> implements SectionHeaderContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;

    public SectionHeaderView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R$id.header_content);
    }

    @Override // cn.damai.onearch.component.section.header.SectionHeaderContract.View
    public void renderTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553273162")) {
            ipChange.ipc$dispatch("-1553273162", new Object[]{this, str});
        } else {
            this.content.setText(str);
        }
    }
}
