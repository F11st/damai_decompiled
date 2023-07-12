package cn.damai.tetris.component.star.content.freetest;

import cn.damai.tetris.component.star.content.freetest.ContentFreeTestContract;
import cn.damai.tetris.component.star.content.freetest.bean.ContentFreeTestBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentFreeTestModel extends AbsModel implements ContentFreeTestContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ContentFreeTestBean> baseFreeBeans;

    @Override // cn.damai.tetris.component.star.content.freetest.ContentFreeTestContract.Model
    public List<ContentFreeTestBean> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181065809") ? (List) ipChange.ipc$dispatch("-181065809", new Object[]{this}) : this.baseFreeBeans;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452964733")) {
            ipChange.ipc$dispatch("1452964733", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() == null || baseNode.getItem().getString("result") == null) {
                return;
            }
            this.baseFreeBeans = JSON.parseArray(baseNode.getItem().getString("result"), ContentFreeTestBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
