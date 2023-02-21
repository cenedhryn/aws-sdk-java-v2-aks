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

package software.amazon.awssdk.enhanced.dynamodb.converters.document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import software.amazon.awssdk.core.SdkBytes;

public class CustomClassForDocumentAPI {

    @Override
    public String toString() {
        return "CustomClassForDocumentAPI{" +
               "string='" + string + '\'' +
               ", stringSet=" + stringSet +
               ", binary=" + binary +
               ", binarySet=" + binarySet +
               ", aBoolean=" + aBoolean +
               ", booleanSet=" + booleanSet +
               ", longNumber=" + longNumber +
               ", longSet=" + longSet +
               ", bigDecimal=" + bigDecimal +
               ", bigDecimalSet=" + bigDecimalSet +
               ", customClassForDocumentAPIList=" + customClassForDocumentAPIList +
               ", instantList=" + instantList +
               ", customClassMap=" + customClassMap +
               ", innerCustomClassForDocumentAPI=" + innerCustomClassForDocumentAPI +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomClassForDocumentAPI that = (CustomClassForDocumentAPI) o;

        if (aBoolean != that.aBoolean) {
            return false;
        }
        if (!Objects.equals(string, that.string)) {
            return false;
        }
        if (!Objects.equals(stringSet, that.stringSet)) {
            return false;
        }
        if (!Objects.equals(binary, that.binary)) {
            return false;
        }
        if (!Objects.equals(binarySet, that.binarySet)) {
            return false;
        }
        if (!Objects.equals(booleanSet, that.booleanSet)) {
            return false;
        }
        if (!Objects.equals(longNumber, that.longNumber)) {
            return false;
        }
        if (!Objects.equals(longSet, that.longSet)) {
            return false;
        }
        if (!Objects.equals(bigDecimal, that.bigDecimal)) {
            return false;
        }
        if (!Objects.equals(bigDecimalSet, that.bigDecimalSet)) {
            return false;
        }
        if (!Objects.equals(customClassForDocumentAPIList, that.customClassForDocumentAPIList)) {
            return false;
        }
        if (!Objects.equals(instantList, that.instantList)) {
            return false;
        }
        if (!Objects.equals(customClassMap, that.customClassMap)) {
            return false;
        }
        return Objects.equals(innerCustomClassForDocumentAPI, that.innerCustomClassForDocumentAPI);
    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (stringSet != null ? stringSet.hashCode() : 0);
        result = 31 * result + (binary != null ? binary.hashCode() : 0);
        result = 31 * result + (binarySet != null ? binarySet.hashCode() : 0);
        result = 31 * result + (aBoolean ? 1 : 0);
        result = 31 * result + (booleanSet != null ? booleanSet.hashCode() : 0);
        result = 31 * result + (longNumber != null ? longNumber.hashCode() : 0);
        result = 31 * result + (longSet != null ? longSet.hashCode() : 0);
        result = 31 * result + (bigDecimal != null ? bigDecimal.hashCode() : 0);
        result = 31 * result + (bigDecimalSet != null ? bigDecimalSet.hashCode() : 0);
        result = 31 * result + (customClassForDocumentAPIList != null ? customClassForDocumentAPIList.hashCode() : 0);
        result = 31 * result + (instantList != null ? instantList.hashCode() : 0);
        result = 31 * result + (customClassMap != null ? customClassMap.hashCode() : 0);
        result = 31 * result + (innerCustomClassForDocumentAPI != null ? innerCustomClassForDocumentAPI.hashCode() : 0);
        return result;
    }

    public String string() {
        return string;
    }

    public Set<String> stringSet() {
        return stringSet;
    }

    public SdkBytes binary() {
        return binary;
    }

    public Set<byte[]> binarySet() {
        return binarySet;
    }

    public boolean aBoolean() {
        return aBoolean;
    }

    public Set<Boolean> booleanSet() {
        return booleanSet;
    }

    public Long longNumber() {
        return longNumber;
    }

    public Set<Long> longSet() {
        return longSet;
    }

    public BigDecimal bigDecimal() {
        return bigDecimal;
    }

    public Set<BigDecimal> bigDecimalSet() {
        return bigDecimalSet;
    }

    public List<CustomClassForDocumentAPI> customClassList() {
        return customClassForDocumentAPIList;
    }

