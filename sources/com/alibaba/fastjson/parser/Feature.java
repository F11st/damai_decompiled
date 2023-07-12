package com.alibaba.fastjson.parser;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    SupportNonPublicField,
    SupportAutoType;
    
    public final int mask = 1 << ordinal();

    Feature() {
    }
}
