package com.youku.skinmanager;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.youku.arch.v3.core.Constants;
import com.youku.skinmanager.download.DownloadManager;
import com.youku.skinmanager.entity.SkinDTO;
import com.youku.skinmanager.resource.IResourceManager;
import com.youku.skinmanager.resource.ResourceManagerImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SkinManagerHelper {
    public static final String TAG = "SkinManagerHelper";
    private static volatile SkinManagerHelper mInstance;
    private IResourceManager mResourceManager;

    private SkinManagerHelper() {
    }

    public static SkinManagerHelper getInstance() {
        if (mInstance == null) {
            synchronized (SkinManagerHelper.class) {
                if (mInstance == null) {
                    mInstance = new SkinManagerHelper();
                }
            }
        }
        return mInstance;
    }

    public Long getCurrentSkinId() {
        SkinDTO currentSkinConfig = SkinManager.getInstance().getCurrentSkinConfig();
        if (currentSkinConfig != null && !TextUtils.isEmpty(currentSkinConfig.getId())) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(currentSkinConfig.getId()));
                Log.d(TAG, "getCurrentSkinId is " + valueOf);
                return valueOf;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public IResourceManager getResourceManager() {
        if (this.mResourceManager == null) {
            this.mResourceManager = new ResourceManagerImpl();
        }
        return this.mResourceManager;
    }

    public void parseSkinConfig(String str) {
        try {
            Log.d(TAG, "parseSkinConfig->>>>>>" + str);
            String optString = new JSONObject(str).optString(Constants.CONFIG);
            if (!TextUtils.isEmpty(optString) && !"{}".equalsIgnoreCase(optString)) {
                SkinDTO skinDTO = (SkinDTO) JSON.parseObject(optString, SkinDTO.class);
                if (skinDTO == null || !skinDTO.getId().equalsIgnoreCase(String.valueOf(getCurrentSkinId()))) {
                    DownloadManager.getInstance().startDownload(skinDTO, null);
                    return;
                }
                return;
            }
            SkinManager.getInstance().restoreDefault(null);
        } catch (JSONException e) {
            e.printStackTrace();
            SkinManager.getInstance().restoreDefault(null);
        }
    }
}
