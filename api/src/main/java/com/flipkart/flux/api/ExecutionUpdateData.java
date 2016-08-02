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
package com.flipkart.flux.api;

import java.io.Serializable;

/**
 * DTO class for holding Task execution updates 
 * @author regunath.balasubramanian
 */
public class ExecutionUpdateData implements Serializable {
	
	/** Default serial version UID*/
	private static final long serialVersionUID = 1L;
	
	/** Member variables*/
	private Long stateMachineId;
	private Long taskId;
	private Status status;
	private long retrycount = 0;
    private long currentRetryCount = 0;
	
	/** Constructors*/
	/* For use by Jackson for deserialization*/
	public ExecutionUpdateData() {
	}
	public ExecutionUpdateData(Long stateMachineId, Long taskId, Status status) {
		this.stateMachineId = stateMachineId;
		this.taskId = taskId;
		this.status = status;
	}
	public ExecutionUpdateData(Long stateMachineId, Long taskId, Status status, long retrycount) {
		this(stateMachineId, taskId,status);
		this.retrycount = retrycount;
	}
    public ExecutionUpdateData(Long stateMachineId, Long taskId, Status status, long retrycount, long currentRetryCount) {
        this(stateMachineId, taskId, status, retrycount);
        this.currentRetryCount = currentRetryCount;
    }

    /** Accessors*/
	public Long getStateMachineId() {
		return stateMachineId;
	}
	public Long getTaskId() {
		return taskId;
	}
	public Status getStatus() {
		return status;
	}
	public long getRetrycount() {
		return retrycount;
	}
    public long getCurrentRetryCount() {
        return currentRetryCount;
    }
}
