package tb;

import android.graphics.Bitmap;
import android.os.Build;
import cn.damai.common.cache.memory.LruCachePolicy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class pc extends LruCachePolicy<String, Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.cache.common.CachePolicy
    /* renamed from: b */
    public int computeValueSize(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180392906")) {
            return ((Integer) ipChange.ipc$dispatch("-1180392906", new Object[]{this, bitmap})).intValue();
        }
        if (bitmap != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return bitmap.getByteCount();
        }
        return 0;
    }

    @Override // cn.damai.common.cache.memory.LruCachePolicy
    /* renamed from: c */
    public void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212667366")) {
            ipChange.ipc$dispatch("1212667366", new Object[]{this, Boolean.valueOf(z), str, bitmap, bitmap2});
        }
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int maxCacheSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009481530")) {
            return ((Integer) ipChange.ipc$dispatch("2009481530", new Object[]{this})).intValue();
        }
        return 15728640;
    }
}
