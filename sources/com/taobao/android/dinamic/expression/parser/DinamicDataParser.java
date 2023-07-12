package com.taobao.android.dinamic.expression.parser;

import java.util.List;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface DinamicDataParser {
    Object evalWithArgs(List list, v80 v80Var);

    Object parser(String str, Object obj);

    Object parser(String str, String str2, Object obj, Object obj2);

    Object parser(String str, v80 v80Var);
}