    public List<Instant> instantList() {
        return instantList;
    }

    public Map<String, CustomClassForDocumentAPI> customClassMap() {
        return customClassMap;
    }

    public CustomClassForDocumentAPI innerCustomClass() {
        return innerCustomClassForDocumentAPI;
    }

    private final String string;
    private final Set<String> stringSet;
    private final SdkBytes binary;
    private final Set<byte[]> binarySet;
    private final boolean aBoolean;
    private final Set<Boolean> booleanSet;
    private final Long longNumber;
    private final Set<Long> longSet;
    private final BigDecimal bigDecimal;
    private final Set<BigDecimal> bigDecimalSet;
    private final List<CustomClassForDocumentAPI> customClassForDocumentAPIList;
    private final List<Instant> instantList;
    private final Map<String, CustomClassForDocumentAPI> customClassMap;
    private final CustomClassForDocumentAPI innerCustomClassForDocumentAPI;

    public static Builder builder(){
        return new Builder();
    }

    public CustomClassForDocumentAPI(Builder builder) {
        this.string = builder.string;
        this.stringSet = builder.stringSet;
        this.binary = builder.binary;
        this.binarySet = builder.binarySet;
        this.aBoolean = builder.aBoolean;
        this.booleanSet = builder.booleanSet;
        this.longNumber = builder.longNumber;
        this.longSet = builder.longSet;
        this.bigDecimal = builder.bigDecimal;
        this.bigDecimalSet = builder.bigDecimalSet;
        this.customClassForDocumentAPIList = builder.customClassForDocumentAPIList;
        this.instantList = builder.instantList;
        this.customClassMap = builder.customClassMap;
        this.innerCustomClassForDocumentAPI = builder.innerCustomClassForDocumentAPI;
    }

    public static final class Builder {
        private String string;
        private Set<String> stringSet;
        private SdkBytes binary;
        private Set<byte []> binarySet;
        private boolean aBoolean;
        private Set<Boolean> booleanSet;
        private Long longNumber;
        private Set<Long> longSet;
        private BigDecimal bigDecimal;
        private Set<BigDecimal> bigDecimalSet;
        private List<CustomClassForDocumentAPI> customClassForDocumentAPIList;
        private List<Instant> instantList;
        private Map<String, CustomClassForDocumentAPI> customClassMap;
        private CustomClassForDocumentAPI innerCustomClassForDocumentAPI;

        private Builder() {
        }


        public Builder string(String string) {
            this.string = string;
            return this;
        }

        public Builder stringSet(Set<String> stringSet) {
            this.stringSet = stringSet;
            return this;
        }

        public Builder binary(SdkBytes binary) {
            this.binary = binary;
            return this;
        }

        public Builder binarySet(Set<byte[]> binarySet) {
            this.binarySet = binarySet;
            return this;
        }

        public Builder aBoolean(boolean aBoolean) {
            this.aBoolean = aBoolean;
            return this;
        }

        public Builder booleanSet(Set<Boolean> booleanSet) {
            this.booleanSet = booleanSet;
            return this;
        }

        public Builder longNumber(Long longNumber) {
            this.longNumber = longNumber;
            return this;
        }

        public Builder longSet(Set<Long> longSet) {
            this.longSet = longSet;
            return this;
        }

        public Builder bigDecimal(BigDecimal bigDecimal) {
            this.bigDecimal = bigDecimal;
            return this;
        }

        public Builder bigDecimalSet(Set<BigDecimal> bigDecimalSet) {
            this.bigDecimalSet = bigDecimalSet;
            return this;
        }

        public Builder customClassList(List<CustomClassForDocumentAPI> customClassForDocumentAPIList) {
            this.customClassForDocumentAPIList = customClassForDocumentAPIList;
            return this;
        }

        public Builder instantList(List<Instant> instantList) {
            this.instantList = instantList;
            return this;
        }

        public Builder customClassMap(Map<String, CustomClassForDocumentAPI> customClassMap) {
            this.customClassMap = customClassMap;
            return this;
        }

        public Builder innerCustomClass(CustomClassForDocumentAPI innerCustomClassForDocumentAPI) {
            this.innerCustomClassForDocumentAPI = innerCustomClassForDocumentAPI;
            return this;
        }

        public CustomClassForDocumentAPI build() {
            return new CustomClassForDocumentAPI(this);
        }
    }


}
