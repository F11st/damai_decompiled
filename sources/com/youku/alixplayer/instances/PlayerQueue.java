package com.youku.alixplayer.instances;

import android.content.Context;
import androidx.annotation.Keep;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.InstancePool;
import com.youku.alixplayer.raphael.RaphaelPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PlayerQueue {
    private static final int MAX_INSTANCE_COUNT = 0;
    private InstancePool<Aliplayer> mInstancePool;
    private InstancePool.Instantiater<Aliplayer> mInstantiater;
    private List<QueueItem> mQueueItems = new ArrayList();
    private Map<Object, QueueItem> mIdQueueMap = new HashMap();

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes.dex */
    public static class QueueItem {
        private List<Aliplayer> mAliplayers = new ArrayList();
        private Object mId;
        private boolean mIsOnprepared;
        private Aliplayer mMainPlayer;
        private PlayerQueue mPlayerQueue;

        public QueueItem(Object obj) {
            this.mId = obj;
        }

        public static QueueItem create(Object obj) {
            return new QueueItem(obj);
        }

        public Aliplayer addPlayer() {
            Aliplayer aliplayer = (Aliplayer) this.mPlayerQueue.mInstancePool.acquire();
            this.mAliplayers.add(aliplayer);
            return aliplayer;
        }

        public List<Aliplayer> getAliplayers() {
            return this.mAliplayers;
        }

        public Aliplayer getMainPlayer() {
            return this.mMainPlayer;
        }

        public boolean isOnprepared() {
            return this.mIsOnprepared;
        }

        public void setOnprepared(boolean z) {
            this.mIsOnprepared = z;
        }
    }

    public PlayerQueue() {
        InstancePool.Instantiater<Aliplayer> instantiater = new InstancePool.Instantiater<Aliplayer>() { // from class: com.youku.alixplayer.instances.PlayerQueue.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.youku.alixplayer.instances.InstancePool.Instantiater
            public Aliplayer instance() {
                return new Aliplayer(Aliplayer.PlayerCategory.MIXED_CODECS_PLAYER);
            }
        };
        this.mInstantiater = instantiater;
        this.mInstancePool = new InstancePool<>(instantiater, 0);
    }

    public static PlayerQueue create() {
        return new PlayerQueue();
    }

    public void addItem(QueueItem queueItem) {
        addItem(queueItem, Aliplayer.PlayerCategory.MIXED_CODECS_PLAYER, null);
    }

    public synchronized void addItem(QueueItem queueItem, Aliplayer.PlayerCategory playerCategory, Context context) {
        if (queueItem == null) {
            return;
        }
        queueItem.mPlayerQueue = this;
        queueItem.mMainPlayer = playerCategory == Aliplayer.PlayerCategory.RAPHAELPLAYER ? new RaphaelPlayer(context) : this.mInstancePool.acquire();
        this.mQueueItems.add(queueItem);
        this.mIdQueueMap.put(queueItem.mId, queueItem);
    }

    public synchronized void bringToFront(Object obj) {
        QueueItem queueItem = this.mIdQueueMap.get(obj);
        if (queueItem != null && this.mQueueItems.indexOf(queueItem) > 0) {
            this.mQueueItems.remove(queueItem);
            this.mQueueItems.add(0, queueItem);
        }
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

    public synchronized void removeItem(QueueItem queueItem) {
        if (queueItem == null) {
            return;
        }
        this.mIdQueueMap.remove(queueItem.mId);
        this.mQueueItems.remove(queueItem);
        this.mInstancePool.release(queueItem.mMainPlayer);
        if (queueItem.mAliplayers != null && queueItem.mAliplayers.size() > 0) {
            for (int size = queueItem.mAliplayers.size() - 1; size >= 0; size--) {
                Aliplayer aliplayer = (Aliplayer) queueItem.mAliplayers.remove(size);
                if (aliplayer != null) {
                    this.mInstancePool.release(aliplayer);
                }
            }
        }
    }
}
