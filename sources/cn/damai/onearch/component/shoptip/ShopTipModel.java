package cn.damai.onearch.component.shoptip;

import cn.damai.onearch.component.shoptip.ShopTipContract;
import cn.damai.onearch.view.AbsModel;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ShopTipModel extends AbsModel<IItem<ItemValue>, Object> implements ShopTipContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String content;

    @Override // cn.damai.onearch.component.shoptip.ShopTipContract.Model
    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1958464120") ? (String) ipChange.ipc$dispatch("1958464120", new Object[]{this}) : this.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289943741")) {
            ipChange.ipc$dispatch("289943741", new Object[]{this, iItem});
            return;
        }
        super.parseModelImpl(iItem);
        JSONObject data = iItem.getProperty().getData();
        if (data == null || !data.containsKey("notice")) {
            return;
        }
        this.content = data.getString("notice");
    }
}
