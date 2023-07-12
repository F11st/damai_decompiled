package com.alipay.ma.common.result;

import com.alipay.ma.decode.DecodeType;
import mtopsdk.mtop.intf.Mtop;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum PRODUCT uses external variables
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
public final class ResultMaType {
    private static final /* synthetic */ ResultMaType[] $VALUES;
    public static final ResultMaType ARCODE;
    public static final int AR_CODE = 65536;
    public static final int BAR_CODE = 0;
    public static final ResultMaType DM;
    public static final int DM_CODE = 1024;
    public static final ResultMaType EXPRESS;
    public static final int EXPRESS_CODE = 2;
    public static final ResultMaType HMCODE;
    public static final int HM_CODE = 262144;
    public static final ResultMaType MEDICINE;
    public static final ResultMaType NARROW;
    public static final int NARROW_CODE = 131072;
    public static final ResultMaType PDF417;
    public static final int PDF417_CODE = 2048;
    public static final ResultMaType PRODUCT;
    public static final ResultMaType QR;
    public static final int QR_CODE = 1;
    public static final ResultMaType TB_ANTI_FAKE;
    private int discernType;
    private int type;

    static {
        DecodeType decodeType = DecodeType.ONECODE;
        ResultMaType resultMaType = new ResultMaType(Mtop.Id.PRODUCT, 0, 0, decodeType.getCodeType());
        PRODUCT = resultMaType;
        DecodeType decodeType2 = DecodeType.QRCODE;
        ResultMaType resultMaType2 = new ResultMaType("QR", 1, 1, decodeType2.getCodeType());
        QR = resultMaType2;
        ResultMaType resultMaType3 = new ResultMaType("MEDICINE", 2, 2, decodeType.getCodeType());
        MEDICINE = resultMaType3;
        ResultMaType resultMaType4 = new ResultMaType("EXPRESS", 3, 2, decodeType.getCodeType());
        EXPRESS = resultMaType4;
        ResultMaType resultMaType5 = new ResultMaType("TB_ANTI_FAKE", 4, 1, decodeType2.getCodeType());
        TB_ANTI_FAKE = resultMaType5;
        ResultMaType resultMaType6 = new ResultMaType("DM", 5, 1024, DecodeType.DMCODE.getCodeType());
        DM = resultMaType6;
        ResultMaType resultMaType7 = new ResultMaType("PDF417", 6, 2048, DecodeType.PDF417.getCodeType());
        PDF417 = resultMaType7;
        ResultMaType resultMaType8 = new ResultMaType("NARROW", 7, 131072, DecodeType.NARROW.getCodeType());
        NARROW = resultMaType8;
        ResultMaType resultMaType9 = new ResultMaType("ARCODE", 8, 65536, DecodeType.ARCODE.getCodeType());
        ARCODE = resultMaType9;
        ResultMaType resultMaType10 = new ResultMaType("HMCODE", 9, 262144, DecodeType.HMCODE.getCodeType());
        HMCODE = resultMaType10;
        $VALUES = new ResultMaType[]{resultMaType, resultMaType2, resultMaType3, resultMaType4, resultMaType5, resultMaType6, resultMaType7, resultMaType8, resultMaType9, resultMaType10};
    }

    private ResultMaType(String str, int i, int i2, int i3) {
        this.type = i2;
        this.discernType = i3;
    }

    public static ResultMaType valueOf(String str) {
        return (ResultMaType) Enum.valueOf(ResultMaType.class, str);
    }

    public static ResultMaType[] values() {
        return (ResultMaType[]) $VALUES.clone();
    }

    public int getDiscernType() {
        return this.discernType;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
