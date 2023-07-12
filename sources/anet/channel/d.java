package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.ab2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d {
    private final Map<SessionRequest, List<Session>> a = new HashMap();
    private final ReentrantReadWriteLock b;
    private final ReentrantReadWriteLock.ReadLock c;
    private final ReentrantReadWriteLock.WriteLock d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock;
        this.c = reentrantReadWriteLock.readLock();
        this.d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.y() == null || session == null) {
            return;
        }
        this.d.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list == null) {
                list = new ArrayList<>();
                this.a.put(sessionRequest, list);
            }
            if (list.indexOf(session) != -1) {
                return;
            }
            list.add(session);
            Collections.sort(list);
        } finally {
            this.d.unlock();
        }
    }

    public boolean b(SessionRequest sessionRequest, Session session) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            boolean z = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.c.unlock();
        }
    }

    public List<Session> c(SessionRequest sessionRequest) {
        ArrayList arrayList;
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                Iterator<Session> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Session next = it.next();
                    if (next != null && next.q()) {
                        arrayList2.add(next);
                        break;
                    }
                }
                arrayList = new ArrayList(arrayList2);
                return arrayList;
            }
            arrayList = null;
            return arrayList;
        } finally {
            this.c.unlock();
        }
    }

    public List<SessionRequest> d() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.c.lock();
        try {
            return this.a.isEmpty() ? list : new ArrayList(this.a.keySet());
        } finally {
            this.c.unlock();
        }
    }

    public Session e(SessionRequest sessionRequest) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                Iterator<Session> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Session next = it.next();
                    if (next != null && next.q()) {
                        session = next;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.c.unlock();
        }
    }

    public Session f(SessionRequest sessionRequest, int i) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.q() && (i == ab2.c || session2.k.e() == i)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.c.unlock();
        }
    }

    public List<Session> g(SessionRequest sessionRequest) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.c.unlock();
        }
    }

    public void h(SessionRequest sessionRequest, Session session) {
        this.d.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.a.remove(sessionRequest);
            }
        } finally {
            this.d.unlock();
        }
    }
}
