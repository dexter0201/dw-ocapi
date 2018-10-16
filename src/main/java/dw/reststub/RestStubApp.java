package dw.reststub;

import dw.reststub.resources.PersonService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RestStubApp extends Application<RestStubConfig> {
    public static void main(String[] args) throws Exception {
        new RestStubApp().run(args);
    }

    @Override
    public void run(RestStubConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        env.healthChecks().register("template",
                new RestStubCheck(config.getVersion()));
    }
}
