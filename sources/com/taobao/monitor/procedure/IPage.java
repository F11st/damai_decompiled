package com.taobao.monitor.procedure;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IPage {
    public static final IPage DEFAULT_PAGE = new b();
    public static final int STATUS_BACK = -4;
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_F2B = -3;
    public static final int STATUS_JUMP_NEXT_PAGE = -5;
    public static final int STATUS_LIFECYCLE_MISS = -6;
    public static final int STATUS_MOVE = -2;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIME_OUT = -1;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageBeginStandard {
        void onPageClickTime(long j);

        void onPageNavStartTime(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageDataSetter {
        void addProperty(String str, Object obj);

        void onEvent(String str, Object obj);

        void onStage(String str, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageLifecycleCallback {
        void onPageAppear();

        void onPageCreate(String str, String str2, Map<String, Object> map);

        void onPageDestroy();

        void onPageDisappear();
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PageRenderError {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageRenderStandard {
        void onPageInteractive(long j);

        void onPageLoadError(int i);

        void onPageRenderPercent(float f, long j);

        void onPageRenderStart(long j);

        void onPageVisible(long j);
    }

    @NonNull
    PageBeginStandard getPageBeginStandard();

    @NonNull
    PageDataSetter getPageDataSetter();

    @NonNull
    PageLifecycleCallback getPageLifecycleCallback();

    @NonNull
    PageRenderStandard getPageRenderStandard();
}
