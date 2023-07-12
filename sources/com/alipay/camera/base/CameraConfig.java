package com.alipay.camera.base;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class CameraConfig {
    private static boolean e;
    private String a;
    private int b;
    private int c;
    private boolean d;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class Builder {
        private CameraConfig a;

        public Builder(String str) {
            CameraConfig cameraConfig = new CameraConfig();
            this.a = cameraConfig;
            cameraConfig.a = str;
        }

        public CameraConfig build() {
            return this.a;
        }

        public Builder setCameraId(int i) {
            this.a.b = i;
            return this;
        }

        public Builder setManuPermissionCheck(boolean z) {
            this.a.d = z;
            return this;
        }

        public Builder setRetryNum(int i) {
            this.a.c = i;
            return this;
        }
    }

    public static void setForceUseLegacy(boolean z) {
        e = z;
    }

    public int getCameraId() {
        return this.b;
    }

    public String getFromTag() {
        return this.a;
    }

    public int getRetryNum() {
        return this.c;
    }

    public boolean isCheckManuPermission() {
        return this.d;
    }

    public boolean isOpenLegacy() {
        return e;
    }

    public String toString() {
        return "CameraConfig{mFromTag='" + this.a + "', mCameraId=" + this.b + ", retryNum=" + this.c + ", checkManuPermission=" + this.d + '}';
    }

    private CameraConfig() {
        this.c = 0;
        this.a = Thread.currentThread().getName();
        this.b = 0;
    }
}
