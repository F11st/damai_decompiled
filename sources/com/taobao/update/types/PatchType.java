package com.taobao.update.types;

import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum PatchType {
    SOPATCH(0, lu2.SOPATCH),
    INSTANTPATCH(1, lu2.HOTPATCH),
    DEXPATCH(2, lu2.DEXPATCH),
    MAIN(3, lu2.MAIN),
    DYNAMIC(4, lu2.DYNAMIC),
    TESTURL(5, lu2.TEST_URL),
    BUNDLES(6, "bundle");
    
    private String key;
    private int priority;

    PatchType(int i, String str) {
        this.priority = i;
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public int getPriority() {
        return this.priority;
    }
}
