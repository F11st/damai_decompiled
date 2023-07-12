package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTour implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -101386840343195078L;
    public String cityName;
    public int index;
    public String itemId;
    public String schema;
    public String showTime;
    public String tourId;

    public boolean isCurrentCityProject(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "305624093") ? ((Boolean) ipChange.ipc$dispatch("305624093", new Object[]{this, str})).booleanValue() : (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.itemId) || !this.itemId.equals(str)) ? false : true;
    }
}
