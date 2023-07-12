package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import cn.damai.tetris.core.StyleInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CardTitleBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean showAll = false;
    public boolean showTitleLayout = false;
    public String subTitle;
    public String title;
    public String url;

    public static CardTitleBean fromTetrisStyle(StyleInfo styleInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1079150521")) {
            return (CardTitleBean) ipChange.ipc$dispatch("1079150521", new Object[]{styleInfo});
        }
        CardTitleBean cardTitleBean = new CardTitleBean();
        if (styleInfo != null) {
            String string = styleInfo.getString("title");
            String string2 = styleInfo.getString("subTitle");
            String string3 = styleInfo.getString("url");
            Boolean bool = styleInfo.getBoolean("showAll");
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            cardTitleBean.title = string;
            cardTitleBean.subTitle = string2;
            cardTitleBean.url = string3;
            cardTitleBean.showAll = booleanValue;
            if (TextUtils.isEmpty(string) && !booleanValue) {
                z = false;
            }
            cardTitleBean.showTitleLayout = z;
        }
        return cardTitleBean;
    }

    public boolean hasUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1813558834") ? ((Boolean) ipChange.ipc$dispatch("1813558834", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.url);
    }
}
