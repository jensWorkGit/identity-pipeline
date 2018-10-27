package com.joshcummings.codeplay.concurrency.throttle;

import com.joshcummings.codeplay.concurrency.Address;

import java.util.List;
import java.util.concurrent.Future;

public interface Batcher {
    Future<?> submit(List<Address> jobs);
}
