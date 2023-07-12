package com.youku.arch.beast.apas.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.apas.Apas;
import com.youku.arch.beast.apas.remote.IApasApiInterface;
import com.youku.util.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RemoteApasConn implements IApasConn {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "RemoteApasConn";
    private Context mContext;
    private IApasApiInterface mRemoteService;
    private ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.youku.arch.beast.apas.remote.RemoteApasConn.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "130579740")) {
                ipChange.ipc$dispatch("130579740", new Object[]{this, componentName, iBinder});
            } else {
                RemoteApasConn.this.mRemoteService = IApasApiInterface.Stub.asInterface(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2001713021")) {
                ipChange.ipc$dispatch("-2001713021", new Object[]{this, componentName});
            } else {
                RemoteApasConn.this.mRemoteService = null;
            }
        }
    };

    private void asyncBindService(final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017479228")) {
            ipChange.ipc$dispatch("-2017479228", new Object[]{this, context});
        } else {
            this.mSingleThreadExecutor.execute(new Runnable() { // from class: com.youku.arch.beast.apas.remote.RemoteApasConn.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1650138097")) {
                        ipChange2.ipc$dispatch("1650138097", new Object[]{this});
                        return;
                    }
                    Intent intent = new Intent(context, ApasApiService.class);
                    intent.setAction("com.youku.arch.beast.action.APAS");
                    context.bindService(intent, RemoteApasConn.this.mConnection, 1);
                }
            });
        }
    }

    private String getConfigFromLocalFile(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402222215")) {
            return (String) ipChange.ipc$dispatch("402222215", new Object[]{this, str, str2, str3});
        }
        try {
            File file = new File(this.mContext.getFilesDir().getAbsolutePath() + "/" + Apas.APAS_PATH + "/" + str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    String sb2 = sb.toString();
                    if (!TextUtils.isEmpty(sb2)) {
                        return (String) JSON.parseObject(sb2).get(str2);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return str3;
    }

    private boolean isConfigFileExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843202570")) {
            return ((Boolean) ipChange.ipc$dispatch("1843202570", new Object[]{this, str})).booleanValue();
        }
        try {
            File file = new File(this.mContext.getFilesDir().getAbsolutePath() + "/" + Apas.APAS_PATH + "/" + str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean containsNamespace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "762011516")) {
            return ((Boolean) ipChange.ipc$dispatch("762011516", new Object[]{this, str})).booleanValue();
        }
        if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        IApasApiInterface iApasApiInterface = this.mRemoteService;
        if (iApasApiInterface == null) {
            Logger.e(TAG, "mRemoteService null,need to bind service");
            asyncBindService(this.mContext);
            return isConfigFileExists(str);
        }
        try {
            return iApasApiInterface.containsNamespace(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public String getConfig(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743835184")) {
            return (String) ipChange.ipc$dispatch("-743835184", new Object[]{this, str, str2, str3});
        }
        if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return str3;
        }
        IApasApiInterface iApasApiInterface = this.mRemoteService;
        if (iApasApiInterface == null) {
            Logger.e(TAG, "mRemoteService null,need to bind service");
            asyncBindService(this.mContext);
            return getConfigFromLocalFile(str, str2, str3);
        }
        try {
            return iApasApiInterface.getConfig(str, str2, str3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return str3;
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public Map getConfigs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211427140")) {
            return (Map) ipChange.ipc$dispatch("211427140", new Object[]{this, str});
        }
        if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return null;
        }
        IApasApiInterface iApasApiInterface = this.mRemoteService;
        if (iApasApiInterface == null) {
            Logger.e(TAG, "mRemoteService null,need to bind service");
            asyncBindService(this.mContext);
            return null;
        }
        try {
            return iApasApiInterface.getConfigs(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169694904")) {
            ipChange.ipc$dispatch("1169694904", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        asyncBindService(context);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147015664")) {
            return ((Boolean) ipChange.ipc$dispatch("2147015664", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        IApasApiInterface iApasApiInterface = this.mRemoteService;
        if (iApasApiInterface == null) {
            Logger.e(TAG, "mRemoteService null,need to bind service");
            asyncBindService(this.mContext);
            return false;
        }
        try {
            iApasApiInterface.registerListener(str, iApasUpdateListenerInterface);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public void setRequestExtraInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447956685")) {
            ipChange.ipc$dispatch("447956685", new Object[]{this, str, str2});
        } else if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
        } else {
            IApasApiInterface iApasApiInterface = this.mRemoteService;
            if (iApasApiInterface == null) {
                Logger.e(TAG, "mRemoteService null,need to bind service");
                asyncBindService(this.mContext);
                return;
            }
            try {
                iApasApiInterface.setRequestExtraInfo(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-81784631")) {
            return ((Boolean) ipChange.ipc$dispatch("-81784631", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        if (this.mContext == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        IApasApiInterface iApasApiInterface = this.mRemoteService;
        if (iApasApiInterface == null) {
            Logger.e(TAG, "mRemoteService null,need to bind service");
            asyncBindService(this.mContext);
            return false;
        }
        try {
            iApasApiInterface.unregisterListener(str, iApasUpdateListenerInterface);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
