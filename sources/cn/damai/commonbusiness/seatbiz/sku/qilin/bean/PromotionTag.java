package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionTag implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String mktPromotionTips;
    public Tag otherTag;
    public Tag promotionTag;

    public String getValidTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795780437")) {
            return (String) ipChange.ipc$dispatch("-1795780437", new Object[]{this});
        }
        Tag tag = this.otherTag;
        if (tag != null && !TextUtils.isEmpty(tag.tagDesc)) {
            return this.otherTag.tagDesc;
        }
        Tag tag2 = this.promotionTag;
        if (tag2 == null || TextUtils.isEmpty(tag2.tagDesc)) {
            return null;
        }
        return this.promotionTag.tagDesc;
    }

    public boolean isDiscount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "248876922")) {
            return ((Boolean) ipChange.ipc$dispatch("248876922", new Object[]{this})).booleanValue();
        }
        Tag tag = this.promotionTag;
        return (tag == null || TextUtils.isEmpty(tag.tagDesc)) ? false : true;
    }

    public boolean isPositive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654086082")) {
            return ((Boolean) ipChange.ipc$dispatch("654086082", new Object[]{this})).booleanValue();
        }
        Tag tag = this.otherTag;
        if (tag != null) {
            return tag.isPositive();
        }
        Tag tag2 = this.promotionTag;
        if (tag2 != null) {
            return tag2.isPositive();
        }
        return false;
    }

    public boolean validTag() {
        Tag tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219519015")) {
            return ((Boolean) ipChange.ipc$dispatch("219519015", new Object[]{this})).booleanValue();
        }
        Tag tag2 = this.otherTag;
        return ((tag2 == null || TextUtils.isEmpty(tag2.tagDesc)) && ((tag = this.promotionTag) == null || TextUtils.isEmpty(tag.tagDesc))) ? false : true;
    }
}
