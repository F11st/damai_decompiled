package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageOption;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.C0819b;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class p11 extends oa<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static p11 d;

    private p11() {
    }

    public static synchronized p11 t() {
        synchronized (p11.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-292828701")) {
                return (p11) ipChange.ipc$dispatch("-292828701", new Object[0]);
            }
            if (d == null) {
                d = new p11();
            }
            return d;
        }
    }

    @Override // tb.oa
    public AbstractC0818a<ImageData, l11> e(@NonNull kn1<l11> kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237377677")) {
            return (AbstractC0818a) ipChange.ipc$dispatch("-1237377677", new Object[]{this, kn1Var});
        }
        if (kn1Var.a().c()) {
            return new SVGRequest(kn1Var);
        }
        return new C0819b(kn1Var);
    }

    public void r(@Nullable RequestListener<ImageData, l11> requestListener, ImageOption... imageOptionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124224952")) {
            ipChange.ipc$dispatch("-2124224952", new Object[]{this, requestListener, imageOptionArr});
        } else if (imageOptionArr != null) {
            for (ImageOption imageOption : imageOptionArr) {
                h(imageOption, requestListener);
            }
        }
    }

    public void s(Option<ImageExtra>[] optionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090219824")) {
            ipChange.ipc$dispatch("-2090219824", new Object[]{this, optionArr});
        } else if (optionArr != null && optionArr.length > 0) {
            for (Option<ImageExtra> option : optionArr) {
                q(option);
            }
        }
    }
}
