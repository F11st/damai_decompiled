package com.youku.arch.beast;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.arch.beast.BeastZygote;
import com.youku.arch.beast.messenger.MessageInfoProvider;
import com.youku.arch.beast.threading.WorkerFactory;
import com.youku.arch.beast.threading.WorkerThread;
import com.youku.sopalladium.SoLoaderGui;
import com.youku.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Beast {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NO_SESSION = -1;
    public static final int SESSION_CREATED = 0;
    public static final int SESSION_EXISTED = 1;
    private static BeastZygote mBeastZygote;
    private static boolean sEnabled;

    static {
        try {
            System.loadLibrary("beast");
        } catch (Throwable unused) {
            SoLoaderGui.loadSoWithRelinker("beast");
        }
        sEnabled = true;
    }

    public static synchronized void end() {
        WorkerThread workerThread;
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1788120528")) {
                ipChange.ipc$dispatch("-1788120528", new Object[0]);
                return;
            }
            Logger.d("beastLib", "beast end");
            if (sEnabled) {
                BeastZygote beastZygote = mBeastZygote;
                if (beastZygote != null && (workerThread = beastZygote.mThread) != null) {
                    workerThread.end();
                    mBeastZygote = null;
                }
            }
        }
    }

    public static void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278491399")) {
            ipChange.ipc$dispatch("-1278491399", new Object[]{context});
            return;
        }
        PcsManager.init(context.getApplicationContext());
        sEnabled = OrangeConfig.getInstance().getConfig("accs_ups_player", "heartbeat_switch", "true").equals("true");
    }

    public static synchronized void pause() {
        WorkerThread workerThread;
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-795773515")) {
                ipChange.ipc$dispatch("-795773515", new Object[0]);
                return;
            }
            Logger.d("beastLib", "beast pause");
            if (sEnabled) {
                BeastZygote beastZygote = mBeastZygote;
                if (beastZygote != null && (workerThread = beastZygote.mThread) != null) {
                    workerThread.pause();
                }
            }
        }
    }

    public static synchronized void registerPlugin(BeastZygote.Type type, MessageInfoProvider.MessageInfoPlugin messageInfoPlugin) {
        WorkerThread workerThread;
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1593397134")) {
                ipChange.ipc$dispatch("-1593397134", new Object[]{type, messageInfoPlugin});
                return;
            }
            Logger.d("beastLib", "registerPlugin:" + type);
            if (sEnabled) {
                if (messageInfoPlugin != null) {
                    MessageInfoProvider.getInstance().registerPlugin(type, messageInfoPlugin);
                }
                BeastZygote beastZygote = mBeastZygote;
                if (beastZygote != null && (workerThread = beastZygote.mThread) != null) {
                    workerThread.register();
                }
            }
        }
    }

    public static synchronized void resume() {
        WorkerThread workerThread;
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1546355982")) {
                ipChange.ipc$dispatch("-1546355982", new Object[0]);
                return;
            }
            Logger.d("beastLib", "beast resume");
            if (sEnabled) {
                BeastZygote beastZygote = mBeastZygote;
                if (beastZygote != null && (workerThread = beastZygote.mThread) != null) {
                    workerThread.resume();
                }
            }
        }
    }

    public static synchronized int start(Context context) {
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-959414254")) {
                return ((Integer) ipChange.ipc$dispatch("-959414254", new Object[]{context})).intValue();
            }
            Logger.d("beastLib", "beast start");
            if (sEnabled) {
                if (mBeastZygote == null) {
                    BeastZygote beastZygote = new BeastZygote();
                    mBeastZygote = beastZygote;
                    beastZygote.init(context.getApplicationContext());
                    WorkerThread workerThread = WorkerFactory.get();
                    mBeastZygote.setThread(workerThread);
                    WorkerFactory.run(workerThread);
                    workerThread.start();
                    return 0;
                }
                return 1;
            }
            return -1;
        }
    }

    public static synchronized void unregisterPlugin(BeastZygote.Type type) {
        WorkerThread workerThread;
        synchronized (Beast.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274013227")) {
                ipChange.ipc$dispatch("-274013227", new Object[]{type});
                return;
            }
            Logger.d("beastLib", "unregisterPlugin:" + type);
            if (sEnabled) {
                MessageInfoProvider.getInstance().unregisterPlugin(type);
                BeastZygote beastZygote = mBeastZygote;
                if (beastZygote != null && (workerThread = beastZygote.mThread) != null) {
                    workerThread.unregister();
                }
            }
        }
    }
}
