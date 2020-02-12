package be.cegeka.datingapp.core;

abstract public class InstanceBuilder<T> {
    protected T instance;

    public InstanceBuilder() {
        this.instance = instance();
    }

    public T build() {
        return instance;
    }

    abstract protected T instance();
}
