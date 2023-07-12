package tb;

import com.opensource.svgaplayer.proto.ShapeEntity;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final /* synthetic */ class b52 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        int[] iArr = new int[ShapeEntity.ShapeType.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        iArr[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        iArr[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        iArr[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        int[] iArr2 = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        int[] iArr3 = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
