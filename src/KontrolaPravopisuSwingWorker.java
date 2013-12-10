
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class KontrolaPravopisuSwingWorker extends SwingWorker<Object, String>{
    private KontrolovacPravopisu kontrolovacPravopisu = 
            new KontrolovacPravopisu();
    
    private JTextArea textovePole;
    private JLabel label;

    public KontrolaPravopisuSwingWorker(JTextArea textovePole, JLabel label) {
        this.textovePole = textovePole;
        this.label = label;
    }
    
    @Override
    protected String doInBackground() throws Exception {
        while(true) {
            System.out.println("Kontrola pravopisu bezi...");
            String text = textovePole.getText();
            if(kontrolovacPravopisu.skontroluj(text)) {
                publish("OK");
            } else {
                publish("Chyba");
            }
            
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Override
    protected void process(List<String> chunks) {
        String stav = chunks.get(chunks.size() - 1);
        label.setText(stav);
    }
    
    

}
