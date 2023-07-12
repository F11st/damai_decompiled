package tb;

import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.tetris.v2.structure.section.ISection;
import cn.damai.tetris.v2.structure.section.SectionProperty;
import cn.damai.tetris.v2.util.CmsDxTemplate;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class vt0 implements ISection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private SectionProperty b;
    private int c;
    private JSONObject d;
    private JSONObject e;
    private ILayer f;
    private TrackInfo h;
    private StyleInfo i;
    private String j;
    private String k;
    private Object l;
    private JSONObject m;
    JSONObject n;
    JSONObject o;
    private int g = -1;
    int p = 1;

    public vt0(IContext iContext, Node node) {
        this.a = iContext;
        JSONObject jSONObject = node.data;
        this.e = jSONObject;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-400154326")) {
            ipChange.ipc$dispatch("-400154326", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
        } else {
            this.k = jSONObject.getString("componentId");
            this.j = jSONObject.getString("node_id");
            this.p = 1;
            try {
                this.p = jSONObject.getIntValue(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
                this.n = jSONObject.getJSONObject("dxConfig");
                this.o = jSONObject.getJSONObject("gaiaxConfig");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.p < 1) {
                this.p = 1;
            }
            if (xl2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID.equals(this.k) || xl2.DX_MUSIC_FESTIVAL_IP_LIST_CID.equals(this.k) || this.p == 2) {
                CmsDxTemplate validTemplateJson = CmsDxTemplate.getValidTemplateJson(jSONObject, this.k);
                if (validTemplateJson != null) {
                    this.c = m90.f(CmsDxTemplate.toDxJsonObj(validTemplateJson));
                } else if (m90.g(this.k)) {
                    this.c = m90.f(m90.c(this.k));
                }
                z = true;
            }
            if (this.p == 3 && (jSONObject2 = this.o) != null) {
                jSONObject2.put("componentId", (Object) this.k);
                this.c = ht0.b(this.o);
            }
            if (!z && this.p != 3) {
                this.c = om.c(this.a.getActivity()).d(this.k);
            }
            this.d = jSONObject.getJSONObject("item");
            JSONObject jSONObject3 = jSONObject.getJSONObject("trackInfo");
            if (jSONObject3 instanceof TrackInfo) {
                this.h = (TrackInfo) jSONObject3;
            }
            JSONObject jSONObject4 = jSONObject.getJSONObject("styleInfo");
            if (jSONObject4 != null && (jSONObject4 instanceof StyleInfo)) {
                this.i = (StyleInfo) jSONObject4;
            }
            JSONObject jSONObject5 = jSONObject.getJSONObject("extraArgs");
            if (jSONObject5 == null || !(jSONObject5 instanceof JSONObject)) {
                return;
            }
            this.m = jSONObject5;
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void addItem(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062182717")) {
            ipChange.ipc$dispatch("-2062182717", new Object[]{this, jSONObject});
            return;
        }
        try {
            this.d = k61.a(this.d, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public String getComponentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "702779577") ? (String) ipChange.ipc$dispatch("702779577", new Object[]{this}) : this.k;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public int getComponentType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "872046843") ? ((Integer) ipChange.ipc$dispatch("872046843", new Object[]{this})).intValue() : this.p;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673930283")) {
            return (IContainer) ipChange.ipc$dispatch("-673930283", new Object[]{this});
        }
        ILayer iLayer = this.f;
        if (iLayer == null) {
            return null;
        }
        return iLayer.getContainer();
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public ho getCoordinate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1162418894")) {
            return (ho) ipChange.ipc$dispatch("1162418894", new Object[]{this});
        }
        return new ho(getModule() == null ? -1 : getModule().getIndex(), getLayer() != null ? getLayer().getIndex() : -1, getIndex());
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getDxConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1760735445") ? (JSONObject) ipChange.ipc$dispatch("1760735445", new Object[]{this}) : this.n;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public Object getExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1322409757") ? ipChange.ipc$dispatch("-1322409757", new Object[]{this}) : this.l;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getExtraArgs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1828295118") ? (JSONObject) ipChange.ipc$dispatch("-1828295118", new Object[]{this}) : this.m;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getGaiaxConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-75808585") ? (JSONObject) ipChange.ipc$dispatch("-75808585", new Object[]{this}) : this.o;
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820764640")) {
            return ((Integer) ipChange.ipc$dispatch("-1820764640", new Object[]{this})).intValue();
        }
        ILayer iLayer = this.f;
        if (iLayer != null) {
            iLayer.updateChildIndex();
        }
        return this.g;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-784236392") ? (JSONObject) ipChange.ipc$dispatch("-784236392", new Object[]{this}) : this.d;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public ILayer getLayer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-213347963") ? (ILayer) ipChange.ipc$dispatch("-213347963", new Object[]{this}) : this.f;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public IModule getModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663657526")) {
            return (IModule) ipChange.ipc$dispatch("-663657526", new Object[]{this});
        }
        ILayer iLayer = this.f;
        if (iLayer == null) {
            return null;
        }
        return iLayer.getModule();
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public SectionProperty getProperty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-518397965") ? (SectionProperty) ipChange.ipc$dispatch("-518397965", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getRawData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "425332653") ? (JSONObject) ipChange.ipc$dispatch("425332653", new Object[]{this}) : this.e;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public String getSectionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-867722719") ? (String) ipChange.ipc$dispatch("-867722719", new Object[]{this}) : this.j;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public StyleInfo getStyleInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-256503173") ? (StyleInfo) ipChange.ipc$dispatch("-256503173", new Object[]{this}) : this.i;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2062204731") ? (TrackInfo) ipChange.ipc$dispatch("2062204731", new Object[]{this}) : this.h;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-84223004") ? ((Integer) ipChange.ipc$dispatch("-84223004", new Object[]{this})).intValue() : this.c;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setExtra(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555569751")) {
            ipChange.ipc$dispatch("555569751", new Object[]{this, obj});
        } else {
            this.l = obj;
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setExtraArgs(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497127278")) {
            ipChange.ipc$dispatch("-497127278", new Object[]{this, jSONObject});
        } else {
            this.m = jSONObject;
        }
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939893482")) {
            ipChange.ipc$dispatch("939893482", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.g = i;
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setLayer(ILayer iLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782266733")) {
            ipChange.ipc$dispatch("782266733", new Object[]{this, iLayer});
        } else {
            this.f = iLayer;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021761891")) {
            return (String) ipChange.ipc$dispatch("1021761891", new Object[]{this});
        }
        return "GenericSection{mType=" + this.c + ", mItem=" + JSON.toJSONString(this.d) + ", rawData=" + JSON.toJSONString(this.e) + ", mLayer=" + this.f.toString() + ", mIndex=" + this.g + ", mTrackInfo=" + JSON.toJSONString(this.h) + ", styleInfo=" + JSON.toJSONString(this.i) + ", mSectionId='" + this.j + "', mComponentId='" + this.k + "', extra=" + JSON.toJSONString(this.l) + ", extraArgs=" + JSON.toJSONString(this.m) + ", dxConfig=" + JSON.toJSONString(this.n) + ", gaiaxConfig=" + JSON.toJSONString(this.o) + ", componentType=" + this.p + '}';
    }
}
