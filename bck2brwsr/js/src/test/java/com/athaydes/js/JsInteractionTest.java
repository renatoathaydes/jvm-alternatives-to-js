package com.athaydes.js;

import net.java.html.junit.BrowserRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Tests for behavior of @JavaScriptBody methods. The {@link BrowserRunner}
 * selects all possible presenters from your <code>pom.xml</code> and
 * runs the tests inside of them.
 *
 * See your <code>pom.xml</code> dependency section for details.
 */
@RunWith(BrowserRunner.class)
public class JsInteractionTest {
    @Test
    public void emptyTest() {
    }

    @Test
    public void testCallbackFromJavaScript() throws Exception {
        class R implements Runnable {
            int called;

            @Override
            public void run() {
                called++;
            }
        }
        R callback = new R();
        
        final PlatformServices services = new PlatformServices();
        services.confirmByUser("Hello", callback);
        
        assertEquals("One immediate callback", callback.called, 1);
    }
}
