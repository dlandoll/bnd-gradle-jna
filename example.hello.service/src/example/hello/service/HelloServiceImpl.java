package example.hello.service;

import org.osgi.service.component.annotations.*;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import example.hello.api.HelloService;

@Component
public class HelloServiceImpl implements HelloService {

	public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
            Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                               CLibrary.class);

        void printf(String format, Object... args);
    }

	@Override
	public void helloWorld() {
		CLibrary.INSTANCE.printf("Hello World!");
	}

}
