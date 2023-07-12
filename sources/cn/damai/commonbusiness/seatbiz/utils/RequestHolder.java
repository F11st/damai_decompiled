package cn.damai.commonbusiness.seatbiz.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RequestHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<WeakReference<Cancelable>> a = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class MtopCancelable implements Cancelable, Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final MtopBusiness mBusiness;

        public MtopCancelable(MtopBusiness mtopBusiness) {
            this.mBusiness = mtopBusiness;
        }

        @Override // cn.damai.commonbusiness.seatbiz.utils.Cancelable
        public void cancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-58124152")) {
                ipChange.ipc$dispatch("-58124152", new Object[]{this});
            } else if (this.mBusiness.isTaskCanceled()) {
            } else {
                this.mBusiness.cancelRequest();
            }
        }
    }

    public void a(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629343863")) {
            ipChange.ipc$dispatch("1629343863", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness != null) {
            this.a.add(new WeakReference<>(new MtopCancelable(mtopBusiness)));
        }
    }

    public void b(Cancelable cancelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715714008")) {
            ipChange.ipc$dispatch("1715714008", new Object[]{this, cancelable});
        } else if (cancelable != null) {
            this.a.add(new WeakReference<>(cancelable));
        }
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44633427")) {
            ipChange.ipc$dispatch("-44633427", new Object[]{this});
        } else if (this.a.size() > 0) {
            for (WeakReference<Cancelable> weakReference : this.a) {
                try {
                    Cancelable cancelable = weakReference.get();
                    if (cancelable != null) {
                        cancelable.cancel();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.a.clear();
        }
    }
}
