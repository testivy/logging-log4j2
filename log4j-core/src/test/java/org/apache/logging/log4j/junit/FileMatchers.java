/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.junit;

import java.io.File;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;

/**
 * Hamcrest Matchers that operate on File objects.
 *
 * @since 2.1
 */
public class FileMatchers {

    /**
     * Returns a File Matcher that matches if the File exists.
     */
    public static Matcher<File> exists() {
        return new FeatureMatcher<File, Boolean>(Is.is(true), "file exists", "file exists") {
            @Override
            protected Boolean featureValueOf(final File actual) {
                return actual.exists();
            }
        };
    }

    /**
     * Returns a File Matcher that matches a Long Matcher against the file length.
     *
     * @param matcher the Matcher to use on the File length.
     */
    public static Matcher<File> hasLength(final Matcher<Long> matcher) {
        return new FeatureMatcher<File, Long>(matcher, "file with size", "file with size") {
            @Override
            protected Long featureValueOf(final File actual) {
                return actual.length();
            }
        };
    }

}
