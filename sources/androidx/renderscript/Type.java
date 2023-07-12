package androidx.renderscript;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Type extends BaseObj {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class Builder {
        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX = 1;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Builder(RenderScript renderScript, Element element) {
            element.checkValid();
            this.mRS = renderScript;
            this.mElement = element;
        }

        public Type create() {
            int i = this.mDimZ;
            if (i > 0) {
                if (this.mDimX >= 1 && this.mDimY >= 1) {
                    if (this.mDimFaces) {
                        throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                    }
                } else {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
            }
            int i2 = this.mDimY;
            if (i2 > 0 && this.mDimX < 1) {
                throw new RSInvalidStateException("X dimension required when Y is present.");
            }
            boolean z = this.mDimFaces;
            if (z && i2 < 1) {
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            }
            if (this.mYuv != 0 && (i != 0 || z || this.mDimMipmaps)) {
                throw new RSInvalidStateException("YUV only supports basic 2D.");
            }
            RenderScript renderScript = this.mRS;
            Type type = new Type(renderScript.nTypeCreate(this.mElement.getID(renderScript), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
            type.mElement = this.mElement;
            type.mDimX = this.mDimX;
            type.mDimY = this.mDimY;
            type.mDimZ = this.mDimZ;
            type.mDimMipmaps = this.mDimMipmaps;
            type.mDimFaces = this.mDimFaces;
            type.mDimYuv = this.mYuv;
            type.calcElementCount();
            return type;
        }

        public Builder setFaces(boolean z) {
            this.mDimFaces = z;
            return this;
        }

        public Builder setMipmaps(boolean z) {
            this.mDimMipmaps = z;
            return this;
        }

        public Builder setX(int i) {
            if (i >= 1) {
                this.mDimX = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
        }

        public Builder setY(int i) {
            if (i >= 1) {
                this.mDimY = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
        }

        public Builder setYuvFormat(int i) {
            if (i != 17 && i != 842094169) {
                throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
            }
            this.mYuv = i;
            return this;
        }

        public Builder setZ(int i) {
            if (i >= 1) {
                this.mDimZ = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);
        
        int mID;

        CubemapFace(int i) {
            this.mID = i;
        }
    }

    Type(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static Type createX(RenderScript renderScript, Element element, int i) {
        if (i >= 1) {
            Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, 0, 0, false, false, 0), renderScript);
            type.mElement = element;
            type.mDimX = i;
            type.calcElementCount();
            return type;
        }
        throw new RSInvalidStateException("Dimension must be >= 1.");
    }

    public static Type createXY(RenderScript renderScript, Element element, int i, int i2) {
        if (i >= 1 && i2 >= 1) {
            Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, 0, false, false, 0), renderScript);
            type.mElement = element;
            type.mDimX = i;
            type.mDimY = i2;
            type.calcElementCount();
            return type;
        }
        throw new RSInvalidStateException("Dimension must be >= 1.");
    }

    public static Type createXYZ(RenderScript renderScript, Element element, int i, int i2, int i3) {
        if (i >= 1 && i2 >= 1 && i3 >= 1) {
            Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, i3, false, false, 0), renderScript);
            type.mElement = element;
            type.mDimX = i;
            type.mDimY = i2;
            type.mDimZ = i3;
            type.calcElementCount();
            return type;
        }
        throw new RSInvalidStateException("Dimension must be >= 1.");
    }

    void calcElementCount() {
        boolean hasMipmaps = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int i = hasFaces() ? 6 : 1;
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        if (z == 0) {
            z = 1;
        }
        int i2 = x * y * z * i;
        while (hasMipmaps && (x > 1 || y > 1 || z > 1)) {
            if (x > 1) {
                x >>= 1;
            }
            if (y > 1) {
                y >>= 1;
            }
            if (z > 1) {
                z >>= 1;
            }
            i2 += x * y * z * i;
        }
        this.mElementCount = i2;
    }

    public int getCount() {
        return this.mElementCount;
    }

    public long getDummyType(RenderScript renderScript, long j) {
        return renderScript.nIncTypeCreate(j, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mDimYuv);
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }
}
