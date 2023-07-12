package cn.damai.commonbusiness.home.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomeFloatResBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public JSONObject item;
    public String type;

    public boolean isPopContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-783573902") ? ((Boolean) ipChange.ipc$dispatch("-783573902", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type);
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1324508548") ? ((Boolean) ipChange.ipc$dispatch("-1324508548", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.type) || this.item == null) ? false : true;
    }

    public boolean isWantSee() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1804269259") ? ((Boolean) ipChange.ipc$dispatch("-1804269259", new Object[]{this})).booleanValue() : TextUtils.equals("3", this.type);
    }

    public boolean isZhiBo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1147220400") ? ((Boolean) ipChange.ipc$dispatch("-1147220400", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.type);
    }
}
