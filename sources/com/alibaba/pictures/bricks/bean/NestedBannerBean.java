package com.alibaba.pictures.bricks.bean;

import android.graphics.Color;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alient.onearch.adapter.view.GenericViewCard;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NestedBannerBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public JSONObject action;
    public String color;
    public String id;
    public String pic;
    public String picHigh;
    public String schema;
    public String subPic1;
    public String subPic2;
    public String subPic3;
    public String subPicText1;
    public String subPicText2;
    public String subPicText3;
    @JSONField(deserialize = false, serialize = false)
    public GenericViewCard temp;
    public String type;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824095540")) {
            return ((Boolean) ipChange.ipc$dispatch("-824095540", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NestedBannerBean nestedBannerBean = (NestedBannerBean) obj;
        return nm1.a(this.id, nestedBannerBean.id) && nm1.a(this.pic, nestedBannerBean.pic) && nm1.a(this.picHigh, nestedBannerBean.picHigh) && nm1.a(this.schema, nestedBannerBean.schema) && nm1.a(this.color, nestedBannerBean.color) && nm1.a(this.subPic1, nestedBannerBean.subPic1) && nm1.a(this.subPicText1, nestedBannerBean.subPicText1) && nm1.a(this.subPic2, nestedBannerBean.subPic2) && nm1.a(this.subPicText2, nestedBannerBean.subPicText2) && nm1.a(this.subPic3, nestedBannerBean.subPic3) && nm1.a(this.type, nestedBannerBean.type);
    }

    public int getBgColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280223722")) {
            return ((Integer) ipChange.ipc$dispatch("-1280223722", new Object[]{this})).intValue();
        }
        try {
            return Color.parseColor(this.color);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-782739325") ? ((Integer) ipChange.ipc$dispatch("-782739325", new Object[]{this})).intValue() : nm1.b(this.id, this.pic, this.picHigh, this.schema, this.color, this.subPic1, this.subPicText1, this.subPic2, this.subPicText2, this.subPic3, this.type);
    }

    public boolean isSuperFrameBanner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1618054215") ? ((Boolean) ipChange.ipc$dispatch("1618054215", new Object[]{this})).booleanValue() : "1".equalsIgnoreCase(this.type);
    }
}
