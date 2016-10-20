package io.sphere.sdk.annotations.processors;

import java.util.LinkedList;
import java.util.List;

final class ClassModel {
    private String name;
    private String type;
    private String packageName;
    private List<String> modifiers = new LinkedList<>();
    private List<MethodModel> methods = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public List<String> getModifiers() {
        return modifiers;
    }

    public void setModifiers(final List<String> modifiers) {
        this.modifiers = modifiers;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

    public List<MethodModel> getMethods() {
        return methods;
    }

    public void setMethods(final List<MethodModel> methods) {
        this.methods = methods;
    }
}
