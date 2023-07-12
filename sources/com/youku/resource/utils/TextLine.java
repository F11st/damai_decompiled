package com.youku.resource.utils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TextLine implements Cloneable {
    public char[] text = new char[32];
    public int size = 0;

    public boolean appendChar(String str, int i) {
        int i2;
        char charAt = str.charAt(i);
        int i3 = this.size;
        char[] cArr = this.text;
        if (i3 == cArr.length - 1) {
            char[] cArr2 = new char[cArr.length + 16];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.text = cArr2;
        }
        char[] cArr3 = this.text;
        int i4 = this.size;
        this.size = i4 + 1;
        cArr3[i4] = charAt;
        if (!Character.isHighSurrogate(charAt) || (i2 = i + 1) >= str.length()) {
            return false;
        }
        char[] cArr4 = this.text;
        int i5 = this.size;
        this.size = i5 + 1;
        cArr4[i5] = str.charAt(i2);
        return true;
    }

    public boolean appendChars(String str, int i, int i2) {
        int i3;
        int i4 = this.size;
        int i5 = i4 + i2 + 1;
        char[] cArr = this.text;
        if (i5 > cArr.length) {
            char[] cArr2 = new char[i4 + i2 + 16];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.text = cArr2;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            char[] cArr3 = this.text;
            int i7 = this.size;
            this.size = i7 + 1;
            cArr3[i7] = str.charAt(i + i6);
        }
        int i8 = this.size;
        if (i8 >= 1 && Character.isHighSurrogate(this.text[i8 - 1]) && (i3 = i + i2) < str.length()) {
            char[] cArr4 = this.text;
            int i9 = this.size;
            this.size = i9 + 1;
            cArr4[i9] = str.charAt(i3);
            return true;
        }
        return false;
    }

    public Object clone() {
        TextLine textLine = new TextLine();
        textLine.fillFromAnother(this);
        return textLine;
    }

    public void fillFromAnother(TextLine textLine) {
        int i;
        if (textLine != null && (i = textLine.size) != 0) {
            if (this.text.length < i) {
                this.text = new char[i + 16];
            }
            this.size = i;
            System.arraycopy(textLine.text, 0, this.text, 0, i);
            return;
        }
        this.size = 0;
    }

    public boolean removeEndingChar() {
        int i;
        int i2 = this.size;
        if (i2 == 0) {
            return false;
        }
        char[] cArr = this.text;
        int i3 = i2 - 1;
        this.size = i3;
        if (Character.isLowSurrogate(cArr[i3]) && (i = this.size) > 0) {
            this.size = i - 1;
        }
        return true;
    }
}
