package cn.damai.tetris.component.star.content.feed;

import cn.damai.tetris.component.star.content.feed.ContentFeedContract;
import cn.damai.tetris.component.star.content.feed.bean.ContentFeedBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentFeedModel extends AbsModel implements ContentFeedContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ContentFeedBean> contentFeedBeans;

    @Override // cn.damai.tetris.component.star.content.feed.ContentFeedContract.Model
    public List<ContentFeedBean> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1655103345") ? (List) ipChange.ipc$dispatch("-1655103345", new Object[]{this}) : this.contentFeedBeans;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927222941")) {
            ipChange.ipc$dispatch("1927222941", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() == null || baseNode.getItem().getString("result") == null) {
                return;
            }
            this.contentFeedBeans = JSON.parseArray(baseNode.getItem().getString("result"), ContentFeedBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
