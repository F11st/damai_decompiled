package com.alipay.euler.andfix;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum AndFixVM {
    NotSupport(0, "NotSupport"),
    Dalvik(1, "Dalvik"),
    ART(2, "ART"),
    Lemur(3, "Lemur"),
    AOC(4, "AOC");
    
    String name;
    int value;

    AndFixVM(int i, String str) {
        this.value = i;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "AndFixVM{value=" + this.value + ", name='" + this.name + "'}";
    }
}
