package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeadAtmosphereBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String backgroundPic;
    public String highLowType;
    public String id;
    public String lottie;
    public String schema;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053796501")) {
            return ((Boolean) ipChange.ipc$dispatch("-2053796501", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HeadAtmosphereBean headAtmosphereBean = (HeadAtmosphereBean) obj;
        return nm1.a(this.id, headAtmosphereBean.id) && nm1.a(this.backgroundPic, headAtmosphereBean.backgroundPic) && nm1.a(this.schema, headAtmosphereBean.schema) && nm1.a(this.lottie, headAtmosphereBean.lottie) && nm1.a(this.highLowType, headAtmosphereBean.highLowType);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1292351266") ? ((Integer) ipChange.ipc$dispatch("1292351266", new Object[]{this})).intValue() : nm1.b(this.id, this.backgroundPic, this.schema, this.lottie, this.highLowType);
    }

    public boolean isLottieAtmosphere() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-762890333") ? ((Boolean) ipChange.ipc$dispatch("-762890333", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.lottie);
    }

    public boolean isPicAtmosphere() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "632993698") ? ((Boolean) ipChange.ipc$dispatch("632993698", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.lottie) && !TextUtils.isEmpty(this.backgroundPic);
    }

    public boolean isShowPlaceholderHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1661898671") ? ((Boolean) ipChange.ipc$dispatch("-1661898671", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.highLowType);
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "672552178") ? ((Boolean) ipChange.ipc$dispatch("672552178", new Object[]{this})).booleanValue() : isLottieAtmosphere() || isPicAtmosphere();
    }
}
