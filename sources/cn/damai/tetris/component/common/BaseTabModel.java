package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.bean.BaseTabResultItem;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseTabModel extends AbsModel implements BaseTabContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    JSONObject action;
    List<BaseTabResultItem> tabLists;

    @Override // cn.damai.tetris.component.common.BaseTabContract$Model
    public List<BaseTabResultItem> getTabLists() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1688080780") ? (List) ipChange.ipc$dispatch("1688080780", new Object[]{this}) : this.tabLists;
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$Model
    public JSONObject getTrackInfoAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1184663648") ? (JSONObject) ipChange.ipc$dispatch("1184663648", new Object[]{this}) : this.action;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103912682")) {
            ipChange.ipc$dispatch("-1103912682", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item != null) {
            try {
                if (item.get("list") != null) {
                    JSONArray jSONArray = item.getJSONArray("list");
                    if (jSONArray.size() == 1 && jSONArray.get(0) != null && ((JSONObject) jSONArray.get(0)).get("tabResults") != null) {
                        this.tabLists = JSON.parseArray(((JSONObject) jSONArray.get(0)).getString("tabResults"), BaseTabResultItem.class);
                    }
                    if (jSONArray.size() != 1 || jSONArray.get(0) == null || ((JSONObject) jSONArray.get(0)).get("action") == null) {
                        return;
                    }
                    this.action = ((JSONObject) jSONArray.get(0)).getJSONObject("action");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
