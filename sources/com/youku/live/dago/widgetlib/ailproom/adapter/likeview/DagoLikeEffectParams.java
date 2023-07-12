package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLikeEffectParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mBubbleUrl;
    private Bitmap mRes;
    private int[] mStartPos = {0, 0};
    private int[] mEndPos = {0, 0};

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class DagoLikeEffectParamsBuilder {
        private String mBubbleUrl;
        private Bitmap mRes;
        private int[] mStartPos = {0, 0};
        private int[] mEndPos = {0, 0};

        public DagoLikeEffectParams build() {
            DagoLikeEffectParams dagoLikeEffectParams = new DagoLikeEffectParams();
            dagoLikeEffectParams.mStartPos = this.mStartPos;
            dagoLikeEffectParams.mEndPos = this.mEndPos;
            dagoLikeEffectParams.mRes = this.mRes;
            dagoLikeEffectParams.mBubbleUrl = this.mBubbleUrl;
            return dagoLikeEffectParams;
        }

        public DagoLikeEffectParamsBuilder setBubbleUrl(String str) {
            this.mBubbleUrl = str;
            return this;
        }

        public DagoLikeEffectParamsBuilder setEndPos(int[] iArr) {
            this.mEndPos = iArr;
            return this;
        }

        public DagoLikeEffectParamsBuilder setResources(Bitmap bitmap) {
            this.mRes = bitmap;
            return this;
        }

        public DagoLikeEffectParamsBuilder setStartPos(int[] iArr) {
            this.mStartPos = iArr;
            return this;
        }
    }

    public String getBubbleUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1609406735") ? (String) ipChange.ipc$dispatch("-1609406735", new Object[]{this}) : this.mBubbleUrl;
    }

    public int[] getEndPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "848389253") ? (int[]) ipChange.ipc$dispatch("848389253", new Object[]{this}) : this.mEndPos;
    }

    public Bitmap getResources() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167765173") ? (Bitmap) ipChange.ipc$dispatch("-1167765173", new Object[]{this}) : this.mRes;
    }

    public int[] getStartPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-634976290") ? (int[]) ipChange.ipc$dispatch("-634976290", new Object[]{this}) : this.mStartPos;
    }
}
