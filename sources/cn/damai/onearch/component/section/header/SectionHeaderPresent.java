package cn.damai.onearch.component.section.header;

import android.text.TextUtils;
import android.view.View;
import cn.damai.onearch.component.section.header.SectionHeaderContract;
import cn.damai.onearch.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SectionHeaderPresent extends AbsPresenter<IItem<ItemValue>, SectionHeaderContract.Model<IItem<ItemValue>>, SectionHeaderContract.View> implements SectionHeaderContract.Presenter<IItem<ItemValue>, SectionHeaderContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public SectionHeaderPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183435700")) {
            ipChange.ipc$dispatch("-183435700", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        if (TextUtils.isEmpty(((SectionHeaderContract.Model) this.model).getTitle())) {
            return;
        }
        ((SectionHeaderContract.View) this.view).renderTitle(((SectionHeaderContract.Model) this.model).getTitle());
    }
}
