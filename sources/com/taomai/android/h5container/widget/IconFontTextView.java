package com.taomai.android.h5container.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.taomai.android.h5container.R$styleable;
import tb.b11;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IconFontTextView extends AppCompatTextView {
    private static final String TAG = "IconFontTextView";
    private Context context;
    private String iconFontAssetTypeface;

    public IconFontTextView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setTypeface(b11.a(context, this.iconFontAssetTypeface));
    }

    private void initAttrs(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.IconFont, i, 0);
        this.iconFontAssetTypeface = obtainStyledAttributes.getString(R$styleable.IconFont_iconFont_assetTypeface);
        obtainStyledAttributes.recycle();
    }

    public IconFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttrs(attributeSet, 0);
        init(context);
    }

    public IconFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(attributeSet, i);
        init(context);
    }
}
