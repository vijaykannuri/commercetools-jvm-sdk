package io.sphere.sdk.customobjects.queries;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sphere.sdk.customobjects.CustomObject;
import io.sphere.sdk.queries.PagedQueryResult;
import io.sphere.sdk.queries.MetaModelQueryDslBuilder;
import io.sphere.sdk.queries.MetaModelQueryDslImpl;

public class CustomObjectQueryImpl<T> extends MetaModelQueryDslImpl<CustomObject<T>, CustomObjectQuery<T>, CustomObjectQueryModel<CustomObject<T>>, Void> implements CustomObjectQuery<T> {
    CustomObjectQueryImpl(final TypeReference<PagedQueryResult<CustomObject<T>>> resultTypeReference){
        super(CustomObjectEndpoint.PATH, resultTypeReference, CustomObjectQueryModel.of(), null, b -> new CustomObjectQueryImpl<>(b));
    }

    private CustomObjectQueryImpl(final MetaModelQueryDslBuilder<CustomObject<T>, CustomObjectQuery<T>, CustomObjectQueryModel<CustomObject<T>>, Void> builder) {
        super(builder);
    }
}