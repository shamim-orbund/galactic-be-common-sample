package com.orbund.galactic.be.common.sample.api;

public abstract class ApiProvider {

    public static class SampleApi {
        public static final String ROOT_PATH = ApiConstants.BASE_PATH + "/" + ApiConstants.SAMPLES;
        public static final String SAMPLE_IDENTIFIER = "/" + "{" + ApiConstants.SAMPLE_ID + "}";
    }

}
