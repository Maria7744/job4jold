package generator;

import java.security.KeyException;
import java.util.Map;

public interface Generator {
    String terminate(String template, Map<String, Object> args) throws KeyException;

}

