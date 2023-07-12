package cn.damai.uikit.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ILoadingLayout {
    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);

    void setTextTypeface(Typeface typeface);
}
