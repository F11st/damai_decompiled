package com.taobao.accs.data;

import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AssembleMessage {
    private static final int DEFAULT_ASSEMBLE_TIMEOUT = 30000;
    private static final char[] DIGITS_LOWER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;
    private static final int STATUS_COMPLETE = 2;
    private static final int STATUS_FAIL = 3;
    private static final int STATUS_TIMEOUT = 1;
    private static final int STATUS_VALID = 0;
    private static final String TAG = "AssembleMessage";
    private String dataId;
    private String dataMd5;
    private int dataNums;
    private long firstDataBurstTime;
    private ScheduledFuture<?> timeoutFuture;
    private volatile int status = 0;
    private Map<Integer, byte[]> burstMessages = new TreeMap(new Comparator<Integer>() { // from class: com.taobao.accs.data.AssembleMessage.1
        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }
    });

    public AssembleMessage(String str, int i, String str2) {
        this.dataId = str;
        this.dataNums = i;
        this.dataMd5 = str2;
    }

    private static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = DIGITS_LOWER;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return cArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:13:0x003e, B:15:0x0042, B:17:0x004e, B:18:0x0057, B:20:0x0059, B:22:0x0061, B:23:0x0067, B:25:0x007a, B:26:0x0085, B:28:0x008b, B:31:0x0095, B:32:0x00a5, B:34:0x00af, B:36:0x00c4, B:40:0x00eb, B:42:0x011d, B:44:0x013e, B:45:0x0141, B:48:0x0158, B:47:0x0143), top: B:55:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013e A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:13:0x003e, B:15:0x0042, B:17:0x004e, B:18:0x0057, B:20:0x0059, B:22:0x0061, B:23:0x0067, B:25:0x007a, B:26:0x0085, B:28:0x008b, B:31:0x0095, B:32:0x00a5, B:34:0x00af, B:36:0x00c4, B:40:0x00eb, B:42:0x011d, B:44:0x013e, B:45:0x0141, B:48:0x0158, B:47:0x0143), top: B:55:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] putBurst(int r13, int r14, byte[] r15) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.AssembleMessage.putBurst(int, int, byte[]):byte[]");
    }

    public void setTimeOut(long j) {
        if (j <= 0) {
            j = 30000;
        }
        this.timeoutFuture = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.data.AssembleMessage.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AssembleMessage.this) {
                    if (AssembleMessage.this.status == 0) {
                        ALog.e(AssembleMessage.TAG, "timeout", Constants.KEY_DATA_ID, AssembleMessage.this.dataId);
                        AssembleMessage.this.status = 1;
                        AssembleMessage.this.burstMessages.clear();
                        x6.b().commitStat(new AssembleMonitor(AssembleMessage.this.dataId, String.valueOf(AssembleMessage.this.status)));
                    }
                }
            }
        }, j, TimeUnit.MILLISECONDS);
    }
}
