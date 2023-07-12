package android.taobao.windvane.packageapp;

import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.file.NotEnoughSpace;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.taobao.android.speed.TBSpeed;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.zcache.ZCacheManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.hh1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZCacheConfigManager {
    private static ZCacheConfigManager instance;
    private AtomicBoolean updateFromLocal = new AtomicBoolean(false);
    private String zType = "3";
    private String oldConfig = "false";
    private String slideEnable = "false";
    private String configPath = null;

    public static ZCacheConfigManager getInstance() {
        if (instance == null) {
            synchronized (ZCacheConfigManager.class) {
                if (instance == null) {
                    instance = new ZCacheConfigManager();
                }
            }
        }
        return instance;
    }

    private void initOrange() {
        OrangeConfig.getInstance().registerListener(new String[]{"ZCache"}, new OrangeConfigListenerV1() { // from class: android.taobao.windvane.packageapp.ZCacheConfigManager.1
            @Override // com.taobao.orange.OrangeConfigListenerV1
            public void onConfigUpdate(String str, boolean z) {
                if (str.equals("ZCache")) {
                    String config = OrangeConfig.getInstance().getConfig("ZCache", hh1.MODULE_NAME, "false");
                    String config2 = OrangeConfig.getInstance().getConfig("ZCache", "oldConfigV1", "false");
                    TaoLog.i("ZCache", "use old config=[" + config2 + "], enable slide=[" + config + jn1.ARRAY_END_STR);
                    try {
                        String str2 = ZCacheConfigManager.this.configPath;
                        FileAccesser.write(str2, ByteBuffer.wrap((GlobalConfig.getInstance().getAppVersion() + "," + config2 + "," + config).getBytes("utf-8")));
                    } catch (NotEnoughSpace e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    private void triggerLocalConfig() {
        byte[] read;
        if (this.updateFromLocal.compareAndSet(false, true)) {
            String str = null;
            try {
                read = FileAccesser.read(this.configPath);
            } catch (Throwable th) {
                th.printStackTrace();
                this.updateFromLocal.set(false);
            }
            if (read == null) {
                return;
            }
            str = new String(read, "utf-8");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TaoLog.i("ZCache", "get zcache local config=[" + str + jn1.ARRAY_END_STR);
            String[] split = str.split(",");
            if (split.length == 3) {
                if (!TextUtils.isEmpty(split[0]) && TextUtils.equals(GlobalConfig.getInstance().getAppVersion(), split[0])) {
                    if (!TextUtils.isEmpty(split[1])) {
                        if (TextUtils.equals("3", this.zType) && !TextUtils.equals(this.oldConfig, split[2])) {
                            TaoLog.i("ZCache", "ZCache 3.0 新旧平台切换，需要刷新本地配置");
                            ZCacheManager.instance().removeAllZCache();
                        }
                        this.oldConfig = split[1];
                    }
                    if (TextUtils.isEmpty(split[2])) {
                        return;
                    }
                    this.slideEnable = split[2];
                    return;
                }
                TaoLog.i("ZCache", "skip local config for dispatching appVersion. require=[" + GlobalConfig.getInstance().getAppVersion() + "], real=[" + split[0] + jn1.ARRAY_END_STR);
            }
        }
    }

    public String getzType() {
        if ("-1".equals(this.zType)) {
            try {
                this.zType = TBSpeed.isSpeedEdition(GlobalConfig.context, "ZCache3") ? "3" : "2";
            } catch (Throwable unused) {
                this.zType = "2";
            }
        }
        return this.zType;
    }

    public void init(Context context) {
        this.zType = GlobalConfig.getInstance().isZcacheType3() ? "3" : "2";
        this.oldConfig = GlobalConfig.getInstance().useZcacheOldConfig() ? "true" : "false";
        if (CommonUtils.getProcessName(context).equals(context.getApplicationContext().getPackageName())) {
            File createFolder = FileManager.createFolder(context, "ZCache");
            this.configPath = createFolder.getPath() + File.separator + "orange";
            File file = new File(this.configPath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            triggerLocalConfig();
            try {
                initOrange();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean slideEnable() {
        return TextUtils.equals("true", this.slideEnable);
    }

    public void triggerZCacheConfig() {
    }

    public boolean useOldConfig() {
        return TextUtils.equals("true", this.oldConfig);
    }
}
