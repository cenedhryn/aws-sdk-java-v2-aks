/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute;
import static software.amazon.awssdk.enhanced.dynamodb.mapper.AttributeMapping.SHALLOW;

import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedTypeDocumentConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.internal.DynamoDBEnhancedRequestConfiguration;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * {@link AttributeConverter} for converting nested table schemas
 */
@SdkInternalApi
public class DocumentAttributeConverter<T> implements AttributeConverter<T> {

    private final TableSchema<T> tableSchema;
    private final EnhancedType<T> enhancedType;
    private final boolean preserveEmptyObject;
    private final boolean ignoreNulls;

    private DocumentAttributeConverter(TableSchema<T> tableSchema,
                                       EnhancedType<T> enhancedType) {
        this.tableSchema = tableSchema;
        this.enhancedType = enhancedType;
        this.preserveEmptyObject = enhancedType.documentConfiguration()
                                               .map(EnhancedTypeDocumentConfiguration::preserveEmptyObject)
                                               .orElse(false);
        this.ignoreNulls = enhancedType.documentConfiguration()
                                       .map(EnhancedTypeDocumentConfiguration::ignoreNulls)
                                       .orElse(false);

    }

    public static <T> DocumentAttributeConverter<T> create(TableSchema<T> tableSchema,
                                                           EnhancedType<T> enhancedType) {
        return new DocumentAttributeConverter<>(tableSchema, enhancedType);
    }

    @Override
    public AttributeValue transformFrom(T input) {
        return AttributeValue.builder().m(tableSchema.itemToMap(input, ignoreNulls,
                                                                new DynamoDBEnhancedRequestConfiguration(SHALLOW))).build();
    }

    @Override
    public T transformTo(AttributeValue input) {
        return tableSchema.mapToItem(input.m(), preserveEmptyObject);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }

    @Override
    public EnhancedType<T> type() {
        return enhancedType;
    }
}
