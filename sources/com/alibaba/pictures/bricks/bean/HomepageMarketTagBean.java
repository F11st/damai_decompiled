package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import android.view.ViewGroup;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomepageMarketTagBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_ZAONIAO = "ZAONIAO";
    public String prefix;
    public String shortTag;
    public int subType;
    public String tag;
    public String type;
    public String value;

    public DMCommonTagView addMarketTagView(ViewGroup viewGroup, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431635808")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("1431635808", new Object[]{this, viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        if (((!TextUtils.isEmpty(this.tag) && !TextUtils.isEmpty(this.prefix)) || specialTag()) && !z) {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(viewGroup.getContext(), z2);
            if (vipTag()) {
                dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_VIP).setTagContent(this.prefix, this.tag);
            } else if (isWednesdayDiscount()) {
                dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
            } else {
                dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_2PART).setTagContent(this.prefix, this.tag);
            }
            viewGroup.addView(dMCommonTagView);
            return dMCommonTagView;
        }
        DMCommonTagView dMCommonTagView2 = new DMCommonTagView(viewGroup.getContext(), z2);
        if (isWednesdayDiscount()) {
            dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT_HOME);
            viewGroup.addView(dMCommonTagView2);
        } else if (z && !TextUtils.isEmpty(this.shortTag)) {
            if ("VIP".equalsIgnoreCase(this.type)) {
                dMCommonTagView2.setTagAutoTextSize(true);
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_FF866E).setTagName(this.shortTag);
            } else if ("VIP_PRIVILEGE".equalsIgnoreCase(this.type)) {
                dMCommonTagView2.setTagAutoTextSize(true);
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_VIP_PRIVILEGE).setTagName(this.shortTag);
            } else {
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(this.shortTag);
                dMCommonTagView2.setTagAutoTextSize(false);
            }
            viewGroup.addView(dMCommonTagView2);
        } else if (!TextUtils.isEmpty(this.tag)) {
            dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(this.tag);
            dMCommonTagView2.setTagAutoTextSize(false);
            viewGroup.addView(dMCommonTagView2);
        }
        return dMCommonTagView2;
    }

    public boolean isWednesdayDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "920574535") ? ((Boolean) ipChange.ipc$dispatch("920574535", new Object[]{this})).booleanValue() : 1 == this.subType && "SINGLE".equals(this.type);
    }

    public boolean showOnPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "914474214") ? ((Boolean) ipChange.ipc$dispatch("914474214", new Object[]{this})).booleanValue() : "ZAONIAO".equals(this.type);
    }

    public boolean specialTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1584746685") ? ((Boolean) ipChange.ipc$dispatch("1584746685", new Object[]{this})).booleanValue() : vipTag() || BQCScanEngine.COUPON_ENGINE.equalsIgnoreCase(this.type);
    }

    public boolean vipTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-726595679") ? ((Boolean) ipChange.ipc$dispatch("-726595679", new Object[]{this})).booleanValue() : "VIP".equalsIgnoreCase(this.type) || "VIP_PRIVILEGE".equalsIgnoreCase(this.type);
    }
}
