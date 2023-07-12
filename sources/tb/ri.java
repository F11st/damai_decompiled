package tb;

import android.text.TextUtils;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ri implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    private void a(BaseSection baseSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291508811")) {
            ipChange.ipc$dispatch("291508811", new Object[]{this, baseSection});
            return;
        }
        try {
            TrackInfo trackInfo = baseSection.getTrackInfo();
            StyleInfo style = baseSection.getStyle();
            if (trackInfo == null) {
                trackInfo = new TrackInfo();
                baseSection.setTrackInfo(trackInfo);
            }
            if (style != null) {
                String string = style.getString("title");
                if (!TextUtils.isEmpty(string)) {
                    trackInfo.put("titlelabel", (Object) string);
                }
            }
            String d = z20.d();
            trackInfo.put("usercode", (Object) z20.E());
            trackInfo.put("city", (Object) d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: b */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, db dbVar) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199472700")) {
            return (List) ipChange.ipc$dispatch("-199472700", new Object[]{this, baseResponse, baseSection, globalConfig, dbVar});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        a(baseSection);
        if (item != null && (jSONArray = item.getJSONArray("data")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("cardType");
                    if (TextUtils.equals("1", string)) {
                        baseSection.setComponentId(xl2.BIG_NOTE_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l = dbVar.l(baseSection, globalConfig);
                        if (l != null) {
                            arrayList.addAll(l);
                        }
                    } else if (TextUtils.equals("2", string)) {
                        baseSection.setComponentId(xl2.BIG_THEME_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l2 = dbVar.l(baseSection, globalConfig);
                        if (l2 != null) {
                            arrayList.addAll(l2);
                        }
                    } else if (TextUtils.equals("6", string)) {
                        baseSection.setComponentId(xl2.DISCUSS_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l3 = dbVar.l(baseSection, globalConfig);
                        if (l3 != null) {
                            arrayList.addAll(l3);
                        }
                    } else if (TextUtils.equals("5", string)) {
                        baseSection.setComponentId(xl2.BIG_VOTE_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l4 = dbVar.l(baseSection, globalConfig);
                        if (l4 != null) {
                            arrayList.addAll(l4);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
