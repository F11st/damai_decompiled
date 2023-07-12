package cn.damai.commonbusiness.seatbiz.view.model;

import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.d;
import com.caverock.androidsvg.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tb.ju1;
import tb.ks;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DMSVG extends BaseSVG {
    private static transient /* synthetic */ IpChange $ipChange;
    private f mSVG;

    private void buildHitLocationInfo(f fVar) {
        List<PointLocation> locationPoint;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453753143")) {
            ipChange.ipc$dispatch("453753143", new Object[]{this, fVar});
        } else if (fVar != null) {
            List<List<PointLocation>> list = this.regionLocationList;
            if (list == null) {
                this.regionLocationList = new ArrayList();
            } else {
                list.clear();
            }
            List<RegionBound> list2 = this.mRegionBounds;
            if (list2 == null) {
                this.mRegionBounds = new ArrayList();
            } else {
                list2.clear();
            }
            List<f.g> l = fVar.l();
            if (l == null || l.isEmpty()) {
                return;
            }
            for (int i = 0; i < l.size(); i++) {
                f.g gVar = l.get(i);
                if (gVar != null) {
                    String[] g = ju1.g(gVar.b());
                    String str = g != null ? g[0] : "";
                    if (!TextUtils.isEmpty(str)) {
                        if (gVar instanceof f.d) {
                            locationPoint = getLocationPoint((f.d) gVar, str);
                        } else {
                            locationPoint = getLocationPoint(gVar.a(), str);
                        }
                        this.regionLocationList.add(locationPoint);
                        if (gVar instanceof f.c) {
                            this.mRegionBounds.add(new RegionBound(str, ((f.c) gVar).e(), locationPoint));
                        } else {
                            this.mRegionBounds.add(new RegionBound(str, locationPoint));
                        }
                    }
                }
            }
        }
    }

    private List<PointLocation> getLocationPoint(RectF rectF, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195636391")) {
            return (List) ipChange.ipc$dispatch("1195636391", new Object[]{this, rectF, str});
        }
        PointLocation pointLocation = new PointLocation();
        pointLocation.id = str;
        pointLocation.x = rectF.left;
        pointLocation.y = rectF.top;
        pointLocation.rectF = rectF;
        PointLocation pointLocation2 = new PointLocation();
        pointLocation2.id = str;
        pointLocation2.x = rectF.right;
        pointLocation2.y = rectF.bottom;
        pointLocation2.rectF = rectF;
        ArrayList arrayList = new ArrayList();
        arrayList.add(pointLocation);
        arrayList.add(pointLocation2);
        return arrayList;
    }

    public Set<String> getSVGIds() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209648773")) {
            return (Set) ipChange.ipc$dispatch("209648773", new Object[]{this});
        }
        f fVar = this.mSVG;
        if (fVar != null) {
            return fVar.n();
        }
        return null;
    }

    public void initSVGData(f fVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841151337")) {
            ipChange.ipc$dispatch("-841151337", new Object[]{this, fVar});
        } else if (fVar == null) {
        } else {
            this.mSVG = fVar;
            buildHitLocationInfo(fVar);
            this.svgScale = this.mSVG.o();
            this.picture = fVar.m();
            ks ksVar = new ks(this);
            ksVar.setSvgScale(this.svgScale);
            setSvgPaintData(ksVar);
        }
    }

    public Picture renderToPicture(d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "741971578")) {
            return (Picture) ipChange.ipc$dispatch("741971578", new Object[]{this, dVar});
        }
        f fVar = this.mSVG;
        if (fVar != null) {
            return fVar.r(dVar);
        }
        return null;
    }

    public void resetCss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1238725334")) {
            ipChange.ipc$dispatch("1238725334", new Object[]{this});
            return;
        }
        f fVar = this.mSVG;
        if (fVar != null) {
            fVar.s();
        }
    }

    private List<PointLocation> getLocationPoint(f.d dVar, String str) {
        float[] e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203352590")) {
            return (List) ipChange.ipc$dispatch("-203352590", new Object[]{this, dVar, str});
        }
        ArrayList arrayList = null;
        if (dVar == null || (e = dVar.e()) == null) {
            return null;
        }
        RectF a = dVar.a();
        if (e.length > 1) {
            arrayList = new ArrayList();
            PointLocation pointLocation = new PointLocation();
            pointLocation.id = str;
            pointLocation.x = e[0];
            pointLocation.y = e[1];
            pointLocation.rectF = a;
            arrayList.add(pointLocation);
            for (int i = 2; i < e.length; i += 2) {
                PointLocation pointLocation2 = new PointLocation();
                float f = e[i];
                float f2 = e[i + 1];
                pointLocation2.id = str;
                pointLocation2.x = f;
                pointLocation2.y = f2;
                pointLocation2.rectF = a;
                arrayList.add(pointLocation2);
            }
            if (!(dVar instanceof f.e)) {
                PointLocation pointLocation3 = new PointLocation();
                pointLocation3.id = str;
                pointLocation3.x = e[0];
                pointLocation3.y = e[1];
                pointLocation3.rectF = a;
                arrayList.add(pointLocation3);
            }
        }
        return arrayList;
    }
}
