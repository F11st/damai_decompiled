package com.alibaba.android.ultron.vfw.web;

import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.base.ResultCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IWebEventBridge {
    void onEvent(Map<String, Object> map, ResultCallback resultCallback, IDMComponent iDMComponent);
}
