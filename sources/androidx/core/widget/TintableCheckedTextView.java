package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface TintableCheckedTextView {
    @Nullable
    ColorStateList getSupportCheckMarkTintList();

    @Nullable
    PorterDuff.Mode getSupportCheckMarkTintMode();

    void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList);

    void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode);
}
