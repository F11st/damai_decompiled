package com.taobao.android.ultron.datamodel;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.C6661a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ISubmitModule {
    JSONObject asyncRequestData(C6661a c6661a, IDMComponent iDMComponent);

    JSONObject submitRequestData(C6661a c6661a);
}
