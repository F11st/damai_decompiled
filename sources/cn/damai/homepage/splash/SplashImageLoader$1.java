package cn.damai.homepage.splash;

import android.content.Context;
import cn.damai.common.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SplashImageLoader$1 extends PriorityTask {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$pic;
    final /* synthetic */ String val$schema;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashImageLoader$1(String str, Object obj, Context context, String str2, String str3) {
        super(str, obj);
        this.val$context = context;
        this.val$pic = str2;
        this.val$schema = str3;
    }

    @Override // cn.damai.common.util.PriorityTask
    public void doTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504322839")) {
            ipChange.ipc$dispatch("504322839", new Object[]{this});
        } else {
            a.c(this.val$context, this.val$pic, this.val$schema);
        }
    }
}
