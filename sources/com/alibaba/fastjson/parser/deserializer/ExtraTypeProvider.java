package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface ExtraTypeProvider extends ParseProcess {
    Type getExtraType(Object obj, String str);
}
