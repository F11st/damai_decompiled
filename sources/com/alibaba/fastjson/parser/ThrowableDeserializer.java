package com.alibaba.fastjson.parser;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0190, code lost:
        if (r0.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0192, code lost:
        r2 = (java.util.Map.Entry) r0.next();
        r2 = r2.getValue();
        r4 = r7.getFieldDeserializer((java.lang.String) r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01a6, code lost:
        if (r4 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a8, code lost:
        r4.setValue(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ac, code lost:
        return (T) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b5, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d8, code lost:
        if (r2 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00da, code lost:
        r3 = (T) new java.lang.Exception(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        r4 = r2.getConstructors();
        r6 = r4.length;
        r9 = r15;
        r10 = r9;
        r14 = r10;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00eb, code lost:
        if (r7 >= r6) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ed, code lost:
        r16 = r4[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f4, code lost:
        if (r16.getParameterTypes().length != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f6, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00fe, code lost:
        if (r16.getParameterTypes().length != 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0108, code lost:
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010a, code lost:
        r10 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0113, code lost:
        if (r16.getParameterTypes().length != 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011c, code lost:
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0127, code lost:
        if (r16.getParameterTypes()[1] != java.lang.Throwable.class) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0129, code lost:
        r9 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x012b, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x012f, code lost:
        if (r9 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0131, code lost:
        r3 = (T) ((java.lang.Throwable) r9.newInstance(r12, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0141, code lost:
        if (r10 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0143, code lost:
        r3 = (java.lang.Throwable) r10.newInstance(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0150, code lost:
        if (r14 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0152, code lost:
        r3 = (java.lang.Throwable) r14.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015c, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015d, code lost:
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015f, code lost:
        r3 = (T) new java.lang.Exception(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0164, code lost:
        if (r13 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0166, code lost:
        ((java.lang.Throwable) r3).setStackTrace(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0169, code lost:
        if (r5 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x016b, code lost:
        if (r2 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x016f, code lost:
        if (r2 != r18.clazz) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0171, code lost:
        r7 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0173, code lost:
        r0 = r19.config.getDeserializer(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x017b, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x017d, code lost:
        r7 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0181, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0182, code lost:
        if (r7 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0184, code lost:
        r0 = r5.entrySet().iterator();
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00d5 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r19, java.lang.reflect.Type r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
