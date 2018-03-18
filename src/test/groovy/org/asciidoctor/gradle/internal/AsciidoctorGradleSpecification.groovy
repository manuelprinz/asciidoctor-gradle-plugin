/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.asciidoctor.gradle.internal

import groovy.transform.CompileStatic
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

/**
 * Base class for Gradle-related tests.
 *
 * This class delegates to project to provide a more fluent API in tests.
 * It also creates a temporary project folder that is reset on each test.
 *
 * @author Manuel Prinz
 */
@CompileStatic
class AsciidoctorGradleSpecification extends Specification {
    @Rule
    final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Delegate
    Project project

    void setup() {
        project = ProjectBuilder.builder().withProjectDir(testProjectDir.root).build()
    }
}
