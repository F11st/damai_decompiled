package com.alipay.ma.decode;

import java.util.ArrayList;
import mtopsdk.mtop.intf.Mtop;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum ONECODE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class DecodeType {
    private static final /* synthetic */ DecodeType[] $VALUES;
    public static final DecodeType ALLBARCODE;
    public static final DecodeType ALLCODE;
    public static final DecodeType ALLLOTTERYCODE;
    public static final DecodeType ALLQRCODE;
    public static final DecodeType ARCODE;
    public static final DecodeType CODE128;
    public static final DecodeType CODE39;
    public static final DecodeType CODE93;
    public static final DecodeType DEFAULTCODE;
    public static final DecodeType DMCODE;
    public static final DecodeType EAN13;
    public static final DecodeType EAN14;
    public static final DecodeType EAN8;
    public static final DecodeType EXPRESS;
    public static final DecodeType FASTMAIL;
    public static final DecodeType HMCODE;
    public static final DecodeType ITF;
    public static final DecodeType MEDICINE;
    public static final DecodeType NARROW;
    public static final DecodeType ONECODE;
    public static final DecodeType PDF417;
    public static final DecodeType PRODUCT;
    public static final DecodeType QRCODE;
    public static final DecodeType UPCA;
    public static final DecodeType UPCE;
    int codeType;

    static {
        DecodeType decodeType = new DecodeType("EAN13", 0, 1);
        EAN13 = decodeType;
        DecodeType decodeType2 = new DecodeType("EAN8", 1, 2);
        EAN8 = decodeType2;
        DecodeType decodeType3 = new DecodeType("UPCA", 2, 4);
        UPCA = decodeType3;
        DecodeType decodeType4 = new DecodeType("UPCE", 3, 8);
        UPCE = decodeType4;
        DecodeType decodeType5 = new DecodeType("EAN14", 4, 128);
        EAN14 = decodeType5;
        DecodeType decodeType6 = new DecodeType("CODE39", 5, 16);
        CODE39 = decodeType6;
        DecodeType decodeType7 = new DecodeType("CODE93", 6, 256);
        CODE93 = decodeType7;
        DecodeType decodeType8 = new DecodeType("CODE128", 7, 32);
        CODE128 = decodeType8;
        DecodeType decodeType9 = new DecodeType("ITF", 8, 64);
        ITF = decodeType9;
        DecodeType decodeType10 = new DecodeType("QRCODE", 9, 512);
        QRCODE = decodeType10;
        DecodeType decodeType11 = new DecodeType("DMCODE", 10, 1024);
        DMCODE = decodeType11;
        DecodeType decodeType12 = new DecodeType("PDF417", 11, 2048);
        PDF417 = decodeType12;
        DecodeType decodeType13 = new DecodeType("NARROW", 12, 131072);
        NARROW = decodeType13;
        DecodeType decodeType14 = new DecodeType("HMCODE", 13, 262144);
        HMCODE = decodeType14;
        DecodeType decodeType15 = new DecodeType("ARCODE", 14, 65536);
        ARCODE = decodeType15;
        DecodeType decodeType16 = new DecodeType("ONECODE", 15, decodeType2.codeType | decodeType.codeType | decodeType3.codeType | decodeType4.codeType | decodeType6.codeType | decodeType8.codeType | decodeType9.codeType | decodeType5.codeType | decodeType7.codeType);
        ONECODE = decodeType16;
        DecodeType decodeType17 = new DecodeType("FASTMAIL", 16, decodeType8.codeType | decodeType6.codeType);
        FASTMAIL = decodeType17;
        DecodeType decodeType18 = new DecodeType(Mtop.Id.PRODUCT, 17, decodeType16.codeType);
        PRODUCT = decodeType18;
        DecodeType decodeType19 = new DecodeType("MEDICINE", 18, decodeType16.codeType);
        MEDICINE = decodeType19;
        DecodeType decodeType20 = new DecodeType("EXPRESS", 19, decodeType16.codeType);
        EXPRESS = decodeType20;
        DecodeType decodeType21 = new DecodeType("ALLQRCODE", 20, decodeType10.codeType);
        ALLQRCODE = decodeType21;
        DecodeType decodeType22 = new DecodeType("ALLBARCODE", 21, decodeType16.codeType);
        ALLBARCODE = decodeType22;
        DecodeType decodeType23 = new DecodeType("ALLLOTTERYCODE", 22, decodeType12.codeType | decodeType11.codeType);
        ALLLOTTERYCODE = decodeType23;
        DecodeType decodeType24 = new DecodeType("ALLCODE", 23, decodeType16.codeType | decodeType21.codeType | decodeType11.codeType | decodeType15.codeType | decodeType12.codeType);
        ALLCODE = decodeType24;
        DecodeType decodeType25 = new DecodeType("DEFAULTCODE", 24, decodeType14.codeType | decodeType16.codeType | decodeType21.codeType | decodeType15.codeType | decodeType11.codeType | decodeType12.codeType);
        DEFAULTCODE = decodeType25;
        $VALUES = new DecodeType[]{decodeType, decodeType2, decodeType3, decodeType4, decodeType5, decodeType6, decodeType7, decodeType8, decodeType9, decodeType10, decodeType11, decodeType12, decodeType13, decodeType14, decodeType15, decodeType16, decodeType17, decodeType18, decodeType19, decodeType20, decodeType21, decodeType22, decodeType23, decodeType24, decodeType25};
    }

    private DecodeType(String str, int i, int i2) {
        this.codeType = i2;
    }

    public static int getCode(DecodeType decodeType, String str) {
        if (decodeType == null && str == null) {
            return DEFAULTCODE.getCodeType();
        }
        int codeType = decodeType != null ? decodeType.getCodeType() : 0;
        if (str != null) {
            if (str.contains("default")) {
                codeType |= DEFAULTCODE.getCodeType();
            }
            if (str.contains("barCode")) {
                codeType |= ALLBARCODE.getCodeType();
            }
            if (str.contains("qrCode")) {
                codeType |= ALLQRCODE.getCodeType();
            }
            if (str.contains("dmCode")) {
                codeType |= DMCODE.getCodeType();
            }
            if (str.contains("pdf417Code")) {
                codeType |= PDF417.getCodeType();
            }
            if (str.contains("narrowCode")) {
                codeType |= NARROW.getCodeType();
            }
            return str.contains("hmCode") ? codeType | HMCODE.getCodeType() : codeType;
        }
        return codeType;
    }

    public static DecodeType[] getCodeTypes(DecodeType decodeType, String str) {
        if (decodeType == null && str == null) {
            return new DecodeType[]{DEFAULTCODE};
        }
        ArrayList arrayList = new ArrayList();
        if (decodeType != null) {
            arrayList.add(decodeType);
        }
        if (str != null) {
            if (str.contains("default")) {
                arrayList.add(DEFAULTCODE);
            }
            if (str.contains("barCode")) {
                arrayList.add(ALLBARCODE);
            }
            if (str.contains("qrCode")) {
                arrayList.add(ALLQRCODE);
            }
            if (str.contains("dmCode")) {
                arrayList.add(DMCODE);
            }
            if (str.contains("pdf417Code")) {
                arrayList.add(PDF417);
            }
            if (str.contains("narrowCode")) {
                arrayList.add(NARROW);
            }
            if (str.contains("hmCode")) {
                arrayList.add(HMCODE);
            }
        }
        if (str.length() == 0) {
            arrayList.add(DEFAULTCODE);
        }
        return (DecodeType[]) arrayList.toArray(new DecodeType[arrayList.size()]);
    }

    public static DecodeType valueOf(String str) {
        return (DecodeType) Enum.valueOf(DecodeType.class, str);
    }

    public static DecodeType[] values() {
        return (DecodeType[]) $VALUES.clone();
    }

    public int getCodeType() {
        return this.codeType;
    }
}
