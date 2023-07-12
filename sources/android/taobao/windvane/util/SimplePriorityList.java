package android.taobao.windvane.util;

import android.taobao.windvane.util.SimplePriorityList.PriorityInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SimplePriorityList<E extends PriorityInterface> implements List<E> {
    private List<E>[] list;
    private int prioritySize;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private List<E> cachedPriorityList = new CopyOnWriteArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface PriorityInterface {
        int getPriority();
    }

    public SimplePriorityList(int i) {
        if (i > 0) {
            this.list = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.list[i2] = new ArrayList();
            }
            this.cachedPriorityList.clear();
            this.prioritySize = i;
            return;
        }
        throw new IllegalArgumentException("prioritySize < 0: " + i);
    }

    private boolean checkPriority(E e) {
        return e == null || (e.getPriority() >= 0 && e.getPriority() < this.prioritySize);
    }

    private List<E> getCachedPriorityList() {
        if (this.cachedPriorityList.isEmpty()) {
            this.lock.readLock().lock();
            for (List<E> list : this.list) {
                this.cachedPriorityList.addAll(list);
            }
            this.lock.readLock().unlock();
        }
        return this.cachedPriorityList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        add(i, (int) ((PriorityInterface) obj));
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.lock.writeLock().lock();
        for (List<E> list : this.list) {
            list.clear();
        }
        this.cachedPriorityList.clear();
        this.lock.writeLock().unlock();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return getCachedPriorityList().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return getCachedPriorityList().iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return getCachedPriorityList().listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return set(i, (int) ((PriorityInterface) obj));
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return getCachedPriorityList().size();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return getCachedPriorityList().toArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((SimplePriorityList<E>) ((PriorityInterface) obj));
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) getCachedPriorityList().toArray(tArr);
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        PriorityInterface priorityInterface = (PriorityInterface) obj;
        if (checkPriority(priorityInterface)) {
            this.lock.writeLock().lock();
            boolean remove = this.list[priorityInterface.getPriority()].remove(priorityInterface);
            this.cachedPriorityList.clear();
            this.lock.writeLock().unlock();
            return remove;
        }
        return false;
    }

    public boolean add(E e) {
        if (checkPriority(e)) {
            this.lock.writeLock().lock();
            boolean add = this.list[e.getPriority()].add(e);
            this.cachedPriorityList.clear();
            this.lock.writeLock().unlock();
            return add;
        }
        return false;
    }
}
