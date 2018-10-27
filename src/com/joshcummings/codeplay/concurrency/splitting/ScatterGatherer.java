package com.joshcummings.codeplay.concurrency.splitting;

import com.joshcummings.codeplay.concurrency.Identity;

import java.util.concurrent.Callable;

/**
 * A scatter-gather contract.
 */
public interface ScatterGatherer {
    public Identity go(Scatterer s, Gatherer g);

    public interface Scatterer {
        boolean hasNext();

        Callable<Identity> next();
    }

    public interface Gatherer {
        boolean needsMore();

        void gatherResult(Identity i);

        Identity getFinalResult();
    }
}