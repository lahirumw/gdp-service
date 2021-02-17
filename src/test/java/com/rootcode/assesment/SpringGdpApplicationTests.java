package com.rootcode.assesment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rootcode.assesment.controller.GdpControllerTest;
import com.rootcode.assesment.interceptor.AccessLogInterceptorTest;

/**
 * Test Suite
 * 
 * @author lahirua
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ GdpControllerTest.class, AccessLogInterceptorTest.class})
class SpringGdpApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringGdpApplicationTests.class);

    @BeforeClass
    public static void startup() {
	LOGGER.info("UNIT TEST STARTING UP");
    }

    @AfterClass
    public static void tearDown() {
	LOGGER.info("UNIT TEST COMPLETION");
    }

}
