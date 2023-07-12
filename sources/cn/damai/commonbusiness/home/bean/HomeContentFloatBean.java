package cn.damai.commonbusiness.home.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomeContentFloatBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HIGH_LIGHT_CARD_JSON = "high_light_card_json";
    public String data;
    public String msg;
    public String pic;
    public String target;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class Data implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String id;
        public String type;

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2092514523") ? ((Boolean) ipChange.ipc$dispatch("2092514523", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.id)) ? false : true;
        }
    }

    @Nullable
    public static TabExtraBean getValidBean(JSONObject jSONObject) {
        Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246907493")) {
            return (TabExtraBean) ipChange.ipc$dispatch("-1246907493", new Object[]{jSONObject});
        }
        if (jSONObject != null) {
            HomeContentFloatBean homeContentFloatBean = (HomeContentFloatBean) m61.d(jSONObject, HomeContentFloatBean.class);
            if (TextUtils.isEmpty(homeContentFloatBean.data) || (data = (Data) m61.a(homeContentFloatBean.data, Data.class)) == null || !data.isValid()) {
                return null;
            }
            TabExtraBean tabExtraBean = new TabExtraBean();
            tabExtraBean.iconUrl = homeContentFloatBean.pic;
            tabExtraBean.msg = homeContentFloatBean.msg;
            tabExtraBean.mFind = data;
            return tabExtraBean;
        }
        return null;
    }
}
