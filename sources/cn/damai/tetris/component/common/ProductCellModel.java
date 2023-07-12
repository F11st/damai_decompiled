package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.ProductCellContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProductCellModel extends AbsModel implements ProductCellContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    String id;
    String img;
    String name;
    String price;
    String schema;

    @Override // cn.damai.tetris.component.common.ProductCellContract.Model
    public String getBgImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-946844324") ? (String) ipChange.ipc$dispatch("-946844324", new Object[]{this}) : this.img;
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.Model
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1598658829") ? (String) ipChange.ipc$dispatch("-1598658829", new Object[]{this}) : this.id;
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.Model
    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1358040355") ? (String) ipChange.ipc$dispatch("1358040355", new Object[]{this}) : this.name;
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.Model
    public String getPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "142593379") ? (String) ipChange.ipc$dispatch("142593379", new Object[]{this}) : this.price;
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.Model
    public String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-962756103") ? (String) ipChange.ipc$dispatch("-962756103", new Object[]{this}) : this.schema;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213798915")) {
            ipChange.ipc$dispatch("1213798915", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item != null) {
            this.id = item.getString("id");
            this.price = item.getString("priceLow");
            this.name = item.getString("name");
            this.img = item.getString("verticalPic");
            this.schema = item.getString("schema");
        }
    }
}
