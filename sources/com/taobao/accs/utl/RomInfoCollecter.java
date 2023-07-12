package com.taobao.accs.utl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class RomInfoCollecter {
    protected RomInfoCollecter mNextCollecter;

    public static RomInfoCollecter getCollecter() {
        return new HuaWeiRomCollecter();
    }

    public abstract String collect();
}
