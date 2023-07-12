package tb;

import android.graphics.Bitmap;
import android.os.Build;
import com.alibaba.pictures.bricks.util.blur.LruCachePolicy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oc extends LruCachePolicy<String, Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    /* renamed from: b */
    public int computeValueSize(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563048148")) {
            return ((Integer) ipChange.ipc$dispatch("1563048148", new Object[]{this, bitmap})).intValue();
        }
        if (bitmap != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return bitmap.getByteCount();
        }
        return 0;
    }

    @Override // com.alibaba.pictures.bricks.util.blur.LruCachePolicy
    /* renamed from: c */
    public void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421923196")) {
            ipChange.ipc$dispatch("-421923196", new Object[]{this, Boolean.valueOf(z), str, bitmap, bitmap2});
        }
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public int maxCacheSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094807588")) {
            return ((Integer) ipChange.ipc$dispatch("-2094807588", new Object[]{this})).intValue();
        }
        return 15728640;
    }
}
