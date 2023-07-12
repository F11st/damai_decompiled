package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.view.DMLabelType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMLabelView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] bgColors;
    private float[] cornerRadii;
    private int gravity;
    private TextView label;
    private int labelHeight;
    private String labelName;
    private FrameLayout.LayoutParams labelParams;
    private int labelTextColor;
    private float labelTextSize;
    private DMLabelType labelType;
    private int labelWidth;
    private int paddingLeft;
    private int paddingRight;
    private int strokeColor;
    private int strokeWidth;

    public DMLabelView(@NonNull Context context) {
        super(context);
        initDefault(context);
    }

    private void drawLabel() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207398821")) {
            ipChange.ipc$dispatch("-207398821", new Object[]{this});
            return;
        }
        if (!TextUtils.isEmpty(this.labelName)) {
            this.label.setText(this.labelName);
        } else {
            this.label.setText(this.labelType.labelName);
        }
        this.label.setTextSize(1, this.labelTextSize);
        this.label.setTextColor(this.labelTextColor);
        int i2 = this.labelHeight;
        if (i2 != 0) {
            setMinimumHeight(i2);
        }
        int i3 = this.labelWidth;
        if (i3 != 0) {
            setMinimumWidth(i3);
        }
        FrameLayout.LayoutParams layoutParams = this.labelParams;
        int i4 = this.gravity;
        layoutParams.gravity = i4;
        this.label.setGravity(i4);
        setPadding(this.paddingLeft, 0, this.paddingRight, 0);
        GradientDrawable gradientDrawable = new GradientDrawable(getOrientation(), getColors());
        gradientDrawable.setCornerRadii(this.cornerRadii);
        int i5 = this.strokeColor;
        if (i5 != 0 && (i = this.strokeWidth) > 0) {
            gradientDrawable.setStroke(i, i5);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }

    private int[] getColors() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660312769")) {
            return (int[]) ipChange.ipc$dispatch("-660312769", new Object[]{this});
        }
        DMLabelType dMLabelType = this.labelType;
        String str2 = "#6A7A99";
        if (dMLabelType == DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE) {
            str = "#7A6EFF";
            str2 = "#30AEFF";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_BUYING || dMLabelType == DMLabelType.LABEL_TYPE_UPCOMING_BUY || dMLabelType == DMLabelType.LABEL_TYPE_HIGHEST_HOT) {
            str = "#FF3E75";
            str2 = "#FF3E9F";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_NEW_SALE) {
            str2 = "#29D6FF";
            str = "#30AEFF";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_TOUR) {
            str2 = "#FF4BB1";
            str = "#D44BFF";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_SOLD_OUT || dMLabelType == DMLabelType.LABEL_TYPE_ALL_SELL_OUT) {
            str = "#6A7A99";
            str2 = "#98A7C2";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_CUSTOM) {
            int[] iArr = this.bgColors;
            return iArr != null ? iArr : new int[]{Color.parseColor("#FF2869"), Color.parseColor("#FF2869")};
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_RANK_TOP_ONE) {
            str2 = "#FF5A5A";
            str = "#FF42B0";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_RANK_TOP_TWO) {
            str2 = "#FF833C";
            str = "#FF4A72";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_RANK_TOP_THREE) {
            str2 = "#FFDA00";
            str = "#FFAD00";
        } else if (dMLabelType == DMLabelType.LABEL_TYPE_RANK_TOP_OTHER) {
            str = "#98A7C2";
        } else {
            str = "#FF2869";
            str2 = str;
        }
        return new int[]{Color.parseColor(str2), Color.parseColor(str)};
    }

    private GradientDrawable.Orientation getOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139814489")) {
            return (GradientDrawable.Orientation) ipChange.ipc$dispatch("2139814489", new Object[]{this});
        }
        DMLabelType dMLabelType = this.labelType;
        if (dMLabelType != DMLabelType.LABEL_TYPE_RANK_TOP_ONE && dMLabelType != DMLabelType.LABEL_TYPE_RANK_TOP_TWO && dMLabelType != DMLabelType.LABEL_TYPE_RANK_TOP_THREE && dMLabelType != DMLabelType.LABEL_TYPE_RANK_TOP_OTHER) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return GradientDrawable.Orientation.BL_TR;
    }

    private void initDefault(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636367154")) {
            ipChange.ipc$dispatch("-1636367154", new Object[]{this, context});
            return;
        }
        this.labelType = DMLabelType.LABEL_TYPE_CUSTOM;
        this.labelTextSize = 11.0f;
        this.labelTextColor = Color.parseColor("#FFFFFF");
        this.gravity = 17;
        s60 s60Var = s60.INSTANCE;
        this.labelHeight = s60Var.b(context, 24);
        this.paddingLeft = s60Var.b(context, 4);
        this.paddingRight = s60Var.b(context, 4);
        int i = this.labelHeight;
        this.cornerRadii = new float[]{i / 2, i / 2, i / 2, i / 2, i / 2, i / 2, s60Var.b(context, 2), s60Var.b(context, 2)};
        TextView textView = new TextView(context);
        this.label = textView;
        textView.setSingleLine(true);
        this.label.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        this.labelParams = layoutParams;
        addView(this.label, layoutParams);
    }

    public DMLabelView setBgColor(int... iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1074829066")) {
            return (DMLabelView) ipChange.ipc$dispatch("1074829066", new Object[]{this, iArr});
        }
        this.bgColors = iArr;
        drawLabel();
        return this;
    }

    public DMLabelView setContentGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788590740")) {
            return (DMLabelView) ipChange.ipc$dispatch("-788590740", new Object[]{this, Integer.valueOf(i)});
        }
        this.gravity = i;
        return this;
    }

    public DMLabelView setCornerRadii(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484247654")) {
            return (DMLabelView) ipChange.ipc$dispatch("-1484247654", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
        this.cornerRadii = new float[]{f, f, f2, f2, f3, f3, f4, f4};
        drawLabel();
        return this;
    }

    public DMLabelView setCornerRadius(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1628013219") ? (DMLabelView) ipChange.ipc$dispatch("-1628013219", new Object[]{this, Float.valueOf(f)}) : setCornerRadii(f, f, f, f);
    }

    public DMLabelView setLabelHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697773982")) {
            return (DMLabelView) ipChange.ipc$dispatch("697773982", new Object[]{this, Integer.valueOf(i)});
        }
        this.labelHeight = i;
        drawLabel();
        return this;
    }

    public DMLabelView setLabelName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392191985")) {
            return (DMLabelView) ipChange.ipc$dispatch("-392191985", new Object[]{this, str});
        }
        this.labelName = str;
        drawLabel();
        return this;
    }

    public DMLabelView setLabelTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569024255")) {
            return (DMLabelView) ipChange.ipc$dispatch("1569024255", new Object[]{this, Integer.valueOf(i)});
        }
        this.labelTextColor = i;
        drawLabel();
        return this;
    }

    public DMLabelView setLabelTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121104186")) {
            return (DMLabelView) ipChange.ipc$dispatch("1121104186", new Object[]{this, Float.valueOf(f)});
        }
        this.labelTextSize = f;
        drawLabel();
        return this;
    }

    public DMLabelView setLabelType(DMLabelType dMLabelType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852889264")) {
            return (DMLabelView) ipChange.ipc$dispatch("-852889264", new Object[]{this, dMLabelType});
        }
        this.labelType = dMLabelType;
        if (TextUtils.isEmpty(this.labelName)) {
            this.labelName = dMLabelType.labelName;
        }
        drawLabel();
        return this;
    }

    public DMLabelView setLabelTypeName(DMLabelType dMLabelType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055467771")) {
            return (DMLabelView) ipChange.ipc$dispatch("-1055467771", new Object[]{this, dMLabelType});
        }
        this.labelType = dMLabelType;
        this.labelName = dMLabelType.labelName;
        drawLabel();
        return this;
    }

    public DMLabelView setLabelWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413799791")) {
            return (DMLabelView) ipChange.ipc$dispatch("1413799791", new Object[]{this, Integer.valueOf(i)});
        }
        this.labelWidth = i;
        drawLabel();
        return this;
    }

    public DMLabelView setPaddingLeft(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500011839")) {
            return (DMLabelView) ipChange.ipc$dispatch("-1500011839", new Object[]{this, Integer.valueOf(i)});
        }
        this.paddingLeft = i;
        drawLabel();
        return this;
    }

    public DMLabelView setPaddingRight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555636790")) {
            return (DMLabelView) ipChange.ipc$dispatch("1555636790", new Object[]{this, Integer.valueOf(i)});
        }
        this.paddingRight = i;
        drawLabel();
        return this;
    }

    public DMLabelView setStroke(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670775126")) {
            return (DMLabelView) ipChange.ipc$dispatch("-670775126", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.strokeColor = i;
        this.strokeWidth = i2;
        drawLabel();
        return this;
    }

    public DMLabelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initDefault(context);
    }

    public DMLabelView setBgColor(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768322495")) {
            return (DMLabelView) ipChange.ipc$dispatch("768322495", new Object[]{this, strArr});
        }
        int length = strArr != null ? strArr.length : 0;
        this.bgColors = new int[length];
        for (int i = 0; i < length; i++) {
            this.bgColors[i] = Color.parseColor(strArr[i]);
        }
        drawLabel();
        return this;
    }

    public DMLabelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initDefault(context);
    }
}
