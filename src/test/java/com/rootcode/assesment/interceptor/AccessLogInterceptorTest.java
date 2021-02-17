package com.rootcode.assesment.interceptor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rootcode.assesment.interceptor.AccessLogInterceptor;

/**
 * Test class for AccessLogInterceptor
 * 
 * @author lahirua
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccessLogInterceptorTest {

    @InjectMocks
    private AccessLogInterceptor accessLogInterceptor = new AccessLogInterceptor();

    @Test
    public void testPreHandle() throws Exception {

	boolean result = accessLogInterceptor.preHandle(new MockHttpServletRequest(), new MockHttpServletResponse(),
		new Object());
	Assert.assertEquals(true, result);
    }

    @Test
    public void testAfterCompletion() throws Exception {

	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setAttribute("startTime", new Long(2));

	Assert.assertNotNull(request);

	accessLogInterceptor.afterCompletion(request, new MockHttpServletResponse(), new Object(), new Exception());
    }

}
