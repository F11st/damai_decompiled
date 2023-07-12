package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i, int i2) {
        int i3 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i3 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i4 = this.mCountInt;
        iArr3[i4] = i;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i4 + 1;
        iArr4[i4] = i2;
    }

    public void addIfNotNull(int i, String str) {
        if (str != null) {
            add(i, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedValues.setValue(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i2 = 0; i2 < this.mCountFloat; i2++) {
            typedValues.setValue(this.mTypeFloat[i2], this.mValueFloat[i2]);
        }
        for (int i3 = 0; i3 < this.mCountString; i3++) {
            typedValues.setValue(this.mTypeString[i3], this.mValueString[i3]);
        }
        for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
            typedValues.setValue(this.mTypeBoolean[i4], this.mValueBoolean[i4]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            if (this.mTypeInt[i2] == i) {
                return this.mValueInt[i2];
            }
        }
        return -1;
    }

    public void add(int i, float f) {
        int i2 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i2 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i3 = this.mCountFloat;
        iArr2[i3] = i;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i3 + 1;
        fArr2[i3] = f;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedBundle.add(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i2 = 0; i2 < this.mCountFloat; i2++) {
            typedBundle.add(this.mTypeFloat[i2], this.mValueFloat[i2]);
        }
        for (int i3 = 0; i3 < this.mCountString; i3++) {
            typedBundle.add(this.mTypeString[i3], this.mValueString[i3]);
        }
        for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
            typedBundle.add(this.mTypeBoolean[i4], this.mValueBoolean[i4]);
        }
    }

    public void add(int i, String str) {
        int i2 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i2 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i3 = this.mCountString;
        iArr2[i3] = i;
        String[] strArr2 = this.mValueString;
        this.mCountString = i3 + 1;
        strArr2[i3] = str;
    }

    public void add(int i, boolean z) {
        int i2 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i2 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i3 = this.mCountBoolean;
        iArr2[i3] = i;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i3 + 1;
        zArr2[i3] = z;
    }
}
