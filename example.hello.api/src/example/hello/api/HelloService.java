package example.hello.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface HelloService {

	void helloWorld();

}
