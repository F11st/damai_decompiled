package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;
import com.taobao.weex.common.Constants;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Size {
    private final int height;
    private final int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf(Constants.Name.X);
            if (indexOf < 0) {
                indexOf = str.indexOf(jn1.MUL);
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.width == size.width && this.height == size.height;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        int i = this.width;
        int i2 = this.height;
        return "Width is " + i + " Height is " + i2;
    }
}
