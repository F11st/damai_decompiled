package com.taobao.accs.asp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.accs.asp.StatMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.exception.IPCException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class PrefsIPCChannel implements IPrefsChannel {
    private static final String ACTION_CORE_PROCESS_CREATED = "com.taobao.adaemon.CORE_PROCESS_CREATED";
    public static final String CORE_CONTENT_PROVIDER = "com.taobao.accs.AccsIPCProvider";
    private static final String TAG = "PrefsIPCChannel";
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<OnDataUpdateListener>> listeners = new ConcurrentHashMap<>();
    private final ARangerReceiver receiver = new ARangerReceiver();
    private final AtomicBoolean coreProcessReady = new AtomicBoolean(false);
    private volatile boolean isRegisterReceiver = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class ARangerReceiver extends BroadcastReceiver {
        private ARangerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String coreProviderProcess = Utils.getCoreProviderProcess();
            if (TextUtils.isEmpty(coreProviderProcess)) {
                return;
            }
            if (Constants.ACTION_DISCONNECT.equals(action)) {
                String stringExtra = intent.getStringExtra(Constants.PARAM_PROCESS_NAME);
                ALog.i(PrefsIPCChannel.TAG, "[onReceive] process disconnect.", "process", stringExtra);
                if (coreProviderProcess.equals(stringExtra)) {
                    try {
                        Client.channel = (IPrefsChannel) ARanger.createSingleton(new ComponentName(ARanger.getContext(), PrefsIPCChannel.CORE_CONTENT_PROVIDER), IPrefsChannel.class, new Pair[0]);
                    } catch (IPCException e) {
                        ALog.e(PrefsIPCChannel.TAG, "[onReceive]connect error.", e, new Object[0]);
                    }
                }
            } else if (Constants.ACTION_CONNECT.equals(action)) {
                String stringExtra2 = intent.getStringExtra(Constants.PARAM_PROCESS_NAME);
                ALog.i(PrefsIPCChannel.TAG, "[onReceive] process connect.", "process", stringExtra2);
                if (coreProviderProcess.equals(stringExtra2)) {
                    APreferencesManager.recoverPreferences();
                }
            } else if (PrefsIPCChannel.ACTION_CORE_PROCESS_CREATED.equals(action)) {
                PrefsIPCChannel.this.coreProcessReady.set(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static class Client {
        static IPrefsChannel channel;

        Client() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void commitToDisk(ModifiedRecord modifiedRecord) {
            if (modifiedRecord == null) {
                return;
            }
            StatMonitor.IpcStat ipcStat = new StatMonitor.IpcStat(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                getChannel().commitToDiskRemote(modifiedRecord);
                ipcStat.result = 1;
            } catch (IPCException e) {
                ALog.e(PrefsIPCChannel.TAG, "[commitToDisk]IPC error.", e, new Object[0]);
                ipcStat.result = 0;
                channel = null;
            }
            ipcStat.costTime = System.currentTimeMillis() - currentTimeMillis;
            ipcStat.commit();
        }

        static IPrefsChannel getChannel() {
            if (channel == null) {
                synchronized (Client.class) {
                    if (channel == null) {
                        try {
                            channel = (IPrefsChannel) ARanger.createSingleton(new ComponentName(ARanger.getContext(), PrefsIPCChannel.CORE_CONTENT_PROVIDER), IPrefsChannel.class, new Pair[0]);
                        } catch (IPCException e) {
                            ALog.e(PrefsIPCChannel.TAG, "create ipc proxy error.", e, new Object[0]);
                        }
                    }
                }
            }
            return channel;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void registerDataListener(@NonNull String str, @NonNull OnDataUpdateListener onDataUpdateListener) {
            StatMonitor.IpcStat ipcStat = new StatMonitor.IpcStat(2);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                getChannel().registerDataListenerRemote(str, onDataUpdateListener);
                ipcStat.result = 1;
            } catch (IPCException e) {
                ALog.e(PrefsIPCChannel.TAG, "[registerDataListener]IPC error.", e, new Object[0]);
                ipcStat.result = 0;
                channel = null;
            }
            ipcStat.costTime = System.currentTimeMillis() - currentTimeMillis;
            ipcStat.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Holder {
        static PrefsIPCChannel instance = new PrefsIPCChannel();

        Holder() {
        }
    }

    PrefsIPCChannel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static PrefsIPCChannel getInstance() {
        return Holder.instance;
    }

    @Override // com.taobao.accs.asp.IPrefsChannel
    public void commitToDiskRemote(ModifiedRecord modifiedRecord) {
        SharedPreferences multiProcessSharedPreferences = APreferencesManager.getMultiProcessSharedPreferences(modifiedRecord.name);
        if (multiProcessSharedPreferences instanceof BaseSharedPreferences) {
            ((BaseSharedPreferences) multiProcessSharedPreferences).sync(modifiedRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dataUpdateEvent(ModifiedRecord modifiedRecord) {
        CopyOnWriteArrayList<OnDataUpdateListener> copyOnWriteArrayList = this.listeners.get(modifiedRecord.name);
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<OnDataUpdateListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            OnDataUpdateListener next = it.next();
            if (next != null) {
                StatMonitor.IpcStat ipcStat = new StatMonitor.IpcStat(3);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    next.onDataUpdate(modifiedRecord);
                    ipcStat.result = 1;
                } catch (IPCException e) {
                    ALog.e(TAG, "[dataUpdateEvent]error.", null, e);
                    ipcStat.result = 0;
                    int errorCode = e.getErrorCode();
                    if (errorCode == 5 || errorCode == 2) {
                        ALog.i(TAG, "remove listener", "result", Boolean.valueOf(copyOnWriteArrayList.remove(next)));
                    }
                }
                ipcStat.costTime = System.currentTimeMillis() - currentTimeMillis;
                ipcStat.commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCoreProcessReady() {
        return this.coreProcessReady.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constants.ACTION_DISCONNECT);
            intentFilter.addAction(Constants.ACTION_CONNECT);
            if (Utils.isCoreProcess()) {
                this.coreProcessReady.set(true);
            } else {
                intentFilter.addAction(ACTION_CORE_PROCESS_CREATED);
                if (Utils.isCoreProcessLive()) {
                    this.coreProcessReady.set(true);
                }
            }
            context.registerReceiver(this.receiver, intentFilter);
            this.isRegisterReceiver = true;
        } catch (Throwable th) {
            ALog.e(TAG, "asp register err", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.asp.IPrefsChannel
    public void registerDataListenerRemote(String str, OnDataUpdateListener onDataUpdateListener) {
        CopyOnWriteArrayList<OnDataUpdateListener> copyOnWriteArrayList = this.listeners.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        copyOnWriteArrayList.add(onDataUpdateListener);
        this.listeners.put(str, copyOnWriteArrayList);
    }

    void unregister(Context context) {
        if (this.isRegisterReceiver) {
            try {
                context.unregisterReceiver(this.receiver);
            } catch (Throwable th) {
                ALog.e(TAG, "asp unregister err", th, new Object[0]);
            }
        }
    }
}
