package interfaces;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GerenteDeJanelas {
    private static JDesktopPane jDesktopPane;
    
    public GerenteDeJanelas (JDesktopPane jDesktopPane){
        GerenteDeJanelas.jDesktopPane = jDesktopPane;
    }
    
    public void abrirJanelas(JInternalFrame jInternalFrame){
        if (jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            jInternalFrame.setLocation(
                jInternalFrame.getWidth()/2 - jInternalFrame.getWidth()/2,
                jInternalFrame.getHeight()/2 - jInternalFrame.getHeight()/2
            );
        
        }
    }
}
