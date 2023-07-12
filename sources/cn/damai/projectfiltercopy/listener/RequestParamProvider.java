package cn.damai.projectfiltercopy.listener;

import androidx.annotation.NonNull;
import cn.damai.projectfiltercopy.bean.FilterReqParamBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface RequestParamProvider {
    @NonNull
    FilterReqParamBean obtainRequestParam();

    void setParamChangeListener(FilterParamChangeListener filterParamChangeListener);
}
