package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: Taobao */
/* renamed from: tb.db */
/* loaded from: classes7.dex */
public class C9039db {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_DAOJISHI = "key_daojishi";
    public static final String KEY_ITEMRESULT = "result";
    public static final String KEY_PROJECT = "key_project";
    public static final String KEY_SHOW_DIS = "key_showDis";
    public static final String TRACKKEY_CATEGORY_NAME = "track_categoryName";
    public static final String TRACKKEY_CITY = "track_city";
    public static final String TRACKKEY_CURRENT_ITEM_TOTAL = "track_currentItemTotal";
    public static final String TRACKKEY_IS_CURRENT_CITY = "isCurrentCity";
    private static TreeSet<String> b = new TreeSet<>();
    private static HashMap<String, IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>>> c = new HashMap<>();
    private static HashMap<String, ILayerStyleBuilder> d = new HashMap<>();
    public String a = "BaseResponse2Node";

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654858647")) {
            ipChange.ipc$dispatch("654858647", new Object[]{str});
        } else {
            b.add(str);
        }
    }

    public static void b(String str, IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> iConverter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198386712")) {
            ipChange.ipc$dispatch("-198386712", new Object[]{str, iConverter});
        } else {
            c.put(str, iConverter);
        }
    }

    public static void c(String str, ILayerStyleBuilder iLayerStyleBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730108421")) {
            ipChange.ipc$dispatch("-1730108421", new Object[]{str, iLayerStyleBuilder});
        } else {
            d.put(str, iLayerStyleBuilder);
        }
    }

    public static void d(BaseResponse baseResponse, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86904376")) {
            ipChange.ipc$dispatch("86904376", new Object[]{baseResponse, trackInfo});
        } else if (baseResponse != null && !oy2.a(baseResponse.layers) && trackInfo != null) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (sections != null) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection != null && j(baseSection.getComponentId())) {
                            baseSection.setTrackInfo(trackInfo);
                        }
                    }
                }
            }
        }
    }

    @NonNull
    private TrackInfo h(String str, BaseSection baseSection, GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115452084")) {
            return (TrackInfo) ipChange.ipc$dispatch("-115452084", new Object[]{this, str, baseSection, globalConfig});
        }
        TrackInfo trackInfo = new TrackInfo();
        if (baseSection.getTrackInfo() != null) {
            trackInfo = baseSection.getTrackInfo();
        }
        if (!TextUtils.isEmpty(str)) {
            trackInfo.trackB = str;
        }
        if (!TextUtils.isEmpty(trackInfo.getString("spmc"))) {
            trackInfo.trackC = trackInfo.getString("spmc");
        }
        if (globalConfig != null && globalConfig.getBuzUTMap() != null) {
            trackInfo.getInnerMap().putAll(globalConfig.getBuzUTMap());
        }
        return trackInfo;
    }

    public static boolean j(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167090715") ? ((Boolean) ipChange.ipc$dispatch("-1167090715", new Object[]{str})).booleanValue() : TextUtils.equals(xl2.DISCOVER_FEED_COMPONENT_ID, str);
    }

    public static boolean k(BaseResponse baseResponse) {
        NodeData item;
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695288199")) {
            return ((Boolean) ipChange.ipc$dispatch("1695288199", new Object[]{baseResponse})).booleanValue();
        }
        if (baseResponse != null && !oy2.a(baseResponse.layers)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            for (int i = 0; i < arrayList.size(); i++) {
                List<BaseSection> sections = arrayList.get(i).getSections();
                if (!oy2.a(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (j(baseSection.getComponentId()) && (item = baseSection.getItem()) != null && (bool = item.getBoolean(xl2.HAS_NEXT)) != null) {
                            return bool.booleanValue();
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.damai.tetris.v2.common.Node> m(cn.damai.tetris.core.mtop.BaseResponse r18, cn.damai.tetris.core.BaseLayer r19, cn.damai.tetris.core.mtop.GlobalConfig r20, int r21) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.C9039db.m(cn.damai.tetris.core.mtop.BaseResponse, cn.damai.tetris.core.BaseLayer, cn.damai.tetris.core.mtop.GlobalConfig, int):java.util.List");
    }

    public static List<BaseLayer> o(List<BaseLayer> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965558810")) {
            return (List) ipChange.ipc$dispatch("1965558810", new Object[]{list});
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BaseLayer baseLayer : list) {
            List<BaseSection> sections = baseLayer.getSections();
            if (sections != null && sections.size() > 0) {
                for (BaseSection baseSection : sections) {
                    BaseLayer baseLayer2 = new BaseLayer();
                    baseLayer2.setLayerId(baseLayer.getLayerId());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(baseSection);
                    baseLayer2.setSections(arrayList2);
                    arrayList.add(baseLayer2);
                }
            }
        }
        return arrayList;
    }

    public Node e(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143756795")) {
            return (Node) ipChange.ipc$dispatch("1143756795", new Object[]{this, baseResponse});
        }
        if (baseResponse != null && baseResponse.layers != null) {
            new cb().b(baseResponse);
            GlobalConfig globalConfig = baseResponse.globalConfig;
            GlobalConfig globalConfig2 = globalConfig != null ? globalConfig : null;
            if (globalConfig2 != null) {
                globalConfig2.comboDegrade = baseResponse.comboDegrade;
            }
            Node node = new Node();
            node.children = new ArrayList();
            Node node2 = new Node();
            node2.children = new ArrayList();
            node.children.add(node2);
            String str = this.a;
            jb1.a(str, "========= start convert ========= response : " + baseResponse);
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<Node> m = m(baseResponse, it.next(), globalConfig2, 0);
                if (m != null) {
                    node2.children.addAll(m);
                }
            }
            String str2 = this.a;
            jb1.a(str2, "========= end convert ========= node : " + node);
            return node;
        }
        jb1.a(this.a, "========= start convert ========= error : null  ");
        return null;
    }

    public List<Node> f(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1919012445") ? (List) ipChange.ipc$dispatch("-1919012445", new Object[]{this, baseResponse}) : g(baseResponse, 0);
    }

    public List<Node> g(BaseResponse baseResponse, int i) {
        ArrayList<BaseLayer> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042668280")) {
            return (List) ipChange.ipc$dispatch("-1042668280", new Object[]{this, baseResponse, Integer.valueOf(i)});
        }
        if (baseResponse != null && (arrayList = baseResponse.layers) != null && !arrayList.isEmpty()) {
            baseResponse.globalConfig.comboDegrade = baseResponse.comboDegrade;
            List<Node> m = m(baseResponse, baseResponse.layers.get(0), baseResponse.globalConfig, i);
            ArrayList arrayList2 = new ArrayList();
            if (m != null) {
                for (Node node : m) {
                    arrayList2.addAll(node.children);
                }
            }
            return arrayList2;
        }
        return new ArrayList();
    }

    public boolean i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224908958")) {
            return ((Boolean) ipChange.ipc$dispatch("-224908958", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b.contains(str);
    }

    public List<Node> l(BaseSection baseSection, GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972744584")) {
            return (List) ipChange.ipc$dispatch("1972744584", new Object[]{this, baseSection, globalConfig});
        }
        if (baseSection == null) {
            jb1.a(this.a, "========= start parse2NodeBySection error null ========= ");
            return null;
        }
        String str = this.a;
        jb1.a(str, "========= start parse2NodeBySection ========= id : " + baseSection.getComponentId());
        ArrayList arrayList = new ArrayList();
        if (baseSection.getItem() == null) {
            baseSection.setItem(new JSONObject());
        }
        NodeData item = baseSection.getItem();
        if (item.containsKey("result") && (item.get("result") instanceof JSONArray) && baseSection.getComponentType() == 1) {
            JSONArray jSONArray = item.getJSONArray("result");
            String str2 = this.a;
            jb1.a(str2, "========= start parse2NodeBySection parse JSONArray ========= : " + jSONArray);
            if (jSONArray != null && jSONArray.size() > 0) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    Node n = n(baseSection, globalConfig, jSONArray.getJSONObject(i));
                    if (n != null) {
                        if (i > 0 && baseSection.getStyle() != null && baseSection.getStyle().containsKey("native")) {
                            baseSection.getStyle().remove("native");
                            n.data.put("styleInfo", (Object) baseSection.getStyle());
                        }
                        arrayList.add(n);
                    }
                }
            }
        } else {
            String str3 = this.a;
            jb1.a(str3, "========= start parse2NodeBySection parse JSONObject ========= : " + baseSection.getItem());
            Node n2 = n(baseSection, globalConfig, baseSection.getItem());
            if (n2 != null) {
                arrayList.add(n2);
            }
        }
        String str4 = this.a;
        jb1.a(str4, "========= end parse2NodeBySection ========= nodeList : " + arrayList);
        return arrayList;
    }

    public Node n(BaseSection baseSection, GlobalConfig globalConfig, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653815046")) {
            return (Node) ipChange.ipc$dispatch("653815046", new Object[]{this, baseSection, globalConfig, jSONObject});
        }
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        Node node = new Node();
        JSONObject jSONObject2 = new JSONObject();
        node.data = jSONObject2;
        jSONObject2.put("node_id", (Object) baseSection.getSectionId());
        node.data.put("componentId", (Object) baseSection.getComponentId());
        node.data.put("item", (Object) jSONObject);
        int componentType = baseSection.getComponentType();
        node.data.put(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, (Object) Integer.valueOf(componentType));
        node.data.put("dxConfig", (Object) baseSection.getDxConfig());
        node.data.put("gaiaxConfig", (Object) baseSection.getGaiaxConfig());
        if (componentType == 2 && globalConfig != null) {
            String componentId = baseSection.getComponentId();
            if (!TextUtils.equals("damai_home_brand_list", componentId) && !TextUtils.equals("damai_home_market_ad", componentId)) {
                if (TextUtils.equals("damai_home_grabticket_notice", componentId) && TextUtils.equals("true", globalConfig.comboDegrade) && jSONObject.getJSONObject("top") != null) {
                    jSONObject.getJSONObject("top").put("status", "3");
                }
            } else {
                node.data.put("globalConfig", (Object) globalConfig.fixDxGlobalCon());
            }
        }
        node.data.put("trackInfo", (Object) h(globalConfig != null ? globalConfig.pageName : null, baseSection, globalConfig));
        node.data.put("styleInfo", (Object) baseSection.getStyle());
        JSONObject jSONObject3 = globalConfig.extraInfo;
        if (jSONObject3 != null) {
            node.data.put("extraArgs", (Object) jSONObject3);
        }
        node.data.put("abBucket", (Object) baseSection.getAbBucket());
        return node;
    }
}
