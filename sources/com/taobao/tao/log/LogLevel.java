package com.taobao.tao.log;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum LogLevel {
    ALL("ALL", 0),
    V("V", 0),
    D("D", 1),
    I("I", 2),
    W(ExifInterface.LONGITUDE_WEST, 3),
    E(ExifInterface.LONGITUDE_EAST, 4),
    F(UTConstant.Args.UT_SUCCESS_F, 5),
    N("N", 6),
    L("L", 6);
    
    private int index;
    private String name;

    LogLevel(String str, int i) {
        this.name = str;
        this.index = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    protected static String getName(int i) {
        LogLevel[] values;
        for (LogLevel logLevel : values()) {
            if (logLevel.getIndex() == i) {
                return logLevel.name;
            }
        }
        return null;
    }
}
