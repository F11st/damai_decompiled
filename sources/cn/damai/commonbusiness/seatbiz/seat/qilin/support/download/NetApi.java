package cn.damai.commonbusiness.seatbiz.seat.qilin.support.download;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Response;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import tb.c22;
import tb.dr1;
import tb.k01;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetApi {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class NetCallback<T> implements NetworkCallBack$FinishListener, NetworkCallBack$ResponseCodeListener, NetworkCallBack$ProgressListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<dr1> a = new ArrayList();
        private final Handler b = new Handler(Looper.getMainLooper());
        private final OnDownLoadListener<T> c;

        NetCallback(OnDownLoadListener<T> onDownLoadListener) {
            this.c = onDownLoadListener;
        }

        private void b(final int i, final String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "897093380")) {
                ipChange.ipc$dispatch("897093380", new Object[]{this, Integer.valueOf(i), str});
            } else {
                this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "655502864")) {
                            ipChange2.ipc$dispatch("655502864", new Object[]{this});
                        } else {
                            NetCallback.this.c.onFail(i, str);
                        }
                    }
                });
            }
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1059703992")) {
                ipChange.ipc$dispatch("-1059703992", new Object[]{this});
            } else {
                this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "458989359")) {
                            ipChange2.ipc$dispatch("458989359", new Object[]{this});
                        } else {
                            NetCallback.this.c.onLimit();
                        }
                    }
                });
            }
        }

        private void d(final T t) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "347154012")) {
                ipChange.ipc$dispatch("347154012", new Object[]{this, t});
            } else {
                this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "852016369")) {
                            ipChange2.ipc$dispatch("852016369", new Object[]{this});
                        } else {
                            NetCallback.this.c.onSuccess(t);
                        }
                    }
                });
            }
        }

        private void e(int i) {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1441337911")) {
                ipChange.ipc$dispatch("-1441337911", new Object[]{this, Integer.valueOf(i)});
            } else if (this.a.size() == 0) {
                b(i, "数据返回为空");
            } else {
                try {
                    try {
                        Collections.sort(this.a);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            for (dr1 dr1Var : this.a) {
                                byteArrayOutputStream.write(dr1Var.b);
                            }
                            d(this.c.callSubThread(byteArrayOutputStream.toByteArray()));
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                b(i, th.getMessage());
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable th3) {
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        byteArrayOutputStream = null;
                        th = th4;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // anetwork.channel.NetworkCallBack$ProgressListener
        public void onDataReceived(NetworkEvent$ProgressEvent networkEvent$ProgressEvent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389257949")) {
                ipChange.ipc$dispatch("-1389257949", new Object[]{this, networkEvent$ProgressEvent, obj});
                return;
            }
            int size = networkEvent$ProgressEvent.getSize();
            if (size <= 0) {
                return;
            }
            this.a.add(new dr1(networkEvent$ProgressEvent.getIndex(), Arrays.copyOf(networkEvent$ProgressEvent.getBytedata(), size)));
        }

        @Override // anetwork.channel.NetworkCallBack$FinishListener
        public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1020136272")) {
                ipChange.ipc$dispatch("1020136272", new Object[]{this, networkEvent$FinishEvent, obj});
                return;
            }
            int httpCode = networkEvent$FinishEvent.getHttpCode();
            if (httpCode == 200) {
                e(httpCode);
            } else if (httpCode != 202 && httpCode != 540) {
                b(httpCode, networkEvent$FinishEvent.getDesc());
            } else {
                c();
            }
        }

        @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
        public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870646070")) {
                return ((Boolean) ipChange.ipc$dispatch("1870646070", new Object[]{this, Integer.valueOf(i), map, obj})).booleanValue();
            }
            return false;
        }
    }

    public static <T> Future<Response> a(Context context, String str, @NonNull OnDownLoadListener<T> onDownLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999620880")) {
            return (Future) ipChange.ipc$dispatch("1999620880", new Object[]{context, str, onDownLoadListener});
        }
        k01 k01Var = new k01(context);
        c22 c22Var = new c22(str);
        c22Var.setConnectTimeout(10000);
        c22Var.setReadTimeout(15000);
        return k01Var.asyncSend(c22Var, null, null, new NetCallback(onDownLoadListener));
    }
}
