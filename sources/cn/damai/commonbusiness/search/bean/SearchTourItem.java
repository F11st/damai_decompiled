package cn.damai.commonbusiness.search.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class SearchTourItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String city;
    public String itemId;
    public String itemSaleStatusDesc;
    public String liveItemUrl;
    public String liveStartTime;
    public String liveStatus;
    public String schema;
    public String showTime;
    public String status;
    public String type;

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963559434")) {
            return (String) ipChange.ipc$dispatch("-1963559434", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.liveItemUrl)) {
            return this.liveItemUrl;
        }
        if (TextUtils.isEmpty(this.schema)) {
            return null;
        }
        return this.schema;
    }

    public boolean isLiveProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222066686")) {
            return ((Boolean) ipChange.ipc$dispatch("-1222066686", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.liveStatus)) {
            return false;
        }
        return "1".equals(this.liveStatus) || "2".equals(this.liveStatus);
    }

    public boolean isRedBackground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-155017424") ? ((Boolean) ipChange.ipc$dispatch("-155017424", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.type) && this.type.equals("2");
    }
}
