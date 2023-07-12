package com.youku.live.livesdk.model.mtop.data;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PlayerbackViewModel implements Serializable {
    public Rect frameEnd;
    public int height;
    public boolean inBattle;
    public boolean isStreamLandscape;
    public int left;
    public int top;
    public Rect weexFrameEnd;
    public int width;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Rect implements Serializable {
        public int height;
        public int left;
        public int top;
        public int width;

        public Rect() {
        }

        public Rect(int i, int i2, int i3, int i4) {
            this.top = i2;
            this.left = i;
            this.width = i3;
            this.height = i4;
        }

        public Rect(int i, int i2, int i3, int i4, int i5, int i6) {
            this.top = (i2 * i5) / i6;
            this.left = (i * i5) / i6;
            this.width = (i3 * i5) / i6;
            this.height = (i4 * i5) / i6;
        }
    }

    public PlayerbackViewModel() {
    }

    public PlayerbackViewModel(Rect rect, Rect rect2, boolean z, boolean z2) {
        this.frameEnd = rect;
        this.weexFrameEnd = rect2;
        this.isStreamLandscape = z;
        this.inBattle = z2;
        this.top = rect2.top;
        this.left = rect2.left;
        this.width = rect2.width;
        this.height = rect2.height;
    }
}
