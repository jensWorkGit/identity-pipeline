package com.joshcummings.codeplay.concurrency.throttle;

import com.joshcummings.codeplay.concurrency.Address;
import com.joshcummings.codeplay.concurrency.AddressVerifier;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * An example of implementing asynchronous batching using CyclicBarrier. {@see CyclicBarrierBatcher} for more detail.
 */
public class CyclicBarrierBatcherAddressVerifier implements AddressVerifier {
    private CyclicBarrierBatcher batcher;

    public CyclicBarrierBatcherAddressVerifier(AddressVerifier delegate, int batchSize, int timeout) {
        batcher = new CyclicBarrierBatcher(batchSize, timeout, delegate);
    }

    @Override
    public void verify(List<Address> addresses) {
        try {
            batcher.submit(addresses).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
