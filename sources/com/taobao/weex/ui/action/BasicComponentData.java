package com.taobao.weex.ui.action;

import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BasicComponentData<T extends View> {
    private WXAttr mAttributes;
    private CSSShorthand mBorders;
    public String mComponentType;
    private WXEvent mEvents;
    private CSSShorthand mMargins;
    private CSSShorthand mPaddings;
    public String mParentRef;
    public String mRef;
    private WXStyle mStyles;
    private long renderObjectPr = 0;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.ui.action.BasicComponentData$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$dom$CSSShorthand$TYPE;

        static {
            int[] iArr = new int[CSSShorthand.TYPE.values().length];
            $SwitchMap$com$taobao$weex$dom$CSSShorthand$TYPE = iArr;
            try {
                iArr[CSSShorthand.TYPE.MARGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$weex$dom$CSSShorthand$TYPE[CSSShorthand.TYPE.PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$taobao$weex$dom$CSSShorthand$TYPE[CSSShorthand.TYPE.BORDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BasicComponentData(String str, String str2, String str3) {
        this.mRef = str;
        this.mComponentType = str2;
        this.mParentRef = str3;
    }

    private void addBorder(CSSShorthand.EDGE edge, float f) {
        if (this.mBorders == null) {
            this.mBorders = new CSSShorthand();
        }
        this.mBorders.set(edge, f);
    }

    private void addMargin(CSSShorthand.EDGE edge, float f) {
        if (this.mMargins == null) {
            this.mMargins = new CSSShorthand();
        }
        this.mMargins.set(edge, f);
    }

    private void addPadding(CSSShorthand.EDGE edge, float f) {
        if (this.mPaddings == null) {
            this.mPaddings = new CSSShorthand();
        }
        this.mPaddings.set(edge, f);
    }

    public final void addAttr(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        WXAttr wXAttr = this.mAttributes;
        if (wXAttr == null) {
            this.mAttributes = new WXAttr(map, 0);
        } else {
            wXAttr.putAll(map);
        }
    }

    public final void addEvent(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if (this.mEvents == null) {
            this.mEvents = new WXEvent();
        }
        this.mEvents.addAll(set);
    }

    public final void addShorthand(float[] fArr, CSSShorthand.TYPE type) {
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (fArr.length == 4) {
            int i = AnonymousClass1.$SwitchMap$com$taobao$weex$dom$CSSShorthand$TYPE[type.ordinal()];
            if (i == 1) {
                CSSShorthand cSSShorthand = this.mMargins;
                if (cSSShorthand == null) {
                    this.mMargins = new CSSShorthand(fArr);
                } else {
                    cSSShorthand.replace(fArr);
                }
            } else if (i == 2) {
                CSSShorthand cSSShorthand2 = this.mPaddings;
                if (cSSShorthand2 == null) {
                    this.mPaddings = new CSSShorthand(fArr);
                } else {
                    cSSShorthand2.replace(fArr);
                }
            } else if (i != 3) {
            } else {
                CSSShorthand cSSShorthand3 = this.mBorders;
                if (cSSShorthand3 == null) {
                    this.mBorders = new CSSShorthand(fArr);
                } else {
                    cSSShorthand3.replace(fArr);
                }
            }
        }
    }

    public void addStyle(Map<String, Object> map) {
        addStyle(map, false);
    }

    @NonNull
    public final WXAttr getAttrs() {
        if (this.mAttributes == null) {
            this.mAttributes = new WXAttr();
        }
        return this.mAttributes;
    }

    @NonNull
    public CSSShorthand getBorder() {
        if (this.mBorders == null) {
            this.mBorders = new CSSShorthand();
        }
        return this.mBorders;
    }

    @NonNull
    public final WXEvent getEvents() {
        if (this.mEvents == null) {
            this.mEvents = new WXEvent();
        }
        return this.mEvents;
    }

    @NonNull
    public final CSSShorthand getMargin() {
        if (this.mMargins == null) {
            this.mMargins = new CSSShorthand();
        }
        return this.mMargins;
    }

    @NonNull
    public final CSSShorthand getPadding() {
        if (this.mPaddings == null) {
            this.mPaddings = new CSSShorthand();
        }
        return this.mPaddings;
    }

    public long getRenderObjectPr() {
        return this.renderObjectPr;
    }

    @NonNull
    public final WXStyle getStyles() {
        if (this.mStyles == null) {
            this.mStyles = new WXStyle();
        }
        return this.mStyles;
    }

    public boolean isRenderPtrEmpty() {
        return this.renderObjectPr == 0;
    }

    public final void setBorders(@NonNull CSSShorthand cSSShorthand) {
        this.mBorders = cSSShorthand;
    }

    public final void setMargins(@NonNull CSSShorthand cSSShorthand) {
        this.mMargins = cSSShorthand;
    }

    public final void setPaddings(@NonNull CSSShorthand cSSShorthand) {
        this.mPaddings = cSSShorthand;
    }

    public synchronized void setRenderObjectPr(long j) {
        long j2 = this.renderObjectPr;
        if (j2 != j) {
            if (j2 == 0) {
                this.renderObjectPr = j;
            } else {
                throw new RuntimeException("RenderObjectPr has " + j + " old renderObjectPtr " + this.renderObjectPr);
            }
        }
    }

    public final void addStyle(Map<String, Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        WXStyle wXStyle = this.mStyles;
        if (wXStyle == null) {
            this.mStyles = new WXStyle(map);
        } else {
            wXStyle.putAll(map, z);
        }
    }

    /* renamed from: clone */
    public BasicComponentData m581clone() throws CloneNotSupportedException {
        BasicComponentData basicComponentData = new BasicComponentData(this.mRef, this.mComponentType, this.mParentRef);
        basicComponentData.setBorders(getBorder().m577clone());
        basicComponentData.setMargins(getMargin().m577clone());
        basicComponentData.setPaddings(getPadding().m577clone());
        WXAttr wXAttr = this.mAttributes;
        if (wXAttr != null) {
            basicComponentData.mAttributes = wXAttr.m578clone();
        }
        WXStyle wXStyle = this.mStyles;
        if (wXStyle != null) {
            basicComponentData.mStyles = wXStyle.m579clone();
        }
        WXEvent wXEvent = this.mEvents;
        if (wXEvent != null) {
            basicComponentData.mEvents = wXEvent.clone();
        }
        long j = this.renderObjectPr;
        if (j != 0) {
            basicComponentData.setRenderObjectPr(NativeRenderObjectUtils.nativeCopyRenderObject(j));
        }
        return basicComponentData;
    }

    public final void addShorthand(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            key.hashCode();
            char c = 65535;
            switch (key.hashCode()) {
                case -1971292586:
                    if (key.equals(Constants.Name.BORDER_RIGHT_WIDTH)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1501175880:
                    if (key.equals("paddingLeft")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1452542531:
                    if (key.equals(Constants.Name.BORDER_TOP_WIDTH)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1290574193:
                    if (key.equals(Constants.Name.BORDER_BOTTOM_WIDTH)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1081309778:
                    if (key.equals(Constants.Name.MARGIN)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1044792121:
                    if (key.equals(Constants.Name.MARGIN_TOP)) {
                        c = 5;
                        break;
                    }
                    break;
                case -806339567:
                    if (key.equals(Constants.Name.PADDING)) {
                        c = 6;
                        break;
                    }
                    break;
                case -289173127:
                    if (key.equals(Constants.Name.MARGIN_BOTTOM)) {
                        c = 7;
                        break;
                    }
                    break;
                case -223992013:
                    if (key.equals(Constants.Name.BORDER_LEFT_WIDTH)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 90130308:
                    if (key.equals("paddingTop")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 202355100:
                    if (key.equals("paddingBottom")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 713848971:
                    if (key.equals("paddingRight")) {
                        c = 11;
                        break;
                    }
                    break;
                case 741115130:
                    if (key.equals(Constants.Name.BORDER_WIDTH)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 975087886:
                    if (key.equals(Constants.Name.MARGIN_RIGHT)) {
                        c = CharUtils.CR;
                        break;
                    }
                    break;
                case 1970934485:
                    if (key.equals(Constants.Name.MARGIN_LEFT)) {
                        c = 14;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    addBorder(CSSShorthand.EDGE.RIGHT, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 1:
                    addPadding(CSSShorthand.EDGE.LEFT, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 2:
                    addBorder(CSSShorthand.EDGE.TOP, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 3:
                    addBorder(CSSShorthand.EDGE.BOTTOM, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 4:
                    addMargin(CSSShorthand.EDGE.ALL, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 5:
                    addMargin(CSSShorthand.EDGE.TOP, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 6:
                    addPadding(CSSShorthand.EDGE.ALL, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 7:
                    addMargin(CSSShorthand.EDGE.BOTTOM, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case '\b':
                    addBorder(CSSShorthand.EDGE.LEFT, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case '\t':
                    addPadding(CSSShorthand.EDGE.TOP, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case '\n':
                    addPadding(CSSShorthand.EDGE.BOTTOM, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 11:
                    addPadding(CSSShorthand.EDGE.RIGHT, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case '\f':
                    addBorder(CSSShorthand.EDGE.ALL, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case '\r':
                    addMargin(CSSShorthand.EDGE.RIGHT, WXUtils.fastGetFloat(map.get(key)));
                    break;
                case 14:
                    addMargin(CSSShorthand.EDGE.LEFT, WXUtils.fastGetFloat(map.get(key)));
                    break;
            }
        }
    }
}
