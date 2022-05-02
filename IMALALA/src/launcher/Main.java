package launcher;
//import Usuario;

import javax.swing.SwingUtilities;

import view.PanelBienvenida;



public class Main {

        public static void main(String[] args) {

                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                
                                PanelBienvenida bienvenida = new PanelBienvenida();
                             

                        }
                });

        }

        

}
