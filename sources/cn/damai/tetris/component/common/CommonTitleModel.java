package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.CommonTitleContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CommonTitleModel extends AbsModel implements CommonTitleContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    String schema;
    String title;

    @Override // cn.damai.tetris.component.common.CommonTitleContract.Model
    public String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "545287997") ? (String) ipChange.ipc$dispatch("545287997", new Object[]{this}) : this.schema;
    }

    @Override // cn.damai.tetris.component.common.CommonTitleContract.Model
    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-323074126") ? (String) ipChange.ipc$dispatch("-323074126", new Object[]{this}) : this.title;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554154433")) {
            ipChange.ipc$dispatch("-1554154433", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item.get("title") != null) {
            this.title = item.getString("title");
        }
        this.schema = item.getString("schema");
    }
}
