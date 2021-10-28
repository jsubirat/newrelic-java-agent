package com.mongodb.async.client;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.lang.Nullable;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.nr.agent.mongo.MongoUtil;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

@Weave(type = MatchType.ExactClass, originalName = "com/mongodb/async/client/DistinctIterableImpl")
abstract class DistinctIterableImpl_Instrumentation<TDocument, TResult> extends MongoIterableImpl_Instrumentation<TResult> {

    DistinctIterableImpl_Instrumentation(@Nullable final ClientSession clientSession, final MongoNamespace namespace, final Class<TDocument> documentClass,
            final Class<TResult> resultClass, final CodecRegistry codecRegistry, final ReadPreference readPreference,
            final ReadConcern readConcern, final OperationExecutor executor, final String fieldName, final Bson filter,
            final boolean retryReads) {
        super(clientSession, executor, readConcern, readPreference, retryReads);
        super.collectionName = namespace.getCollectionName() + "-" + fieldName;
        super.databaseName = namespace.getDatabaseName();
        super.operationName = MongoUtil.OP_DISTINCT;
    }
}
