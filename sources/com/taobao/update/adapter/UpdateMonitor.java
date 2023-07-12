package com.taobao.update.adapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface UpdateMonitor {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements UpdateMonitor {
        @Override // com.taobao.update.adapter.UpdateMonitor
        public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
        }

        @Override // com.taobao.update.adapter.UpdateMonitor
        public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        }

        @Override // com.taobao.update.adapter.UpdateMonitor
        public void commit(String str) {
        }

        @Override // com.taobao.update.adapter.UpdateMonitor
        public void commitCount(String str, String str2, String str3, double d) {
        }

        @Override // com.taobao.update.adapter.UpdateMonitor
        public void commitFail(String str, String str2, String str3, String str4) {
        }

        @Override // com.taobao.update.adapter.UpdateMonitor
        public void commitSuccess(String str, String str2, String str3) {
        }
    }

    void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, long j, long j2);

    void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7);

    void commit(String str);

    void commitCount(String str, String str2, String str3, double d);

    void commitFail(String str, String str2, String str3, String str4);

    void commitSuccess(String str, String str2, String str3);
}
