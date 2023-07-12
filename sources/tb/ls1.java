package tb;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import cn.damai.seat.bean.VenueImage;
import cn.damai.seat.support.combine.ICombiner;
import cn.damai.seat.support.combine.OnPicCombineListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ls1 implements ICombiner {
    private static transient /* synthetic */ IpChange $ipChange;
    public final VenueImage a = new VenueImage();
    public final RegionData b;
    private final boolean c;
    private final hs d;
    private PriceInfo e;
    private Picture f;
    private PictureDrawable g;
    private List<List<PointLocation>> h;
    private List<RegionBound> i;
    private float j;
    private OnPicCombineListener k;

    public ls1(RegionData regionData, OnPicCombineListener onPicCombineListener) {
        hs hsVar = new hs();
        this.d = hsVar;
        this.j = 1.0f;
        this.b = regionData;
        this.c = hsVar.e(regionData);
        this.k = onPicCombineListener;
    }

    private g52 a(boolean z, @Nullable PriceLevel priceLevel) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173045697")) {
            return (g52) ipChange.ipc$dispatch("1173045697", new Object[]{this, Boolean.valueOf(z), priceLevel});
        }
        RegionData regionData = this.b;
        if (regionData == null || (regionInfo = regionData.ri) == null) {
            return new j50();
        }
        if (z) {
            return new jk1(priceLevel, this.e, regionInfo.regionList, regionInfo.standColorList, regionInfo.mRegionIdMatchList);
        }
        return new kk1(priceLevel, this.e, regionInfo.regionList);
    }

    public Picture b(PriceLevel priceLevel) {
        BaseSVG regionSvg;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047006665")) {
            return (Picture) ipChange.ipc$dispatch("-1047006665", new Object[]{this, priceLevel});
        }
        if (this.e == null) {
            return null;
        }
        if (this.c) {
            regionSvg = this.a.getRainBowSvg();
        } else {
            regionSvg = this.a.getRegionSvg();
        }
        if (regionSvg == null || regionSvg.getSvgPaintData() == null) {
            return null;
        }
        return regionSvg.getSvgPaintData().buildPicture(a(this.c, priceLevel));
    }

    public void c(ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011119227")) {
            ipChange.ipc$dispatch("-2011119227", new Object[]{this, imageData});
        } else if (imageData != null) {
            String imageUrl = imageData.getImageUrl();
            if (imageUrl.equals(this.b.ri.rainbowSvgImg)) {
                this.a.setRainBowSvg(imageData.getSVG());
            } else if (imageUrl.equals(this.b.ri.seatSvgImg)) {
                this.a.setRegionSvg(imageData.getSVG());
            }
            combineIfNeed();
        }
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void combineIfNeed() {
        BaseSVG regionSvg;
        g52 wd2Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757167779")) {
            ipChange.ipc$dispatch("-757167779", new Object[]{this});
        } else if (this.e == null) {
        } else {
            if (this.c) {
                regionSvg = this.a.getRainBowSvg();
            } else {
                regionSvg = this.a.getRegionSvg();
            }
            BaseSVG regionSvg2 = this.a.getRegionSvg();
            if (regionSvg2 == null || regionSvg2.getSvgPaintData() == null || regionSvg == null || regionSvg.getSvgPaintData() == null) {
                return;
            }
            AbstractC0856a svgPaintData = regionSvg.getSvgPaintData();
            AbstractC0856a svgPaintData2 = regionSvg2.getSvgPaintData();
            if (this.c) {
                wd2Var = a(true, null);
            } else if (!this.d.f(this.b)) {
                wd2Var = a(false, null);
            } else {
                wd2Var = new wd2();
            }
            this.f = svgPaintData.buildPicture(wd2Var);
            svgPaintData2.setRegionColorData(null);
            svgPaintData2.setRainbowColorData(null);
            this.g = new PictureDrawable(svgPaintData2.buildPicture(true));
            this.j = regionSvg2.getSVGScale();
            this.h = regionSvg2.getRegionLocationMap();
            List<RegionBound> regionBounds = regionSvg2.getRegionBounds();
            this.i = regionBounds;
            if (this.k != null) {
                this.k.onPicCombineFinish(new ms1(this.f, this.g, this.h, regionBounds, this.j));
            }
        }
    }

    public void d(PriceInfo priceInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060478257")) {
            ipChange.ipc$dispatch("-2060478257", new Object[]{this, priceInfo});
            return;
        }
        this.e = priceInfo;
        combineIfNeed();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public boolean isPrepared() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1708914632") ? ((Boolean) ipChange.ipc$dispatch("-1708914632", new Object[]{this})).booleanValue() : (this.f == null || this.g == null) ? false : true;
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void removeDynamic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440123668")) {
            ipChange.ipc$dispatch("1440123668", new Object[]{this});
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
    }
}
