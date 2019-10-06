/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import GuiStates.Resources;

/**
 *
 * @author morei
 */
public class Som {

    private AudioClip som;
    
    public Som(String pathnameRelativo) {
      
        URL url = Resources.getResourceFile(pathnameRelativo);
        if (url != null) {
            som = Applet.newAudioClip(url);
        }
            
    }
    public boolean iniciar(boolean on) {
        if (som != null) {
            som.stop();
            som.play();
            on = true;
        }
        return on;
    }
    public boolean play(boolean on) {
        if (som != null && on == false) {
            som.play();
            on = true; }      return on;
    }
    public boolean stop(boolean on) {
        if (som != null) {
            som.stop();
            on = false;
        }
        return on;
    }
    
    public void button(){
        if(som != null)
            som.play();
    }

    public boolean loop(boolean on) {
        if (som != null && on == false) {
            som.loop();
            on = true;
        }
        return on;
    }
}
