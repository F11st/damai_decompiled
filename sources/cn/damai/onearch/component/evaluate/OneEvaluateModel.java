package cn.damai.onearch.component.evaluate;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.onearch.component.evaluate.OneEvaluate;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneEvaluateModel extends AbsModel<GenericItem<ItemValue>, CommentsItemBean> implements OneEvaluate.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.onearch.component.evaluate.OneEvaluate.Model
    @NotNull
    public CommentsItemBean getEvaluate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-935466668") ? (CommentsItemBean) ipChange.ipc$dispatch("-935466668", new Object[]{this}) : getValue();
    }
}
