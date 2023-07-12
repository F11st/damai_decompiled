package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.WXImageView;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class WXTitleBorderView extends LinearLayout {
    public WXImageView icon;
    WXComponent mComponent;
    Context mContext;
    int mtextLineHeight;
    int realTextFontSize;
    String title;
    private TextView titleText;

    public WXTitleBorderView(Context context, WXComponent wXComponent) {
        super(context);
        this.mContext = context;
        this.mComponent = wXComponent;
        setOrientation(0);
        this.icon = new WXImageView(context);
        int realPxByWidth = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textfontsize", 20)).intValue());
        this.realTextFontSize = realPxByWidth;
        this.mtextLineHeight = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textlineheight", Integer.valueOf(realPxByWidth))).intValue());
        String str = wXComponent.getAttrs().get("value") != null ? (String) wXComponent.getAttrs().get("value") : "测试标题";
        this.title = str;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.realTextFontSize * str.length()) + 2, this.mtextLineHeight + 5);
        layoutParams.leftMargin = 6;
        TextView textView = new TextView(context);
        this.titleText = textView;
        textView.setGravity(17);
        this.titleText.setSingleLine();
        this.titleText.setLayoutParams(layoutParams);
        this.titleText.setText(this.title);
        this.titleText.setTextColor(Color.parseColor((String) getValue("textcolor", "#000000")));
        this.titleText.setTextSize(0, WXViewUtils.getRealPxByWidth(((Integer) getValue("textfontsize", 20)).intValue()));
        this.icon.setScaleType(ImageView.ScaleType.FIT_XY);
        int i = this.realTextFontSize;
        this.icon.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        addView(this.icon);
        addView(this.titleText);
    }

    public <T> T getValue(String str, T t) {
        T t2 = (T) this.mComponent.getAttrs().get(str);
        return t2 != null ? t2 : t;
    }
}
