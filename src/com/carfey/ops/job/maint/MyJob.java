package com.carfey.ops.job.maint;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import com.carfey.jdk.log.Logger;
import com.carfey.ops.job.Context;
import com.carfey.ops.job.SchedulableJob;
import com.carfey.ops.job.param.Description;


@Description("This is the wrapper to run a Clojure job, look at clojob.core.clj")
public class MyJob implements SchedulableJob {
    private static final Logger LOGGER = Logger.get();

    @Override
    public void execute(Context context) throws Exception {
        try {
            LOGGER.debug("Start: " + getClass().getSimpleName());
            IFn require = Clojure.var("clojure.core", "require");
            require.invoke(Clojure.read("clojob.core"));

            IFn hello = Clojure.var("clojob.core", "hello");
            hello.invoke("mario");
        } finally {
            LOGGER.debug("End: " + getClass().getSimpleName());
        }
    }

}