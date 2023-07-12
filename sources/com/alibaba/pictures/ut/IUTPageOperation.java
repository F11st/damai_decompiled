package com.alibaba.pictures.ut;

import android.app.Activity;
import java.util.Properties;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&J1\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0014\"\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u001a"}, d2 = {"Lcom/alibaba/pictures/ut/IUTPageOperation;", "", "", "spmPageName", "Ltb/wt2;", "setUTPageName", "getUTPageName", "", "enable", "setUTPageEnable", "Landroid/app/Activity;", "activity", "startExpoTrack", "Ljava/util/Properties;", "properties", "updateUTPageProperties", "spm", "updateSPM", "getPageSPM", "controlName", "", "kvs", "onUTButtonClick", "(Ljava/lang/String;[Ljava/lang/String;)V", "key", "querySavedPageProperty", "ut_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public interface IUTPageOperation {
    @Nullable
    String getPageSPM();

    @Nullable
    String getUTPageName();

    void onUTButtonClick(@Nullable String str, @NotNull String... strArr);

    @Nullable
    String querySavedPageProperty(@Nullable String str);

    void setUTPageEnable(boolean z);

    void setUTPageName(@Nullable String str);

    void startExpoTrack(@Nullable Activity activity);

    void updateSPM(@Nullable String str);

    void updateUTPageProperties(@Nullable Properties properties);
}
