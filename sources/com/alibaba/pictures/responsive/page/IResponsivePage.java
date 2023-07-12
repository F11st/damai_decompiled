package com.alibaba.pictures.responsive.page;

import android.content.res.Configuration;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/responsive/page/IResponsivePage;", "", "Landroid/content/res/Configuration;", "newConfig", "", "responsiveLayoutState", "", "responsiveLayoutStateChanged", "Ltb/wt2;", "onResponsiveLayout", "app_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface IResponsivePage {
    void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z);
}
