package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.og1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class vr1 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private og1.a a;

    public vr1(int i, int i2, @Nullable og1.a aVar) {
        this.a = aVar;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2061797708") ? (String) ipChange.ipc$dispatch("-2061797708", new Object[]{this}) : "com.alibaba.pictures.phenix.PhenixBorderProcessor";
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794062765")) {
            return (Bitmap) ipChange.ipc$dispatch("-1794062765", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        b41.i(str, "s");
        b41.i(bitmapSupplier, "bitmapSupplier");
        b41.i(bitmap, "toTransform");
        og1.a aVar = this.a;
        if (aVar == null) {
            return bitmap;
        }
        sg1 sg1Var = sg1.INSTANCE;
        b41.f(aVar);
        Bitmap b = sg1Var.b(bitmapSupplier, bitmap, aVar);
        return b != null ? b : bitmap;
    }
}
