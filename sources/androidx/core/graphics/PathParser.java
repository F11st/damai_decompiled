package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i >= 0 && i <= length) {
                int i3 = i2 - i;
                int min = Math.min(i3, length - i);
                float[] fArr2 = new float[i3];
                System.arraycopy(fArr, i, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String trim = str.substring(i2, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException("Error in parsing " + str, e);
            }
        }
        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L37
        L27:
            r10.mEndWithNegOrDot = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.mEndWithNegOrDot = r7
            goto L35
        L31:
            r2 = 0
            goto L37
        L33:
            r2 = 1
            goto L37
        L35:
            r2 = 0
            r4 = 1
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr != null && pathDataNodeArr2 != null && pathDataNodeArr3 != null) {
            if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
                if (canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                    for (int i = 0; i < pathDataNodeArr.length; i++) {
                        pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c3 = c2;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr2.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                        f15 = fArr2[i6];
                        float f19 = fArr2[i7];
                        float f20 = fArr2[i4];
                        float f21 = fArr2[i5];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path.lineTo(fArr2[i8], f16);
                        f15 = fArr2[i8];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f22 = fArr2[i9];
                        float f23 = fArr2[i10];
                        f15 = fArr2[i11];
                        f16 = fArr2[i12];
                        f11 = f22;
                        f12 = f23;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path.lineTo(f15, fArr2[i13]);
                        f16 = fArr2[i13];
                    } else if (c3 != 'a') {
                        if (c3 != 'c') {
                            if (c3 == 'h') {
                                int i14 = i3 + 0;
                                path.rLineTo(fArr2[i14], 0.0f);
                                f15 += fArr2[i14];
                            } else if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i15 = i3 + 0;
                                    path.rLineTo(0.0f, fArr2[i15]);
                                    f4 = fArr2[i15];
                                } else if (c3 == 'L') {
                                    int i16 = i3 + 0;
                                    int i17 = i3 + 1;
                                    path.lineTo(fArr2[i16], fArr2[i17]);
                                    f15 = fArr2[i16];
                                    f16 = fArr2[i17];
                                } else if (c3 == 'M') {
                                    int i18 = i3 + 0;
                                    f15 = fArr2[i18];
                                    int i19 = i3 + 1;
                                    f16 = fArr2[i19];
                                    if (i3 > 0) {
                                        path.lineTo(fArr2[i18], fArr2[i19]);
                                    } else {
                                        path.moveTo(fArr2[i18], fArr2[i19]);
                                        i2 = i3;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 'S') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i20 = i3 + 0;
                                    int i21 = i3 + 1;
                                    int i22 = i3 + 2;
                                    int i23 = i3 + 3;
                                    path.cubicTo(f15, f24, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                    f = fArr2[i20];
                                    f2 = fArr2[i21];
                                    f15 = fArr2[i22];
                                    f16 = fArr2[i23];
                                    f11 = f;
                                    f12 = f2;
                                } else if (c3 == 'T') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    int i24 = i3 + 0;
                                    int i25 = i3 + 1;
                                    path.quadTo(f15, f16, fArr2[i24], fArr2[i25]);
                                    float f25 = fArr2[i24];
                                    float f26 = fArr2[i25];
                                    i2 = i3;
                                    f12 = f16;
                                    f11 = f15;
                                    f15 = f25;
                                    f16 = f26;
                                } else if (c3 == 'l') {
                                    int i26 = i3 + 0;
                                    int i27 = i3 + 1;
                                    path.rLineTo(fArr2[i26], fArr2[i27]);
                                    f15 += fArr2[i26];
                                    f4 = fArr2[i27];
                                } else if (c3 == 'm') {
                                    int i28 = i3 + 0;
                                    f15 += fArr2[i28];
                                    int i29 = i3 + 1;
                                    f16 += fArr2[i29];
                                    if (i3 > 0) {
                                        path.rLineTo(fArr2[i28], fArr2[i29]);
                                    } else {
                                        path.rMoveTo(fArr2[i28], fArr2[i29]);
                                        i2 = i3;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        float f27 = f15 - f11;
                                        f5 = f16 - f12;
                                        f6 = f27;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i30 = i3 + 0;
                                    int i31 = i3 + 1;
                                    int i32 = i3 + 2;
                                    int i33 = i3 + 3;
                                    path.rCubicTo(f6, f5, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                    f = fArr2[i30] + f15;
                                    f2 = fArr2[i31] + f16;
                                    f15 += fArr2[i32];
                                    f3 = fArr2[i33];
                                } else if (c3 == 't') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f7 = f15 - f11;
                                        f8 = f16 - f12;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i34 = i3 + 0;
                                    int i35 = i3 + 1;
                                    path.rQuadTo(f7, f8, fArr2[i34], fArr2[i35]);
                                    float f28 = f7 + f15;
                                    float f29 = f8 + f16;
                                    f15 += fArr2[i34];
                                    f16 += fArr2[i35];
                                    f12 = f29;
                                    f11 = f28;
                                }
                                f16 += f4;
                            } else {
                                int i36 = i3 + 0;
                                int i37 = i3 + 1;
                                int i38 = i3 + 2;
                                int i39 = i3 + 3;
                                path.rQuadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                                f = fArr2[i36] + f15;
                                f2 = fArr2[i37] + f16;
                                f15 += fArr2[i38];
                                f3 = fArr2[i39];
                            }
                            i2 = i3;
                        } else {
                            int i40 = i3 + 2;
                            int i41 = i3 + 3;
                            int i42 = i3 + 4;
                            int i43 = i3 + 5;
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                            f = fArr2[i40] + f15;
                            f2 = fArr2[i41] + f16;
                            f15 += fArr2[i42];
                            f3 = fArr2[i43];
                        }
                        f16 += f3;
                        f11 = f;
                        f12 = f2;
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        int i45 = i3 + 6;
                        i2 = i3;
                        drawArc(path, f15, f16, fArr2[i44] + f15, fArr2[i45] + f16, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f15 += fArr2[i44];
                        f16 += fArr2[i45];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    drawArc(path, f15, f16, fArr2[i46], fArr2[i47], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f15 = fArr2[i46];
                    f16 = fArr2[i47];
                }
                f12 = f16;
                f11 = f15;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            fArr[0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ceil;
            double d19 = d8;
            double d20 = d17;
            double d21 = d14;
            int i = 0;
            double d22 = d5;
            double d23 = d6;
            while (i < ceil) {
                double d24 = d19 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d19;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d30 = d22 + (d21 * sin4);
                double d31 = cos;
                double d32 = sin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                i++;
                d18 = d18;
                sin = d32;
                d22 = d25;
                d15 = d15;
                cos = d31;
                d19 = d24;
                d20 = d28;
                d21 = d27;
                ceil = ceil;
                d23 = d26;
                d10 = d3;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = d3 * cos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = f6;
            double d9 = (((-f) * sin) + (d5 * cos)) / d8;
            double d10 = f4;
            double d11 = ((f3 * cos) + (d10 * sin)) / d6;
            double d12 = (((-f3) * sin) + (d10 * cos)) / d8;
            double d13 = d7 - d11;
            double d14 = d9 - d12;
            double d15 = (d7 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d17);
                float sqrt = (float) (Math.sqrt(d17) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d18);
            double d19 = d13 * sqrt2;
            double d20 = sqrt2 * d14;
            if (z == z2) {
                d = d15 - d20;
                d2 = d16 + d19;
            } else {
                d = d15 + d20;
                d2 = d16 - d19;
            }
            double atan2 = Math.atan2(d9 - d2, d7 - d);
            double atan22 = Math.atan2(d12 - d2, d11 - d) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d21 = d * d6;
            double d22 = d2 * d8;
            arcToBezier(path, (d21 * cos) - (d22 * sin), (d21 * sin) + (d22 * cos), d6, d8, d3, d5, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                i++;
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
