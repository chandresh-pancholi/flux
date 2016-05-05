/*
 * Copyright 2012-2016, the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flipkart.flux.commons.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorkflowStateSummaryTest {

    private String stateSummary = "{\"stateSummaries\":[{\"summary\":{\"state2\":{\"version\":\"1\",\"count\":9},\"state1\":{\"version\":\"0\",\"count\":12}}},{\"summary\":{\"state2\":{\"version\":\"1\",\"count\":19},\"state1\":{\"version\":\"0\",\"count\":13}}}]}\n";
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void shouldParseProperly() throws Exception {
        WorkflowStateSummary workFlowStateSummary = objectMapper.readValue(stateSummary, WorkflowStateSummary.class);
        assertThat(workFlowStateSummary.getStateSummaries().get(0).getSummary().get("state2").getCount(), is(9));
    }

}
