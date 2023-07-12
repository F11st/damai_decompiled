package cn.damai.launcher.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dc0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DoloresGlobalInterceptor implements IRequestInterceptor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> void onAfterProcessData(@NonNull DoloresKernel<T> doloresKernel, @Nullable dc0<T> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1224240789")) {
            ipChange.ipc$dispatch("1224240789", new Object[]{this, doloresKernel, dc0Var});
        }
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> boolean onPreProcessData(@NonNull DoloresKernel<T> doloresKernel, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797545320")) {
            return ((Boolean) ipChange.ipc$dispatch("-797545320", new Object[]{this, doloresKernel, obj})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> boolean onPreRequest(@NonNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618296496")) {
            return ((Boolean) ipChange.ipc$dispatch("-1618296496", new Object[]{this, doloresKernel, doloresRequest})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> void onRequestConfig(@NonNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736087671")) {
            ipChange.ipc$dispatch("736087671", new Object[]{this, doloresKernel, doloresRequest});
        }
    }
}
