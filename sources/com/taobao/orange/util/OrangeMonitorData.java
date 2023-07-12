package com.taobao.orange.util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeMonitorData {
    public PerformanceStat performance = new PerformanceStat();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class PerformanceStat {
        public boolean bootType;
        public int downgradeType;
        public long ioTime;
        public int monitorType;
        public int persistCount;
        public long persistTime;
        public int requestCount;
        public int restoreCount;
        public long restoreTime;

        public PerformanceStat() {
        }

        public String toString() {
            return "PerformanceStat{bootType='" + this.bootType + "', downgradeType='" + this.downgradeType + "', monitorType='" + this.monitorType + "', requestCount='" + this.requestCount + "', persistCount='" + this.persistCount + "', restoreCount='" + this.restoreCount + "', persistTime='" + this.persistTime + "', restoreTime='" + this.restoreTime + "', ioTime='" + this.ioTime + "'}";
        }
    }
}
