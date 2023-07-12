package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.detect.NetworkDetector;
import anet.channel.fulltrace.C0179a;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.statist.LongRequestMonitorStat;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestMonitorFullSampling;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.stat.C0246a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tb.c62;
import tb.he;
import tb.hu0;
import tb.jn1;
import tb.lw2;
import tb.rj1;
import tb.s12;
import tb.x6;
import tb.z12;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Repeater implements Callback {
    private ParcelableNetworkListener a;
    private String b;
    private ParcelableInputStreamImpl c = null;
    private boolean d;
    private z12 e;

    public Repeater(ParcelableNetworkListener parcelableNetworkListener, z12 z12Var) {
        this.d = false;
        this.e = null;
        this.a = parcelableNetworkListener;
        this.e = z12Var;
        if (parcelableNetworkListener != null) {
            try {
                if ((parcelableNetworkListener.getListenerState() & 8) != 0) {
                    this.d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final RequestStatistic requestStatistic) {
        if (rj1.r()) {
            ThreadPoolExecutorFactory.h(new Runnable() { // from class: anetwork.channel.entity.Repeater.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Repeater.this.j(requestStatistic);
                    } catch (Exception e) {
                        ALog.d("anet.Repeater", "[checkLongRequet]error", null, e, new Object[0]);
                    }
                }
            });
        }
    }

    private void i(Runnable runnable) {
        if (this.e.o()) {
            runnable.run();
            return;
        }
        String str = this.b;
        s12.b(str != null ? str.hashCode() : hashCode(), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(RequestStatistic requestStatistic) {
        String h;
        String obj;
        int length;
        int length2;
        int length3;
        if (requestStatistic != null && (length3 = (length = (h = this.e.h()).length()) + (length2 = (obj = this.e.d().toString()).length())) >= 6144) {
            LongRequestMonitorStat longRequestMonitorStat = new LongRequestMonitorStat(this.e.e().l());
            longRequestMonitorStat.originUrl = h;
            longRequestMonitorStat.header = obj;
            longRequestMonitorStat.headerSize = length2;
            longRequestMonitorStat.urlSize = length;
            longRequestMonitorStat.httpCode = requestStatistic.statusCode;
            longRequestMonitorStat.method = this.e.b().k();
            longRequestMonitorStat.refer = requestStatistic.f_refer;
            String str = null;
            int i = 0;
            for (Map.Entry<String, String> entry : this.e.d().entrySet()) {
                int length4 = entry.getValue().length();
                if (length4 > i) {
                    str = entry.getKey();
                    i = length4;
                }
            }
            longRequestMonitorStat.maxHeader = str;
            longRequestMonitorStat.maxHeaderSize = i;
            if (length3 >= 8192) {
                longRequestMonitorStat.reportType = 1;
            } else if (length3 >= 7168) {
                longRequestMonitorStat.reportType = 2;
            } else {
                longRequestMonitorStat.reportType = 3;
            }
            x6.b().commitStat(longRequestMonitorStat);
        }
    }

    public void k(String str) {
        this.b = str;
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onDataReceiveSize(final int i, final int i2, final he heVar) {
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            i(new Runnable() { // from class: anetwork.channel.entity.Repeater.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Repeater.this.d) {
                            try {
                                if (Repeater.this.c != null) {
                                    Repeater.this.c.write(heVar);
                                } else {
                                    Repeater.this.c = new ParcelableInputStreamImpl();
                                    Repeater.this.c.init(Repeater.this.e, i2);
                                    Repeater.this.c.write(heVar);
                                    parcelableNetworkListener.onInputStreamGet(Repeater.this.c);
                                }
                            } catch (Exception unused) {
                                if (Repeater.this.c == null) {
                                    return;
                                }
                                Repeater.this.c.close();
                            }
                        } else {
                            parcelableNetworkListener.onDataReceived(new DefaultProgressEvent(i, heVar.d(), i2, heVar.c()));
                        }
                    } catch (RemoteException unused2) {
                    }
                }
            });
        }
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onFinish(final DefaultFinishEvent defaultFinishEvent) {
        if (ALog.g(2)) {
            ALog.f("anet.Repeater", "[onFinish] ", this.b, new Object[0]);
        }
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            Runnable runnable = new Runnable() { // from class: anetwork.channel.entity.Repeater.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultFinishEvent defaultFinishEvent2 = defaultFinishEvent;
                    String str = null;
                    if (defaultFinishEvent2 != null) {
                        defaultFinishEvent2.setContext(null);
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        RequestStatistic requestStatistic = defaultFinishEvent.rs;
                        if (requestStatistic != null) {
                            requestStatistic.rspCbStart = currentTimeMillis;
                            C0179a.f().log(requestStatistic.span, "netRspCbStart", null);
                            requestStatistic.lastProcessTime = currentTimeMillis - requestStatistic.rspEnd;
                            requestStatistic.oneWayTime = requestStatistic.retryCostTime + (currentTimeMillis - requestStatistic.start);
                            defaultFinishEvent.getStatisticData().filledBy(requestStatistic);
                        }
                        parcelableNetworkListener.onFinished(defaultFinishEvent);
                        if (requestStatistic != null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            requestStatistic.rspCbEnd = currentTimeMillis2;
                            C0179a.f().log(requestStatistic.span, "netRspCbEnd", null);
                            requestStatistic.callbackTime = currentTimeMillis2 - currentTimeMillis;
                            C0179a.e().commitRequest(requestStatistic.falcoId, requestStatistic);
                            if (requestStatistic.span != null) {
                                C0179a.f().finishRequest(requestStatistic.span, requestStatistic);
                            }
                        }
                        if (Repeater.this.c != null) {
                            Repeater.this.c.writeEnd();
                        }
                        if (requestStatistic != null) {
                            ALog.e("anet.Repeater", "[falcoId:" + requestStatistic.falcoId + jn1.ARRAY_END_STR + "end, " + requestStatistic.toString(), Repeater.this.b, new Object[0]);
                            C0179a.f().log(requestStatistic.span, IFullTraceAnalysis.Stage.FINISH, requestStatistic.toString());
                            CopyOnWriteArrayList<String> b = hu0.b();
                            if (b != null) {
                                int size = b.size();
                                for (int i = 0; i < size - 1; i += 2) {
                                    requestStatistic.putExtra(b.get(i), b.get(i + 1));
                                }
                            }
                            if (hu0.i()) {
                                requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.g()));
                            }
                            c62 sceneInfo = C0179a.e().getSceneInfo();
                            if (sceneInfo != null) {
                                ALog.f("anet.Repeater", sceneInfo.toString(), Repeater.this.b, new Object[0]);
                                long j = requestStatistic.start;
                                long j2 = sceneInfo.c;
                                requestStatistic.sinceInitTime = j - j2;
                                int i2 = sceneInfo.a;
                                requestStatistic.startType = i2;
                                if (i2 != 1) {
                                    requestStatistic.sinceLastLaunchTime = j2 - sceneInfo.d;
                                }
                                requestStatistic.deviceLevel = sceneInfo.e;
                                requestStatistic.isFromExternal = sceneInfo.b ? 1 : 0;
                                requestStatistic.speedBucket = sceneInfo.f;
                                requestStatistic.abTestBucket = sceneInfo.g;
                            }
                            requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                            requestStatistic.userInfo = Repeater.this.e.g("RequestUserInfo");
                            x6.b().commitStat(requestStatistic);
                            if (rj1.C(requestStatistic) || rj1.k(requestStatistic.bizId)) {
                                x6.b().commitStat(new RequestMonitorFullSampling(requestStatistic));
                            }
                            try {
                                String str2 = requestStatistic.ip;
                                JSONObject jSONObject = requestStatistic.extra;
                                if (jSONObject != null) {
                                    str = jSONObject.optString("firstIp");
                                }
                                if (lw2.d(str2) || lw2.d(str)) {
                                    x6.b().commitStat(new RequestMonitor(requestStatistic));
                                }
                            } catch (Exception unused) {
                            }
                            C0246a.a().put(Repeater.this.e.h(), defaultFinishEvent.getStatisticData());
                            NetworkDetector.a(requestStatistic);
                            Repeater.this.h(requestStatistic);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            };
            RequestStatistic requestStatistic = defaultFinishEvent.rs;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
                C0179a.f().log(requestStatistic.span, "netRspCbDispatch", null);
            }
            i(runnable);
        }
        this.a = null;
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onResponseCode(final int i, final Map<String, List<String>> map) {
        if (ALog.g(2)) {
            ALog.f("anet.Repeater", "[onResponseCode]", this.b, new Object[0]);
        }
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            i(new Runnable() { // from class: anetwork.channel.entity.Repeater.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        parcelableNetworkListener.onResponseCode(i, new ParcelableHeader(i, map));
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }
}
