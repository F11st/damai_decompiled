package com.youku.uplayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AssSubtitle {
    private static final String TAG = "AssSubtitle";
    public long duration;
    public int font2Size;
    public int fontSize;
    public boolean isHeader;
    public int numStyle;
    public AssStyle[] style;
    public String styleType;
    public String text;
    public int trackIndex;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class AssStyle {
        public String backColor;
        public String font;
        public boolean isBold;
        public boolean isItalic;
        public boolean isUnderline;
        public String name;
        public String outlineColor;
        public String primaryColor;

        public AssStyle() {
        }
    }
}
