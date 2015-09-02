
package atmproject2;

import javax.swing.*;

/**
 *
 * @author Jastark
 */
public class InsufficientFunds extends Exception {

    /**
     * Creates a new instance of InsufficientFunds without detail
     * message.
     */
    public InsufficientFunds() {
    }

    /**
     * Constructs an instance of InsufficientFunds with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InsufficientFunds(String msg) {
        super(msg);
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Insufficient Funds");
    }
}
