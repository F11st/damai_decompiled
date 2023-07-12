package com.alibaba.android.bindingx.core;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlatformManager {
    private IDeviceResolutionTranslator a;
    private IViewFinder b;
    private IViewUpdater c;
    private IScrollFactory d;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface IDeviceResolutionTranslator {
        double nativeToWeb(double d, Object... objArr);

        double webToNative(double d, Object... objArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface IScrollFactory {
        void addScrollListenerWith(@NonNull String str, @NonNull ScrollListener scrollListener);

        void removeScrollListenerWith(@NonNull String str, @NonNull ScrollListener scrollListener);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface IViewFinder {
        @Nullable
        View findViewBy(String str, Object... objArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface IViewUpdater {
        void synchronouslyUpdateViewOnUIThread(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map, Object... objArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface ScrollListener {
        void onScrollEnd(float f, float f2);

        void onScrollStart();

        void onScrolled(float f, float f2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class b {
        private IDeviceResolutionTranslator a;
        private IViewFinder b;
        private IViewUpdater c;
        private IScrollFactory d;

        public PlatformManager a() {
            PlatformManager platformManager = new PlatformManager();
            platformManager.b = this.b;
            platformManager.a = this.a;
            platformManager.c = this.c;
            platformManager.d = this.d;
            return platformManager;
        }

        public b b(@NonNull IDeviceResolutionTranslator iDeviceResolutionTranslator) {
            this.a = iDeviceResolutionTranslator;
            return this;
        }

        public b c(@Nullable IScrollFactory iScrollFactory) {
            this.d = iScrollFactory;
            return this;
        }

        public b d(@NonNull IViewFinder iViewFinder) {
            this.b = iViewFinder;
            return this;
        }

        public b e(@NonNull IViewUpdater iViewUpdater) {
            this.c = iViewUpdater;
            return this;
        }
    }

    @NonNull
    public IDeviceResolutionTranslator e() {
        return this.a;
    }

    @Nullable
    public IScrollFactory f() {
        return this.d;
    }

    @NonNull
    public IViewFinder g() {
        return this.b;
    }

    @NonNull
    public IViewUpdater h() {
        return this.c;
    }

    private PlatformManager() {
    }
}
