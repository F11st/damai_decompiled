package com.taobao.opentracing.api.propagation;

import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface TextMapExtract extends Iterable<Map.Entry<String, String>> {
    @Override // java.lang.Iterable
    Iterator<Map.Entry<String, String>> iterator();
}
