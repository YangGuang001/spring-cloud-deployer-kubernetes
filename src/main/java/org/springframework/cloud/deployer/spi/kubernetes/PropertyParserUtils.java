/*
 * Copyright 2018 the original author or authors.
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

package org.springframework.cloud.deployer.spi.kubernetes;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

/**
 * Utility methods for formatting and parsing common properties
 *
 * @author Chris Schaefer
 */
public class PropertyParserUtils {
	/**
	 * Extracts annotations from the provided value
	 *
	 * @param annotation The deployment request annotations
	 * @return {@link Map} of annotations
	 */
	public static Map<String, String> getAnnotations(String annotation) {
		Map<String, String> annotations = new HashMap<>();

		if (StringUtils.hasText(annotation)) {
			String[] annotationPairs = annotation.split(",");
			for (String annotationPair : annotationPairs) {
				String[] splitAnnotation = annotationPair.split(":");
				Assert.isTrue(splitAnnotation.length == 2, format("Invalid annotation value: %s", annotationPair));
				annotations.put(splitAnnotation[0].trim(), splitAnnotation[1].trim());
			}
		}

		return annotations;
	}
}
