package by.arhor.context;

import org.junit.Test;

public class ContextImplTest {

    @Test
    public void testContext() {
        try (Context ctx = ContextFactory.getContext(TestConfig.class)) {
            String bean = ctx.getBean(String.class);
            System.out.println(bean);
        }
    }

}
