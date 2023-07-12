package cn.damai.projectfiltercopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.gm;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityCode;
    public String cityName;

    public CityBean(String str, String str2) {
        this.cityCode = str2;
        this.cityName = str;
    }

    public static CityBean defaultCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109794396")) {
            return (CityBean) ipChange.ipc$dispatch("1109794396", new Object[0]);
        }
        gm gmVar = gm.INSTANCE;
        return new CityBean(gmVar.a().getCityName(), gmVar.a().getCityId());
    }
}
