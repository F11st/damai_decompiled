package com.alibaba.wireless.security.aopsdk;

/* loaded from: classes.dex */
public class AopInitConfig {
    private boolean a = true;
    private boolean b = false;
    private boolean c = true;

    /* loaded from: classes.dex */
    public static class Builder {
        public AopInitConfig a;

        public Builder() {
            AopInitConfig aopInitConfig = new AopInitConfig();
            this.a = aopInitConfig;
            aopInitConfig.a = true;
            this.a.b = false;
            this.a.c = true;
        }

        public AopInitConfig build() {
            return this.a;
        }

        public void registerLifeCycleListener(boolean z) {
            this.a.c = z;
        }

        public void setDebug(boolean z) {
            this.a.b = z;
        }

        public void setFetchConfig(boolean z) {
            this.a.a = z;
        }
    }

    public boolean isDebug() {
        return this.b;
    }

    public boolean shouldFetchConfig() {
        return this.a;
    }

    public boolean shouldRegisterLifeCycleListener() {
        return this.c;
    }
}
