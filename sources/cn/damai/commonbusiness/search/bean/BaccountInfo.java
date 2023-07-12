package cn.damai.commonbusiness.search.bean;

import android.text.TextUtils;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BaccountInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ActivityInfo activityDO;
    public String backgroundPic;
    private StringBuilder builder = new StringBuilder();
    public String damaiId;
    public String description;
    public String distance;
    public String fansCount;
    public String followStatus;
    public String headPic;
    public String id;
    public int index;
    public List<String> moreInfo;
    public String moreMessage;
    public String name;
    public String performanceCount;
    public String schema;
    public String subTitle;
    public String subtype;
    public String type;
    public String vaccount;

    public String getAccountFansDesc() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "327483577")) {
            return (String) ipChange.ipc$dispatch("327483577", new Object[]{this});
        }
        StringBuilder sb = this.builder;
        sb.delete(0, sb.length());
        if (TextUtils.isEmpty(this.performanceCount) || this.performanceCount.equals("0")) {
            z = false;
        } else {
            StringBuilder sb2 = this.builder;
            sb2.append(this.performanceCount + "场在售演出");
        }
        String fansCount = getFansCount(this.fansCount);
        if (!TextUtils.isEmpty(fansCount)) {
            if (z) {
                this.builder.append(" | ");
            }
            this.builder.append(fansCount);
        }
        return this.builder.length() > 0 ? this.builder.toString() : "";
    }

    public String getFansCount(String str) {
        double d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744080224")) {
            return (String) ipChange.ipc$dispatch("-744080224", new Object[]{this, str});
        }
        try {
            d = Double.parseDouble(str);
        } catch (Exception unused) {
            d = 0.0d;
        }
        if (d > 0.0d) {
            if (d < 10000.0d) {
                return str + " 粉丝";
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            return decimalFormat.format(d / 10000.0d) + "万粉丝";
        }
        return "";
    }

    public boolean isHasFollow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "68053598") ? ((Boolean) ipChange.ipc$dispatch("68053598", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.followStatus) || "0".equals(this.followStatus)) ? false : true;
    }

    public boolean isMusicType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406208458")) {
            return ((Boolean) ipChange.ipc$dispatch("1406208458", new Object[]{this})).booleanValue();
        }
        if (TextUtils.equals("5", this.type)) {
            return TextUtils.equals("音乐节", this.subtype);
        }
        return false;
    }

    public boolean isShowVTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1274544056") ? ((Boolean) ipChange.ipc$dispatch("-1274544056", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.vaccount) || "0".equals(this.vaccount)) ? false : true;
    }
}
