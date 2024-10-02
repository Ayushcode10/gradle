/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.artifacts.ivyservice.resolveengine.artifact;

import org.gradle.api.Describable;
import org.gradle.api.artifacts.component.ComponentIdentifier;
import org.gradle.api.internal.attributes.ImmutableAttributes;
import org.gradle.api.internal.attributes.immutable.ImmutableAttributesSchema;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents some provider of {@link ResolvedVariant} instances to select from.
 * Used to select the artifacts given a particular variant selected during graph resolution.
 */
public interface ResolvedVariantSet {
    /**
     * Returns the component identifier for the component that this set of artifacts belongs to.
     *
     * @return component identifier as described
     */
    @Nullable
    ComponentIdentifier getComponentIdentifier();

    Describable asDescribable();

    ImmutableAttributesSchema getSchema();

    /**
     * The variants available for artifact selection.
     */
    List<ResolvedVariant> getVariants();

    /**
     * The provider may have been selected thanks to a different attribute set than the one from
     * the consuming configuration. This can happen whenever a dependency has additional attributes,
     * in which case it may override attributes from the configuration itself.
     *
     * @return attributes which will override the consumer attributes
     */
    ImmutableAttributes getOverriddenAttributes();
}
