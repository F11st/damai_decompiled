package com.taobao.weex.devtools.inspector.helper;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewDebug;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IntegerFormatter {
    private static volatile IntegerFormatter cachedFormatter;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @Override // com.taobao.weex.devtools.inspector.helper.IntegerFormatter
        @TargetApi(21)
        public String format(Integer num, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            if (exportedProperty != null && exportedProperty.formatToHexString()) {
                return "0x" + Integer.toHexString(num.intValue());
            }
            return super.format(num, exportedProperty);
        }
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                if (cachedFormatter == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cachedFormatter = new IntegerFormatterWithHex();
                    } else {
                        cachedFormatter = new IntegerFormatter();
                    }
                }
            }
        }
        return cachedFormatter;
    }

    public String format(Integer num, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }

    private IntegerFormatter() {
    }
}
