package com.taobao.monitor.impl.trace;

import android.os.Bundle;
import android.os.Message;
import android.view.FrameMetrics;
import com.taobao.monitor.impl.common.ThreadSwitcher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FPSDispatcher extends AbsDispatcher<FPSListener> implements ThreadSwitcher.ThreadConversion {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface FPSListener {
        void frameDataPerSecond(int i, int i2, int i3, int i4, List<FrameMetrics> list);
    }

    public void f(int i, int i2, int i3, int i4, ArrayList<FrameMetrics> arrayList) {
        Message obtain = Message.obtain();
        obtain.what = 120;
        Bundle b = ThreadSwitcher.a().b();
        b.putInt("fps", i);
        b.putInt("jankCount", i2);
        b.putInt("frozenFrameCount", i3);
        b.putInt("slowFrameCount", i4);
        if (arrayList != null) {
            b.putSerializable("frozenFrameMetricsList", arrayList);
        }
        obtain.setData(b);
        ThreadSwitcher.a().d(obtain);
    }

    @Override // com.taobao.monitor.impl.common.ThreadSwitcher.ThreadConversion
    public void onThreadChanged(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            return;
        }
        for (LISTENER listener : this.b) {
            Serializable serializable = data.getSerializable("frozenFrameMetricsList");
            listener.frameDataPerSecond(data.getInt("fps"), data.getInt("jankCount"), data.getInt("frozenFrameCount"), data.getInt("slowFrameCount"), serializable instanceof ArrayList ? (ArrayList) serializable : null);
        }
        ThreadSwitcher.a().c(data);
    }

    @Override // com.taobao.monitor.impl.common.ThreadSwitcher.ThreadConversion
    public int what() {
        return 120;
    }
}
