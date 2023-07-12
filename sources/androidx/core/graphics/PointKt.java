package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0086\n\u001a\r\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0005*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0004*\u00020\u0004H\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0000H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0000*\u00020\u0004H\u0086\b¨\u0006\r"}, d2 = {"Landroid/graphics/Point;", "", "component1", "component2", "Landroid/graphics/PointF;", "", "p", "plus", "xy", "minus", "unaryMinus", "toPointF", "toPoint", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@NotNull Point point) {
        b41.i(point, "<this>");
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
    }

    public static final int component2(@NotNull Point point) {
        b41.i(point, "<this>");
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    @NotNull
    public static final Point minus(@NotNull Point point, @NotNull Point point2) {
        b41.i(point, "<this>");
        b41.i(point2, "p");
        Point point3 = new Point(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        point3.offset(-com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), -com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        return point3;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, @NotNull Point point2) {
        b41.i(point, "<this>");
        b41.i(point2, "p");
        Point point3 = new Point(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        point3.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        return point3;
    }

    @NotNull
    public static final Point toPoint(@NotNull PointF pointF) {
        b41.i(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull Point point) {
        b41.i(point, "<this>");
        return new PointF(point);
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point point) {
        b41.i(point, "<this>");
        return new Point(-com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), -com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
    }

    public static final float component1(@NotNull PointF pointF) {
        b41.i(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(@NotNull PointF pointF) {
        b41.i(pointF, "<this>");
        return pointF.y;
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF pointF) {
        b41.i(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        b41.i(pointF, "<this>");
        b41.i(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        b41.i(pointF, "<this>");
        b41.i(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final Point minus(@NotNull Point point, int i) {
        b41.i(point, "<this>");
        Point point2 = new Point(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, int i) {
        b41.i(point, "<this>");
        Point point2 = new Point(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        point2.offset(i, i);
        return point2;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, float f) {
        b41.i(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, float f) {
        b41.i(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
