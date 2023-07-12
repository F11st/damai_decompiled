package com.alibaba.aliweex.adapter.module.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXAudioModule extends WXModule implements IWXAudio, Destroyable {
    private AtomicLong generateId = new AtomicLong(1);
    private Map<String, List<Long>> instancePlayerIdMap = new HashMap();
    private Map<Long, MediaPlayer> playerMap = new HashMap();
    private Map<Long, Integer> statusMap = new ConcurrentHashMap();
    private Map<Long, Map<String, String>> optionsMap = new HashMap();
    private Map<Long, JSCallback> callbackMap = new HashMap();
    private List<Long> autoStartPlayWhenReady = new ArrayList();
    private List<Long> loopWhenPlayEnded = new ArrayList();
    private List<Long> pausedWhenLoseAudioFocus = new ArrayList();
    AudioManager mAudioManager = null;
    boolean mHasErrorInGainAudioFocus = false;
    Handler handler = new Handler(Looper.getMainLooper());
    C3054d mPreparedListener = new C3054d();
    C3053c mErrorListener = new C3053c();
    WXAudioOnCompletionListener mCompletionListener = new WXAudioOnCompletionListener();
    private C3052b mWXAudioFocusListener = new C3052b();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private class WXAudioOnCompletionListener implements MediaPlayer.OnCompletionListener {
        private WXAudioOnCompletionListener() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            final long longValue = WXAudioModule.this.getIdByPlayer(mediaPlayer).longValue();
            WXAudioModule.this.changeStatus(Long.valueOf(longValue), 5);
            int i = 100;
            try {
                if (((Map) WXAudioModule.this.optionsMap.get(Long.valueOf(longValue))).get("delay") != null) {
                    i = Integer.parseInt((String) ((Map) WXAudioModule.this.optionsMap.get(Long.valueOf(longValue))).get("delay"));
                }
            } catch (Exception unused) {
            }
            WXAudioModule.this.handler.postDelayed(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.audio.WXAudioModule.WXAudioOnCompletionListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WXAudioModule.this.loopWhenPlayEnded.contains(Long.valueOf(longValue))) {
                        WXAudioModule.this.play(Long.valueOf(longValue));
                        return;
                    }
                    WXAudioModule wXAudioModule = WXAudioModule.this;
                    wXAudioModule.invokeCallbackAndKeepAlive(wXAudioModule.generateCallbackValue(Long.valueOf(longValue), 5, ""));
                    WXAudioModule.this.abandonAudioFocus();
                }
            }, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.audio.WXAudioModule$b */
    /* loaded from: classes15.dex */
    public class C3052b implements AudioManager.OnAudioFocusChangeListener {
        boolean a = false;

        C3052b() {
        }

        private void a() {
            for (Long l : WXAudioModule.this.playerMap.keySet()) {
                WXAudioModule.this.stop(l);
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -2) {
                synchronized (this) {
                    for (Long l : WXAudioModule.this.playerMap.keySet()) {
                        MediaPlayer player = WXAudioModule.this.getPlayer(l);
                        if (player != null && player.isPlaying()) {
                            WXAudioModule.this.pause(l);
                            WXAudioModule.this.pausedWhenLoseAudioFocus.add(l);
                        }
                    }
                }
            } else if (i == 1) {
                synchronized (this) {
                    for (Long l2 : WXAudioModule.this.pausedWhenLoseAudioFocus) {
                        WXAudioModule.this.play(l2);
                    }
                    if (this.a) {
                        WXAudioModule.this.setVolume(1.0f);
                        this.a = false;
                    }
                }
            } else if (i == 3) {
                synchronized (this) {
                    WXAudioModule.this.setVolume(0.3f);
                    this.a = true;
                }
            } else if (i == -1) {
                synchronized (this) {
                    a();
                    WXAudioModule.this.abandonAudioFocus();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.audio.WXAudioModule$c */
    /* loaded from: classes15.dex */
    private class C3053c implements MediaPlayer.OnErrorListener {
        private C3053c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            long longValue = WXAudioModule.this.getIdByPlayer(mediaPlayer).longValue();
            WXAudioModule.this.changeStatus(Long.valueOf(longValue), 6);
            WXAudioModule wXAudioModule = WXAudioModule.this;
            Long valueOf = Long.valueOf(longValue);
            wXAudioModule.invokeCallbackAndKeepAlive(wXAudioModule.generateCallbackValue(valueOf, 6, "2", "error in loading audio. what:" + i + " extra:" + i2));
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.audio.WXAudioModule$d */
    /* loaded from: classes15.dex */
    private class C3054d implements MediaPlayer.OnPreparedListener {
        private C3054d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Long idByPlayer = WXAudioModule.this.getIdByPlayer(mediaPlayer);
            WXAudioModule.this.changeStatus(idByPlayer, 2);
            if (WXAudioModule.this.autoStartPlayWhenReady.size() > 0 && WXAudioModule.this.autoStartPlayWhenReady.contains(idByPlayer)) {
                WXAudioModule.this.play(idByPlayer);
                WXAudioModule.this.autoStartPlayWhenReady.remove(idByPlayer);
            }
            if (WXAudioModule.this.optionsMap.get(idByPlayer) != null) {
                ((Map) WXAudioModule.this.optionsMap.get(idByPlayer)).put("duration", String.valueOf(mediaPlayer.getDuration()));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("duration", String.valueOf(mediaPlayer.getDuration()));
            WXAudioModule.this.invokeCallbackAndKeepAlive(WXAudioModule.this.generateCallbackValue(idByPlayer, 2, hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        boolean z = true;
        try {
            for (Integer num : this.statusMap.values()) {
                if (num.intValue() == 3) {
                    z = false;
                }
            }
            if (z) {
                getAudioManager().abandonAudioFocus(this.mWXAudioFocusListener);
            }
        } catch (Exception e) {
            WXLogUtils.w("error in abandonAudioFocus", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeStatus(Long l, int i) {
        this.statusMap.put(l, Integer.valueOf(i));
    }

    private void collectPlayerIdByInstanceId(String str, long j) {
        List<Long> list = this.instancePlayerIdMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.instancePlayerIdMap.put(str, list);
        }
        if (list.contains(Long.valueOf(j))) {
            return;
        }
        list.add(Long.valueOf(j));
    }

    private void doPlayInner(Long l) {
        try {
            getPlayer(l).start();
            changeStatus(l, 3);
            invokeCallbackAndKeepAlive(generateCallbackValue(l, 3, ""));
        } catch (Exception e) {
            WXLogUtils.w("error in play", e);
            invokeCallbackAndKeepAlive(generateCallbackValue(l, 6, "error in start play"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> generateCallbackValue(Long l, Integer num, String str, String str2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("code", str);
        hashMap.put("message", str2);
        return generateCallbackValue(l, num, hashMap);
    }

    private AudioManager getAudioManager() {
        try {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) this.mWXSDKInstance.getContext().getSystemService("audio");
            }
        } catch (Exception e) {
            WXLogUtils.w("error in getSystemService of audio", e);
            this.mHasErrorInGainAudioFocus = true;
        }
        return this.mAudioManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long getIdByPlayer(MediaPlayer mediaPlayer) {
        for (Map.Entry<Long, MediaPlayer> entry : this.playerMap.entrySet()) {
            if (entry.getValue() == mediaPlayer) {
                return entry.getKey();
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer getPlayer(Long l) {
        MediaPlayer mediaPlayer = this.playerMap.get(l);
        if (mediaPlayer == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.playerMap.put(l, mediaPlayer2);
            return mediaPlayer2;
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallbackAndKeepAlive(Map<String, Object> map) {
        if (map.get("id") == null) {
            return;
        }
        JSCallback jSCallback = this.callbackMap.get((Long) map.get("id"));
        if (jSCallback != null) {
            jSCallback.invokeAndKeepAlive(map);
        }
    }

    private boolean tryToGainAudioFocus(int i) {
        int i2 = 2;
        if (i > 100000) {
            i2 = 1;
        } else if (i > 0 && i < 2500) {
            i2 = 3;
        }
        try {
            return getAudioManager().requestAudioFocus(this.mWXAudioFocusListener, 3, i2) == 1;
        } catch (Exception e) {
            WXLogUtils.w("error in tryToGainAudioFocus", e);
            this.mHasErrorInGainAudioFocus = true;
            return false;
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod(uiThread = false)
    public String canPlayType(String str) {
        return ("audio/wav".equalsIgnoreCase(str) || "audio/x-wav".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str) || "audio/aac".equalsIgnoreCase(str) || "audio/mp4".equalsIgnoreCase(str) || "audio/amr".equalsIgnoreCase(str)) ? IWXAudio.CAN_PLAY_TYPE_PROBABLY : "application/octet-stream".equalsIgnoreCase(str) ? "" : IWXAudio.CAN_PLAY_TYPE_MAYBE;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            WXLogUtils.w("in WXAudioModule destory() mWXSDKInstance is null.");
            return;
        }
        List<Long> list = this.instancePlayerIdMap.get(wXSDKInstance.getInstanceId());
        if (list != null) {
            for (Long l : list) {
                this.optionsMap.remove(l);
                MediaPlayer mediaPlayer = this.playerMap.get(l);
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                this.playerMap.remove(l);
                this.statusMap.remove(l);
                this.callbackMap.remove(l);
            }
        }
        this.instancePlayerIdMap.remove(this.mWXSDKInstance.getInstanceId());
        abandonAudioFocus();
    }

    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void load(Map<String, String> map, @Nullable JSCallback jSCallback) {
        long parseLong;
        HashMap hashMap = new HashMap(3);
        if (map == null) {
            invokeCallbackAndKeepAlive(generateCallbackValue(-1L, 6, "5", "empty option"));
            return;
        }
        if (map.get("id") == null) {
            parseLong = this.generateId.getAndIncrement();
        } else {
            parseLong = Long.parseLong(map.get("id"));
        }
        hashMap.put("id", String.valueOf(parseLong));
        if (map.get("url") == null) {
            invokeCallbackAndKeepAlive(generateCallbackValue(Long.valueOf(parseLong), 6, "4", "empty option url"));
            return;
        }
        Uri parse = Uri.parse(map.get("url"));
        if (!parse.isHierarchical()) {
            invokeCallbackAndKeepAlive(generateCallbackValue(Long.valueOf(parseLong), 6, "4", "not a vaild url"));
            return;
        }
        collectPlayerIdByInstanceId(this.mWXSDKInstance.getInstanceId(), parseLong);
        if (this.optionsMap.containsKey(Long.valueOf(parseLong))) {
            this.autoStartPlayWhenReady.remove(Long.valueOf(parseLong));
            this.loopWhenPlayEnded.remove(Long.valueOf(parseLong));
        } else {
            this.optionsMap.put(Long.valueOf(parseLong), map);
        }
        this.callbackMap.put(Long.valueOf(parseLong), jSCallback);
        changeStatus(Long.valueOf(parseLong), 1);
        MediaPlayer player = getPlayer(Long.valueOf(parseLong));
        if (map.get(IWXAudio.KEY_VOLUME) != null) {
            Float valueOf = Float.valueOf(0.0f);
            try {
                valueOf = Float.valueOf(Float.parseFloat(map.get(IWXAudio.KEY_VOLUME)));
            } catch (NumberFormatException unused) {
            }
            if (valueOf.floatValue() > 0.0f) {
                player.setVolume(valueOf.floatValue(), valueOf.floatValue());
            }
        }
        Boolean bool = Boolean.TRUE;
        if (String.valueOf(bool).equals(map.get("autoplay"))) {
            this.autoStartPlayWhenReady.add(Long.valueOf(parseLong));
        }
        if (String.valueOf(bool).equals(map.get(IWXAudio.KEY_LOOP))) {
            this.loopWhenPlayEnded.add(Long.valueOf(parseLong));
        }
        try {
            getAudioManager();
            player.reset();
            player.setDataSource(this.mWXSDKInstance.getContext(), parse);
            player.setOnCompletionListener(this.mCompletionListener);
            player.setOnErrorListener(this.mErrorListener);
            player.setOnPreparedListener(this.mPreparedListener);
            invokeCallbackAndKeepAlive(generateCallbackValue(Long.valueOf(parseLong), 1, ""));
            player.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
            changeStatus(Long.valueOf(parseLong), 6);
            invokeCallbackAndKeepAlive(generateCallbackValue(Long.valueOf(parseLong), 6, "5", e.getMessage()));
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void pause(Long l) {
        if (l == null || this.playerMap.get(l) == null) {
            return;
        }
        MediaPlayer player = getPlayer(l);
        if (player.isPlaying()) {
            try {
                player.pause();
                changeStatus(l, 4);
                invokeCallbackAndKeepAlive(generateCallbackValue(l, 4, ""));
            } catch (Exception e) {
                WXLogUtils.w("error in pause", e);
                invokeCallbackAndKeepAlive(generateCallbackValue(l, 6, "error in pause"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bf -> B:40:0x00df). Please submit an issue!!! */
    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void play(Long l) {
        if (l == null || this.playerMap.get(l) == null) {
            return;
        }
        Integer num = -1;
        try {
            if (this.optionsMap.get(l) != null) {
                num = Integer.valueOf(Integer.parseInt(this.optionsMap.get(l).get("duration")));
            }
        } catch (Exception unused) {
        }
        ?? r1 = 6;
        r1 = 6;
        r1 = 6;
        r1 = 6;
        r1 = 6;
        r1 = 6;
        r1 = 6;
        if (!tryToGainAudioFocus(num.intValue()) && !this.mHasErrorInGainAudioFocus) {
            invokeCallbackAndKeepAlive(generateCallbackValue(l, 6, "request audio focus failed. maybe there is a high prior audio task is playing"));
            return;
        }
        try {
            MediaPlayer player = getPlayer(l);
            int intValue = this.statusMap.get(l).intValue();
            l = l;
            if (3 != intValue) {
                if (player.isPlaying()) {
                    l = l;
                } else {
                    if (2 != this.statusMap.get(l).intValue() && 4 != this.statusMap.get(l).intValue()) {
                        if (5 == this.statusMap.get(l).intValue()) {
                            player.pause();
                            player.seekTo(0);
                            doPlayInner(l);
                            l = l;
                        } else {
                            int intValue2 = this.statusMap.get(l).intValue();
                            l = l;
                            if (1 == intValue2) {
                                this.autoStartPlayWhenReady.add(l);
                                l = l;
                            }
                        }
                    }
                    doPlayInner(l);
                    l = l;
                }
            }
        } catch (IllegalStateException e) {
            Integer valueOf = Integer.valueOf((int) r1);
            Map<String, Object> generateCallbackValue = generateCallbackValue(l, valueOf, "exception occur. IllegalStateException " + e.getMessage());
            invokeCallbackAndKeepAlive(generateCallbackValue);
            r1 = valueOf;
            l = generateCallbackValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b6 -> B:38:0x00d6). Please submit an issue!!! */
    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void seek(Long l, int i) {
        MediaPlayer player;
        if (l == null || this.playerMap.get(l) == null) {
            return;
        }
        Integer num = -1;
        try {
            if (this.optionsMap.get(l) != null) {
                num = Integer.valueOf(Integer.parseInt(this.optionsMap.get(l).get("duration")));
            }
        } catch (Exception unused) {
        }
        int i2 = 6;
        i2 = 6;
        i2 = 6;
        i2 = 6;
        i2 = 6;
        if (!tryToGainAudioFocus(num.intValue()) && !this.mHasErrorInGainAudioFocus) {
            invokeCallbackAndKeepAlive(generateCallbackValue(l, 6, "request audio focus failed. maybe there is a high prior audio task is playing"));
            return;
        }
        try {
            player = getPlayer(l);
        } catch (IllegalStateException e) {
            Integer valueOf = Integer.valueOf(i2);
            StringBuilder sb = new StringBuilder();
            sb.append("exception occur. IllegalStateException ");
            sb.append(e.getMessage());
            Map<String, Object> generateCallbackValue = generateCallbackValue(l, valueOf, sb.toString());
            invokeCallbackAndKeepAlive(generateCallbackValue);
            i2 = sb;
            l = generateCallbackValue;
        }
        if (3 != this.statusMap.get(l).intValue() && !player.isPlaying()) {
            if (2 != this.statusMap.get(l).intValue() && 4 != this.statusMap.get(l).intValue()) {
                int intValue = this.statusMap.get(l).intValue();
                l = l;
                if (5 == intValue) {
                    player.pause();
                    player.seekTo(i);
                    doPlayInner(l);
                    l = l;
                }
            }
            player.seekTo(i);
            doPlayInner(l);
            l = l;
        }
        player.pause();
        player.seekTo(i);
        doPlayInner(l);
        l = l;
    }

    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void setVolume(float f) {
        List<Long> list = this.instancePlayerIdMap.get(this.mWXSDKInstance.getInstanceId());
        if (list == null) {
            return;
        }
        for (Long l : list) {
            MediaPlayer mediaPlayer = this.playerMap.get(l);
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f, f);
            }
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.audio.IWXAudio
    @JSMethod
    public void stop(Long l) {
        if (l == null || this.playerMap.get(l) == null) {
            return;
        }
        MediaPlayer player = getPlayer(l);
        this.loopWhenPlayEnded.remove(l);
        if (player.isPlaying()) {
            try {
                player.pause();
                player.seekTo(0);
                changeStatus(l, 5);
                invokeCallbackAndKeepAlive(generateCallbackValue(l, 5, ""));
                abandonAudioFocus();
            } catch (Exception e) {
                WXLogUtils.w("error in stop", e);
                invokeCallbackAndKeepAlive(generateCallbackValue(l, 6, "error in stop"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> generateCallbackValue(Long l, Integer num, Object obj) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("id", l);
        hashMap.put("status", num);
        hashMap.put("value", obj);
        return hashMap;
    }
}
