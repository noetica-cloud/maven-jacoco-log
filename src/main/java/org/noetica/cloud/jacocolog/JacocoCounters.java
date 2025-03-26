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

import java.util.EnumMap;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.analysis.ICounter;
import org.jacoco.core.analysis.ICoverageNode.CounterEntity;

public class JacocoCounters {

    private EnumMap<CounterEntity, Double> counters = new EnumMap<CounterEntity, Double>(CounterEntity.class);

    private JacocoCounters() {
    }

    public static JacocoCounters of(IBundleCoverage bundle) {
        // Extract counters
        JacocoCounters counters = new JacocoCounters();
        counters.counters.put(CounterEntity.CLASS, build(bundle.getInstructionCounter()));
        counters.counters.put(CounterEntity.METHOD, build(bundle.getMethodCounter()));
        counters.counters.put(CounterEntity.BRANCH, build(bundle.getBranchCounter()));
        counters.counters.put(CounterEntity.LINE, build(bundle.getLineCounter()));
        counters.counters.put(CounterEntity.INSTRUCTION, build(bundle.getInstructionCounter()));
        counters.counters.put(CounterEntity.COMPLEXITY, build(bundle.getComplexityCounter()));
        return counters;
    }

    private static Double build(ICounter counter) {
        // prevent not a number issue
        if (counter.getTotalCount() <= 0) {
            return 0.0;
        }
        return counter.getCoveredRatio() * 100;
    }

    public EnumMap<CounterEntity, Double> getCounters() {
        return counters;
    }
}
