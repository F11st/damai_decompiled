package androidx.renderscript;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Matrix4f {
    final float[] mMat;

    public Matrix4f() {
        this.mMat = new float[16];
        loadIdentity();
    }

    private float computeCofactor(int i, int i2) {
        int i3 = (i + 1) % 4;
        int i4 = (i + 2) % 4;
        int i5 = (i + 3) % 4;
        float[] fArr = this.mMat;
        int i6 = ((i2 + 1) % 4) * 4;
        int i7 = ((i2 + 2) % 4) * 4;
        int i8 = i4 + i7;
        int i9 = ((i2 + 3) % 4) * 4;
        int i10 = i5 + i9;
        int i11 = i4 + i9;
        int i12 = i5 + i7;
        int i13 = i4 + i6;
        int i14 = i5 + i6;
        float f = ((fArr[i3 + i6] * ((fArr[i8] * fArr[i10]) - (fArr[i11] * fArr[i12]))) - (fArr[i7 + i3] * ((fArr[i13] * fArr[i10]) - (fArr[i11] * fArr[i14])))) + (fArr[i3 + i9] * ((fArr[i13] * fArr[i12]) - (fArr[i8] * fArr[i14])));
        return ((i + i2) & 1) != 0 ? -f : f;
    }

    public float get(int i, int i2) {
        return this.mMat[(i * 4) + i2];
    }

    public float[] getArray() {
        return this.mMat;
    }

    public boolean inverse() {
        Matrix4f matrix4f = new Matrix4f();
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                matrix4f.mMat[(i * 4) + i2] = computeCofactor(i, i2);
            }
        }
        float[] fArr = this.mMat;
        float f = fArr[0];
        float[] fArr2 = matrix4f.mMat;
        float f2 = (f * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[8] * fArr2[2]) + (fArr[12] * fArr2[3]);
        if (Math.abs(f2) < 1.0E-6d) {
            return false;
        }
        float f3 = 1.0f / f2;
        for (int i3 = 0; i3 < 16; i3++) {
            this.mMat[i3] = matrix4f.mMat[i3] * f3;
        }
        return true;
    }

    public boolean inverseTranspose() {
        Matrix4f matrix4f = new Matrix4f();
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                matrix4f.mMat[(i2 * 4) + i] = computeCofactor(i, i2);
            }
        }
        float[] fArr = this.mMat;
        float f = fArr[0];
        float[] fArr2 = matrix4f.mMat;
        float f2 = (f * fArr2[0]) + (fArr[4] * fArr2[4]) + (fArr[8] * fArr2[8]) + (fArr[12] * fArr2[12]);
        if (Math.abs(f2) < 1.0E-6d) {
            return false;
        }
        float f3 = 1.0f / f2;
        for (int i3 = 0; i3 < 16; i3++) {
            this.mMat[i3] = matrix4f.mMat[i3] * f3;
        }
        return true;
    }

    public void load(Matrix4f matrix4f) {
        float[] array = matrix4f.getArray();
        float[] fArr = this.mMat;
        System.arraycopy(array, 0, fArr, 0, fArr.length);
    }

    public void loadFrustum(float f, float f2, float f3, float f4, float f5, float f6) {
        loadIdentity();
        float[] fArr = this.mMat;
        float f7 = 2.0f * f5;
        float f8 = f2 - f;
        fArr[0] = f7 / f8;
        float f9 = f4 - f3;
        fArr[5] = f7 / f9;
        fArr[8] = (f2 + f) / f8;
        fArr[9] = (f4 + f3) / f9;
        float f10 = f6 - f5;
        fArr[10] = (-(f6 + f5)) / f10;
        fArr[11] = -1.0f;
        fArr[14] = ((f6 * (-2.0f)) * f5) / f10;
        fArr[15] = 0.0f;
    }

    public void loadIdentity() {
        float[] fArr = this.mMat;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public void loadMultiply(Matrix4f matrix4f, Matrix4f matrix4f2) {
        for (int i = 0; i < 4; i++) {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (int i2 = 0; i2 < 4; i2++) {
                float f5 = matrix4f2.get(i, i2);
                f += matrix4f.get(i2, 0) * f5;
                f2 += matrix4f.get(i2, 1) * f5;
                f3 += matrix4f.get(i2, 2) * f5;
                f4 += matrix4f.get(i2, 3) * f5;
            }
            set(i, 0, f);
            set(i, 1, f2);
            set(i, 2, f3);
            set(i, 3, f4);
        }
    }

    public void loadOrtho(float f, float f2, float f3, float f4, float f5, float f6) {
        loadIdentity();
        float[] fArr = this.mMat;
        float f7 = f2 - f;
        fArr[0] = 2.0f / f7;
        float f8 = f4 - f3;
        fArr[5] = 2.0f / f8;
        float f9 = f6 - f5;
        fArr[10] = (-2.0f) / f9;
        fArr[12] = (-(f2 + f)) / f7;
        fArr[13] = (-(f4 + f3)) / f8;
        fArr[14] = (-(f6 + f5)) / f9;
    }

    public void loadOrthoWindow(int i, int i2) {
        loadOrtho(0.0f, i, i2, 0.0f, -1.0f, 1.0f);
    }

    public void loadPerspective(float f, float f2, float f3, float f4) {
        float tan = f3 * ((float) Math.tan((float) ((f * 3.141592653589793d) / 360.0d)));
        float f5 = -tan;
        loadFrustum(f5 * f2, tan * f2, f5, tan, f3, f4);
    }

    public void loadProjectionNormalized(int i, int i2) {
        Matrix4f matrix4f = new Matrix4f();
        Matrix4f matrix4f2 = new Matrix4f();
        if (i > i2) {
            float f = i / i2;
            matrix4f.loadFrustum(-f, f, -1.0f, 1.0f, 1.0f, 100.0f);
        } else {
            float f2 = i2 / i;
            matrix4f.loadFrustum(-1.0f, 1.0f, -f2, f2, 1.0f, 100.0f);
        }
        matrix4f2.loadRotate(180.0f, 0.0f, 1.0f, 0.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        matrix4f2.loadScale(-2.0f, 2.0f, 1.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        matrix4f2.loadTranslate(0.0f, 0.0f, 2.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        load(matrix4f);
    }

    public void loadRotate(float f, float f2, float f3, float f4) {
        float[] fArr = this.mMat;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
        double d = f * 0.017453292f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
        if (sqrt == 1.0f) {
            float f5 = 1.0f / sqrt;
            f2 *= f5;
            f3 *= f5;
            f4 *= f5;
        }
        float f6 = 1.0f - cos;
        float f7 = f2 * sin;
        float f8 = f3 * sin;
        float f9 = sin * f4;
        float[] fArr2 = this.mMat;
        fArr2[0] = (f2 * f2 * f6) + cos;
        float f10 = f2 * f3 * f6;
        fArr2[4] = f10 - f9;
        float f11 = f4 * f2 * f6;
        fArr2[8] = f11 + f8;
        fArr2[1] = f10 + f9;
        fArr2[5] = (f3 * f3 * f6) + cos;
        float f12 = f3 * f4 * f6;
        fArr2[9] = f12 - f7;
        fArr2[2] = f11 - f8;
        fArr2[6] = f12 + f7;
        fArr2[10] = (f4 * f4 * f6) + cos;
    }

    public void loadScale(float f, float f2, float f3) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[0] = f;
        fArr[5] = f2;
        fArr[10] = f3;
    }

    public void loadTranslate(float f, float f2, float f3) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
    }

    public void multiply(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f();
        matrix4f2.loadMultiply(this, matrix4f);
        load(matrix4f2);
    }

    public void rotate(float f, float f2, float f3, float f4) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadRotate(f, f2, f3, f4);
        multiply(matrix4f);
    }

    public void scale(float f, float f2, float f3) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadScale(f, f2, f3);
        multiply(matrix4f);
    }

    public void set(int i, int i2, float f) {
        this.mMat[(i * 4) + i2] = f;
    }

    public void translate(float f, float f2, float f3) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadTranslate(f, f2, f3);
        multiply(matrix4f);
    }

    public void transpose() {
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < 4; i3++) {
                float[] fArr = this.mMat;
                int i4 = (i * 4) + i3;
                float f = fArr[i4];
                int i5 = (i3 * 4) + i;
                fArr[i4] = fArr[i5];
                fArr[i5] = f;
            }
            i = i2;
        }
    }

    public void load(Matrix3f matrix3f) {
        float[] fArr = this.mMat;
        float[] fArr2 = matrix3f.mMat;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = 0.0f;
        fArr[4] = fArr2[3];
        fArr[5] = fArr2[4];
        fArr[6] = fArr2[5];
        fArr[7] = 0.0f;
        fArr[8] = fArr2[6];
        fArr[9] = fArr2[7];
        fArr[10] = fArr2[8];
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public Matrix4f(float[] fArr) {
        float[] fArr2 = new float[16];
        this.mMat = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }
}
