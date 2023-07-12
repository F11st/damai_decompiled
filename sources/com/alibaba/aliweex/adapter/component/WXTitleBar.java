package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageSharpen;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import tb.v32;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXTitleBar extends WXComponent<View> {
    WXTitleBorderView borderView;
    int iconTextSize;
    View leftLine;
    int mBarSpace;
    String mlineColor;
    int mlineWeight;
    String mtextBorderColor;
    int mtextBorderRadius;
    int mtextBorderWidth;
    String mtextColor;
    String mtextFontFamliy;
    int mtextFontSize;
    int mtextInnerSpace;
    int mtextLineHeight;
    int mtextOuterSpace;
    String mtextTitle;
    View rightLine;
    int titleWidth;
    int width;
    WXTitleBorderView wxTitleBorderView;

    public WXTitleBar(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mlineWeight = 1;
    }

    public void drawLine(Context context) {
        int length = (this.mtextTitle.length() * this.mtextFontSize) + this.iconTextSize + this.mtextInnerSpace + 2;
        this.titleWidth = length;
        int i = (((this.width / 2) - (length / 2)) - this.mBarSpace) - this.mtextOuterSpace;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.mlineWeight);
        layoutParams.leftMargin = this.mBarSpace;
        layoutParams.width = i;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, this.mlineWeight);
        layoutParams2.leftMargin = this.mtextOuterSpace;
        layoutParams2.width = i;
        this.leftLine = new View(context);
        this.rightLine = new View(context);
        this.leftLine.setBackgroundColor(Color.parseColor(this.mlineColor));
        this.rightLine.setBackgroundColor(Color.parseColor(this.mlineColor));
        this.leftLine.setLayoutParams(layoutParams);
        this.rightLine.setLayoutParams(layoutParams2);
    }

    public void drawTilebar(Context context) {
        this.wxTitleBorderView = new WXTitleBorderView(context, this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.titleWidth, this.mtextFontSize + 10);
        layoutParams.leftMargin = this.mtextOuterSpace;
        this.wxTitleBorderView.setLayoutParams(layoutParams);
        this.wxTitleBorderView.setGravity(17);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(-16776961);
        if (this.mtextBorderWidth == 0) {
            paint.setColor(0);
        }
        paint.setStrokeWidth(this.mtextBorderWidth);
        v32 v32Var = new v32(paint, this.mtextBorderRadius);
        if (Build.VERSION.SDK_INT >= 16) {
            this.wxTitleBorderView.setBackground(v32Var);
        }
    }

    public <T> T getValue(String str, T t) {
        T t2 = (T) getStyles().get(str);
        return t2 != null ? t2 : t;
    }

    public void init() {
        this.mlineColor = (String) getValue("linecolor", "#000000");
        this.mlineWeight = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("lineweight", 1)).intValue());
        this.mBarSpace = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("barspace", 30)).intValue());
        int realPxByWidth = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textborderwidth", 1)).intValue());
        this.mtextBorderWidth = realPxByWidth;
        this.mtextInnerSpace = realPxByWidth != 0 ? (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textinnerspace", 20)).intValue()) : 0;
        this.mtextOuterSpace = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textouterspace", 10)).intValue());
        this.mtextColor = (String) getValue("textcolor", "#000000");
        this.mtextFontSize = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textfontsize", 20)).intValue());
        this.mtextTitle = getAttrs().get("value") != null ? (String) getAttrs().get("value") : "测试标题";
        this.mtextFontFamliy = (String) getValue("textfontfamliy", "");
        int realPxByWidth2 = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textlineheight", Integer.valueOf(this.mtextFontSize))).intValue());
        this.mtextLineHeight = realPxByWidth2;
        this.mtextBorderRadius = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("textborderradius", Integer.valueOf(realPxByWidth2 / 2))).intValue());
        this.mtextBorderColor = (String) getValue("textbordercolor", "#000000");
        this.iconTextSize = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("icontextfontsize", Integer.valueOf(this.mtextFontSize))).intValue());
        this.width = (int) WXViewUtils.getRealPxByWidth(((Integer) getValue("width", Integer.valueOf((int) FeatureFactory.PRIORITY_ABOVE_NORMAL))).intValue());
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(Context context) {
        init();
        drawLine(context);
        drawTilebar(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(this.leftLine);
        linearLayout.addView(this.wxTitleBorderView);
        linearLayout.addView(this.rightLine);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals("src")) {
            return super.setProperty(str, obj);
        }
        String string = WXUtils.getString(obj, null);
        if (string != null) {
            setSrc(string);
            return true;
        }
        return true;
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        WXImageStrategy wXImageStrategy = new WXImageStrategy();
        wXImageStrategy.isClipping = true;
        wXImageStrategy.isSharpen = getAttrs().getImageSharpen() == WXImageSharpen.SHARPEN;
        IWXImgLoaderAdapter imgLoaderAdapter = getInstance().getImgLoaderAdapter();
        if (imgLoaderAdapter != null) {
            imgLoaderAdapter.setImage(str, this.wxTitleBorderView.icon, getAttrs().getImageQuality(), wXImageStrategy);
        }
    }
}
