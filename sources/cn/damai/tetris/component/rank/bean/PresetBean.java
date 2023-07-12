package cn.damai.tetris.component.rank.bean;

import android.content.Intent;
import android.text.TextUtils;
import cn.damai.rank.RankSquareCMSActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PresetBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categoryId;
    public String cityId;
    public String cityName;

    public PresetBean() {
    }

    public static PresetBean obtainPresetBean(Intent intent) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515421129")) {
            return (PresetBean) ipChange.ipc$dispatch("-515421129", new Object[]{intent});
        }
        String str3 = null;
        if (intent == null || intent.getExtras() == null) {
            str = null;
            str2 = null;
        } else {
            str3 = intent.getStringExtra(RankSquareCMSActivity.PRESET_CITY_NAME);
            str2 = intent.getStringExtra("cityId");
            str = intent.getStringExtra("categoryId");
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            str2 = z20.c();
            str3 = z20.d();
        }
        return new PresetBean(str2, str3, str);
    }

    public static CategoryTabBean obtainSelected(List<CategoryTabBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382900219")) {
            return (CategoryTabBean) ipChange.ipc$dispatch("1382900219", new Object[]{list, str});
        }
        if (cb2.d(list)) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            for (CategoryTabBean categoryTabBean : list) {
                if (TextUtils.equals(str, categoryTabBean.id)) {
                    return categoryTabBean;
                }
            }
        }
        return list.get(0);
    }

    public PresetBean(String str, String str2, String str3) {
        this.cityId = str;
        this.cityName = str2;
        this.categoryId = str3;
    }
}
