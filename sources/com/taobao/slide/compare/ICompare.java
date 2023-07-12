package com.taobao.slide.compare;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ICompare {
    boolean equals(String str, String str2);

    boolean equalsNot(String str, String str2);

    boolean fuzzy(String str, String str2);

    boolean fuzzyNot(String str, String str2);

    boolean greater(String str, String str2);

    boolean greaterEquals(String str, String str2);

    boolean in(String str, String str2);

    boolean less(String str, String str2);

    boolean lessEquals(String str, String str2);

    boolean notIn(String str, String str2);
}
