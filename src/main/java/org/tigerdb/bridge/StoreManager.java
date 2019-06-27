package org.tigerdb.bridge;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public abstract class StoreManager<T> {

    public StoreManager(Class<T> objectsClazz, File tblFolder){}

    /**
     * Devuelve la cantidad de objetos almacenados.
     * @return Cantidad de objetos almacenados.
     */
    public abstract long getObjectsCount();

    public abstract long getSumBy(String fieldName);

    public abstract long getMaxBy(String fieldName);

    public abstract long getMinBy(String fieldName);

    public abstract double getAvgBy(String fieldName);

    public abstract void addObject(T object) throws IOException;

    public abstract void addObjectParallel(T object) throws IOException;

    public abstract void addObjectsFrom(Collection<T> list) throws IOException;

    public abstract List<T> getObjects();

    public abstract T getFirstObject();

    public abstract T getLastObject();

    public abstract T getObjectBy(int index);

    public abstract T getObjectBy(String fieldName, Object valueToFind) throws Exception;

    public abstract T getFirstBy(Predicate<? super T> predicate);

    public abstract T getLastBy(Predicate<? super T> predicate);

    public abstract List<T> getObjectsBy(Predicate<? super T> predicate);

    public abstract List<T> getObjectsBy(String fieldName, Object valueToFind) throws Exception;

    public abstract T getFirstObjectBy(String fieldName, Object valueToFind);

    public abstract void setObject(int index, T newObject) throws IOException;

    public abstract void setObjects(Predicate<? super T> predicate, T newObject) throws IOException;

    public abstract void setObjects(String fieldName, Object valueToFind, T newObject) throws Exception;

    public abstract void setObject(T oldObj, T newObj) throws IOException;

    public abstract void deleteAllObjects() throws IOException;

    public abstract void deleteObject(int index) throws IOException;

    public abstract void deleteObjectsBy(Predicate<? super T> predicate) throws IOException;

    public abstract void deleteObjectsBy(String fieldName, Object valueToFind) throws Exception;

    public abstract void deleteRecordFile();

}
