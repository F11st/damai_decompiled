package com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TipInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bgImg;
    public String bigImg;
    public String buttonText;
    public String desc;
    public Boolean enableClose;
    public int frequencyCount;
    public String icon;
    public String smallImg;
    public String styleType;
    public String text;
    public String tipId;
    public String title;
    public int type;
    public int duration = -1;
    public int frequencyType = -1;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274147862")) {
            return (String) ipChange.ipc$dispatch("274147862", new Object[]{this});
        }
        return "{ tipId : " + this.tipId + "\ntitle : " + this.title + "\nduration : " + this.duration + "\ntext : " + this.text + "\nbuttonText : " + this.buttonText + "\nbigImg : " + this.bigImg + "\nsmallImg : " + this.smallImg + "\nenableClose : " + this.enableClose + "\nstyleType : " + this.styleType + "\nfrequencyType : " + this.frequencyType + "\nfrequencyCount : " + this.frequencyCount + "}";
    }
}
