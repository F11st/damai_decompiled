package cn.damai.commonbusiness.search.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class MarketTabBase implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MARKET_UT_KEY = "discount_type";
    public List<MarketTagBean> marketPromotionTags;

    public String gotMarketUTValue() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "258578276")) {
            return (String) ipChange.ipc$dispatch("258578276", new Object[]{this});
        }
        if (ifIsNewMarketTag()) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!n91.b(this.marketPromotionTags)) {
                for (MarketTagBean marketTagBean : this.marketPromotionTags) {
                    if (marketTagBean != null) {
                        stringBuffer.append(marketTagBean.type);
                        if (i < this.marketPromotionTags.size() - 1) {
                            stringBuffer.append(",");
                        }
                    }
                    i++;
                }
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public MarketTagBean gotPostTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656398716")) {
            return (MarketTagBean) ipChange.ipc$dispatch("1656398716", new Object[]{this});
        }
        if (n91.b(this.marketPromotionTags)) {
            return null;
        }
        for (MarketTagBean marketTagBean : this.marketPromotionTags) {
            if (marketTagBean != null && marketTagBean.showOnPic()) {
                return marketTagBean;
            }
        }
        return null;
    }

    public MarketTagBean gotTopTag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374691941")) {
            return (MarketTagBean) ipChange.ipc$dispatch("1374691941", new Object[]{this, Boolean.valueOf(z)});
        }
        if (ifIsNewMarketTag() && !n91.b(this.marketPromotionTags)) {
            for (MarketTagBean marketTagBean : this.marketPromotionTags) {
                if (marketTagBean.showOnPic()) {
                    if (z) {
                    }
                }
                return marketTagBean;
            }
        }
        return null;
    }

    public boolean ifIsNewMarketTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2042339515") ? ((Boolean) ipChange.ipc$dispatch("-2042339515", new Object[]{this})).booleanValue() : (n91.b(this.marketPromotionTags) || this.marketPromotionTags.get(0) == null || (TextUtils.isEmpty(this.marketPromotionTags.get(0).tag) && TextUtils.isEmpty(this.marketPromotionTags.get(0).shortTag))) ? false : true;
    }
}
