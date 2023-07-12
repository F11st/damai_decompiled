package cn.damai.onearch.component.scripttag;

import cn.damai.onearch.component.scripttag.ScriptTagBean;
import cn.damai.onearch.component.scripttag.ScriptTagContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.alient.onearch.adapter.widget.RichTitle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptTagModel extends AbsModel<GenericItem<ItemValue>, ScriptTagBean> implements ScriptTagContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Model
    @NotNull
    public String getTagValue(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697435037")) {
            return (String) ipChange.ipc$dispatch("-1697435037", new Object[]{this, Integer.valueOf(i)});
        }
        List<ScriptTagBean.Tag> list = getValue().lineItem;
        if (list == null || i >= list.size()) {
            return "";
        }
        String str = list.get(i).value;
        b41.h(str, "it[tabPosition].value");
        return str;
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Model
    @NotNull
    public List<RichTitle> getTags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21572419")) {
            return (List) ipChange.ipc$dispatch("21572419", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        List<ScriptTagBean.Tag> list = getValue().lineItem;
        if (list != null) {
            for (ScriptTagBean.Tag tag : list) {
                String str = tag.name;
                b41.h(str, "it.name");
                arrayList.add(new RichTitle(str, null, null, null, 0, 30, null));
            }
        }
        return arrayList;
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Model
    @NotNull
    public String getTagsOption() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522930703")) {
            return (String) ipChange.ipc$dispatch("-522930703", new Object[]{this});
        }
        String str = getValue().option;
        b41.h(str, "value.option");
        return str;
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Model
    @NotNull
    public String getTargetComponentType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794488231")) {
            return (String) ipChange.ipc$dispatch("-1794488231", new Object[]{this});
        }
        String str = getValue().componentType;
        b41.h(str, "value.componentType");
        return str;
    }
}
