package org.noetica.cloud.jacocolog;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;

@Named("jacocolog")
@Singleton
public class JacocoLogListener extends AbstractMavenLifecycleParticipant {
    @Override
    public void afterProjectsRead(MavenSession session)
    {
        // default does nothing
    }
}
