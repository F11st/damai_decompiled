package tb;

import cn.damai.ultron.view.bean.DmPayTypeBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class va0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private JSONObject a;
    private IDMComponent b;

    public va0(IDMComponent iDMComponent) {
        this.b = iDMComponent;
        if (iDMComponent != null) {
            this.a = iDMComponent.getFields();
        }
    }

    public IDMComponent a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1079306502") ? (IDMComponent) ipChange.ipc$dispatch("-1079306502", new Object[]{this}) : this.b;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392322322")) {
            return (String) ipChange.ipc$dispatch("1392322322", new Object[]{this});
        }
        JSONObject jSONObject = this.a;
        return jSONObject != null ? jSONObject.getString("allTip") : "";
    }

    public List<DmPayTypeBean> c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545852652")) {
            return (List) ipChange.ipc$dispatch("-1545852652", new Object[]{this});
        }
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("paytypeList");
                if (jSONArray != null) {
                    return JSON.parseArray(jSONArray.toJSONString(), DmPayTypeBean.class);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void d(List<DmPayTypeBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463503504")) {
            ipChange.ipc$dispatch("1463503504", new Object[]{this, list});
            return;
        }
        IDMComponent iDMComponent = this.b;
        if (iDMComponent != null) {
            iDMComponent.writeFields("paytypeList", JSON.toJSONString(list));
        }
    }

    public int e() {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016502401")) {
            return ((Integer) ipChange.ipc$dispatch("-2016502401", new Object[]{this})).intValue();
        }
        JSONObject jSONObject = this.a;
        if (jSONObject != null && (jSONArray = jSONObject.getJSONArray("paytypeList")) != null) {
            try {
                List parseArray = JSON.parseArray(jSONArray.toJSONString(), DmPayTypeBean.class);
                for (int i = 0; i < wh2.e(parseArray); i++) {
                    DmPayTypeBean dmPayTypeBean = (DmPayTypeBean) parseArray.get(i);
                    if (dmPayTypeBean.isSelect()) {
                        return dmPayTypeBean.payTypeId;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
