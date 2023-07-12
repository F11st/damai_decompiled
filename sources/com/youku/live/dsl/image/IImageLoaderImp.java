package com.youku.live.dsl.image;

import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IImageLoaderImp implements IImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mBlur;
    private String mImageUrl;

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader blur(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266630534")) {
            return (IImageLoader) ipChange.ipc$dispatch("-266630534", new Object[]{this, Integer.valueOf(i)});
        }
        this.mBlur = i;
        return this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader circle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1855733486") ? (IImageLoader) ipChange.ipc$dispatch("1855733486", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader into(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-596606632")) {
            return (IImageLoader) ipChange.ipc$dispatch("-596606632", new Object[]{this, imageView});
        }
        ur1.o().s(this.mImageUrl).y(imageView);
        return this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader loadUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685589861")) {
            return (IImageLoader) ipChange.ipc$dispatch("-685589861", new Object[]{this, str});
        }
        this.mImageUrl = str;
        return this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader round(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "219744709") ? (IImageLoader) ipChange.ipc$dispatch("219744709", new Object[]{this, Integer.valueOf(i)}) : this;
    }
}
