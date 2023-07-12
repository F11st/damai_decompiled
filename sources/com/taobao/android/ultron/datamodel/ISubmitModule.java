package com.taobao.android.ultron.datamodel;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ISubmitModule {
    JSONObject asyncRequestData(a aVar, IDMComponent iDMComponent);

    JSONObject submitRequestData(a aVar);
}
