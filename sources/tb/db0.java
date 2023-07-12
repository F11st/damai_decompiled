package tb;

import cn.damai.ultron.view.bean.DmSeatPositionsBean;
import cn.damai.ultron.view.bean.DmViewerBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class db0 {
    private static transient /* synthetic */ IpChange $ipChange;
    DMComponent a;

    public db0(DMComponent dMComponent) {
        this.a = dMComponent;
    }

    public void a(DmViewerBean dmViewerBean, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-557269413")) {
            ipChange.ipc$dispatch("-557269413", new Object[]{this, dmViewerBean, Integer.valueOf(i)});
        } else if (dmViewerBean == null) {
        } else {
            List<DmViewerBean> e = e();
            int e2 = wh2.e(e);
            while (true) {
                if (i2 >= e2) {
                    break;
                } else if (e.get(i2).viewerId.equals(dmViewerBean.viewerId)) {
                    e.get(i2).isUsed = "true";
                    break;
                } else {
                    i2++;
                }
            }
            this.a.writeFields("viewerList", e);
            this.a.writeFields("selectedNum", String.valueOf(i));
        }
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331060044")) {
            return ((Integer) ipChange.ipc$dispatch("1331060044", new Object[]{this})).intValue();
        }
        DMComponent dMComponent = this.a;
        if (dMComponent == null || dMComponent.getFields() == null) {
            return 0;
        }
        return this.a.getFields().getInteger("buyerTotalNum").intValue();
    }

    public IDMComponent c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1246748203") ? (IDMComponent) ipChange.ipc$dispatch("-1246748203", new Object[]{this}) : this.a;
    }

    public List<DmSeatPositionsBean> d() {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969908542")) {
            return (List) ipChange.ipc$dispatch("1969908542", new Object[]{this});
        }
        DMComponent dMComponent = this.a;
        if (dMComponent == null || dMComponent.getFields() == null || (jSONArray = this.a.getFields().getJSONArray("dmSeatPositions")) == null) {
            return null;
        }
        return JSON.parseArray(jSONArray.toJSONString(), DmSeatPositionsBean.class);
    }

    public List<DmViewerBean> e() {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45420293")) {
            return (List) ipChange.ipc$dispatch("-45420293", new Object[]{this});
        }
        DMComponent dMComponent = this.a;
        if (dMComponent == null || dMComponent.getFields() == null || (jSONArray = this.a.getFields().getJSONArray("viewerList")) == null) {
            return null;
        }
        return JSON.parseArray(jSONArray.toJSONString(), DmViewerBean.class);
    }

    public void f(DmViewerBean dmViewerBean, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-618582056")) {
            ipChange.ipc$dispatch("-618582056", new Object[]{this, dmViewerBean, Integer.valueOf(i)});
        } else if (dmViewerBean == null) {
        } else {
            List<DmViewerBean> e = e();
            int e2 = wh2.e(e);
            while (true) {
                if (i2 >= e2) {
                    break;
                } else if (e.get(i2).viewerId.equals(dmViewerBean.viewerId)) {
                    e.get(i2).isUsed = "false";
                    break;
                } else {
                    i2++;
                }
            }
            this.a.writeFields("viewerList", e);
            this.a.writeFields("selectedNum", String.valueOf(i));
        }
    }

    public void g(Map<String, DmViewerBean> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497422123")) {
            ipChange.ipc$dispatch("1497422123", new Object[]{this, map});
        } else if (map != null) {
            List<DmSeatPositionsBean> d = d();
            int e = wh2.e(d);
            if (e != 0) {
                int i = 0;
                for (Map.Entry<String, DmViewerBean> entry : map.entrySet()) {
                    if (i >= e) {
                        break;
                    }
                    entry.getValue().seatId = d.get(i).seatId;
                    i++;
                }
            }
            List<DmViewerBean> e2 = e();
            int e3 = wh2.e(e2);
            for (int i2 = 0; i2 < e3; i2++) {
                if (map.containsKey(e2.get(i2).viewerId)) {
                    e2.get(i2).isUsed = "true";
                    DmViewerBean dmViewerBean = map.get(e2.get(i2).viewerId);
                    if (d != null) {
                        e2.get(i2).seatId = dmViewerBean.seatId;
                    } else {
                        e2.get(i2).seatId = "0";
                    }
                } else {
                    e2.get(i2).seatId = "0";
                    e2.get(i2).isUsed = "false";
                }
            }
            DMComponent dMComponent = this.a;
            if (dMComponent != null) {
                dMComponent.writeFields("viewerList", e2);
            }
        }
    }
}
