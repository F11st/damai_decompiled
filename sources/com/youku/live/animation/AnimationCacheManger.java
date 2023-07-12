package com.youku.live.animation;

import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGAVideoEntity;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnimationCacheManger {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile AnimationCacheManger sInstance;
    private final int CACHE_SIZE = 52428800;
    private LruCache<String, SVGAVideoEntity> mLruCache = new LruCache<String, SVGAVideoEntity>(52428800) { // from class: com.youku.live.animation.AnimationCacheManger.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, SVGAVideoEntity sVGAVideoEntity) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1473588602") ? ((Integer) ipChange.ipc$dispatch("1473588602", new Object[]{this, str, sVGAVideoEntity})).intValue() : super.sizeOf((AnonymousClass1) str, (String) sVGAVideoEntity);
        }
    };

    private AnimationCacheManger() {
    }

    public static AnimationCacheManger getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102429233")) {
            return (AnimationCacheManger) ipChange.ipc$dispatch("-1102429233", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (AnimationCacheManger.class) {
                if (sInstance == null) {
                    sInstance = new AnimationCacheManger();
                }
            }
        }
        return sInstance;
    }

    public void addCache(String str, SVGAVideoEntity sVGAVideoEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48721437")) {
            ipChange.ipc$dispatch("48721437", new Object[]{this, str, sVGAVideoEntity});
        } else {
            this.mLruCache.put(str, sVGAVideoEntity);
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450648462")) {
            ipChange.ipc$dispatch("1450648462", new Object[]{this});
        } else {
            this.mLruCache.evictAll();
        }
    }

    public SVGAVideoEntity getDrawableFromCache(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1169497862") ? (SVGAVideoEntity) ipChange.ipc$dispatch("-1169497862", new Object[]{this, str}) : this.mLruCache.get(str);
    }

    public void removeDrawable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752492873")) {
            ipChange.ipc$dispatch("-1752492873", new Object[]{this, str});
        } else {
            this.mLruCache.remove(str);
        }
    }
}
