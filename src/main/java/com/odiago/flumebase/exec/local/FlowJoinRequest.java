// (c) Copyright 2010 Odiago, Inc.

package com.odiago.flumebase.exec.local;

import com.odiago.flumebase.exec.FlowId;

import com.odiago.flumebase.util.Ref;

/**
 * Datum payload sent with a LocalEnvironment.ControlOp.Join request.
 */
public class FlowJoinRequest {
  /** What flow to join on. */
  private final FlowId mFlowId;

  /** What object to notify when this flow is done. */
  private final Ref<Boolean> mJoinObj;

  public FlowJoinRequest(FlowId flowId, Ref<Boolean> joinObj) {
    mFlowId = flowId;
    mJoinObj = joinObj;
  }

  public FlowId getFlowId() {
    return mFlowId;
  }

  public Ref<Boolean> getJoinObj() {
    return mJoinObj;
  }
}