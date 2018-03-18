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

import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty

class AsciidoctorExtension {

    private final DirectoryProperty sourceDir

    AsciidoctorExtension(Project project) {
        // Initialize fields
        sourceDir = project.layout.directoryProperty()
        // Set default values
        sourceDir.set(new File('src/docs/asciidoc'))
    }

    DirectoryProperty getSourceDir() {
        sourceDir
    }

    void setSourceDir(File sourceDir) {
        this.sourceDir.set(sourceDir)
    }

    void setSourceDir(String sourceDir) {
        setSourceDir(new File(sourceDir))
    }

    void setSourceDir(Object sourceDir) {
        setSourceDir(sourceDir as String)
    }
}
