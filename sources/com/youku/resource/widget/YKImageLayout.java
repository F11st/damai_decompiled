package com.youku.resource.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKImageLayout extends FrameLayout {
    private TUrlImageView gif;
    private YKImageView resource_image;

    public YKImageLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(context).inflate(R.C8074layout.resource_ykimageview, (ViewGroup) this, true);
        this.resource_image = (YKImageView) inflate.findViewById(R.id.resource_image);
        this.gif = (TUrlImageView) inflate.findViewById(R.id.gif);
    }

    public YKImageView getYKImageView() {
        return this.resource_image;
    }

    public void hideAll() {
        this.resource_image.hideAll();
        this.gif.setImageUrl(null);
    }

    public void setBottomLeftText(String str) {
        this.resource_image.setBottomLeftText(str);
    }

    public void setBottomRightText(String str) {
        this.resource_image.setBottomRightText(str);
    }

    public void setCorner(boolean z, boolean z2, boolean z3, boolean z4) {
        this.resource_image.setCorner(z, z2, z3, z4);
    }

    public void setRank(int i) {
        this.resource_image.setRank(i);
    }

    public void setReputation(String str) {
        this.resource_image.setReputation(str);
    }

    public void setTopRight(String str, int i) {
        this.resource_image.setTopRight(str, i);
    }

    public void setTopRightImageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.indexOf("?") == -1 && str.endsWith("apng")) {
            str = str + "?noResize=1&noWebp=1";
        }
        this.gif.setImageUrl(str);
    }

    public YKImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
