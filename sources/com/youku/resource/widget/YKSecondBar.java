package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKSecondBar extends LinearLayout implements YKCustomizedView {
    public static final String SECOND_BAR_STYLE_1 = "second_bar_1";
    public static final String SECOND_BAR_STYLE_2 = "second_bar_2";
    public static final String SECOND_BAR_STYLE_4 = "second_bar_4";
    public static final String SECOND_BAR_STYLE_5 = "second_bar_5";
    private View backView;
    private String barStyle;
    private YKTextView extendView;
    private YKTextView titleView;

    public YKSecondBar(Context context) {
        super(context);
        init(context, null);
    }

    public View getBackView() {
        return this.backView;
    }

    public YKTextView getExtendView() {
        return this.extendView;
    }

    public YKTextView getTitleView() {
        return this.titleView;
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKSecondBarWidget, 0, 0);
            this.barStyle = obtainStyledAttributes.getString(R.styleable.YKSecondBarWidget_secondbar_style);
            obtainStyledAttributes.recycle();
        }
        LayoutInflater.from(context).inflate(R.C8074layout.yk_secondbar_layout, (ViewGroup) this, true);
        setStyle(this.barStyle);
    }

    public void setStyle(String str) {
        this.backView = findViewById(R.id.yk_secondbar_back);
        this.titleView = (YKTextView) findViewById(R.id.yk_secondbar_title);
        this.extendView = (YKTextView) findViewById(R.id.yk_secondbar_extend);
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -377860230:
                    if (str.equals(SECOND_BAR_STYLE_1)) {
                        c = 0;
                        break;
                    }
                    break;
                case -377860229:
                    if (str.equals(SECOND_BAR_STYLE_2)) {
                        c = 1;
                        break;
                    }
                    break;
                case -377860227:
                    if (str.equals(SECOND_BAR_STYLE_4)) {
                        c = 3;
                        break;
                    }
                    break;
                case -377860226:
                    if (str.equals(SECOND_BAR_STYLE_5)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c != 1) {
                return;
            }
            this.extendView.setVisibility(4);
        }
    }

    public YKSecondBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
