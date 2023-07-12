package com.youku.arch.v3.page;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.uc.webview.export.media.MessageID;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H&J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0007H&J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0018\u001a\u00020\u0007H&J\b\u0010\u0019\u001a\u00020\u0007H&J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH&¨\u0006 "}, d2 = {"Lcom/youku/arch/v3/page/ActivityInterceptor;", "", "", "position", "", "positionOffset", "positionOffsetPixels", "Ltb/wt2;", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "onResume", MessageID.onPause, MessageID.onStop, "onBackPressed", "onDestroy", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onNewIntent", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ActivityInterceptor {
    void onAttachedToWindow();

    void onBackPressed();

    void onConfigurationChanged(@Nullable Configuration configuration);

    void onCreate(@Nullable Bundle bundle);

    void onDestroy();

    void onDetachedFromWindow();

    void onMultiWindowModeChanged(boolean z);

    void onNewIntent(@Nullable Intent intent);

    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, int i2);

    void onPageSelected(int i);

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
