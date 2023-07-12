package tb;

import cn.damai.homepage.bean.HomePageData;
import cn.damai.homepage.bean.HomePageWaterFlowRecommend;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ly0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static List<fm> a(int i, int i2, List<WaterFlowRecommendItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124876596")) {
            return (List) ipChange.ipc$dispatch("124876596", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list});
        }
        if (m91.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            WaterFlowRecommendItem waterFlowRecommendItem = list.get(i3);
            if (waterFlowRecommendItem != null && gh1.b(waterFlowRecommendItem.cardType)) {
                waterFlowRecommendItem.pageNum = i;
                waterFlowRecommendItem.index = i2 + i3;
                arrayList.add(new w03(waterFlowRecommendItem.cardType, waterFlowRecommendItem));
            }
        }
        return arrayList;
    }

    public static HomePageWaterFlowRecommend b(HomePageData homePageData) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788486359")) {
            return (HomePageWaterFlowRecommend) ipChange.ipc$dispatch("1788486359", new Object[]{homePageData});
        }
        if (homePageData == null || m91.a(homePageData.sections) || (jSONArray = homePageData.sections.get(0).getJSONArray("items")) == null || t41.b(jSONArray) <= 0 || (jSONObject = jSONArray.getJSONObject(0)) == null) {
            return null;
        }
        try {
            return (HomePageWaterFlowRecommend) JSON.parseObject(jSONObject.toJSONString(), HomePageWaterFlowRecommend.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
