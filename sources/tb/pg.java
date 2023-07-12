package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.tetris.component.drama.bean.CategoryItemListBean;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class pg {
    private static transient /* synthetic */ IpChange $ipChange;

    @NonNull
    public static CategoryItemListInfo a(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158174644")) {
            return (CategoryItemListInfo) ipChange.ipc$dispatch("1158174644", new Object[]{baseResponse});
        }
        CategoryItemListInfo categoryItemListInfo = new CategoryItemListInfo();
        categoryItemListInfo.total = 0;
        categoryItemListInfo.currentCitySize = 0;
        categoryItemListInfo.nearByCitySize = 0;
        if (baseResponse != null && !cb2.d(baseResponse.layers)) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                List<BaseSection> sections = next.getSections();
                if (!cb2.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals(baseSection.getComponentId(), xl2.DM_PROJECT_LIST_BELOW_FILTER_PANEL_CID) && baseSection.getItem() != null) {
                            try {
                                CategoryItemListBean categoryItemListBean = (CategoryItemListBean) JSON.parseObject(baseSection.getItem().toJSONString(), CategoryItemListBean.class);
                                categoryItemListInfo.total = categoryItemListBean.total;
                                categoryItemListInfo.currentCitySize = wh2.e(categoryItemListBean.currentCity);
                                categoryItemListInfo.nearByCitySize = wh2.e(categoryItemListBean.nearByCity);
                                categoryItemListInfo.findComponent = true;
                                categoryItemListInfo.targetLayerId = next.getLayerId();
                                categoryItemListInfo.targetSectionId = baseSection.getSectionId();
                                return categoryItemListInfo;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return categoryItemListInfo;
    }

    public static boolean b(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054878923")) {
            return ((Boolean) ipChange.ipc$dispatch("2054878923", new Object[]{baseResponse})).booleanValue();
        }
        if (baseResponse != null && cb2.g(baseResponse.layers)) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (cb2.g(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals(xl2.DM_PROJECT_FILTER_PANEL_CID, baseSection.getComponentId())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }
}
