package com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnimationsContainer {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AnimationsContainer mInstance;
    public int FPS = 12;
    private Context mContext;
    private int[] resArray;
    private int resId;

    public AnimationsContainer(Context context) {
        this.mContext = context;
    }

    private int[] getData(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127908165")) {
            return (int[]) ipChange.ipc$dispatch("-1127908165", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.resArray == null) {
            TypedArray obtainTypedArray = this.mContext.getResources().obtainTypedArray(i);
            int length = obtainTypedArray.length();
            this.resArray = new int[obtainTypedArray.length()];
            for (int i2 = 0; i2 < length; i2++) {
                this.resArray[i2] = obtainTypedArray.getResourceId(i2, 0);
            }
            obtainTypedArray.recycle();
        }
        return this.resArray;
    }

    public static AnimationsContainer getInstance(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826308559")) {
            return (AnimationsContainer) ipChange.ipc$dispatch("-1826308559", new Object[]{context});
        }
        if (mInstance == null) {
            mInstance = new AnimationsContainer(context);
        }
        return mInstance;
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239624429")) {
            ipChange.ipc$dispatch("239624429", new Object[]{this});
        } else {
            mInstance = null;
        }
    }

    public FramesSequenceAnimation createProgressDialogAnim(ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1649906825") ? (FramesSequenceAnimation) ipChange.ipc$dispatch("-1649906825", new Object[]{this, imageView}) : new FramesSequenceAnimation(imageView, this.resArray, this.FPS);
    }

    public void setResId(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102210089")) {
            ipChange.ipc$dispatch("-1102210089", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.resId = i;
        this.FPS = i2;
        this.resArray = getData(i);
    }

    public FramesSequenceAnimation createProgressDialogAnim(ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2072764695") ? (FramesSequenceAnimation) ipChange.ipc$dispatch("2072764695", new Object[]{this, imageView, Integer.valueOf(i), Integer.valueOf(i2)}) : new FramesSequenceAnimation(imageView, getData(i), i2);
    }
}
