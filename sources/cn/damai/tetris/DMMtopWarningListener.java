package cn.damai.tetris;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.b23;
import tb.cb2;
import tb.t03;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class DMMtopWarningListener<T> extends DMMtopRequestListener {
    private static transient /* synthetic */ IpChange $ipChange;
    String args;

    public DMMtopWarningListener(Class cls, String str) {
        super(cls);
        this.args = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972653256")) {
            ipChange.ipc$dispatch("-1972653256", new Object[]{this, str, str2});
            return;
        }
        onFailWithWarning(str, str2);
        if ("FAIL_BIZ_PATTERN_EMPTY".equals(str)) {
            t03.d(t03.TETRIS_CORE_ERROR_NOPATTREN_CODE, t03.TETRIS_CORE_ERROR_NOPATTREN_MSG, str, str2, this.args);
        } else {
            b23.c(b23.a, t03.BUSINESS_NAME_MONITORPOINT, b23.i("Tetris", "mtop.damai.mec.aristotle.get", str, str2, this.args), str, str2);
        }
    }

    public abstract void onFailWithWarning(String str, String str2);

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636651135")) {
            ipChange.ipc$dispatch("-636651135", new Object[]{this, obj});
            return;
        }
        if (obj != 0 && (obj instanceof BaseResponse)) {
            ((BaseResponse) obj).args = this.args;
        }
        onSuccessWithWarning(obj);
        b23.e(b23.a, t03.BUSINESS_NAME_MONITORPOINT, b23.i("Tetris", "mtop.damai.mec.aristotle.get", "", "", this.args));
        if (obj == 0 || ((obj instanceof BaseResponse) && cb2.d(((BaseResponse) obj).layers))) {
            t03.d(t03.TETRIS_CORE_ERROR_NODATA_CODE, t03.TETRIS_CORE_ERROR_NODATA_MSG, "NODATA_NOLAYERS", "接口返回数据为空或楼层为空", this.args);
        }
    }

    public abstract void onSuccessWithWarning(T t);
}
