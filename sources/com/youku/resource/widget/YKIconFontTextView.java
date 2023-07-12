package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.youku.resource.utils.IconFontUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKIconFontTextView extends AppCompatTextView {
    public YKIconFontTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setTypeface(IconFontUtils.getIconFont());
    }

    public YKIconFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public YKIconFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
