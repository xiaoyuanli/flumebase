// (c) Copyright 2010 Odiago, Inc.

package com.odiago.rtengine.exec.local;

import java.io.IOException;

import com.cloudera.flume.core.Event;

import com.odiago.rtengine.exec.FlowElement;

/**
 * Context for a FlowElement which has a single downstream FE on the
 * same physical host. An event emitted by the upstream FE is immediately
 * consumed by the downstream FE with no intermediate buffering.
 */
public class DirectCoupledFlowElemContext extends LocalContext {

  /** The downstream element where we sent events. */
  private FlowElement mDownstream;

  public DirectCoupledFlowElemContext(FlowElement downstream) {
    mDownstream = downstream;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void emit(Event e) throws IOException, InterruptedException {
    post(mDownstream, e);
  }

  /**
   * Return the downstream FlowElement. Used by the LocalEnvironment.
   */
  FlowElement getDownstream() {
    return mDownstream;
  }
}