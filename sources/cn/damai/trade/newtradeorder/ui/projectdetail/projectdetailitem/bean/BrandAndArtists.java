package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BrandAndArtists implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 5505069933823547959L;
    public String activityId;
    public String bgPicUrl;
    public String desc;
    public long id;
    public int index;
    public String label;
    public String name;
    public String picUrl;
    public String subFlag;
    public String tag;
    public int type;

    public String getFollowStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1786181944") ? (String) ipChange.ipc$dispatch("-1786181944", new Object[]{this}) : (!TextUtils.isEmpty(this.subFlag) && this.subFlag.equals("true")) ? "1" : "0";
    }
}
