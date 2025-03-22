/*
 *   Copyright (c) 2025 The maven-jacoco-log contributors
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.noetica.cloud.jacocolog;

import org.apache.maven.model.FileSet;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.plugins.annotations.LifecyclePhase;

import java.util.List;

/**
 * Goal which reads the JaCoCo report and logs coverage.
 */
@Mojo(name = "coverage", defaultPhase = LifecyclePhase.VERIFY, threadSafe = true)
public class JacocoLogMojo
        extends AbstractMojo {

    @Parameter(property = "project", readonly = true)
    private MavenProject project;

    /**
     * This mojo accepts any number of execution data file sets.
     *
     * <pre>
     * <code>
     * &lt;fileSets&gt;
     *   &lt;fileSet&gt;
     *     &lt;directory&gt;${project.build.directory}&lt;/directory&gt;
     *     &lt;includes&gt;
     *       &lt;include&gt;*.exec&lt;/include&gt;
     *     &lt;/includes&gt;
     *   &lt;/fileSet&gt;
     * &lt;/fileSets&gt;
     * </code>
     * </pre>
     */
    @Parameter
    private List<FileSet> fileSets;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("JaCoCoLog test");
    }
}
