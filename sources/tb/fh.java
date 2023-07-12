package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class fh implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public fh(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "523349247") ? (String) ipChange.ipc$dispatch("523349247", new Object[]{this}) : "com.alibaba.pictures.phenix.CenterInsideProcessor";
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245783064")) {
            return (Bitmap) ipChange.ipc$dispatch("-245783064", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        b41.i(str, "s");
        b41.i(bitmapSupplier, "bitmapSupplier");
        b41.i(bitmap, "toTransform");
        int i3 = this.a;
        if (i3 <= 0 || (i2 = this.b) > 0) {
            return (i3 <= 0 || (i = this.b) <= 0) ? bitmap : sg1.INSTANCE.d(bitmapSupplier, bitmap, i3, i);
        }
        Bitmap h = sg1.INSTANCE.h(bitmapSupplier, bitmap, i3, i2);
        return h != null ? h : bitmap;
    }
}
