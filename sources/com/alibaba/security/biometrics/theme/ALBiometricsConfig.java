package com.alibaba.security.biometrics.theme;

import com.alibaba.security.biometrics.transition.TransitionMode;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsConfig implements Serializable {
    public static final transient boolean DEFAULT_NEED_SOUND = true;
    public static final transient TransitionMode DEFAULT_TRANSITION_MODE = TransitionMode.NULL;
    boolean isNeedFailResultPage;
    final boolean isNeedSound;
    final boolean isShouldAlertOnExit;
    boolean mIsSkinInAssets;
    final String skinPath;
    final TransitionMode transitionMode;

    public ALBiometricsConfig() {
        this(new Builder());
    }

    public String getSkinPath() {
        return this.skinPath;
    }

    public TransitionMode getTransitionMode() {
        return this.transitionMode;
    }

    public boolean isNeedFailResultPage() {
        return this.isNeedFailResultPage;
    }

    public boolean isNeedSound() {
        return this.isNeedSound;
    }

    public boolean isShouldAlertOnExit() {
        return this.isShouldAlertOnExit;
    }

    public boolean isSkinInAssets() {
        return this.mIsSkinInAssets;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    ALBiometricsConfig(Builder builder) {
        this.isNeedFailResultPage = true;
        this.transitionMode = builder.transitionMode;
        this.isNeedSound = builder.isNeedSound;
        this.isShouldAlertOnExit = builder.isShouldAlertOnExit;
        this.skinPath = builder.skinPath;
        this.mIsSkinInAssets = builder.mIsSkinInAssets;
        this.isNeedFailResultPage = builder.isNeedFailResultPage;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class Builder {
        boolean isNeedFailResultPage;
        boolean isNeedSound;
        boolean isNeedWaitingForFinish;
        boolean isShouldAlertOnExit;
        boolean mIsSkinInAssets;
        String skinPath;
        TransitionMode transitionMode;

        public Builder() {
            this.transitionMode = ALBiometricsConfig.DEFAULT_TRANSITION_MODE;
            this.isNeedSound = true;
            this.isShouldAlertOnExit = true;
        }

        public final ALBiometricsConfig build() {
            return new ALBiometricsConfig(this);
        }

        public final Builder setIsSkinInAssets(boolean z) {
            this.mIsSkinInAssets = z;
            return this;
        }

        public final Builder setNeedFailResultPage(boolean z) {
            this.isNeedFailResultPage = z;
            return this;
        }

        @Deprecated
        public final Builder setNeedLoading(boolean z) {
            this.isNeedWaitingForFinish = z;
            return this;
        }

        public final Builder setNeedSound(boolean z) {
            this.isNeedSound = z;
            return this;
        }

        public final Builder setNeedWaitingForFinish(boolean z) {
            this.isNeedWaitingForFinish = z;
            return this;
        }

        public final Builder setShouldAlertOnExit(boolean z) {
            this.isShouldAlertOnExit = z;
            return this;
        }

        public final Builder setSkinPath(String str) {
            this.skinPath = str;
            return this;
        }

        public final Builder setTransitionMode(TransitionMode transitionMode) {
            this.transitionMode = transitionMode;
            return this;
        }

        Builder(ALBiometricsConfig aLBiometricsConfig) {
            this.transitionMode = aLBiometricsConfig.transitionMode;
            this.isNeedSound = aLBiometricsConfig.isNeedSound;
            this.isShouldAlertOnExit = aLBiometricsConfig.isShouldAlertOnExit;
        }
    }
}
