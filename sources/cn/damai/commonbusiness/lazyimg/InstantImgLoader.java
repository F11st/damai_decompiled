package cn.damai.commonbusiness.lazyimg;

import android.view.View;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d21;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class InstantImgLoader extends ImgLoader implements TaskListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<View, d21> a = new HashMap<>();

    @Override // cn.damai.commonbusiness.lazyimg.ImgLoader
    public void a(d21 d21Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346486155")) {
            ipChange.ipc$dispatch("-346486155", new Object[]{this, d21Var});
        } else if (d21Var == null || !d21Var.c()) {
        } else {
            GifCareImageView b = d21Var.b();
            d21 remove = this.a.remove(b);
            if (remove != null) {
                remove.a();
            }
            this.a.put(b, d21Var);
            d21Var.f();
            d21Var.e(this);
        }
    }

    @Override // cn.damai.commonbusiness.lazyimg.TaskListener
    public void onTaskLoadFinish(d21 d21Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301676980")) {
            ipChange.ipc$dispatch("-1301676980", new Object[]{this, d21Var});
        } else if (d21Var != null) {
            this.a.remove(d21Var.b());
        }
    }
}
