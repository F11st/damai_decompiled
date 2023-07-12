package tb;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import cn.damai.commonbusiness.seatbiz.view.model.DMSVG;
import cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.C4748d;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ks extends AbstractC0856a {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMSVG a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.ks$a */
    /* loaded from: classes.dex */
    public static class C9373a {
        public String a;
        public float b;

        C9373a() {
        }
    }

    public ks(DMSVG dmsvg) {
        this.a = dmsvg;
        c();
        DMSVG dmsvg2 = this.a;
        if (dmsvg2 != null) {
            this.mRegionBounds = dmsvg2.getRegionBounds();
            this.regionLocationList = this.a.getRegionLocationMap();
        }
    }

    private String a() {
        HashMap<String, String> value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743305229")) {
            return (String) ipChange.ipc$dispatch("1743305229", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, HashMap<String, String>> entry : this.rainbowColorMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                for (Map.Entry<String, String> entry2 : value.entrySet()) {
                    String key2 = entry2.getKey();
                    if (!TextUtils.isEmpty(key2)) {
                        String value2 = entry2.getValue();
                        if (!TextUtils.isEmpty(value2)) {
                            String d = ju1.d(key, key2);
                            stringBuffer.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            stringBuffer.append(d);
                            stringBuffer.append("{fill:");
                            stringBuffer.append(value2);
                            stringBuffer.append("!important}");
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    private String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208703237")) {
            return (String) ipChange.ipc$dispatch("1208703237", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.regionColorMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    String c = ju1.c(key);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(c);
                    sb.append("{fill:");
                    sb.append(value);
                    sb.append("!important}");
                }
            }
        }
        return sb.toString();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225748211")) {
            ipChange.ipc$dispatch("-1225748211", new Object[]{this});
            return;
        }
        DMSVG dmsvg = this.a;
        if (dmsvg != null && dmsvg.getSVGIds() != null) {
            for (String str : this.a.getSVGIds()) {
                if (ju1.e(str)) {
                    this.isHasFloorId = true;
                    return;
                }
            }
        }
        this.isHasFloorId = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(java.lang.String r7, java.lang.String r8, java.lang.String[] r9, cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice r10, cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData r11) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ks.$ipChange
            java.lang.String r1 = "886774931"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L23
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r6
            r2[r5] = r7
            r2[r3] = r8
            r7 = 3
            r2[r7] = r9
            r7 = 4
            r2[r7] = r10
            r7 = 5
            r2[r7] = r11
            r0.ipc$dispatch(r1, r2)
            return
        L23:
            if (r9 == 0) goto L85
            int r0 = r9.length
            if (r0 == r3) goto L29
            goto L85
        L29:
            java.lang.String r0 = ""
            r9[r4] = r0
            r9[r5] = r0
            if (r7 != 0) goto L32
            return
        L32:
            java.lang.String r10 = r6.getPricePointColor(r10, r7, r11)
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            r11 = r11 ^ r5
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r6.regionColorMap
            if (r1 == 0) goto L54
            if (r11 == 0) goto L43
        L41:
            r0 = r10
            goto L76
        L43:
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L76
            java.lang.String r0 = r6.addAlpha2Color(r7)
            goto L76
        L54:
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> r1 = r6.rainbowColorMap
            if (r1 == 0) goto L76
            if (r8 == 0) goto L76
            java.lang.Object r7 = r1.get(r7)
            java.util.HashMap r7 = (java.util.HashMap) r7
            if (r7 == 0) goto L76
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L76
            if (r11 == 0) goto L71
            goto L41
        L71:
            java.lang.String r7 = r6.addAlpha2Color(r7)
            r0 = r7
        L76:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L7d
            return
        L7d:
            r9[r4] = r0
            if (r11 != 0) goto L85
            java.lang.String r7 = ";fill-opacity:0.2"
            r9[r5] = r7
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ks.d(java.lang.String, java.lang.String, java.lang.String[], cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice, cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData):void");
    }

    private void e(int i, C9373a c9373a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271986493")) {
            ipChange.ipc$dispatch("271986493", new Object[]{this, Integer.valueOf(i), c9373a});
            return;
        }
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        String hexString = Integer.toHexString(red);
        String hexString2 = Integer.toHexString(green);
        String hexString3 = Integer.toHexString(blue);
        if (alpha < 255) {
            c9373a.b = alpha / 255.0f;
        } else {
            c9373a.b = 1.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        if (hexString.length() < 2) {
            hexString = "0" + hexString;
        }
        sb.append(hexString);
        if (hexString2.length() < 2) {
            hexString2 = "0" + hexString2;
        }
        sb.append(hexString2);
        if (hexString3.length() < 2) {
            hexString3 = "0" + hexString3;
        }
        sb.append(hexString3);
        c9373a.a = sb.toString();
    }

    private String f(String str) {
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509128908")) {
            return (String) ipChange.ipc$dispatch("-1509128908", new Object[]{this, str});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : sVGIds) {
            if (ju1.f(str2)) {
                stringBuffer.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                stringBuffer.append(str2);
                stringBuffer.append("{fill:");
                stringBuffer.append(str);
                stringBuffer.append(";stroke:");
                stringBuffer.append(str);
                stringBuffer.append("!important}");
            }
        }
        return stringBuffer.toString();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    protected String addAlpha2Color(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654419959")) {
            return (String) ipChange.ipc$dispatch("-654419959", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + ";fill-opacity:0.2";
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPicture(boolean z) {
        String a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121114750")) {
            return (Picture) ipChange.ipc$dispatch("-1121114750", new Object[]{this, Boolean.valueOf(z)});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null) {
            return null;
        }
        dmsvg.resetCss();
        C4748d c4748d = new C4748d();
        if (this.regionColorMap != null) {
            a = b();
        } else {
            a = this.rainbowColorMap != null ? a() : "";
        }
        if (z) {
            a = a + f("#E0E0E0");
        }
        if (!TextUtils.isEmpty(a)) {
            c4748d.a(a);
        }
        return this.a.renderToPicture(c4748d);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPictureWithColorIntercepter(List<f52> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469856801")) {
            return (Picture) ipChange.ipc$dispatch("1469856801", new Object[]{this, list});
        }
        this.a.resetCss();
        return this.a.renderToPicture(new C4748d());
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPriceFilterPicture2(SeatPrice seatPrice, RegionData regionData) {
        DMSVG dmsvg;
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702422050")) {
            return (Picture) ipChange.ipc$dispatch("702422050", new Object[]{this, seatPrice, regionData});
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (seatPrice == null || regionData == null || (dmsvg = this.a) == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        C4748d c4748d = new C4748d();
        String[] strArr = new String[2];
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = ju1.g(str);
            if (g != null) {
                d(g[0], g[1], strArr, seatPrice, regionData);
                if (!TextUtils.isEmpty(strArr[0])) {
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append("{fill:");
                    sb.append(strArr[0]);
                    sb.append(strArr[1]);
                    sb.append("!important}");
                }
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            c4748d.a(sb2);
        }
        Log.d("SVG parse", "-------------------- buildPriceFilterPicture2 prepare cost = " + (System.currentTimeMillis() - currentTimeMillis));
        Picture renderToPicture = this.a.renderToPicture(c4748d);
        Log.d("SVG parse", "-------------------- buildPriceFilterPicture2 cost = " + (System.currentTimeMillis() - currentTimeMillis));
        return renderToPicture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildRegionPicture(String str, RectF rectF, Path path) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022756109")) {
            return (Picture) ipChange.ipc$dispatch("2022756109", new Object[]{this, str, rectF, path});
        }
        this.a.resetCss();
        return this.a.renderToPicture(new C4748d());
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildStrokePicture(List<SeatPrice> list, RegionData regionData) {
        DMSVG dmsvg;
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243447898")) {
            return (Picture) ipChange.ipc$dispatch("-1243447898", new Object[]{this, list, regionData});
        }
        if (list == null || list.isEmpty() || regionData == null || (dmsvg = this.a) == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        C4748d c4748d = new C4748d();
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = ju1.g(str);
            if (g != null) {
                String str2 = g[0];
                if (!TextUtils.isEmpty(str2) && hasSelectedColor(list, str2, regionData)) {
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append("{fill:#00000000;");
                    sb.append("stroke:#FF0000;");
                    sb.append("stroke-width:2.5}");
                    sb.append("!important}");
                }
            }
        }
        c4748d.a(sb.toString());
        return this.a.renderToPicture(c4748d);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public int getRegionCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626430967")) {
            return ((Integer) ipChange.ipc$dispatch("-1626430967", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public int getShapeCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910726718")) {
            return ((Integer) ipChange.ipc$dispatch("1910726718", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPicture(@NonNull g52 g52Var) {
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746075994")) {
            return (Picture) ipChange.ipc$dispatch("746075994", new Object[]{this, g52Var});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        C4748d c4748d = new C4748d();
        Shape shape = new Shape();
        C9373a c9373a = new C9373a();
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = ju1.g(str);
            if (g != null) {
                String str2 = g[0];
                if (!TextUtils.isEmpty(str2)) {
                    shape.floorId = str2;
                    shape.rowId = g[1];
                    shape.fillColor = 0;
                    shape.strokeColor = 0;
                    g52Var.b(shape);
                    int[] iArr = g52Var.a;
                    if (iArr[0] != 0) {
                        e(iArr[0], c9373a);
                        if (c9373a.b != 1.0f) {
                            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(str);
                            sb.append("{fill:");
                            sb.append(c9373a.a);
                            sb.append(";fill-opacity:");
                            sb.append(c9373a.b);
                            sb.append(";stroke-opacity:");
                            sb.append(c9373a.b);
                            sb.append("!important}");
                        } else {
                            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(str);
                            sb.append("{fill:");
                            sb.append(c9373a.a);
                            sb.append(";fill-opacity:");
                            sb.append(c9373a.b);
                            sb.append("!important}");
                        }
                    }
                }
            }
        }
        c4748d.a(sb.toString());
        return this.a.renderToPicture(c4748d);
    }
}
