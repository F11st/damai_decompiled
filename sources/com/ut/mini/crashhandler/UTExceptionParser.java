package com.ut.mini.crashhandler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTExceptionParser {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTExceptionItem {
        String mExpName = null;
        String mMd5 = null;
        String mCrashDetail = null;
        boolean mCrashedByUT = false;

        public String getCrashDetail() {
            return this.mCrashDetail;
        }

        public String getExpName() {
            return this.mExpName;
        }

        public String getMd5() {
            return this.mMd5;
        }

        public boolean isCrashedByUT() {
            return this.mCrashedByUT;
        }

        public void setCrashDetail(String str) {
            this.mCrashDetail = str;
        }

        public void setExpName(String str) {
            this.mExpName = str;
        }

        public void setMd5(String str) {
            this.mMd5 = str;
        }

        public void setmCrashedByUT(boolean z) {
            this.mCrashedByUT = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.ut.mini.crashhandler.UTExceptionParser.UTExceptionItem parse(java.lang.Throwable r5) {
        /*
            if (r5 == 0) goto La8
            com.ut.mini.crashhandler.UTExceptionParser$UTExceptionItem r0 = new com.ut.mini.crashhandler.UTExceptionParser$UTExceptionItem
            r0.<init>()
            java.lang.Throwable r1 = r5.getCause()
            if (r1 != 0) goto Le
            r1 = r5
        Le:
            java.lang.StackTraceElement[] r2 = r1.getStackTrace()
            int r3 = r2.length
            if (r3 <= 0) goto La7
            r3 = 0
            r2 = r2[r3]
            if (r2 == 0) goto La7
            java.lang.String r1 = r1.toString()
            java.io.StringWriter r2 = new java.io.StringWriter
            r2.<init>()
            java.io.PrintWriter r4 = new java.io.PrintWriter
            r4.<init>(r2)
            r5.printStackTrace(r4)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L40
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L40
            r4.close()     // Catch: java.lang.Exception -> L36
            r2.close()     // Catch: java.lang.Exception -> L36
            goto L48
        L36:
            goto L48
        L38:
            r5 = move-exception
            r4.close()     // Catch: java.lang.Exception -> L3f
            r2.close()     // Catch: java.lang.Exception -> L3f
        L3f:
            throw r5
        L40:
            r4.close()     // Catch: java.lang.Exception -> L46
            r2.close()     // Catch: java.lang.Exception -> L46
        L46:
            java.lang.String r5 = ""
        L48:
            java.lang.String r2 = "}:"
            int r2 = r1.indexOf(r2)
            if (r2 <= 0) goto L5b
            int r2 = r2 + 2
            java.lang.String r1 = r1.substring(r2)
            java.lang.String r1 = r1.trim()
            goto L67
        L5b:
            java.lang.String r2 = ":"
            int r2 = r1.indexOf(r2)
            if (r2 <= 0) goto L67
            java.lang.String r1 = r1.substring(r3, r2)
        L67:
            r0.setExpName(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L78
            java.lang.String r1 = "\n"
            java.lang.String r2 = "++"
            java.lang.String r5 = r5.replaceAll(r1, r2)
        L78:
            r0.setCrashDetail(r5)
            byte[] r1 = r5.getBytes()
            java.lang.String r1 = tb.qc1.b(r1)
            r0.setMd5(r1)
            java.lang.String r1 = "com.taobao.statistic"
            boolean r1 = r5.contains(r1)
            if (r1 != 0) goto La3
            java.lang.String r1 = "com.ut"
            boolean r1 = r5.contains(r1)
            if (r1 != 0) goto La3
            java.lang.String r1 = "org.usertrack"
            boolean r5 = r5.contains(r1)
            if (r5 == 0) goto L9f
            goto La3
        L9f:
            r0.setmCrashedByUT(r3)
            goto La7
        La3:
            r5 = 1
            r0.setmCrashedByUT(r5)
        La7:
            return r0
        La8:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.crashhandler.UTExceptionParser.parse(java.lang.Throwable):com.ut.mini.crashhandler.UTExceptionParser$UTExceptionItem");
    }
}
