package com.taobao.update.datasource;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.data.UpdateDataListener;
import com.taobao.update.datasource.local.UpdateInfo;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.datasource.mtop.MtopUpdater;
import com.taobao.update.types.PatchType;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.ae0;
import tb.be0;
import tb.hu2;
import tb.lu2;
import tb.n01;
import tb.ou2;
import tb.pu2;
import tb.qp;
import tb.qu1;
import tb.ub1;
import tb.v2;
import tb.wd0;
import tb.xd0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateDataSource implements UpdateDataListener {
    public static boolean inited;
    public static Application sContext;
    public static String sGroup;
    public static hu2 sUpdateAdapter;
    private ou2 a;
    private HandlerThread f;
    private AddUpdateCallback g;
    private Handler h;
    public static Map<String, UpdateListener> listenerMap = new HashMap();
    private static UpdateDataSource k = new UpdateDataSource();
    private be0 b = xd0.INSTANCE();
    private be0 c = wd0.INSTANCE();
    private be0 d = ae0.INSTANCE();
    private Map<String, IUpdater> e = new HashMap();
    private Log i = ub1.getLog(UpdateDataSource.class, (Log) null);
    volatile boolean j = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                UpdateDataSource updateDataSource = UpdateDataSource.this;
                updateDataSource.i((UpdateInfo) message.obj, true, updateDataSource.g, lu2.ACCS_SOURCE);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (i == 1) {
                Bundle data = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data.getBoolean("background"), UpdateDataSource.this.g, lu2.MTOP_SOURCE);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else if (i == 2) {
                Object obj = message.obj;
                if (obj != null) {
                    UpdateDataSource updateDataSource2 = UpdateDataSource.this;
                    updateDataSource2.i((UpdateInfo) obj, false, updateDataSource2.g, lu2.SCAN);
                }
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            } else if (i == 4) {
                Object obj2 = message.obj;
                if (obj2 != null) {
                    UpdateDataSource updateDataSource3 = UpdateDataSource.this;
                    updateDataSource3.i((UpdateInfo) obj2, true, updateDataSource3.g, lu2.SAFE_MODE);
                }
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            } else if (i == 5) {
                Bundle data2 = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data2.getBoolean("background"), UpdateDataSource.this.g, "NOTICE");
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            } else if (i != 6) {
            } else {
                Bundle data3 = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data3.getBoolean("background"), UpdateDataSource.this.g, lu2.EMAS_PUBLISH);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements MtopUpdater.MtopDataListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // com.taobao.update.datasource.mtop.MtopUpdater.MtopDataListener
        public void hasUpdate(String str) {
        }

        @Override // com.taobao.update.datasource.mtop.MtopUpdater.MtopDataListener
        public void noUpdate() {
            UpdateDataSource.this.i.e("invoke mtop no update!");
            if (this.a) {
                UpdateDataSource.getInstance().toast("您使用的版本已是最新的了哦!");
            }
        }
    }

    private UpdateDataSource() {
        this.f = null;
        HandlerThread handlerThread = new HandlerThread(UpdateDataSource.class.getName());
        this.f = handlerThread;
        handlerThread.start();
        this.h = new a(this.f.getLooper());
    }

    public static UpdateDataSource getInstance() {
        return k;
    }

    private Task h(final PatchType patchType, final UpdateInfo.UpdateData updateData, String str, final boolean z) {
        final UpdateListener updateListener = listenerMap.get(patchType.getKey());
        return new qu1(patchType, new PatchRunnable(updateListener) { // from class: com.taobao.update.datasource.UpdateDataSource.2
            @Override // java.lang.Runnable
            public void run() {
                UpdateListener updateListener2 = updateListener;
                if (updateListener2 != null) {
                    try {
                        boolean z2 = lu2.HOTPATCH.equals(patchType.getKey()) ? true : z;
                        UpdateInfo.UpdateData updateData2 = updateData;
                        updateListener2.onUpdate(z2, updateData2.value, updateData2.from);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        UpdateDataSource.this.m(updateData, patchType);
                    }
                }
            }
        }, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(UpdateInfo updateInfo, boolean z, AddUpdateCallback addUpdateCallback, String str) {
        ArrayList arrayList = new ArrayList();
        if (updateInfo.updateList.containsKey(lu2.SOPATCH)) {
            arrayList.add(lu2.SOPATCH);
            TaskManager.instance().add(h(PatchType.SOPATCH, updateInfo.updateList.get(lu2.SOPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey(lu2.DYNAMIC) && Build.VERSION.SDK_INT < 28) {
            arrayList.add(lu2.DYNAMIC);
            TaskManager.instance().add(h(PatchType.DYNAMIC, updateInfo.updateList.get(lu2.DYNAMIC), str, z));
        }
        if (updateInfo.updateList.containsKey(lu2.HOTPATCH)) {
            arrayList.add(lu2.HOTPATCH);
            TaskManager.instance().add(h(PatchType.INSTANTPATCH, updateInfo.updateList.get(lu2.HOTPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey(lu2.MAIN)) {
            arrayList.add(lu2.MAIN);
            TaskManager.instance().add(h(PatchType.MAIN, updateInfo.updateList.get(lu2.MAIN), str, z));
        }
        if (updateInfo.updateList.containsKey(lu2.DEXPATCH) && Build.VERSION.SDK_INT < 28) {
            arrayList.add(lu2.DEXPATCH);
            TaskManager.instance().add(h(PatchType.DEXPATCH, updateInfo.updateList.get(lu2.DEXPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey("bundle")) {
            arrayList.add("bundle");
            TaskManager.instance().add(h(PatchType.BUNDLES, updateInfo.updateList.get("bundle"), str, z));
        }
        if (addUpdateCallback != null) {
            addUpdateCallback.onAdded(arrayList);
        }
        if (arrayList.contains(lu2.MAIN) || z || str.equals(lu2.SCAN) || !listenerMap.containsKey(lu2.MAIN)) {
            return;
        }
        listenerMap.get(lu2.MAIN).onUpdate(false, null, "");
    }

    private UpdateInfo j(String str, String str2, String str3) {
        JSONObject parseObject = JSON.parseObject(str3);
        if (!TextUtils.isEmpty(str2) && str2.equals(lu2.CACHE_SOURCE)) {
            return (UpdateInfo) JSON.parseObject(str3, UpdateInfo.class);
        }
        if (!str.equals(lu2.ACCS_SOURCE) && !str.equals(lu2.SAFE_MODE) && !str.equals(lu2.SCAN)) {
            if (str.equalsIgnoreCase(lu2.EMAS_PUBLISH)) {
                UpdateInfo convert2EmasUpdateInfo = pu2.convert2EmasUpdateInfo(parseObject, str);
                if (n(convert2EmasUpdateInfo)) {
                    return convert2EmasUpdateInfo;
                }
            } else if (parseObject != null && parseObject.containsKey("hasUpdate") && parseObject.getBoolean("hasUpdate").booleanValue()) {
                UpdateInfo convert2UpdateInfo = pu2.convert2UpdateInfo(parseObject, str);
                if (n(convert2UpdateInfo)) {
                    return convert2UpdateInfo;
                }
            }
        } else if (parseObject != null && parseObject.containsKey("data")) {
            JSONObject jSONObject = parseObject.getJSONObject("data");
            boolean booleanValue = jSONObject.containsKey("hasUpdate") ? jSONObject.getBoolean("hasUpdate").booleanValue() : false;
            UpdateInfo convert2UpdateInfo2 = pu2.convert2UpdateInfo(jSONObject, str);
            if (booleanValue && n(convert2UpdateInfo2)) {
                return convert2UpdateInfo2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.h.hasMessages(0) || this.h.hasMessages(1) || this.h.hasMessages(2) || this.h.hasMessages(3);
    }

    private void l(boolean z) {
        if (sUpdateAdapter.hasEmasPublish() && sUpdateAdapter.openEmasPublish()) {
            this.i.e("UpdateSDK use emas publish update");
            final String versionName = pu2.getVersionName();
            final HashMap hashMap = new HashMap();
            hashMap.put("cpuArch", String.valueOf(qp.getCpuArch()));
            if (!z) {
                boolean registerEmasPublishApi = sUpdateAdapter.registerEmasPublishApi(versionName, this.b, hashMap);
                Log log = this.i;
                log.e("regist emas apk update success ? " + registerEmasPublishApi);
            } else {
                new Thread(new Runnable() { // from class: com.taobao.update.datasource.UpdateDataSource.3
                    @Override // java.lang.Runnable
                    public void run() {
                        List<PublishMtopUpdateInfo> list;
                        PublishMtopResponse pullEmasPublishApi = UpdateDataSource.sUpdateAdapter.pullEmasPublishApi(versionName, UpdateDataSource.this.b, hashMap);
                        if (pullEmasPublishApi != null && pullEmasPublishApi.hasUpdate && (list = pullEmasPublishApi.updateInfo) != null && list.size() != 0) {
                            PublishMtopUpdateInfo publishMtopUpdateInfo = pullEmasPublishApi.updateInfo.get(0);
                            if (publishMtopUpdateInfo == null || publishMtopUpdateInfo.payload == null) {
                                return;
                            }
                            UpdateDataSource.this.b.dispatchUpdate(UpdateDataSource.this.b.from(), false, JSON.toJSONString(publishMtopUpdateInfo), new String[0]);
                            return;
                        }
                        UpdateDataSource.getInstance().toast("您使用的版本已是最新的了哦!");
                    }
                }).start();
            }
            boolean registerEmasPublishApi2 = sUpdateAdapter.registerEmasPublishApi(versionName, this.c, null);
            Log log2 = this.i;
            log2.e("regist emas instantpatch update success?" + registerEmasPublishApi2);
            boolean registerEmasPublishApi3 = sUpdateAdapter.registerEmasPublishApi(versionName, this.d, null);
            Log log3 = this.i;
            log3.e("regist emas sopatch update success?" + registerEmasPublishApi3);
        }
        MtopUpdater mtopUpdater = (MtopUpdater) this.e.get(lu2.MTOP_SOURCE);
        if (mtopUpdater != null) {
            mtopUpdater.setMtopDataListener(new b(z)).startUpdate(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(UpdateInfo.UpdateData updateData, PatchType patchType) {
        Map<String, UpdateInfo.UpdateData> map;
        if (!TextUtils.isEmpty(updateData.subFrom) && updateData.subFrom.equals(lu2.CACHE_SOURCE)) {
            UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
            if (data != null && (map = data.updateList) != null) {
                map.remove(patchType.getKey());
            }
            com.taobao.update.datasource.local.a.getInstance(sContext).resetData(data);
        }
    }

    private boolean n(UpdateInfo updateInfo) {
        Map<String, UpdateInfo.UpdateData> map;
        return (updateInfo == null || (map = updateInfo.updateList) == null || map.size() == 0) ? false : true;
    }

    public void addUpdateInfo(final String str) {
        new AsyncTask<Void, Void, Void>() { // from class: com.taobao.update.datasource.UpdateDataSource.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                if (str.contains("get_bundle_install_data")) {
                    final UpdateListener updateListener = UpdateDataSource.listenerMap.get(lu2.TEST_URL);
                    if (updateListener != null) {
                        TaskManager.instance().add(new qu1(PatchType.TESTURL, new PatchRunnable(updateListener) { // from class: com.taobao.update.datasource.UpdateDataSource.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", (Object) str);
                                updateListener.onUpdate(false, jSONObject, lu2.SCAN);
                            }
                        }, lu2.SCAN, false));
                    }
                    if (!UpdateDataSource.this.k()) {
                        UpdateDataSource.this.h.obtainMessage(2).sendToTarget();
                    } else {
                        UpdateDataSource.this.toast("已经有更新正在运行中");
                    }
                    return null;
                }
                String response = new n01().getResponse(str);
                if (!TextUtils.isEmpty(response)) {
                    UpdateDataSource.this.onUpdate(lu2.SCAN, null, false, response, new String[0]);
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    public void clearCache() {
        com.taobao.update.datasource.local.a.getInstance(sContext).clearCache();
    }

    public Application getApplication() {
        return sContext;
    }

    public void getRecentData(boolean z) {
        Map<String, UpdateInfo.UpdateData> map;
        if (pu2.getProcessName(sContext) != null && pu2.getProcessName(sContext).contains(AXPParamsProvider.ClientType.YOUKU)) {
            l(true);
        }
        if (z && !sUpdateAdapter.subscribed) {
            l(true);
            return;
        }
        UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
        if (this.a.isLocalDataValid(data)) {
            String str = null;
            if (data != null && (map = data.updateList) != null) {
                for (UpdateInfo.UpdateData updateData : map.values()) {
                    updateData.subFrom = lu2.CACHE_SOURCE;
                    str = updateData.from;
                }
            }
            onUpdate(str, lu2.CACHE_SOURCE, !z, JSON.toJSONString(data), new String[0]);
            return;
        }
        clearCache();
        l(z);
    }

    public IUpdater getUpdater(String str) {
        return this.e.get(str);
    }

    public synchronized void init(Application application, String str, String str2, boolean z, hu2 hu2Var) {
        if (inited) {
            return;
        }
        inited = true;
        sGroup = str;
        sContext = application;
        sUpdateAdapter = hu2Var;
        this.a = new ou2();
        if (hu2Var.hasEmasPublish() && sUpdateAdapter.openEmasPublish()) {
            this.i.e("UpdateSDK use emas publish update init");
            EmasPublishService.getInstance().init(application, Boolean.valueOf(z), str, str2);
            this.b.registerDataListener(this);
            this.c.registerDataListener(this);
            this.d.registerDataListener(this);
        }
        MtopUpdater mtopUpdater = new MtopUpdater(application, str2, str, z);
        mtopUpdater.registerDataListener(this);
        this.e.put(lu2.MTOP_SOURCE, mtopUpdater);
        if (hu2Var.hasAccs()) {
            v2 v2Var = new v2(sUpdateAdapter);
            v2Var.registerDataListener(this);
            this.e.put(lu2.ACCS_SOURCE, v2Var);
            sUpdateAdapter.registerPushApi(application, v2Var);
        }
        this.i.d(" inited ");
    }

    public void invalidUpdateInfo(String str) {
        UpdateInfo.UpdateData updateData;
        UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
        if (data == null || (updateData = data.updateList.get(str)) == null) {
            return;
        }
        updateData.valid = false;
        com.taobao.update.datasource.local.a.getInstance(sContext).updateData(data);
    }

    @Override // com.taobao.update.datasource.data.UpdateDataListener
    public synchronized void onUpdate(String str, String str2, boolean z, String str3, String... strArr) {
        ou2 ou2Var;
        ou2 ou2Var2 = this.a;
        if (ou2Var2 == null) {
            this.i.e("no inited");
            return;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
            ou2Var = this.a;
        }
        if (ou2Var2.isUpdating()) {
            Log log = this.i;
            log.d("is updating ... discard data from:" + str);
            this.a.finishUpdate();
            return;
        }
        Log log2 = this.i;
        log2.d(" >>>>>> on " + str + " update info <<<<<<   " + str3);
        if (!TextUtils.isEmpty(str3) && inited) {
            UpdateInfo j = j(str, str2, str3);
            if (j == null) {
                this.i.e("updateInfo invalid!");
                if (!z && listenerMap.containsKey(lu2.MAIN)) {
                    listenerMap.get(lu2.MAIN).onUpdate(false, null, "");
                }
                this.a.finishUpdate();
                return;
            }
            this.a.startUpdate();
            if (str.equals(lu2.SLIDE)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetMemoryData(j);
            } else if ((str.equals(lu2.ACCS_SOURCE) || str.equals(lu2.MTOP_SOURCE)) && TextUtils.isEmpty(str2)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetData(j);
            } else if (str.equals(lu2.EMAS_PUBLISH) && TextUtils.isEmpty(str2)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetData(j);
            }
            if (k()) {
                this.i.e("handling msg......");
                if (str.equals(lu2.SCAN)) {
                    toast("已经有更新正在运行中");
                } else {
                    this.a.finishUpdate();
                    return;
                }
            }
            Message obtainMessage = this.h.obtainMessage();
            if (str.equals(lu2.SCAN)) {
                obtainMessage.what = 2;
            } else if (str.equals(lu2.ACCS_SOURCE)) {
                obtainMessage.what = 0;
                sUpdateAdapter.commitSuccess("update_center_accs", "dispatch_message", "");
                if (strArr != null && strArr.length >= 1) {
                    sUpdateAdapter.commitSuccess("update_center_accs", "dispatch_message", strArr[0]);
                }
            } else if (str.equals(lu2.SLIDE)) {
                obtainMessage.what = 3;
            } else if (str.equals(lu2.SAFE_MODE)) {
                obtainMessage.what = 4;
            } else if (str.equals(lu2.MTOP_SOURCE)) {
                sUpdateAdapter.commitSuccess("update_center_mtop", "mtop_dispatch_message", "");
                obtainMessage.what = 1;
            } else if (str.equals("NOTICE")) {
                obtainMessage.what = 5;
            } else if (str.equals(lu2.EMAS_PUBLISH)) {
                obtainMessage.what = 6;
            }
            obtainMessage.obj = j;
            Bundle bundle = new Bundle();
            bundle.putBoolean("background", z);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            ou2Var = this.a;
            ou2Var.finishUpdate();
            return;
        }
        this.a.finishUpdate();
    }

    public void registerListener(String str, UpdateListener updateListener) {
        listenerMap.put(str, updateListener);
    }

    public void setAddUpdateCallback(AddUpdateCallback addUpdateCallback) {
        this.g = addUpdateCallback;
    }

    public void startUpdate(final boolean z, boolean z2) {
        if (inited) {
            if (this.j) {
                if (z) {
                    return;
                }
                toast("已经有更新正在运行中");
                return;
            }
            this.j = true;
            Runnable runnable = new Runnable() { // from class: com.taobao.update.datasource.UpdateDataSource.5
                @Override // java.lang.Runnable
                public void run() {
                    UpdateDataSource.this.getRecentData(!z);
                    UpdateDataSource.this.j = false;
                }
            };
            if (z2) {
                runnable.run();
            } else {
                sUpdateAdapter.executeThread(runnable);
            }
        }
    }

    public void toast(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.update.datasource.UpdateDataSource.7
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }
}
