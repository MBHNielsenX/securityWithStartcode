package dat3.experiments;

import org.apache.logging.log4j.util.Strings;

//Never use anything in here for real
public class SimpleSanitizer {
    public static void main(String[] args) {
        simpleSanitize("hej mit navn er mads <b>hej<b> hej hej" );
    }
    public static String simpleSanitize(String s){

        return s;
    }
}

