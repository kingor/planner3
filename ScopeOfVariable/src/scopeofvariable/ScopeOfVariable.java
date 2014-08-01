/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scopeofvariable;

/**
 *
 * @author ASUP8
 */
public class ScopeOfVariable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x;
        
        x = 10;
        if (x == 10){
            int y = 20;
            System.out.println("x и y: " + x + " " + y);
        }
        //y не виден в этой области.
        System.out.println("значение x: " + x);
    }
}
