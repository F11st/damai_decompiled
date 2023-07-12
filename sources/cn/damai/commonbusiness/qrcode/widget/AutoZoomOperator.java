package cn.damai.commonbusiness.qrcode.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cn.damai.commonbusiness.qrcode.QRCodeActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AutoZoomOperator {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Handler c = new Handler(Looper.getMainLooper());
    private volatile boolean a;
    private QRCodeActivity b;

    public AutoZoomOperator(QRCodeActivity qRCodeActivity) {
        this.b = qRCodeActivity;
    }

    private void d(final int i, final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976228941")) {
            ipChange.ipc$dispatch("-976228941", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            c.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.AutoZoomOperator.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "746544324")) {
                        ipChange2.ipc$dispatch("746544324", new Object[]{this});
                        return;
                    }
                    int i3 = i;
                    if (i3 >= 10) {
                        AutoZoomOperator.this.a = false;
                        return;
                    }
                    AutoZoomOperator autoZoomOperator = AutoZoomOperator.this;
                    int i4 = i2;
                    autoZoomOperator.e(((int) ((i4 * 1.0f) / 10.0f)) * (i3 + 1), i3, i4);
                }
            }, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980973988")) {
            ipChange.ipc$dispatch("-1980973988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        QRCodeActivity qRCodeActivity = this.b;
        if (qRCodeActivity == null) {
            return;
        }
        qRCodeActivity.setZoom(i);
        d(i2 + 1, i3);
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820711200")) {
            ipChange.ipc$dispatch("1820711200", new Object[]{this});
        } else {
            this.b = null;
        }
    }

    public void f(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990105285")) {
            ipChange.ipc$dispatch("-990105285", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        Log.d("AutoZoomOperator", "startAutoZoom : rate is " + f + ", curIndex is " + i);
        if (f >= 0.0f && !this.a && i < 10) {
            this.a = true;
            d(0, (int) f);
            return;
        }
        this.a = false;
    }
}
