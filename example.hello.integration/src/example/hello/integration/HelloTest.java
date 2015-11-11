package example.hello.integration;

import org.knowhowlab.osgi.testing.assertions.ServiceAssert;
import org.knowhowlab.osgi.testing.utils.ServiceUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import example.hello.api.HelloService;
import junit.framework.TestCase;

public class HelloTest extends TestCase {
	private final BundleContext m_Context = FrameworkUtil.getBundle(
			this.getClass()).getBundleContext();

	@Override
	protected void setUp() throws Exception {
		ServiceAssert.assertServiceAvailable(HelloService.class, 1000);
	}

	public void testHelloWorld() throws Exception {
		HelloService service = ServiceUtils.getService(m_Context,
				HelloService.class);
		service.helloWorld();
	}
}
