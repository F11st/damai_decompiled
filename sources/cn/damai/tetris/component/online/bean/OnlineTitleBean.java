package cn.damai.tetris.component.online.bean;

import android.text.TextUtils;
import cn.damai.tetris.core.StyleInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OnlineTitleBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean showAll = false;
    public String subTitle;
    public String title;
    public String url;

    public static OnlineTitleBean fromTetrisStyle(StyleInfo styleInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923901557")) {
            return (OnlineTitleBean) ipChange.ipc$dispatch("-1923901557", new Object[]{styleInfo});
        }
        OnlineTitleBean onlineTitleBean = new OnlineTitleBean();
        if (styleInfo != null) {
            String string = styleInfo.getString("title");
            String string2 = styleInfo.getString("subTitle");
            String string3 = styleInfo.getString("url");
            onlineTitleBean.title = string;
            onlineTitleBean.subTitle = string2;
            onlineTitleBean.url = string3;
        }
        return onlineTitleBean;
    }

    public boolean hasUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1606781265") ? ((Boolean) ipChange.ipc$dispatch("1606781265", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.url);
    }
}
