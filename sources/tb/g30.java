package tb;

import android.text.TextUtils;
import android.util.Log;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.homepage.bean.HomeConfigAgreementBean;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomeConfigHeadStyleBean;
import cn.damai.homepage.bean.HomeConfigSearchTipBean;
import cn.damai.homepage.bean.HomePageDetailedList;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class g30 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static BaseResponse a(BaseResponse baseResponse) {
        BaseSection baseSection;
        JSONObject jSONObject;
        Object obj;
        HomePageDetailedList homePageDetailedList;
        List<HomePageDetailedList.DetailedListItem> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-601113418")) {
            return (BaseResponse) ipChange.ipc$dispatch("-601113418", new Object[]{baseResponse});
        }
        BaseSection baseSection2 = null;
        HomeData.topItemId = null;
        if (baseResponse != null && !m91.a(baseResponse.layers)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            Iterator<BaseLayer> it = arrayList.iterator();
            BaseLayer baseLayer = null;
            BaseLayer baseLayer2 = null;
            while (it.hasNext()) {
                BaseLayer next = it.next();
                if (next != null) {
                    List<BaseSection> sections = next.getSections();
                    if (!cb2.d(sections)) {
                        for (BaseSection baseSection3 : sections) {
                            if (baseSection3 != null) {
                                String componentId = baseSection3.getComponentId();
                                if (TextUtils.equals(xl2.DM_HOME_BANNER_CID, componentId)) {
                                    baseLayer = next;
                                } else if (TextUtils.equals(xl2.DM_HOME_FIVE_ENTRY_CID, componentId)) {
                                    baseLayer2 = next;
                                }
                            }
                        }
                    }
                }
            }
            if (baseLayer == null || baseLayer2 == null) {
                BaseResponse j = yy0.j();
                BaseSection d = yy0.d(xl2.DM_HOME_BANNER_CID, j);
                baseSection = yy0.d(xl2.DM_HOME_FIVE_ENTRY_CID, j);
                baseSection2 = d;
            } else {
                baseSection = null;
            }
            BaseLayer baseLayer3 = arrayList.get(0);
            if (baseLayer3 != null && baseLayer == null && baseSection2 != null) {
                List<BaseSection> sections2 = baseLayer3.getSections();
                if (sections2 == null) {
                    sections2 = new ArrayList<>();
                    baseLayer3.setSections(sections2);
                }
                sections2.add(0, baseSection2);
                baseLayer = baseLayer3;
            }
            if (baseLayer != null && baseLayer2 == null && baseSection != null) {
                List<BaseSection> sections3 = baseLayer.getSections();
                if (!cb2.d(sections3)) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= sections3.size()) {
                            break;
                        }
                        BaseSection baseSection4 = sections3.get(i2);
                        if (baseSection4 != null && TextUtils.equals(xl2.DM_HOME_BANNER_CID, baseSection4.getComponentId())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                    if (i >= 0) {
                        baseLayer.getSections().add(i + 1, baseSection);
                    }
                }
            }
            for (int i3 = 0; i3 < baseResponse.layers.size(); i3++) {
                try {
                    BaseLayer baseLayer4 = baseResponse.layers.get(i3);
                    if (baseLayer4 != null && !m91.a(baseLayer4.getSections())) {
                        for (int i4 = 0; i4 < baseLayer4.getSections().size(); i4++) {
                            BaseSection baseSection5 = baseLayer4.getSections().get(i4);
                            if (baseSection5 != null && baseSection5.getComponentId() != null) {
                                if ("damai_home_detailed_list".equals(baseSection5.getComponentId()) && baseSection5.getItem() != null && (homePageDetailedList = (HomePageDetailedList) JSON.parseObject(baseSection5.getItem().toJSONString(), HomePageDetailedList.class)) != null && homePageDetailedList.content != null && (list = homePageDetailedList.discount) != null) {
                                    if (!cb2.d(list)) {
                                        for (HomePageDetailedList.DetailedListItem detailedListItem : list) {
                                            if (detailedListItem != null) {
                                                detailedListItem.type = "2";
                                            }
                                        }
                                        homePageDetailedList.content.addAll(0, homePageDetailedList.discount);
                                    }
                                    baseSection5.getItem().put("content", JSON.toJSON(homePageDetailedList.content));
                                }
                                if ("damai_home_grabticket_notice".equals(baseSection5.getComponentId()) && baseSection5.getItem() != null && baseSection5.getItem().containsKey("top") && (jSONObject = baseSection5.getItem().getJSONObject("top")) != null && jSONObject.containsKey("itemId") && (obj = jSONObject.get("itemId")) != null) {
                                    HomeData.topItemId = obj.toString();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Log.e("HomeData", "HomeData.topItemId=" + HomeData.topItemId);
            return baseResponse;
        }
        BaseResponse j2 = yy0.j();
        return j2 != null ? j2 : baseResponse;
    }

    public static int b(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088916645")) {
            return ((Integer) ipChange.ipc$dispatch("-2088916645", new Object[]{baseResponse})).intValue();
        }
        int i = 2;
        if (baseResponse != null && !m91.a(baseResponse.layers)) {
            for (int i2 = 0; i2 < baseResponse.layers.size(); i2++) {
                BaseLayer baseLayer = baseResponse.layers.get(i2);
                if (baseLayer != null && !m91.a(baseLayer.getSections())) {
                    i += baseLayer.getSections().size();
                }
            }
        }
        return i;
    }

    public static HomeHeaderBg c(HomeConfigBean homeConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980118651")) {
            return (HomeHeaderBg) ipChange.ipc$dispatch("1980118651", new Object[]{homeConfigBean});
        }
        if (homeConfigBean.headLottie == null && homeConfigBean.headStyle == null) {
            return null;
        }
        HomeHeaderBg homeHeaderBg = new HomeHeaderBg();
        homeHeaderBg.type = 999;
        homeHeaderBg.weiyiId = "&999&homeheaderbg1";
        homeHeaderBg.headLottie = homeConfigBean.headLottie;
        HomeConfigHeadStyleBean homeConfigHeadStyleBean = homeConfigBean.headStyle;
        if (homeConfigHeadStyleBean != null) {
            homeHeaderBg.headBackgroudPic = homeConfigHeadStyleBean.headBackgroudPic;
            homeHeaderBg.headColor = homeConfigHeadStyleBean.headColor;
        }
        return homeHeaderBg;
    }

    public static String d(HomeConfigBean homeConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1755933082")) {
            return (String) ipChange.ipc$dispatch("-1755933082", new Object[]{homeConfigBean});
        }
        HomeConfigSearchTipBean homeConfigSearchTipBean = homeConfigBean.searchTip;
        if (homeConfigSearchTipBean != null) {
            return homeConfigSearchTipBean.keyword;
        }
        return null;
    }

    public static BaseLayer e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640304091")) {
            return (BaseLayer) ipChange.ipc$dispatch("-1640304091", new Object[]{str});
        }
        BaseLayer baseLayer = new BaseLayer();
        ArrayList arrayList = new ArrayList();
        BaseSection obj2Section = BaseSection.obj2Section("dm_home_weinituijian_title", JSON.parseObject("{\"mainTitles\":" + str + "}"), null);
        obj2Section.setSectionId("dm-home-weinituijian-title");
        arrayList.add(obj2Section);
        baseLayer.setSections(arrayList);
        return baseLayer;
    }

    private static boolean f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982007152")) {
            return ((Boolean) ipChange.ipc$dispatch("982007152", new Object[]{str, str2})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || str.equals("0")) {
            return false;
        }
        return str2 == null || !str2.equals(str);
    }

    public static void g(HomeConfigBean homeConfigBean) {
        HomeConfigAgreementBean homeConfigAgreementBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-292121640")) {
            ipChange.ipc$dispatch("-292121640", new Object[]{homeConfigBean});
        } else if (homeConfigBean != null && (homeConfigAgreementBean = homeConfigBean.agreement) != null) {
            String str = homeConfigAgreementBean.pos1;
            String str2 = homeConfigAgreementBean.pos2;
            String str3 = homeConfigAgreementBean.pos3;
            if (ru1.h()) {
                ru1.m();
                ru1.k(JSON.toJSONString(homeConfigBean.agreement));
                return;
            }
            String c = ru1.c();
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (!TextUtils.isEmpty(c)) {
                JSONObject parseObject = JSON.parseObject(c);
                if (parseObject != null) {
                    String string = parseObject.getString("pos1");
                    String string2 = parseObject.getString("pos2");
                    String string3 = parseObject.getString("pos3");
                    if (f(str, string)) {
                        arrayList.add(0);
                    }
                    if (f(str2, string2)) {
                        arrayList.add(1);
                    }
                    if (f(str3, string3)) {
                        arrayList.add(2);
                    }
                }
                if (wh2.e(arrayList) > 0) {
                    if (ru1.d()) {
                        ru1.j(JSON.toJSON(arrayList).toString());
                    } else {
                        try {
                            String b = ru1.b();
                            if (!TextUtils.isEmpty(b)) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.clear();
                                arrayList2.addAll(JSON.parseArray(b, Integer.class));
                                for (int i = 0; i < wh2.e(arrayList2); i++) {
                                    if (!arrayList.contains(arrayList2.get(i))) {
                                        arrayList.add((Integer) arrayList2.get(i));
                                    }
                                }
                                Collections.sort(arrayList);
                            }
                        } catch (Exception unused) {
                        }
                        ru1.j(JSON.toJSON(arrayList).toString());
                    }
                    ru1.l(false);
                }
            }
            ru1.k(JSON.toJSONString(homeConfigBean.agreement));
        }
    }
}
