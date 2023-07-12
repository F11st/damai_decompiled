package com.youku.live.widgets.protocol;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IProps extends IMap {
    <RetType> RetType getValue(String str, Class<RetType> cls, RetType rettype);

    Map<String, Object> toMap();

    Map<String, Object> toMap(Map<String, Object> map);
}
