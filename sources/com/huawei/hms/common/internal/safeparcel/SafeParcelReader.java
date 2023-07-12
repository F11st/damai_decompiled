package com.huawei.hms.common.internal.safeparcel;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeParcelReader {
    private static final int BIT16_MARK = 65535;
    private static final int FIELD_ID_CHECKER = 20293;
    private static final int MAX_ARRAY_LENGTH = 1024;
    private static final int NEGATIVE_MARK = -65536;
    private static final int OFFSET16 = 16;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                java.lang.String r1 = java.lang.String.valueOf(r3)
                int r1 = r1.length()
                int r1 = r1 + 41
                r0.<init>(r1)
                r0.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r0.append(r3)
                int r3 = r4.dataPosition()
                r0.append(r3)
                java.lang.String r3 = " size="
                r0.append(r3)
                int r3 = r4.dataSize()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigDecimal[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigInteger[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new boolean[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBooleanArray;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static Bundle createBundle(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new byte[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createByteArray;
    }

    public static byte[][] createByteArrayArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        byte[][] bArr = new byte[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bArr;
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static char[] createCharArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new char[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createCharArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new double[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createDoubleArray;
    }

    public static ArrayList<Double> createDoubleList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static float[] createFloatArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new float[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createFloatArray;
    }

    public static ArrayList<Float> createFloatList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new IBinder[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArray;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static int[] createIntArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new int[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static long[] createLongArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new long[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createLongArray;
    }

    public static ArrayList<Long> createLongList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static Parcel createParcel(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        return obtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new Parcel[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                parcelArr[i2] = null;
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    public static ArrayList<Parcel> createParcelList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                arrayList.add(null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 == 0) {
                sparseArray.append(readInt2, null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt3, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <P extends Parcelable> P createParcelable(Parcel parcel, int i, Parcelable.Creator<P> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        P createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        return createFromParcel;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return readSparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseIntArray;
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseLongArray sparseLongArray = Build.VERSION.SDK_INT >= 18 ? new SparseLongArray() : null;
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            if (Build.VERSION.SDK_INT >= 18) {
                sparseLongArray.append(parcel.readInt(), parcel.readLong());
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseLongArray;
    }

    public static String createString(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        return readString;
    }

    public static String[] createStringArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new String[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArrayList;
    }

    public static SparseArray<String> createStringSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <C> C[] createTypedArray(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return creator.newArray(0);
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        C[] cArr = (C[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return cArr;
    }

    public static <C> ArrayList<C> createTypedList(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        ArrayList<C> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return createTypedArrayList;
    }

    public static <C> SparseArray<C> createTypedSparseArray(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        SparseArray<C> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    private static void ensureArrayLengthValid(Parcel parcel, int i) {
        if (i > 1024) {
            throw new ParseException("arraySize cannot be beyond 65535", parcel);
        }
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i, parcel);
    }

    private static void ensureDataPositionValid(Parcel parcel, int i, int i2) {
        if (i < 0 || isOutOfIntBoundary(i, i2)) {
            throw new ParseException("dataPosition cannot be beyond integer scope", parcel);
        }
    }

    public static int getFieldId(int i) {
        return i & 65535;
    }

    private static boolean isOutOfIntBoundary(int i, int i2) {
        long j = i + i2;
        return j > 2147483647L || j < -2147483648L;
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return Boolean.FALSE;
        }
        sizeChecker(parcel, i, readSize, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte readByte(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static char readChar(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (char) parcel.readInt();
    }

    public static double readDouble(Parcel parcel, int i) {
        sizeChecker(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double readDoubleObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer readIntegerObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void readList(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize != 0) {
            ensureDataPositionValid(parcel, readSize, dataPosition);
            parcel.readList(list, classLoader);
            parcel.setDataPosition(readSize + dataPosition);
        }
    }

    public static long readLong(Parcel parcel, int i) {
        sizeChecker(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short readShort(Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int readSize(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    private static void sizeChecker(Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize == i2) {
            return;
        }
        String hexString = Integer.toHexString(readSize);
        StringBuilder sb = new StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(readSize);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(jn1.BRACKET_END_STR);
        throw new ParseException(sb.toString(), parcel);
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        ensureDataPositionValid(parcel, readSize, dataPosition);
        parcel.setDataPosition(readSize + dataPosition);
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != FIELD_ID_CHECKER) {
            String hexString = Integer.toHexString(readHeader);
            throw new ParseException(hexString.length() != 0 ? "Expected object header. Got 0x".concat(hexString) : "Expected object header. Got 0x", parcel);
        }
        int i = readSize + dataPosition;
        if (i < dataPosition || i > parcel.dataSize()) {
            throw new ParseException("invalid start=" + dataPosition + " end=" + i, parcel);
        }
        return i;
    }

    private static void sizeChecker(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(jn1.BRACKET_END_STR);
        throw new ParseException(sb.toString(), parcel);
    }
}
