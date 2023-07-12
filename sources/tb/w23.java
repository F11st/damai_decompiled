package tb;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class w23 extends Handler {
    public com.efs.sdk.base.a.d.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w23() {
        super(r33.a.getLooper());
        sendEmptyMessageDelayed(0, DateUtils.MILLIS_PER_MINUTE);
    }

    abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, DateUtils.MILLIS_PER_MINUTE);
    }
}
