package com.amap.api.maps.model;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);
        
        private int type;

        LineCapType(int i) {
            this.type = i;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i, values.length))];
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);
        
        private int type;

        LineJoinType(int i) {
            this.type = i;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i, values.length))];
        }
    }
}
