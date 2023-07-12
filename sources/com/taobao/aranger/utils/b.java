package com.taobao.aranger.utils;

import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b {
    private static final HashMap<String, Parcelable.Creator<?>> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a extends ObjectInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, ARanger.class.getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    private static Object a(byte[] bArr) {
        if (bArr != null) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Object d = d(obtain);
            obtain.recycle();
            return d;
        }
        return null;
    }

    private static byte[] b(Object obj) {
        Parcel obtain = Parcel.obtain();
        h(obtain, obj);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    private static Object[] c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Object[] objArr = new Object[readInt];
        for (int i = 0; i < readInt; i++) {
            objArr[i] = d(parcel);
        }
        return objArr;
    }

    private static Object d(Parcel parcel) {
        Parcelable.Creator<?> creator;
        int readInt = parcel.readInt();
        CharSequence[] charSequenceArr = null;
        switch (readInt) {
            case -1:
                return null;
            case 0:
                return parcel.readString();
            case 1:
                return Integer.valueOf(parcel.readInt());
            case 2:
                return parcel.readHashMap(ARanger.class.getClassLoader());
            case 3:
                return parcel.readBundle(ARanger.class.getClassLoader());
            case 4:
                return parcel.readParcelable(ARanger.class.getClassLoader());
            case 5:
                return Short.valueOf((short) parcel.readInt());
            case 6:
                return Long.valueOf(parcel.readLong());
            case 7:
                return Float.valueOf(parcel.readFloat());
            case 8:
                return Double.valueOf(parcel.readDouble());
            case 9:
                return Boolean.valueOf(parcel.readInt() == 1);
            case 10:
                return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            case 11:
                return parcel.readArrayList(ARanger.class.getClassLoader());
            case 12:
                return parcel.readSparseArray(ARanger.class.getClassLoader());
            case 13:
                return parcel.createByteArray();
            case 14:
                return parcel.createStringArray();
            case 15:
                return parcel.readStrongBinder();
            case 16:
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                try {
                    Class<?> b = d.e().b(readString);
                    HashMap<String, Parcelable.Creator<?>> hashMap = a;
                    synchronized (hashMap) {
                        creator = hashMap.get(b.getName());
                        if (creator == null) {
                            try {
                                creator = (Parcelable.Creator) b.getField("CREATOR").get(null);
                                if (creator != null) {
                                    hashMap.put(b.getName(), creator);
                                } else {
                                    throw new BadParcelableException("Parcelable protocol requires a non-null Parcelable.Creator object called CREATOR on class " + b.getName());
                                }
                            } catch (IllegalAccessException unused) {
                                throw new BadParcelableException("IllegalAccessException when unmarshalling: " + b.getName());
                            } catch (NoSuchFieldException unused2) {
                                throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class " + b.getName());
                            }
                        }
                    }
                    Object[] newArray = creator.newArray(readInt2);
                    for (int i = 0; i < readInt2; i++) {
                        newArray[i] = creator.createFromParcel(parcel);
                    }
                    return newArray;
                } catch (IPCException e) {
                    throw new RuntimeException(e);
                }
            case 17:
                return c(parcel);
            case 18:
                return parcel.createIntArray();
            case 19:
                return parcel.createLongArray();
            case 20:
                return Byte.valueOf(parcel.readByte());
            case 21:
                try {
                    return new a(new ByteArrayInputStream(parcel.createByteArray())).readObject();
                } catch (IOException unused3) {
                    throw new RuntimeException("Parcelable encountered IOException reading a Serializable object)");
                } catch (ClassNotFoundException unused4) {
                    throw new RuntimeException("Parcelable encountered ClassNotFoundException reading a Serializable object)");
                }
            case 22:
                return parcel.readSparseBooleanArray();
            case 23:
                return parcel.createBooleanArray();
            case 24:
                int readInt3 = parcel.readInt();
                if (readInt3 >= 0) {
                    charSequenceArr = new CharSequence[readInt3];
                    for (int i2 = 0; i2 < readInt3; i2++) {
                        charSequenceArr[i2] = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    }
                }
                return charSequenceArr;
            case 25:
            case 26:
            case 27:
            default:
                if (Build.VERSION.SDK_INT >= 21) {
                    switch (readInt) {
                        case 25:
                            return parcel.readPersistableBundle(ARanger.class.getClassLoader());
                        case 26:
                            return parcel.readSize();
                        case 27:
                            return parcel.readSizeF();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Parcel ");
                sb.append(parcel);
                sb.append(": Unmarshalling unknown type code ");
                sb.append(readInt);
                sb.append(" at offset ");
                sb.append(parcel.dataPosition() - 4);
                throw new RuntimeException(sb.toString());
            case 28:
                return parcel.createDoubleArray();
            case 29:
                return ParameterWrapper.CREATOR.createFromParcel(parcel);
            case 30:
                int readInt4 = parcel.readInt();
                ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[readInt4];
                for (int i3 = 0; i3 < readInt4; i3++) {
                    parameterWrapperArr[i3] = ParameterWrapper.CREATOR.createFromParcel(parcel);
                }
                return parameterWrapperArr;
        }
    }

    public static Object e(ClassLoader classLoader, Parcel parcel) {
        if (parcel.readInt() == 0) {
            return d(parcel);
        }
        return a(c.a(parcel.readParcelable(classLoader)));
    }

    private static void f(Parcel parcel, Object[] objArr) {
        if (objArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(objArr.length);
        for (Object obj : objArr) {
            h(parcel, obj);
        }
    }

    public static long g(Parcel parcel, Object obj, int i, boolean z) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        h(parcel, obj);
        long dataSize = parcel.dataSize();
        if (z && dataSize > Constants.MAX_SIZE) {
            parcel.setDataSize(dataPosition);
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(1);
            parcel.writeParcelable(c.b(b(obj)), i);
        }
        return dataSize;
    }

    private static void h(Parcel parcel, Object obj) {
        if (obj instanceof ParameterWrapper) {
            parcel.writeInt(29);
            ((ParameterWrapper) obj).writeToParcel(parcel, 0);
        } else if (obj instanceof ParameterWrapper[]) {
            ParameterWrapper[] parameterWrapperArr = (ParameterWrapper[]) obj;
            parcel.writeInt(30);
            parcel.writeInt(parameterWrapperArr.length);
            for (ParameterWrapper parameterWrapper : parameterWrapperArr) {
                parameterWrapper.writeToParcel(parcel, 0);
            }
        } else if (obj == null) {
            parcel.writeInt(-1);
        } else if (obj instanceof String) {
            parcel.writeInt(0);
            parcel.writeString((String) obj);
        } else if (obj instanceof Integer) {
            parcel.writeInt(1);
            parcel.writeInt(((Integer) obj).intValue());
        } else if (obj instanceof Map) {
            parcel.writeInt(2);
            parcel.writeMap((Map) obj);
        } else if (obj instanceof Bundle) {
            parcel.writeInt(3);
            parcel.writeBundle((Bundle) obj);
        } else if (obj instanceof Parcelable) {
            parcel.writeInt(4);
            parcel.writeParcelable((Parcelable) obj, 0);
        } else if (obj instanceof Short) {
            parcel.writeInt(5);
            parcel.writeInt(((Short) obj).intValue());
        } else if (obj instanceof Long) {
            parcel.writeInt(6);
            parcel.writeLong(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            parcel.writeInt(7);
            parcel.writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            parcel.writeInt(8);
            parcel.writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            parcel.writeInt(9);
            parcel.writeInt(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof CharSequence) {
            parcel.writeInt(10);
            TextUtils.writeToParcel((CharSequence) obj, parcel, 0);
        } else if (obj instanceof List) {
            parcel.writeInt(11);
            parcel.writeList((List) obj);
        } else if (obj instanceof SparseArray) {
            parcel.writeInt(12);
            parcel.writeSparseArray((SparseArray) obj);
        } else if (obj instanceof boolean[]) {
            parcel.writeInt(23);
            parcel.writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof byte[]) {
            parcel.writeInt(13);
            parcel.writeByteArray((byte[]) obj);
        } else if (obj instanceof String[]) {
            parcel.writeInt(14);
            parcel.writeStringArray((String[]) obj);
        } else if (obj instanceof CharSequence[]) {
            parcel.writeInt(24);
        } else if (obj instanceof IBinder) {
            parcel.writeInt(15);
            parcel.writeStrongBinder((IBinder) obj);
        } else if (obj instanceof Parcelable[]) {
            parcel.writeInt(16);
            parcel.writeString(obj.getClass().getComponentType().getName());
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            parcel.writeInt(parcelableArr.length);
            for (Parcelable parcelable : parcelableArr) {
                parcelable.writeToParcel(parcel, 0);
            }
        } else if (obj instanceof int[]) {
            parcel.writeInt(18);
            parcel.writeIntArray((int[]) obj);
        } else if (obj instanceof long[]) {
            parcel.writeInt(19);
            parcel.writeLongArray((long[]) obj);
        } else if (obj instanceof Byte) {
            parcel.writeInt(20);
            parcel.writeInt(((Byte) obj).byteValue());
        } else if (obj instanceof double[]) {
            parcel.writeInt(28);
            parcel.writeDoubleArray((double[]) obj);
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isArray() && cls.getComponentType() == Object.class) {
                parcel.writeInt(17);
                f(parcel, (Object[]) obj);
            } else if (obj instanceof Serializable) {
                parcel.writeInt(21);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                    parcel.writeByteArray(byteArrayOutputStream.toByteArray());
                } catch (IOException unused) {
                    throw new RuntimeException("Parcelable encountered IOException writing serializable object");
                }
            } else {
                throw new RuntimeException("Parcel: unable to marshal value " + obj);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (obj instanceof Size) {
                parcel.writeInt(26);
                parcel.writeSize((Size) obj);
            } else if (obj instanceof SizeF) {
                parcel.writeInt(27);
                parcel.writeSizeF((SizeF) obj);
            } else if (obj instanceof PersistableBundle) {
                parcel.writeInt(25);
                parcel.writePersistableBundle((PersistableBundle) obj);
            }
        }
    }
}
