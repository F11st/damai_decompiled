package com.ut.mini;

import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.List;
import tb.hl2;
import tb.sj;
import tb.we2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTPageSequenceMgr {
    private static final String SPM_SEQ = "spm_seq";
    private static final String TAG = "UTPageSequenceMgr";
    static final String UT_SEQ = "ut_seq";
    private static List<PageNode> mPageSequence = new ArrayList();
    private static int mSpmCount = 0;
    private static List<String> mSpmPageList = null;
    private static String CONFIG = "{\"spm_seq\":{\"count\":4,\"page\":[\"Page_Detail\",\"Page_MyTaobao\"]}}";
    private static String mConfig = null;
    private static boolean bInit = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PageNode {
        int pageId;
        String pageName;
        String spmUrl;

        private PageNode() {
            this.pageName = "";
            this.spmUrl = "-";
        }
    }

    UTPageSequenceMgr() {
    }

    private static boolean compare(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private static int findNodeIndex(int i, String str) {
        int i2 = -1;
        for (int size = mPageSequence.size() - 1; size >= 0; size--) {
            PageNode pageNode = mPageSequence.get(size);
            if (pageNode != null && i == pageNode.pageId) {
                if (i2 < 0) {
                    i2 = size;
                }
                if (compare(str, pageNode.pageName)) {
                    return size;
                }
            }
        }
        return i2;
    }

    private static List<String> getSpmSeq(int i) {
        ArrayList arrayList = new ArrayList();
        int size = mPageSequence.size();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (size - 1) - i2;
            if (i3 < 0) {
                break;
            }
            PageNode pageNode = mPageSequence.get(i3);
            if (pageNode != null) {
                arrayList.add(pageNode.spmUrl);
            }
        }
        return arrayList;
    }

    public static void init() {
        if (bInit) {
            return;
        }
        bInit = true;
        Logger.f(TAG, UCCore.LEGACY_EVENT_INIT);
        hl2.c().f(new Runnable() { // from class: com.ut.mini.UTPageSequenceMgr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UTPageSequenceMgr.updateConfig(we2.a(sj.c().b(), UTPageSequenceMgr.UT_SEQ));
                } catch (Exception unused) {
                }
            }
        });
        UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() { // from class: com.ut.mini.UTPageSequenceMgr.2
            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public String getKey() {
                return UTPageSequenceMgr.UT_SEQ;
            }

            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public void onChange(String str) {
                UTPageSequenceMgr.updateConfig(str);
            }
        });
    }

    private static void popNode(int i) {
        int size = mPageSequence.size();
        int i2 = size - 1;
        if (i > i2) {
            Logger.i(TAG, "popIndex", Integer.valueOf(i), "maxIndex", Integer.valueOf(i2));
        } else {
            mPageSequence.subList(i + 1, size).clear();
        }
    }

    private static void printSpmSeq() {
        ArrayList arrayList = new ArrayList();
        int size = mPageSequence.size();
        for (int i = 0; i < size; i++) {
            PageNode pageNode = mPageSequence.get(i);
            if (pageNode != null) {
                arrayList.add(pageNode.pageName + ":" + pageNode.spmUrl);
            } else {
                arrayList.add("");
            }
        }
        Logger.f(TAG, "PageSequence", JSON.toJSONString(arrayList));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[Catch: all -> 0x00c1, Exception -> 0x00c3, TryCatch #1 {Exception -> 0x00c3, blocks: (B:8:0x000a, B:10:0x0023, B:15:0x002f, B:20:0x003e, B:22:0x0044, B:24:0x0051, B:27:0x0099, B:29:0x009d, B:31:0x00a1, B:33:0x00a7, B:25:0x0056, B:26:0x0089), top: B:45:0x000a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[Catch: all -> 0x00c1, Exception -> 0x00c3, TryCatch #1 {Exception -> 0x00c3, blocks: (B:8:0x000a, B:10:0x0023, B:15:0x002f, B:20:0x003e, B:22:0x0044, B:24:0x0051, B:27:0x0099, B:29:0x009d, B:31:0x00a1, B:33:0x00a7, B:25:0x0056, B:26:0x0089), top: B:45:0x000a, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void pushNode(java.lang.Object r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            java.lang.Class<com.ut.mini.UTPageSequenceMgr> r0 = com.ut.mini.UTPageSequenceMgr.class
            monitor-enter(r0)
            if (r10 == 0) goto Lcf
            if (r11 != 0) goto L9
            goto Lcf
        L9:
            r1 = 0
            int r2 = r10.hashCode()     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            com.alibaba.analytics.core.model.LogField r3 = com.alibaba.analytics.core.model.LogField.PAGE     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.Object r3 = r11.get(r3)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r4 = "ut_isbk"
            boolean r4 = r11.containsKey(r4)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r5 = 1
            if (r4 != 0) goto L2e
            java.lang.String r4 = "isbf"
            boolean r4 = r11.containsKey(r4)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r4 == 0) goto L2c
            goto L2e
        L2c:
            r4 = 0
            goto L2f
        L2e:
            r4 = 1
        L2f:
            java.lang.String r6 = "spm-url"
            java.lang.Object r6 = r11.get(r6)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r6 != 0) goto L3b
            java.lang.String r6 = "-"
        L3b:
            r7 = 0
            if (r4 == 0) goto L89
            int r4 = findNodeIndex(r2, r3)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r4 < 0) goto L56
            popNode(r4)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.util.List<com.ut.mini.UTPageSequenceMgr$PageNode> r10 = com.ut.mini.UTPageSequenceMgr.mPageSequence     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.Object r10 = r10.get(r4)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            com.ut.mini.UTPageSequenceMgr$PageNode r10 = (com.ut.mini.UTPageSequenceMgr.PageNode) r10     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r10 == 0) goto L99
            r10.pageName = r3     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.spmUrl = r6     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            goto L99
        L56:
            java.lang.String r4 = "UTPageSequenceMgr"
            r8 = 6
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r9 = "Cannot find object"
            r8[r1] = r9     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r8[r5] = r10     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10 = 2
            java.lang.String r5 = "pageId"
            r8[r10] = r5     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10 = 3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r8[r10] = r5     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10 = 4
            java.lang.String r5 = "pageName"
            r8[r10] = r5     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10 = 5
            r8[r10] = r3     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            com.alibaba.analytics.utils.Logger.i(r4, r8)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            com.ut.mini.UTPageSequenceMgr$PageNode r10 = new com.ut.mini.UTPageSequenceMgr$PageNode     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.<init>()     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.pageId = r2     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.pageName = r3     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.spmUrl = r6     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.util.List<com.ut.mini.UTPageSequenceMgr$PageNode> r2 = com.ut.mini.UTPageSequenceMgr.mPageSequence     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r2.add(r10)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            goto L99
        L89:
            com.ut.mini.UTPageSequenceMgr$PageNode r10 = new com.ut.mini.UTPageSequenceMgr$PageNode     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.<init>()     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.pageId = r2     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.pageName = r3     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.spmUrl = r6     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.util.List<com.ut.mini.UTPageSequenceMgr$PageNode> r2 = com.ut.mini.UTPageSequenceMgr.mPageSequence     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r2.add(r10)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
        L99:
            int r10 = com.ut.mini.UTPageSequenceMgr.mSpmCount     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r10 <= 0) goto Lcb
            java.util.List<java.lang.String> r10 = com.ut.mini.UTPageSequenceMgr.mSpmPageList     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r10 == 0) goto Lcb
            boolean r10 = r10.contains(r3)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            if (r10 == 0) goto Lcb
            java.util.HashMap r10 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.<init>()     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r2 = "spm_seq"
            int r3 = com.ut.mini.UTPageSequenceMgr.mSpmCount     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.util.List r3 = getSpmSeq(r3)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r10.put(r2, r3)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            java.lang.String r2 = "ut_seq"
            java.lang.String r10 = com.alibaba.fastjson.JSON.toJSONString(r10)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            r11.put(r2, r10)     // Catch: java.lang.Throwable -> Lc1 java.lang.Exception -> Lc3
            goto Lcb
        Lc1:
            r10 = move-exception
            goto Lcd
        Lc3:
            r10 = move-exception
            java.lang.String r11 = "UTPageSequenceMgr"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lc1
            com.alibaba.analytics.utils.Logger.h(r11, r10, r1)     // Catch: java.lang.Throwable -> Lc1
        Lcb:
            monitor-exit(r0)
            return
        Lcd:
            monitor-exit(r0)
            throw r10
        Lcf:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageSequenceMgr.pushNode(java.lang.Object, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r5.equalsIgnoreCase(com.ut.mini.UTPageSequenceMgr.mConfig) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void updateConfig(java.lang.String r5) {
        /*
            java.lang.Class<com.ut.mini.UTPageSequenceMgr> r0 = com.ut.mini.UTPageSequenceMgr.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            if (r5 == 0) goto Lf
            java.lang.String r3 = com.ut.mini.UTPageSequenceMgr.mConfig     // Catch: java.lang.Throwable -> L73
            boolean r3 = r5.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto L15
        Lf:
            if (r5 != 0) goto L17
            java.lang.String r3 = com.ut.mini.UTPageSequenceMgr.mConfig     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto L17
        L15:
            monitor-exit(r0)
            return
        L17:
            com.ut.mini.UTPageSequenceMgr.mConfig = r5     // Catch: java.lang.Throwable -> L73
            tb.sj r5 = tb.sj.c()     // Catch: java.lang.Throwable -> L73
            android.content.Context r5 = r5.b()     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "ut_seq"
            java.lang.String r4 = com.ut.mini.UTPageSequenceMgr.mConfig     // Catch: java.lang.Throwable -> L73
            tb.we2.b(r5, r3, r4)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = com.ut.mini.UTPageSequenceMgr.mConfig     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L6e
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            java.lang.Object r5 = com.alibaba.fastjson.JSON.parseObject(r5, r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            if (r5 == 0) goto L77
            int r3 = r5.size()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            if (r3 <= 0) goto L77
            java.lang.String r3 = "spm_seq"
            java.lang.Object r5 = r5.get(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            if (r5 == 0) goto L77
            int r3 = r5.size()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            if (r3 <= 0) goto L77
            java.lang.String r3 = "count"
            java.lang.Object r3 = r5.get(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            com.ut.mini.UTPageSequenceMgr.mSpmCount = r3     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            java.lang.String r3 = "page"
            java.lang.Object r5 = r5.get(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            com.ut.mini.UTPageSequenceMgr.mSpmPageList = r5     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L73
            goto L77
        L65:
            r5 = move-exception
            java.lang.String r3 = "UTPageSequenceMgr"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L73
            com.alibaba.analytics.utils.Logger.h(r3, r5, r4)     // Catch: java.lang.Throwable -> L73
            goto L77
        L6e:
            com.ut.mini.UTPageSequenceMgr.mSpmCount = r2     // Catch: java.lang.Throwable -> L73
            com.ut.mini.UTPageSequenceMgr.mSpmPageList = r1     // Catch: java.lang.Throwable -> L73
            goto L77
        L73:
            com.ut.mini.UTPageSequenceMgr.mSpmCount = r2     // Catch: java.lang.Throwable -> L79
            com.ut.mini.UTPageSequenceMgr.mSpmPageList = r1     // Catch: java.lang.Throwable -> L79
        L77:
            monitor-exit(r0)
            return
        L79:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageSequenceMgr.updateConfig(java.lang.String):void");
    }
}
