package cn.damai.seat.helper;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.bean.biz.PreCheckResult;
import cn.damai.seat.listener.net.MtopPreCheckListener;
import cn.damai.seat.request.MtopPreCheckRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatPreLocker {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a;
    private long b;
    private String c;
    private List<Long> d;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnPreLockResultListener {
        void onOpenNextPage(boolean z, String str, String str2);

        void onPreLockFailed();
    }

    public SeatPreLocker(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902989305")) {
            ipChange.ipc$dispatch("902989305", new Object[]{this});
        } else {
            this.d = null;
        }
    }

    public List<Long> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181389167") ? (List) ipChange.ipc$dispatch("-181389167", new Object[]{this}) : this.d;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1415562236") ? (String) ipChange.ipc$dispatch("1415562236", new Object[]{this}) : this.c;
    }

    public MtopBusiness f(List<SeatNew> list, final OnPreLockResultListener onPreLockResultListener) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "60070705") ? (MtopBusiness) ipChange.ipc$dispatch("60070705", new Object[]{this, list, onPreLockResultListener}) : new MtopPreCheckRequest(this.a, this.b, f92.e(list), this.c).request(new MtopPreCheckListener() { // from class: cn.damai.seat.helper.SeatPreLocker.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1978501724")) {
                    ipChange2.ipc$dispatch("1978501724", new Object[]{this, str, str2});
                } else {
                    onPreLockResultListener.onOpenNextPage(false, str, str2);
                }
            }

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetSuccess(@NonNull PreCheckResult preCheckResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-649994542")) {
                    ipChange2.ipc$dispatch("-649994542", new Object[]{this, preCheckResult});
                    return;
                }
                SeatPreLocker.this.c = preCheckResult.serialNumber;
                SeatPreLocker.this.d = preCheckResult.greySeats;
                if (preCheckResult.isCanOpenNextPage()) {
                    onPreLockResultListener.onOpenNextPage(true, null, null);
                } else {
                    onPreLockResultListener.onPreLockFailed();
                }
            }
        });
    }
}
