package cn.damai.category.ranking.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7556077017399395428L;
    public String benefitPoint;
    public String buttonTitle;
    public String categoryName;
    public String cityName;
    public String extraInfo;
    public String hasVideo;
    public String id;
    public int index;
    public String ipvuv;
    public String name;
    public int order;
    public String priceLow;
    public String reason;
    public String schema;
    public String showTime;
    public String trend;
    public String venueName;
    public String verticalPic;

    public boolean hasVideo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "990726675") ? ((Boolean) ipChange.ipc$dispatch("990726675", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.hasVideo) && this.hasVideo.equals("true");
    }
}
