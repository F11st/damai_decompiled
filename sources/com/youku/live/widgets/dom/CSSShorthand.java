package com.youku.live.widgets.dom;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.Enum;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CSSShorthand<T extends Enum<? extends CSSProperty>> implements Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    private float[] values;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum CORNER implements CSSProperty {
        BORDER_TOP_LEFT,
        BORDER_TOP_RIGHT,
        BORDER_BOTTOM_RIGHT,
        BORDER_BOTTOM_LEFT,
        ALL
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    interface CSSProperty {
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum EDGE implements CSSProperty {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        ALL
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum TYPE {
        MARGIN,
        PADDING,
        BORDER
    }

    public CSSShorthand(float[] fArr) {
        replace(fArr);
    }

    private float getInternal(@NonNull Enum<? extends CSSProperty> r5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140955424")) {
            return ((Float) ipChange.ipc$dispatch("1140955424", new Object[]{this, r5})).floatValue();
        }
        if (r5 == EDGE.ALL || r5 == CORNER.ALL) {
            return 0.0f;
        }
        return this.values[r5.ordinal()];
    }

    private void setInternal(@NonNull Enum<? extends CSSProperty> r5, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924538780")) {
            ipChange.ipc$dispatch("924538780", new Object[]{this, r5, Float.valueOf(f)});
        } else if (r5 != EDGE.ALL && r5 != CORNER.ALL) {
            this.values[r5.ordinal()] = f;
        } else {
            Arrays.fill(this.values, f);
        }
    }

    public float get(@NonNull EDGE edge) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1307958517") ? ((Float) ipChange.ipc$dispatch("1307958517", new Object[]{this, edge})).floatValue() : getInternal(edge);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void replace(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093068288")) {
            ipChange.ipc$dispatch("-2093068288", new Object[]{this, fArr});
        } else {
            this.values = fArr;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void set(@NonNull EDGE edge, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260472167")) {
            ipChange.ipc$dispatch("260472167", new Object[]{this, edge, Float.valueOf(f)});
        } else {
            setInternal(edge, f);
        }
    }

    /* renamed from: clone */
    public CSSShorthand m1269clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1135233511") ? (CSSShorthand) ipChange.ipc$dispatch("-1135233511", new Object[]{this}) : (CSSShorthand) super.clone();
    }

    public float get(@NonNull CORNER corner) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1274418909") ? ((Float) ipChange.ipc$dispatch("1274418909", new Object[]{this, corner})).floatValue() : getInternal(corner);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void set(@NonNull CORNER corner, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583085439")) {
            ipChange.ipc$dispatch("583085439", new Object[]{this, corner, Float.valueOf(f)});
        } else {
            setInternal(corner, f);
        }
    }

    public CSSShorthand() {
        this(false);
    }

    CSSShorthand(boolean z) {
        float[] fArr = new float[Math.max(EDGE.values().length, CORNER.values().length)];
        this.values = fArr;
        if (z) {
            Arrays.fill(fArr, Float.NaN);
        }
    }
}
