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
package org.asciidoctor.gradle

import org.asciidoctor.gradle.internal.AsciidoctorGradleSpecification
import org.gradle.api.Task
import spock.lang.Title

/**
 * Asciidoctor extension specification.
 *
 * @author Manuel Prinz
 */
@Title('Tests for the Asciidoctor Extension')
class AsciidoctorExtensionSpec extends AsciidoctorGradleSpecification {

    void 'source directory defaults to "src/docs/asciidoc"'() {
        when:
        configure(project) {
            apply plugin: 'org.asciidoctor.convert'

            evaluate()
        }
        Task task = asciidoctorTask

        then:
        sourceDirOf(task) == fullPathTo('src/docs/asciidoc')
    }

    void 'source directory can be set as file'() {
        when:
        def changedSourceDir = 'src/docs'
        configure(project) {
            apply plugin: 'org.asciidoctor.convert'

            asciidoctor {
                sourceDir = file(changedSourceDir)
            }
            evaluate()
        }
        Task task = asciidoctorTask

        then:
        sourceDirOf(task) == fullPathTo(changedSourceDir)
    }

    void 'source directory can be set as string'() {
        when:
        def changedSourceDir = 'src/docs'
        configure(project) {
            apply plugin: 'org.asciidoctor.convert'

            asciidoctor {
                sourceDir = changedSourceDir
            }
            evaluate()
        }
        Task task = asciidoctorTask

        then:
        sourceDirOf(task) == fullPathTo(changedSourceDir)
    }

    void 'source directory can be set as GString'() {
        when:
        GString changedSourceDir = "src/${"docs"}"
        configure(project) {
            apply plugin: 'org.asciidoctor.convert'

            asciidoctor {
                sourceDir = changedSourceDir
            }
            evaluate()
        }
        Task task = asciidoctorTask

        then:
        sourceDirOf(task) == fullPathTo(changedSourceDir)
    }

    private AsciidoctorTask getAsciidoctorTask() {
        tasks.getByName('asciidoctor') as AsciidoctorTask
    }

    private static File sourceDirOf(Task task) {
        task.property('sourceDir').getAsFile().get()
    }

    private File fullPathTo(String directory) {
        new File(layout.projectDirectory.getAsFile(), directory)
    }
}
