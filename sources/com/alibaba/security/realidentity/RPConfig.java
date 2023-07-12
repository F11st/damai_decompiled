package com.alibaba.security.realidentity;

import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.realidentity.a.C3847g;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPConfig implements Serializable {
    final ALBiometricsConfig biometricsConfig;
    String fromSource;

    private RPConfig() {
        this(new Builder());
    }

    public ALBiometricsConfig getBiometricsConfig() {
        return this.biometricsConfig;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public void setFromSource(String str) {
        this.fromSource = str;
    }

    RPConfig(Builder builder) {
        ALBiometricsConfig.Builder builder2 = new ALBiometricsConfig.Builder();
        builder2.setTransitionMode(builder.a);
        builder2.setNeedSound(builder.b);
        builder2.setShouldAlertOnExit(builder.d);
        builder2.setSkinPath(builder.e);
        builder2.setNeedFailResultPage(builder.c);
        builder2.setIsSkinInAssets(builder.f);
        this.fromSource = builder.h;
        this.biometricsConfig = builder2.build();
        C3847g.C3848a.a.o = builder.g;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class Builder {
        TransitionMode a;
        boolean b;
        @Deprecated
        boolean c;
        boolean d;
        String e;
        boolean f;
        boolean g;
        String h;

        public Builder() {
            this.g = true;
            this.h = "native";
            this.a = ALBiometricsConfig.DEFAULT_TRANSITION_MODE;
            this.b = true;
            this.d = true;
            this.f = true;
        }

        public final RPConfig build() {
            return new RPConfig(this);
        }

        public final Builder setFromSource(String str) {
            this.h = str;
            return this;
        }

        @Deprecated
        public final Builder setNeedFailResultPage(boolean z) {
            this.c = z;
            return this;
        }

        public final Builder setNeedSound(boolean z) {
            this.b = z;
            return this;
        }

        @Deprecated
        public final Builder setNeedWaitingForFinish(boolean z) {
            return this;
        }

        public final Builder setShouldAlertOnExit(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder setSkinInAssets(boolean z) {
            this.f = z;
            return this;
        }

        public final Builder setSkinPath(String str) {
            this.e = str;
            return this;
        }

        public final Builder setTransitionMode(TransitionMode transitionMode) {
            this.a = transitionMode;
            return this;
        }

        public final Builder setUseWindVane(boolean z) {
            this.g = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(RPConfig rPConfig) {
            this.g = true;
            this.h = "native";
            ALBiometricsConfig biometricsConfig = rPConfig.getBiometricsConfig();
            this.a = biometricsConfig.getTransitionMode();
            this.b = biometricsConfig.isNeedSound();
            this.c = biometricsConfig.isNeedFailResultPage();
            this.d = biometricsConfig.isShouldAlertOnExit();
            this.e = biometricsConfig.getSkinPath();
        }
    }
}
