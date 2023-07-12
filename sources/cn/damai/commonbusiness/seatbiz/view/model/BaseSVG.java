package cn.damai.commonbusiness.seatbiz.view.model;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BaseSVG {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    private RectF bounds;
    protected List<RegionBound> mRegionBounds;
    protected Picture picture;
    protected List<List<PointLocation>> regionLocationList;
    protected AbstractC0856a svgPaintData;
    protected List<String> unrecognizedCommandList;
    protected float svgScale = 1.0f;
    protected PictureDrawable drawable = null;

    @Deprecated
    public RectF getBounds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "783511658") ? (RectF) ipChange.ipc$dispatch("783511658", new Object[]{this}) : this.bounds;
    }

    public PictureDrawable getDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216606870")) {
            return (PictureDrawable) ipChange.ipc$dispatch("216606870", new Object[]{this});
        }
        if (this.drawable == null) {
            this.drawable = new PictureDrawable(this.picture);
        }
        return this.drawable;
    }

    public Picture getPicture() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "30047985") ? (Picture) ipChange.ipc$dispatch("30047985", new Object[]{this}) : this.picture;
    }

    public List<RegionBound> getRegionBounds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1142913762") ? (List) ipChange.ipc$dispatch("-1142913762", new Object[]{this}) : this.mRegionBounds;
    }

    public List<List<PointLocation>> getRegionLocationMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1871554242") ? (List) ipChange.ipc$dispatch("1871554242", new Object[]{this}) : this.regionLocationList;
    }

    public float getSVGScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "382712028") ? ((Float) ipChange.ipc$dispatch("382712028", new Object[]{this})).floatValue() : this.svgScale;
    }

    public AbstractC0856a getSvgPaintData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-124682967") ? (AbstractC0856a) ipChange.ipc$dispatch("-124682967", new Object[]{this}) : this.svgPaintData;
    }

    public List<String> getUnrecognizedCommandList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-932929143") ? (List) ipChange.ipc$dispatch("-932929143", new Object[]{this}) : this.unrecognizedCommandList;
    }

    public void setRegionLocationList(List<List<PointLocation>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565269328")) {
            ipChange.ipc$dispatch("-565269328", new Object[]{this, list});
        } else {
            this.regionLocationList = list;
        }
    }

    public void setSVGScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110049440")) {
            ipChange.ipc$dispatch("-110049440", new Object[]{this, Float.valueOf(f)});
        } else {
            this.svgScale = f;
        }
    }

    public void setSvgPaintData(AbstractC0856a abstractC0856a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526933475")) {
            ipChange.ipc$dispatch("1526933475", new Object[]{this, abstractC0856a});
        } else {
            this.svgPaintData = abstractC0856a;
        }
    }

    public void setUnrecognizedCommandList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584579579")) {
            ipChange.ipc$dispatch("1584579579", new Object[]{this, list});
        } else {
            this.unrecognizedCommandList = list;
        }
    }
}
