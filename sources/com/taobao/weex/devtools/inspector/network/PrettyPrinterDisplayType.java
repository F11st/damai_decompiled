package com.taobao.weex.devtools.inspector.network;

import com.taobao.weex.devtools.inspector.protocol.module.Page;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum HTML uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class PrettyPrinterDisplayType {
    private static final /* synthetic */ PrettyPrinterDisplayType[] $VALUES;
    public static final PrettyPrinterDisplayType HTML;
    public static final PrettyPrinterDisplayType JSON;
    public static final PrettyPrinterDisplayType TEXT;
    private final Page.ResourceType mResourceType;

    static {
        PrettyPrinterDisplayType prettyPrinterDisplayType = new PrettyPrinterDisplayType("JSON", 0, Page.ResourceType.XHR);
        JSON = prettyPrinterDisplayType;
        Page.ResourceType resourceType = Page.ResourceType.DOCUMENT;
        PrettyPrinterDisplayType prettyPrinterDisplayType2 = new PrettyPrinterDisplayType("HTML", 1, resourceType);
        HTML = prettyPrinterDisplayType2;
        PrettyPrinterDisplayType prettyPrinterDisplayType3 = new PrettyPrinterDisplayType("TEXT", 2, resourceType);
        TEXT = prettyPrinterDisplayType3;
        $VALUES = new PrettyPrinterDisplayType[]{prettyPrinterDisplayType, prettyPrinterDisplayType2, prettyPrinterDisplayType3};
    }

    private PrettyPrinterDisplayType(String str, int i, Page.ResourceType resourceType) {
        this.mResourceType = resourceType;
    }

    public static PrettyPrinterDisplayType valueOf(String str) {
        return (PrettyPrinterDisplayType) Enum.valueOf(PrettyPrinterDisplayType.class, str);
    }

    public static PrettyPrinterDisplayType[] values() {
        return (PrettyPrinterDisplayType[]) $VALUES.clone();
    }

    public Page.ResourceType getResourceType() {
        return this.mResourceType;
    }
}
