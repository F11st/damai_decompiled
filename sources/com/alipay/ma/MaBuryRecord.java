package com.alipay.ma;

import android.os.AsyncTask;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaBuryRecord {
    protected static volatile EngineBuryRecord a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface EngineBuryRecord {
        void recodeDecodeFailedMaInfo(String str);

        void recordBigPixelsImageScan(double d, double d2);

        void recordLazyRecorgnized(boolean z, String str);

        void recordRecognizedPerformance(Object obj);

        void recordRsBinarizeException(String str);

        void recordRsExceptionLimitation();

        void recordScanDecodeTrack(String str, String str2, Map map);

        void recordScanSuccess(Object obj, boolean z, String str, long j, boolean z2);

        void recordTwoCodeHasBlackList(String str);

        void reportEightSecondsNotRecognize(long j, String str);

        void reportNativeInterfaceResult(String str);

        void reportSoLoadResult(int i, long j);

        void reportUnusualScanCase(int i, String str);
    }

    private static void a(final int i, final long j) {
        new AsyncTask<Object, Object, Object>() { // from class: com.alipay.ma.MaBuryRecord.2
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object... objArr) {
                try {
                    Class<?> cls = Class.forName("com.alipay.mobile.mascanengine.BuryRecord");
                    cls.getDeclaredMethod("reportSoLoadResult", Integer.TYPE, Long.TYPE).invoke(cls.newInstance(), Integer.valueOf(i), Long.valueOf(j));
                    return null;
                } catch (ClassNotFoundException e) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e);
                    return null;
                } catch (IllegalAccessException e2) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e2);
                    return null;
                } catch (InstantiationException e3) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e3);
                    return null;
                } catch (NoSuchMethodException e4) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e4);
                    return null;
                } catch (InvocationTargetException e5) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e5);
                    return null;
                }
            }
        }.execute(new Object[0]);
    }

    private static void b(final String str, final String str2, final Map map) {
        new AsyncTask<Object, Object, Object>() { // from class: com.alipay.ma.MaBuryRecord.1
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object... objArr) {
                try {
                    Class<?> cls = Class.forName("com.alipay.mobile.mascanengine.BuryRecord");
                    cls.getDeclaredMethod("recordScanDecodeTrack", String.class, String.class, Map.class).invoke(cls.newInstance(), str, str2, map);
                    return null;
                } catch (ClassNotFoundException e) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e);
                    return null;
                } catch (IllegalAccessException e2) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e2);
                    return null;
                } catch (InstantiationException e3) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e3);
                    return null;
                } catch (NoSuchMethodException e4) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e4);
                    return null;
                } catch (InvocationTargetException e5) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e5);
                    return null;
                }
            }
        }.execute(new Object[0]);
    }

    public static void recodeDecodeFailedMaInfo(String str) {
        if (a != null) {
            a.recodeDecodeFailedMaInfo(str);
        }
    }

    public static void recordBigPixelsImageScan(double d, double d2) {
        if (a != null) {
            a.recordBigPixelsImageScan(d, d2);
        }
    }

    public static void recordLazyRecorgnized(boolean z, String str) {
        if (a != null) {
            a.recordLazyRecorgnized(z, str);
        }
    }

    public static void recordRecognizedPerformance(Object obj) {
        if (a != null) {
            a.recordRecognizedPerformance(obj);
        }
    }

    public static void recordRsBinarizeException(String str) {
        if (a != null) {
            a.recordRsBinarizeException(str);
        }
    }

    public static void recordRsExceptionLimitation() {
        if (a != null) {
            a.recordRsExceptionLimitation();
        }
    }

    public static void recordScanDecodeTrack(String str, String str2, Map map) {
        if (a != null) {
            a.recordScanDecodeTrack(str, str2, map);
        } else {
            b(str, str2, map);
        }
    }

    public static void recordScanSuccess(Object obj, boolean z, String str, long j, boolean z2) {
        if (a != null) {
            a.recordScanSuccess(obj, z, str, j, z2);
        }
    }

    public static void recordTwoCodeHasBlackList(String str) {
        if (a != null) {
            a.recordTwoCodeHasBlackList(str);
        }
    }

    public static void registerEngineBuryRecord(EngineBuryRecord engineBuryRecord) {
        a = engineBuryRecord;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void reportEightSecondsNotRecognize(java.util.Map r9) {
        /*
            Method dump skipped, instructions count: 184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.ma.MaBuryRecord.reportEightSecondsNotRecognize(java.util.Map):void");
    }

    public static void reportNativeInterfaceResult(String str) {
        if (a == null || str == null) {
            return;
        }
        a.reportNativeInterfaceResult(str);
    }

    public static void reportSoLoadResult(int i, long j) {
        if (a != null) {
            a.reportSoLoadResult(i, j);
        } else {
            a(i, j);
        }
    }

    public static void reportUnusualScanCase(int i, String str) {
        if (a != null) {
            a.reportUnusualScanCase(i, str);
        }
    }

    public static void unRegisterEngineBuryRecord() {
        a = null;
    }
}
