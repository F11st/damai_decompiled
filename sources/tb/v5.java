package tb;

import android.content.res.Resources;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.phenix.animate.AnimatedImageDrawable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class v5 extends ef {
    final AnimatedImage i;

    public v5(AnimatedImage animatedImage, String str, String str2, int i, int i2) {
        super(str, str2, i, i2);
        this.i = animatedImage;
    }

    @Override // tb.ef
    public int c() {
        AnimatedImage animatedImage = this.i;
        if (animatedImage == null) {
            return 0;
        }
        return animatedImage.getSizeInBytes();
    }

    @Override // tb.ef
    protected tq1 d(String str, String str2, int i, int i2, boolean z, Resources resources) {
        return new AnimatedImageDrawable(str, str2, i, i2, this.i);
    }
}
