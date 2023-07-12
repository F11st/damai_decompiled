package tb;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class g81 extends Paint {
    public g81() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public g81(int i) {
        super(i);
    }

    public g81(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public g81(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
