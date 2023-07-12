package cn.damai.commonbusiness.home.bean;

import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class TabExtraBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String iconUrl;
    public HomeContentFloatBean.Data mFind;
    public String msg;

    @Nullable
    public static Bundle makeFindBundleIfNeed(TabExtraBean tabExtraBean) {
        HomeContentFloatBean.Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733425268")) {
            return (Bundle) ipChange.ipc$dispatch("-1733425268", new Object[]{tabExtraBean});
        }
        if (tabExtraBean == null || (data = tabExtraBean.mFind) == null || !data.isValid()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(HomeContentFloatBean.HIGH_LIGHT_CARD_JSON, JSON.toJSONString(tabExtraBean.mFind));
        return bundle;
    }
}
