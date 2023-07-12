package com.youku.live.dsl.image;

import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IImageLoaderVirtualImp implements IImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader blur(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1248349367") ? (IImageLoader) ipChange.ipc$dispatch("-1248349367", new Object[]{this, Integer.valueOf(i)}) : this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader circle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1487220735") ? (IImageLoader) ipChange.ipc$dispatch("1487220735", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader into(ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1848348521") ? (IImageLoader) ipChange.ipc$dispatch("1848348521", new Object[]{this, imageView}) : this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader loadUrl(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "480863722") ? (IImageLoader) ipChange.ipc$dispatch("480863722", new Object[]{this, str}) : this;
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader round(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-148768042") ? (IImageLoader) ipChange.ipc$dispatch("-148768042", new Object[]{this, Integer.valueOf(i)}) : this;
    }
}
