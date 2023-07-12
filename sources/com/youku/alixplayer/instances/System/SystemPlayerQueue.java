package com.youku.alixplayer.instances.System;

import androidx.annotation.Keep;
import com.youku.alixplayer.instances.System.SystemInstancePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemPlayerQueue {
    private static final int MAX_INSTANCE_COUNT = 0;
    private SystemInstancePool<AndroidPlayer> mInstancePool;
    private SystemInstancePool.Instantiater<AndroidPlayer> mInstantiater;
    private List<QueueItem> mQueueItems = new ArrayList();
    private Map<Object, QueueItem> mIdQueueMap = new HashMap();

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes.dex */
    public static class QueueItem {
        private List<AndroidPlayer> mAndroidPlayers = new ArrayList();
        private Object mId;
        private boolean mIsOnprepared;
        private AndroidPlayer mMainPlayer;
        private SystemPlayerQueue mPlayerQueue;

        public QueueItem(Object obj) {
            this.mId = obj;
        }

        public static QueueItem create(Object obj) {
            return new QueueItem(obj);
        }

        public AndroidPlayer addPlayer() {
            AndroidPlayer androidPlayer = (AndroidPlayer) this.mPlayerQueue.mInstancePool.acquire();
            this.mAndroidPlayers.add(androidPlayer);
            return androidPlayer;
        }

        public AndroidPlayer getMainPlayer() {
            return this.mMainPlayer;
        }

        public List<AndroidPlayer> getmAndroidPlayersplayers() {
            return this.mAndroidPlayers;
        }

        public boolean isOnprepared() {
            return this.mIsOnprepared;
        }

        public void setOnprepared(boolean z) {
            this.mIsOnprepared = z;
        }
    }

    public SystemPlayerQueue() {
        SystemInstancePool.Instantiater<AndroidPlayer> instantiater = new SystemInstancePool.Instantiater<AndroidPlayer>() { // from class: com.youku.alixplayer.instances.System.SystemPlayerQueue.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.youku.alixplayer.instances.System.SystemInstancePool.Instantiater
            public AndroidPlayer instance() {
                return new AndroidPlayer();
            }
        };
        this.mInstantiater = instantiater;
        this.mInstancePool = new SystemInstancePool<>(instantiater, 0);
    }

    public static SystemPlayerQueue create() {
        return new SystemPlayerQueue();
    }

    public void addItem(QueueItem queueItem) {
        this.mQueueItems.add(queueItem);
        this.mIdQueueMap.put(queueItem.mId, queueItem);
        queueItem.mPlayerQueue = this;
        queueItem.mMainPlayer = this.mInstancePool.acquire();
    }

    public void bringToFront(Object obj) {
        QueueItem queueItem = this.mIdQueueMap.get(obj);
        if (queueItem == null || this.mQueueItems.indexOf(queueItem) <= 0) {
            return;
        }
        this.mQueueItems.remove(queueItem);
        this.mQueueItems.add(0, queueItem);
    }

    public void clearAllItems() {
        if (this.mQueueItems.size() > 0) {
            for (int size = this.mQueueItems.size() - 1; size >= 0; size--) {
                removeItem(this.mQueueItems.get(size));
            }
        }
    }

    public void clearOtherItems(QueueItem queueItem) {
        if (this.mQueueItems.size() > 0) {
            for (int size = this.mQueueItems.size() - 1; size >= 0; size--) {
                QueueItem queueItem2 = this.mQueueItems.get(size);
                if (queueItem2 != queueItem) {
                    removeItem(queueItem2);
                }
            }
        }
    }

    public QueueItem get(Object obj) {
        return this.mIdQueueMap.get(obj);
    }

    public QueueItem getActiveItem() {
        if (this.mQueueItems.size() > 0) {
            return this.mQueueItems.get(0);
        }
        return null;
    }

    public void removeItem(QueueItem queueItem) {
        this.mIdQueueMap.remove(queueItem.mId);
        this.mQueueItems.remove(queueItem);
        this.mInstancePool.release(queueItem.mMainPlayer);
        if (queueItem.mAndroidPlayers == null || queueItem.mAndroidPlayers.size() <= 0) {
            return;
        }
        for (int size = queueItem.mAndroidPlayers.size() - 1; size >= 0; size--) {
            this.mInstancePool.release((AndroidPlayer) queueItem.mAndroidPlayers.remove(size));
        }
    }
}
