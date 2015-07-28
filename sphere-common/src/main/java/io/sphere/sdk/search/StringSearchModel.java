package io.sphere.sdk.search;

import javax.annotation.Nullable;

public class StringSearchModel<T, S extends SearchSortDirection> extends SearchModelImpl<T> implements TermModel<T, String>, SearchSortingModel<T, S> {

    public StringSearchModel(@Nullable final SearchModel<T> parent, final String pathSegment) {
        super(parent, pathSegment);
    }

    @Override
    public FilterSearchModel<T, String> filterBy() {
        return new FilterSearchModel<>(this, null, TypeSerializer.ofText());
    }

    @Override
    public FacetSearchModel<T, String> facetOf() {
        return new FacetSearchModel<>(this, null, TypeSerializer.ofText());
    }

    @Override
    public SearchSort<T> sort(S sortDirection) {
        return new SphereSearchSort<>(this, sortDirection);
    }
}