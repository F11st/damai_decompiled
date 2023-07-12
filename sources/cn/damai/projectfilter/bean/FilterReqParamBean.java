package cn.damai.projectfilter.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.Util;
import cn.damai.tetris.componentplugin.bean.CategoryRequestNewParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cb2;
import tb.jm1;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterReqParamBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String dateType;
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String secondLevelSelection;
    public List<String> skipOverrideKeyList;
    public String sortType;
    public String startDate;
    public List<String> categoryIds = new ArrayList();
    public List<Map<String, String>> optionParam = new ArrayList();

    public void assembleCategoryId(List<CategoryBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825676968")) {
            ipChange.ipc$dispatch("-825676968", new Object[]{this, list});
            return;
        }
        for (CategoryBean categoryBean : list) {
            this.categoryIds.add(categoryBean.value);
        }
    }

    public void assembleFilter(HashMap<String, List<FilterBean>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370020843")) {
            ipChange.ipc$dispatch("1370020843", new Object[]{this, hashMap});
        } else if (cb2.h(hashMap)) {
            for (String str : hashMap.keySet()) {
                List<FilterBean> list = hashMap.get(str);
                StringBuilder sb = new StringBuilder();
                if (cb2.g(list)) {
                    for (FilterBean filterBean : list) {
                        sb.append("|");
                        sb.append(filterBean.value);
                    }
                    sb.deleteCharAt(0);
                }
                if (sb.length() > 0) {
                    HashMap hashMap2 = new HashMap(1);
                    hashMap2.put(str, sb.toString());
                    this.optionParam.add(hashMap2);
                }
            }
        }
    }

    @NonNull
    public CategoryRequestNewParams createReqParams() {
        double[] dMCoordinates;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623527")) {
            return (CategoryRequestNewParams) ipChange.ipc$dispatch("1623527", new Object[]{this});
        }
        CategoryRequestNewParams categoryRequestNewParams = new CategoryRequestNewParams();
        categoryRequestNewParams.dateType = jm1.j(this.dateType, 0);
        categoryRequestNewParams.startDate = this.startDate;
        categoryRequestNewParams.endDate = this.endDate;
        if (cb2.g(this.categoryIds)) {
            if (this.categoryIds.size() == 1) {
                categoryRequestNewParams.categoryId = this.categoryIds.get(0);
            } else {
                StringBuilder sb = new StringBuilder();
                for (String str : this.categoryIds) {
                    sb.append("|");
                    sb.append(str);
                }
                sb.deleteCharAt(0);
                categoryRequestNewParams.categoryId = sb.toString();
            }
        }
        categoryRequestNewParams.firstLevelSelection = this.firstLevelSelection;
        categoryRequestNewParams.secondLevelSelection = this.secondLevelSelection;
        categoryRequestNewParams.currentCityId = this.cityId;
        categoryRequestNewParams.sortType = jm1.j(this.sortType, 10);
        if (cb2.g(this.optionParam)) {
            categoryRequestNewParams.optionParam = m61.e(this.optionParam);
        } else {
            categoryRequestNewParams.optionParam = null;
        }
        categoryRequestNewParams.groupId = this.groupId;
        if (TextUtils.equals("4", this.sortType) && (dMCoordinates = Util.getDMCoordinates()) != null) {
            categoryRequestNewParams.longitude = String.valueOf(dMCoordinates[0]);
            categoryRequestNewParams.latitude = String.valueOf(dMCoordinates[1]);
        }
        return categoryRequestNewParams;
    }
}
