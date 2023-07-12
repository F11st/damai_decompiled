package com.alibaba.poplayer.utils;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ConsoleLogger$Level {
    V('v', -1),
    I('i', -16711936),
    W('w', InputDeviceCompat.SOURCE_ANY),
    E('e', SupportMenu.CATEGORY_MASK),
    D('d', -16776961);
    
    public int color;
    public char sign;

    ConsoleLogger$Level(char c, int i) {
        this.sign = c;
        this.color = i;
    }

    public static ConsoleLogger$Level find(char c) {
        ConsoleLogger$Level[] values;
        for (ConsoleLogger$Level consoleLogger$Level : values()) {
            if (consoleLogger$Level.sign == c) {
                return consoleLogger$Level;
            }
        }
        return D;
    }
}
