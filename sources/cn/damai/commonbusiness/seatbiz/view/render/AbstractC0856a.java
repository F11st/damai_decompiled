package cn.damai.commonbusiness.seatbiz.view.render;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionColorListResult;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.f52;
import tb.g52;
import tb.i12;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.view.render.a */
/* loaded from: classes.dex */
public abstract class AbstractC0856a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected boolean isHasFloorId;
    public List<RegionBound> mRegionBounds = new ArrayList(256);
    private i12 mRegionManager = new i12();
    protected HashMap<String, ArrayList<RegionColorListResult.RegionColorList.RegionColor>> mRegionVid2ColorMap;
    protected HashMap<String, HashMap<String, String>> rainbowColorMap;
    protected HashMap<String, String> regionColorMap;
    protected List<List<PointLocation>> regionLocationList;
    protected float svgScale;

    /* JADX INFO: Access modifiers changed from: protected */
    public int addAlpha2Color(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420014207")) {
            return ((Integer) ipChange.ipc$dispatch("-420014207", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            String hexString = Integer.toHexString(i);
            if (hexString == null || hexString.length() < 6) {
                return i;
            }
            String substring = hexString.substring(hexString.length() - 6, hexString.length());
            return Color.parseColor("#33" + substring);
        } catch (Exception unused) {
            return i;
        }
    }

    protected abstract String addAlpha2Color(String str);

    public Picture buildPicture() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "320132408") ? (Picture) ipChange.ipc$dispatch("320132408", new Object[]{this}) : buildPicture(false);
    }

    public abstract Picture buildPicture(@NonNull g52 g52Var);

    public abstract Picture buildPicture(boolean z);

    public abstract Picture buildPictureWithColorIntercepter(List<f52> list);

    public abstract Picture buildPriceFilterPicture2(SeatPrice seatPrice, RegionData regionData);

    public abstract Picture buildRegionPicture(String str, RectF rectF, Path path);

    public abstract Picture buildStrokePicture(List<SeatPrice> list, RegionData regionData);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getPricePointColor(cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice r7, java.lang.String r8, cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData r9) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a.$ipChange
            java.lang.String r1 = "310858358"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L20
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r6
            r3 = 1
            r2[r3] = r7
            r7 = 2
            r2[r7] = r8
            r7 = 3
            r2[r7] = r9
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L20:
            tb.i12 r0 = r6.mRegionManager
            tb.bb r0 = r0.c(r9)
            cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region r8 = r0.a(r9, r8)
            r9 = 0
            if (r8 == 0) goto L92
            java.util.ArrayList<java.lang.Long> r0 = r8.priceLevelIdList
            if (r0 == 0) goto L92
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L38
            goto L92
        L38:
            java.util.ArrayList<java.lang.Long> r0 = r8.priceLevelIdList
            long r1 = r7.maitixPriceId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L92
            java.util.HashMap<java.lang.String, java.util.ArrayList<cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionColorListResult$RegionColorList$RegionColor>> r0 = r6.mRegionVid2ColorMap
            if (r0 == 0) goto L92
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = r8.id
            r1.append(r2)
            java.lang.String r8 = ""
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            java.lang.Object r8 = r0.get(r8)
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            boolean r0 = tb.cb2.d(r8)
            if (r0 != 0) goto L92
            java.util.Iterator r8 = r8.iterator()
        L6d:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r8.next()
            cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionColorListResult$RegionColorList$RegionColor r0 = (cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionColorListResult.RegionColorList.RegionColor) r0
            r1 = 0
            java.lang.String r3 = r0.priceId     // Catch: java.lang.Exception -> L82
            long r1 = java.lang.Long.parseLong(r3)     // Catch: java.lang.Exception -> L82
            goto L83
        L82:
        L83:
            long r3 = r7.priceLevelId
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L8f
            long r3 = r7.maitixPriceId
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L6d
        L8f:
            java.lang.String r7 = r0.color
            return r7
        L92:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a.getPricePointColor(cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice, java.lang.String, cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData):java.lang.String");
    }

    public List<RegionBound> getRegionBounds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1663202527") ? (List) ipChange.ipc$dispatch("1663202527", new Object[]{this}) : this.mRegionBounds;
    }

    public abstract int getRegionCount();

    public List<List<PointLocation>> getRegionLocationList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1339227491") ? (List) ipChange.ipc$dispatch("-1339227491", new Object[]{this}) : this.regionLocationList;
    }

    public abstract int getShapeCount();

    public float getSvgScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-647861573") ? ((Float) ipChange.ipc$dispatch("-647861573", new Object[]{this})).floatValue() : this.svgScale;
    }

    public boolean hasFloorData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-505129909") ? ((Boolean) ipChange.ipc$dispatch("-505129909", new Object[]{this})).booleanValue() : this.isHasFloorId;
    }

    public boolean hasSelectedColor(List<SeatPrice> list, String str, RegionData regionData) {
        ArrayList<Long> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615942843")) {
            return ((Boolean) ipChange.ipc$dispatch("-1615942843", new Object[]{this, list, str, regionData})).booleanValue();
        }
        Region a = this.mRegionManager.c(regionData).a(regionData, str);
        if (a != null && (arrayList = a.priceLevelIdList) != null && !arrayList.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (a.priceLevelIdList.contains(Long.valueOf(list.get(i).maitixPriceId))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655848400")) {
            return ((Integer) ipChange.ipc$dispatch("-1655848400", new Object[]{this, str})).intValue();
        }
        if (TextUtils.isEmpty(str) || !str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return 0;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setDynamicRegionColor(RegionColorListResult regionColorListResult) {
        HashMap<String, ArrayList<RegionColorListResult.RegionColorList.RegionColor>> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010714978")) {
            ipChange.ipc$dispatch("2010714978", new Object[]{this, regionColorListResult});
            return;
        }
        this.mRegionVid2ColorMap = null;
        if (regionColorListResult == null || regionColorListResult.getData() == null || (hashMap = regionColorListResult.getData().standColor) == null || hashMap.size() == 0) {
            return;
        }
        this.mRegionVid2ColorMap = hashMap;
    }

    public void setRainbowColorData(HashMap<String, HashMap<String, String>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854424485")) {
            ipChange.ipc$dispatch("1854424485", new Object[]{this, hashMap});
        } else {
            this.rainbowColorMap = hashMap;
        }
    }

    public void setRegionColorData(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1676074425")) {
            ipChange.ipc$dispatch("-1676074425", new Object[]{this, hashMap});
        } else {
            this.regionColorMap = hashMap;
        }
    }

    public void setSvgScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993059999")) {
            ipChange.ipc$dispatch("-1993059999", new Object[]{this, Float.valueOf(f)});
        } else {
            this.svgScale = f;
        }
    }
}
