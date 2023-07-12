package com.youku.skinmanager.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSON;
import com.youku.mtop.MTopManager;
import com.youku.skinmanager.ILoadSkinListener;
import com.youku.skinmanager.ISkinManager;
import com.youku.skinmanager.SkinManager;
import com.youku.skinmanager.download.DownloadManager;
import com.youku.skinmanager.download.IDownloadListener;
import com.youku.skinmanager.entity.SkinConstant;
import com.youku.skinmanager.entity.SkinDTO;
import com.youku.skinmanager.http.MtopSkinLoadRequest;
import com.youku.skinmanager.utils.FileUtils;
import com.youku.skinmanager.utils.Utils;
import com.youku.usercenter.passport.IPassport;
import java.io.File;
import mtopsdk.mtop.domain.MtopRequest;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SkinManagerImpl implements ISkinManager {
    private static final String TAG = "SkinManager";
    private static volatile SkinManagerImpl mInstance;
    private Context mContext;
    private SkinDTO mSkinDTO;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.youku.skinmanager.impl.SkinManagerImpl.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.isEmpty(intent.getAction())) {
                return;
            }
            String action = intent.getAction();
            action.hashCode();
            if (action.equals(IPassport.ACTION_USER_LOOUT)) {
                Log.d(SkinManagerImpl.TAG, IPassport.ACTION_USER_LOOUT);
                if (SkinManagerImpl.this.mSkinDTO != null) {
                    if (TextUtils.isEmpty(SkinManagerImpl.this.mSkinDTO.getType()) || !SkinManagerImpl.this.mSkinDTO.getType().startsWith("vip")) {
                        return;
                    }
                    Log.d(SkinManagerImpl.TAG, "passport_user_logout->>>restoreDefault current skin id is " + SkinManagerImpl.this.mSkinDTO.getId());
                    SkinManagerImpl.this.restoreDefault(null);
                    return;
                }
                Log.d(SkinManagerImpl.TAG, "passport_user_logout skindto is null");
            }
        }
    };
    private boolean isInit = false;
    private boolean isOverdraw = false;

    private SkinManagerImpl() {
    }

    private void deleteOldSkinFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FileUtils.deleteFile(new File(str).getParentFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SkinManagerImpl getInstance() {
        if (mInstance == null) {
            synchronized (SkinManagerImpl.class) {
                if (mInstance == null) {
                    mInstance = new SkinManagerImpl();
                }
            }
        }
        return mInstance;
    }

    private void saveSkinData(SkinDTO skinDTO) {
        Utils.savePreference(SkinManager.sContext, SkinConstant.SKIN_DATA_KEY, skinDTO != null ? JSON.toJSONString(skinDTO) : "");
    }

    private void sendBroadcast(Context context) {
        if (context == null) {
            Log.e(TAG, "sendBroadcast context is null!!!!");
            return;
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(SkinConstant.CHANGE_SKIN_ACTION));
        Log.d(TAG, "sendBroadcast action is com.youku.skinmanager.action.changeskin");
    }

    @Override // com.youku.skinmanager.ISkinManager
    @Nullable
    public SkinDTO getCurrentSkinConfig() {
        if (this.isInit) {
            return this.mSkinDTO;
        }
        String preference = Utils.getPreference(SkinManager.sContext, SkinConstant.SKIN_DATA_KEY);
        if (TextUtils.isEmpty(preference)) {
            return null;
        }
        return (SkinDTO) JSON.parseObject(preference, SkinDTO.class);
    }

    @Override // com.youku.skinmanager.ISkinManager
    @Nullable
    public String getSkinPath() {
        SkinDTO skinDTO = this.mSkinDTO;
        return (skinDTO == null || !Utils.fileIsExists(skinDTO.getLocalFilePath())) ? "" : this.mSkinDTO.getLocalFilePath();
    }

    @Override // com.youku.skinmanager.ISkinManager
    public void init(Context context) {
        SkinManager.sContext = context.getApplicationContext();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        String preference = Utils.getPreference(applicationContext, SkinConstant.SKIN_DATA_KEY);
        SkinDTO skinDTO = TextUtils.isEmpty(preference) ? null : (SkinDTO) JSON.parseObject(preference, SkinDTO.class);
        if (skinDTO != null) {
            loadSkin(true, skinDTO, skinDTO.getLocalFilePath(), null);
        }
        FileUtils.deleteFiles(DownloadManager.getInstance().getDirectory(context), getSkinPath());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IPassport.ACTION_USER_LOOUT);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mReceiver, intentFilter);
        this.isInit = true;
    }

    @Override // com.youku.skinmanager.ISkinManager
    public boolean isOverdraw() {
        return this.isOverdraw;
    }

    @Override // com.youku.skinmanager.ISkinManager
    public void loadSkin(SkinDTO skinDTO, @Nullable String str, ILoadSkinListener iLoadSkinListener) {
        loadSkin(false, skinDTO, str, iLoadSkinListener);
    }

    @Override // com.youku.skinmanager.ISkinManager
    public void loadSkinById(String str, @Nullable IDownloadListener iDownloadListener) {
        Log.d(TAG, "loadSkinById id is " + str);
        MtopSkinLoadRequest mtopSkinLoadRequest = new MtopSkinLoadRequest();
        mtopSkinLoadRequest.skinId = str;
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(mtopSkinLoadRequest.API_NAME);
        mtopRequest.setVersion(mtopSkinLoadRequest.VERSION);
        mtopRequest.setData(com.youku.mtop.util.Utils.convertMapToDataStr(mtopSkinLoadRequest.buildRequestParams()));
        MTopManager.getMtopInstance().build(mtopRequest, MTopManager.getTtid()).addListener(new SkinMtopListener(iDownloadListener)).asyncRequest();
    }

    @Override // com.youku.skinmanager.ISkinManager
    public void restoreDefault(ILoadSkinListener iLoadSkinListener) {
        Log.d(TAG, "restoreDefault");
        if (iLoadSkinListener != null) {
            iLoadSkinListener.onLoadSuccess(null);
        }
        String skinPath = getSkinPath();
        this.isOverdraw = false;
        this.mSkinDTO = null;
        deleteOldSkinFile(skinPath);
        saveSkinData(null);
        if (TextUtils.isEmpty(skinPath)) {
            return;
        }
        sendBroadcast(SkinManager.sContext);
    }

    private void loadSkin(boolean z, SkinDTO skinDTO, @Nullable String str, ILoadSkinListener iLoadSkinListener) {
        Log.d(TAG, "loadSkin");
        if (skinDTO != null && !TextUtils.isEmpty(str) && Utils.fileIsExists(str)) {
            Log.d(TAG, "loadSkin skin id is " + skinDTO.getId() + " path is " + str);
            SkinDTO skinDTO2 = this.mSkinDTO;
            if (skinDTO2 != null && skinDTO2.getId().equalsIgnoreCase(skinDTO.getId())) {
                Log.d(TAG, "the same id return");
                return;
            }
            SkinDTO skinDTO3 = this.mSkinDTO;
            String localFilePath = skinDTO3 == null ? "" : skinDTO3.getLocalFilePath();
            this.mSkinDTO = skinDTO;
            skinDTO.setLocalFilePath(str);
            deleteOldSkinFile(localFilePath);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("tab");
            sb.append(str2);
            sb.append("tab_bg.png");
            this.isOverdraw = Utils.fileIsExists(sb.toString());
            if (!z) {
                saveSkinData(this.mSkinDTO);
            }
            if (iLoadSkinListener != null) {
                iLoadSkinListener.onLoadSuccess(this.mSkinDTO);
            }
            sendBroadcast(SkinManager.sContext);
            return;
        }
        restoreDefault(iLoadSkinListener);
    }
}
