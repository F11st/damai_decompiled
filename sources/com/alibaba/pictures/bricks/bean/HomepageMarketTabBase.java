package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomepageMarketTabBase implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MARKET_UT_KEY = "discount_type";
    public List<HomepageMarketTagBean> marketPromotionTags;

    public String gotMarketUTValue() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-424178124")) {
            return (String) ipChange.ipc$dispatch("-424178124", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (!n91.b(this.marketPromotionTags)) {
            for (HomepageMarketTagBean homepageMarketTagBean : this.marketPromotionTags) {
                if (homepageMarketTagBean != null) {
                    stringBuffer.append(homepageMarketTagBean.type);
                    if (i < this.marketPromotionTags.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public HomepageMarketTagBean gotPostTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79240472")) {
            return (HomepageMarketTagBean) ipChange.ipc$dispatch("79240472", new Object[]{this});
        }
        if (n91.b(this.marketPromotionTags)) {
            return null;
        }
        for (HomepageMarketTagBean homepageMarketTagBean : this.marketPromotionTags) {
            if (homepageMarketTagBean != null && homepageMarketTagBean.showOnPic()) {
                return homepageMarketTagBean;
            }
        }
        return null;
    }

    public HomepageMarketTagBean gotTopTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438177283")) {
            return (HomepageMarketTagBean) ipChange.ipc$dispatch("-1438177283", new Object[]{this});
        }
        if (n91.b(this.marketPromotionTags)) {
            return null;
        }
        for (HomepageMarketTagBean homepageMarketTagBean : this.marketPromotionTags) {
            if (homepageMarketTagBean != null) {
                return homepageMarketTagBean;
            }
        }
        return null;
    }
}
