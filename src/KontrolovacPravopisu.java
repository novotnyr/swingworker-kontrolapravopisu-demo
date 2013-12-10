
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KontrolovacPravopisu {
    private List<String> databazaSlov = 
            Arrays.asList("vysací", 
                    "bycikel", 
                    "visokí", 
                    "mnýsi",
                    "céra",
                    "oťec",
                    "fták",
                    "fčela",
                    "odca",
                    "vtákou",
                    "problémou"
                    );
    
    public boolean skontroluj(String text) {
        Scanner scanner = new Scanner(text);
        while(scanner.hasNext()) {
            String slovo = scanner.next();
            slovo = osetriNepismenoveZnaky(slovo);
            if(!skontrolujSlovo(slovo)) {
                return false;
            }
        }
        return true;
    }

    private String osetriNepismenoveZnaky(String slovo) {
        return slovo.replaceAll("[,;\\.]", "");
    }

    private boolean skontrolujSlovo(String slovo) {
        return !databazaSlov.contains(slovo);
    }
}
