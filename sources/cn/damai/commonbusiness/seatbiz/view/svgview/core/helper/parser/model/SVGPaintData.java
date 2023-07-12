package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tb.cb1;
import tb.cb2;
import tb.f52;
import tb.g52;
import tb.i12;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGPaintData extends AbstractC0856a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_G = 102;
    public static final int TYPE_LINE = 103;
    public static final int TYPE_OVAL = 104;
    public static final int TYPE_PATH = 106;
    public static final int TYPE_POLYGON = 105;
    public static final int TYPE_RECT = 101;
    public static final int TYPE_TEXT = 107;
    private Integer canvasRestoreCount;
    private Paint fillPaint;
    private int gIndex;
    private int height;
    private boolean isHasFloorId;
    private boolean isViewBoxBounds;
    private Paint layerPaint;
    private int lineIndex;
    private i12 mRegionManager;
    private Shape mShape;
    private int ovalIndex;
    private int pathIndex;
    private int polygonIndex;
    private Paint priceColorStrokePaint;
    private int rectIndex;
    private float startX;
    private float startY;
    private Paint strokePaint;
    private int textIndex;
    private List<String> unrecognizedCommandList;
    private int width;
    private LinkedList<Matrix> matrixStack = new LinkedList<>();
    private List<Integer> shapeList = new ArrayList(1024);
    private List<SVGRect> rectList = new ArrayList();
    private List<G> gList = new ArrayList();
    private List<SVGLine> lineList = new ArrayList();
    private List<SVGOval> ovalList = new ArrayList();
    private List<SVGPolygon> polygonList = new ArrayList();
    private List<SVGPath> pathList = new ArrayList(1024);
    private List<SVGText> textList = new ArrayList();

    public SVGPaintData() {
        this.regionLocationList = new ArrayList(256);
        Paint paint = new Paint(1);
        this.strokePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeWidth(1.3f);
        this.strokePaint.setColor(Color.parseColor("#CACACA"));
        Paint paint2 = new Paint(1);
        this.priceColorStrokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.priceColorStrokePaint.setStrokeWidth(2.5f);
        this.priceColorStrokePaint.setColor(SupportMenu.CATEGORY_MASK);
        Paint paint3 = new Paint();
        this.fillPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.fillPaint.setColor(-1);
        Paint paint4 = new Paint(1);
        this.layerPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.layerPaint.setColor(Color.parseColor("#616161"));
        this.mRegionManager = new i12();
    }

    private void computeFillAndStrokeColor(Shape shape, int[] iArr, SeatPrice seatPrice, RegionData regionData) {
        HashMap<String, String> hashMap;
        String str;
        int parseColor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877089100")) {
            ipChange.ipc$dispatch("-877089100", new Object[]{this, shape, iArr, seatPrice, regionData});
        } else if (shape == null || iArr == null || iArr.length != 2) {
        } else {
            iArr[0] = shape.fillColor;
            iArr[1] = shape.strokeColor;
            String str2 = shape.floorId;
            if (str2 != null) {
                String pricePointColor = getPricePointColor(seatPrice, str2, regionData);
                boolean z = !TextUtils.isEmpty(pricePointColor);
                HashMap<String, String> hashMap2 = this.regionColorMap;
                if (hashMap2 == null) {
                    HashMap<String, HashMap<String, String>> hashMap3 = this.rainbowColorMap;
                    if (hashMap3 != null && shape.rowId != null && (hashMap = hashMap3.get(str2)) != null) {
                        String str3 = hashMap.get(shape.rowId);
                        if (!TextUtils.isEmpty(str3)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("------------------------ floorId = ");
                            sb.append(str2);
                            sb.append(" , rowId = ");
                            sb.append(shape.rowId);
                            sb.append(" fill = ");
                            if (z) {
                                str = pricePointColor;
                            } else {
                                str = "#33" + str3;
                            }
                            sb.append(str);
                            cb1.b("SVG parser", sb.toString());
                            int parseColor2 = parseColor(pricePointColor);
                            int parseColor3 = parseColor(str3);
                            if (!z) {
                                parseColor2 = addAlpha2Color(parseColor3);
                            }
                            iArr[0] = parseColor2;
                        }
                    }
                } else if (z) {
                    iArr[0] = parseColor(pricePointColor);
                } else {
                    String str4 = hashMap2.get(str2);
                    if (!TextUtils.isEmpty(str4) && (parseColor = parseColor(str4)) != -1) {
                        iArr[0] = addAlpha2Color(parseColor);
                    }
                }
                if (z) {
                    return;
                }
                iArr[1] = addAlpha2Color(shape.strokeColor);
            }
        }
    }

    private void interceptColor(Paint paint, int i, List<f52> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658352520")) {
            ipChange.ipc$dispatch("1658352520", new Object[]{this, paint, Integer.valueOf(i), list});
        } else if (list != null) {
            for (f52 f52Var : list) {
                if (f52Var.a(i)) {
                    paint.setColor(f52Var.b());
                    return;
                }
            }
        }
    }

    private int regionCount(List<? extends Shape> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1624729627")) {
            return ((Integer) ipChange.ipc$dispatch("1624729627", new Object[]{this, list})).intValue();
        }
        if (!cb2.d(list)) {
            for (Shape shape : list) {
                if (!TextUtils.isEmpty(shape.floorId)) {
                    i++;
                }
            }
        }
        return i;
    }

    private void resetPaintData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900446463")) {
            ipChange.ipc$dispatch("900446463", new Object[]{this});
            return;
        }
        this.matrixStack.clear();
        this.rectIndex = 0;
        this.gIndex = 0;
        this.lineIndex = 0;
        this.ovalIndex = 0;
        this.polygonIndex = 0;
        this.pathIndex = 0;
        this.textIndex = 0;
    }

    private void resetRegionLocationData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21975792")) {
            ipChange.ipc$dispatch("-21975792", new Object[]{this});
            return;
        }
        this.regionLocationList.clear();
        this.mRegionBounds.clear();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    protected String addAlpha2Color(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599728172")) {
            return (String) ipChange.ipc$dispatch("599728172", new Object[]{this, str});
        }
        if (str != null) {
            try {
                if (str.length() >= 6) {
                    String substring = str.substring(str.length() - 6, str.length());
                    return "#33" + substring;
                }
                return str;
            } catch (Exception unused) {
                return str;
            }
        }
        return str;
    }

    public void addG(G g) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943876281")) {
            ipChange.ipc$dispatch("-1943876281", new Object[]{this, g});
            return;
        }
        if (g.floorId != null) {
            this.isHasFloorId = true;
        }
        this.gList.add(g);
    }

    public void addLine(SVGLine sVGLine) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "976612971")) {
            ipChange.ipc$dispatch("976612971", new Object[]{this, sVGLine});
        } else {
            this.lineList.add(sVGLine);
        }
    }

    public void addOval(SVGOval sVGOval) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45358635")) {
            ipChange.ipc$dispatch("45358635", new Object[]{this, sVGOval});
            return;
        }
        if (sVGOval.floorId != null) {
            this.isHasFloorId = true;
        }
        this.ovalList.add(sVGOval);
    }

    public void addPath(SVGPath sVGPath) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32546165")) {
            ipChange.ipc$dispatch("-32546165", new Object[]{this, sVGPath});
            return;
        }
        if (sVGPath.floorId != null) {
            this.isHasFloorId = true;
        }
        this.pathList.add(sVGPath);
    }

    public void addPolygon(SVGPolygon sVGPolygon) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251982681")) {
            ipChange.ipc$dispatch("1251982681", new Object[]{this, sVGPolygon});
            return;
        }
        if (sVGPolygon.floorId != null) {
            this.isHasFloorId = true;
        }
        this.polygonList.add(sVGPolygon);
    }

    public void addRect(SVGRect sVGRect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359510933")) {
            ipChange.ipc$dispatch("-359510933", new Object[]{this, sVGRect});
            return;
        }
        if (sVGRect.floorId != null) {
            this.isHasFloorId = true;
        }
        this.rectList.add(sVGRect);
    }

    public void addShape(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111549685")) {
            ipChange.ipc$dispatch("-111549685", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.shapeList.add(Integer.valueOf(i));
        }
    }

    public void addText(SVGText sVGText) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927206517")) {
            ipChange.ipc$dispatch("-927206517", new Object[]{this, sVGText});
        } else {
            this.textList.add(sVGText);
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPicture(boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541584065")) {
            return (Picture) ipChange.ipc$dispatch("-541584065", new Object[]{this, Boolean.valueOf(z)});
        }
        Picture picture = new Picture();
        if (this.shapeList.isEmpty()) {
            return picture;
        }
        resetPaintData();
        resetRegionLocationData();
        Canvas beginRecording = picture.beginRecording(this.width, this.height);
        if (this.isViewBoxBounds) {
            if (this.startX != 0.0f || this.startY != 0.0f) {
                this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                beginRecording.translate(-this.startX, -this.startY);
            }
        } else {
            this.canvasRestoreCount = null;
        }
        for (Integer num : this.shapeList) {
            switch (num.intValue()) {
                case 101:
                    SVGRect sVGRect = this.rectList.get(this.rectIndex);
                    List<PointLocation> list = sVGRect.locationList;
                    if (list != null) {
                        this.mRegionBounds.add(new RegionBound(sVGRect.floorId, list));
                        this.regionLocationList.add(sVGRect.locationList);
                    }
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGRect.transformMatrix);
                    }
                    Paint paint = sVGRect.fillPaint;
                    if (paint != null) {
                        HashMap<String, String> hashMap = this.regionColorMap;
                        if (hashMap != null && (str = sVGRect.floorId) != null) {
                            String str5 = hashMap.get(str);
                            if (!TextUtils.isEmpty(str5)) {
                                sVGRect.fillPaint.setColor(Color.parseColor(str5));
                            } else {
                                sVGRect.fillPaint.setColor(sVGRect.fillColor);
                            }
                        } else {
                            HashMap<String, HashMap<String, String>> hashMap2 = this.rainbowColorMap;
                            if (hashMap2 != null && sVGRect.rowId != null) {
                                HashMap<String, String> hashMap3 = hashMap2.get(sVGRect.floorId);
                                if (hashMap3 != null) {
                                    String str6 = hashMap3.get(sVGRect.rowId);
                                    if (!TextUtils.isEmpty(str6)) {
                                        sVGRect.fillPaint.setColor(Color.parseColor(str6));
                                    } else {
                                        sVGRect.fillPaint.setColor(sVGRect.fillColor);
                                    }
                                } else {
                                    sVGRect.fillPaint.setColor(sVGRect.fillColor);
                                }
                            } else {
                                paint.setColor(sVGRect.fillColor);
                            }
                        }
                        float f = sVGRect.rx;
                        if (f <= 0.0f && sVGRect.ry <= 0.0f) {
                            beginRecording.drawRect(sVGRect.rect, sVGRect.fillPaint);
                        } else {
                            beginRecording.drawRoundRect(sVGRect.rect, f, sVGRect.ry, sVGRect.fillPaint);
                        }
                    }
                    Paint paint2 = sVGRect.strokePaint;
                    if (paint2 != null) {
                        paint2.setColor(sVGRect.strokeColor);
                        float f2 = sVGRect.rx;
                        if (f2 <= 0.0f && sVGRect.ry <= 0.0f) {
                            beginRecording.drawRect(sVGRect.rect, sVGRect.strokePaint);
                        } else {
                            beginRecording.drawRoundRect(sVGRect.rect, f2, sVGRect.ry, sVGRect.strokePaint);
                        }
                    }
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.rectIndex++;
                    break;
                case 102:
                    G g = this.gList.get(this.gIndex);
                    if (g.isParseEnd) {
                        if (!this.matrixStack.isEmpty()) {
                            this.matrixStack.removeLast();
                            beginRecording.restore();
                        }
                    } else {
                        List<PointLocation> list2 = g.locationList;
                        if (list2 != null) {
                            this.regionLocationList.add(list2);
                        }
                        if (g.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(g.transformMatrix);
                            this.matrixStack.add(g.transformMatrix);
                        }
                    }
                    this.gIndex++;
                    break;
                case 103:
                    SVGLine sVGLine = this.lineList.get(this.lineIndex);
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGLine.transformMatrix);
                    }
                    Paint paint3 = sVGLine.strokePaint;
                    if (paint3 != null) {
                        paint3.setColor(sVGLine.strokeColor);
                        beginRecording.drawLine(sVGLine.startX, sVGLine.startY, sVGLine.endX, sVGLine.endY, sVGLine.strokePaint);
                    }
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.lineIndex++;
                    break;
                case 104:
                    SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                    List<PointLocation> list3 = sVGOval.locationList;
                    if (list3 != null) {
                        this.mRegionBounds.add(new RegionBound(sVGOval.floorId, list3));
                        this.regionLocationList.add(sVGOval.locationList);
                    }
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGOval.transformMatrix);
                    }
                    Paint paint4 = sVGOval.fillPaint;
                    if (paint4 != null) {
                        HashMap<String, String> hashMap4 = this.regionColorMap;
                        if (hashMap4 != null && (str2 = sVGOval.floorId) != null) {
                            String str7 = hashMap4.get(str2);
                            if (!TextUtils.isEmpty(str7)) {
                                sVGOval.fillPaint.setColor(Color.parseColor(str7));
                            } else {
                                sVGOval.fillPaint.setColor(sVGOval.fillColor);
                            }
                        } else {
                            HashMap<String, HashMap<String, String>> hashMap5 = this.rainbowColorMap;
                            if (hashMap5 != null && sVGOval.rowId != null) {
                                HashMap<String, String> hashMap6 = hashMap5.get(sVGOval.floorId);
                                if (hashMap6 != null) {
                                    String str8 = hashMap6.get(sVGOval.rowId);
                                    if (!TextUtils.isEmpty(str8)) {
                                        sVGOval.fillPaint.setColor(Color.parseColor(str8));
                                    } else {
                                        sVGOval.fillPaint.setColor(sVGOval.fillColor);
                                    }
                                } else {
                                    sVGOval.fillPaint.setColor(sVGOval.fillColor);
                                }
                            } else {
                                paint4.setColor(sVGOval.fillColor);
                            }
                        }
                        beginRecording.drawOval(sVGOval.rect, sVGOval.fillPaint);
                    }
                    Paint paint5 = sVGOval.strokePaint;
                    if (paint5 != null) {
                        paint5.setColor(sVGOval.strokeColor);
                        beginRecording.drawOval(sVGOval.rect, sVGOval.strokePaint);
                    }
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.ovalIndex++;
                    break;
                case 105:
                    SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                    List<PointLocation> list4 = sVGPolygon.locationList;
                    if (list4 != null) {
                        this.mRegionBounds.add(new RegionBound(sVGPolygon.floorId, list4));
                        this.regionLocationList.add(sVGPolygon.locationList);
                    }
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPolygon.transformMatrix);
                    }
                    Paint paint6 = sVGPolygon.fillPaint;
                    if (paint6 != null) {
                        HashMap<String, String> hashMap7 = this.regionColorMap;
                        if (hashMap7 != null && (str3 = sVGPolygon.floorId) != null) {
                            String str9 = hashMap7.get(str3);
                            if (!TextUtils.isEmpty(str9)) {
                                sVGPolygon.fillPaint.setColor(Color.parseColor(str9));
                            } else {
                                sVGPolygon.fillPaint.setColor(sVGPolygon.fillColor);
                            }
                        } else {
                            HashMap<String, HashMap<String, String>> hashMap8 = this.rainbowColorMap;
                            if (hashMap8 != null && sVGPolygon.rowId != null) {
                                HashMap<String, String> hashMap9 = hashMap8.get(sVGPolygon.floorId);
                                if (hashMap9 != null) {
                                    String str10 = hashMap9.get(sVGPolygon.rowId);
                                    if (!TextUtils.isEmpty(str10)) {
                                        sVGPolygon.fillPaint.setColor(Color.parseColor(str10));
                                    } else {
                                        sVGPolygon.fillPaint.setColor(sVGPolygon.fillColor);
                                    }
                                } else {
                                    sVGPolygon.fillPaint.setColor(sVGPolygon.fillColor);
                                }
                            } else {
                                paint6.setColor(sVGPolygon.fillColor);
                            }
                        }
                        beginRecording.drawPath(sVGPolygon.path, sVGPolygon.fillPaint);
                    }
                    Paint paint7 = sVGPolygon.strokePaint;
                    if (paint7 != null) {
                        paint7.setColor(sVGPolygon.strokeColor);
                        beginRecording.drawPath(sVGPolygon.path, sVGPolygon.strokePaint);
                    }
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.polygonIndex++;
                    break;
                case 106:
                    SVGPath sVGPath = this.pathList.get(this.pathIndex);
                    List<PointLocation> list5 = sVGPath.locationList;
                    if (list5 != null) {
                        this.mRegionBounds.add(new RegionBound(sVGPath.floorId, sVGPath.transformBound, list5));
                        this.regionLocationList.add(sVGPath.locationList);
                    }
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPath.transformMatrix);
                    }
                    Paint paint8 = sVGPath.fillPaint;
                    if (paint8 != null) {
                        HashMap<String, String> hashMap10 = this.regionColorMap;
                        if (hashMap10 != null && (str4 = sVGPath.floorId) != null) {
                            String str11 = hashMap10.get(str4);
                            if (!TextUtils.isEmpty(str11)) {
                                sVGPath.fillPaint.setColor(Color.parseColor(str11));
                            } else {
                                sVGPath.fillPaint.setColor(sVGPath.fillColor);
                            }
                        } else {
                            HashMap<String, HashMap<String, String>> hashMap11 = this.rainbowColorMap;
                            if (hashMap11 != null && sVGPath.rowId != null) {
                                HashMap<String, String> hashMap12 = hashMap11.get(sVGPath.floorId);
                                if (hashMap12 != null) {
                                    String str12 = hashMap12.get(sVGPath.rowId);
                                    if (!TextUtils.isEmpty(str12)) {
                                        sVGPath.fillPaint.setColor(Color.parseColor(str12));
                                    } else {
                                        sVGPath.fillPaint.setColor(sVGPath.fillColor);
                                    }
                                } else {
                                    sVGPath.fillPaint.setColor(sVGPath.fillColor);
                                }
                            } else {
                                paint8.setColor(sVGPath.fillColor);
                            }
                        }
                        beginRecording.drawPath(sVGPath.path, sVGPath.fillPaint);
                    }
                    Paint paint9 = sVGPath.strokePaint;
                    if (paint9 != null) {
                        paint9.setColor(sVGPath.strokeColor);
                        beginRecording.drawPath(sVGPath.path, sVGPath.strokePaint);
                    }
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.pathIndex++;
                    break;
                case 107:
                    SVGText sVGText = this.textList.get(this.textIndex);
                    if (sVGText.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGText.transformMatrix);
                    }
                    if (!TextUtils.isEmpty(sVGText.content)) {
                        int parseColor = Color.parseColor("#E0E0E0");
                        int i = z ? parseColor : sVGText.fillColor;
                        if (!z) {
                            parseColor = sVGText.strokeColor;
                        }
                        Paint paint10 = sVGText.fillPaint;
                        if (paint10 != null) {
                            paint10.setColor(i);
                            if (sVGText.strokePaint != null) {
                                sVGText.fillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                            }
                            sVGText.fillPaint.setTextSize(sVGText.textSize);
                            beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.fillPaint);
                        } else {
                            Paint paint11 = sVGText.strokePaint;
                            if (paint11 != null) {
                                paint11.setColor(parseColor);
                                sVGText.strokePaint.setTextSize(sVGText.textSize);
                                beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.strokePaint);
                            }
                        }
                    }
                    if (sVGText.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.textIndex++;
                    break;
            }
        }
        Integer num2 = this.canvasRestoreCount;
        if (num2 != null) {
            beginRecording.restoreToCount(num2.intValue());
        }
        picture.endRecording();
        return picture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPictureWithColorIntercepter(List<f52> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824150852")) {
            return (Picture) ipChange.ipc$dispatch("824150852", new Object[]{this, list});
        }
        Picture picture = new Picture();
        if (!this.shapeList.isEmpty() && list != null && !list.isEmpty()) {
            resetPaintData();
            resetRegionLocationData();
            Canvas beginRecording = picture.beginRecording(this.width, this.height);
            if (this.isViewBoxBounds) {
                if (this.startX != 0.0f || this.startY != 0.0f) {
                    this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                    beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                    beginRecording.translate(-this.startX, -this.startY);
                }
            } else {
                this.canvasRestoreCount = null;
            }
            for (Integer num : this.shapeList) {
                switch (num.intValue()) {
                    case 101:
                        SVGRect sVGRect = this.rectList.get(this.rectIndex);
                        List<PointLocation> list2 = sVGRect.locationList;
                        if (list2 != null) {
                            this.mRegionBounds.add(new RegionBound(sVGRect.floorId, list2));
                            this.regionLocationList.add(sVGRect.locationList);
                        }
                        if (sVGRect.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGRect.transformMatrix);
                        }
                        Paint paint = sVGRect.fillPaint;
                        if (paint != null) {
                            interceptColor(paint, sVGRect.fillColor, list);
                            float f = sVGRect.rx;
                            if (f <= 0.0f && sVGRect.ry <= 0.0f) {
                                beginRecording.drawRect(sVGRect.rect, sVGRect.fillPaint);
                            } else {
                                beginRecording.drawRoundRect(sVGRect.rect, f, sVGRect.ry, sVGRect.fillPaint);
                            }
                        }
                        Paint paint2 = sVGRect.strokePaint;
                        if (paint2 != null) {
                            interceptColor(paint2, sVGRect.strokeColor, list);
                            float f2 = sVGRect.rx;
                            if (f2 <= 0.0f && sVGRect.ry <= 0.0f) {
                                beginRecording.drawRect(sVGRect.rect, sVGRect.strokePaint);
                            } else {
                                beginRecording.drawRoundRect(sVGRect.rect, f2, sVGRect.ry, sVGRect.strokePaint);
                            }
                        }
                        if (sVGRect.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.rectIndex++;
                        break;
                    case 102:
                        G g = this.gList.get(this.gIndex);
                        if (g.isParseEnd) {
                            if (!this.matrixStack.isEmpty()) {
                                this.matrixStack.removeLast();
                                beginRecording.restore();
                            }
                        } else {
                            List<PointLocation> list3 = g.locationList;
                            if (list3 != null) {
                                this.regionLocationList.add(list3);
                            }
                            if (g.transformMatrix != null) {
                                beginRecording.save();
                                beginRecording.concat(g.transformMatrix);
                                this.matrixStack.add(g.transformMatrix);
                            }
                        }
                        this.gIndex++;
                        break;
                    case 103:
                        SVGLine sVGLine = this.lineList.get(this.lineIndex);
                        if (sVGLine.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGLine.transformMatrix);
                        }
                        Paint paint3 = sVGLine.strokePaint;
                        if (paint3 != null) {
                            interceptColor(paint3, sVGLine.strokeColor, list);
                            beginRecording.drawLine(sVGLine.startX, sVGLine.startY, sVGLine.endX, sVGLine.endY, sVGLine.strokePaint);
                        }
                        if (sVGLine.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.lineIndex++;
                        break;
                    case 104:
                        SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                        List<PointLocation> list4 = sVGOval.locationList;
                        if (list4 != null) {
                            this.mRegionBounds.add(new RegionBound(sVGOval.floorId, list4));
                            this.regionLocationList.add(sVGOval.locationList);
                        }
                        if (sVGOval.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGOval.transformMatrix);
                        }
                        Paint paint4 = sVGOval.fillPaint;
                        if (paint4 != null) {
                            interceptColor(paint4, sVGOval.fillColor, list);
                            beginRecording.drawOval(sVGOval.rect, sVGOval.fillPaint);
                        }
                        Paint paint5 = sVGOval.strokePaint;
                        if (paint5 != null) {
                            interceptColor(paint5, sVGOval.strokeColor, list);
                            beginRecording.drawOval(sVGOval.rect, sVGOval.strokePaint);
                        }
                        if (sVGOval.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.ovalIndex++;
                        break;
                    case 105:
                        SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                        List<PointLocation> list5 = sVGPolygon.locationList;
                        if (list5 != null) {
                            this.mRegionBounds.add(new RegionBound(sVGPolygon.floorId, list5));
                            this.regionLocationList.add(sVGPolygon.locationList);
                        }
                        if (sVGPolygon.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGPolygon.transformMatrix);
                        }
                        Paint paint6 = sVGPolygon.fillPaint;
                        if (paint6 != null) {
                            interceptColor(paint6, sVGPolygon.fillColor, list);
                            beginRecording.drawPath(sVGPolygon.path, sVGPolygon.fillPaint);
                        }
                        Paint paint7 = sVGPolygon.strokePaint;
                        if (paint7 != null) {
                            interceptColor(paint7, sVGPolygon.strokeColor, list);
                            beginRecording.drawPath(sVGPolygon.path, sVGPolygon.strokePaint);
                        }
                        if (sVGPolygon.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.polygonIndex++;
                        break;
                    case 106:
                        SVGPath sVGPath = this.pathList.get(this.pathIndex);
                        List<PointLocation> list6 = sVGPath.locationList;
                        if (list6 != null) {
                            this.mRegionBounds.add(new RegionBound(sVGPath.floorId, sVGPath.transformBound, list6));
                            this.regionLocationList.add(sVGPath.locationList);
                        }
                        if (sVGPath.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGPath.transformMatrix);
                        }
                        Paint paint8 = sVGPath.fillPaint;
                        if (paint8 != null) {
                            interceptColor(paint8, sVGPath.fillColor, list);
                            beginRecording.drawPath(sVGPath.path, sVGPath.fillPaint);
                        }
                        Paint paint9 = sVGPath.strokePaint;
                        if (paint9 != null) {
                            interceptColor(paint9, sVGPath.strokeColor, list);
                            beginRecording.drawPath(sVGPath.path, sVGPath.strokePaint);
                        }
                        if (sVGPath.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.pathIndex++;
                        break;
                    case 107:
                        SVGText sVGText = this.textList.get(this.textIndex);
                        if (sVGText.transformMatrix != null) {
                            beginRecording.save();
                            beginRecording.concat(sVGText.transformMatrix);
                        }
                        if (!TextUtils.isEmpty(sVGText.content)) {
                            Paint paint10 = sVGText.fillPaint;
                            if (paint10 != null) {
                                if (sVGText.strokePaint != null) {
                                    paint10.setStyle(Paint.Style.FILL_AND_STROKE);
                                }
                                sVGText.fillPaint.setTextSize(sVGText.textSize);
                                interceptColor(sVGText.fillPaint, sVGText.fillColor, list);
                                beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.fillPaint);
                            } else {
                                Paint paint11 = sVGText.strokePaint;
                                if (paint11 != null) {
                                    paint11.setTextSize(sVGText.textSize);
                                    interceptColor(sVGText.strokePaint, sVGText.strokeColor, list);
                                    beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.strokePaint);
                                }
                            }
                        }
                        if (sVGText.transformMatrix != null) {
                            beginRecording.restore();
                        }
                        this.textIndex++;
                        break;
                }
            }
            Integer num2 = this.canvasRestoreCount;
            if (num2 != null) {
                beginRecording.restoreToCount(num2.intValue());
            }
            picture.endRecording();
        }
        return picture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPriceFilterPicture2(SeatPrice seatPrice, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843374113")) {
            return (Picture) ipChange.ipc$dispatch("-843374113", new Object[]{this, seatPrice, regionData});
        }
        if (seatPrice == null || regionData == null) {
            return null;
        }
        Picture picture = new Picture();
        if (this.shapeList.isEmpty()) {
            return picture;
        }
        resetPaintData();
        Canvas beginRecording = picture.beginRecording(this.width, this.height);
        if (this.isViewBoxBounds) {
            if (this.startX != 0.0f || this.startY != 0.0f) {
                this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                beginRecording.translate(-this.startX, -this.startY);
            }
        } else {
            this.canvasRestoreCount = null;
        }
        int[] iArr = new int[2];
        for (Integer num : this.shapeList) {
            switch (num.intValue()) {
                case 101:
                    SVGRect sVGRect = this.rectList.get(this.rectIndex);
                    computeFillAndStrokeColor(sVGRect, iArr, seatPrice, regionData);
                    sVGRect.draw(beginRecording, iArr[0], iArr[1]);
                    this.rectIndex++;
                    break;
                case 102:
                    G g = this.gList.get(this.gIndex);
                    if (g.isParseEnd) {
                        if (!this.matrixStack.isEmpty()) {
                            this.matrixStack.removeLast();
                            beginRecording.restore();
                        }
                    } else if (g.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(g.transformMatrix);
                        this.matrixStack.add(g.transformMatrix);
                    }
                    this.gIndex++;
                    break;
                case 103:
                    SVGLine sVGLine = this.lineList.get(this.lineIndex);
                    sVGLine.draw(beginRecording, sVGLine.fillColor, sVGLine.strokeColor);
                    this.lineIndex++;
                    break;
                case 104:
                    SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                    computeFillAndStrokeColor(sVGOval, iArr, seatPrice, regionData);
                    sVGOval.draw(beginRecording, iArr[0], iArr[1]);
                    this.ovalIndex++;
                    break;
                case 105:
                    SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                    computeFillAndStrokeColor(sVGPolygon, iArr, seatPrice, regionData);
                    sVGPolygon.draw(beginRecording, iArr[0], iArr[1]);
                    this.polygonIndex++;
                    break;
                case 106:
                    SVGPath sVGPath = this.pathList.get(this.pathIndex);
                    computeFillAndStrokeColor(sVGPath, iArr, seatPrice, regionData);
                    sVGPath.draw(beginRecording, iArr[0], iArr[1]);
                    this.pathIndex++;
                    break;
                case 107:
                    SVGText sVGText = this.textList.get(this.textIndex);
                    sVGText.draw(beginRecording, sVGText.fillColor, sVGText.strokeColor);
                    this.textIndex++;
                    break;
            }
        }
        Integer num2 = this.canvasRestoreCount;
        if (num2 != null) {
            beginRecording.restoreToCount(num2.intValue());
        }
        picture.endRecording();
        return picture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildRegionPicture(String str, RectF rectF, Path path) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060623626")) {
            return (Picture) ipChange.ipc$dispatch("1060623626", new Object[]{this, str, rectF, path});
        }
        Picture picture = new Picture();
        if (this.shapeList.isEmpty()) {
            return picture;
        }
        resetPaintData();
        Canvas beginRecording = picture.beginRecording(this.width, this.height);
        if (this.isViewBoxBounds) {
            if (this.startX != 0.0f || this.startY != 0.0f) {
                this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                beginRecording.translate(-this.startX, -this.startY);
            }
        } else {
            this.canvasRestoreCount = null;
        }
        Iterator<Integer> it = this.shapeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Integer next = it.next();
            if (next.intValue() == 101) {
                SVGRect sVGRect = this.rectList.get(this.rectIndex);
                String str2 = sVGRect.floorId;
                if (str2 != null && str2.equals(str)) {
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGRect.transformMatrix);
                    }
                    if (sVGRect.fillPaint != null) {
                        float f = sVGRect.rx;
                        if (f <= 0.0f && sVGRect.ry <= 0.0f) {
                            beginRecording.drawRect(sVGRect.rect, this.fillPaint);
                        } else {
                            beginRecording.drawRoundRect(sVGRect.rect, f, sVGRect.ry, this.fillPaint);
                        }
                    }
                    if (sVGRect.strokePaint != null) {
                        float f2 = sVGRect.rx;
                        if (f2 <= 0.0f && sVGRect.ry <= 0.0f) {
                            beginRecording.drawRect(sVGRect.rect, this.strokePaint);
                        } else {
                            beginRecording.drawRoundRect(sVGRect.rect, f2, sVGRect.ry, this.strokePaint);
                        }
                    }
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    rectF.set(sVGRect.rect);
                } else {
                    this.rectIndex++;
                }
            } else if (next.intValue() == 102) {
                G g = this.gList.get(this.gIndex);
                if (g.isParseEnd) {
                    if (!this.matrixStack.isEmpty()) {
                        this.matrixStack.removeLast();
                        beginRecording.restore();
                    }
                } else if (g.transformMatrix != null) {
                    beginRecording.save();
                    beginRecording.concat(g.transformMatrix);
                    this.matrixStack.add(g.transformMatrix);
                }
                this.gIndex++;
            } else if (next.intValue() == 103) {
                SVGLine sVGLine = this.lineList.get(this.lineIndex);
                String str3 = sVGLine.floorId;
                if (str3 != null && str3.equals(str)) {
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGLine.transformMatrix);
                    }
                    Paint paint = sVGLine.strokePaint;
                    if (paint != null) {
                        beginRecording.drawLine(sVGLine.startX, sVGLine.startY, sVGLine.endX, sVGLine.endY, paint);
                    }
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.restore();
                    }
                } else {
                    this.ovalIndex++;
                }
            } else if (next.intValue() == 104) {
                SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                String str4 = sVGOval.floorId;
                if (str4 != null && str4.equals(str)) {
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGOval.transformMatrix);
                    }
                    if (sVGOval.fillPaint != null) {
                        beginRecording.drawOval(sVGOval.rect, this.fillPaint);
                    }
                    if (sVGOval.strokePaint != null) {
                        beginRecording.drawOval(sVGOval.rect, this.strokePaint);
                    }
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    rectF.set(sVGOval.rect);
                } else {
                    this.ovalIndex++;
                }
            } else if (next.intValue() == 105) {
                SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                String str5 = sVGPolygon.floorId;
                if (str5 != null && str5.equals(str)) {
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPolygon.transformMatrix);
                    }
                    if (sVGPolygon.fillPaint != null) {
                        beginRecording.drawPath(sVGPolygon.path, this.fillPaint);
                    }
                    if (sVGPolygon.strokePaint != null) {
                        beginRecording.drawPath(sVGPolygon.path, this.strokePaint);
                    }
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    rectF.set(sVGPolygon.rect);
                    path.set(sVGPolygon.path);
                } else {
                    this.polygonIndex++;
                }
            } else if (next.intValue() != 106) {
                continue;
            } else {
                SVGPath sVGPath = this.pathList.get(this.pathIndex);
                String str6 = sVGPath.floorId;
                if (str6 != null && str6.equals(str)) {
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPath.transformMatrix);
                    }
                    if (sVGPath.fillPaint != null) {
                        beginRecording.drawPath(sVGPath.path, this.fillPaint);
                    }
                    if (sVGPath.strokePaint != null) {
                        beginRecording.drawPath(sVGPath.path, this.strokePaint);
                    }
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    rectF.set(sVGPath.rect);
                    path.set(sVGPath.path);
                } else {
                    this.pathIndex++;
                }
            }
        }
        Integer num = this.canvasRestoreCount;
        if (num != null) {
            beginRecording.restoreToCount(num.intValue());
        }
        picture.endRecording();
        return picture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildStrokePicture(List<SeatPrice> list, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "469513353")) {
            return (Picture) ipChange.ipc$dispatch("469513353", new Object[]{this, list, regionData});
        }
        if (list == null || list.isEmpty() || regionData == null || this.shapeList.isEmpty()) {
            return null;
        }
        Picture picture = new Picture();
        resetPaintData();
        Canvas beginRecording = picture.beginRecording(this.width, this.height);
        if (this.isViewBoxBounds) {
            if (this.startX != 0.0f || this.startY != 0.0f) {
                this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                beginRecording.translate(-this.startX, -this.startY);
            }
        } else {
            this.canvasRestoreCount = null;
        }
        for (Integer num : this.shapeList) {
            switch (num.intValue()) {
                case 101:
                    SVGRect sVGRect = this.rectList.get(this.rectIndex);
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGRect.transformMatrix);
                    }
                    String str = sVGRect.floorId;
                    if (str != null && sVGRect.rowId == null && hasSelectedColor(list, str, regionData)) {
                        float f = sVGRect.rx;
                        if (f <= 0.0f && sVGRect.ry <= 0.0f) {
                            beginRecording.drawRect(sVGRect.rect, this.priceColorStrokePaint);
                        } else {
                            beginRecording.drawRoundRect(sVGRect.rect, f, sVGRect.ry, this.priceColorStrokePaint);
                        }
                    }
                    if (sVGRect.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.rectIndex++;
                    break;
                case 102:
                    G g = this.gList.get(this.gIndex);
                    if (g.isParseEnd) {
                        if (!this.matrixStack.isEmpty()) {
                            this.matrixStack.removeLast();
                            beginRecording.restore();
                        }
                    } else if (g.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(g.transformMatrix);
                        this.matrixStack.add(g.transformMatrix);
                    }
                    this.gIndex++;
                    break;
                case 103:
                    SVGLine sVGLine = this.lineList.get(this.lineIndex);
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGLine.transformMatrix);
                    }
                    if (sVGLine.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.lineIndex++;
                    break;
                case 104:
                    SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGOval.transformMatrix);
                    }
                    String str2 = sVGOval.floorId;
                    if (str2 != null && sVGOval.rowId == null && hasSelectedColor(list, str2, regionData)) {
                        beginRecording.drawOval(sVGOval.rect, this.priceColorStrokePaint);
                    }
                    if (sVGOval.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.ovalIndex++;
                    break;
                case 105:
                    SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPolygon.transformMatrix);
                    }
                    String str3 = sVGPolygon.floorId;
                    if (str3 != null && sVGPolygon.rowId == null && hasSelectedColor(list, str3, regionData)) {
                        beginRecording.drawPath(sVGPolygon.path, this.priceColorStrokePaint);
                    }
                    if (sVGPolygon.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.polygonIndex++;
                    break;
                case 106:
                    SVGPath sVGPath = this.pathList.get(this.pathIndex);
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGPath.transformMatrix);
                    }
                    String str4 = sVGPath.floorId;
                    if (str4 != null && sVGPath.rowId == null && hasSelectedColor(list, str4, regionData)) {
                        beginRecording.drawPath(sVGPath.path, this.priceColorStrokePaint);
                    }
                    if (sVGPath.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.pathIndex++;
                    break;
                case 107:
                    SVGText sVGText = this.textList.get(this.textIndex);
                    if (sVGText.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(sVGText.transformMatrix);
                    }
                    if (!TextUtils.isEmpty(sVGText.content)) {
                        Paint paint = sVGText.fillPaint;
                        if (paint != null) {
                            paint.setColor(sVGText.fillColor);
                            if (sVGText.strokePaint != null) {
                                sVGText.fillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                            }
                            sVGText.fillPaint.setTextSize(sVGText.textSize);
                            beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.fillPaint);
                        } else {
                            Paint paint2 = sVGText.strokePaint;
                            if (paint2 != null) {
                                paint2.setColor(sVGText.strokeColor);
                                sVGText.strokePaint.setTextSize(sVGText.textSize);
                                beginRecording.drawText(sVGText.content, sVGText.x, sVGText.y, sVGText.strokePaint);
                            }
                        }
                    }
                    if (sVGText.transformMatrix != null) {
                        beginRecording.restore();
                    }
                    this.textIndex++;
                    break;
            }
        }
        Integer num2 = this.canvasRestoreCount;
        if (num2 != null) {
            beginRecording.restoreToCount(num2.intValue());
        }
        picture.endRecording();
        return picture;
    }

    public void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208652325")) {
            ipChange.ipc$dispatch("-1208652325", new Object[]{this});
            return;
        }
        this.canvasRestoreCount = null;
        this.height = 0;
        this.width = 0;
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.isViewBoxBounds = false;
        this.shapeList.clear();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public int getRegionCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1890404154") ? ((Integer) ipChange.ipc$dispatch("-1890404154", new Object[]{this})).intValue() : regionCount(this.rectList) + 0 + regionCount(this.ovalList) + regionCount(this.pathList) + regionCount(this.polygonList);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public int getShapeCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "932380129") ? ((Integer) ipChange.ipc$dispatch("932380129", new Object[]{this})).intValue() : wh2.e(this.rectList) + 0 + wh2.e(this.lineList) + wh2.e(this.ovalList) + wh2.e(this.pathList) + wh2.e(this.polygonList) + wh2.e(this.textList);
    }

    public List<String> getUnrecognizedCommandList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1815249011") ? (List) ipChange.ipc$dispatch("1815249011", new Object[]{this}) : this.unrecognizedCommandList;
    }

    public void setSVGHeightAndWidth(int i, int i2, boolean z, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942326324")) {
            ipChange.ipc$dispatch("942326324", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        this.height = i2;
        this.width = i;
        this.isViewBoxBounds = z;
        if (z) {
            this.startX = f;
            this.startY = f2;
        }
    }

    public void setUnrecognizedCommandList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878756433")) {
            ipChange.ipc$dispatch("878756433", new Object[]{this, list});
        } else {
            this.unrecognizedCommandList = list;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPicture() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "375698435") ? (Picture) ipChange.ipc$dispatch("375698435", new Object[]{this}) : buildPicture(false);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.AbstractC0856a
    public Picture buildPicture(@NonNull g52 g52Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835930051")) {
            return (Picture) ipChange.ipc$dispatch("-1835930051", new Object[]{this, g52Var});
        }
        Picture picture = new Picture();
        if (this.shapeList.isEmpty()) {
            return picture;
        }
        resetPaintData();
        Canvas beginRecording = picture.beginRecording(this.width, this.height);
        if (this.isViewBoxBounds) {
            if (this.startX != 0.0f || this.startY != 0.0f) {
                this.canvasRestoreCount = Integer.valueOf(beginRecording.save());
                beginRecording.clipRect(0.0f, 0.0f, this.width, this.height);
                beginRecording.translate(-this.startX, -this.startY);
            }
        } else {
            this.canvasRestoreCount = null;
        }
        for (Integer num : this.shapeList) {
            switch (num.intValue()) {
                case 101:
                    SVGRect sVGRect = this.rectList.get(this.rectIndex);
                    g52Var.b(sVGRect);
                    int[] iArr = g52Var.a;
                    sVGRect.draw(beginRecording, iArr[0], iArr[1]);
                    this.rectIndex++;
                    break;
                case 102:
                    G g = this.gList.get(this.gIndex);
                    if (g.isParseEnd) {
                        if (!this.matrixStack.isEmpty()) {
                            this.matrixStack.removeLast();
                            beginRecording.restore();
                        }
                    } else if (g.transformMatrix != null) {
                        beginRecording.save();
                        beginRecording.concat(g.transformMatrix);
                        this.matrixStack.add(g.transformMatrix);
                    }
                    this.gIndex++;
                    break;
                case 103:
                    SVGLine sVGLine = this.lineList.get(this.lineIndex);
                    g52Var.b(sVGLine);
                    int[] iArr2 = g52Var.a;
                    sVGLine.draw(beginRecording, iArr2[0], iArr2[1]);
                    this.lineIndex++;
                    break;
                case 104:
                    SVGOval sVGOval = this.ovalList.get(this.ovalIndex);
                    g52Var.b(sVGOval);
                    int[] iArr3 = g52Var.a;
                    sVGOval.draw(beginRecording, iArr3[0], iArr3[1]);
                    this.ovalIndex++;
                    break;
                case 105:
                    SVGPolygon sVGPolygon = this.polygonList.get(this.polygonIndex);
                    g52Var.b(sVGPolygon);
                    int[] iArr4 = g52Var.a;
                    sVGPolygon.draw(beginRecording, iArr4[0], iArr4[1]);
                    this.polygonIndex++;
                    break;
                case 106:
                    SVGPath sVGPath = this.pathList.get(this.pathIndex);
                    g52Var.b(sVGPath);
                    int[] iArr5 = g52Var.a;
                    sVGPath.draw(beginRecording, iArr5[0], iArr5[1]);
                    this.pathIndex++;
                    break;
                case 107:
                    SVGText sVGText = this.textList.get(this.textIndex);
                    g52Var.b(sVGText);
                    int[] iArr6 = g52Var.a;
                    sVGText.draw(beginRecording, iArr6[0], iArr6[1]);
                    this.textIndex++;
                    break;
            }
        }
        Integer num2 = this.canvasRestoreCount;
        if (num2 != null) {
            beginRecording.restoreToCount(num2.intValue());
        }
        picture.endRecording();
        return picture;
    }
}
